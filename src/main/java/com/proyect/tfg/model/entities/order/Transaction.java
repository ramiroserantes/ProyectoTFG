package com.proyect.tfg.model.entities.order;

import com.proyect.tfg.model.entities.order.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TransactionTable")
public class Transaction implements Serializable {

    @Id
    private LocalDateTime dateOfTransaction;
    private int transactionValue;
    private int transactionAmount;

    private Order order;

    public Transaction () {}

    public Transaction(Order order, LocalDateTime dateOfTransaction, int transactionValue, int transactionAmount) {
        this.order = order;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionValue = transactionValue;
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getDateOfTransaction() { return dateOfTransaction; }

    public void setDateOfTransaction(LocalDateTime dateOfTransaction) { this.dateOfTransaction = dateOfTransaction; }

    public int getTransactionValue() { return transactionValue; }

    public void setTransactionValue(int transactionValue) { this.transactionValue = transactionValue; }

    public int getTransactionAmount() { return transactionAmount; }

    public void setTransactionAmount(int transactionAmount) { this.transactionAmount = transactionAmount; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name = "orderId")
    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }
}
