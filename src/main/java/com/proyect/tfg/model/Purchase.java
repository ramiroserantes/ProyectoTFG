package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Purchase {

    @Id
    private Long id;

    private String productName;

    private Long premiumCoinValue;
    private BigDecimal realValue;

    private LocalDateTime purchaseDate;
    private int quantity;

    public Purchase () {}

    public Purchase(String productName, Long premiumCoinValue, BigDecimal realValue,
                    LocalDateTime purchaseDate, int quantity) {
        this.productName = productName;
        this.premiumCoinValue = premiumCoinValue;
        this.realValue = realValue;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
    }

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
}
