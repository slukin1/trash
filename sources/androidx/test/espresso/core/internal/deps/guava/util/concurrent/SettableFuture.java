package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture;

public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> C() {
        return new SettableFuture<>();
    }

    public boolean y(V v11) {
        return super.y(v11);
    }

    public boolean z(Throwable th2) {
        return super.z(th2);
    }
}
