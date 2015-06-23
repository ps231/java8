package com.lambdas.katas;

import org.junit.Assert;
import org.junit.Test;

public class StringSortTest {

    @Test
    public void shouldSortStringsByLength() {
        final String[] strings = { "abc", "x", "za", "abcd" };
        final String[] actual = StringSort.sortByLength(strings);
        Assert.assertArrayEquals(new String[] { "x", "za", "abc", "abcd" }, actual);
    }

    @Test
    public void shouldSortStringsByReverseLength() {
        final String[] strings = { "abc", "x", "za", "abcd" };
        final String[] actual = StringSort.sortByReverseLength(strings);
        Assert.assertArrayEquals(new String[] { "abcd", "abc", "za", "x" }, actual);
    }

    @Test
    public void shouldSortStringsByFirstCharacter() {
        final String[] strings = { "abc", "xb", "za", "abcd" };
        final String[] actual = StringSort.sortByFirstChar(strings);
        Assert.assertArrayEquals(new String[] { "abc", "abcd", "xb", "za" }, actual);
    }

    @Test
    public void shouldSortStringsWithCharEFirstAndThenTheRest() {
        final String[] strings = { "abc", "xe", "za", "abed" };
        final String[] actual = StringSort.sortByCharE(strings);
        Assert.assertArrayEquals(new String[] { "xe", "abed", "abc", "za" }, actual);
    }

}
