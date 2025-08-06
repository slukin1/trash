package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import z20.b;
import z20.c;
import z20.d;

final class FlowableRepeat$RepeatSubscriber<T> extends AtomicInteger implements e<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    public final c<? super T> downstream;
    public long produced;
    public long remaining;

    /* renamed from: sa  reason: collision with root package name */
    public final SubscriptionArbiter f55488sa;
    public final b<? extends T> source;

    public FlowableRepeat$RepeatSubscriber(c<? super T> cVar, long j11, SubscriptionArbiter subscriptionArbiter, b<? extends T> bVar) {
        this.downstream = cVar;
        this.f55488sa = subscriptionArbiter;
        this.source = bVar;
        this.remaining = j11;
    }

    public void onComplete() {
        long j11 = this.remaining;
        if (j11 != Long.MAX_VALUE) {
            this.remaining = j11 - 1;
        }
        if (j11 != 0) {
            subscribeNext();
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.produced++;
        this.downstream.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        this.f55488sa.setSubscription(dVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i11 = 1;
            while (!this.f55488sa.isCancelled()) {
                long j11 = this.produced;
                if (j11 != 0) {
                    this.produced = 0;
                    this.f55488sa.produced(j11);
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
