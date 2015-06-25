package com.lambdas.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericTransformer {

    public static <T, R> List<R> transform(final List<T> elems, final Function<T, R> function) {
        final List<R> transformedList = new ArrayList<R>();
        for (final T elem : elems) {
            final R transformedElem = function.apply(elem);
            transformedList.add(transformedElem);
        }
        return transformedList;
    }
}
