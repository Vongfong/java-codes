package com.dragon.cyc.note.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * User: dengshenyan
 * Time: 2019-03-21 15:25
 */
public class ProductConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producter extends Thread {
        @Override
        public void run() {
            try {
                queue.put("Product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Product...");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producter producter = new Producter();
            producter.start();
        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 3; i++) {
            Producter producter = new Producter();
            producter.start();
        }
    }
}
