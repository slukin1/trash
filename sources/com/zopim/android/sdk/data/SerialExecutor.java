package com.zopim.android.sdk.data;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

class SerialExecutor implements Executor {
    public Runnable active;
    public final Executor executor;
    public final Queue<Runnable> tasks = new ArrayDeque();

    public SerialExecutor(Executor executor2) {
        this.executor = executor2;
    }

    public synchronized void execute(final Runnable runnable) {
        this.tasks.add(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    SerialExecutor.this.scheduleNext();
                }
            }
        });
        if (this.active == null) {
            scheduleNext();
        }
    }

    public synchronized void scheduleNext() {
        Runnable poll = this.tasks.poll();
        this.active = poll;
        if (poll != null) {
            this.executor.execute(poll);
        }
    }
}
