package g10;

import kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher;

public final class b extends SchedulerCoroutineDispatcher {

    /* renamed from: i  reason: collision with root package name */
    public static final b f54777i = new b();

    public b() {
        super(g.f54783c, g.f54784d, g.f54785e, g.f54781a);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
