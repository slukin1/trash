package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableTakeUntil$TakeUntilMainSubscriber<T> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -4945480365982832967L;
    public final c<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final FlowableTakeUntil$TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public final class OtherSubscriber extends AtomicReference<d> implements e<Object> {
        private static final long serialVersionUID = -3592821756711087922L;

        public OtherSubscriber() {
        }

        public void onComplete() {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            io.reactivex.rxjava3.internal.util.e.b(flowableTakeUntil$TakeUntilMainSubscriber.downstream, flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            io.reactivex.rxjava3.internal.util.e.d(flowableTakeUntil$TakeUntilMainSubscriber.downstream, th2, flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        public void onNext(Object obj) {
            SubscriptionHelper.cancel(this);
            onComplete();
        }

        public void onSubscribe(d dVar) {
            SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
        }
    }

    public FlowableTakeUntil$TakeUntilMainSubscriber(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        io.reactivex.rxjava3.internal.util.e.b(this.downstream, this, this.error);
    }

    public void onError(Throwable th2) {
        SubscriptionHelper.cancel(this.other);
        io.reactivex.rxjava3.internal.util.e.d(this.downstream, th2, this, this.error);
    }

    public void onNext(T t11) {
        io.reactivex.rxjava3.internal.util.e.f(this.downstream, t11, this, this.error);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
    }
}
