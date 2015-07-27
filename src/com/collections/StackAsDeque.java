package com.collections;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackAsDeque<T> {

    private final Deque<T> deque;

    public StackAsDeque() {
        deque = new LinkedList<T>();
    }

    public void push(final T t) {
        deque.offerFirst(t);
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public T pop() {
        return deque.pollFirst();
    }

    public static Queue<Integer> getStackUsingCollectionsUtility(final Deque<Integer> deque2) {
        return Collections.asLifoQueue(deque2);
    }

}
