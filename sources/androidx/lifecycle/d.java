package androidx.lifecycle;

import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.r1;

public final class d implements Closeable, h0 {

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineContext f9996b;

    public d(CoroutineContext coroutineContext) {
        this.f9996b = coroutineContext;
    }

    public void close() {
        r1.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f9996b;
    }
}
