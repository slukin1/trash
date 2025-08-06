package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleThreadCachedScheduler implements ThreadScheduler {
    /* access modifiers changed from: private */
    public boolean isTeardown = false;
    /* access modifiers changed from: private */
    public boolean isThreadProcessing = false;
    /* access modifiers changed from: private */
    public final List<Runnable> queue = new ArrayList();
    private ThreadPoolExecutor threadPoolExecutor;

    public class a implements RejectedExecutionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13964a;

        public a(String str) {
            this.f13964a = str;
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), this.f13964a);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f13965a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f13966b;

        public b(long j11, Runnable runnable) {
            this.f13965a = j11;
            this.f13966b = runnable;
        }

        public final void run() {
            try {
                Thread.sleep(this.f13965a);
            } catch (InterruptedException e11) {
                AdjustFactory.getLogger().warn("Sleep delay exception: %s", e11.getMessage());
            }
            SingleThreadCachedScheduler.this.submit(this.f13966b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f13968a;

        public c(Runnable runnable) {
            this.f13968a = runnable;
        }

        public final void run() {
            SingleThreadCachedScheduler singleThreadCachedScheduler = SingleThreadCachedScheduler.this;
            Runnable runnable = this.f13968a;
            while (true) {
                singleThreadCachedScheduler.tryExecuteRunnable(runnable);
                synchronized (SingleThreadCachedScheduler.this.queue) {
                    if (!SingleThreadCachedScheduler.this.isTeardown) {
                        if (SingleThreadCachedScheduler.this.queue.isEmpty()) {
                            boolean unused = SingleThreadCachedScheduler.this.isThreadProcessing = false;
                            return;
                        } else {
                            runnable = (Runnable) SingleThreadCachedScheduler.this.queue.get(0);
                            SingleThreadCachedScheduler.this.queue.remove(0);
                        }
                    } else {
                        return;
                    }
                }
                singleThreadCachedScheduler = SingleThreadCachedScheduler.this;
            }
            while (true) {
            }
        }
    }

    public SingleThreadCachedScheduler(String str) {
        this.threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryWrapper(str), new a(str));
    }

    private void processQueue(Runnable runnable) {
        this.threadPoolExecutor.submit(new c(runnable));
    }

    /* access modifiers changed from: private */
    public void tryExecuteRunnable(Runnable runnable) {
        try {
            if (!this.isTeardown) {
                runnable.run();
            }
        } catch (Throwable th2) {
            AdjustFactory.getLogger().warn("Execution failed: %s", th2.getMessage());
        }
    }

    public void schedule(Runnable runnable, long j11) {
        synchronized (this.queue) {
            if (!this.isTeardown) {
                this.threadPoolExecutor.submit(new b(j11, runnable));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void submit(java.lang.Runnable r3) {
        /*
            r2 = this;
            java.util.List<java.lang.Runnable> r0 = r2.queue
            monitor-enter(r0)
            boolean r1 = r2.isTeardown     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0009:
            boolean r1 = r2.isThreadProcessing     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0014
            r1 = 1
            r2.isThreadProcessing = r1     // Catch:{ all -> 0x001b }
            r2.processQueue(r3)     // Catch:{ all -> 0x001b }
            goto L_0x0019
        L_0x0014:
            java.util.List<java.lang.Runnable> r1 = r2.queue     // Catch:{ all -> 0x001b }
            r1.add(r3)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.scheduler.SingleThreadCachedScheduler.submit(java.lang.Runnable):void");
    }

    public void teardown() {
        synchronized (this.queue) {
            this.isTeardown = true;
            this.queue.clear();
            this.threadPoolExecutor.shutdown();
        }
    }
}
