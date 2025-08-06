package io.reactivex.rxjava3.internal.operators.observable;

import h00.a;
import h00.k;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T> extends AtomicInteger implements b, k<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final a downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends h00.b> mapper;
    public final CompositeDisposable set = new CompositeDisposable();
    public b upstream;

    public final class InnerObserver extends AtomicReference<b> implements a, b {
        private static final long serialVersionUID = 8606673141535671828L;

        public InnerObserver() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void onComplete() {
            ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver.this.innerError(this, th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver(a aVar, h<? super T, ? extends h00.b> hVar, boolean z11) {
        this.downstream = aVar;
        this.mapper = hVar;
        this.delayErrors = z11;
        lazySet(1);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void innerComplete(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
        this.set.b(innerObserver);
        onComplete();
    }

    public void innerError(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
        this.set.b(innerObserver);
        onError(th2);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer(this.downstream);
        }
    }

    public void onError(Throwable th2) {
        if (!this.errors.tryAddThrowableOrReport(th2)) {
            return;
        }
        if (!this.delayErrors) {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
            this.errors.tryTerminateConsumer(this.downstream);
        } else if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer(this.downstream);
        }
    }

    public void onNext(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            h00.b bVar = (h00.b) apply;
            getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (!this.disposed && this.set.a(innerObserver)) {
                bVar.a(innerObserver);
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.upstream.dispose();
            onError(th2);
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
