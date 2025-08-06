package io.reactivex.rxjava3.internal.operators.observable;

import h00.a;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableConcatWithCompletable$ConcatWithObserver<T> extends AtomicReference<b> implements k<T>, a, b {
    private static final long serialVersionUID = -1953724749712440952L;
    public final k<? super T> downstream;
    public boolean inCompletable;
    public h00.b other;

    public ObservableConcatWithCompletable$ConcatWithObserver(k<? super T> kVar, h00.b bVar) {
        this.downstream = kVar;
        this.other = bVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        if (this.inCompletable) {
            this.downstream.onComplete();
            return;
        }
        this.inCompletable = true;
        DisposableHelper.replace(this, (b) null);
        h00.b bVar = this.other;
        this.other = null;
        bVar.a(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar) && !this.inCompletable) {
            this.downstream.onSubscribe(this);
        }
    }
}
