package org.fariha.accessmodifier;

import org.fariha.accessmodifier.protectedclass.ProtectedClass;

class ProtectedSubClass extends ProtectedClass {
    public void display() {
        System.out.println(protectedField);  // Accessible in subclass
        protectedMethod();                   // Accessible in subclass
    }
}