package com.proyect.tfg.model.entities.order;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderDao extends PagingAndSortingRepository<Order, Long> {

    Slice<Order> findByUserIdOrderByCreationDateAscStatusAscOrderTypeAsc(Long userId, Pageable page);

}
