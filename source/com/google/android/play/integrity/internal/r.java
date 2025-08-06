package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TaskCompletionSource f66888a;

    public r() {
        this.f66888a = null;
    }

    public r(TaskCompletionSource taskCompletionSource) {
        this.f66888a = taskCompletionSource;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f66888a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    public abstract void b();

    public final TaskCompletionSource c() {
        return this.f66888a;
    }

    public final void run() {
        try {
            b();
        } catch (Exception e11) {
            a(e11);
        }
    }
}
