package com.streams.katas;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTransformerTest {

    private static final String[] strings = { "a", "7", "4", "z", "T", "c", "10", "h", "2" };

    private ListTransformer listTransformer;

    @Before
    public void setup() {
        this.listTransformer = ListTransformer.of(Arrays.asList(strings));
    }

    @Test
    public void testGetSortedStrings() throws Exception {
        assertThat(listTransformer.getSortedStrings(), is(equalTo(Arrays.asList("10", "2", "4", "7", "T", "a", "c", "h", "z"))));
    }

    @Test
    public void testGetSortedIntegers() throws Exception {
        assertThat(listTransformer.getSortedIntegers(), is(equalTo(Arrays.asList(2, 4, 7, 10))));
    }

    @Test
    public void testGetSortedDescendingIntegers() throws Exception {
        assertThat(listTransformer.getSortedDescendingIntegers(), is(equalTo(Arrays.asList(10, 7, 4, 2))));
    }

    @Test
    public void shouldReturnTrueIfStringIsANumber() {
        Assert.assertTrue("10".matches("[0-9]+"));
        Assert.assertTrue("0".matches("[0-9]+"));
        Assert.assertTrue("1002".matches("[0-9]+"));
    }

    @Test
    public void shouldReturnFalseIfStringIsNotANumber() {
        Assert.assertFalse("".matches("[0-9]+"));
        Assert.assertFalse(" ".matches("[0-9]+"));
        Assert.assertFalse("T".matches("[0-9]+"));
        Assert.assertFalse("ab".matches("[0-9]+"));
    }

}
