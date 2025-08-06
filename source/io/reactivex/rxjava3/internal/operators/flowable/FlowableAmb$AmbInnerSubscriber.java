package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableAmb$AmbInnerSubscriber<T> extends AtomicReference<d> implements e<T>, d {
    private static final long serialVersionUID = -1185974347409665484L;
    public final c<? super T> downstream;
    public final int index;
    public final AtomicLong missedRequested = new AtomicLong();
    public final b<T> parent;
    public boolean won;

    public FlowableAmb$AmbInnerSubscriber(b<T> bVar, int i11, c<? super T> cVar) {
        this.index = i11;
        this.downstream = cVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        if (this.won) {
            this.downstream.onComplete();
            return;
        }
        throw null;
    }

    public void onError(Throwable th2) {
        if (this.won) {
            this.downstream.onError(th2);
            return;
        }
        throw null;
    }

    public void onNext(T t11) {
        if (this.won) {
            this.downstream.onNext(t11);
            return;
        }
        throw null;
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this, this.missedRequested, dVar);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this, this.missedRequested, j11);
    }
}
