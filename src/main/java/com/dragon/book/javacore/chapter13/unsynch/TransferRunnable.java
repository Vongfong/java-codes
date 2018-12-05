package com.dragon.book.javacore.chapter13.unsynch;

import java.beans.Transient;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: dsy30
 * Date: 2018/3/25
 */
public class TransferRunnable implements Runnable {

    private static Bank bank;
    private int fromAccount;
    private double maxAmount;

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        String string;
        bank = new Bank(1, 1);
        BigDecimal bigDecimal = new BigDecimal(0);
    }

    void add() {
        int i;
    }
}
