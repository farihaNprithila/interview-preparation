package org.fariha.iteratoranditerable;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableWithIterator {
    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        collection.add("Java");
        collection.add("Python");
        collection.add("C++");

        // For-each loop (uses Iterable)
        System.out.println("Using for-each:");
        for (String lang : collection) {
            System.out.println(lang);
        }

        // Explicit iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class MyCollection implements Iterable<String> {
    private ArrayList<String> items;

    public MyCollection() {
        this.items = new ArrayList<>();
    }

    public void add(String item) {
        items.add(item);
    }

    @Override
    public Iterator<String> iterator() {
        return items.iterator(); // Return the iterator from the ArrayList
    }
}

