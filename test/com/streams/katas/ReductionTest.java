package com.streams.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 Operations to reduce all elements of a collection
 */

public class ReductionTest {

    @Test
    public void reductionShouldAddAllElements() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertEquals(15, Reduction.addition(numbers));
    }

    @Test
    public void reductionShouldMultiplyAllElements() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertEquals(1 * 2 * 3 * 4 * 5, Reduction.multiply(numbers));

    }

    @Test
    public void reductionShouldReturnAConcatenatedStringOfAllElementsSeperatedBy$() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertEquals("1#2#3#4#5#", Reduction.stringify(numbers));
    }

}