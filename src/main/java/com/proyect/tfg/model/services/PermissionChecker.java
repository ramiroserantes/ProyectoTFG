package com.proyect.tfg.model.services;

import com.proyect.tfg.model.exceptions.InstanceNotFoundException;

public interface PermissionChecker {

    void checkUserExists(Long userId) throws InstanceNotFoundException;

}
