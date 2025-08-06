package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.c;
import z20.d;

final class FlowableDebounce$DebounceSubscriber<T, U> extends AtomicLong implements e<T>, d {
    private static final long serialVersionUID = 6725975399620862591L;
    public final h<? super T, ? extends b<U>> debounceSelector;
    public final AtomicReference<io.reactivex.rxjava3.disposables.b> debouncer = new AtomicReference<>();
    public boolean done;
    public final c<? super T> downstream;
    public volatile long index;
    public d upstream;

    public static final class a<T, U> extends DisposableSubscriber<U> {

        /* renamed from: c  reason: collision with root package name */
        public final FlowableDebounce$DebounceSubscriber<T, U> f55477c;

        /* renamed from: d  reason: collision with root package name */
        public final long f55478d;

        /* renamed from: e  reason: collision with root package name */
        public final T f55479e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f55480f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicBoolean f55481g = new AtomicBoolean();

        public a(FlowableDebounce$DebounceSubscriber<T, U> flowableDebounce$DebounceSubscriber, long j11, T t11) {
            this.f55477c = flowableDebounce$DebounceSubscriber;
            this.f55478d = j11;
            this.f55479e = t11;
        }

        public void c() {
            if (this.f55481g.compareAndSet(false, true)) {
                this.f55477c.emit(this.f55478d, this.f55479e);
            }
        }

        public void onComplete() {
            if (!this.f55480f) {
                this.f55480f = true;
                c();
            }
        }

        public void onError(Throwable th2) {
            if (this.f55480f) {
                o00.a.n(th2);
                return;
            }
            this.f55480f = true;
            this.f55477c.onError(th2);
        }

        public void onNext(U u11) {
            if (!this.f55480f) {
                this.f55480f = true;
                a();
                c();
            }
        }
    }

    public FlowableDebounce$DebounceSubscriber(c<? super T> cVar, h<? super T, ? extends b<U>> hVar) {
        this.downstream = cVar;
        this.debounceSelector = hVar;
    }

    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    public void emit(long j11, T t11) {
        if (j11 != this.index) {
            return;
        }
        if (get() != 0) {
            this.downstream.onNext(t11);
            io.reactivex.rxjava3.internal.util.b.e(this, 1);
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            io.reactivex.rxjava3.disposables.b bVar = this.debouncer.get();
            if (!DisposableHelper.isDisposed(bVar)) {
                a aVar = (a) bVar;
                if (aVar != null) {
                    aVar.c();
                }
                DisposableHelper.dispose(this.debouncer);
                this.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            long j11 = this.index + 1;
            this.index = j11;
            io.reactivex.rxjava3.disposables.b bVar = this.debouncer.get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                Object apply = this.debounceSelector.apply(t11);
                Objects.requireNonNull(apply, "The publisher supplied is null");
                b bVar2 = (b) apply;
                a aVar = new a(this, j11, t11);
                if (this.debouncer.compareAndSet(bVar, aVar)) {
                    bVar2.subscribe(aVar);
                }
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this, j11);
        }
    }
}
