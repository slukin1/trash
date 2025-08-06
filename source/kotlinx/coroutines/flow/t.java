package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.j;

public final /* synthetic */ class t {
    public static final Object a(d<?> dVar, c<? super Unit> cVar) {
        Object collect = dVar.collect(j.f57264b, cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }

    public static final <T> Object b(d<? extends T> dVar, p<? super T, ? super c<? super Unit>, ? extends Object> pVar, c<? super Unit> cVar) {
        Object h11 = f.h(u.b(f.L(dVar, pVar), 0, (BufferOverflow) null, 2, (Object) null), cVar);
        return h11 == IntrinsicsKt__IntrinsicsKt.d() ? h11 : Unit.f56620a;
    }

    public static final <T> Object c(e<? super T> eVar, d<? extends T> dVar, c<? super Unit> cVar) {
        f.x(eVar);
        Object collect = dVar.collect(eVar, cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }
}
