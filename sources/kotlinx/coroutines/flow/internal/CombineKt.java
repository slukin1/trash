package kotlinx.coroutines.flow.internal;

import d10.a;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;

public final class CombineKt {
    public static final <R, T> Object a(e<? super R> eVar, d<? extends T>[] dVarArr, a<T[]> aVar, q<? super e<? super R>, ? super T[], ? super c<? super Unit>, ? extends Object> qVar, c<? super Unit> cVar) {
        Object a11 = FlowCoroutineKt.a(new CombineKt$combineInternal$2(dVarArr, aVar, qVar, eVar, (c<? super CombineKt$combineInternal$2>) null), cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }
}
