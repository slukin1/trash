package io.reactivex.rxjava3.internal.observers;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T> extends AtomicReference<b> implements m<T>, b {
    private static final long serialVersionUID = 4943102778943297569L;
    public final j00.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(j00.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onError(Throwable th2) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(null, th2);
        } catch (Throwable th3) {
            a.b(th3);
            o00.a.n(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(t11, null);
        } catch (Throwable th2) {
            a.b(th2);
            o00.a.n(th2);
        }
    }
}
