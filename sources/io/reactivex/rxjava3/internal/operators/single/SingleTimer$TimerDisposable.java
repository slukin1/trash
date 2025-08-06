package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class SingleTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 8465401857522493082L;
    public final m<? super Long> downstream;

    public SingleTimer$TimerDisposable(m<? super Long> mVar) {
        this.downstream = mVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void run() {
        this.downstream.onSuccess(0L);
    }

    public void setFuture(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
