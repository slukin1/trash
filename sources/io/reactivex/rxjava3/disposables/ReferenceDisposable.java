package io.reactivex.rxjava3.disposables;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferenceDisposable(T t11) {
        super(t11);
        Objects.requireNonNull(t11, "value is null");
    }

    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            onDisposed(andSet);
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }

    public abstract void onDisposed(T t11);
}
