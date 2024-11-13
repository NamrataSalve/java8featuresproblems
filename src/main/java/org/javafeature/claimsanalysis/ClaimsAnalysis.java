package org.javafeature.claimsanalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClaimsAnalysis {

    public List<PolicyClaim> analyzeClaims(List<Claim> claims) {

        // greater than 5000
        List<Claim> filteredClaims = claims.stream()
                .filter(claim -> "Approved".equalsIgnoreCase(claim.getStatus()) && claim.getClaimAmount() > 5000).collect(Collectors.toList());

        Map<String, List<Claim>> groupedByPolicy = filteredClaims.stream().collect(Collectors.groupingBy(Claim::getPolicyNumber));

        // average claim amount
        List<PolicyClaim> summaries = groupedByPolicy.entrySet().stream()
                .map(entry -> {
                    String policyNumber = entry.getKey();
                    List<Claim> policyClaims = entry.getValue();
                    double totalClaimAmount = policyClaims.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double averageClaimAmount = policyClaims.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0.0);
                    return new PolicyClaim(policyNumber, totalClaimAmount, averageClaimAmount);
                }).collect(Collectors.toList());

        //  highest total claim amounts
        return summaries.stream()
                .sorted(Comparator.comparingDouble(PolicyClaim::getTotalClaimAmount).reversed())
                .limit(3).collect(Collectors.toList());
    }
        public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P1", 6000.0, LocalDate.now(), "Approved"),
                new Claim("C2", "P2", 7000.0, LocalDate.now(), "Approved"),
                new Claim("C3", "P1", 8000.0, LocalDate.now(), "Approved")
                );
            ClaimsAnalysis analysis = new ClaimsAnalysis();
            List<PolicyClaim> topPolicies = analysis.analyzeClaims(claims);
            topPolicies.forEach(System.out::println);
    }
}
