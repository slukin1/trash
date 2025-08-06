package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import z20.d;

final class FlowableSequenceEqual$EqualSubscriber<T> extends AtomicReference<d> implements e<T> {
    private static final long serialVersionUID = 4804128302091633067L;
    public volatile boolean done;
    public final int limit;
    public final m parent;
    public final int prefetch;
    public long produced;
    public volatile f<T> queue;
    public int sourceMode;

    public FlowableSequenceEqual$EqualSubscriber(m mVar, int i11) {
        this.parent = mVar;
        this.limit = i11 - (i11 >> 2);
        this.prefetch = i11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void clear() {
        f<T> fVar = this.queue;
        if (fVar != null) {
            fVar.clear();
        }
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable th2) {
        this.parent.innerError(th2);
    }

    public void onNext(T t11) {
        if (this.sourceMode != 0 || this.queue.offer(t11)) {
            this.parent.drain();
        } else {
            onError(new MissingBackpressureException());
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    dVar.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            dVar.request((long) this.prefetch);
        }
    }

    public void request() {
        if (this.sourceMode != 1) {
            long j11 = this.produced + 1;
            if (j11 >= ((long) this.limit)) {
                this.produced = 0;
                ((d) get()).request(j11);
                return;
            }
            this.produced = j11;
        }
    }
}
