package org.fariha.dynamicgrowthofaarraylist;

import java.util.ArrayList;

public class ArrayListGrowthExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(2); // Initial capacity is 2

        // Adding elements beyond initial capacity
        list.add(1); // No resizing needed
        list.add(2); // No resizing needed

        System.out.println(list.size());

        list.add(3); // Capacity exceeded, resizing occurs

        System.out.println("List: " + list); // [1, 2, 3]
    }
}
