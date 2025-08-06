package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ParallelReduceFull$ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = -5370107872170712765L;
    public final AtomicReference<ParallelReduceFull$SlotPair<T>> current = new AtomicReference<>();
    public final AtomicThrowable error = new AtomicThrowable();
    public final c<T, T, T> reducer;
    public final AtomicInteger remaining = new AtomicInteger();
    public final ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] subscribers;

    public ParallelReduceFull$ParallelReduceFullMainSubscriber(z20.c<? super T> cVar, int i11, c<T, T, T> cVar2) {
        super(cVar);
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] parallelReduceFull$ParallelReduceFullInnerSubscriberArr = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            parallelReduceFull$ParallelReduceFullInnerSubscriberArr[i12] = new ParallelReduceFull$ParallelReduceFullInnerSubscriber<>(this, cVar2);
        }
        this.subscribers = parallelReduceFull$ParallelReduceFullInnerSubscriberArr;
        this.reducer = cVar2;
        this.remaining.lazySet(i11);
    }

    public ParallelReduceFull$SlotPair<T> addValue(T t11) {
        ParallelReduceFull$SlotPair<T> parallelReduceFull$SlotPair;
        int tryAcquireSlot;
        while (true) {
            parallelReduceFull$SlotPair = this.current.get();
            if (parallelReduceFull$SlotPair == null) {
                parallelReduceFull$SlotPair = new ParallelReduceFull$SlotPair<>();
                if (!this.current.compareAndSet((Object) null, parallelReduceFull$SlotPair)) {
                    continue;
                }
            }
            tryAcquireSlot = parallelReduceFull$SlotPair.tryAcquireSlot();
            if (tryAcquireSlot >= 0) {
                break;
            }
            this.current.compareAndSet(parallelReduceFull$SlotPair, (Object) null);
        }
        if (tryAcquireSlot == 0) {
            parallelReduceFull$SlotPair.first = t11;
        } else {
            parallelReduceFull$SlotPair.second = t11;
        }
        if (!parallelReduceFull$SlotPair.releaseSlot()) {
            return null;
        }
        this.current.compareAndSet(parallelReduceFull$SlotPair, (Object) null);
        return parallelReduceFull$SlotPair;
    }

    public void cancel() {
        for (ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void innerComplete(T t11) {
        if (t11 != null) {
            while (true) {
                ParallelReduceFull$SlotPair addValue = addValue(t11);
                if (addValue == null) {
                    break;
                }
                try {
                    t11 = this.reducer.apply(addValue.first, addValue.second);
                    Objects.requireNonNull(t11, "The reducer returned a null value");
                } catch (Throwable th2) {
                    a.b(th2);
                    innerError(th2);
                    return;
                }
            }
        }
        if (this.remaining.decrementAndGet() == 0) {
            ParallelReduceFull$SlotPair parallelReduceFull$SlotPair = this.current.get();
            this.current.lazySet((Object) null);
            if (parallelReduceFull$SlotPair != null) {
                complete(parallelReduceFull$SlotPair.first);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public void innerError(Throwable th2) {
        if (this.error.compareAndSet((Object) null, th2)) {
            cancel();
            this.downstream.onError(th2);
        } else if (th2 != this.error.get()) {
            o00.a.n(th2);
        }
    }
}
