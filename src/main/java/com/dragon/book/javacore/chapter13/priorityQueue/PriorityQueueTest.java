package com.dragon.book.javacore.chapter13.priorityQueue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/17
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();

        pq.add(new GregorianCalendar(1905, Calendar.DECEMBER, 9));
        pq.add(new GregorianCalendar(2000, Calendar.DECEMBER, 8));
        pq.add(new GregorianCalendar(1994, Calendar.DECEMBER, 7));
        pq.add(new GregorianCalendar(2018, Calendar.DECEMBER, 20));

        System.out.println("Iteratoring over Elements .... ");
        for (GregorianCalendar data : pq) {
            System.out.println(data.get(Calendar.YEAR));
        }

        System.out.println("removing Elements...");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove().get(Calendar.YEAR));
        }
    }
}
