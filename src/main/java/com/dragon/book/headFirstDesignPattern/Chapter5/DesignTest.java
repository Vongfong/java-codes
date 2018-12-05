package com.dragon.book.headFirstDesignPattern.Chapter5;

/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/11
 */
public class DesignTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}
