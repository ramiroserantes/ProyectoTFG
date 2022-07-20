package com.proyect.tfg.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    private Long id;

    private Boolean isQuantityLimited;

    private Long gameValue;
    private BigDecimal realValue;

    private String name;
    private String description;
    private BigDecimal discount;

    private Category category;

    public Product () {}

    public Product(Boolean isQuantityLimited, Long gameValue, BigDecimal realValue,
                   String name, String description, BigDecimal discount) {
        this.isQuantityLimited = isQuantityLimited;
        this.gameValue = gameValue;
        this.realValue = realValue;
        this.name = name;
        this.description = description;
        this.discount = discount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Boolean getQuantityLimited() { return isQuantityLimited; }

    public void setQuantityLimited(Boolean quantityLimited) { isQuantityLimited = quantityLimited; }

    public Long getGameValue() { return gameValue; }

    public void setGameValue(Long gameValue) { this.gameValue = gameValue; }

    public BigDecimal getRealValue() { return realValue; }

    public void setRealValue(BigDecimal realValue) { this.realValue = realValue; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getDiscount() { return discount; }

    public void setDiscount(BigDecimal discount) { this.discount = discount; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="categoryId")
    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }
}
