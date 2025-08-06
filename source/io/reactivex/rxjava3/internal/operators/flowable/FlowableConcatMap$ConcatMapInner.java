package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import z20.d;

final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements e<R> {
    private static final long serialVersionUID = 897683679971470653L;
    public final c<R> parent;
    public long produced;

    public FlowableConcatMap$ConcatMapInner(c<R> cVar) {
        super(false);
        this.parent = cVar;
    }

    public void onComplete() {
        long j11 = this.produced;
        if (j11 != 0) {
            this.produced = 0;
            produced(j11);
        }
        this.parent.innerComplete();
    }

    public void onError(Throwable th2) {
        long j11 = this.produced;
        if (j11 != 0) {
            this.produced = 0;
            produced(j11);
        }
        this.parent.innerError(th2);
    }

    public void onNext(R r11) {
        this.produced++;
        this.parent.innerNext(r11);
    }

    public void onSubscribe(d dVar) {
        setSubscription(dVar);
    }
}
