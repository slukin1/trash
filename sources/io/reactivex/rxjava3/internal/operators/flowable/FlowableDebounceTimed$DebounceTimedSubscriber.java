package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.c;
import z20.d;

final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements e<T>, d {
    private static final long serialVersionUID = -9102637559663639004L;
    public boolean done;
    public final c<? super T> downstream;
    public volatile long index;
    public final long timeout;
    public b timer;
    public final TimeUnit unit;
    public d upstream;
    public final Scheduler.Worker worker;

    public FlowableDebounceTimed$DebounceTimedSubscriber(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2) {
        this.downstream = cVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void emit(long j11, T t11, FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter) {
        if (j11 != this.index) {
            return;
        }
        if (get() != 0) {
            this.downstream.onNext(t11);
            io.reactivex.rxjava3.internal.util.b.e(this, 1);
            flowableDebounceTimed$DebounceEmitter.dispose();
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            b bVar = this.timer;
            if (bVar != null) {
                bVar.dispose();
            }
            FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = (FlowableDebounceTimed$DebounceEmitter) bVar;
            if (flowableDebounceTimed$DebounceEmitter != null) {
                flowableDebounceTimed$DebounceEmitter.emit();
            }
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
        b bVar = this.timer;
        if (bVar != null) {
            bVar.dispose();
        }
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    public void onNext(T t11) {
        if (!this.done) {
            long j11 = this.index + 1;
            this.index = j11;
            b bVar = this.timer;
            if (bVar != null) {
                bVar.dispose();
            }
            FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = new FlowableDebounceTimed$DebounceEmitter(t11, j11, this);
            this.timer = flowableDebounceTimed$DebounceEmitter;
            flowableDebounceTimed$DebounceEmitter.setResource(this.worker.c(flowableDebounceTimed$DebounceEmitter, this.timeout, this.unit));
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
            io.reactivex.rxjava3.internal.util.b.a(this, j11);
        }
    }
}
