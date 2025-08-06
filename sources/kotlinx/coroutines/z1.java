package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.k;

public final class z1<T> extends JobNode {

    /* renamed from: f  reason: collision with root package name */
    public final l<T> f57588f;

    public z1(l<? super T> lVar) {
        this.f57588f = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return Unit.f56620a;
    }

    public void q(Throwable th2) {
        Object s02 = r().s0();
        if (j0.a() && !(!(s02 instanceof i1))) {
            throw new AssertionError();
        } else if (s02 instanceof y) {
            l<T> lVar = this.f57588f;
            Result.a aVar = Result.Companion;
            lVar.resumeWith(Result.m3072constructorimpl(k.a(((y) s02).f57583a)));
        } else {
            l<T> lVar2 = this.f57588f;
            Result.a aVar2 = Result.Companion;
            lVar2.resumeWith(Result.m3072constructorimpl(s1.h(s02)));
        }
    }
}
