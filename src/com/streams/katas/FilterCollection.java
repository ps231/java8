package com.streams.katas;

import java.util.List;
import java.util.stream.Collectors;

public class FilterCollection {

    public static List<String> transform(final List<String> collection) {
//        return collection.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(final String t) {
//                return t.length() < 4;
//            }
//        }).collect(Collectors.toList());

        return collection.stream().filter(eachString -> eachString.length() < 4).collect(Collectors.toList());
    }

}
