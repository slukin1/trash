package com.adjust.sdk.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

public interface FutureScheduler {
    ScheduledFuture<?> scheduleFuture(Runnable runnable, long j11);

    ScheduledFuture<?> scheduleFutureWithFixedDelay(Runnable runnable, long j11, long j12);

    <V> ScheduledFuture<V> scheduleFutureWithReturn(Callable<V> callable, long j11);

    void teardown();
}
