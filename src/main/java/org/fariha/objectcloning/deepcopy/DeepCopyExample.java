package org.fariha.objectcloning.deepcopy;


public class DeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York", "USA");
        Person original = new Person("John", address);

        // Perform deep copy
        Person clone = (Person) original.clone();

        // Display values
        System.out.println("Original: " + original.address.city);
        System.out.println("Clone: " + clone.address.city);

        // Modify the address in the clone
        clone.address.city = "Los Angeles";

        // Changes are NOT reflected in the original object
        System.out.println("After modification:");
        System.out.println("Original: " + original.address.city);
        System.out.println("Clone: " + clone.address.city);
    }
}

class Address implements Cloneable{
    String city;
    String country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    // Method to create a deep copy of Address
    Address deepCopy() {
        return new Address(this.city, this.country);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Override clone() for deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        //clonedPerson.address = this.address.deepCopy();

        //Another way of deep copy
        clonedPerson.address=(Address) this.address.clone();
        return clonedPerson;
    }
}


