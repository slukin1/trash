package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    private static final long serialVersionUID = 2875964065294031672L;
    public final f<? super Long> downstream;

    public MaybeTimer$TimerDisposable(f<? super Long> fVar) {
        this.downstream = fVar;
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
