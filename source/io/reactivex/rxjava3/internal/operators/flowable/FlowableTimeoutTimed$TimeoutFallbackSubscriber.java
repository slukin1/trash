package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.b;
import z20.c;
import z20.d;

final class FlowableTimeoutTimed$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements e<T>, p {
    private static final long serialVersionUID = 3764492702657003550L;
    public long consumed;
    public final c<? super T> downstream;
    public b<? extends T> fallback;
    public final AtomicLong index = new AtomicLong();
    public final SequentialDisposable task = new SequentialDisposable();
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public final Scheduler.Worker worker;

    public FlowableTimeoutTimed$TimeoutFallbackSubscriber(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2, b<? extends T> bVar) {
        super(true);
        this.downstream = cVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
        this.fallback = bVar;
    }

    public void cancel() {
        super.cancel();
        this.worker.dispose();
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
            long j12 = j11 + 1;
            if (this.index.compareAndSet(j11, j12)) {
                ((io.reactivex.rxjava3.disposables.b) this.task.get()).dispose();
                this.consumed++;
                this.downstream.onNext(t11);
                startTimeout(j12);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            setSubscription(dVar);
        }
    }

    public void onTimeout(long j11) {
        if (this.index.compareAndSet(j11, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            long j12 = this.consumed;
            if (j12 != 0) {
                produced(j12);
            }
            b<? extends T> bVar = this.fallback;
            this.fallback = null;
            bVar.subscribe(new o(this.downstream, this));
            this.worker.dispose();
        }
    }

    public void startTimeout(long j11) {
        this.task.replace(this.worker.c(new q(j11, this), this.timeout, this.unit));
    }
}
