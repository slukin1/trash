package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import o00.a;

public class b extends Scheduler.Worker {

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f55674b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f55675c;

    public b(ThreadFactory threadFactory) {
        this.f55674b = d.a(threadFactory);
    }

    public io.reactivex.rxjava3.disposables.b b(Runnable runnable) {
        return c(runnable, 0, (TimeUnit) null);
    }

    public io.reactivex.rxjava3.disposables.b c(Runnable runnable, long j11, TimeUnit timeUnit) {
        if (this.f55675c) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j11, timeUnit, (c) null);
    }

    public void dispose() {
        if (!this.f55675c) {
            this.f55675c = true;
            this.f55674b.shutdownNow();
        }
    }

    public ScheduledRunnable e(Runnable runnable, long j11, TimeUnit timeUnit, c cVar) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(a.p(runnable), cVar);
        if (cVar != null && !cVar.a(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j11 <= 0) {
            try {
                future = this.f55674b.submit(scheduledRunnable);
            } catch (RejectedExecutionException e11) {
                if (cVar != null) {
                    cVar.c(scheduledRunnable);
                }
                a.n(e11);
            }
        } else {
            future = this.f55674b.schedule(scheduledRunnable, j11, timeUnit);
        }
        scheduledRunnable.setFuture(future);
        return scheduledRunnable;
    }

    public io.reactivex.rxjava3.disposables.b f(Runnable runnable, long j11, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(a.p(runnable));
        if (j11 <= 0) {
            try {
                future = this.f55674b.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e11) {
                a.n(e11);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f55674b.schedule(scheduledDirectTask, j11, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public io.reactivex.rxjava3.disposables.b g(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Future future;
        Runnable p11 = a.p(runnable);
        if (j12 <= 0) {
            a aVar = new a(p11, this.f55674b);
            if (j11 <= 0) {
                try {
                    future = this.f55674b.submit(aVar);
                } catch (RejectedExecutionException e11) {
                    a.n(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f55674b.schedule(aVar, j11, timeUnit);
            }
            aVar.b(future);
            return aVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(p11);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f55674b.scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e12) {
            a.n(e12);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void h() {
        if (!this.f55675c) {
            this.f55675c = true;
            this.f55674b.shutdown();
        }
    }

    public boolean isDisposed() {
        return this.f55675c;
    }
}
