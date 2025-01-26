package org.fariha.collectioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetainAllExample {
    public static void main(String[] args) {
        List<String> fruitsList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Pear"));
        List<String> fruitsToKeep = new ArrayList<>(Arrays.asList("Banana", "Pear", "Grape"));

        System.out.println("Before retainAll:");
        System.out.println("Fruits List: " + fruitsList);
        System.out.println("Fruits to Keep: " + fruitsToKeep);

        // Retain only the elements in fruitsList that are also in fruitsToKeep
        boolean isModified = fruitsList.retainAll(fruitsToKeep);

        System.out.println("\nAfter retainAll:");
        System.out.println("Fruits List: " + fruitsList);
        System.out.println("Was the list modified? " + isModified);
    }
}
