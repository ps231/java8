package com.streams.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * http://www.coreservlets.com/java-8-tutorial/#streams-1
 */
public class BasicStreamsTest {

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
    public void shouldLoopThroughEachElementAndReturnWithTwoSpacesInFrontOfEveryWord() throws Exception {
        final List<String> transformedList = BasicStreams.transformWithSpaces(strings);
        assertFilteredList(transformedList, Arrays.asList("  how", "  are", "  youuu", "  doing", "  abcde"));
    }

    @Test
    public void shouldLoopThroughEachElementAndReturnSameWord() throws Exception {
        final List<String> transformedList = BasicStreams.returnSame(strings);
        assertFilteredList(transformedList, strings);
    }

    private <T> void assertFilteredList(final List<T> actual, final List<T> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

}
