package com.proyect.tfg.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Purchase {

    private Long id;

    private String productName;

    private Long premiumCoinValue;
    private BigDecimal realValue;

    private LocalDateTime purchaseDate;
    private Product product;
    private int quantity;

    private User user;

    public Purchase () {}

    public Purchase(String productName, Long premiumCoinValue, BigDecimal realValue,
                    LocalDateTime purchaseDate, int quantity) {
        this.productName = productName;
        this.premiumCoinValue = premiumCoinValue;
        this.realValue = realValue;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public Long getPremiumCoinValue() { return premiumCoinValue; }

    public void setPremiumCoinValue(Long premiumCoinValue) { this.premiumCoinValue = premiumCoinValue; }

    public BigDecimal getRealValue() { return realValue; }

    public void setRealValue(BigDecimal realValue) { this.realValue = realValue; }

    public LocalDateTime getPurchaseDate() { return purchaseDate; }

    public void setPurchaseDate(LocalDateTime purchaseDate) { this.purchaseDate = purchaseDate; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="productId")
    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }
}
