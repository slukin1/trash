package io.reactivex.rxjava3.subscribers;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

public abstract class ResourceSubscriber<T> implements e<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<d> f55786b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final ListCompositeDisposable f55787c = new ListCompositeDisposable();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f55788d = new AtomicLong();

    public void a() {
        b(Long.MAX_VALUE);
    }

    public final void b(long j11) {
        SubscriptionHelper.deferredRequest(this.f55786b, this.f55788d, j11);
    }

    public final void dispose() {
        if (SubscriptionHelper.cancel(this.f55786b)) {
            this.f55787c.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f55786b.get() == SubscriptionHelper.CANCELLED;
    }

    public final void onSubscribe(d dVar) {
        if (io.reactivex.rxjava3.internal.util.d.d(this.f55786b, dVar, getClass())) {
            long andSet = this.f55788d.getAndSet(0);
            if (andSet != 0) {
                dVar.request(andSet);
            }
            a();
        }
    }
}
