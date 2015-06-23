package com.lambdas.katas;

@FunctionalInterface
public interface TwoArgPredicate<T> {
    boolean test(T o1, T o2);
}
