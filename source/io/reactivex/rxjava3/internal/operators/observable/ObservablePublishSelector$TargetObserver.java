package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservablePublishSelector$TargetObserver<R> extends AtomicReference<b> implements k<R>, b {
    private static final long serialVersionUID = 854110278590336484L;
    public final k<? super R> downstream;
    public b upstream;

    public ObservablePublishSelector$TargetObserver(k<? super R> kVar) {
        this.downstream = kVar;
    }

    public void dispose() {
        this.upstream.dispose();
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th2);
    }

    public void onNext(R r11) {
        this.downstream.onNext(r11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
