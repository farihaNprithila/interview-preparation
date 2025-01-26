package org.fariha.interfaces;

public interface Test2 {
    int m=10;

    public void foo();
    public void foo(String s);

    default void methodTest(){
        System.out.println("methodTest");
    }

    static void staticMethodTest(){
        System.out.println("staticMethodTest2");
    }

}
