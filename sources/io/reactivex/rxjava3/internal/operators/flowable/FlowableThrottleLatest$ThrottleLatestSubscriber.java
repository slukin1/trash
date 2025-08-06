package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableThrottleLatest$ThrottleLatestSubscriber<T> extends AtomicInteger implements e<T>, d, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final c<? super T> downstream;
    public final boolean emitLast;
    public long emitted;
    public Throwable error;
    public final AtomicReference<T> latest = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final long timeout;
    public volatile boolean timerFired;
    public boolean timerRunning;
    public final TimeUnit unit;
    public d upstream;
    public final Scheduler.Worker worker;

    public FlowableThrottleLatest$ThrottleLatestSubscriber(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2, boolean z11) {
        this.downstream = cVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
        this.emitLast = z11;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.latest.lazySet((Object) null);
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            AtomicReference<T> atomicReference = this.latest;
            AtomicLong atomicLong = this.requested;
            c<? super T> cVar = this.downstream;
            int i11 = 1;
            while (!this.cancelled) {
                boolean z11 = this.done;
                if (!z11 || this.error == null) {
                    boolean z12 = atomicReference.get() == null;
                    if (z11) {
                        if (z12 || !this.emitLast) {
                            atomicReference.lazySet((Object) null);
                            cVar.onComplete();
                        } else {
                            T andSet = atomicReference.getAndSet((Object) null);
                            long j11 = this.emitted;
                            if (j11 != atomicLong.get()) {
                                this.emitted = j11 + 1;
                                cVar.onNext(andSet);
                                cVar.onComplete();
                            } else {
                                cVar.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                            }
                        }
                        this.worker.dispose();
                        return;
                    }
                    if (z12) {
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                    } else if (!this.timerRunning || this.timerFired) {
                        T andSet2 = atomicReference.getAndSet((Object) null);
                        long j12 = this.emitted;
                        if (j12 != atomicLong.get()) {
                            cVar.onNext(andSet2);
                            this.emitted = j12 + 1;
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.c(this, this.timeout, this.unit);
                        } else {
                            this.upstream.cancel();
                            cVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                            this.worker.dispose();
                            return;
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    atomicReference.lazySet((Object) null);
                    cVar.onError(this.error);
                    this.worker.dispose();
                    return;
                }
            }
            atomicReference.lazySet((Object) null);
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        this.latest.set(t11);
        drain();
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
            b.a(this.requested, j11);
        }
    }

    public void run() {
        this.timerFired = true;
        drain();
    }
}
