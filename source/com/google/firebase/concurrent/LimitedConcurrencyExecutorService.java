package com.google.firebase.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class LimitedConcurrencyExecutorService extends LimitedConcurrencyExecutor implements ExecutorService {
    private final ExecutorService delegate;

    public LimitedConcurrencyExecutorService(ExecutorService executorService, int i11) {
        super(executorService, i11);
        this.delegate = executorService;
    }

    public boolean awaitTermination(long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j11, timeUnit);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.delegate.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j11, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.delegate.invokeAny(collection, j11, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t11) {
        return submit(new x(runnable, t11));
    }

    public Future<?> submit(Runnable runnable) {
        return submit(new w(runnable));
    }
}
