package io.reactivex.rxjava3.internal.operators.flowable;

import h00.a;
import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableConcatWithCompletable$ConcatWithSubscriber<T> extends AtomicReference<b> implements e<T>, a, d {
    private static final long serialVersionUID = -7346385463600070225L;
    public final c<? super T> downstream;
    public boolean inCompletable;
    public h00.b other;
    public d upstream;

    public FlowableConcatWithCompletable$ConcatWithSubscriber(c<? super T> cVar, h00.b bVar) {
        this.downstream = cVar;
        this.other = bVar;
    }

    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        if (this.inCompletable) {
            this.downstream.onComplete();
            return;
        }
        this.inCompletable = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        h00.b bVar = this.other;
        this.other = null;
        bVar.a(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j11) {
        this.upstream.request(j11);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
