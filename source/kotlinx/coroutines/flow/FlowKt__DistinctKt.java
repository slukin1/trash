package kotlinx.coroutines.flow;

import d10.l;
import d10.p;
import kotlin.jvm.internal.TypeIntrinsics;

public final /* synthetic */ class FlowKt__DistinctKt {

    /* renamed from: a  reason: collision with root package name */
    public static final l<Object, Object> f57134a = FlowKt__DistinctKt$defaultKeySelector$1.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    public static final p<Object, Object, Boolean> f57135b = FlowKt__DistinctKt$defaultAreEquivalent$1.INSTANCE;

    public static final <T> d<T> a(d<? extends T> dVar) {
        return dVar instanceof j1 ? dVar : c(dVar, f57134a, f57135b);
    }

    public static final <T> d<T> b(d<? extends T> dVar, p<? super T, ? super T, Boolean> pVar) {
        return c(dVar, f57134a, (p) TypeIntrinsics.e(pVar, 2));
    }

    public static final <T> d<T> c(d<? extends T> dVar, l<? super T, ? extends Object> lVar, p<Object, Object, Boolean> pVar) {
        if (dVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) dVar;
            if (distinctFlowImpl.f57123c == lVar && distinctFlowImpl.f57124d == pVar) {
                return dVar;
            }
        }
        return new DistinctFlowImpl(dVar, lVar, pVar);
    }
}
