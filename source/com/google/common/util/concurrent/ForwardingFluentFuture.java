package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible
final class ForwardingFluentFuture<V> extends FluentFuture<V> {
    private final ListenableFuture<V> delegate;

    public ForwardingFluentFuture(ListenableFuture<V> listenableFuture) {
        this.delegate = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean z11) {
        return this.delegate.cancel(z11);
    }

    public V get() throws InterruptedException, ExecutionException {
        return this.delegate.get();
    }

    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    public boolean isDone() {
        return this.delegate.isDone();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.get(j11, timeUnit);
    }
}
