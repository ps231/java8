package com.lambdas.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringTransformer {

    public static List<String> transform(final List<String> elems, final Function<String, String> function) {
        final List<String> transformedList = new ArrayList<String>();
        for (final String elem : elems) {
            final String transformedElem = function.apply(elem);
            transformedList.add(transformedElem);
        }
        return transformedList;
    }

}
