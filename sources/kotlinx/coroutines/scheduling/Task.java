package kotlinx.coroutines.scheduling;

import g10.d;
import g10.g;

public abstract class Task implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public long f57493b;

    /* renamed from: c  reason: collision with root package name */
    public d f57494c;

    public Task(long j11, d dVar) {
        this.f57493b = j11;
        this.f57494c = dVar;
    }

    public Task() {
        this(0, g.f54787g);
    }
}
