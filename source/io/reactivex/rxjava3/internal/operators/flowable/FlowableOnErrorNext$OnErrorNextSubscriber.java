package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import j00.h;
import java.util.Objects;
import z20.b;
import z20.c;
import z20.d;

final class FlowableOnErrorNext$OnErrorNextSubscriber<T> extends SubscriptionArbiter implements e<T> {
    private static final long serialVersionUID = 4063763155303814625L;
    public boolean done;
    public final c<? super T> downstream;
    public final h<? super Throwable, ? extends b<? extends T>> nextSupplier;
    public boolean once;
    public long produced;

    public FlowableOnErrorNext$OnErrorNextSubscriber(c<? super T> cVar, h<? super Throwable, ? extends b<? extends T>> hVar) {
        super(false);
        this.downstream = cVar;
        this.nextSupplier = hVar;
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (!this.once) {
            this.once = true;
            try {
                Object apply = this.nextSupplier.apply(th2);
                Objects.requireNonNull(apply, "The nextSupplier returned a null Publisher");
                b bVar = (b) apply;
                long j11 = this.produced;
                if (j11 != 0) {
                    produced(j11);
                }
                bVar.subscribe(this);
            } catch (Throwable th3) {
                a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        } else if (this.done) {
            o00.a.n(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    public void onNext(T t11) {
        if (!this.done) {
            if (!this.once) {
                this.produced++;
            }
            this.downstream.onNext(t11);
        }
    }

    public void onSubscribe(d dVar) {
        setSubscription(dVar);
    }
}
