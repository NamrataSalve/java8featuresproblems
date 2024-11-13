package org.javafeature.policyrenewalanalysis;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PolicyRenewalAnalysis {

    public Map<String, List<RenewalReminder>> analyzePolicyRenewals(List<Policy> policies) {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);

        // Filter renewal within the next 30 days
        List<RenewalReminder> reminders = policies.stream()
                .filter(policy -> "Active".equalsIgnoreCase(policy.getStatus()) && (policy.getExpiryDate().isAfter(today) && policy.getExpiryDate().isBefore(thirtyDaysFromNow)))
                .map(policy -> {
                    long remainingDays = ChronoUnit.DAYS.between(today, policy.getExpiryDate());
                    return new RenewalReminder(policy.getPolicyId(), policy.getPolicyHolderId(), remainingDays);
                }).sorted(Comparator.comparingLong(RenewalReminder::getRemainingDays)).collect(Collectors.toList());

        return reminders.stream().collect(Collectors.groupingBy(RenewalReminder::getPolicyHolderId));
    }

    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P1", "H1", LocalDate.now().plusDays(15), 1000, "Active"),
                new Policy("P2", "H2", LocalDate.now().plusDays(25), 1500, "Active"),
                new Policy("P3", "H1", LocalDate.now().plusDays(10), 2000, "Inactive"),
                new Policy("P4", "H3", LocalDate.now().plusDays(5), 1200, "Active")
        );

        PolicyRenewalAnalysis analysis = new PolicyRenewalAnalysis();
        Map<String, List<RenewalReminder>> reminders = analysis.analyzePolicyRenewals(policies);
        reminders.forEach((policyHolderId, reminderList) -> {
            System.out.println("Policy Holder ID: " + policyHolderId);
            reminderList.forEach(System.out::println);
        });
    }
}
