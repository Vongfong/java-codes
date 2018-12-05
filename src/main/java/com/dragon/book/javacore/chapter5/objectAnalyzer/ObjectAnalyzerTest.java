package com.dragon.book.javacore.chapter5.objectAnalyzer;

import java.util.ArrayList;

/**
 * User: dengshenyan
 * Time: 2018-04-27 17:20
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
