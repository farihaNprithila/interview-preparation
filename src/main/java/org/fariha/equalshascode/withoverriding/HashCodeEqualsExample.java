package org.fariha.equalshascode.withoverriding;

import java.util.HashSet;
import java.util.Objects;


public class HashCodeEqualsExample {
    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);

        people.add(p1);
        people.add(p2); // Now this works as expected

        System.out.println("Set size: " + people.size()); // Outputs 1
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
