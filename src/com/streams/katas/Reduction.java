package com.streams.katas;

import java.util.List;

public class Reduction {

    public static int addition(final List<Integer> numbers) {
        return numbers.stream().reduce(0, (total, number) -> total + number);
    }

    public static int multiply(final List<Integer> numbers) {
        return numbers.stream().reduce(1, (total, number) -> total * number);
    }

    public static String stringify(final List<Integer> numbers) {
        return numbers.stream()
                .map(number->Integer.toString(number))
                .reduce("", (concatenatedString, number) -> concatenatedString + number + "#");

        //        numbers.stream().map(
        //                new Function<Integer, String>() {
        //
        //            @Override
        //            public String apply(final Integer t) {
        //                return Integer.toString(t);
        //            }
        //        }).reduce("", (concatenatedString, number) -> concatenatedString + "#");
    }
}