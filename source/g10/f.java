package g10;

import kotlinx.coroutines.k0;
import kotlinx.coroutines.scheduling.Task;

public final class f extends Task {

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f54780d;

    public f(Runnable runnable, long j11, d dVar) {
        super(j11, dVar);
        this.f54780d = runnable;
    }

    public void run() {
        try {
            this.f54780d.run();
        } finally {
            this.f57494c.a();
        }
    }

    public String toString() {
        return "Task[" + k0.a(this.f54780d) + '@' + k0.b(this.f54780d) + ", " + this.f57493b + ", " + this.f57494c + ']';
    }
}
