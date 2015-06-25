package com.lambdas.katas;

@FunctionalInterface
public interface FilterPredicate<T> {
    boolean test(T t);
}
