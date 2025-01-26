package org.fariha.interfaces;

public class InterfaceTest implements Test1,Test2{
    public static void main (String[] args) {
        System.out.println(m);
        Test1.staticMethodTest();
        Test2.staticMethodTest();
    }

    @Override
    public void foo() {

    }

    @Override
    public void methodTest() {
        Test2.super.methodTest();
    }

    @Override
    public void foo(String s) {

    }
}
