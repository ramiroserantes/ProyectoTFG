package com.proyect.tfg.model.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {

    private Long id;

    private User user;
    private Set<ShoppingCartItem> items = new HashSet<>();

    public ShoppingCart() {};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**************************************** Relations ************************************************************/

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @OneToMany(mappedBy="shoppingCart")
    public Set<ShoppingCartItem> getItems() { return items; }

    public void setItems(Set<ShoppingCartItem> items) { this.items = items; }
}
