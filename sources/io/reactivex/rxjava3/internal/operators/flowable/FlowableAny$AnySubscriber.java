package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.j;
import o00.a;
import z20.c;
import z20.d;

final class FlowableAny$AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements e<T> {
    private static final long serialVersionUID = -2311252482644620661L;
    public boolean done;
    public final j<? super T> predicate;
    public d upstream;

    public FlowableAny$AnySubscriber(c<? super Boolean> cVar, j<? super T> jVar) {
        super(cVar);
        this.predicate = jVar;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            complete(Boolean.FALSE);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                if (this.predicate.test(t11)) {
                    this.done = true;
                    this.upstream.cancel();
                    complete(Boolean.TRUE);
                }
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
