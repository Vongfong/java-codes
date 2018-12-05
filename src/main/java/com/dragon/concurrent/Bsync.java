package com.dragon.concurrent;

/**
 * Created by dsy on 2018/3/1
 */
public class Bsync {
    int totalThreads;
    int currentThreads;

    public Bsync(int x) {
        this.totalThreads = x;
        currentThreads = 0;
    }

    public void waitForAll() {
        currentThreads ++;
        if (currentThreads < totalThreads) {
            try {
                wait();
            } catch (Exception e) {
            }
        } else {
            currentThreads = 0;
            notifyAll();
        }
    }
}
