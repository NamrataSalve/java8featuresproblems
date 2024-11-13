package org.javafeature.policyrenewalanalysis;

import java.time.LocalDate;

public class Policy {
    private String policyId;
    private String policyHolderId;
    private LocalDate expiryDate;
    private double premiumAmount;
    private String status;

    public Policy(String policyId, String policyHolderId, LocalDate expiryDate, double premiumAmount, String status) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
        this.status = status;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        this.policyHolderId = policyHolderId;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
