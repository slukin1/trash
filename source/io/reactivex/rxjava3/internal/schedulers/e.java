package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class e extends Scheduler {

    /* renamed from: c  reason: collision with root package name */
    public static final e f55680c = new e();

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f55681b;

        /* renamed from: c  reason: collision with root package name */
        public final c f55682c;

        /* renamed from: d  reason: collision with root package name */
        public final long f55683d;

        public a(Runnable runnable, c cVar, long j11) {
            this.f55681b = runnable;
            this.f55682c = cVar;
            this.f55683d = j11;
        }

        public void run() {
            if (!this.f55682c.f55691e) {
                long a11 = this.f55682c.a(TimeUnit.MILLISECONDS);
                long j11 = this.f55683d;
                if (j11 > a11) {
                    try {
                        Thread.sleep(j11 - a11);
                    } catch (InterruptedException e11) {
                        Thread.currentThread().interrupt();
                        o00.a.n(e11);
                        return;
                    }
                }
                if (!this.f55682c.f55691e) {
                    this.f55681b.run();
                }
            }
        }
    }

    public static final class b implements Comparable<b> {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f55684b;

        /* renamed from: c  reason: collision with root package name */
        public final long f55685c;

        /* renamed from: d  reason: collision with root package name */
        public final int f55686d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f55687e;

        public b(Runnable runnable, Long l11, int i11) {
            this.f55684b = runnable;
            this.f55685c = l11.longValue();
            this.f55686d = i11;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int compare = Long.compare(this.f55685c, bVar.f55685c);
            return compare == 0 ? Integer.compare(this.f55686d, bVar.f55686d) : compare;
        }
    }

    public static final class c extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f55688b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f55689c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f55690d = new AtomicInteger();

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f55691e;

        public final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final b f55692b;

            public a(b bVar) {
                this.f55692b = bVar;
            }

            public void run() {
                this.f55692b.f55687e = true;
                c.this.f55688b.remove(this.f55692b);
            }
        }

        public io.reactivex.rxjava3.disposables.b b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        public io.reactivex.rxjava3.disposables.b c(Runnable runnable, long j11, TimeUnit timeUnit) {
            long a11 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j11);
            return e(new a(runnable, this, a11), a11);
        }

        public void dispose() {
            this.f55691e = true;
        }

        public io.reactivex.rxjava3.disposables.b e(Runnable runnable, long j11) {
            if (this.f55691e) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j11), this.f55690d.incrementAndGet());
            this.f55688b.add(bVar);
            if (this.f55689c.getAndIncrement() != 0) {
                return io.reactivex.rxjava3.disposables.a.b(new a(bVar));
            }
            int i11 = 1;
            while (!this.f55691e) {
                b poll = this.f55688b.poll();
                if (poll == null) {
                    i11 = this.f55689c.addAndGet(-i11);
                    if (i11 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f55687e) {
                    poll.f55684b.run();
                }
            }
            this.f55688b.clear();
            return EmptyDisposable.INSTANCE;
        }

        public boolean isDisposed() {
            return this.f55691e;
        }
    }

    public static e f() {
        return f55680c;
    }

    public Scheduler.Worker a() {
        return new c();
    }

    public io.reactivex.rxjava3.disposables.b c(Runnable runnable) {
        o00.a.p(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public io.reactivex.rxjava3.disposables.b d(Runnable runnable, long j11, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j11);
            o00.a.p(runnable).run();
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            o00.a.n(e11);
        }
        return EmptyDisposable.INSTANCE;
    }
}
