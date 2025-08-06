package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {

    /* renamed from: b  reason: collision with root package name */
    public static final long f55421b = TimeUnit.MINUTES.toNanos(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue());

    public static abstract class Worker implements io.reactivex.rxjava3.disposables.b {

        public final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final Runnable f55422b;

            /* renamed from: c  reason: collision with root package name */
            public final SequentialDisposable f55423c;

            /* renamed from: d  reason: collision with root package name */
            public final long f55424d;

            /* renamed from: e  reason: collision with root package name */
            public long f55425e;

            /* renamed from: f  reason: collision with root package name */
            public long f55426f;

            /* renamed from: g  reason: collision with root package name */
            public long f55427g;

            public a(long j11, Runnable runnable, long j12, SequentialDisposable sequentialDisposable, long j13) {
                this.f55422b = runnable;
                this.f55423c = sequentialDisposable;
                this.f55424d = j13;
                this.f55426f = j12;
                this.f55427g = j11;
            }

            public void run() {
                long j11;
                this.f55422b.run();
                if (!this.f55423c.isDisposed()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long a11 = worker.a(timeUnit);
                    long j12 = Scheduler.f55421b;
                    long j13 = this.f55426f;
                    if (a11 + j12 >= j13) {
                        long j14 = this.f55424d;
                        if (a11 < j13 + j14 + j12) {
                            long j15 = this.f55427g;
                            long j16 = this.f55425e + 1;
                            this.f55425e = j16;
                            j11 = j15 + (j16 * j14);
                            this.f55426f = a11;
                            this.f55423c.replace(Worker.this.c(this, j11 - a11, timeUnit));
                        }
                    }
                    long j17 = this.f55424d;
                    long j18 = a11 + j17;
                    long j19 = this.f55425e + 1;
                    this.f55425e = j19;
                    this.f55427g = j18 - (j17 * j19);
                    j11 = j18;
                    this.f55426f = a11;
                    this.f55423c.replace(Worker.this.c(this, j11 - a11, timeUnit));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public io.reactivex.rxjava3.disposables.b b(Runnable runnable) {
            return c(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract io.reactivex.rxjava3.disposables.b c(Runnable runnable, long j11, TimeUnit timeUnit);

        public io.reactivex.rxjava3.disposables.b d(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            long j13 = j11;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable p11 = o00.a.p(runnable);
            long nanos = timeUnit2.toNanos(j12);
            long a11 = a(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            a aVar = r0;
            a aVar2 = new a(a11 + timeUnit2.toNanos(j13), p11, a11, sequentialDisposable2, nanos);
            io.reactivex.rxjava3.disposables.b c11 = c(aVar, j13, timeUnit2);
            if (c11 == EmptyDisposable.INSTANCE) {
                return c11;
            }
            sequentialDisposable3.replace(c11);
            return sequentialDisposable2;
        }
    }

    public static final class a implements io.reactivex.rxjava3.disposables.b, Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f55429b;

        /* renamed from: c  reason: collision with root package name */
        public final Worker f55430c;

        /* renamed from: d  reason: collision with root package name */
        public Thread f55431d;

        public a(Runnable runnable, Worker worker) {
            this.f55429b = runnable;
            this.f55430c = worker;
        }

        public void dispose() {
            if (this.f55431d == Thread.currentThread()) {
                Worker worker = this.f55430c;
                if (worker instanceof io.reactivex.rxjava3.internal.schedulers.b) {
                    ((io.reactivex.rxjava3.internal.schedulers.b) worker).h();
                    return;
                }
            }
            this.f55430c.dispose();
        }

        public boolean isDisposed() {
            return this.f55430c.isDisposed();
        }

        public void run() {
            this.f55431d = Thread.currentThread();
            try {
                this.f55429b.run();
            } finally {
                dispose();
                this.f55431d = null;
            }
        }
    }

    public static final class b implements io.reactivex.rxjava3.disposables.b, Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f55432b;

        /* renamed from: c  reason: collision with root package name */
        public final Worker f55433c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f55434d;

        public b(Runnable runnable, Worker worker) {
            this.f55432b = runnable;
            this.f55433c = worker;
        }

        public void dispose() {
            this.f55434d = true;
            this.f55433c.dispose();
        }

        public boolean isDisposed() {
            return this.f55434d;
        }

        public void run() {
            if (!this.f55434d) {
                try {
                    this.f55432b.run();
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    this.f55433c.dispose();
                    throw ExceptionHelper.g(th2);
                }
            }
        }
    }

    public abstract Worker a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public io.reactivex.rxjava3.disposables.b c(Runnable runnable) {
        return d(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.rxjava3.disposables.b d(Runnable runnable, long j11, TimeUnit timeUnit) {
        Worker a11 = a();
        a aVar = new a(o00.a.p(runnable), a11);
        a11.c(aVar, j11, timeUnit);
        return aVar;
    }

    public io.reactivex.rxjava3.disposables.b e(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Worker a11 = a();
        b bVar = new b(o00.a.p(runnable), a11);
        io.reactivex.rxjava3.disposables.b d11 = a11.d(bVar, j11, j12, timeUnit);
        return d11 == EmptyDisposable.INSTANCE ? d11 : bVar;
    }
}
