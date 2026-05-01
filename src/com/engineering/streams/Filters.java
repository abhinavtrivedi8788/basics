package com.engineering.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Filters {
    private static List<Employee> createEmployeesForGoogle() {
        return Arrays.asList(
                new Employee("Charlie", "T",30, 1000000),
                new Employee("John", "B", 14,1000),
                new Employee("Alice", "T",18 ,20000),
                new Employee("Bob", "H", 44,40000)
        );
    }
    private static List<Employee> createEmployeesForMicrofoft() {
        return Arrays.asList(
                new Employee("Adam", "T",23, 1001),
                new Employee("Bond", "B", 11,2000),
                new Employee("Chug", "F",19 ,3000),
                new Employee("Dom", "H", 56,40000)
        );
    }

    private static List<Organisation> createOrg() {
        return Arrays.asList(
                new Organisation("Google", "Mountain View", createEmployeesForGoogle()),
                new Organisation("Microsoft", "Redmond", createEmployeesForMicrofoft())
        );
    }

    static void main() {
        List<Organisation> org = createOrg();


        // find the Employee whose as age greater than 20 and salary is greater that 1000 in both org.
        List<String> list = org.stream()
                .flatMap(emp -> emp.getEmployees().stream())
                .filter(employee -> employee.getAge() > 20 && employee.getSalary() > 40000)
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .toList();
        list.forEach(System.out::println);

        List<Organisation> organization = org.stream()
                .filter(o -> o.getEmployees()
                        .stream()
                        .anyMatch(employee -> employee.getFirstName().equalsIgnoreCase("Charlie")))
                .toList();
        System.out.println(organization);


        Map<String, List<Employee>> groupBy = org.stream()
                .flatMap(o -> o.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getLastName));

        System.out.println(groupBy.values());

        Map<Boolean, List<Employee>> partitioningBy = org.stream()
                .flatMap(o -> o.getEmployees().stream())
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 4000));

        System.out.println("\n Employee with Salary Greater than 4K");
        partitioningBy.get(true).forEach(System.out::println);

        System.out.println("\n Employee with Salary less than 4K");
        partitioningBy.get(false).forEach(System.out::println);
    }
}
