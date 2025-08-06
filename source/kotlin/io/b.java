package kotlin.io;

import java.io.Closeable;

public final class b {
    public static final void a(Closeable closeable, Throwable th2) {
        if (closeable == null) {
            return;
        }
        if (th2 == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th3) {
            ExceptionsKt__ExceptionsKt.a(th2, th3);
        }
    }
}
