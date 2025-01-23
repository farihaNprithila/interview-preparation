package org.fariha.passbyvaluepassbyreferences;

public class PassByValueExample {
    public static void main(String[] args) {
        int number = 10;
        modifyPrimitive(number);
        System.out.println("Original number after method call: " + number); // Output: 10
    }

    public static void modifyPrimitive(int num) {
        num = 20; // Modifies the copy of 'number', not the original
        System.out.println("Modified inside method: " + num); // Output: 20
    }
}
