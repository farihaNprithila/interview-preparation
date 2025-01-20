package org.fariha.iteratoranditerable;

import java.util.Iterator;

public class IterableExample {
    public static void main(String[] args) {
        // Create custom collection
        String[] fruits = {"Apple", "Banana", "Cherry"};
        CustomCollection collection = new CustomCollection(fruits);

        // Use for-each loop (thanks to Iterable)
        for (String fruit : collection) {
            System.out.println(fruit);
        }
    }
}

class CustomCollection implements Iterable<String> {
    private String[] items;

    // Constructor
    public CustomCollection(String[] items) {
        this.items = items;
    }

    // Implementing the iterator() method
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < items.length;
            }

            @Override
            public String next() {
                return items[index++];
            }
        };
    }
}

