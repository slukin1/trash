package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.e;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import k00.a;
import z20.b;
import z20.c;
import z20.d;

final class FlowableWithLatestFromMany$WithLatestFromSubscriber<T, R> extends AtomicInteger implements a<T>, d {
    private static final long serialVersionUID = 1577321883966341961L;
    public final h<? super Object[], R> combiner;
    public volatile boolean done;
    public final c<? super R> downstream;
    public final AtomicThrowable error;
    public final AtomicLong requested;
    public final FlowableWithLatestFromMany$WithLatestInnerSubscriber[] subscribers;
    public final AtomicReference<d> upstream;
    public final AtomicReferenceArray<Object> values;

    public FlowableWithLatestFromMany$WithLatestFromSubscriber(c<? super R> cVar, h<? super Object[], R> hVar, int i11) {
        this.downstream = cVar;
        this.combiner = hVar;
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = new FlowableWithLatestFromMany$WithLatestInnerSubscriber[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i12] = new FlowableWithLatestFromMany$WithLatestInnerSubscriber(this, i12);
        }
        this.subscribers = flowableWithLatestFromMany$WithLatestInnerSubscriberArr;
        this.values = new AtomicReferenceArray<>(i11);
        this.upstream = new AtomicReference<>();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        for (FlowableWithLatestFromMany$WithLatestInnerSubscriber dispose : this.subscribers) {
            dispose.dispose();
        }
    }

    public void cancelAllBut(int i11) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        for (int i12 = 0; i12 < flowableWithLatestFromMany$WithLatestInnerSubscriberArr.length; i12++) {
            if (i12 != i11) {
                flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i12].dispose();
            }
        }
    }

    public void innerComplete(int i11, boolean z11) {
        if (!z11) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(i11);
            e.b(this.downstream, this, this.error);
        }
    }

    public void innerError(int i11, Throwable th2) {
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        cancelAllBut(i11);
        e.d(this.downstream, th2, this, this.error);
    }

    public void innerNext(int i11, Object obj) {
        this.values.set(i11, obj);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            cancelAllBut(-1);
            e.b(this.downstream, this, this.error);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        e.d(this.downstream, th2, this, this.error);
    }

    public void onNext(T t11) {
        if (!tryOnNext(t11) && !this.done) {
            this.upstream.get().request(1);
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
    }

    public void subscribe(b<?>[] bVarArr, int i11) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        AtomicReference<d> atomicReference = this.upstream;
        for (int i12 = 0; i12 < i11 && atomicReference.get() != SubscriptionHelper.CANCELLED; i12++) {
            bVarArr[i12].subscribe(flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i12]);
        }
    }

    public boolean tryOnNext(T t11) {
        if (this.done) {
            return false;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[(length + 1)];
        objArr[0] = t11;
        int i11 = 0;
        while (i11 < length) {
            Object obj = atomicReferenceArray.get(i11);
            if (obj == null) {
                return false;
            }
            i11++;
            objArr[i11] = obj;
        }
        try {
            R apply = this.combiner.apply(objArr);
            Objects.requireNonNull(apply, "The combiner returned a null value");
            e.f(this.downstream, apply, this, this.error);
            return true;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            cancel();
            onError(th2);
            return false;
        }
    }
}
