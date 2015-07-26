package com.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.streams.katas.Person;

/**
 * Test cases to understand PriorityQueue implementation in java.
 */
public class PriorityQueueTest {

    private Queue<Person> queue;

    @Before
    public void setup() {
        queue = new PriorityQueue<Person>(5, new PersonNameComparator());
        addPeopleToQueue();
    }

    private class PersonNameComparator implements Comparator<Person> {

        @Override
        public int compare(final Person p1, final Person p2) {
            return p1.getName().compareToIgnoreCase(p2.getName());
        }
    }

    private class PersonAgeComparator implements Comparator<Person> {

        @Override
        public int compare(final Person p1, final Person p2) {
            if (p1.getAge() < p2.getAge())
                return -1;
            else if (p1.getAge() > p2.getAge())
                return 1;
            else
                return 0;
        }
    }

    private void addPeopleToQueue() {
        Assert.assertTrue(queue.offer(new Person("prasad", 30)));
        Assert.assertTrue(queue.offer(new Person("sneha", 30)));
        Assert.assertTrue(queue.offer(new Person("aarti", 27)));
        Assert.assertTrue(queue.offer(new Person("baba", 60)));
        Assert.assertTrue(queue.offer(new Person("aai", 55)));
    }

    @Test
    public void shouldOrderElementsBasedOnNamePriorityAlphabetically() {
        final int priorSize = queue.size();
        final Person actualPerson = queue.peek();
        final int afterSize = queue.size();

        Assert.assertEquals("peek() should not remove elements from the head of the queue", priorSize, afterSize);

        assertPerson(actualPerson, new Person("aai", 55));
    }

    @Test
    public void shouldRemoveElementsFromQueueBasedOnNamePriorityAlphabetically() {
        final int priorSize = queue.size();
        Person actualPerson = queue.poll();
        final int afterSize = queue.size();

        Assert.assertEquals("poll() should remove elements from the head of the queue", priorSize - 1, afterSize);

        assertPerson(actualPerson, new Person("aai", 55));

        actualPerson = queue.poll();
        assertPerson(actualPerson, new Person("aarti", 27));
    }

    @Test
    public void shouldOrderElementsBasedOnPersonAge() {
        queue = new PriorityQueue<Person>(5, new PersonAgeComparator());
        addPeopleToQueue();

        Person actualPerson = queue.poll();
        assertPerson(actualPerson, new Person("aarti", 27));

        while (queue.peek() != null) {
            actualPerson = queue.poll();
        }

        assertPerson(actualPerson, new Person("baba", 60));
    }

    private void assertPerson(final Person actualPerson, final Person expectedPerson) {
        Assert.assertEquals(expectedPerson.getName(), actualPerson.getName());
        Assert.assertEquals(expectedPerson.getAge(), actualPerson.getAge());
    }

}
