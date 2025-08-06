package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<b> implements a, b, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    public final a downstream;
    public Throwable error;
    public final Scheduler scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(a aVar, Scheduler scheduler2) {
        this.downstream = aVar;
        this.scheduler = scheduler2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    public void onError(Throwable th2) {
        this.error = th2;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.error = null;
            this.downstream.onError(th2);
            return;
        }
        this.downstream.onComplete();
    }
}
