package com.lambdas.katas;

import java.util.ArrayList;
import java.util.List;

public class GenericFilter {

    public static <T> List<T> filter(final List<T> elems, final FilterPredicate<T> predicate) {
        final List<T> filteredList = new ArrayList<T>();
        for (final T elem : elems) {
            if (predicate.test(elem)) {
                filteredList.add(elem);
            }
        }
        return filteredList;
    }
}
