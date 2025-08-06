package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

@GwtIncompatible
final class SequentialExecutor implements Executor {
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor executor;
    /* access modifiers changed from: private */
    @GuardedBy("queue")
    public final Deque<Runnable> queue = new ArrayDeque();
    private final QueueWorker worker = new QueueWorker();
    @GuardedBy("queue")
    private long workerRunCount = 0;
    /* access modifiers changed from: private */
    @GuardedBy("queue")
    public WorkerRunningState workerRunningState = WorkerRunningState.IDLE;

    public final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
            if (r1 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r3.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            if (r1 == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void workOnQueue() {
            /*
                r8 = this;
                r0 = 0
                r1 = r0
            L_0x0002:
                com.google.common.util.concurrent.SequentialExecutor r2 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch:{ all -> 0x0074 }
                java.util.Deque r2 = r2.queue     // Catch:{ all -> 0x0074 }
                monitor-enter(r2)     // Catch:{ all -> 0x0074 }
                if (r0 != 0) goto L_0x002b
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch:{ all -> 0x0071 }
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = r0.workerRunningState     // Catch:{ all -> 0x0071 }
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x0071 }
                if (r0 != r3) goto L_0x0020
                monitor-exit(r2)     // Catch:{ all -> 0x0071 }
                if (r1 == 0) goto L_0x001f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x001f:
                return
            L_0x0020:
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch:{ all -> 0x0071 }
                com.google.common.util.concurrent.SequentialExecutor.access$308(r0)     // Catch:{ all -> 0x0071 }
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch:{ all -> 0x0071 }
                com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState unused = r0.workerRunningState = r3     // Catch:{ all -> 0x0071 }
                r0 = 1
            L_0x002b:
                com.google.common.util.concurrent.SequentialExecutor r3 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch:{ all -> 0x0071 }
                java.util.Deque r3 = r3.queue     // Catch:{ all -> 0x0071 }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0071 }
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x0071 }
                if (r3 != 0) goto L_0x004b
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch:{ all -> 0x0071 }
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch:{ all -> 0x0071 }
                com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState unused = r0.workerRunningState = r3     // Catch:{ all -> 0x0071 }
                monitor-exit(r2)     // Catch:{ all -> 0x0071 }
                if (r1 == 0) goto L_0x004a
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x004a:
                return
            L_0x004b:
                monitor-exit(r2)     // Catch:{ all -> 0x0071 }
                boolean r2 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x0074 }
                r1 = r1 | r2
                r3.run()     // Catch:{ RuntimeException -> 0x0055 }
                goto L_0x0002
            L_0x0055:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.SequentialExecutor.log     // Catch:{ all -> 0x0074 }
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0074 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
                r6.<init>()     // Catch:{ all -> 0x0074 }
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch:{ all -> 0x0074 }
                r6.append(r3)     // Catch:{ all -> 0x0074 }
                java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0074 }
                r4.log(r5, r3, r2)     // Catch:{ all -> 0x0074 }
                goto L_0x0002
            L_0x0071:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0071 }
                throw r0     // Catch:{ all -> 0x0074 }
            L_0x0074:
                r0 = move-exception
                if (r1 == 0) goto L_0x007e
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L_0x007e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        public void run() {
            try {
                workOnQueue();
            } catch (Error e11) {
                synchronized (SequentialExecutor.this.queue) {
                    WorkerRunningState unused = SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e11;
                }
            }
        }
    }

    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public SequentialExecutor(Executor executor2) {
        this.executor = (Executor) Preconditions.checkNotNull(executor2);
    }

    public static /* synthetic */ long access$308(SequentialExecutor sequentialExecutor) {
        long j11 = sequentialExecutor.workerRunCount;
        sequentialExecutor.workerRunCount = 1 + j11;
        return j11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r8.executor.execute(r8.worker);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r8.workerRunningState == r9) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r6 = r8.queue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        if (r8.workerRunCount != r3) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r8.workerRunningState != r9) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        r8.workerRunningState = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004d, code lost:
        monitor-enter(r8.queue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r3 = r8.workerRunningState;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        if (r3 == com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0061, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0064, code lost:
        if ((r9 instanceof java.util.concurrent.RejectedExecutionException) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0069, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006a, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(final java.lang.Runnable r9) {
        /*
            r8 = this;
            com.google.common.base.Preconditions.checkNotNull(r9)
            java.util.Deque<java.lang.Runnable> r0 = r8.queue
            monitor-enter(r0)
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = r8.workerRunningState     // Catch:{ all -> 0x0075 }
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x0075 }
            if (r1 == r2) goto L_0x006e
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUED     // Catch:{ all -> 0x0075 }
            if (r1 != r2) goto L_0x0011
            goto L_0x006e
        L_0x0011:
            long r3 = r8.workerRunCount     // Catch:{ all -> 0x0075 }
            com.google.common.util.concurrent.SequentialExecutor$1 r1 = new com.google.common.util.concurrent.SequentialExecutor$1     // Catch:{ all -> 0x0075 }
            r1.<init>(r9)     // Catch:{ all -> 0x0075 }
            java.util.Deque<java.lang.Runnable> r9 = r8.queue     // Catch:{ all -> 0x0075 }
            r9.add(r1)     // Catch:{ all -> 0x0075 }
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r9 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x0075 }
            r8.workerRunningState = r9     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            r0 = 1
            r5 = 0
            java.util.concurrent.Executor r6 = r8.executor     // Catch:{ RuntimeException -> 0x004a, Error -> 0x0048 }
            com.google.common.util.concurrent.SequentialExecutor$QueueWorker r7 = r8.worker     // Catch:{ RuntimeException -> 0x004a, Error -> 0x0048 }
            r6.execute(r7)     // Catch:{ RuntimeException -> 0x004a, Error -> 0x0048 }
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = r8.workerRunningState
            if (r1 == r9) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = r5
        L_0x0031:
            if (r0 == 0) goto L_0x0034
            return
        L_0x0034:
            java.util.Deque<java.lang.Runnable> r6 = r8.queue
            monitor-enter(r6)
            long r0 = r8.workerRunCount     // Catch:{ all -> 0x0045 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0043
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = r8.workerRunningState     // Catch:{ all -> 0x0045 }
            if (r0 != r9) goto L_0x0043
            r8.workerRunningState = r2     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r6)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r9 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0045 }
            throw r9
        L_0x0048:
            r9 = move-exception
            goto L_0x004b
        L_0x004a:
            r9 = move-exception
        L_0x004b:
            java.util.Deque<java.lang.Runnable> r2 = r8.queue
            monitor-enter(r2)
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = r8.workerRunningState     // Catch:{ all -> 0x006b }
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r4 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch:{ all -> 0x006b }
            if (r3 == r4) goto L_0x0058
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r4 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x006b }
            if (r3 != r4) goto L_0x0061
        L_0x0058:
            java.util.Deque<java.lang.Runnable> r3 = r8.queue     // Catch:{ all -> 0x006b }
            boolean r1 = r3.removeLastOccurrence(r1)     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r0 = r5
        L_0x0062:
            boolean r1 = r9 instanceof java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x006a
            if (r0 != 0) goto L_0x006a
            monitor-exit(r2)     // Catch:{ all -> 0x006b }
            return
        L_0x006a:
            throw r9     // Catch:{ all -> 0x006b }
        L_0x006b:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x006b }
            throw r9
        L_0x006e:
            java.util.Deque<java.lang.Runnable> r1 = r8.queue     // Catch:{ all -> 0x0075 }
            r1.add(r9)     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            return
        L_0x0075:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.execute(java.lang.Runnable):void");
    }
}
