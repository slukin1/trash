package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.c;
import java.util.Objects;
import o00.a;
import z20.d;

final class FlowableReduce$ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements e<T> {
    private static final long serialVersionUID = -4663883003264602070L;
    public final c<T, T, T> reducer;
    public d upstream;

    public FlowableReduce$ReduceSubscriber(z20.c<? super T> cVar, c<T, T, T> cVar2) {
        super(cVar);
        this.reducer = cVar2;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        d dVar = this.upstream;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            this.upstream = subscriptionHelper;
            T t11 = this.value;
            if (t11 != null) {
                complete(t11);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        d dVar = this.upstream;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar == subscriptionHelper) {
            a.n(th2);
            return;
        }
        this.upstream = subscriptionHelper;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (this.upstream != SubscriptionHelper.CANCELLED) {
            T t12 = this.value;
            if (t12 == null) {
                this.value = t11;
                return;
            }
            try {
                T apply = this.reducer.apply(t12, t11);
                Objects.requireNonNull(apply, "The reducer returned a null value");
                this.value = apply;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
