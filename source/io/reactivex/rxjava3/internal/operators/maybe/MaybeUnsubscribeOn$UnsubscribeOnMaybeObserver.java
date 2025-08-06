package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver<T> extends AtomicReference<b> implements f<T>, b, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    public final f<? super T> downstream;

    /* renamed from: ds  reason: collision with root package name */
    public b f55548ds;
    public final Scheduler scheduler;

    public MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver(f<? super T> fVar, Scheduler scheduler2) {
        this.downstream = fVar;
        this.scheduler = scheduler2;
    }

    public void dispose() {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        b bVar = (b) getAndSet(disposableHelper);
        if (bVar != disposableHelper) {
            this.f55548ds = bVar;
            this.scheduler.c(this);
        }
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
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }

    public void run() {
        this.f55548ds.dispose();
    }
}
