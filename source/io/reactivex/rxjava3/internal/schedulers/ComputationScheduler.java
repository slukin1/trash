package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler {

    /* renamed from: e  reason: collision with root package name */
    public static final b f55622e;

    /* renamed from: f  reason: collision with root package name */
    public static final RxThreadFactory f55623f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f55624g = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* renamed from: h  reason: collision with root package name */
    public static final c f55625h;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadFactory f55626c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<b> f55627d;

    public static final class a extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final ListCompositeDisposable f55628b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f55629c;

        /* renamed from: d  reason: collision with root package name */
        public final ListCompositeDisposable f55630d;

        /* renamed from: e  reason: collision with root package name */
        public final c f55631e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f55632f;

        public a(c cVar) {
            this.f55631e = cVar;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.f55628b = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.f55629c = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.f55630d = listCompositeDisposable2;
            listCompositeDisposable2.a(listCompositeDisposable);
            listCompositeDisposable2.a(compositeDisposable);
        }

        public io.reactivex.rxjava3.disposables.b b(Runnable runnable) {
            if (this.f55632f) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f55631e.e(runnable, 0, TimeUnit.MILLISECONDS, this.f55628b);
        }

        public io.reactivex.rxjava3.disposables.b c(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (this.f55632f) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f55631e.e(runnable, j11, timeUnit, this.f55629c);
        }

        public void dispose() {
            if (!this.f55632f) {
                this.f55632f = true;
                this.f55630d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f55632f;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f55633a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f55634b;

        /* renamed from: c  reason: collision with root package name */
        public long f55635c;

        public b(int i11, ThreadFactory threadFactory) {
            this.f55633a = i11;
            this.f55634b = new c[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f55634b[i12] = new c(threadFactory);
            }
        }

        public c a() {
            int i11 = this.f55633a;
            if (i11 == 0) {
                return ComputationScheduler.f55625h;
            }
            c[] cVarArr = this.f55634b;
            long j11 = this.f55635c;
            this.f55635c = 1 + j11;
            return cVarArr[(int) (j11 % ((long) i11))];
        }

        public void b() {
            for (c dispose : this.f55634b) {
                dispose.dispose();
            }
        }
    }

    public static final class c extends b {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f55625h = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f55623f = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f55622e = bVar;
        bVar.b();
    }

    public ComputationScheduler() {
        this(f55623f);
    }

    public static int f(int i11, int i12) {
        return (i12 <= 0 || i12 > i11) ? i11 : i12;
    }

    public Scheduler.Worker a() {
        return new a(this.f55627d.get().a());
    }

    public io.reactivex.rxjava3.disposables.b d(Runnable runnable, long j11, TimeUnit timeUnit) {
        return this.f55627d.get().a().f(runnable, j11, timeUnit);
    }

    public io.reactivex.rxjava3.disposables.b e(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        return this.f55627d.get().a().g(runnable, j11, j12, timeUnit);
    }

    public void g() {
        b bVar = new b(f55624g, this.f55626c);
        if (!this.f55627d.compareAndSet(f55622e, bVar)) {
            bVar.b();
        }
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f55626c = threadFactory;
        this.f55627d = new AtomicReference<>(f55622e);
        g();
    }
}
