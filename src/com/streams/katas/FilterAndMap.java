package com.streams.katas;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterAndMap {
    
    private static Predicate<? super Person> kidsAgePredicate = p -> p.getAge() < 18;
    
    public static List<String> filterKidNames(final List<Person> collection) {
        
        return collection
                .stream()
                .filter(kidsAgePredicate)
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }

    public static List<String> filterAdultNames(final List<Person> collection) {
        return collection
                .stream()
                .filter(kidsAgePredicate.negate())
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }
}
