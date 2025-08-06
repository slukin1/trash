package io.reactivex.rxjava3.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;
import k00.b;

public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ void dispose();

    public abstract /* synthetic */ boolean isDisposed();

    public abstract /* synthetic */ boolean isEmpty();

    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public abstract /* synthetic */ T poll() throws Throwable;

    public abstract /* synthetic */ int requestFusion(int i11);

    public final boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
