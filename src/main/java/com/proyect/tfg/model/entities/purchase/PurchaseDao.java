package com.proyect.tfg.model.entities.purchase;

import com.proyect.tfg.model.entities.purchase.Purchase;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PurchaseDao extends PagingAndSortingRepository<Purchase, Long> {}
