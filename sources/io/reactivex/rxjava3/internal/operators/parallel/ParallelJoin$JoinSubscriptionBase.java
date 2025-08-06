package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

abstract class ParallelJoin$JoinSubscriptionBase<T> extends AtomicInteger implements d {
    private static final long serialVersionUID = 3100232009247827843L;
    public volatile boolean cancelled;
    public final AtomicInteger done = new AtomicInteger();
    public final c<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();
    public final ParallelJoin$JoinInnerSubscriber<T>[] subscribers;

    public ParallelJoin$JoinSubscriptionBase(c<? super T> cVar, int i11, int i12) {
        this.downstream = cVar;
        ParallelJoin$JoinInnerSubscriber<T>[] parallelJoin$JoinInnerSubscriberArr = new ParallelJoin$JoinInnerSubscriber[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            parallelJoin$JoinInnerSubscriberArr[i13] = new ParallelJoin$JoinInnerSubscriber<>(this, i12);
        }
        this.subscribers = parallelJoin$JoinInnerSubscriberArr;
        this.done.lazySet(i11);
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }
    }

    public void cancelAll() {
        for (ParallelJoin$JoinInnerSubscriber<T> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void cleanup() {
        for (ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber : this.subscribers) {
            parallelJoin$JoinInnerSubscriber.queue = null;
        }
    }

    public abstract void drain();

    public abstract void onComplete();

    public abstract void onError(Throwable th2);

    public abstract void onNext(ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber, T t11);

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }
}
