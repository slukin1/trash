package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

public class StrictSubscriber<T> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -4945028590049415624L;
    public volatile boolean done;
    public final c<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public StrictSubscriber(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        if (!this.done) {
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    public void onComplete() {
        this.done = true;
        io.reactivex.rxjava3.internal.util.e.b(this.downstream, this, this.error);
    }

    public void onError(Throwable th2) {
        this.done = true;
        io.reactivex.rxjava3.internal.util.e.d(this.downstream, th2, this, this.error);
    }

    public void onNext(T t11) {
        io.reactivex.rxjava3.internal.util.e.f(this.downstream, t11, this, this.error);
    }

    public void onSubscribe(d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
            return;
        }
        dVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void request(long j11) {
        if (j11 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j11));
            return;
        }
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j11);
    }
}
