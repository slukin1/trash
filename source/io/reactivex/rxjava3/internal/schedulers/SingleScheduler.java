package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {

    /* renamed from: e  reason: collision with root package name */
    public static final RxThreadFactory f55661e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);

    /* renamed from: f  reason: collision with root package name */
    public static final ScheduledExecutorService f55662f;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadFactory f55663c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f55664d;

    public static final class a extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final ScheduledExecutorService f55665b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f55666c = new CompositeDisposable();

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f55667d;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f55665b = scheduledExecutorService;
        }

        public b c(Runnable runnable, long j11, TimeUnit timeUnit) {
            Future future;
            if (this.f55667d) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(o00.a.p(runnable), this.f55666c);
            this.f55666c.a(scheduledRunnable);
            if (j11 <= 0) {
                try {
                    future = this.f55665b.submit(scheduledRunnable);
                } catch (RejectedExecutionException e11) {
                    dispose();
                    o00.a.n(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f55665b.schedule(scheduledRunnable, j11, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.f55667d) {
                this.f55667d = true;
                this.f55666c.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f55667d;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f55662f = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(f55661e);
    }

    public static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return d.a(threadFactory);
    }

    public Scheduler.Worker a() {
        return new a(this.f55664d.get());
    }

    public b d(Runnable runnable, long j11, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(o00.a.p(runnable));
        if (j11 <= 0) {
            try {
                future = this.f55664d.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e11) {
                o00.a.n(e11);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f55664d.get().schedule(scheduledDirectTask, j11, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public b e(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Future future;
        Runnable p11 = o00.a.p(runnable);
        if (j12 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f55664d.get();
            a aVar = new a(p11, scheduledExecutorService);
            if (j11 <= 0) {
                try {
                    future = scheduledExecutorService.submit(aVar);
                } catch (RejectedExecutionException e11) {
                    o00.a.n(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(aVar, j11, timeUnit);
            }
            aVar.b(future);
            return aVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(p11);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f55664d.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e12) {
            o00.a.n(e12);
            return EmptyDisposable.INSTANCE;
        }
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f55664d = atomicReference;
        this.f55663c = threadFactory;
        atomicReference.lazySet(f(threadFactory));
    }
}
