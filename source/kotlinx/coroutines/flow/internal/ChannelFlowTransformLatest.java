package kotlinx.coroutines.flow.internal;

import d10.q;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j0;

public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: f  reason: collision with root package name */
    public final q<e<? super R>, T, c<? super Unit>, Object> f57240f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFlowTransformLatest(q qVar, d dVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, r rVar) {
        this(qVar, dVar, (i12 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 8) != 0 ? -2 : i11, (i12 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public ChannelFlow<R> i(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f57240f, this.f57239e, coroutineContext, i11, bufferOverflow);
    }

    public Object q(e<? super R> eVar, c<? super Unit> cVar) {
        if (!j0.a() || (eVar instanceof m)) {
            Object g11 = i0.g(new ChannelFlowTransformLatest$flowCollect$3(this, eVar, (c<? super ChannelFlowTransformLatest$flowCollect$3>) null), cVar);
            return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
        }
        throw new AssertionError();
    }

    public ChannelFlowTransformLatest(q<? super e<? super R>, ? super T, ? super c<? super Unit>, ? extends Object> qVar, d<? extends T> dVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(dVar, coroutineContext, i11, bufferOverflow);
        this.f57240f = qVar;
    }
}
