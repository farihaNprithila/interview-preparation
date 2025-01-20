package org.fariha.iteratoranditerable;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        // Create a collection
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Get an iterator for the collection
        Iterator<String> iterator = names.iterator();

        // Traverse using iterator
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);

            // Remove an element during iteration
            if (name.equals("Bob")) {
                iterator.remove();
            }
        }

        // Print the collection after iteration
        System.out.println("Remaining names: " + names);
    }
}
