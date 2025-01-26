package org.fariha.collectioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionInterface {

    public static void main(String[] args) {
        List<String> fruitsList = new ArrayList<String>();

        System.out.println(fruitsList.size());

        fruitsList.add("Banana");
        fruitsList.add("Apple");
        fruitsList.add("Orange");
        fruitsList.add("Pear");
        fruitsList.add("Grape");

        System.out.println(fruitsList);

        fruitsList.remove("Apple");
        System.out.println(fruitsList);

        System.out.println(fruitsList.contains("banana"));

        System.out.println(fruitsList.containsAll(new ArrayList<>(Arrays.asList("Banana", "Grape"))));

        fruitsList.add(0, "Car");
        System.out.println(fruitsList);

        fruitsList.remove(fruitsList.size() - 1);
        System.out.println(fruitsList);

        System.out.println(fruitsList.indexOf("Car"));

        System.out.println(fruitsList.subList(0,2));
    }
}
