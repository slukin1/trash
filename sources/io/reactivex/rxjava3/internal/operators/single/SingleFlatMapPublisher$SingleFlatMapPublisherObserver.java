package io.reactivex.rxjava3.internal.operators.single;

import h00.e;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class SingleFlatMapPublisher$SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements m<S>, e<T>, d {
    private static final long serialVersionUID = 7759721921468635667L;
    public b disposable;
    public final c<? super T> downstream;
    public final h<? super S, ? extends z20.b<? extends T>> mapper;
    public final AtomicReference<d> parent = new AtomicReference<>();

    public SingleFlatMapPublisher$SingleFlatMapPublisherObserver(c<? super T> cVar, h<? super S, ? extends z20.b<? extends T>> hVar) {
        this.downstream = cVar;
        this.mapper = hVar;
    }

    public void cancel() {
        this.disposable.dispose();
        SubscriptionHelper.cancel(this.parent);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        this.disposable = bVar;
        this.downstream.onSubscribe(this);
    }

    public void onSuccess(S s11) {
        try {
            Object apply = this.mapper.apply(s11);
            Objects.requireNonNull(apply, "the mapper returned a null Publisher");
            z20.b bVar = (z20.b) apply;
            if (this.parent.get() != SubscriptionHelper.CANCELLED) {
                bVar.subscribe(this);
            }
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.parent, this, j11);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.parent, this, dVar);
    }
}
