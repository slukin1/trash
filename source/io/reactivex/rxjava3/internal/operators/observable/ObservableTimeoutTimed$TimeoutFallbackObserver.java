package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableTimeoutTimed$TimeoutFallbackObserver<T> extends AtomicReference<b> implements k<T>, b, l {
    private static final long serialVersionUID = 3764492702657003550L;
    public final k<? super T> downstream;
    public j<? extends T> fallback;
    public final AtomicLong index = new AtomicLong();
    public final SequentialDisposable task = new SequentialDisposable();
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference<b> upstream = new AtomicReference<>();
    public final Scheduler.Worker worker;

    public ObservableTimeoutTimed$TimeoutFallbackObserver(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2, j<? extends T> jVar) {
        this.downstream = kVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
        this.fallback = jVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        long j11 = this.index.get();
        if (j11 != Long.MAX_VALUE) {
            long j12 = 1 + j11;
            if (this.index.compareAndSet(j11, j12)) {
                ((b) this.task.get()).dispose();
                this.downstream.onNext(t11);
                startTimeout(j12);
            }
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void onTimeout(long j11) {
        if (this.index.compareAndSet(j11, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.upstream);
            j<? extends T> jVar = this.fallback;
            this.fallback = null;
            jVar.subscribe(new k(this.downstream, this));
            this.worker.dispose();
        }
    }

    public void startTimeout(long j11) {
        this.task.replace(this.worker.c(new m(j11, this), this.timeout, this.unit));
    }
}
