package org.javafeature.claimsanalysis;

public class PolicyClaim {
    private String policyNumber;
    private double totalClaimAmount;
    private double averageClaimAmount;

    public PolicyClaim(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public double getTotalClaimAmount() {
        return totalClaimAmount;
    }

    public void setTotalClaimAmount(double totalClaimAmount) {
        this.totalClaimAmount = totalClaimAmount;
    }

    public double getAverageClaimAmount() {
        return averageClaimAmount;
    }

    public void setAverageClaimAmount(double averageClaimAmount) {
        this.averageClaimAmount = averageClaimAmount;
    }

    @Override
    public String toString() {
        return "PolicyClaim{" +
                "policyNumber='" + policyNumber + '\'' +
                ", totalClaimAmount=" + totalClaimAmount +
                ", averageClaimAmount=" + averageClaimAmount +
                '}';
    }
}
