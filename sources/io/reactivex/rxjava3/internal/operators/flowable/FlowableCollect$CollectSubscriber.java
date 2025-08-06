package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.b;
import o00.a;
import z20.c;
import z20.d;

final class FlowableCollect$CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements e<T> {
    private static final long serialVersionUID = -3589550218733891694L;
    public final b<? super U, ? super T> collector;
    public boolean done;

    /* renamed from: u  reason: collision with root package name */
    public final U f55476u;
    public d upstream;

    public FlowableCollect$CollectSubscriber(c<? super U> cVar, U u11, b<? super U, ? super T> bVar) {
        super(cVar);
        this.collector = bVar;
        this.f55476u = u11;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            complete(this.f55476u);
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
                this.collector.accept(this.f55476u, t11);
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
