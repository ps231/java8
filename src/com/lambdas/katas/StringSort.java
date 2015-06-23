package com.lambdas.katas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSort {

    private static Comparator<String> LENGTH_COMPARATOR = Comparator.comparingInt(s -> s.length());

    public static String[] sortByLength(final String[] strings) {
        final List<String> actual = Arrays.stream(strings).sorted(LENGTH_COMPARATOR).collect(Collectors.toList());
        return actual.toArray(new String[actual.size()]);
    }

    public static String[] sortByReverseLength(final String[] strings) {
        final List<String> actual = Arrays.stream(strings).sorted(LENGTH_COMPARATOR.reversed()).collect(Collectors.toList());
        return actual.toArray(new String[actual.size()]);
    }

    public static String[] sortByFirstChar(final String[] strings) {
        final List<String> actual = Arrays.stream(strings).sorted(Comparator.comparingInt(s -> s.charAt(0))).collect(Collectors.toList());
        return actual.toArray(new String[actual.size()]);
    }

    public static String[] sortByCharE(final String[] strings) {
        final List<String> actual = Arrays.stream(strings).sorted(eComparator()).collect(Collectors.toList());
        return actual.toArray(new String[actual.size()]);
    }

    private static Comparator<? super String> eComparator() {
        return (s1, s2) -> {
            if (s1.contains("e") && !s2.contains("e")) {
                return -1;
            } else if (!s1.contains("e") && s2.contains("e")) {
                return 1;
            }
            return 0;
        };
    }

    public static String betterString(final String string1, final String string2, final TwoArgPredicate<? super String> stringPredicate) {
        if (stringPredicate.test(string1, string2)) {
            return string1;
        }
        return string2;
    }

}
