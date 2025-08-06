package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

public final class SubscriberResourceWrapper<T> extends AtomicReference<b> implements e<T>, b, d {
    private static final long serialVersionUID = -8612022020200669122L;
    public final c<? super T> downstream;
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.upstream.get().request(j11);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
