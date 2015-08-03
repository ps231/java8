package com.threading;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class CallableCalculator implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("calculator run invoked");

        final int sum = IntStream.range(0, 1000).reduce((i1, i2) -> i1 + i2).getAsInt();

        // for (int i = 0; i < 1000; i++) {
        // sum += i;
        // }

        /*
         * This helps simulate Future.get() blocks for the operation to complete.
         * Future.isDone() can also be used to find if the operation is complete.
         */
        Thread.sleep(2000);

        return sum;
    }

}
