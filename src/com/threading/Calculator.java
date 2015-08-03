package com.threading;

public class Calculator implements Runnable {

    private int sum;

    @Override
    public void run() {
        System.out.println("calculator run invoked");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            /*
             * if replaced with notify() only one of the threads will be
             * notified, the other thread will be waiting forever.
             */
            notifyAll();
        }
    }

    public int getSum() {
        return sum;
    }

}
