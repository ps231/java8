package com.streams.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * http://www.coreservlets.com/java-8-tutorial/#streams-2
 */
public class StreamReductionTest {

    private List<String> strings;

    @Before
    public void setup() {
        strings = new ArrayList<String>();
        strings.add("how");
        strings.add("are");
        strings.add("youuu");
        strings.add("doing");
        strings.add("abcde");
    }

    @Test
    public void shouldConcatenateAllWordsInUpperCase() throws Exception {
        final String concatenatedString = StreamReduction.reduceToUpperCase(strings);
        Assert.assertEquals("HOWAREYOUUUDOINGABCDE", concatenatedString);
    }

    @Test
    public void shouldConcatenateAllWordsSeparatedByComma() throws Exception {
        final String concatenatedString = StreamReduction.reduceWithComma(strings);
        Assert.assertEquals("how,are,youuu,doing,abcde", concatenatedString);
    }

    @Test
    public void shouldComputeSumOfAllNumbers() throws Exception {
        final int sum = StreamReduction.add(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(15, sum);
    }

    @Test
    public void shouldComputeSumOfAllNumbersUsingParallelStream() throws Exception {
        final int sum = StreamReduction.addParallel(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(15, sum);
    }

    @Test
    public void shouldComputeSumOfAllNumbersUsingIntStream() throws Exception {
        final int sum = StreamReduction.addUsingIntStream(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(15, sum);
    }

    @Test
    public void shouldComputeMultiplicationOfAllNumbers() throws Exception {
        final int multipliedVal = StreamReduction.multiply(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(120, multipliedVal);
    }
}
