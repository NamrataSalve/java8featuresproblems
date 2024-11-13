package org.javafeature.policyrenewalanalysis;

public class RenewalReminder {
    private String policyId;
    private String policyHolderId;
    private long remainingDays;

    public RenewalReminder(String policyId, String policyHolderId, long remainingDays) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.remainingDays = remainingDays;
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

    public long getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(long remainingDays) {
        this.remainingDays = remainingDays;
    }

    @Override
    public String toString() {
        return "RenewalReminder{" +
                "policyId='" + policyId + '\'' +
                ", policyHolderId='" + policyHolderId + '\'' +
                ", remainingDays=" + remainingDays +
                '}';
    }
}
