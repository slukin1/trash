package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class SingleObserveOn$ObserveOnSingleObserver<T> extends AtomicReference<b> implements m<T>, b, Runnable {
    private static final long serialVersionUID = 3528003840217436037L;
    public final m<? super T> downstream;
    public Throwable error;
    public final Scheduler scheduler;
    public T value;

    public SingleObserveOn$ObserveOnSingleObserver(m<? super T> mVar, Scheduler scheduler2) {
        this.downstream = mVar;
        this.scheduler = scheduler2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
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

    public void onSuccess(T t11) {
        this.value = t11;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.downstream.onError(th2);
        } else {
            this.downstream.onSuccess(this.value);
        }
    }
}
