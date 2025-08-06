package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import z20.c;
import z20.d;

final class FlowableCount$CountSubscriber extends DeferredScalarSubscription<Long> implements e<Object> {
    private static final long serialVersionUID = 4973004223787171406L;
    public long count;
    public d upstream;

    public FlowableCount$CountSubscriber(c<? super Long> cVar) {
        super(cVar);
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        complete(Long.valueOf(this.count));
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(Object obj) {
        this.count++;
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
