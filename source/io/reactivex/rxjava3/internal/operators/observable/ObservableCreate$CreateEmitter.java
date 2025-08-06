package io.reactivex.rxjava3.internal.operators.observable;

import h00.i;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.f;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableCreate$CreateEmitter<T> extends AtomicReference<b> implements i<T>, b {
    private static final long serialVersionUID = -3434801548987643227L;
    public final k<? super T> observer;

    public ObservableCreate$CreateEmitter(k<? super T> kVar) {
        this.observer = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        if (!isDisposed()) {
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }
    }

    public void onError(Throwable th2) {
        if (!tryOnError(th2)) {
            a.n(th2);
        }
    }

    public void onNext(T t11) {
        if (t11 == null) {
            onError(ExceptionHelper.b("onNext called with a null value."));
        } else if (!isDisposed()) {
            this.observer.onNext(t11);
        }
    }

    public i<T> serialize() {
        return new ObservableCreate$SerializedEmitter(this);
    }

    public void setCancellable(f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    public void setDisposable(b bVar) {
        DisposableHelper.set(this, bVar);
    }

    public String toString() {
        return String.format("%s{%s}", new Object[]{ObservableCreate$CreateEmitter.class.getSimpleName(), super.toString()});
    }

    /* JADX INFO: finally extract failed */
    public boolean tryOnError(Throwable th2) {
        if (th2 == null) {
            th2 = ExceptionHelper.b("onError called with a null Throwable.");
        }
        if (isDisposed()) {
            return false;
        }
        try {
            this.observer.onError(th2);
            dispose();
            return true;
        } catch (Throwable th3) {
            dispose();
            throw th3;
        }
    }
}
