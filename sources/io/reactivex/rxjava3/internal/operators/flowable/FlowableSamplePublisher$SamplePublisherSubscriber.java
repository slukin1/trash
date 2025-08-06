package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.c;
import z20.d;

abstract class FlowableSamplePublisher$SamplePublisherSubscriber<T> extends AtomicReference<T> implements e<T>, d {
    private static final long serialVersionUID = -3517602651313910099L;
    public final c<? super T> downstream;
    public final AtomicReference<d> other = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final b<?> sampler;
    public d upstream;

    public FlowableSamplePublisher$SamplePublisherSubscriber(c<? super T> cVar, b<?> bVar) {
        this.downstream = cVar;
        this.sampler = bVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.upstream.cancel();
    }

    public void complete() {
        this.upstream.cancel();
        completion();
    }

    public abstract void completion();

    public void emit() {
        Object andSet = getAndSet((Object) null);
        if (andSet == null) {
            return;
        }
        if (this.requested.get() != 0) {
            this.downstream.onNext(andSet);
            io.reactivex.rxjava3.internal.util.b.e(this.requested, 1);
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
    }

    public void error(Throwable th2) {
        this.upstream.cancel();
        this.downstream.onError(th2);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        completion();
    }

    public void onError(Throwable th2) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        lazySet(t11);
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            if (this.other.get() == null) {
                this.sampler.subscribe(new l(this));
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
        }
    }

    public abstract void run();

    public void setOther(d dVar) {
        SubscriptionHelper.setOnce(this.other, dVar, Long.MAX_VALUE);
    }
}
