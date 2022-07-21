package com.proyect.tfg.model.services;

import com.proyect.tfg.model.entities.order.Order;
import com.proyect.tfg.model.entities.order.OrderDao;
import com.proyect.tfg.model.exceptions.InstanceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PermissionChecker permissionChecker;

    @Override
    public Block<Order> findOrdersByUser(Long userId, int page, int size) throws InstanceNotFoundException {

        permissionChecker.checkUserExists(userId);

        Slice<Order> slice = orderDao.findByUserIdOrderByCreationDateAscStatusAscOrderTypeAsc(userId,
                PageRequest.of(page, size));

        List<Order> orders = slice.getContent();

        for (Order o : orders) {
            if(o.getExpirationDate().isBefore(LocalDateTime.now()) && (o.getStatus() == Order.Status.ACTIVE)) {
                o.setStatus(Order.Status.EXPIRED);
            }
        }

        return new Block<>(orders, slice.hasNext());
    }
}
