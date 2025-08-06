package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    public long count;
    public final k<? super Long> downstream;
    public final long end;

    public ObservableIntervalRange$IntervalRangeObserver(k<? super Long> kVar, long j11, long j12) {
        this.downstream = kVar;
        this.count = j11;
        this.end = j12;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void run() {
        if (!isDisposed()) {
            long j11 = this.count;
            this.downstream.onNext(Long.valueOf(j11));
            if (j11 == this.end) {
                if (!isDisposed()) {
                    this.downstream.onComplete();
                }
                DisposableHelper.dispose(this);
                return;
            }
            this.count = j11 + 1;
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
