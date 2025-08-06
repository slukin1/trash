package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import z20.c;
import z20.d;

final class FlowableTakeLastOne$TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements e<T> {
    private static final long serialVersionUID = -5467847744262967226L;
    public d upstream;

    public FlowableTakeLastOne$TakeLastOneSubscriber(c<? super T> cVar) {
        super(cVar);
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        T t11 = this.value;
        if (t11 != null) {
            complete(t11);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.value = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.value = t11;
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
