package cw;

import android.os.Looper;
import java.util.Objects;

public final class a {
    public static <T> T a(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }

    public static void b() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread. Was: " + Thread.currentThread());
        }
    }
}
