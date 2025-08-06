package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;

public final class b<V> extends AbstractResolvableFuture<V> {
    public static <V> b<V> a() {
        return new b<>();
    }

    public boolean set(V v11) {
        return super.set(v11);
    }

    public boolean setException(Throwable th2) {
        return super.setException(th2);
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
