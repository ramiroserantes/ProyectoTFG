package com.proyect.tfg.model.entities.product;

import com.proyect.tfg.model.entities.category.Category;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Product {

    private Long id;

    private Boolean isQuantityLimited;

    private Long gameValue;
    private BigDecimal realValue;

    private String name;
    private String description;
    private BigDecimal discount;
    private LocalDateTime disableDate;

    private Category category;

    public Product () {}

    public Product(Category category, Boolean isQuantityLimited, Long gameValue, BigDecimal realValue,
                   String name, String description, BigDecimal discount, LocalDateTime disableDate) {
        this.category = category;
        this.isQuantityLimited = isQuantityLimited;
        this.gameValue = gameValue;
        this.realValue = realValue;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.disableDate = disableDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Boolean getQuantityLimited() { return isQuantityLimited; }

    public void setQuantityLimited(Boolean quantityLimited) { this.isQuantityLimited = quantityLimited; }

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

    public LocalDateTime getDisableDate() { return disableDate; }

    public void setDisableDate(LocalDateTime disableDate) { this.disableDate = disableDate; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="categoryId")
    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }
}
