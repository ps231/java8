package com.streams.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FilterAndMapTest {

    private List<Person> collection;

    @Before
    public void setup() {
        final Person sara = new Person("Sara", 4);
        final Person viktor = new Person("Viktor", 40);
        final Person eva = new Person("Eva", 42);
        final Person anna = new Person("Anna", 5);
        collection = Arrays.asList(sara, eva, viktor, anna);
    }

    /*
     * Get names of all kids (under age of 18)
     */
    @Test
    public void getKidNamesShouldReturnNamesOfAllKids() {
        final List<String> actualResult = FilterAndMap.filterKidNames(collection);
        assertResults(actualResult, Arrays.asList("Sara", "Anna"), Arrays.asList("Viktor", "Eva"));
    }

    /*
     * Get names of all adults (above age 18)
     */
    @Test
    public void getAdultNamesShouldReturnNamesOfAllAdults() {
        final List<String> actualResult = FilterAndMap.filterAdultNames(collection);
        assertResults(actualResult, Arrays.asList("Viktor", "Eva"), Arrays.asList("Sara", "Anna"));
    }


    private void assertResults(final List<String> actualResult, final List<String> expectedFoundResults, final List<String> expectedFilteredOutResults) {

        Assert.assertEquals(actualResult.size(), expectedFoundResults.size());
        for (final String exp : expectedFoundResults) {
            Assert.assertTrue(actualResult.contains(exp));
        }
        for (final String exp : expectedFilteredOutResults) {
            Assert.assertFalse(actualResult.contains(exp));
        }
    }
}