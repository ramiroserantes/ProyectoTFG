package com.proyect.tfg.model.entities.product;

import com.proyect.tfg.model.entities.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDao extends PagingAndSortingRepository<Product, Long> {}
