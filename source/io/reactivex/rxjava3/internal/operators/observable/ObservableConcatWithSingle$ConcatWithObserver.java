package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableConcatWithSingle$ConcatWithObserver<T> extends AtomicReference<b> implements k<T>, m<T>, b {
    private static final long serialVersionUID = -1953724749712440952L;
    public final k<? super T> downstream;
    public boolean inSingle;
    public o<? extends T> other;

    public ObservableConcatWithSingle$ConcatWithObserver(k<? super T> kVar, o<? extends T> oVar) {
        this.downstream = kVar;
        this.other = oVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        this.inSingle = true;
        DisposableHelper.replace(this, (b) null);
        o<? extends T> oVar = this.other;
        this.other = null;
        oVar.a(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar) && !this.inSingle) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.downstream.onNext(t11);
        this.downstream.onComplete();
    }
}
