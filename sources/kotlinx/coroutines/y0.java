package kotlinx.coroutines;

import kotlin.Unit;

public final class y0 extends CancelHandler {

    /* renamed from: b  reason: collision with root package name */
    public final x0 f57584b;

    public y0(x0 x0Var) {
        this.f57584b = x0Var;
    }

    public void g(Throwable th2) {
        this.f57584b.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return Unit.f56620a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f57584b + ']';
    }
}
