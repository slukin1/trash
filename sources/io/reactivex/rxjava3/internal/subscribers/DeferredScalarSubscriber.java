package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import z20.c;
import z20.d;

public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements e<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    public boolean hasValue;
    public d upstream;

    public DeferredScalarSubscriber(c<? super R> cVar) {
        super(cVar);
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.value = null;
        this.downstream.onError(th2);
    }

    public abstract /* synthetic */ void onNext(T t11);

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
