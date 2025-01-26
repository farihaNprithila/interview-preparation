package org.fariha.streamapi;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample1 {

    public static void main(String[] args) {

        // Sample Data: List of people with name and age
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Diana", 40),
                new Person("Eve", 30)
        );

        // NON-TERMINAL OPERATION: Using map() to get a stream of names
        List<String> names = people.stream()
                .map(Person::getName) // map Person objects to names
                .collect(Collectors.toList());

        // Using map() with toMap() to create a Map from person's name to age
        Map<String, Person> peoplemap = people.stream()
                .collect(Collectors.toMap(Person::getName, person -> person));

        // Printing the map
        System.out.println("Name to Age Map: " + peoplemap);

        Set<Integer> age = people.stream().map(person -> {
            return person.getAge();
        }).collect(Collectors.toSet());

        System.out.println("Age: " + age);

        System.out.println("Names: " + names);

        // NON-TERMINAL OPERATION: Using filter() to filter by age
        List<Person> filteredPeople = people.stream()
                .filter(p -> {
                    return p.getAge() > 30;
                })
                .collect(Collectors.toList());

        System.out.println("People older than 30: " + filteredPeople);

        // TERMINAL OPERATION: Using forEach() to print each person's name
        System.out.println("Printing names using forEach:");
        people.stream().forEach(p -> System.out.println(p.getName()));

        // TERMINAL OPERATION: Using reduce() for aggregation (finding the oldest person)
        Optional<Person> oldestPerson = people.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);

        oldestPerson.ifPresent(p -> System.out.println("Oldest person: " + p.getName()));

        // TERMINAL OPERATION: Using collect() to group people by age
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("People grouped by age: " + peopleByAge);

        // PURE FUNCTION: Example of a pure function (no side effects)
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));

        // HIGHER-ORDER FUNCTION: A function that returns another function
        Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
        Function<Integer, Integer> add5 = add.apply(5);
        System.out.println("Add 5 to 10: " + add5.apply(10));

        // FUNCTION COMPOSITION: Combining functions
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;
        Function<Integer, Integer> combinedFunction = multiplyBy2.andThen(add3);
        System.out.println("Multiply by 2 and then add 3 to 5: " + combinedFunction.apply(5));

        // Built-in Functional Interfaces
        // Predicate - Test if a person is over 30
        Predicate<Person> isOver30 = p -> p.getAge() > 30;
        boolean anyOver30 = people.stream().anyMatch(isOver30);
        System.out.println("Any person older than 30? " + anyOver30);

        // Consumer - Print person's name
        Consumer<Person> printName = p -> System.out.println("Person: " + p.getName());
        people.stream().forEach(printName);

        // Supplier - Generate a random age
        Supplier<Integer> randomAge = () -> new Random().nextInt(100);
        System.out.println("Random Age: " + randomAge.get());

        // Aggregation using summarizing (Count, Average, Min, Max)
        IntSummaryStatistics stats = people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println("Age statistics: " + stats);

        // Building your own Collector (to count names by length)
        Collector<Person, ?, Map<Integer, Long>> nameLengthCollector = Collector.of(
                HashMap::new,
                (map, person) -> map.merge(person.getName().length(), 1L, Long::sum),
                (map1, map2) -> {
                    map1.putAll(map2);
                    return map1;
                });

        Map<Integer, Long> nameLengthMap = people.stream()
                .collect(nameLengthCollector);

        System.out.println("Name length counts: " + nameLengthMap);
    }

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
