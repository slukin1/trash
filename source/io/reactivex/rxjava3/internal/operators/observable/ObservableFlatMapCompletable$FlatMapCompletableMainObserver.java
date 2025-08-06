package io.reactivex.rxjava3.internal.operators.observable;

import h00.a;
import h00.b;
import h00.k;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements k<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final k<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends b> mapper;
    public final CompositeDisposable set = new CompositeDisposable();
    public io.reactivex.rxjava3.disposables.b upstream;

    public final class InnerObserver extends AtomicReference<io.reactivex.rxjava3.disposables.b> implements a, io.reactivex.rxjava3.disposables.b {
        private static final long serialVersionUID = 8606673141535671828L;

        public InnerObserver() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.rxjava3.disposables.b) get());
        }

        public void onComplete() {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerError(this, th2);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableFlatMapCompletable$FlatMapCompletableMainObserver(k<? super T> kVar, h<? super T, ? extends b> hVar, boolean z11) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.delayErrors = z11;
        lazySet(1);
    }

    public void clear() {
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void innerComplete(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
        this.set.b(innerObserver);
        onComplete();
    }

    public void innerError(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
        this.set.b(innerObserver);
        onError(th2);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer((k<?>) this.downstream);
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
            this.errors.tryTerminateConsumer((k<?>) this.downstream);
        } else if (decrementAndGet() == 0) {
            this.errors.tryTerminateConsumer((k<?>) this.downstream);
        }
    }

    public void onNext(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            b bVar = (b) apply;
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

    public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public T poll() {
        return null;
    }

    public int requestFusion(int i11) {
        return i11 & 2;
    }
}
