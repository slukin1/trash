package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;

public final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> d<T> a(d<? extends T> dVar) {
        return new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(dVar);
    }

    public static final <T> d<T> b(d<? extends T> dVar, p<? super T, ? super c<? super Unit>, ? extends Object> pVar) {
        return new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(dVar, pVar);
    }
}
