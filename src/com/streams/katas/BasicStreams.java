package com.streams.katas;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicStreams {

    public static List<String> transformWithSpaces(final List<String> strings) {
        // strings.stream().forEach(s -> System.out.println("  " + s));
        return strings.stream().map(s -> "  " + s).collect(Collectors.toList());
    }

    public static List<String> returnSame(final List<String> strings) {
        // strings.stream().forEach(System.out::println);
        return strings.stream().map(Function.identity()).collect(Collectors.toList());
    }

}
