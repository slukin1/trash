package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.c;
import z20.d;

final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements e<T>, d, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    public boolean done;
    public final c<? super T> downstream;
    public volatile boolean gate;
    public final long timeout;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public d upstream;
    public final Scheduler.Worker worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2) {
        this.downstream = cVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    public void onNext(T t11) {
        if (!this.done && !this.gate) {
            this.gate = true;
            if (get() != 0) {
                this.downstream.onNext(t11);
                b.e(this, 1);
                io.reactivex.rxjava3.disposables.b bVar = (io.reactivex.rxjava3.disposables.b) this.timer.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.timer.replace(this.worker.c(this, this.timeout, this.unit));
                return;
            }
            this.done = true;
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this, j11);
        }
    }

    public void run() {
        this.gate = false;
    }
}
