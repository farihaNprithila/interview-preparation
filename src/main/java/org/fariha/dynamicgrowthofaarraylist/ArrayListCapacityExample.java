package org.fariha.dynamicgrowthofaarraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;
//the capacity will grow 1.5 times
public class ArrayListCapacityExample {
    public static void main(String[] args) throws Exception {
        // Create an ArrayList with an initial capacity of 5
        ArrayList<Integer> list = new ArrayList<>(5);
        System.out.println("Initial capacity: " + getCapacity(list));

        // Add elements to trigger capacity changes
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Capacity after adding 5 elements: " + getCapacity(list));

        list.add(6); // This will trigger resizing
        System.out.println("Capacity after adding 6th element: " + getCapacity(list));
    }

    // Reflection method to access the capacity of an ArrayList
    private static int getCapacity(ArrayList<?> list) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData"); // Access internal field
        field.setAccessible(true); // Make it accessible
        Object[] elementData = (Object[]) field.get(list); // Get the internal array
        return elementData.length; // Return the length of the internal array
    }

   /* Output
    Initial capacity: 5
    Capacity after adding 5 elements: 5
    Capacity after adding 6th element: 7*/

}
