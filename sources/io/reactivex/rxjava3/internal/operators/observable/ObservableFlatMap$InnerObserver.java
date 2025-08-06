package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;

final class ObservableFlatMap$InnerObserver<T, U> extends AtomicReference<b> implements k<U> {
    private static final long serialVersionUID = -4606175640614850599L;
    public volatile boolean done;
    public int fusionMode;

    /* renamed from: id  reason: collision with root package name */
    public final long f55554id;
    public final ObservableFlatMap$MergeObserver<T, U> parent;
    public volatile f<U> queue;

    public ObservableFlatMap$InnerObserver(ObservableFlatMap$MergeObserver<T, U> observableFlatMap$MergeObserver, long j11) {
        this.f55554id = j11;
        this.parent = observableFlatMap$MergeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable th2) {
        if (this.parent.errors.tryAddThrowableOrReport(th2)) {
            ObservableFlatMap$MergeObserver<T, U> observableFlatMap$MergeObserver = this.parent;
            if (!observableFlatMap$MergeObserver.delayErrors) {
                observableFlatMap$MergeObserver.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }
    }

    public void onNext(U u11) {
        if (this.fusionMode == 0) {
            this.parent.tryEmit(u11, this);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof k00.b)) {
            k00.b bVar2 = (k00.b) bVar;
            int requestFusion = bVar2.requestFusion(7);
            if (requestFusion == 1) {
                this.fusionMode = requestFusion;
                this.queue = bVar2;
                this.done = true;
                this.parent.drain();
            } else if (requestFusion == 2) {
                this.fusionMode = requestFusion;
                this.queue = bVar2;
            }
        }
    }
}
