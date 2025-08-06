package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

public final class Futures extends GwtFuturesCatchingSpecialization {
    public static <V> ListenableFuture<V> a(Throwable th2) {
        Preconditions.i(th2);
        return new ImmediateFuture$ImmediateFailedFuture(th2);
    }
}
