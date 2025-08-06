package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;

@GwtIncompatible
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    public void addFirst(E e11) {
        delegate().addFirst(e11);
    }

    public void addLast(E e11) {
        delegate().addLast(e11);
    }

    public abstract Deque<E> delegate();

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public E getFirst() {
        return delegate().getFirst();
    }

    public E getLast() {
        return delegate().getLast();
    }

    @CanIgnoreReturnValue
    public boolean offerFirst(E e11) {
        return delegate().offerFirst(e11);
    }

    @CanIgnoreReturnValue
    public boolean offerLast(E e11) {
        return delegate().offerLast(e11);
    }

    public E peekFirst() {
        return delegate().peekFirst();
    }

    public E peekLast() {
        return delegate().peekLast();
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        return delegate().pollLast();
    }

    @CanIgnoreReturnValue
    public E pop() {
        return delegate().pop();
    }

    public void push(E e11) {
        delegate().push(e11);
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        return delegate().removeLast();
    }

    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
