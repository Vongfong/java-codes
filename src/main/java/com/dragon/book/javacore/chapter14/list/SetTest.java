package com.dragon.book.javacore.chapter14.list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/15
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        long totalTime = 0;

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long currentTime = System.currentTimeMillis();
            set.add(in.next());
            long callTime = System.currentTimeMillis() - currentTime;
            totalTime += callTime;
        }

        Iterator<String> iterator = set.iterator();
        for (int i = 1; i <= 20 && iterator.hasNext(); i++) {
            System.out.println(iterator.next());
        }

        System.out.println(".......");
        System.out.println(set.size() + " distincts word. " + totalTime + " milliseconds");
    }
}
