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
        assertList(transformedList, Arrays.asList("  how", "  are", "  youuu", "  doing", "  abcde"));
    }

    @Test
    public void shouldLoopThroughEachElementAndReturnSameWord() throws Exception {
        final List<String> transformedList = BasicStreams.returnSame(strings);
        assertList(transformedList, strings);
    }

    @Test
    public void shouldLoopThroughEachElementAndReturnExcitedWords() throws Exception {
        final List<String> transformedList = BasicStreams.transformToExcitedWords(strings);
        assertList(transformedList, Arrays.asList("how!", "are!", "youuu!", "doing!", "abcde!"));
    }

    @Test
    public void shouldLoopThroughEachElementAndReturnUpperCaseWords() throws Exception {
        final List<String> transformedList = BasicStreams.transformToUpperCaseWords(strings);
        assertList(transformedList, Arrays.asList("HOW", "ARE", "YOUUU", "DOING", "ABCDE"));
    }

    @Test
    public void shouldFilterWordsHavingLengthEquals3() throws Exception {
        final List<String> filteredList = BasicStreams.filterWordsByLength(strings);
        assertList(filteredList, Arrays.asList("how", "are"));
    }

    @Test
    public void shouldFilterWordsHavingLengthEquals3AndReturnAnArray() throws Exception {
        final String[] filteredArray = BasicStreams.filterWordsByLengthAndReturnArray(strings);
        Assert.assertArrayEquals(new String[] { "how", "are" }, filteredArray);
    }

    @Test
    public void shouldFilterWordsHavingEvenLength() throws Exception {
        List<String> filteredList = BasicStreams.filterWordsHavingEvenLength(strings);
        Assert.assertTrue(filteredList.isEmpty());

        strings.add("ab");
        filteredList = BasicStreams.filterWordsHavingEvenLength(strings);
        Assert.assertEquals(1, filteredList.size());
        Assert.assertEquals("ab", filteredList.get(0));
    }

    private <T> void assertList(final List<T> actual, final List<T> expected) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

}
