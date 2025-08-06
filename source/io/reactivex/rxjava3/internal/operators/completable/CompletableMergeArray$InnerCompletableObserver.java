package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class CompletableMergeArray$InnerCompletableObserver extends AtomicInteger implements a, b {
    private static final long serialVersionUID = -8360547806504310570L;
    public final a downstream;
    public final AtomicBoolean once;
    public final CompositeDisposable set;

    public CompletableMergeArray$InnerCompletableObserver(a aVar, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i11) {
        this.downstream = aVar;
        this.once = atomicBoolean;
        this.set = compositeDisposable;
        lazySet(i11);
    }

    public void dispose() {
        this.set.dispose();
        this.once.set(true);
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    public void onComplete() {
        if (decrementAndGet() == 0) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onError(th2);
        } else {
            o00.a.n(th2);
        }
    }

    public void onSubscribe(b bVar) {
        this.set.a(bVar);
    }
}
