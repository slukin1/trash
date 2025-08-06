package io.reactivex.rxjava3.internal.operators.flowable;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;

final class FlowableConcatWithMaybe$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements f<T> {
    private static final long serialVersionUID = -7346385463600070225L;
    public boolean inMaybe;
    public g<? extends T> other;
    public final AtomicReference<b> otherDisposable = new AtomicReference<>();

    public FlowableConcatWithMaybe$ConcatWithSubscriber(c<? super T> cVar, g<? extends T> gVar) {
        super(cVar);
        this.other = gVar;
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        if (this.inMaybe) {
            this.downstream.onComplete();
            return;
        }
        this.inMaybe = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        g<? extends T> gVar = this.other;
        this.other = null;
        gVar.a(this);
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
