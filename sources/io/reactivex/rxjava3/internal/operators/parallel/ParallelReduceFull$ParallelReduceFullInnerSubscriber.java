package io.reactivex.rxjava3.internal.operators.parallel;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.d;

final class ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> extends AtomicReference<d> implements e<T> {
    private static final long serialVersionUID = -7954444275102466525L;
    public boolean done;
    public final ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parent;
    public final c<T, T, T> reducer;
    public T value;

    public ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parallelReduceFull$ParallelReduceFullMainSubscriber, c<T, T, T> cVar) {
        this.parent = parallelReduceFull$ParallelReduceFullMainSubscriber;
        this.reducer = cVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.parent.innerComplete(this.value);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.parent.innerError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            T t12 = this.value;
            if (t12 == null) {
                this.value = t11;
                return;
            }
            try {
                T apply = this.reducer.apply(t12, t11);
                Objects.requireNonNull(apply, "The reducer returned a null value");
                this.value = apply;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                ((d) get()).cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
