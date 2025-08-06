package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k00.a;
import z20.c;
import z20.d;

final class FlowableSkipUntil$SkipUntilMainSubscriber<T> extends AtomicInteger implements a<T>, d {
    private static final long serialVersionUID = -6270983465606289181L;
    public final c<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public volatile boolean gate;
    public final FlowableSkipUntil$SkipUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public final class OtherSubscriber extends AtomicReference<d> implements e<Object> {
        private static final long serialVersionUID = -5592042965931999169L;

        public OtherSubscriber() {
        }

        public void onComplete() {
            FlowableSkipUntil$SkipUntilMainSubscriber.this.gate = true;
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(FlowableSkipUntil$SkipUntilMainSubscriber.this.upstream);
            FlowableSkipUntil$SkipUntilMainSubscriber flowableSkipUntil$SkipUntilMainSubscriber = FlowableSkipUntil$SkipUntilMainSubscriber.this;
            io.reactivex.rxjava3.internal.util.e.d(flowableSkipUntil$SkipUntilMainSubscriber.downstream, th2, flowableSkipUntil$SkipUntilMainSubscriber, flowableSkipUntil$SkipUntilMainSubscriber.error);
        }

        public void onNext(Object obj) {
            FlowableSkipUntil$SkipUntilMainSubscriber.this.gate = true;
            ((d) get()).cancel();
        }

        public void onSubscribe(d dVar) {
            SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
        }
    }

    public FlowableSkipUntil$SkipUntilMainSubscriber(c<? super T> cVar) {
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
        if (!tryOnNext(t11)) {
            this.upstream.get().request(1);
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
    }

    public boolean tryOnNext(T t11) {
        if (!this.gate) {
            return false;
        }
        io.reactivex.rxjava3.internal.util.e.f(this.downstream, t11, this, this.error);
        return true;
    }
}
