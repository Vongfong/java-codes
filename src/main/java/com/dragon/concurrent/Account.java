package com.dragon.concurrent;

/**
 * Created by dsy on 2018/3/1
 */
public class Account {
    String name;
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public synchronized void despoist(float amt) {
        amount += amt;
    }

    public synchronized void withdraw(float amt) {
        amount -= amt;
    }

    public float checkBalance() {
        return amount;
    }
}
