package com.proyect.tfg.model.entities.category;

import com.proyect.tfg.model.entities.category.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryDao extends PagingAndSortingRepository<Category, Long> {}
