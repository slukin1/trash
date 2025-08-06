package io.reactivex.rxjava3.internal.operators.parallel;

import h00.e;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class ParallelJoin$JoinInnerSubscriber<T> extends AtomicReference<d> implements e<T> {
    private static final long serialVersionUID = 8410034718427740355L;
    public final int limit;
    public final ParallelJoin$JoinSubscriptionBase<T> parent;
    public final int prefetch;
    public long produced;
    public volatile k00.e<T> queue;

    public ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase<T> parallelJoin$JoinSubscriptionBase, int i11) {
        this.parent = parallelJoin$JoinSubscriptionBase;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    public k00.e<T> getQueue() {
        k00.e<T> eVar = this.queue;
        if (eVar != null) {
            return eVar;
        }
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        this.queue = spscArrayQueue;
        return spscArrayQueue;
    }

    public void onComplete() {
        this.parent.onComplete();
    }

    public void onError(Throwable th2) {
        this.parent.onError(th2);
    }

    public void onNext(T t11) {
        this.parent.onNext(this, t11);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, (long) this.prefetch);
    }

    public void request(long j11) {
        long j12 = this.produced + j11;
        if (j12 >= ((long) this.limit)) {
            this.produced = 0;
            ((d) get()).request(j12);
            return;
        }
        this.produced = j12;
    }

    public void requestOne() {
        long j11 = this.produced + 1;
        if (j11 == ((long) this.limit)) {
            this.produced = 0;
            ((d) get()).request(j11);
            return;
        }
        this.produced = j11;
    }
}
