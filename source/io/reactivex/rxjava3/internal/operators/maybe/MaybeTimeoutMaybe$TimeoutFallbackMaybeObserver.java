package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> extends AtomicReference<b> implements f<T> {
    private static final long serialVersionUID = 8663801314800248617L;
    public final f<? super T> downstream;

    public MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver(f<? super T> fVar) {
        this.downstream = fVar;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }
}
