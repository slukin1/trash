package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.Logger;
import com.twitter.sdk.android.core.Twitter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final long DEFAULT_TERMINATION_TIMEOUT = 1;
    private static final long KEEP_ALIVE = 1;
    private static final int MAXIMUM_POOL_SIZE;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAXIMUM_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    private ExecutorUtils() {
    }

    public static void addDelayedShutdownHook(String str, ExecutorService executorService) {
        addDelayedShutdownHook(str, executorService, 1, TimeUnit.SECONDS);
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static ExecutorService buildThreadPoolExecutorService(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), getNamedThreadFactory(str));
        addDelayedShutdownHook(str, threadPoolExecutor);
        return threadPoolExecutor;
    }

    public static ThreadFactory getNamedThreadFactory(String str) {
        return new b(str, new AtomicLong(1));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addDelayedShutdownHook$1(ExecutorService executorService, long j11, TimeUnit timeUnit, String str) {
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(j11, timeUnit)) {
                Logger logger = Twitter.getLogger();
                logger.d("Twitter", str + " did not shutdown in the allocated time. Requesting immediate shutdown.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException unused) {
            Twitter.getLogger().d("Twitter", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str}));
            executorService.shutdownNow();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$getNamedThreadFactory$0(String str, AtomicLong atomicLong, Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
        newThread.setName(str + atomicLong.getAndIncrement());
        return newThread;
    }

    public static void addDelayedShutdownHook(String str, ExecutorService executorService, long j11, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        a aVar = new a(executorService, j11, timeUnit, str);
        runtime.addShutdownHook(new Thread(aVar, "Twitter Shutdown Hook for " + str));
    }
}
