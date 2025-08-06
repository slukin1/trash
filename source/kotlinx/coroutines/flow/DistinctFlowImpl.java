package kotlinx.coroutines.flow;

import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.k;

public final class DistinctFlowImpl<T> implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public final d<T> f57122b;

    /* renamed from: c  reason: collision with root package name */
    public final l<T, Object> f57123c;

    /* renamed from: d  reason: collision with root package name */
    public final p<Object, Object, Boolean> f57124d;

    public DistinctFlowImpl(d<? extends T> dVar, l<? super T, ? extends Object> lVar, p<Object, Object, Boolean> pVar) {
        this.f57122b = dVar;
        this.f57123c = lVar;
        this.f57124d = pVar;
    }

    public Object collect(e<? super T> eVar, c<? super Unit> cVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = k.f57265a;
        Object collect = this.f57122b.collect(new DistinctFlowImpl$collect$2(this, ref$ObjectRef, eVar), cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }
}
