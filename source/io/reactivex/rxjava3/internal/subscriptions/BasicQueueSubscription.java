package io.reactivex.rxjava3.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import k00.d;

public abstract class BasicQueueSubscription<T> extends AtomicLong implements d<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public abstract /* synthetic */ void cancel();

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ boolean isEmpty();

    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public abstract /* synthetic */ T poll() throws Throwable;

    public abstract /* synthetic */ void request(long j11);

    public abstract /* synthetic */ int requestFusion(int i11);

    public final boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
