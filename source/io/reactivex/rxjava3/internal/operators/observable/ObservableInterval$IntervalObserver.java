package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableInterval$IntervalObserver extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 346773832286157679L;
    public long count;
    public final k<? super Long> downstream;

    public ObservableInterval$IntervalObserver(k<? super Long> kVar) {
        this.downstream = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void run() {
        if (get() != DisposableHelper.DISPOSED) {
            k<? super Long> kVar = this.downstream;
            long j11 = this.count;
            this.count = 1 + j11;
            kVar.onNext(Long.valueOf(j11));
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
