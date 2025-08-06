package kotlinx.coroutines;

import kotlin.Unit;

public final class p extends JobCancellingNode {

    /* renamed from: f  reason: collision with root package name */
    public final l<?> f57388f;

    public p(l<?> lVar) {
        this.f57388f = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return Unit.f56620a;
    }

    public void q(Throwable th2) {
        l<?> lVar = this.f57388f;
        lVar.K(lVar.t(r()));
    }
}
