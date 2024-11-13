package org.javafeature.policydetection;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class FraudulentPolicyDetector {
    public List<String> detectFraudulentPolicies(List<Policy> policies, List<Transaction> transactions) {
        LocalDate sixMonthsAgo = LocalDate.now().minus(6, ChronoUnit.MONTHS);

        // Filter transactions in the last 6 months exceeding $10,000
        Map<String, List<Transaction>> highValueTransactions = transactions.stream()
                .filter(transaction -> transaction.getTransactionDate().isAfter(sixMonthsAgo)
                        && transaction.getAmount() > 10000)
                .collect(Collectors.groupingBy(Transaction::getPolicyId));
                  System.out.println("High Value Transactions: " + highValueTransactions);


        // Filter policies with more than 3 such transactions
        Map<String, List<Transaction>> filteredPolicies = highValueTransactions.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Filtered Policies: " + filteredPolicies);

        // Group by policyHolderId and aggregate total amounts
        Map<String, Double> flaggedPolicies = new HashMap<>();

        for (String policyId : filteredPolicies.keySet()) {
            double totalAmount = filteredPolicies.get(policyId).stream()
                    .mapToDouble(Transaction::getAmount)
                    .sum();

            if (totalAmount > 50000) {
                // Find policyHolderId for this policyId
                policies.stream()
                        .filter(policy -> policy.getPolicyId().equals(policyId))
                        .findFirst()
                        .ifPresent(policy -> {
                            flaggedPolicies.put(policy.getPolicyHolderId(), totalAmount);
                        });
            }
        }

        return new ArrayList<>(flaggedPolicies.keySet());
    }

    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P01","PH01"),
                new Policy("P02","PH02"),
                new Policy("P03","PH03")
        );
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T01", "P01", 15000, LocalDate.now().minusMonths(2)),
                new Transaction("T02", "P02", 20000, LocalDate.now().minusMonths(3)),
                new Transaction("T03", "P03", 25000, LocalDate.now().minusMonths(1)),
                new Transaction("T04", "P01", 5000, LocalDate.now().minusMonths(5))
        );


    }
}
