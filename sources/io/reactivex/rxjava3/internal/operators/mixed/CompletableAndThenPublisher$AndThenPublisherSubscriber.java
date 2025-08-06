package io.reactivex.rxjava3.internal.operators.mixed;

import h00.a;
import h00.e;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.c;
import z20.d;

final class CompletableAndThenPublisher$AndThenPublisherSubscriber<R> extends AtomicReference<d> implements e<R>, a, d {
    private static final long serialVersionUID = -8948264376121066672L;
    public final c<? super R> downstream;
    public b<? extends R> other;
    public final AtomicLong requested = new AtomicLong();
    public io.reactivex.rxjava3.disposables.b upstream;

    public CompletableAndThenPublisher$AndThenPublisherSubscriber(c<? super R> cVar, b<? extends R> bVar) {
        this.downstream = cVar;
        this.other = bVar;
    }

    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        b<? extends R> bVar = this.other;
        if (bVar == null) {
            this.downstream.onComplete();
            return;
        }
        this.other = null;
        bVar.subscribe(this);
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

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this, this.requested, j11);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
    }
}
