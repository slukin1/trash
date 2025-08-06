package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeSubscribeOn$SubscribeOnMaybeObserver<T> extends AtomicReference<b> implements f<T>, b {
    private static final long serialVersionUID = 8571289934935992137L;
    public final f<? super T> downstream;
    public final SequentialDisposable task = new SequentialDisposable();

    public MaybeSubscribeOn$SubscribeOnMaybeObserver(f<? super T> fVar) {
        this.downstream = fVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
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

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }
}
