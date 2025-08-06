package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

final class ObservableSkipLast$SkipLastObserver<T> extends ArrayDeque<T> implements k<T>, b {
    private static final long serialVersionUID = -3807491841935125653L;
    public final k<? super T> downstream;
    public final int skip;
    public b upstream;

    public ObservableSkipLast$SkipLastObserver(k<? super T> kVar, int i11) {
        super(i11);
        this.downstream = kVar;
        this.skip = i11;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (this.skip == size()) {
            this.downstream.onNext(poll());
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
