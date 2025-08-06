package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableTimeoutTimed$TimeoutObserver<T> extends AtomicLong implements k<T>, b, l {
    private static final long serialVersionUID = 3764492702657003550L;
    public final k<? super T> downstream;
    public final SequentialDisposable task = new SequentialDisposable();
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference<b> upstream = new AtomicReference<>();
    public final Scheduler.Worker worker;

    public ObservableTimeoutTimed$TimeoutObserver(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2) {
        this.downstream = kVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        long j11 = get();
        if (j11 != Long.MAX_VALUE) {
            long j12 = 1 + j11;
            if (compareAndSet(j11, j12)) {
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
        if (compareAndSet(j11, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(new TimeoutException(ExceptionHelper.f(this.timeout, this.unit)));
            this.worker.dispose();
        }
    }

    public void startTimeout(long j11) {
        this.task.replace(this.worker.c(new m(j11, this), this.timeout, this.unit));
    }
}
