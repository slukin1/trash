package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.c;
import z20.d;

final class FlowableTake$TakeSubscriber<T> extends AtomicLong implements e<T>, d {
    private static final long serialVersionUID = 2288246011222124525L;
    public final c<? super T> downstream;
    public long remaining;
    public d upstream;

    public FlowableTake$TakeSubscriber(c<? super T> cVar, long j11) {
        this.downstream = cVar;
        this.remaining = j11;
        lazySet(j11);
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.remaining > 0) {
            this.remaining = 0;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.remaining > 0) {
            this.remaining = 0;
            this.downstream.onError(th2);
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        long j11 = this.remaining;
        if (j11 > 0) {
            long j12 = j11 - 1;
            this.remaining = j12;
            this.downstream.onNext(t11);
            if (j12 == 0) {
                this.upstream.cancel();
                this.downstream.onComplete();
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (!SubscriptionHelper.validate(this.upstream, dVar)) {
            return;
        }
        if (this.remaining == 0) {
            dVar.cancel();
            EmptySubscription.complete(this.downstream);
            return;
        }
        this.upstream = dVar;
        this.downstream.onSubscribe(this);
    }

    public void request(long j11) {
        long j12;
        long min;
        if (SubscriptionHelper.validate(j11)) {
            do {
                j12 = get();
                if (j12 != 0) {
                    min = Math.min(j12, j11);
                } else {
                    return;
                }
            } while (!compareAndSet(j12, j12 - min));
            this.upstream.request(min);
        }
    }
}
