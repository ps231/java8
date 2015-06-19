package com.streams.katas;

import java.util.List;
import java.util.stream.Collectors;

public class FlattenCollection {

    public static List<String> transform(final List<List<String>> collection) {
//        return collection.stream().flatMap(new Function<List<String>, Stream<String>>() {
//            @Override
//            public Stream<String> apply(final List<String> t) {
//                return t.stream();
//            }
//        }).collect(Collectors.toList());

        return collection.stream().flatMap(eachInputCollection -> eachInputCollection.stream()).collect(Collectors.toList());
    }

}
