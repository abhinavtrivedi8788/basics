package com.engineering.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filters {
    private static List<Employee> createEmployeesForGoogle() {
        return Arrays.asList(
                new Employee("Charlie", "T",30, 1000000),
                new Employee("John", "B", 14,1000),
                new Employee("Alice", "F",18 ,20000),
                new Employee("Bob", "H", 44,40000)
        );
    }
    private static List<Employee> createEmployeesForMicrofoft() {
        return Arrays.asList(
                new Employee("Adam", "A",23, 1001),
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
                .filter(employee -> employee.getAge() > 20 && employee.getSalary() > 1000)
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .toList();
        list.forEach(System.out::println);

        org.stream().forEach(System.out::println);

    }




}
