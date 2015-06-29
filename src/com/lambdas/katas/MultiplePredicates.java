package com.lambdas.katas;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultiplePredicates {

    @SafeVarargs
    public static <T> List<T> filterOnBothPredicates(final List<T> strings, final Predicate<T>... predicates) {
        return strings.stream().filter(createCombinedPredicateWithAndCondition(predicates)).collect(Collectors.toList());
    }

    @SafeVarargs
    public static <T> List<T> filterOnAllPredicates(final List<T> strings, final Predicate<T>... predicates) {
        return strings.stream().filter(createCombinedPredicateWithAndCondition(predicates)).collect(Collectors.toList());
    }

    @SafeVarargs
    public static <T> List<T> filterOnAnyPredicates(final List<T> strings, final Predicate<T>... predicates) {
        return strings.stream().filter(createCombinedPredicateWithOrCondition(predicates)).collect(Collectors.toList());
    }

    @SafeVarargs
    private static <T> Predicate<T> createCombinedPredicateWithAndCondition(final Predicate<T>... predicates) {
        Predicate<T> combinedPredicate = getPredicate(true);

        for (final Predicate<T> pred : predicates) {
            combinedPredicate = combinedPredicate.and(pred);
        }
        return combinedPredicate;
    }

    @SafeVarargs
    private static <T> Predicate<T> createCombinedPredicateWithOrCondition(final Predicate<T>... predicates) {
        Predicate<T> combinedPredicate = getPredicate(false);

        for (final Predicate<T> pred : predicates) {
            combinedPredicate = combinedPredicate.or(pred);
        }
        return combinedPredicate;
    }

    private static <T> Predicate<T> getPredicate(final boolean returnVal) {
        return s -> returnVal;
    }
}
