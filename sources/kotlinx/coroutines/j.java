package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Unit;

public final class j extends CancelHandler {

    /* renamed from: b  reason: collision with root package name */
    public final Future<?> f57354b;

    public j(Future<?> future) {
        this.f57354b = future;
    }

    public void g(Throwable th2) {
        if (th2 != null) {
            this.f57354b.cancel(false);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return Unit.f56620a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f57354b + ']';
    }
}
