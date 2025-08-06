package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class SingleTakeUntil$TakeUntilMainObserver<T> extends AtomicReference<b> implements m<T>, b {
    private static final long serialVersionUID = -622603812305745221L;
    public final m<? super T> downstream;
    public final SingleTakeUntil$TakeUntilOtherSubscriber other = new SingleTakeUntil$TakeUntilOtherSubscriber(this);

    public SingleTakeUntil$TakeUntilMainObserver(m<? super T> mVar) {
        this.downstream = mVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.other.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onError(Throwable th2) {
        this.other.dispose();
        b bVar = (b) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || ((b) getAndSet(disposableHelper)) == disposableHelper) {
            a.n(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        this.other.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (((b) getAndSet(disposableHelper)) != disposableHelper) {
            this.downstream.onSuccess(t11);
        }
    }

    public void otherError(Throwable th2) {
        b bVar;
        b bVar2 = (b) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar2 == disposableHelper || (bVar = (b) getAndSet(disposableHelper)) == disposableHelper) {
            a.n(th2);
            return;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        this.downstream.onError(th2);
    }
}
