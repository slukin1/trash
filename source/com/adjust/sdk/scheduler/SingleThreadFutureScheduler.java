package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleThreadFutureScheduler implements FutureScheduler {
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    public class a implements RejectedExecutionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13970a;

        public a(String str) {
            this.f13970a = str;
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), this.f13970a);
        }
    }

    public class b implements Callable<V> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callable f13971a;

        public b(Callable callable) {
            this.f13971a = callable;
        }

        public final V call() {
            try {
                return this.f13971a.call();
            } catch (Throwable th2) {
                AdjustFactory.getLogger().error("Callable error [%s] of type [%s]", th2.getMessage(), th2.getClass().getCanonicalName());
                return null;
            }
        }
    }

    public SingleThreadFutureScheduler(String str, boolean z11) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new ThreadFactoryWrapper(str), new a(str));
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor2;
        if (!z11) {
            scheduledThreadPoolExecutor2.setKeepAliveTime(10, TimeUnit.MILLISECONDS);
            this.scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public ScheduledFuture<?> scheduleFuture(Runnable runnable, long j11) {
        return this.scheduledThreadPoolExecutor.schedule(new RunnableWrapper(runnable), j11, TimeUnit.MILLISECONDS);
    }

    public ScheduledFuture<?> scheduleFutureWithFixedDelay(Runnable runnable, long j11, long j12) {
        return this.scheduledThreadPoolExecutor.scheduleWithFixedDelay(new RunnableWrapper(runnable), j11, j12, TimeUnit.MILLISECONDS);
    }

    public <V> ScheduledFuture<V> scheduleFutureWithReturn(Callable<V> callable, long j11) {
        return this.scheduledThreadPoolExecutor.schedule(new b(callable), j11, TimeUnit.MILLISECONDS);
    }

    public void teardown() {
        this.scheduledThreadPoolExecutor.shutdownNow();
    }
}
