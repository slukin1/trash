package kotlinx.coroutines.flow;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.d0;

public final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f57154a = d0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    public static final <T, R> d<R> a(d<? extends T> dVar, p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        return f.c0(dVar, new FlowKt__MergeKt$mapLatest$1(pVar, (c<? super FlowKt__MergeKt$mapLatest$1>) null));
    }

    public static final <T> d<T> b(Iterable<? extends d<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (r) null);
    }

    public static final <T> d<T> c(d<? extends T>... dVarArr) {
        return f.M(ArraysKt___ArraysKt.y(dVarArr));
    }

    public static final <T, R> d<R> d(d<? extends T> dVar, q<? super e<? super R>, ? super T, ? super c<? super Unit>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, dVar, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (r) null);
    }
}
