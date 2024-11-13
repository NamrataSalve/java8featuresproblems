package org.javafeature.policyholderriskassessment;

public class RiskAssessment {
    private String holderId;
    private String name;
    private double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String holderId) {
        this.holderId = holderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "RiskAssessment{" +
                "holderId='" + holderId + '\'' +
                ", name='" + name + '\'' +
                ", riskScore=" + riskScore +
                '}';
    }
}
