package org.fariha.passbyvaluepassbyreferences;

class Person {
    String name;
}

public class PassByValueObjectExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John";

        modifyObject(person);
        System.out.println("Original person's name after method call: " + person.name); // Output: Jane
    }

    public static void modifyObject(Person p) {
        p.name = "Jane"; // Modifies the object through the reference
    }
}
