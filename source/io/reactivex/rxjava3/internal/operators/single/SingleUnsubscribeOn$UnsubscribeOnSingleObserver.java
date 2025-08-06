package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class SingleUnsubscribeOn$UnsubscribeOnSingleObserver<T> extends AtomicReference<b> implements m<T>, b, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    public final m<? super T> downstream;

    /* renamed from: ds  reason: collision with root package name */
    public b f55606ds;
    public final Scheduler scheduler;

    public SingleUnsubscribeOn$UnsubscribeOnSingleObserver(m<? super T> mVar, Scheduler scheduler2) {
        this.downstream = mVar;
        this.scheduler = scheduler2;
    }

    public void dispose() {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        b bVar = (b) getAndSet(disposableHelper);
        if (bVar != disposableHelper) {
            this.f55606ds = bVar;
            this.scheduler.c(this);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
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
        this.f55606ds.dispose();
    }
}
