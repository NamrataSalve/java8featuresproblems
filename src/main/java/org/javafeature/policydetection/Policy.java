package org.javafeature.policydetection;

public class Policy {
    private String policyId;
    private String policyHolderId;

    public Policy(String policyId, String policyHolderId) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        this.policyHolderId = policyHolderId;
    }
}
