package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import z20.c;
import z20.d;

public final class o<T> implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public final c<? super T> f55522b;

    /* renamed from: c  reason: collision with root package name */
    public final SubscriptionArbiter f55523c;

    public o(c<? super T> cVar, SubscriptionArbiter subscriptionArbiter) {
        this.f55522b = cVar;
        this.f55523c = subscriptionArbiter;
    }

    public void onComplete() {
        this.f55522b.onComplete();
    }

    public void onError(Throwable th2) {
        this.f55522b.onError(th2);
    }

    public void onNext(T t11) {
        this.f55522b.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        this.f55523c.setSubscription(dVar);
    }
}
