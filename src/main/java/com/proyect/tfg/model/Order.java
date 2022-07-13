package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Order {

    public enum Status {ACTIVE, CANCELED, EXPIRED};
    public enum OrderType {SELLPLATINUM, BUYPLATINUM};

    @Id
    private Long id;

    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    private int requiredAmount;
    private int adquiredAmount;
    private Long pricePerUnit;

    private Status status;
    private OrderType orderType;

    public Order () {}

    public Order(LocalDateTime creationDate,
                 LocalDateTime expirationDate, int requiredAmount, int adquiredAmount,
                 Long pricePerUnit, Status status, OrderType orderType) {
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.requiredAmount = requiredAmount;
        this.adquiredAmount = adquiredAmount;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
        this.orderType = orderType;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LocalDateTime getCreationDate() { return creationDate; }

    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    public LocalDateTime getExpirationDate() { return expirationDate; }

    public void setExpirationDate(LocalDateTime expirationDate) { this.expirationDate = expirationDate; }

    public int getRequiredAmount() { return requiredAmount; }

    public void setRequiredAmount(int requiredAmount) { this.requiredAmount = requiredAmount; }

    public int getAdquiredAmount() { return adquiredAmount; }

    public void setAdquiredAmount(int adquiredAmount) { this.adquiredAmount = adquiredAmount; }

    public Long getPricePerUnit() { return pricePerUnit; }

    public void setPricePerUnit(Long pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public OrderType getOrderType() { return orderType; }

    public void setOrderType(OrderType orderType) { this.orderType = orderType; }

}
