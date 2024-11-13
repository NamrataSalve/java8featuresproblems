package org.javafeature.employeestatementproblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EmployeeDataProcessing {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101,"Namrata","Engineering",80000));
        employeeList.add(new Employee(102,"Ankita","Management",60000));
        employeeList.add(new Employee(103,"Shryash","Marketing",70000));
        employeeList.add(new Employee(104,"Abhishek","HR",80000));
        employeeList.add(new Employee(101,"Lakhan","Engineering",90000));

        List<Employee> filteredEmployee = filterEmployees(employeeList);
        filteredEmployee.forEach(System.out::println);

        sortEmployeeBySalary(employeeList);
        groupByEmployee(employeeList);

    }

    private static void groupByEmployee(List<Employee> employeeList) {
        Map<String, List<Employee>> groupedEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupedEmployee.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            employees.forEach(emp -> {
                System.out.println(emp);
            });
        });
    }

    private static void sortEmployeeBySalary(List<Employee> employeeList) {
        List<Employee> sortedEmployee = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println("Employee sort by salary descending");
        for (Employee employee : sortedEmployee){
            System.out.println(employee);
        }
    }

    public static List<Employee> filterEmployees(List<Employee> employeeList){
            return employeeList.stream().filter(e -> "Engineering".equals(e.getDepartment()) && e.getSalary()>80000).collect(Collectors.toList());
        }
}
