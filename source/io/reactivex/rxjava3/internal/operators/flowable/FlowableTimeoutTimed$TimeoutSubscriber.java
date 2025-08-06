package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.c;
import z20.d;

final class FlowableTimeoutTimed$TimeoutSubscriber<T> extends AtomicLong implements e<T>, d, p {
    private static final long serialVersionUID = 3764492702657003550L;
    public final c<? super T> downstream;
    public final AtomicLong requested = new AtomicLong();
    public final SequentialDisposable task = new SequentialDisposable();
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public final Scheduler.Worker worker;

    public FlowableTimeoutTimed$TimeoutSubscriber(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2) {
        this.downstream = cVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
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

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    public void onTimeout(long j11) {
        if (compareAndSet(j11, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(new TimeoutException(ExceptionHelper.f(this.timeout, this.unit)));
            this.worker.dispose();
        }
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
    }

    public void startTimeout(long j11) {
        this.task.replace(this.worker.c(new q(j11, this), this.timeout, this.unit));
    }
}
