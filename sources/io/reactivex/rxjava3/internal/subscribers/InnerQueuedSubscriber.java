package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.g;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import m00.c;
import z20.d;

public final class InnerQueuedSubscriber<T> extends AtomicReference<d> implements e<T>, d {
    private static final long serialVersionUID = 22876611072430776L;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final c<T> parent;
    public final int prefetch;
    public long produced;
    public volatile f<T> queue;

    public InnerQueuedSubscriber(c<T> cVar, int i11) {
        this.parent = cVar;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(this, th2);
    }

    public void onNext(T t11) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t11);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    g.f(dVar, this.prefetch);
                    return;
                }
            }
            this.queue = g.a(this.prefetch);
            g.f(dVar, this.prefetch);
        }
    }

    public f<T> queue() {
        return this.queue;
    }

    public void request(long j11) {
        if (this.fusionMode != 1) {
            long j12 = this.produced + j11;
            if (j12 >= ((long) this.limit)) {
                this.produced = 0;
                ((d) get()).request(j12);
                return;
            }
            this.produced = j12;
        }
    }

    public void setDone() {
        this.done = true;
    }
}
