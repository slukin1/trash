package io.reactivex.rxjava3.internal.operators.flowable;

import h00.a;
import h00.b;
import h00.e;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements e<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final c<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends b> mapper;
    public final int maxConcurrency;
    public final CompositeDisposable set = new CompositeDisposable();
    public d upstream;

    public final class InnerConsumer extends AtomicReference<io.reactivex.rxjava3.disposables.b> implements a, io.reactivex.rxjava3.disposables.b {
        private static final long serialVersionUID = 8606673141535671828L;

        public InnerConsumer() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.rxjava3.disposables.b) get());
        }

        public void onComplete() {
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerError(this, th2);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber(c<? super T> cVar, h<? super T, ? extends b> hVar, boolean z11, int i11) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.delayErrors = z11;
        this.maxConcurrency = i11;
        lazySet(1);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void clear() {
    }

    public void innerComplete(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
        this.set.b(innerConsumer);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th2) {
        this.set.b(innerConsumer);
        onError(th2);
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer((c<?>) this.downstream);
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
    }

    public void onError(Throwable th2) {
        if (!this.errors.tryAddThrowableOrReport(th2)) {
            return;
        }
        if (!this.delayErrors) {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
            this.errors.tryTerminateConsumer((c<?>) this.downstream);
        } else if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer((c<?>) this.downstream);
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
    }

    public void onNext(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            b bVar = (b) apply;
            getAndIncrement();
            InnerConsumer innerConsumer = new InnerConsumer();
            if (!this.cancelled && this.set.a(innerConsumer)) {
                bVar.a(innerConsumer);
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.upstream.cancel();
            onError(th2);
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            int i11 = this.maxConcurrency;
            if (i11 == Integer.MAX_VALUE) {
                dVar.request(Long.MAX_VALUE);
            } else {
                dVar.request((long) i11);
            }
        }
    }

    public T poll() {
        return null;
    }

    public void request(long j11) {
    }

    public int requestFusion(int i11) {
        return i11 & 2;
    }
}
