package org.javafeature.customerliflinevaluecalculation;

public class CustomerLifetimeValue {
    private String customerId;
    private double totalAmount;
    private double averageAmount;

    public CustomerLifetimeValue(String customerId, double totalAmount, double averageAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAverageAmount() {
        return averageAmount;
    }

    public void setAverageAmount(double averageAmount) {
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "CustomerLifetimeValue{" +
                "customerId='" + customerId + '\'' +
                ", totalAmount=" + totalAmount +
                ", averageAmount=" + averageAmount +
                '}';
    }
}
