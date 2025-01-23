package org.fariha.string;

public class StringLiteralExample {
    public static void main(String[] args) {
        String str1 = "Hello"; // Stored in the constant pool
        String str2 = "Hello"; // Points to the same object as str1
        System.out.println(str1 == str2); // true, same reference

        str2="hello1";
        System.out.println(str1);

        String a="abc";
        String b=a;

        System.out.println(a);
        b="test";
        System.out.println(a);
    }
}
