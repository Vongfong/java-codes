package com.dragon.book.thinkinjava.chapter11;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/3
 */

public class AsListInference {

    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<Integer>(Arrays.asList(1, 3, 4));
        Collections.addAll(numbers, 1, 2, 3);
        numbers.element();
    }

}
