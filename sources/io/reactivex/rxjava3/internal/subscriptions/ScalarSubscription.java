package io.reactivex.rxjava3.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import k00.d;
import z20.c;

public final class ScalarSubscription<T> extends AtomicInteger implements d<T> {
    public static final int CANCELLED = 2;
    public static final int NO_REQUEST = 0;
    public static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    public final c<? super T> subscriber;
    public final T value;

    public ScalarSubscription(c<? super T> cVar, T t11) {
        this.subscriber = cVar;
        this.value = t11;
    }

    public void cancel() {
        lazySet(2);
    }

    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11) && compareAndSet(0, 1)) {
            c<? super T> cVar = this.subscriber;
            cVar.onNext(this.value);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    public int requestFusion(int i11) {
        return i11 & 1;
    }

    public boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
