package io.reactivex.rxjava3.internal.operators.mixed;

import h00.e;
import h00.f;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.c;
import z20.d;

final class MaybeFlatMapPublisher$FlatMapPublisherSubscriber<T, R> extends AtomicReference<d> implements e<R>, f<T>, d {
    private static final long serialVersionUID = -8948264376121066672L;
    public final c<? super R> downstream;
    public final h<? super T, ? extends b<? extends R>> mapper;
    public final AtomicLong requested = new AtomicLong();
    public io.reactivex.rxjava3.disposables.b upstream;

    public MaybeFlatMapPublisher$FlatMapPublisherSubscriber(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar) {
        this.downstream = cVar;
        this.mapper = hVar;
    }

    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(R r11) {
        this.downstream.onNext(r11);
    }

    public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            b bVar = (b) apply;
            if (get() != SubscriptionHelper.CANCELLED) {
                bVar.subscribe(this);
            }
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this, this.requested, j11);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
    }
}
