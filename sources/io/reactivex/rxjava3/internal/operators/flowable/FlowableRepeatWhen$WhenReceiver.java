package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.d;

final class FlowableRepeatWhen$WhenReceiver<T, U> extends AtomicInteger implements e<Object>, d {
    private static final long serialVersionUID = 2827772011130406689L;
    public final AtomicLong requested = new AtomicLong();
    public final b<T> source;
    public FlowableRepeatWhen$WhenSourceSubscriber<T, U> subscriber;
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public FlowableRepeatWhen$WhenReceiver(b<T> bVar) {
        this.source = bVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
    }

    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.subscriber.cancel();
        this.subscriber.downstream.onError(th2);
    }

    public void onNext(Object obj) {
        if (getAndIncrement() == 0) {
            while (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                this.source.subscribe(this.subscriber);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
    }
}
