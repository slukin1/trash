package io.reactivex.rxjava3.internal.operators.observable;

import h00.f;
import h00.g;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableConcatWithMaybe$ConcatWithObserver<T> extends AtomicReference<b> implements k<T>, f<T>, b {
    private static final long serialVersionUID = -1953724749712440952L;
    public final k<? super T> downstream;
    public boolean inMaybe;
    public g<? extends T> other;

    public ObservableConcatWithMaybe$ConcatWithObserver(k<? super T> kVar, g<? extends T> gVar) {
        this.downstream = kVar;
        this.other = gVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        if (this.inMaybe) {
            this.downstream.onComplete();
            return;
        }
        this.inMaybe = true;
        DisposableHelper.replace(this, (b) null);
        g<? extends T> gVar = this.other;
        this.other = null;
        gVar.a(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar) && !this.inMaybe) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.downstream.onNext(t11);
        this.downstream.onComplete();
    }
}
