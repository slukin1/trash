package kotlinx.coroutines;

import java.util.concurrent.Future;

public final class w0 implements x0 {

    /* renamed from: b  reason: collision with root package name */
    public final Future<?> f57575b;

    public w0(Future<?> future) {
        this.f57575b = future;
    }

    public void dispose() {
        this.f57575b.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f57575b + ']';
    }
}
