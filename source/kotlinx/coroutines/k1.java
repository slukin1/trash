package kotlinx.coroutines;

import d10.l;
import kotlin.Unit;

public final class k1 extends CancelHandler {

    /* renamed from: b  reason: collision with root package name */
    public final l<Throwable, Unit> f57363b;

    public k1(l<? super Throwable, Unit> lVar) {
        this.f57363b = lVar;
    }

    public void g(Throwable th2) {
        this.f57363b.invoke(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return Unit.f56620a;
    }

    public String toString() {
        return "InvokeOnCancel[" + k0.a(this.f57363b) + '@' + k0.b(this) + ']';
    }
}
