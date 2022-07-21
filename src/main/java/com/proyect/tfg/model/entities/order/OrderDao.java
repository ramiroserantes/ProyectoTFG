package com.proyect.tfg.model.entities.order;

import com.proyect.tfg.model.entities.order.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderDao extends PagingAndSortingRepository<Order, Long> {}
