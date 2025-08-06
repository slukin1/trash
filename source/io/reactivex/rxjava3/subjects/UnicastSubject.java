package io.reactivex.rxjava3.subjects;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;

public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: b  reason: collision with root package name */
    public final a<T> f55774b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<k<? super T>> f55775c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Runnable> f55776d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f55777e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f55778f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f55779g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f55780h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f55781i = new AtomicBoolean();

    /* renamed from: j  reason: collision with root package name */
    public final BasicIntQueueDisposable<T> f55782j = new UnicastQueueDisposable();

    /* renamed from: k  reason: collision with root package name */
    public boolean f55783k;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        public void clear() {
            UnicastSubject.this.f55774b.clear();
        }

        public void dispose() {
            if (!UnicastSubject.this.f55778f) {
                UnicastSubject.this.f55778f = true;
                UnicastSubject.this.e();
                UnicastSubject.this.f55775c.lazySet((Object) null);
                if (UnicastSubject.this.f55782j.getAndIncrement() == 0) {
                    UnicastSubject.this.f55775c.lazySet((Object) null);
                    UnicastSubject unicastSubject = UnicastSubject.this;
                    if (!unicastSubject.f55783k) {
                        unicastSubject.f55774b.clear();
                    }
                }
            }
        }

        public boolean isDisposed() {
            return UnicastSubject.this.f55778f;
        }

        public boolean isEmpty() {
            return UnicastSubject.this.f55774b.isEmpty();
        }

        public T poll() {
            return UnicastSubject.this.f55774b.poll();
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f55783k = true;
            return 2;
        }
    }

    public UnicastSubject(int i11, Runnable runnable, boolean z11) {
        this.f55774b = new a<>(i11);
        this.f55776d = new AtomicReference<>(runnable);
        this.f55777e = z11;
    }

    public static <T> UnicastSubject<T> c() {
        return new UnicastSubject<>(Observable.a(), (Runnable) null, true);
    }

    public static <T> UnicastSubject<T> d(int i11, Runnable runnable) {
        io.reactivex.rxjava3.internal.functions.a.a(i11, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i11, runnable, true);
    }

    public void b(k<? super T> kVar) {
        if (this.f55781i.get() || !this.f55781i.compareAndSet(false, true)) {
            EmptyDisposable.error((Throwable) new IllegalStateException("Only a single observer allowed."), (k<?>) kVar);
            return;
        }
        kVar.onSubscribe(this.f55782j);
        this.f55775c.lazySet(kVar);
        if (this.f55778f) {
            this.f55775c.lazySet((Object) null);
        } else {
            f();
        }
    }

    public void e() {
        Runnable runnable = this.f55776d.get();
        if (runnable != null && this.f55776d.compareAndSet(runnable, (Object) null)) {
            runnable.run();
        }
    }

    public void f() {
        if (this.f55782j.getAndIncrement() == 0) {
            k kVar = this.f55775c.get();
            int i11 = 1;
            while (kVar == null) {
                i11 = this.f55782j.addAndGet(-i11);
                if (i11 != 0) {
                    kVar = this.f55775c.get();
                } else {
                    return;
                }
            }
            if (this.f55783k) {
                g(kVar);
            } else {
                h(kVar);
            }
        }
    }

    public void g(k<? super T> kVar) {
        a<T> aVar = this.f55774b;
        int i11 = 1;
        boolean z11 = !this.f55777e;
        while (!this.f55778f) {
            boolean z12 = this.f55779g;
            if (!z11 || !z12 || !j(aVar, kVar)) {
                kVar.onNext(null);
                if (z12) {
                    i(kVar);
                    return;
                }
                i11 = this.f55782j.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f55775c.lazySet((Object) null);
    }

    public void h(k<? super T> kVar) {
        a<T> aVar = this.f55774b;
        boolean z11 = !this.f55777e;
        boolean z12 = true;
        int i11 = 1;
        while (!this.f55778f) {
            boolean z13 = this.f55779g;
            T poll = this.f55774b.poll();
            boolean z14 = poll == null;
            if (z13) {
                if (z11 && z12) {
                    if (!j(aVar, kVar)) {
                        z12 = false;
                    } else {
                        return;
                    }
                }
                if (z14) {
                    i(kVar);
                    return;
                }
            }
            if (z14) {
                i11 = this.f55782j.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                kVar.onNext(poll);
            }
        }
        this.f55775c.lazySet((Object) null);
        aVar.clear();
    }

    public void i(k<? super T> kVar) {
        this.f55775c.lazySet((Object) null);
        Throwable th2 = this.f55780h;
        if (th2 != null) {
            kVar.onError(th2);
        } else {
            kVar.onComplete();
        }
    }

    public boolean j(f<T> fVar, k<? super T> kVar) {
        Throwable th2 = this.f55780h;
        if (th2 == null) {
            return false;
        }
        this.f55775c.lazySet((Object) null);
        fVar.clear();
        kVar.onError(th2);
        return true;
    }

    public void onComplete() {
        if (!this.f55779g && !this.f55778f) {
            this.f55779g = true;
            e();
            f();
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f55779g || this.f55778f) {
            o00.a.n(th2);
            return;
        }
        this.f55780h = th2;
        this.f55779g = true;
        e();
        f();
    }

    public void onNext(T t11) {
        ExceptionHelper.c(t11, "onNext called with a null value.");
        if (!this.f55779g && !this.f55778f) {
            this.f55774b.offer(t11);
            f();
        }
    }

    public void onSubscribe(b bVar) {
        if (this.f55779g || this.f55778f) {
            bVar.dispose();
        }
    }
}
