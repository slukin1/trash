package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.a;
import java.util.concurrent.atomic.AtomicReference;

final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<a> implements m<T>, b {
    private static final long serialVersionUID = -8583764624474935784L;
    public final m<? super T> downstream;
    public b upstream;

    public SingleDoOnDispose$DoOnDisposeObserver(m<? super T> mVar, a aVar) {
        this.downstream = mVar;
        lazySet(aVar);
    }

    public void dispose() {
        a aVar = (a) getAndSet((Object) null);
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                o00.a.n(th2);
            }
            this.upstream.dispose();
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }
}
