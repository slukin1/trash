package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<b> implements k<T>, b {
    private static final long serialVersionUID = 8094547886072529208L;
    public final k<? super T> downstream;
    public final AtomicReference<b> upstream = new AtomicReference<>();

    public ObservableSubscribeOn$SubscribeOnObserver(k<? super T> kVar) {
        this.downstream = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void setDisposable(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
