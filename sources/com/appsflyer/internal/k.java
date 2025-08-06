package com.appsflyer.internal;

import android.net.TrafficStats;
import com.appsflyer.AFLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class k {
    public static k valueOf;
    public ScheduledExecutorService AFInAppEventParameterName;
    public final ThreadFactory AFInAppEventType = new ThreadFactory() {
        public final Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() {
                public final void run() {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                    runnable.run();
                }
            });
        }
    };
    public Executor AFKeystoreWrapper;
    public ScheduledExecutorService values;

    public static void AFKeystoreWrapper(ExecutorService executorService) {
        try {
            AFLogger.AFInAppEventParameterName("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.AFInAppEventParameterName("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.AFInAppEventParameterName("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.AFInAppEventParameterName("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (Throwable th2) {
            if (!executorService.isTerminated()) {
                AFLogger.AFInAppEventParameterName("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th2;
        }
    }

    public final ScheduledThreadPoolExecutor AFInAppEventParameterName() {
        ScheduledExecutorService scheduledExecutorService = this.values;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.values.isTerminated()) {
            this.values = Executors.newScheduledThreadPool(2, this.AFInAppEventType);
        }
        return (ScheduledThreadPoolExecutor) this.values;
    }

    public final Executor valueOf() {
        Executor executor = this.AFKeystoreWrapper;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.AFKeystoreWrapper).isTerminated() || ((ThreadPoolExecutor) this.AFKeystoreWrapper).isTerminating()))) {
            this.AFKeystoreWrapper = Executors.newFixedThreadPool(2, this.AFInAppEventType);
        }
        return this.AFKeystoreWrapper;
    }
}
