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

}
