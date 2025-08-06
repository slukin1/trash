package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableAmb$AmbInnerObserver<T> extends AtomicReference<b> implements k<T> {
    private static final long serialVersionUID = -1185974347409665484L;
    public final k<? super T> downstream;
    public final int index;
    public final b<T> parent;
    public boolean won;

    public ObservableAmb$AmbInnerObserver(b<T> bVar, int i11, k<? super T> kVar) {
        this.index = i11;
        this.downstream = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        if (this.won) {
            this.downstream.onComplete();
            return;
        }
        throw null;
    }

    public void onError(Throwable th2) {
        if (this.won) {
            this.downstream.onError(th2);
            return;
        }
        throw null;
    }

    public void onNext(T t11) {
        if (this.won) {
            this.downstream.onNext(t11);
            return;
        }
        throw null;
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
