package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

abstract class ObservableSampleTimed$SampleTimedObserver<T> extends AtomicReference<T> implements k<T>, b, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    public final k<? super T> downstream;
    public final long period;
    public final Scheduler scheduler;
    public final AtomicReference<b> timer = new AtomicReference<>();
    public final TimeUnit unit;
    public b upstream;

    public ObservableSampleTimed$SampleTimedObserver(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.downstream = kVar;
        this.period = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void dispose() {
        cancelTimer();
        this.upstream.dispose();
    }

    public void emit() {
        Object andSet = getAndSet((Object) null);
        if (andSet != null) {
            this.downstream.onNext(andSet);
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        cancelTimer();
        complete();
    }

    public void onError(Throwable th2) {
        cancelTimer();
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        lazySet(t11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
            Scheduler scheduler2 = this.scheduler;
            long j11 = this.period;
            DisposableHelper.replace(this.timer, scheduler2.e(this, j11, j11, this.unit));
        }
    }
}
