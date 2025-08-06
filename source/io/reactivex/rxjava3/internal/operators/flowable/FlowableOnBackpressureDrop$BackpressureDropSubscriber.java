package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.g;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.c;
import z20.d;

final class FlowableOnBackpressureDrop$BackpressureDropSubscriber<T> extends AtomicLong implements e<T>, d {
    private static final long serialVersionUID = -6246093802440953054L;
    public boolean done;
    public final c<? super T> downstream;
    public final g<? super T> onDrop;
    public d upstream;

    public FlowableOnBackpressureDrop$BackpressureDropSubscriber(c<? super T> cVar, g<? super T> gVar) {
        this.downstream = cVar;
        this.onDrop = gVar;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            if (get() != 0) {
                this.downstream.onNext(t11);
                b.e(this, 1);
                return;
            }
            try {
                this.onDrop.accept(t11);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this, j11);
        }
    }
}
