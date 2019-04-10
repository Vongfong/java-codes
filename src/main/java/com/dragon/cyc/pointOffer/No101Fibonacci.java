package com.dragon.cyc.pointOffer;

/**
 * User: dengshenyan
 * Time: 2019-04-08 17:24
 */
public class No101Fibonacci {

    private int fib[] = new int[40];

    public No101Fibonacci(int n) {
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public int fibonacci(int n) {
        return fib[n];
    }
}
