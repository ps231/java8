package com.threading;

public class Adder implements Runnable {

    private final Calculator calc;

    public Adder(final Calculator calc) {
        this.calc = calc;
    }

    @Override
    public void run() {
        System.out.println("before invoking addition logic in another thread " + calc.getSum());

        /*
         * If the wait notify mechanism is not used, then this thread runs to
         * completion before calculator has completed. Thread.sleep() can also
         * be used, but it is not a foolproof way to solve this problem.
         */
        synchronized (calc) {
            try {
                calc.wait();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("after starting calc thread " + calc.getSum());
    }

    public static void main(final String[] args) throws InterruptedException {
        final Calculator calc = new Calculator();
        final Adder adder = new Adder(calc);
        final Thread t = new Thread(adder);
        t.start();

        final Thread t1 = new Thread(adder);
        t1.start();

        Thread.sleep(500);

        final Thread t2 = new Thread(calc);
        t2.start();

        System.out.println("main thread ends");
    }

}
