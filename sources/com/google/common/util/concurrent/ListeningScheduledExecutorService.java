package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
public interface ListeningScheduledExecutorService extends ScheduledExecutorService, ListeningExecutorService {
    ListenableScheduledFuture<?> schedule(Runnable runnable, long j11, TimeUnit timeUnit);

    <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j11, TimeUnit timeUnit);

    ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j11, long j12, TimeUnit timeUnit);

    ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit);
}
