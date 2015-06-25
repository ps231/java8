package com.lambdas.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Coding exercises from http://www.coreservlets.com/java-8-tutorial/#lambdas-2
 *
 */
public class StringFilterTest {

    @Test
    public void shouldFilterWordsWithLengthLessThan4() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<String> shortWords = StringFilter.filter(words, s -> s.length() < 4);
        assertFilteredList(shortWords, Arrays.asList("hi", "how", "do", "you"));
    }

    @Test
    public void shouldFilterWordsWithCharB() {
        final List<String> words = Arrays.asList("hi", "bunny", "boo", "you");
        final List<String> wordsWithCharB = StringFilter.filter(words, s -> s.contains("b"));
        assertFilteredList(wordsWithCharB, Arrays.asList("bunny", "boo"));
    }

    @Test
    public void shouldFilterWordsWithEvenLength() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<String> wordsWithEvenLength = StringFilter.filter(words, s -> s.length() % 2 == 0);
        assertFilteredList(wordsWithEvenLength, Arrays.asList("hi", "do", "feel"));
    }

    private void assertFilteredList(final List<String> actual, final List<String> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (final String word : actual) {
            Assert.assertTrue(expected.contains(word));
        }
    }
}
