package com.lambdas.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Coding exercises from http://www.coreservlets.com/java-8-tutorial/#lambdas-2
 *
 */
public class GenericTransformerTest {

    @Test
    public void shouldTransformToExcitingWordsWithExclamation() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<String> shortWords = GenericTransformer.transform(words, s -> s + "!");
        assertTransformedList(shortWords, Arrays.asList("hi!", "hello!", "how!", "do!", "you!", "feel!"));
    }

    @Test
    public void shouldTransformToUpperCaseWords() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<String> shortWords = GenericTransformer.transform(words, s -> s.toUpperCase());
        assertTransformedList(shortWords, Arrays.asList("HI", "HELLO", "HOW", "DO", "YOU", "FEEL"));
    }

    @Test
    public void shouldTransformToIntegerListWithWordLength() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<Integer> wordLengths = GenericTransformer.transform(words, s -> s.length());
        assertTransformedList(wordLengths, Arrays.asList(2, 5, 3, 2, 3, 4));
    }

    private <T> void assertTransformedList(final List<T> actual, final List<T> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }
}
