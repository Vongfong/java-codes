package com.dragon.dynamicProxy;

/**
 * User: dengshenyan
 * Time: 2018-05-11 16:40
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello" + str);
    }
}
