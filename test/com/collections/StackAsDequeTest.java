package com.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackAsDequeTest {

    private StackAsDeque<Integer> stack;
    private Deque<Integer> deque;

    @Before
    public void setup() {
        stack = new StackAsDeque<Integer>();
        populateDeque();
    }

    private void populateDeque() {
        deque = new LinkedList<Integer>();
        deque.offer(3);
        deque.offer(4);
        deque.offer(5);
        deque.offer(6);
        deque.offer(7);
    }

    @Test
    public void shouldBeAbleToPushElementsOnStack() {
        stack.push(10);
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void shouldBeAbleToPopElementsFromStack() {
        stack.push(10);
        Assert.assertEquals(10, stack.pop().intValue());
        Assert.assertNull(stack.pop());
    }

    @Test
    public void testStackUsingCollectionsUtility() {
        final Queue<Integer> stackAsQueue = StackAsDeque.getStackUsingCollectionsUtility(deque);
        Assert.assertNotNull(stackAsQueue);
        Assert.assertEquals(3, stackAsQueue.poll().intValue());
        stackAsQueue.offer(15);
        Assert.assertEquals(15, stackAsQueue.poll().intValue());
        Assert.assertEquals(4, stackAsQueue.poll().intValue());
    }

}
