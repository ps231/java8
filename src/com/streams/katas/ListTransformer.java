package com.streams.katas;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListTransformer {

    private final List<String> values;

    private static Predicate<? super String> NUMBERS_PREDICATE = s -> s.matches("[0-9]+");
    private static Comparator<Integer> NATURAL_SORT_COMPARATOR = Comparator.comparingInt(s -> s.intValue());

    private ListTransformer(final List<String> values) {
        this.values = values;
    }

    public static ListTransformer of(final List<String> values) {
        return new ListTransformer(values);
    }

    /**
     * This method should take the String List and sort all the String elements
     * in ascending (ASCII) order.
     *
     * @return The sorted values in ascending ASCII order.
     */
    public List<String> getSortedStrings() {
        return values
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * This method should take the String List and:
     * <ol>
     * <li>filter the elements that contains one or more digits;</li>
     * <li>transform (map) the remaining Strings into Integers;</li>
     * <li>sort the Integers in ascending order.</li>
     * </ol>
     *
     * @return
     */
    public List<Integer> getSortedIntegers() {

        return values
                .stream()
                .filter(NUMBERS_PREDICATE)
                .map(s -> Integer.valueOf(s))
                .sorted(NATURAL_SORT_COMPARATOR)
                .collect(Collectors.toList());
    }

    /**
     * This method should take the String List and:
     * <ol>
     * <li>filter the elements that contains one or more digits;</li>
     * <li>transform (map) the remaining Strings into Integers;</li>
     * <li>sort the Integers in descending order.</li>
     * </ol>
     *
     * @return
     */
    public List<Integer> getSortedDescendingIntegers() {

        return values
                .stream()
                .filter(NUMBERS_PREDICATE)
                .map(s -> Integer.valueOf(s))
                .sorted(NATURAL_SORT_COMPARATOR.reversed())
                .collect(Collectors.toList());
    }

}