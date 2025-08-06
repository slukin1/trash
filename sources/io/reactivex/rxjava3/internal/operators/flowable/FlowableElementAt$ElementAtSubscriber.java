package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import o00.a;
import z20.c;
import z20.d;

final class FlowableElementAt$ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements e<T> {
    private static final long serialVersionUID = 4066607327284737757L;
    public long count;
    public final T defaultValue;
    public boolean done;
    public final boolean errorOnFewer;
    public final long index;
    public d upstream;

    public FlowableElementAt$ElementAtSubscriber(c<? super T> cVar, long j11, T t11, boolean z11) {
        super(cVar);
        this.index = j11;
        this.defaultValue = t11;
        this.errorOnFewer = z11;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            T t11 = this.defaultValue;
            if (t11 != null) {
                complete(t11);
            } else if (this.errorOnFewer) {
                this.downstream.onError(new NoSuchElementException());
            } else {
                this.downstream.onComplete();
            }
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
            long j11 = this.count;
            if (j11 == this.index) {
                this.done = true;
                this.upstream.cancel();
                complete(t11);
                return;
            }
            this.count = j11 + 1;
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
