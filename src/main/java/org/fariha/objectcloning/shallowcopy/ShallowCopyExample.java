package org.fariha.objectcloning.shallowcopy;


public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York", "USA");
        Person original = new Person("John", address);

        // Perform shallow copy
        Person clone = (Person) original.clone();

        // Display values
        System.out.println("Original: " + original.address.city);
        System.out.println("Clone: " + clone.address.city);

        // Modify the address in the clone
        clone.address.city = "Los Angeles";

        // Changes are reflected in the original object
        System.out.println("After modification:");
        System.out.println("Original: " + original.address.city);
        System.out.println("Clone: " + clone.address.city);
    }
}
class Address {
    String city;
    String country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Override clone() for shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

