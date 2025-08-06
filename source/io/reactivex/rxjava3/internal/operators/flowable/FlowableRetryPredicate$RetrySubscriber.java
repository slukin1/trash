package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import j00.j;
import java.util.concurrent.atomic.AtomicInteger;
import z20.b;
import z20.c;
import z20.d;

final class FlowableRetryPredicate$RetrySubscriber<T> extends AtomicInteger implements e<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    public final c<? super T> downstream;
    public final j<? super Throwable> predicate;
    public long produced;
    public long remaining;

    /* renamed from: sa  reason: collision with root package name */
    public final SubscriptionArbiter f55491sa;
    public final b<? extends T> source;

    public FlowableRetryPredicate$RetrySubscriber(c<? super T> cVar, long j11, j<? super Throwable> jVar, SubscriptionArbiter subscriptionArbiter, b<? extends T> bVar) {
        this.downstream = cVar;
        this.f55491sa = subscriptionArbiter;
        this.source = bVar;
        this.predicate = jVar;
        this.remaining = j11;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        long j11 = this.remaining;
        if (j11 != Long.MAX_VALUE) {
            this.remaining = j11 - 1;
        }
        if (j11 == 0) {
            this.downstream.onError(th2);
            return;
        }
        try {
            if (!this.predicate.test(th2)) {
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

    public void onSubscribe(d dVar) {
        this.f55491sa.setSubscription(dVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i11 = 1;
            while (!this.f55491sa.isCancelled()) {
                long j11 = this.produced;
                if (j11 != 0) {
                    this.produced = 0;
                    this.f55491sa.produced(j11);
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
