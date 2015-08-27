package com.threading.barrier;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Thread[] threads = new Thread[5];
        CyclicBarrier barrier = new CyclicBarrier(3, ()->{System.out.println("Barrier limit of 3 reached. 3 threads will get the promotional offer!");});
        Runnable nr = new PromotionRunnable(barrier);

        int i = 0;
        for (Thread t : threads) {
            t = new Thread(nr, "Thread " + ++i);
            t.start();
        }
        System.out.println("main thread has completed");
    }

    private static class PromotionRunnable implements Runnable {
        private final CyclicBarrier barrier;

        public PromotionRunnable(final CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        /*
         * As per the doc, BrokenBarrierException is thrown when another thread timed out while the current thread was waiting.
         * This explains why we are able to see both Timeout and Broken Barrier Exceptions.
         */
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " trying to get the promotional offer!");
            try {
                barrier.await(2000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName() + " could not get the promotional offer, due to barrier exception");
                return;
            } catch (TimeoutException e) {
                System.out.println(Thread.currentThread().getName() + " could not get the promotional offer, due to timeout exception");
                return;
            }
            System.out.println(Thread.currentThread().getName() + " got the promotional offer!");
        }
    }
}
