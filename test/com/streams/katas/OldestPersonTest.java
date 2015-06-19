package com.streams.katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 Get oldest person from the collection
 */
public class OldestPersonTest {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        final Person sara = new Person("Sara", 4);
        final Person viktor = new Person("Viktor", 40);
        final Person eva = new Person("Eva", 42);
        final List<Person> collection = Arrays.asList(sara, eva, viktor);
        final Person actualOldestPerson = OldestPerson.getOldestPerson(collection);
        assertOldestPerson(eva, actualOldestPerson);
    }

    private void assertOldestPerson(final Person expected, final Person actual) {
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getAge(), actual.getAge());
    }
}
