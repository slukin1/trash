package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import j00.d;
import java.util.concurrent.atomic.AtomicInteger;
import z20.b;
import z20.c;

final class FlowableRetryBiPredicate$RetryBiSubscriber<T> extends AtomicInteger implements e<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    public final c<? super T> downstream;
    public final d<? super Integer, ? super Throwable> predicate;
    public long produced;
    public int retries;

    /* renamed from: sa  reason: collision with root package name */
    public final SubscriptionArbiter f55490sa;
    public final b<? extends T> source;

    public FlowableRetryBiPredicate$RetryBiSubscriber(c<? super T> cVar, d<? super Integer, ? super Throwable> dVar, SubscriptionArbiter subscriptionArbiter, b<? extends T> bVar) {
        this.downstream = cVar;
        this.f55490sa = subscriptionArbiter;
        this.source = bVar;
        this.predicate = dVar;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        try {
            d<? super Integer, ? super Throwable> dVar = this.predicate;
            int i11 = this.retries + 1;
            this.retries = i11;
            if (!dVar.a(Integer.valueOf(i11), th2)) {
                this.downstream.onError(th2);
            } else {
                subscribeNext();
            }
        } catch (Throwable th3) {
            a.b(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        this.produced++;
        this.downstream.onNext(t11);
    }

    public void onSubscribe(z20.d dVar) {
        this.f55490sa.setSubscription(dVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i11 = 1;
            while (!this.f55490sa.isCancelled()) {
                long j11 = this.produced;
                if (j11 != 0) {
                    this.produced = 0;
                    this.f55490sa.produced(j11);
                }
                this.source.subscribe(this);
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }
}
