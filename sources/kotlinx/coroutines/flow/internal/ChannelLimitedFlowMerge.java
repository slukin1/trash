package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: e  reason: collision with root package name */
    public final Iterable<d<T>> f57245e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, r rVar) {
        this(iterable, (i12 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 4) != 0 ? -2 : i11, (i12 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public Object h(k<? super T> kVar, c<? super Unit> cVar) {
        m mVar = new m(kVar);
        for (d<T> channelLimitedFlowMerge$collectTo$2$1 : this.f57245e) {
            n1 unused = i.d(kVar, (CoroutineContext) null, (CoroutineStart) null, new ChannelLimitedFlowMerge$collectTo$2$1(channelLimitedFlowMerge$collectTo$2$1, mVar, (c<? super ChannelLimitedFlowMerge$collectTo$2$1>) null), 3, (Object) null);
        }
        return Unit.f56620a;
    }

    public ChannelFlow<T> i(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.f57245e, coroutineContext, i11, bufferOverflow);
    }

    public ReceiveChannel<T> m(h0 h0Var) {
        return ProduceKt.b(h0Var, this.f57236b, this.f57237c, k());
    }

    public ChannelLimitedFlowMerge(Iterable<? extends d<? extends T>> iterable, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f57245e = iterable;
    }
}
