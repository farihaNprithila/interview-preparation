package org.fariha.accessmodifier.protectedclass;

public class ProtectedClass {
    protected String protectedField = "I am protected";  // Accessible in the same package or subclasses

    protected void protectedMethod() {  // Accessible in the same package or subclasses
        System.out.println("Protected Method");
    }
}
