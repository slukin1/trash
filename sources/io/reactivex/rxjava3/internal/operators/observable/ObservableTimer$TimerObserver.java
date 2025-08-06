package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableTimer$TimerObserver extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    public final k<? super Long> downstream;

    public ObservableTimer$TimerObserver(k<? super Long> kVar) {
        this.downstream = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void run() {
        if (!isDisposed()) {
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.trySet(this, bVar);
    }
}
