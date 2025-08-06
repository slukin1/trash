package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.b;
import o00.a;
import z20.c;
import z20.d;

final class ParallelCollect$ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
    private static final long serialVersionUID = -4767392946044436228L;
    public C collection;
    public final b<? super C, ? super T> collector;
    public boolean done;

    public ParallelCollect$ParallelCollectSubscriber(c<? super C> cVar, C c11, b<? super C, ? super T> bVar) {
        super(cVar);
        this.collection = c11;
        this.collector = bVar;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            C c11 = this.collection;
            this.collection = null;
            complete(c11);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.collection = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                this.collector.accept(this.collection, t11);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                cancel();
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
