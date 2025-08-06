package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlinx.coroutines.d0;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Collection<d0> f57308a;

    static {
        Class<d0> cls = d0.class;
        f57308a = SequencesKt___SequencesKt.w(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final Collection<d0> a() {
        return f57308a;
    }

    public static final void b(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }
}
