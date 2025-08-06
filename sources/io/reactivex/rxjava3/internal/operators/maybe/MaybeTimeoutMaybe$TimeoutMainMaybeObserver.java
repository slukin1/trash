package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> extends AtomicReference<b> implements f<T>, b {
    private static final long serialVersionUID = -5955289211445418871L;
    public final f<? super T> downstream;
    public final g<? extends T> fallback;
    public final MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> other = new MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<>(this);
    public final MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> otherObserver;

    public MaybeTimeoutMaybe$TimeoutMainMaybeObserver(f<? super T> fVar, g<? extends T> gVar) {
        this.downstream = fVar;
        this.fallback = gVar;
        this.otherObserver = gVar != null ? new MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<>(fVar) : null;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> maybeTimeoutMaybe$TimeoutFallbackMaybeObserver = this.otherObserver;
        if (maybeTimeoutMaybe$TimeoutFallbackMaybeObserver != null) {
            DisposableHelper.dispose(maybeTimeoutMaybe$TimeoutFallbackMaybeObserver);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.other);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.downstream.onError(th2);
        } else {
            a.n(th2);
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        DisposableHelper.dispose(this.other);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.downstream.onSuccess(t11);
        }
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this)) {
            g<? extends T> gVar = this.fallback;
            if (gVar == null) {
                this.downstream.onError(new TimeoutException());
            } else {
                gVar.a(this.otherObserver);
            }
        }
    }

    public void otherError(Throwable th2) {
        if (DisposableHelper.dispose(this)) {
            this.downstream.onError(th2);
        } else {
            a.n(th2);
        }
    }
}
