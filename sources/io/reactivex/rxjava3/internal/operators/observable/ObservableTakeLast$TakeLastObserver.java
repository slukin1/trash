package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

final class ObservableTakeLast$TakeLastObserver<T> extends ArrayDeque<T> implements k<T>, b {
    private static final long serialVersionUID = 7240042530241604978L;
    public volatile boolean cancelled;
    public final int count;
    public final k<? super T> downstream;
    public b upstream;

    public ObservableTakeLast$TakeLastObserver(k<? super T> kVar, int i11) {
        this.downstream = kVar;
        this.count = i11;
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.dispose();
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        k<? super T> kVar = this.downstream;
        while (!this.cancelled) {
            Object poll = poll();
            if (poll == null) {
                kVar.onComplete();
                return;
            }
            kVar.onNext(poll);
        }
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (this.count == size()) {
            poll();
        }
        offer(t11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
