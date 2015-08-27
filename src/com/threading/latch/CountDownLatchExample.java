package com.threading.latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        CountDownLatch latch = new CountDownLatch(3);
        Runnable nr = new NameRunnable(latch);

        int i = 0;
        for (Thread t : threads) {
            t = new Thread(nr, "Thread " + ++i);
            t.start();
        }
        latch.await();

        System.out.println("main thread has completed");
    }

    private static class NameRunnable implements Runnable {

        private CountDownLatch latch;

        public NameRunnable(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " got the promotional offer!");
            latch.countDown();
        }
    }
}
