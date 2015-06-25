package com.lambdas.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Coding exercises from http://www.coreservlets.com/java-8-tutorial/#lambdas-2
 *
 */
public class StringTransformerTest {

    @Test
    public void shouldTransformToExcitingWordsWithExclamation() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<String> shortWords = StringTransformer.transform(words, s -> s + "!");
        assertTransformedList(shortWords, Arrays.asList("hi!", "hello!", "how!", "do!", "you!", "feel!"));
    }

    @Test
    public void shouldTransformToUpperCaseWords() {
        final List<String> words = Arrays.asList("hi", "hello", "how", "do", "you", "feel");
        final List<String> shortWords = StringTransformer.transform(words, s -> s.toUpperCase());
        assertTransformedList(shortWords, Arrays.asList("HI", "HELLO", "HOW", "DO", "YOU", "FEEL"));
    }

    private void assertTransformedList(final List<String> actual, final List<String> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (final String word : actual) {
            Assert.assertTrue(expected.contains(word));
        }
    }

}
