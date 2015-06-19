package com.streams.katas;

import static java.util.Arrays.asList;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 Filter collection so that only elements with less then 4 characters are returned.
 */
public class FilterCollectionTest {

    @Test
    public void transformShouldFilterCollection() {
        final List<String> collection = asList("My", "name", "is", "John", "Doe");
        final List<String> expected = asList("My", "is", "Doe");
        final List<String> actual = FilterCollection.transform(collection);
        assertFilteredElements(expected, actual);
    }

    private void assertFilteredElements(final List<String> expected, final List<String> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (final String elem : expected) {
            Assert.assertTrue(actual.contains(elem));
        }
    }

}
