package kotlinx.coroutines;

import d10.p;
import f10.a;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;

public final class t1<T> extends o0<T> {

    /* renamed from: e  reason: collision with root package name */
    public final c<Unit> f57565e;

    public t1(CoroutineContext coroutineContext, p<? super h0, ? super c<? super T>, ? extends Object> pVar) {
        super(coroutineContext, false);
        this.f57565e = IntrinsicsKt__IntrinsicsJvmKt.b(pVar, this, this);
    }

    public void L0() {
        a.d(this.f57565e, this);
    }
}
