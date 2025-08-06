package kotlinx.coroutines;

import d10.l;
import kotlin.Unit;

public final class m1 extends JobNode {

    /* renamed from: f  reason: collision with root package name */
    public final l<Throwable, Unit> f57380f;

    public m1(l<? super Throwable, Unit> lVar) {
        this.f57380f = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return Unit.f56620a;
    }

    public void q(Throwable th2) {
        this.f57380f.invoke(th2);
    }
}
