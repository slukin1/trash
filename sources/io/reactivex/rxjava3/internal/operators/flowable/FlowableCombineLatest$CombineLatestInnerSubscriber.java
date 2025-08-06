package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class FlowableCombineLatest$CombineLatestInnerSubscriber<T> extends AtomicReference<d> implements e<T> {
    private static final long serialVersionUID = -8730235182291002949L;
    public final int index;
    public final int limit;
    public final FlowableCombineLatest$CombineLatestCoordinator<T, ?> parent;
    public final int prefetch;
    public int produced;

    public FlowableCombineLatest$CombineLatestInnerSubscriber(FlowableCombineLatest$CombineLatestCoordinator<T, ?> flowableCombineLatest$CombineLatestCoordinator, int i11, int i12) {
        this.parent = flowableCombineLatest$CombineLatestCoordinator;
        this.index = i11;
        this.prefetch = i12;
        this.limit = i12 - (i12 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(this.index, th2);
    }

    public void onNext(T t11) {
        this.parent.innerValue(this.index, t11);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, (long) this.prefetch);
    }

    public void requestOne() {
        int i11 = this.produced + 1;
        if (i11 == this.limit) {
            this.produced = 0;
            ((d) get()).request((long) i11);
            return;
        }
        this.produced = i11;
    }
}
