package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler extends Scheduler {

    /* renamed from: e  reason: collision with root package name */
    public static final RxThreadFactory f55636e;

    /* renamed from: f  reason: collision with root package name */
    public static final RxThreadFactory f55637f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f55638g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f55639h = TimeUnit.SECONDS;

    /* renamed from: i  reason: collision with root package name */
    public static final c f55640i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f55641j;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadFactory f55642c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<a> f55643d;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final long f55644b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f55645c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f55646d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f55647e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f55648f;

        /* renamed from: g  reason: collision with root package name */
        public final ThreadFactory f55649g;

        public a(long j11, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j11) : 0;
            this.f55644b = nanos;
            this.f55645c = new ConcurrentLinkedQueue<>();
            this.f55646d = new CompositeDisposable();
            this.f55649g = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f55637f);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f55647e = scheduledExecutorService;
            this.f55648f = scheduledFuture;
        }

        public static void a(ConcurrentLinkedQueue<c> concurrentLinkedQueue, CompositeDisposable compositeDisposable) {
            if (!concurrentLinkedQueue.isEmpty()) {
                long c11 = c();
                Iterator<c> it2 = concurrentLinkedQueue.iterator();
                while (it2.hasNext()) {
                    c next = it2.next();
                    if (next.i() > c11) {
                        return;
                    }
                    if (concurrentLinkedQueue.remove(next)) {
                        compositeDisposable.c(next);
                    }
                }
            }
        }

        public static long c() {
            return System.nanoTime();
        }

        public c b() {
            if (this.f55646d.isDisposed()) {
                return IoScheduler.f55640i;
            }
            while (!this.f55645c.isEmpty()) {
                c poll = this.f55645c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f55649g);
            this.f55646d.a(cVar);
            return cVar;
        }

        public void d(c cVar) {
            cVar.j(c() + this.f55644b);
            this.f55645c.offer(cVar);
        }

        public void e() {
            this.f55646d.dispose();
            Future<?> future = this.f55648f;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f55647e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            a(this.f55645c, this.f55646d);
        }
    }

    public static final class b extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f55650b;

        /* renamed from: c  reason: collision with root package name */
        public final a f55651c;

        /* renamed from: d  reason: collision with root package name */
        public final c f55652d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f55653e = new AtomicBoolean();

        public b(a aVar) {
            this.f55651c = aVar;
            this.f55650b = new CompositeDisposable();
            this.f55652d = aVar.b();
        }

        public io.reactivex.rxjava3.disposables.b c(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (this.f55650b.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f55652d.e(runnable, j11, timeUnit, this.f55650b);
        }

        public void dispose() {
            if (this.f55653e.compareAndSet(false, true)) {
                this.f55650b.dispose();
                this.f55651c.d(this.f55652d);
            }
        }

        public boolean isDisposed() {
            return this.f55653e.get();
        }
    }

    public static final class c extends b {

        /* renamed from: d  reason: collision with root package name */
        public long f55654d = 0;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long i() {
            return this.f55654d;
        }

        public void j(long j11) {
            this.f55654d = j11;
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f55640i = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f55636e = rxThreadFactory;
        f55637f = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0, (TimeUnit) null, rxThreadFactory);
        f55641j = aVar;
        aVar.e();
    }

    public IoScheduler() {
        this(f55636e);
    }

    public Scheduler.Worker a() {
        return new b(this.f55643d.get());
    }

    public void f() {
        a aVar = new a(f55638g, f55639h, this.f55642c);
        if (!this.f55643d.compareAndSet(f55641j, aVar)) {
            aVar.e();
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f55642c = threadFactory;
        this.f55643d = new AtomicReference<>(f55641j);
        f();
    }
}
