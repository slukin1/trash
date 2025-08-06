package io.reactivex.rxjava3.internal.operators.mixed;

import h00.a;
import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableAndThenObservable$AndThenObservableObserver<R> extends AtomicReference<b> implements k<R>, a, b {
    private static final long serialVersionUID = -8948264376121066672L;
    public final k<? super R> downstream;
    public j<? extends R> other;

    public CompletableAndThenObservable$AndThenObservableObserver(k<? super R> kVar, j<? extends R> jVar) {
        this.other = jVar;
        this.downstream = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        j<? extends R> jVar = this.other;
        if (jVar == null) {
            this.downstream.onComplete();
            return;
        }
        this.other = null;
        jVar.subscribe(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(R r11) {
        this.downstream.onNext(r11);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
