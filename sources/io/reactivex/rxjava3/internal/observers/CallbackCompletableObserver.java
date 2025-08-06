package io.reactivex.rxjava3.internal.observers;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.g;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver extends AtomicReference<b> implements a, b, g<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    public final j00.a onComplete;
    public final g<? super Throwable> onError;

    public CallbackCompletableObserver(j00.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            o00.a.n(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th2) {
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.rxjava3.exceptions.a.b(th3);
            o00.a.n(th3);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void accept(Throwable th2) {
        o00.a.n(new OnErrorNotImplementedException(th2));
    }

    public CallbackCompletableObserver(g<? super Throwable> gVar, j00.a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }
}
