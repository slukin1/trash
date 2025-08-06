package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.exceptions.a;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th2) {
            a.b(th2);
            this.runner = null;
            lazySet(AbstractDirectTask.FINISHED);
            o00.a.n(th2);
        }
    }
}
