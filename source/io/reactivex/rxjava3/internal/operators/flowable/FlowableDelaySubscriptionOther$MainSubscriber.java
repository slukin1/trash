package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.b;
import z20.c;
import z20.d;

final class FlowableDelaySubscriptionOther$MainSubscriber<T> extends AtomicLong implements e<T>, d {
    private static final long serialVersionUID = 2259811067697317255L;
    public final c<? super T> downstream;
    public final b<? extends T> main;
    public final FlowableDelaySubscriptionOther$MainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public final class OtherSubscriber extends AtomicReference<d> implements e<Object> {
        private static final long serialVersionUID = -3892798459447644106L;

        public OtherSubscriber() {
        }

        public void onComplete() {
            if (((d) get()) != SubscriptionHelper.CANCELLED) {
                FlowableDelaySubscriptionOther$MainSubscriber.this.next();
            }
        }

        public void onError(Throwable th2) {
            if (((d) get()) != SubscriptionHelper.CANCELLED) {
                FlowableDelaySubscriptionOther$MainSubscriber.this.downstream.onError(th2);
            } else {
                a.n(th2);
            }
        }

        public void onNext(Object obj) {
            d dVar = (d) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (dVar != subscriptionHelper) {
                lazySet(subscriptionHelper);
                dVar.cancel();
                FlowableDelaySubscriptionOther$MainSubscriber.this.next();
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableDelaySubscriptionOther$MainSubscriber(c<? super T> cVar, b<? extends T> bVar) {
        this.downstream = cVar;
        this.main = bVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void next() {
        this.main.subscribe(this);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this, dVar);
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            SubscriptionHelper.deferredRequest(this.upstream, this, j11);
        }
    }
}
