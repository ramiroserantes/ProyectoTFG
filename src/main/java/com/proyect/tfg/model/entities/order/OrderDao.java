package com.proyect.tfg.model.entities.order;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDao extends PagingAndSortingRepository<Order, Long> {

    @Query(" SELECT o FROM Order o WHERE " +
            " o.user.id = ?1 " + " ORDER BY " +
            "o.status, o.orderType, o.creationDate DESC")
    Slice<Order> findOrdersByUser(Long userId, Pageable page);

    List<Order> findByUserIdAndStatusAndExpirationDateBefore(Long userId, Order.Status status, LocalDateTime date);

}
