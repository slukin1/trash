package kotlinx.coroutines;

import d10.p;
import f10.a;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;

public final class u1 extends c2 {

    /* renamed from: e  reason: collision with root package name */
    public final c<Unit> f57569e;

    public u1(CoroutineContext coroutineContext, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar) {
        super(coroutineContext, false);
        this.f57569e = IntrinsicsKt__IntrinsicsJvmKt.b(pVar, this, this);
    }

    public void L0() {
        a.d(this.f57569e, this);
    }
}
