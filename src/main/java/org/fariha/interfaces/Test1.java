package org.fariha.interfaces;

public interface Test1 {
    public void foo();

    default void methodTest(){
        System.out.println("methodTest");
    }

    static void staticMethodTest(){
        System.out.println("staticMethodTest");
    }
}
