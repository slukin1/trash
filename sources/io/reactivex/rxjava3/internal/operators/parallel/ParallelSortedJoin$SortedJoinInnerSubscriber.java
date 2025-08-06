package io.reactivex.rxjava3.internal.operators.parallel;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class ParallelSortedJoin$SortedJoinInnerSubscriber<T> extends AtomicReference<d> implements e<List<T>> {
    private static final long serialVersionUID = 6751017204873808094L;
    public final int index;
    public final ParallelSortedJoin$SortedJoinSubscription<T> parent;

    public ParallelSortedJoin$SortedJoinInnerSubscriber(ParallelSortedJoin$SortedJoinSubscription<T> parallelSortedJoin$SortedJoinSubscription, int i11) {
        this.parent = parallelSortedJoin$SortedJoinSubscription;
        this.index = i11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
    }

    public void onError(Throwable th2) {
        this.parent.innerError(th2);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }

    public void onNext(List<T> list) {
        this.parent.innerNext(list, this.index);
    }
}
