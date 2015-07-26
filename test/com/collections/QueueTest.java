package com.collections;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.streams.katas.Person;

/**
 * Test cases to understand Queue implementation in java.
 */
public class QueueTest {

    private Queue<Person> queue;

    @Before
    public void setup() {
        queue = new LinkedList<Person>();
        addPeopleToQueue();
    }

    private void addPeopleToQueue() {
        Assert.assertTrue(queue.offer(new Person("prasad", 30)));
        Assert.assertTrue(queue.offer(new Person("sneha", 30)));
        Assert.assertTrue(queue.offer(new Person("aarti", 27)));
        Assert.assertTrue(queue.offer(new Person("baba", 60)));
        Assert.assertTrue(queue.offer(new Person("aai", 55)));
    }

    @Test
    public void shouldOnlyInspectButNotRemoveElementFromQueue() {
        final int priorSize = queue.size();
        final Person actualPerson = queue.peek();
        final int afterSize = queue.size();

        Assert.assertEquals("peek() should not remove elements from the head of the queue", priorSize, afterSize);

        assertPerson(actualPerson);
    }

    @Test
    public void shouldRemoveElementFromQueue() {
        final int priorSize = queue.size();
        final Person actualPerson = queue.poll();
        final int afterSize = queue.size();

        Assert.assertEquals("poll() should remove elements from the head of the queue", priorSize - 1, afterSize);

        assertPerson(actualPerson);
    }

    private void assertPerson(final Person actualPerson) {
        Assert.assertEquals("prasad", actualPerson.getName());
        Assert.assertEquals(30, actualPerson.getAge());
    }

}
