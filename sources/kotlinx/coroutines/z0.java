package kotlinx.coroutines;

import kotlin.Unit;

public final class z0 extends JobNode {

    /* renamed from: f  reason: collision with root package name */
    public final x0 f57587f;

    public z0(x0 x0Var) {
        this.f57587f = x0Var;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return Unit.f56620a;
    }

    public void q(Throwable th2) {
        this.f57587f.dispose();
    }
}
