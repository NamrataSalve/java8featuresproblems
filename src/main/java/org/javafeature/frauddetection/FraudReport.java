package org.javafeature.frauddetection;

public class FraudReport {
    private String policyNumber;
    private int fraudulentTransactionCount;
    private double totalFraudAmount;

    public FraudReport(String policyNumber, int fraudulentTransactionCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudulentTransactionCount = fraudulentTransactionCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getFraudulentTransactionCount() {
        return fraudulentTransactionCount;
    }

    public void setFraudulentTransactionCount(int fraudulentTransactionCount) {
        this.fraudulentTransactionCount = fraudulentTransactionCount;
    }

    public double getTotalFraudAmount() {
        return totalFraudAmount;
    }

    public void setTotalFraudAmount(double totalFraudAmount) {
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "FraudReport{" +
                "policyNumber='" + policyNumber + '\'' +
                ", fraudulentTransactionCount=" + fraudulentTransactionCount +
                ", totalFraudAmount=" + totalFraudAmount +
                '}';
    }
}
