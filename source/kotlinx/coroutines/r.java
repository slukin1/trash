package kotlinx.coroutines;

import kotlin.Unit;

public final class r extends JobCancellingNode implements q {

    /* renamed from: f  reason: collision with root package name */
    public final s f57390f;

    public r(s sVar) {
        this.f57390f = sVar;
    }

    public boolean b(Throwable th2) {
        return r().d0(th2);
    }

    public n1 getParent() {
        return r();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return Unit.f56620a;
    }

    public void q(Throwable th2) {
        this.f57390f.k(r());
    }
}
