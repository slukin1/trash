package kotlinx.coroutines.channels;

import d10.q;
import f10.a;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.selects.h;
import kotlinx.coroutines.selects.i;
import kotlinx.coroutines.selects.k;

public final class LazyActorCoroutine<E> extends a<E> {

    /* renamed from: f  reason: collision with root package name */
    public c<? super Unit> f57042f;

    public boolean K(Throwable th2) {
        boolean K = super.K(th2);
        start();
        return K;
    }

    public void L0() {
        a.d(this.f57042f, this);
    }

    public h<E, m<E>> d() {
        return new i(this, (q) TypeIntrinsics.e(LazyActorCoroutine$onSend$1.INSTANCE, 3), super.d().b(), (q) null, 8, (r) null);
    }

    public final void i1(k<?> kVar, Object obj) {
        L0();
        super.d().c().invoke(this, kVar, obj);
    }

    public Object q(E e11) {
        start();
        return super.q(e11);
    }

    public Object send(E e11, c<? super Unit> cVar) {
        start();
        Object send = super.send(e11, cVar);
        return send == IntrinsicsKt__IntrinsicsKt.d() ? send : Unit.f56620a;
    }
}
