package org.fariha.string;

public class NewStringExample {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = "Hello";
        
        System.out.println(str1 == str2); // false (different objects)
        System.out.println(str1.equals(str2)); // true (same value)
    }
}
