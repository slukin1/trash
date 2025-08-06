package okhttp3.internal.concurrent;

import d10.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import kotlin.Unit;
import okhttp3.internal.Util;

public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks = new ArrayList();
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    public static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch = new CountDownLatch(1);

        public AwaitIdleTask() {
            super(Util.okHttpName + " awaitIdle", false);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    public TaskQueue(TaskRunner taskRunner2, String str) {
        this.taskRunner = taskRunner2;
        this.name = str;
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j11, boolean z11, a aVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        taskQueue.schedule(new TaskQueue$execute$1(str, z11, aVar), j11);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        taskQueue.schedule(task, j11);
    }

    public final void cancelAll() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.f56620a;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null && task.getCancelable()) {
            this.cancelActiveTask = true;
        }
        boolean z11 = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Task task2 = this.futureTasks.get(size);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z11 = true;
            }
        }
        return z11;
    }

    public final void execute(String str, long j11, boolean z11, a<Unit> aVar) {
        schedule(new TaskQueue$execute$1(str, z11, aVar), j11);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> I0;
        synchronized (this.taskRunner) {
            I0 = CollectionsKt___CollectionsKt.I0(this.futureTasks);
        }
        return I0;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask != null || !this.futureTasks.isEmpty()) {
                Task task = this.activeTask;
                if (task instanceof AwaitIdleTask) {
                    CountDownLatch latch = ((AwaitIdleTask) task).getLatch();
                    return latch;
                }
                for (Task next : this.futureTasks) {
                    if (next instanceof AwaitIdleTask) {
                        CountDownLatch latch2 = ((AwaitIdleTask) next).getLatch();
                        return latch2;
                    }
                }
                AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
                if (scheduleAndDecide$okhttp(awaitIdleTask, 0, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                CountDownLatch latch3 = awaitIdleTask.getLatch();
                return latch3;
            }
            CountDownLatch countDownLatch = new CountDownLatch(0);
            return countDownLatch;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void schedule(okhttp3.internal.concurrent.Task r3, long r4) {
        /*
            r2 = this;
            okhttp3.internal.concurrent.TaskRunner r0 = r2.taskRunner
            monitor-enter(r0)
            boolean r1 = r2.shutdown     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x003b
            boolean r4 = r3.getCancelable()     // Catch:{ all -> 0x004b }
            if (r4 == 0) goto L_0x0022
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x004b }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x004b }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x004b }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x004b }
            if (r4 == 0) goto L_0x0020
            java.lang.String r4 = "schedule canceled (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x004b }
        L_0x0020:
            monitor-exit(r0)
            return
        L_0x0022:
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x004b }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x004b }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x004b }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x004b }
            if (r4 == 0) goto L_0x0035
            java.lang.String r4 = "schedule failed (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x004b }
        L_0x0035:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x004b }
            r3.<init>()     // Catch:{ all -> 0x004b }
            throw r3     // Catch:{ all -> 0x004b }
        L_0x003b:
            r1 = 0
            boolean r3 = r2.scheduleAndDecide$okhttp(r3, r4, r1)     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x0047
            okhttp3.internal.concurrent.TaskRunner r3 = r2.taskRunner     // Catch:{ all -> 0x004b }
            r3.kickCoordinator$okhttp(r2)     // Catch:{ all -> 0x004b }
        L_0x0047:
            kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x004b }
            monitor-exit(r0)
            return
        L_0x004b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskQueue.schedule(okhttp3.internal.concurrent.Task, long):void");
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j11, boolean z11) {
        String str;
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j12 = nanoTime + j11;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j12) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j12);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z11) {
                str = "run again after " + TaskLoggerKt.formatDuration(j12 - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j12 - nanoTime);
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it2 = this.futureTasks.iterator();
        int i11 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i11 = -1;
                break;
            }
            if (it2.next().getNextExecuteNanoTime$okhttp() - nanoTime > j11) {
                break;
            }
            i11++;
        }
        if (i11 == -1) {
            i11 = this.futureTasks.size();
        }
        this.futureTasks.add(i11, task);
        if (i11 == 0) {
            return true;
        }
        return false;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z11) {
        this.cancelActiveTask = z11;
    }

    public final void setShutdown$okhttp(boolean z11) {
        this.shutdown = z11;
    }

    public final void shutdown() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.f56620a;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j11, a aVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        taskQueue.schedule(new TaskQueue$schedule$2(str, aVar), j11);
    }

    public final void schedule(String str, long j11, a<Long> aVar) {
        schedule(new TaskQueue$schedule$2(str, aVar), j11);
    }
}
