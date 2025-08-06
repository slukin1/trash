package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableTimeout$TimeoutConsumer extends AtomicReference<b> implements k<Object>, b {
    private static final long serialVersionUID = 8708641127342403073L;
    public final long idx;
    public final j parent;

    public ObservableTimeout$TimeoutConsumer(long j11, j jVar) {
        this.idx = j11;
        this.parent = jVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    public void onError(Throwable th2) {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            this.parent.onTimeoutError(this.idx, th2);
            return;
        }
        a.n(th2);
    }

    public void onNext(Object obj) {
        b bVar = (b) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            bVar.dispose();
            lazySet(disposableHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
