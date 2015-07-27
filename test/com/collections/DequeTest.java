package com.collections;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.streams.katas.Person;

public class DequeTest {

    private Deque<Person> deque;

    @Before
    public void setup() {
        deque = new LinkedList<Person>();
        addPeopleToDeque();
    }

    private void addPeopleToDeque() {
        Assert.assertTrue(deque.offer(new Person("prasad", 30)));
        Assert.assertTrue(deque.offer(new Person("sneha", 30)));
        Assert.assertTrue(deque.offer(new Person("aarti", 27)));
        Assert.assertTrue(deque.offer(new Person("baba", 60)));
        Assert.assertTrue(deque.offer(new Person("aai", 55)));
    }

    @Test
    public void shouldPeekOnTheLastElement() {
        final Person lastPerson = deque.peekLast();
        assertPerson(lastPerson, new Person("aai", 55));
    }

    @Test
    public void shouldRemoveTheLastElement() {
        final int initSize = deque.size();
        final Person lastPerson = deque.pollLast();

        Assert.assertEquals(initSize - 1, deque.size());
        assertPerson(lastPerson, new Person("aai", 55));
    }

    @Test
    public void shouldAddElementAtTheHeadOfTheQueue() {
        final int initSize = deque.size();
        Person firstPerson = deque.peekFirst();
        assertPerson(firstPerson, new Person("prasad", 30));

        deque.offerFirst(new Person("aarnav", 5));
        firstPerson = deque.peekFirst();

        Assert.assertEquals(initSize + 1, deque.size());
        assertPerson(firstPerson, new Person("aarnav", 5));
    }

    private void assertPerson(final Person actualPerson, final Person expectedPerson) {
        Assert.assertEquals(expectedPerson.getName(), actualPerson.getName());
        Assert.assertEquals(expectedPerson.getAge(), actualPerson.getAge());
    }
}
