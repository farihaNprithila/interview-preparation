package org.fariha.equalshascode.withoutoverriding;

import java.util.HashSet;

public class HashCodeContractViolation {
    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);

        people.add(p1);
        people.add(p2); // Since hashCode() is not overridden, this may not behave as expected

        System.out.println("Set size: " + people.size()); // Outputs 2, which is wrong since p1.equals(p2)
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
}

