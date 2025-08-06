package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeObserveOn$ObserveOnMaybeObserver<T> extends AtomicReference<b> implements f<T>, b, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    public final f<? super T> downstream;
    public Throwable error;
    public final Scheduler scheduler;
    public T value;

    public MaybeObserveOn$ObserveOnMaybeObserver(f<? super T> fVar, Scheduler scheduler2) {
        this.downstream = fVar;
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

    public void onSuccess(T t11) {
        this.value = t11;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.error = null;
            this.downstream.onError(th2);
            return;
        }
        T t11 = this.value;
        if (t11 != null) {
            this.value = null;
            this.downstream.onSuccess(t11);
            return;
        }
        this.downstream.onComplete();
    }
}
