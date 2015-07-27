package com.collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NavigableSetTest {

    NavigableSet<Integer> set;

    @Before
    public void setup() {
        set = new TreeSet<Integer>();
        set.add(5);
        set.add(15);
        set.add(3);
        set.add(1);
        set.add(7);
    }

    /**
     * descendingSet returns a view of the original set. ie, if we changes are
     * made to the view, they will be reflected in the original set as well.
     */
    @Test
    public void shouldGiveADescendingSetAsAViewOfTheOriginalSet() {
        final NavigableSet<Integer> nSet = set.descendingSet();
        assertSet(new Integer[] { 15, 7, 5, 3, 1 }, nSet);

        nSet.add(9);
        assertSet(new Integer[] { 1, 3, 5, 7, 9, 15 }, set);
        assertSet(new Integer[] { 15, 9, 7, 5, 3, 1 }, nSet);
    }

    @Test
    public void descendingIteratorMustPrintElementsInDescendingOrder() {
        final Iterator<Integer> descItr = set.descendingIterator();
        while (descItr.hasNext()) {
            System.out.println(descItr.next());
        }
    }

    @Test
    public void testVariousSetDivisionMethods() {
        final SortedSet<Integer> setWithElementsLessThan5 = set.headSet(5);
        assertSet(new Integer[] { 1, 3 }, setWithElementsLessThan5);

        final SortedSet<Integer> setWithElementsGreaterThan5 = set.tailSet(5);
        assertSet(new Integer[] { 5, 7, 15 }, setWithElementsGreaterThan5);

        final SortedSet<Integer> subset = set.subSet(2, 6);
        assertSet(new Integer[] { 3, 5 }, subset);

    }

    @Test
    public void testCeilingFloorMethods() {
        final int ceiling = set.ceiling(2);
        Assert.assertEquals(3, ceiling);

        final int floor = set.floor(7);
        Assert.assertEquals(7, floor);
    }

    private void assertSet(final Integer[] expectedArray, final SortedSet<Integer> set) {
        Assert.assertArrayEquals(expectedArray, set.toArray(new Integer[set.size()]));
    }
}
