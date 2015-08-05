package com.threading.semaphore;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class SharedResource {

    /*
     * Currently the binarySemaphore has a single permit, but we can change this
     * value and create a counting semaphore having number of permits > 1. A
     * counting semaphore allows those many number of threads to access the
     * shared resource. If no of threads exceeds the no of permits, then the
     * latest threads have to wait till the time semaphore.release is not
     * invoked.
     */
    private final Semaphore binarySemaphore = new Semaphore(1, true);

    public int getSharedValue() {
        int randomValue = 0;
        try {
            binarySemaphore.acquire();
            randomValue = 10;

            Thread.sleep(500);

            System.out.println(Thread.currentThread().getName() + " has access to shared resource at " + LocalDateTime.now());
        } catch (final InterruptedException e) {
            e.printStackTrace();
        } finally {
            /*
             * very important to release the semaphore, otherwise other threads
             * that are waiting to acquire the semaphore will be hanging
             * forever.
             */
            binarySemaphore.release();
        }
        return randomValue;
    }

    /*
     * Creating a synchronized method or block is another way to protect a
     * shared resource from being accessed by multiple threads.
     */
    public synchronized int getSynchronizedSharedValue() throws InterruptedException {
        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName() + " has access to shared resource at " + LocalDateTime.now());

        return 10;
    }
}
