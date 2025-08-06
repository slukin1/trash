package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class k2 {
    public static final ExecutorCoroutineDispatcher b(int i11, String str) {
        boolean z11 = true;
        if (i11 < 1) {
            z11 = false;
        }
        if (z11) {
            return f1.b(Executors.newScheduledThreadPool(i11, new j2(i11, str, new AtomicInteger())));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i11 + " specified").toString());
    }

    public static final Thread c(int i11, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i11 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
