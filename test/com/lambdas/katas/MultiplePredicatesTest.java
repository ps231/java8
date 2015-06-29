package com.lambdas.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * http://www.coreservlets.com/java-8-tutorial/#lambdas-3
 */
public class MultiplePredicatesTest {

    private List<String> strings;
    private List<Integer> numbers;

    @Before
    public void setup() {
        strings = new ArrayList<String>();
        strings.add("how");
        strings.add("are");
        strings.add("youuu");
        strings.add("doing");
        strings.add("abcde");

        numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(12);
        numbers.add(28);
        numbers.add(4);
        numbers.add(35);
    }

    @Test
    public void shouldFilterCollectionBasedOnTwoPredicates() throws Exception {
        final List<String> filteredList = MultiplePredicates.filterOnBothPredicates(
                strings,
                s -> s.contains("o"),
                s -> s.length() > 4);

        assertFilteredList(filteredList, Arrays.asList("youuu", "doing"));
    }

    @Test
    public void shouldFilterCollectionBasedOnMultiplePredicates() throws Exception {
        final List<String> filteredList = MultiplePredicates.filterOnAllPredicates(
                strings,
                s -> s.contains("o"),
                s -> s.length() > 4,
                s -> s.endsWith("ng"));

        assertFilteredList(filteredList, Arrays.asList("doing"));
    }

    @Test
    public void shouldFilterCollectionBasedOnAnyOfThePredicates() throws Exception {
        final List<String> filteredList = MultiplePredicates.filterOnAnyPredicates(
                strings,
                s -> s.contains("o"),
                s -> s.length() > 4);

        assertFilteredList(filteredList, Arrays.asList("how", "youuu", "doing", "abcde"));
    }


    @Test
    public void shouldFilterEvenNumbersAbove10UsingGenericisedMultiplePredicates() throws Exception {
        final List<Integer> filteredList = MultiplePredicates.filterOnAllPredicates(
                numbers,
                num -> num % 2 == 0,
                num -> num > 10);

        assertFilteredList(filteredList, Arrays.asList(12, 28));
    }

    @Test
    public void shouldFilterNumbersBasedOnAnyOfThePredicates() throws Exception {
        final List<Integer> filteredList = MultiplePredicates.filterOnAnyPredicates(
                numbers,
                num -> num % 2 == 0,
                num -> num > 20);

        assertFilteredList(filteredList, Arrays.asList(12, 28, 4, 35));
    }

    private <T> void assertFilteredList(final List<T> actual, final List<T> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

}
