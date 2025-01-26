package org.fariha.streamapi;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamExample {

    public static void main(String[] args) {
        
        // Sample Data: List of people with name and age
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("Diana", 40),
            new Person("Eve", 30)
        );

        // 1. Terminal Operations: Operations that consume the stream and produce a result
        System.out.println("Terminal Operations:");
        
        // collect() - collects the stream into a list
        List<Person> personList = people.stream()
            .filter(person -> person.getAge() > 30)
            .collect(Collectors.toList()); // collect terminal operation
        System.out.println("People older than 30: " + personList);

        // forEach() - performs an action for each element in the stream
        System.out.print("People's Names: ");
        people.stream().forEach(person -> System.out.print(person.getName() + " "));
        System.out.println();

        // reduce() - combines the elements into a single value (e.g., sum of ages)
        int totalAge = people.stream()
            .map(Person::getAge)
            .reduce(0, Integer::sum); // reduce terminal operation
        System.out.println("Total Age: " + totalAge);

        // count() - counts the elements in the stream
        long count = people.stream().count(); // count terminal operation
        System.out.println("Total Number of People: " + count);

        // 2. Non-Terminal Operations: Operations that return a new stream
        System.out.println("\nNon-Terminal Operations:");

        // map() - transforms each element in the stream (mapping names to uppercase)
        List<String> upperNames = people.stream()
            .map(person -> person.getName().toUpperCase()) // map non-terminal operation
            .collect(Collectors.toList());
        System.out.println("Names in Uppercase: " + upperNames);

        // filter() - filters elements based on a condition
        List<Person> peopleWithAgeOver30 = people.stream()
            .filter(person -> person.getAge() > 30) // filter non-terminal operation
            .collect(Collectors.toList());
        System.out.println("People older than 30: " + peopleWithAgeOver30);

        // sorted() - sorts the stream elements
        List<Person> sortedByName = people.stream()
            .sorted(Comparator.comparing(Person::getName)) // sorted non-terminal operation
            .collect(Collectors.toList());
        System.out.println("People sorted by name: " + sortedByName);

        // 3. Pure Function: A function that has no side effects and produces the same output for the same input
        System.out.println("\nPure Function Example:");
        Function<Integer, Integer> square = x -> x * x; // pure function
        System.out.println("Square of 5: " + square.apply(5));

        // 4. Higher-Order Function: A function that takes other functions as arguments or returns a function
        System.out.println("\nHigher-Order Function Example:");
        Function<Integer, Function<Integer, Integer>> add = a -> b -> a + b;
        Function<Integer, Integer> add5 = add.apply(5); // first argument is 5
        System.out.println("5 + 3 = " + add5.apply(3)); // apply the second argument

        // 5. Function Composition: Combining two functions to create a new function
        System.out.println("\nFunction Composition Example:");
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> add5Again = x -> x + 5;
        Function<Integer, Integer> doubleAndAdd5 = doubleIt.andThen(add5Again); // compose functions
        System.out.println("Double and then add 5 to 4: " + doubleAndAdd5.apply(4));

        // 6. Built-in Functional Interfaces: Examples of Predicate, Consumer, Supplier, Function

        // Predicate: Tests if an element meets a condition
        Predicate<Person> isAdult = person -> person.getAge() >= 18;
        boolean isAdultBob = isAdult.test(new Person("Bob", 25));
        System.out.println("Is Bob an adult? " + isAdultBob);

        // Consumer: Accepts a value and does something with it (printing a person)
        Consumer<Person> printPerson = person -> System.out.println(person);
        System.out.print("Consuming each person: ");
        people.stream().forEach(printPerson);

        // Supplier: Provides a value (creates a new person)
        Supplier<Person> personSupplier = () -> new Person("John", 50);
        System.out.println("New person from Supplier: " + personSupplier.get());

        // Function: Transforms one type to another (e.g., age to age in months)
        Function<Person, Integer> ageInMonths = person -> person.getAge() * 12;
        System.out.println("Age in months for Bob: " + ageInMonths.apply(new Person("Bob", 25)));

        // 7. Aggregation: Operations that combine or summarize data
        System.out.println("\nAggregation Example:");

        // Using summarizingInt to calculate average, sum, min, and max of ages
        IntSummaryStatistics ageSummary = people.stream()
            .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("Age Summary: " + ageSummary);

        // 8. Building Your Own Collector: Custom Collector Example
        System.out.println("\nCustom Collector Example:");

        // Custom collector to group people by their age
        Collector<Person, ?, Map<Integer, List<Person>>> groupByAge = 
            Collectors.groupingBy(Person::getAge);
        Map<Integer, List<Person>> groupedByAge = people.stream()
            .collect(groupByAge);
        System.out.println("People grouped by age: " + groupedByAge);
    }

    // Sample Person class
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}
