package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingQueue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    public abstract BlockingQueue<E> delegate();

    public int drainTo(Collection<? super E> collection, int i11) {
        return delegate().drainTo(collection, i11);
    }

    public boolean offer(E e11, long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offer(e11, j11, timeUnit);
    }

    public E poll(long j11, TimeUnit timeUnit) throws InterruptedException {
        return delegate().poll(j11, timeUnit);
    }

    public void put(E e11) throws InterruptedException {
        delegate().put(e11);
    }

    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    public E take() throws InterruptedException {
        return delegate().take();
    }

    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }
}
