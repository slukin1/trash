package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class TestScheduler extends Scheduler {

    /* renamed from: c  reason: collision with root package name */
    public final Queue<b> f55746c = new PriorityBlockingQueue(11);

    /* renamed from: d  reason: collision with root package name */
    public long f55747d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f55748e;

    public final class a extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f55749b;

        /* renamed from: io.reactivex.rxjava3.schedulers.TestScheduler$a$a  reason: collision with other inner class name */
        public final class C0657a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final b f55751b;

            public C0657a(b bVar) {
                this.f55751b = bVar;
            }

            public void run() {
                TestScheduler.this.f55746c.remove(this.f55751b);
            }
        }

        public a() {
        }

        public long a(TimeUnit timeUnit) {
            return TestScheduler.this.b(timeUnit);
        }

        public io.reactivex.rxjava3.disposables.b b(Runnable runnable) {
            if (this.f55749b) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j11 = testScheduler.f55747d;
            testScheduler.f55747d = 1 + j11;
            b bVar = new b(this, 0, runnable, j11);
            TestScheduler.this.f55746c.add(bVar);
            return io.reactivex.rxjava3.disposables.a.b(new C0657a(bVar));
        }

        public io.reactivex.rxjava3.disposables.b c(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (this.f55749b) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.f55748e + timeUnit.toNanos(j11);
            TestScheduler testScheduler = TestScheduler.this;
            long j12 = testScheduler.f55747d;
            testScheduler.f55747d = 1 + j12;
            b bVar = new b(this, nanos, runnable, j12);
            TestScheduler.this.f55746c.add(bVar);
            return io.reactivex.rxjava3.disposables.a.b(new C0657a(bVar));
        }

        public void dispose() {
            this.f55749b = true;
        }

        public boolean isDisposed() {
            return this.f55749b;
        }
    }

    public static final class b implements Comparable<b> {

        /* renamed from: b  reason: collision with root package name */
        public final long f55753b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f55754c;

        /* renamed from: d  reason: collision with root package name */
        public final a f55755d;

        /* renamed from: e  reason: collision with root package name */
        public final long f55756e;

        public b(a aVar, long j11, Runnable runnable, long j12) {
            this.f55753b = j11;
            this.f55754c = runnable;
            this.f55755d = aVar;
            this.f55756e = j12;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            long j11 = this.f55753b;
            long j12 = bVar.f55753b;
            if (j11 == j12) {
                return Long.compare(this.f55756e, bVar.f55756e);
            }
            return Long.compare(j11, j12);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", new Object[]{Long.valueOf(this.f55753b), this.f55754c.toString()});
        }
    }

    public Scheduler.Worker a() {
        return new a();
    }

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(this.f55748e, TimeUnit.NANOSECONDS);
    }
}
