package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableDelay$Delay extends AtomicReference<b> implements a, Runnable, b {
    private static final long serialVersionUID = 465972761105851022L;
    public final long delay;
    public final boolean delayError;
    public final a downstream;
    public Throwable error;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    public CompletableDelay$Delay(a aVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, boolean z11) {
        this.downstream = aVar;
        this.delay = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.d(this, this.delay, this.unit));
    }

    public void onError(Throwable th2) {
        this.error = th2;
        DisposableHelper.replace(this, this.scheduler.d(this, this.delayError ? this.delay : 0, this.unit));
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        Throwable th2 = this.error;
        this.error = null;
        if (th2 != null) {
            this.downstream.onError(th2);
        } else {
            this.downstream.onComplete();
        }
    }
}
