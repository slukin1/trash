package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.d;

final class FlowableTimeout$TimeoutConsumer extends AtomicReference<d> implements e<Object>, b {
    private static final long serialVersionUID = 8708641127342403073L;
    public final long idx;
    public final n parent;

    public FlowableTimeout$TimeoutConsumer(long j11, n nVar) {
        this.idx = j11;
        this.parent = nVar;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    public void onError(Throwable th2) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.onTimeoutError(this.idx, th2);
            return;
        }
        a.n(th2);
    }

    public void onNext(Object obj) {
        d dVar = (d) get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            dVar.cancel();
            lazySet(subscriptionHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
