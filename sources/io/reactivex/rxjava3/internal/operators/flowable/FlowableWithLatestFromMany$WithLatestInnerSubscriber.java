package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class FlowableWithLatestFromMany$WithLatestInnerSubscriber extends AtomicReference<d> implements e<Object> {
    private static final long serialVersionUID = 3256684027868224024L;
    public boolean hasValue;
    public final int index;
    public final FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> parent;

    public FlowableWithLatestFromMany$WithLatestInnerSubscriber(FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> flowableWithLatestFromMany$WithLatestFromSubscriber, int i11) {
        this.parent = flowableWithLatestFromMany$WithLatestFromSubscriber;
        this.index = i11;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(this.index, th2);
    }

    public void onNext(Object obj) {
        if (!this.hasValue) {
            this.hasValue = true;
        }
        this.parent.innerNext(this.index, obj);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
