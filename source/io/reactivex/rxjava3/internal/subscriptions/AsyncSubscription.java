package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

public final class AsyncSubscription extends AtomicLong implements d, b {
    private static final long serialVersionUID = 7028635084060361255L;
    public final AtomicReference<d> actual;
    public final AtomicReference<b> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    public boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(b bVar) {
        return DisposableHelper.replace(this.resource, bVar);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.actual, this, j11);
    }

    public boolean setResource(b bVar) {
        return DisposableHelper.set(this.resource, bVar);
    }

    public void setSubscription(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, dVar);
    }

    public AsyncSubscription(b bVar) {
        this();
        this.resource.lazySet(bVar);
    }
}
