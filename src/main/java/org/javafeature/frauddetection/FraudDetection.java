package org.javafeature.frauddetection;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FraudDetection {

    public List<FraudReport> detectFraud(List<Transaction> transactions) {

        // Filter amount greater than $10,000
        List<Transaction> fraudulentTransactions = transactions.stream()
                .filter(transaction -> transaction.isFraudulent() && transaction.getAmount() > 10000).collect(Collectors.toList());

        // group by policyNumber
        Map<String, List<Transaction>> groupedByPolicy = fraudulentTransactions.stream()
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        // calculate fraudulent transactions and amount
        List<FraudReport> fraudReports = groupedByPolicy.entrySet().stream()
                .map(entry -> {
                    String policyNumber = entry.getKey();
                    List<Transaction> policyTransactions = entry.getValue();
                    int fraudulentTransactionCount = policyTransactions.size();
                    double totalFraudAmount = policyTransactions.stream().mapToDouble(Transaction::getAmount).sum();
                    return new FraudReport(policyNumber, fraudulentTransactionCount, totalFraudAmount);
                }).collect(Collectors.toList());

        List<FraudReport> alerts = fraudReports.stream()
                .filter(report -> report.getFraudulentTransactionCount() > 5 || report.getTotalFraudAmount() > 50000).collect(Collectors.toList());

        return alerts;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P1", 12000.0, LocalDate.now(), true),
                new Transaction("T2", "P1", 15000.0, LocalDate.now(), true),
                new Transaction("T3", "P1", 8000.0, LocalDate.now(), true)
        );

        FraudDetection detection = new FraudDetection();
        List<FraudReport> alerts = detection.detectFraud(transactions);

        alerts.forEach(System.out::println);

    }
}
