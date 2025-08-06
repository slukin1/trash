package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import o00.a;
import z20.c;
import z20.d;

final class FlowableSingle$SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements e<T> {
    private static final long serialVersionUID = -5526049321428043809L;
    public final T defaultValue;
    public boolean done;
    public final boolean failOnEmpty;
    public d upstream;

    public FlowableSingle$SingleElementSubscriber(c<? super T> cVar, T t11, boolean z11) {
        super(cVar);
        this.defaultValue = t11;
        this.failOnEmpty = z11;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            T t11 = this.value;
            this.value = null;
            if (t11 == null) {
                t11 = this.defaultValue;
            }
            if (t11 != null) {
                complete(t11);
            } else if (this.failOnEmpty) {
                this.downstream.onError(new NoSuchElementException());
            } else {
                this.downstream.onComplete();
            }
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
            if (this.value != null) {
                this.done = true;
                this.upstream.cancel();
                this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.value = t11;
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
