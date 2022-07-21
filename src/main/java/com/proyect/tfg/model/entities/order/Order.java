package com.proyect.tfg.model.entities.order;

import com.proyect.tfg.model.entities.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OrderTable")
public class Order {

    public enum Status {ACTIVE, CANCELED, EXPIRED};
    public enum OrderType {SELLPLATINUM, BUYPLATINUM};

    private Long id;

    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    private int requiredAmount;
    private int adquiredAmount;
    private int pricePerUnit;

    private Status status;
    private OrderType orderType;

    private Set<Transaction> transactions = new HashSet<>();

    private User user;

    public Order () {}

    public Order(User user, LocalDateTime creationDate,
                 LocalDateTime expirationDate, int requiredAmount, int adquiredAmount,
                 int pricePerUnit, Status status, OrderType orderType) {
        this.user = user;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.requiredAmount = requiredAmount;
        this.adquiredAmount = adquiredAmount;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
        this.orderType = orderType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getPricePerUnit() { return pricePerUnit; }

    public void setPricePerUnit(int pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public OrderType getOrderType() { return orderType; }

    public void setOrderType(OrderType orderType) { this.orderType = orderType; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @OneToMany(mappedBy = "order")
    public Set<Transaction> getTransactions() { return transactions; }

    public void setTransactions(Set<Transaction> transactions) { this.transactions = transactions; }
}
