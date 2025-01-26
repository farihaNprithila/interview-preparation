package org.fariha.comparatorandcomparable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Alice"));
        employees.add(new Employee(1, "Bob"));
        employees.add(new Employee(2, "Charlie"));

        // Using Comparator to sort by name
        Comparator<Employee> nameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getId().compareTo(e1.getId()); // Compare by name
            }
        };

        // Sorting using the custom Comparator
        Collections.sort(employees, nameComparator);

        // Print sorted list
        System.out.println("Sorted by Name (using Comparator):");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Employee{
    Integer id;
    String name;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
