package com.proyect.tfg.model.services;

import com.proyect.tfg.model.entities.user.UserDao;
import com.proyect.tfg.model.exceptions.InstanceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PremissionCheckerImpl implements PermissionChecker {

    @Autowired
    private UserDao userDao;

    @Override
    public void checkUserExists(Long userId) throws InstanceNotFoundException {

        if(!userDao.existsById(userId)) {
            throw new InstanceNotFoundException("project.entities.user", userId);
        }
    }

}
