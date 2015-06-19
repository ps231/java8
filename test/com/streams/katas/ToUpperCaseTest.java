package com.streams.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 Convert elements of a collection to upper case.
 */
public class ToUpperCaseTest {
    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        final List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        final List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");
        final List<String> actual = ToUpperCase.transform(collection);
        assertElementIsInUpperCase(expected, actual);
    }

    private void assertElementIsInUpperCase(final List<String> expected, final List<String> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (final String upperCaseElem : expected) {
            Assert.assertTrue(actual.contains(upperCaseElem));
        }
    }
}
