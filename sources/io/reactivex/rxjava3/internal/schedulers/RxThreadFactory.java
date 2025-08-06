package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    public final boolean nonBlocking;
    public final String prefix;
    public final int priority;

    public static final class a extends Thread implements c {
        public a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread aVar = this.nonBlocking ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    public RxThreadFactory(String str, int i11) {
        this(str, i11, false);
    }

    public RxThreadFactory(String str, int i11, boolean z11) {
        this.prefix = str;
        this.priority = i11;
        this.nonBlocking = z11;
    }
}
