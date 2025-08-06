package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;

public final class a2 extends JobNode {

    /* renamed from: f  reason: collision with root package name */
    public final c<Unit> f56978f;

    public a2(c<? super Unit> cVar) {
        this.f56978f = cVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return Unit.f56620a;
    }

    public void q(Throwable th2) {
        c<Unit> cVar = this.f56978f;
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
    }
}
