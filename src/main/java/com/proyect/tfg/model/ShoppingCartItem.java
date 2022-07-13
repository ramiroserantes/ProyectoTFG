package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingCartItem {

    @Id
    private Long id;

    private int quantity;
}
