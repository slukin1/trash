package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingDeque;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    public abstract BlockingDeque<E> delegate();

    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }

    public boolean offer(E e11, long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offer(e11, j11, timeUnit);
    }

    public boolean offerFirst(E e11, long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offerFirst(e11, j11, timeUnit);
    }

    public boolean offerLast(E e11, long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offerLast(e11, j11, timeUnit);
    }

    public E poll(long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().poll(j11, timeUnit);
    }

    public E pollFirst(long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().pollFirst(j11, timeUnit);
    }

    public E pollLast(long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().pollLast(j11, timeUnit);
    }

    public void put(E e11) throws InterruptedException {
        delegate().put(e11);
    }

    public void putFirst(E e11) throws InterruptedException {
        delegate().putFirst(e11);
    }

    public void putLast(E e11) throws InterruptedException {
        delegate().putLast(e11);
    }

    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    public E take() throws InterruptedException {
        return delegate().take();
    }

    public E takeFirst() throws InterruptedException {
        return delegate().takeFirst();
    }

    public E takeLast() throws InterruptedException {
        return delegate().takeLast();
    }

    public int drainTo(Collection<? super E> collection, int i11) {
        return delegate().drainTo(collection, i11);
    }
}
