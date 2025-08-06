package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;

public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: e  reason: collision with root package name */
    public final d<S> f57239e;

    public ChannelFlowOperator(d<? extends S> dVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f57239e = dVar;
    }

    public static /* synthetic */ <S, T> Object n(ChannelFlowOperator<S, T> channelFlowOperator, e<? super T> eVar, c<? super Unit> cVar) {
        if (channelFlowOperator.f57237c == -3) {
            CoroutineContext context = cVar.getContext();
            CoroutineContext d11 = CoroutineContextKt.d(context, channelFlowOperator.f57236b);
            if (x.b(d11, context)) {
                Object q11 = channelFlowOperator.q(eVar, cVar);
                return q11 == IntrinsicsKt__IntrinsicsKt.d() ? q11 : Unit.f56620a;
            }
            d.b bVar = kotlin.coroutines.d.f56672p0;
            if (x.b(d11.get(bVar), context.get(bVar))) {
                Object p11 = channelFlowOperator.p(eVar, d11, cVar);
                return p11 == IntrinsicsKt__IntrinsicsKt.d() ? p11 : Unit.f56620a;
            }
        }
        Object collect = super.collect(eVar, cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }

    public static /* synthetic */ <S, T> Object o(ChannelFlowOperator<S, T> channelFlowOperator, k<? super T> kVar, c<? super Unit> cVar) {
        Object q11 = channelFlowOperator.q(new m(kVar), cVar);
        return q11 == IntrinsicsKt__IntrinsicsKt.d() ? q11 : Unit.f56620a;
    }

    public Object collect(e<? super T> eVar, c<? super Unit> cVar) {
        return n(this, eVar, cVar);
    }

    public Object h(k<? super T> kVar, c<? super Unit> cVar) {
        return o(this, kVar, cVar);
    }

    public final Object p(e<? super T> eVar, CoroutineContext coroutineContext, c<? super Unit> cVar) {
        Object d11 = b.d(coroutineContext, b.e(eVar, cVar.getContext()), (Object) null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, (c<? super ChannelFlowOperator$collectWithContextUndispatched$2>) null), cVar, 4, (Object) null);
        return d11 == IntrinsicsKt__IntrinsicsKt.d() ? d11 : Unit.f56620a;
    }

    public abstract Object q(e<? super T> eVar, c<? super Unit> cVar);

    public String toString() {
        return this.f57239e + " -> " + super.toString();
    }
}
