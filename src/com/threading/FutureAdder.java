package com.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAdder {

    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        final CallableCalculator callableCalc = new CallableCalculator();

        final ExecutorService pool = Executors.newFixedThreadPool(2);

        final List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

        for (int i = 1; i <= 10; i++) {
            System.out.println("submitting t" + i);
            futures.add(pool.submit(callableCalc));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("is future ready for t" + (i + 1) + "? " + futures.get(i).isDone());
            System.out.println("value for t" + i + 1 + ": " + futures.get(i).get());
        }
        pool.shutdown();
    }

}
