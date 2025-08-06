package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableThrottleFirstTimed$DebounceTimedObserver<T> extends AtomicReference<b> implements k<T>, b, Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    public final k<? super T> downstream;
    public volatile boolean gate;
    public final long timeout;
    public final TimeUnit unit;
    public b upstream;
    public final Scheduler.Worker worker;

    public ObservableThrottleFirstTimed$DebounceTimedObserver(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2) {
        this.downstream = kVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
    }

    public void dispose() {
        this.upstream.dispose();
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    public void onNext(T t11) {
        if (!this.gate) {
            this.gate = true;
            this.downstream.onNext(t11);
            b bVar = (b) get();
            if (bVar != null) {
                bVar.dispose();
            }
            DisposableHelper.replace(this, this.worker.c(this, this.timeout, this.unit));
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        this.gate = false;
    }
}
