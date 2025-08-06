package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 3167244060586201109L;
    public final a downstream;

    public CompletableTimer$TimerDisposable(a aVar) {
        this.downstream = aVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void run() {
        this.downstream.onComplete();
    }

    public void setFuture(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
