package okhttp3.internal.concurrent;

import kotlin.jvm.internal.r;

public abstract class Task {
    private final boolean cancelable;
    private final String name;
    private long nextExecuteNanoTime;
    private TaskQueue queue;

    public Task(String str, boolean z11) {
        this.name = str;
        this.cancelable = z11;
        this.nextExecuteNanoTime = -1;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(TaskQueue taskQueue) {
        TaskQueue taskQueue2 = this.queue;
        if (taskQueue2 != taskQueue) {
            if (taskQueue2 == null) {
                this.queue = taskQueue;
                return;
            }
            throw new IllegalStateException("task is in multiple queues".toString());
        }
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long j11) {
        this.nextExecuteNanoTime = j11;
    }

    public final void setQueue$okhttp(TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    public String toString() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Task(String str, boolean z11, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? true : z11);
    }
}
