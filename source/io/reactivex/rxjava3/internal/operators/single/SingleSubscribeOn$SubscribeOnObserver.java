package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

final class SingleSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<b> implements m<T>, b, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    public final m<? super T> downstream;
    public final o<? extends T> source;
    public final SequentialDisposable task = new SequentialDisposable();

    public SingleSubscribeOn$SubscribeOnObserver(m<? super T> mVar, o<? extends T> oVar) {
        this.downstream = mVar;
        this.source = oVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }

    public void run() {
        this.source.a(this);
    }
}
