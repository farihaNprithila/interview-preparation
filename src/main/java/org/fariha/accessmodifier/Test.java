package org.fariha.accessmodifier;

import org.fariha.accessmodifier.protectedclass.ProtectedClass;

public class Test {
    public static void main(String[] args) {
        ProtectedClass obj = new ProtectedClass();
        // System.out.println(obj.protectedField);  // Error if accessed from a different package
        // obj.protectedMethod();                   // Error if accessed from a different package

        ProtectedSubClass subObj = new ProtectedSubClass();
        subObj.display();  // Can access protected members within the same package or subclass
    }
}
