package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
public final class ExecutionList {
    private static final Logger log = Logger.getLogger(ExecutionList.class.getName());
    @GuardedBy("this")
    private boolean executed;
    @GuardedBy("this")
    private RunnableExecutorPair runnables;

    public static final class RunnableExecutorPair {
        public final Executor executor;
        public RunnableExecutorPair next;
        public final Runnable runnable;

        public RunnableExecutorPair(Runnable runnable2, Executor executor2, RunnableExecutorPair runnableExecutorPair) {
            this.runnable = runnable2;
            this.executor = executor2;
            this.next = runnableExecutorPair;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e11);
        }
    }

    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        synchronized (this) {
            if (!this.executed) {
                this.runnables = new RunnableExecutorPair(runnable, executor, this.runnables);
            } else {
                executeListener(runnable, executor);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        executeListener(r1.runnable, r1.executor);
        r1 = r1.next;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r0 == null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r2 = r0.next;
        r0.next = r1;
        r1 = r0;
        r0 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.executed     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            return
        L_0x0007:
            r0 = 1
            r3.executed = r0     // Catch:{ all -> 0x0026 }
            com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair r0 = r3.runnables     // Catch:{ all -> 0x0026 }
            r1 = 0
            r3.runnables = r1     // Catch:{ all -> 0x0026 }
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
        L_0x0010:
            if (r0 == 0) goto L_0x0019
            com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair r2 = r0.next
            r0.next = r1
            r1 = r0
            r0 = r2
            goto L_0x0010
        L_0x0019:
            if (r1 == 0) goto L_0x0025
            java.lang.Runnable r0 = r1.runnable
            java.util.concurrent.Executor r2 = r1.executor
            executeListener(r0, r2)
            com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair r1 = r1.next
            goto L_0x0019
        L_0x0025:
            return
        L_0x0026:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ExecutionList.execute():void");
    }
}
