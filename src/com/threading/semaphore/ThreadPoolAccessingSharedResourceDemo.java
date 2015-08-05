package com.threading.semaphore;

public class ThreadPoolAccessingSharedResourceDemo {

    public static void main(final String[] args) {
        Thread t;
        final SharedResource shared = new SharedResource();
        for (int i = 0; i < 10; i++) {
            t = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " shared value : " + shared.getSharedValue());
            }, "Thread" + i);
            t.start();
        }
        System.out.println("started 10 threads");
    }

}
