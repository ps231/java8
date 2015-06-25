package com.lambdas.katas;

import java.util.ArrayList;
import java.util.List;

public class StringFilter {

    public static List<String> filter(final List<String> words, final FilterPredicate<String> predicate) {
        final List<String> filteredList = new ArrayList<String>();
        for (final String word : words) {
            if (predicate.test(word)) {
                filteredList.add(word);
            }
        }
        return filteredList;
    }
}
