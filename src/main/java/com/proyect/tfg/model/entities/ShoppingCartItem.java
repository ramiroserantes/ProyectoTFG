package com.proyect.tfg.model.entities;

import javax.persistence.*;

@Entity
public class ShoppingCartItem {


    private Long id;

    private int quantity;

    private ShoppingCart shoppingCart;
    private Product product;

    public ShoppingCartItem () {}

    public ShoppingCartItem(int quantity) {
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="shoppingCartId")
    public ShoppingCart getShoppingCart() { return shoppingCart; }

    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="productId")
    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }
}
