package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import h00.b;
import h00.e;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class CompletableMerge$CompletableMergeSubscriber extends AtomicInteger implements e<b>, io.reactivex.rxjava3.disposables.b {
    private static final long serialVersionUID = -2108443387387077490L;
    public final boolean delayErrors;
    public final a downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final int maxConcurrency;
    public final CompositeDisposable set = new CompositeDisposable();
    public d upstream;

    public final class MergeInnerObserver extends AtomicReference<io.reactivex.rxjava3.disposables.b> implements a, io.reactivex.rxjava3.disposables.b {
        private static final long serialVersionUID = 251330541679988317L;

        public MergeInnerObserver() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.rxjava3.disposables.b) get());
        }

        public void onComplete() {
            CompletableMerge$CompletableMergeSubscriber.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            CompletableMerge$CompletableMergeSubscriber.this.innerError(this, th2);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public CompletableMerge$CompletableMergeSubscriber(a aVar, int i11, boolean z11) {
        this.downstream = aVar;
        this.maxConcurrency = i11;
        this.delayErrors = z11;
        lazySet(1);
    }

    public void dispose() {
        this.upstream.cancel();
        this.set.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void innerComplete(MergeInnerObserver mergeInnerObserver) {
        this.set.b(mergeInnerObserver);
        if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer(this.downstream);
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
    }

    public void innerError(MergeInnerObserver mergeInnerObserver, Throwable th2) {
        this.set.b(mergeInnerObserver);
        if (!this.delayErrors) {
            this.upstream.cancel();
            this.set.dispose();
            if (this.errors.tryAddThrowableOrReport(th2) && getAndSet(0) > 0) {
                this.errors.tryTerminateConsumer(this.downstream);
            }
        } else if (!this.errors.tryAddThrowableOrReport(th2)) {
        } else {
            if (decrementAndGet() == 0) {
                this.errors.tryTerminateConsumer(this.downstream);
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1);
            }
        }
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    public void onComplete() {
        if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer(this.downstream);
        }
    }

    public void onError(Throwable th2) {
        if (!this.delayErrors) {
            this.set.dispose();
            if (this.errors.tryAddThrowableOrReport(th2) && getAndSet(0) > 0) {
                this.errors.tryTerminateConsumer(this.downstream);
            }
        } else if (this.errors.tryAddThrowableOrReport(th2) && decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer(this.downstream);
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

    public void onNext(b bVar) {
        getAndIncrement();
        MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
        this.set.a(mergeInnerObserver);
        bVar.a(mergeInnerObserver);
    }
}
