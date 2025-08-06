package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.a;
import java.util.concurrent.atomic.AtomicInteger;

final class SingleDoFinally$DoFinallyObserver<T> extends AtomicInteger implements m<T>, b {
    private static final long serialVersionUID = 4109457741734051389L;
    public final m<? super T> downstream;
    public final a onFinally;
    public b upstream;

    public SingleDoFinally$DoFinallyObserver(m<? super T> mVar, a aVar) {
        this.downstream = mVar;
        this.onFinally = aVar;
    }

    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        runFinally();
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
        runFinally();
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                o00.a.n(th2);
            }
        }
    }
}
