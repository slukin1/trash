package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements e<T>, d, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    public final c<? super T> downstream;
    public final long period;
    public final AtomicLong requested = new AtomicLong();
    public final Scheduler scheduler;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public d upstream;

    public FlowableSampleTimed$SampleTimedSubscriber(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.downstream = cVar;
        this.period = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void cancel() {
        cancelTimer();
        this.upstream.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void emit() {
        Object andSet = getAndSet((Object) null);
        if (andSet == null) {
            return;
        }
        if (this.requested.get() != 0) {
            this.downstream.onNext(andSet);
            b.e(this.requested, 1);
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
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

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            SequentialDisposable sequentialDisposable = this.timer;
            Scheduler scheduler2 = this.scheduler;
            long j11 = this.period;
            sequentialDisposable.replace(scheduler2.e(this, j11, j11, this.unit));
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
        }
    }
}
