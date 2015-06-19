package com.streams.katas;

import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCase {

    public static List<String> transform(final List<String> collection) {
        return collection.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
    }

}
