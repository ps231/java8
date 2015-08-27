package com.threading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private int balance;
    private Lock lock = new ReentrantLock();

    public Account(final int balance) {
        this.balance = balance;
    }

    public void withdraw() {
        //        lock.lock();
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw");

        lock.lock();

        if (balance >= 10) {
            balance = balance - 10;
            System.out.println(Thread.currentThread().getName() + " withdrew 10. Current bal: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " unable to withdraw. Current bal: " + balance);
        }

        lock.unlock();
    }
}
