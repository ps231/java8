package com.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackAsDequeTest {

    private StackAsDeque<Integer> stack;

    @Before
    public void setup() {
        stack = new StackAsDeque<Integer>();
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

}
