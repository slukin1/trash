package io.reactivex.rxjava3.internal.operators.flowable;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;

final class FlowableConcatWithSingle$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements m<T> {
    private static final long serialVersionUID = -7346385463600070225L;
    public o<? extends T> other;
    public final AtomicReference<b> otherDisposable = new AtomicReference<>();

    public FlowableConcatWithSingle$ConcatWithSubscriber(c<? super T> cVar, o<? extends T> oVar) {
        super(cVar);
        this.other = oVar;
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        o<? extends T> oVar = this.other;
        this.other = null;
        oVar.a(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.produced++;
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.otherDisposable, bVar);
    }

    public void onSuccess(T t11) {
        complete(t11);
    }
}
