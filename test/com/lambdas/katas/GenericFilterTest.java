package com.lambdas.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Coding exercises from http://www.coreservlets.com/java-8-tutorial/#lambdas-2
 *
 */
public class GenericFilterTest {

    @Test
    public void shouldFilterIntegersGreaterThan100() {
        final List<Integer> nums = Arrays.asList(10, 20, 101, 500, 0, 100, 99);
        final List<Integer> numGreaterThan100 = GenericFilter.filter(nums, num -> num > 100);
        assertFilteredList(numGreaterThan100, Arrays.asList(101, 500));
    }

    @Test
    public void shouldFilterWordsWithEvenLength() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<String> wordsWithEvenLength = GenericFilter.filter(words, s -> s.length() % 2 == 0);
        assertFilteredList(wordsWithEvenLength, Arrays.asList("hi", "do", "feel"));
    }

    private <T> void assertFilteredList(final List<T> actual, final List<T> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (final T elem : actual) {
            Assert.assertTrue(expected.contains(elem));
        }
    }
}
