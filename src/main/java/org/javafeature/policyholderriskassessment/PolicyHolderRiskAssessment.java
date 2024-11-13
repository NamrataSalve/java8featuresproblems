package org.javafeature.policyholderriskassessment;

import java.util.*;
import java.util.stream.Collectors;

public class PolicyHolderRiskAssessment {

    public Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> policyHolders) {

        //filter "Life" and age > 60
        List<RiskAssessment> riskAssessments = policyHolders.stream()
                .filter(holder -> "Life".equalsIgnoreCase(holder.getPolicyType()) && holder.getAge() > 60).map(holder -> {
                    double riskScore = holder.getPremiumAmount() / holder.getAge();
                    return new RiskAssessment(holder.getHolderId(), holder.getName(), riskScore);
                }).sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed()).collect(Collectors.toList());
       // risk categories
        Map<String, List<RiskAssessment>> categorizedRiskAssessments = new HashMap<>();
        for (RiskAssessment assessment : riskAssessments) {
            String category = assessment.getRiskScore() > 0.5 ? "High Risk" : "Low Risk";
            categorizedRiskAssessments.computeIfAbsent(category, k -> new ArrayList<>()).add(assessment);
        }
        return categorizedRiskAssessments;
    }
        public static void main(String[] args) {
        List<PolicyHolder> policyHolders = Arrays.asList(
                new PolicyHolder("H1", "Namrata", 65, "Life", 1200.0),
                new PolicyHolder("H2", "Vishal", 70, "Life", 800.0),
                new PolicyHolder("H3", "Kajal", 62, "Health", 1000.0),
                new PolicyHolder("H4", "Kiran", 61, "Life", 700.0)
        );
            PolicyHolderRiskAssessment assessment = new PolicyHolderRiskAssessment();
            Map<String, List<RiskAssessment>> result = assessment.assessRisk(policyHolders);

            result.forEach((category, assessments) -> {
                System.out.println(category + ":");
                assessments.forEach(System.out::println);
            });

        }
}
