package com.streams.katas;

import java.util.List;

public class AdvStreams {

    public static String getFirstStringThatContainsSpecificCharAndLengthLessThan4(final List<String> strings, final String specificChar) {
        return strings.stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() < 4)
                .filter(s -> s.contains(specificChar))
                .findFirst()
                .get();
    }

}
