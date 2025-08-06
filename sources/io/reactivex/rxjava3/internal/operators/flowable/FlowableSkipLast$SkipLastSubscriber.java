package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import z20.c;
import z20.d;

final class FlowableSkipLast$SkipLastSubscriber<T> extends ArrayDeque<T> implements e<T>, d {
    private static final long serialVersionUID = -3807491841935125653L;
    public final c<? super T> downstream;
    public final int skip;
    public d upstream;

    public FlowableSkipLast$SkipLastSubscriber(c<? super T> cVar, int i11) {
        super(i11);
        this.downstream = cVar;
        this.skip = i11;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (this.skip == size()) {
            this.downstream.onNext(poll());
        } else {
            this.upstream.request(1);
        }
        offer(t11);
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j11) {
        this.upstream.request(j11);
    }
}
