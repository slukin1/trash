package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableSubscribeOn$SubscribeOnObserver extends AtomicReference<b> implements a, b, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    public final a downstream;
    public final h00.b source;
    public final SequentialDisposable task = new SequentialDisposable();

    public CompletableSubscribeOn$SubscribeOnObserver(a aVar, h00.b bVar) {
        this.downstream = aVar;
        this.source = bVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
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
        DisposableHelper.setOnce(this, bVar);
    }

    public void run() {
        this.source.a(this);
    }
}
