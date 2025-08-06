package kotlinx.coroutines;

import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.g0;

public final class g2 {

    /* renamed from: a  reason: collision with root package name */
    public static final g2 f57278a = new g2();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<EventLoop> f57279b = g0.a(new c0("ThreadLocalEventLoop"));

    public final EventLoop a() {
        return f57279b.get();
    }

    public final EventLoop b() {
        ThreadLocal<EventLoop> threadLocal = f57279b;
        EventLoop eventLoop = threadLocal.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        EventLoop a11 = b1.a();
        threadLocal.set(a11);
        return a11;
    }

    public final void c() {
        f57279b.set((Object) null);
    }

    public final void d(EventLoop eventLoop) {
        f57279b.set(eventLoop);
    }
}
