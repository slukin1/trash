package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class Uninterruptibles {
    public static <V> V a(Future<V> future) throws ExecutionException {
        V v11;
        boolean z11 = false;
        while (true) {
            try {
                v11 = future.get();
                break;
            } catch (InterruptedException unused) {
                z11 = true;
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return v11;
    }
}
