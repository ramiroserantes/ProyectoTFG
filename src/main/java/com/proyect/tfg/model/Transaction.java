package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    private LocalDateTime dateOfTransaction;
    private Long transactionValue;
    private Long transactedAmount;

    public Transaction () {}

    public Transaction(LocalDateTime dateOfTransaction, Long transactionValue, Long transactedAmount) {
        this.dateOfTransaction = dateOfTransaction;
        this.transactionValue = transactionValue;
        this.transactedAmount = transactedAmount;
    }

    public LocalDateTime getDateOfTransaction() { return dateOfTransaction; }

    public void setDateOfTransaction(LocalDateTime dateOfTransaction) { this.dateOfTransaction = dateOfTransaction; }

    public Long getTransactionValue() { return transactionValue; }

    public void setTransactionValue(Long transactionValue) { this.transactionValue = transactionValue; }

    public Long getTransactedAmount() { return transactedAmount; }

    public void setTransactedAmount(Long transactedAmount) { this.transactedAmount = transactedAmount; }
}
