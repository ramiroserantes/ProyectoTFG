package com.proyect.tfg.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TransactionTable")
public class Transaction {

    @Id
    private LocalDateTime dateOfTransaction;
    private int transactionValue;
    private int transactedAmount;

    private Order order;

    public Transaction () {}

    public Transaction(LocalDateTime dateOfTransaction, int transactionValue, int transactedAmount) {
        this.dateOfTransaction = dateOfTransaction;
        this.transactionValue = transactionValue;
        this.transactedAmount = transactedAmount;
    }

    public LocalDateTime getDateOfTransaction() { return dateOfTransaction; }

    public void setDateOfTransaction(LocalDateTime dateOfTransaction) { this.dateOfTransaction = dateOfTransaction; }

    public int getTransactionValue() { return transactionValue; }

    public void setTransactionValue(int transactionValue) { this.transactionValue = transactionValue; }

    public int getTransactedAmount() { return transactedAmount; }

    public void setTransactedAmount(int transactedAmount) { this.transactedAmount = transactedAmount; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }
}
