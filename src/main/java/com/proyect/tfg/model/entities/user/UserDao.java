package com.proyect.tfg.model.entities.user;

import com.proyect.tfg.model.entities.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
}
