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

    public static List<String> transformToExcitedWords(final List<String> strings) {
        return strings.stream().map(s -> s + "!").collect(Collectors.toList());
    }

    public static List<String> transformToUpperCaseWords(final List<String> strings) {
        return strings.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    }

    public static List<String> filterWordsByLength(final List<String> strings) {
        return strings.stream().filter(s -> s.length() == 3).collect(Collectors.toList());
    }

    public static List<String> filterWordsHavingEvenLength(final List<String> strings) {
        return strings.stream().filter(s -> s.length() % 2 == 0).collect(Collectors.toList());
    }

}
