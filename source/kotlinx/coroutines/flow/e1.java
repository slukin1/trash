package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;

public final class e1<T> extends AbstractFlow<T> {

    /* renamed from: b  reason: collision with root package name */
    public final p<e<? super T>, c<? super Unit>, Object> f57222b;

    public e1(p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        this.f57222b = pVar;
    }

    public Object collectSafely(e<? super T> eVar, c<? super Unit> cVar) {
        Object invoke = this.f57222b.invoke(eVar, cVar);
        return invoke == IntrinsicsKt__IntrinsicsKt.d() ? invoke : Unit.f56620a;
    }
}
