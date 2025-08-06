package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k00.a;
import z20.d;

final class FlowableWithLatestFrom$WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements a<T>, d {
    private static final long serialVersionUID = -312246233408980075L;
    public final c<? super T, ? super U, ? extends R> combiner;
    public final z20.c<? super R> downstream;
    public final AtomicReference<d> other = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public FlowableWithLatestFrom$WithLatestFromSubscriber(z20.c<? super R> cVar, c<? super T, ? super U, ? extends R> cVar2) {
        this.downstream = cVar;
        this.combiner = cVar2;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!tryOnNext(t11)) {
            this.upstream.get().request(1);
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    public void otherError(Throwable th2) {
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(th2);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
    }

    public boolean setOther(d dVar) {
        return SubscriptionHelper.setOnce(this.other, dVar);
    }

    public boolean tryOnNext(T t11) {
        Object obj = get();
        if (obj != null) {
            try {
                Object apply = this.combiner.apply(t11, obj);
                Objects.requireNonNull(apply, "The combiner returned a null value");
                this.downstream.onNext(apply);
                return true;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }
        return false;
    }
}
