package com.proyect.tfg.model.services;

import com.proyect.tfg.model.entities.order.Order;
import com.proyect.tfg.model.exceptions.InstanceNotFoundException;

public interface AuctionService {

    Block<Order> findOrdersByUser(Long userId, int page, int size) throws InstanceNotFoundException;
}
