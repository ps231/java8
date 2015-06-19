package com.streams.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 Flatten multidimensional collection
 */
public class FlattenCollectionTest {

    @Test
    public void transformShouldFlattenCollection() {
        final List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
        final List<String> expected = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");
        final List<String> actual = FlattenCollection.transform(collection);
        assertFlattenedElements(expected, actual);
    }

    private void assertFlattenedElements(final List<String> expected, final List<String> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (final String elem : expected) {
            Assert.assertTrue(actual.contains(elem));
        }
    }

}
