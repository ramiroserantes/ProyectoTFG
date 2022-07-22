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

        /** Comprobamos los datos de entrada **/

        permissionChecker.checkUserExists(userId);

        /** Comprobamos si el usuario tiene ordenes expiradas y en ese caso las actualizamos (no es necesario hacer un update por
         * la first-level cache de spring) **/

        List<Order> updateOrders = orderDao.findByUserIdAndStatusAndExpirationDateBefore(userId,
                Order.Status.ACTIVE, LocalDateTime.now());

        if(!updateOrders.isEmpty()) {
            for (Order o: updateOrders) {
                o.setStatus(Order.Status.EXPIRED);
            }
        }

        /** Ahora que ya sabemos que todas las ordenes están actualizadas en su estado correcamente las buscamos paginadas **/

        Slice<Order> slice = orderDao.findOrdersByUser(userId,
                PageRequest.of(page, size));

        return new Block<>(slice.getContent(), slice.hasNext());
    }
}
