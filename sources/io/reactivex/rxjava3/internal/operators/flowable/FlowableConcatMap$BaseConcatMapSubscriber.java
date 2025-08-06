package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.concurrent.atomic.AtomicInteger;
import k00.f;
import z20.b;
import z20.d;

abstract class FlowableConcatMap$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements e<T>, c<R>, d {
    private static final long serialVersionUID = -3511336836796789179L;
    public volatile boolean active;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final FlowableConcatMap$ConcatMapInner<R> inner = new FlowableConcatMap$ConcatMapInner<>(this);
    public final int limit;
    public final h<? super T, ? extends b<? extends R>> mapper;
    public final int prefetch;
    public f<T> queue;
    public int sourceMode;
    public d upstream;

    public FlowableConcatMap$BaseConcatMapSubscriber(h<? super T, ? extends b<? extends R>> hVar, int i11) {
        this.mapper = hVar;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
    }

    public abstract /* synthetic */ void cancel();

    public abstract void drain();

    public final void innerComplete() {
        this.active = false;
        drain();
    }

    public abstract /* synthetic */ void innerError(Throwable th2);

    public abstract /* synthetic */ void innerNext(T t11);

    public final void onComplete() {
        this.done = true;
        drain();
    }

    public abstract /* synthetic */ void onError(Throwable th2);

    public final void onNext(T t11) {
        if (this.sourceMode == 2 || this.queue.offer(t11)) {
            drain();
            return;
        }
        this.upstream.cancel();
        onError(new IllegalStateException("Queue full?!"));
    }

    public final void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    subscribeActual();
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    subscribeActual();
                    dVar.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            subscribeActual();
            dVar.request((long) this.prefetch);
        }
    }

    public abstract /* synthetic */ void request(long j11);

    public abstract void subscribeActual();
}
