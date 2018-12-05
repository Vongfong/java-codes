package com.dragon.concurrent;

import java.util.Date;

/**
 * Created by dsy on 2018/3/1
 * 多线程的实现方式
 */
public class TimePrinter implements Runnable {
    int pauseTime;
    String name;

    public TimePrinter(int pauseTime, String name) {
        this.pauseTime = pauseTime;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(name + ":" + new Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TimePrinter(1000, "Fast Guy"));
        t1.start();
        Thread t2 = new Thread(new TimePrinter(3000, "Slow Guy"));
        t2.start();
    }
}
