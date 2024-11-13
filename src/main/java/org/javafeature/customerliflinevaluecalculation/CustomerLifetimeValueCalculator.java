package org.javafeature.customerliflinevaluecalculation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerLifetimeValueCalculator {
    public List<CustomerLifetimeValue> calculateTopCustomers(List<CustomerTransaction> transactions) {
        LocalDate oneYearAgo = LocalDate.now().minus(12, ChronoUnit.MONTHS);

        //filter  last 12 months
        List<CustomerTransaction> filteredTransactions = transactions.stream()
                .filter(transaction -> transaction.getTransactionDate().isAfter(oneYearAgo))
                .collect(Collectors.toList());

        Map<String, List<Double>> customerAmounts = filteredTransactions.stream()
                .collect(Collectors.groupingBy(
                        CustomerTransaction::getCustomerId,
                        Collectors.mapping(CustomerTransaction::getTransactionAmount, Collectors.toList())
                ));

        List<CustomerLifetimeValue> customerLifetimeValues = customerAmounts.entrySet().stream()
                .map(entry -> {
                    String customerId = entry.getKey();
                    List<Double> amounts = entry.getValue();
                    double totalAmount = amounts.stream().mapToDouble(Double::doubleValue).sum();
                    double averageAmount = amounts.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    return new CustomerLifetimeValue(customerId, totalAmount, averageAmount);
                })
                .collect(Collectors.toList());

        // sort descending order
        List<CustomerLifetimeValue> sortedCustomers = customerLifetimeValues.stream()
                .sorted(Comparator.comparingDouble(CustomerLifetimeValue::getTotalAmount).reversed())
                .collect(Collectors.toList());
        return sortedCustomers.stream().limit(10).collect(Collectors.toList());

    }
    public static void main(String[] args) {
        List<CustomerTransaction> transactions = Arrays.asList(
                new CustomerTransaction("C1", LocalDate.now().minusMonths(1), 150.0),
                new CustomerTransaction("C1", LocalDate.now().minusMonths(3), 200.0),
                new CustomerTransaction("C1", LocalDate.now().minusMonths(6), 300.0),
                new CustomerTransaction("C2", LocalDate.now().minusMonths(2), 400.0),
                new CustomerTransaction("C2", LocalDate.now().minusMonths(5), 500.0),
                new CustomerTransaction("C3", LocalDate.now().minusMonths(10), 600.0),
                new CustomerTransaction("C3", LocalDate.now().minusMonths(11), 700.0),
                new CustomerTransaction("C4", LocalDate.now().minusMonths(1), 800.0)
                );
        CustomerLifetimeValueCalculator calculator = new CustomerLifetimeValueCalculator();
        List<CustomerLifetimeValue> topCustomers = calculator.calculateTopCustomers(transactions);

        topCustomers.forEach(System.out::println);
    }
}
