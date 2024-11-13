package org.javafeature.policydetection;

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private String policyId;
    private double amount;
    private LocalDate transactionDate;

    public Transaction(String transactionId, String policyId, double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.policyId = policyId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
