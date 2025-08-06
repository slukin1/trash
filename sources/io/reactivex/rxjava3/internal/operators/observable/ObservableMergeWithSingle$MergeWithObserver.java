package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import h00.m;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.e;

final class ObservableMergeWithSingle$MergeWithObserver<T> extends AtomicInteger implements k<T>, b {
    public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    public static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    public volatile boolean disposed;
    public final k<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicReference<b> mainDisposable = new AtomicReference<>();
    public volatile boolean mainDone;
    public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
    public volatile int otherState;
    public volatile e<T> queue;
    public T singleItem;

    public static final class OtherObserver<T> extends AtomicReference<b> implements m<T> {
        private static final long serialVersionUID = -2935427570954647017L;
        public final ObservableMergeWithSingle$MergeWithObserver<T> parent;

        public OtherObserver(ObservableMergeWithSingle$MergeWithObserver<T> observableMergeWithSingle$MergeWithObserver) {
            this.parent = observableMergeWithSingle$MergeWithObserver;
        }

        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(T t11) {
            this.parent.otherSuccess(t11);
        }
    }

    public ObservableMergeWithSingle$MergeWithObserver(k<? super T> kVar) {
        this.downstream = kVar;
    }

    public void dispose() {
        this.disposed = true;
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue = null;
            this.singleItem = null;
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        k<? super T> kVar = this.downstream;
        int i11 = 1;
        while (!this.disposed) {
            if (this.errors.get() != null) {
                this.singleItem = null;
                this.queue = null;
                this.errors.tryTerminateConsumer((k<?>) kVar);
                return;
            }
            int i12 = this.otherState;
            if (i12 == 1) {
                T t11 = this.singleItem;
                this.singleItem = null;
                this.otherState = 2;
                kVar.onNext(t11);
                i12 = 2;
            }
            boolean z11 = this.mainDone;
            e<T> eVar = this.queue;
            T poll = eVar != null ? eVar.poll() : null;
            boolean z12 = poll == null;
            if (z11 && z12 && i12 == 2) {
                this.queue = null;
                kVar.onComplete();
                return;
            } else if (z12) {
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                kVar.onNext(poll);
            }
        }
        this.singleItem = null;
        this.queue = null;
    }

    public e<T> getOrCreateQueue() {
        e<T> eVar = this.queue;
        if (eVar != null) {
            return eVar;
        }
        a aVar = new a(Observable.a());
        this.queue = aVar;
        return aVar;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            DisposableHelper.dispose(this.otherObserver);
            drain();
        }
    }

    public void onNext(T t11) {
        if (compareAndSet(0, 1)) {
            this.downstream.onNext(t11);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            getOrCreateQueue().offer(t11);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.mainDisposable, bVar);
    }

    public void otherError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            DisposableHelper.dispose(this.mainDisposable);
            drain();
        }
    }

    public void otherSuccess(T t11) {
        if (compareAndSet(0, 1)) {
            this.downstream.onNext(t11);
            this.otherState = 2;
        } else {
            this.singleItem = t11;
            this.otherState = 1;
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }
}
