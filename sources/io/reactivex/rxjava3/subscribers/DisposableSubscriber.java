package io.reactivex.rxjava3.subscribers;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

public abstract class DisposableSubscriber<T> implements e<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<d> f55785b = new AtomicReference<>();

    public final void a() {
        dispose();
    }

    public void b() {
        this.f55785b.get().request(Long.MAX_VALUE);
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.f55785b);
    }

    public final boolean isDisposed() {
        return this.f55785b.get() == SubscriptionHelper.CANCELLED;
    }

    public final void onSubscribe(d dVar) {
        if (io.reactivex.rxjava3.internal.util.d.d(this.f55785b, dVar, getClass())) {
            b();
        }
    }
}
