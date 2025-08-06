package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class UndispatchedContextCollector<T> implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineContext f57256b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f57257c;

    /* renamed from: d  reason: collision with root package name */
    public final p<T, c<? super Unit>, Object> f57258d;

    public UndispatchedContextCollector(e<? super T> eVar, CoroutineContext coroutineContext) {
        this.f57256b = coroutineContext;
        this.f57257c = ThreadContextKt.b(coroutineContext);
        this.f57258d = new UndispatchedContextCollector$emitRef$1(eVar, (c<? super UndispatchedContextCollector$emitRef$1>) null);
    }

    public Object emit(T t11, c<? super Unit> cVar) {
        Object c11 = b.c(this.f57256b, t11, this.f57257c, this.f57258d, cVar);
        return c11 == IntrinsicsKt__IntrinsicsKt.d() ? c11 : Unit.f56620a;
    }
}
