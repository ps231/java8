package com.streams.katas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * http://www.coreservlets.com/java-8-tutorial/#streams-1
 */
public class AdvStreamsTest {

    private List<String> strings;

    @Before
    public void setup() {
        strings = new ArrayList<String>();
        strings.add("how");
        strings.add("are");
        strings.add("youuu");
        strings.add("doing");
        strings.add("aeb");
        strings.add("aqb");
        strings.add("pqr");
    }

    //    Turn the strings into uppercase, keep only the ones that are shorter than 4 characters, of what
    //    is remaining, keep only the ones that contain “E”, and print the first result. Repeat the process,
    //    except checking for a “Q” instead of an “E”. When checking for the “Q”, try to avoid
    //    repeating all the code from when you checked for an “E”

    @Test
    public void shouldTransfromToUpperCaseAndFilterOnEWhereLengthIsLessThan4AndGiveFirstResult() throws Exception {
        final String firstMatchingString = AdvStreams.getFirstStringThatContainsSpecificCharAndLengthLessThan4(strings, "E");
        Assert.assertEquals("ARE", firstMatchingString);
    }

    @Test
    public void shouldTransfromToUpperCaseAndFilterOnQWhereLengthIsLessThan4AndGiveFirstResult() throws Exception {
        final String firstMatchingString = AdvStreams.getFirstStringThatContainsSpecificCharAndLengthLessThan4(strings, "Q");
        Assert.assertEquals("AQB", firstMatchingString);
    }
    
//    The above example uses lazy evaluation, but it is not easy to see that it is doing so. Make a
//    variation of the above example that proves that it is doing lazy evaluation. The simplest way
//    is to track which entries are turned into upper case.

    @Test
    public void testLazyEvaluation() throws Exception {
        
    }

    private <T> void assertList(final List<T> actual, final List<T> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

}
