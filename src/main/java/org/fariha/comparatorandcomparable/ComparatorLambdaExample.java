package org.fariha.comparatorandcomparable;

import java.util.ArrayList;
import java.util.List;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Alice"));
        employees.add(new Employee(1, "Bob"));
        employees.add(new Employee(2, "Charlie"));

        // Sort by Name (using lambda)
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));

        System.out.println("Sorted by Name (using Lambda):");
        employees.forEach(System.out::println);

        // Sort by ID (using lambda)
        employees.sort((e1, e2) -> Integer.compare(e1.getId(), e2.getId()));

        System.out.println("\nSorted by ID (using Lambda):");
        employees.forEach(System.out::println);
    }
}
