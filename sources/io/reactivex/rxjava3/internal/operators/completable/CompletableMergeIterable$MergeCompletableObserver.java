package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class CompletableMergeIterable$MergeCompletableObserver extends AtomicBoolean implements a, b {
    private static final long serialVersionUID = -7730517613164279224L;
    public final a downstream;
    public final CompositeDisposable set;
    public final AtomicInteger wip;

    public CompletableMergeIterable$MergeCompletableObserver(a aVar, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
        this.downstream = aVar;
        this.set = compositeDisposable;
        this.wip = atomicInteger;
    }

    public void dispose() {
        this.set.dispose();
        set(true);
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    public void onComplete() {
        if (this.wip.decrementAndGet() == 0) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.set.dispose();
        if (compareAndSet(false, true)) {
            this.downstream.onError(th2);
        } else {
            o00.a.n(th2);
        }
    }

    public void onSubscribe(b bVar) {
        this.set.a(bVar);
    }
}
