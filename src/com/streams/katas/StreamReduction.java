package com.streams.katas;

import java.util.List;

public class StreamReduction {

    public static String reduceToUpperCase(final List<String> strings) {
        //        return strings.stream().map(s -> s.toUpperCase()).reduce("", (s1, s2) -> s1.concat(s2));
        return strings.stream().reduce("", (s1, s2) -> s1.toUpperCase().concat(s2.toUpperCase()));
    }

    public static String reduceWithComma(final List<String> strings) {
        return strings.stream().reduce((s1, s2) -> s1.concat(",").concat(s2)).get();
    }

    public static int add(final List<Integer> numbers) {
        return numbers.stream().reduce((num1, num2) -> num1 + num2).get();
    }

    public static int addParallel(final List<Integer> numbers) {
        return numbers.parallelStream().reduce((num1, num2) -> num1 + num2).get();
    }

    public static int addUsingIntStream(final List<Integer> numbers) {
        return numbers.stream().mapToInt(num -> num).sum();
    }

    public static int multiply(final List<Integer> numbers) {
        return numbers.stream().reduce((num1, num2) -> num1 * num2).get();
    }

    public static int getMaxNumber(final List<Integer> numbers) {
        return numbers.stream().mapToInt(num -> num).max().getAsInt();
    }

    public static int getMinNumber(final List<Integer> numbers) {
        return numbers.stream().mapToInt(num -> num).min().getAsInt();
    }

    public static double getAverage(final List<Integer> numbers) {
        return numbers.stream().mapToInt(num -> num).average().getAsDouble();
    }
}
