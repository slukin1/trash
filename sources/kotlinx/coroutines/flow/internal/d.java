package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.e;

public final class d<T> extends ChannelFlowOperator<T, T> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(kotlinx.coroutines.flow.d dVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, r rVar) {
        this(dVar, (i12 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 4) != 0 ? -3 : i11, (i12 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public ChannelFlow<T> i(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new d(this.f57239e, coroutineContext, i11, bufferOverflow);
    }

    public kotlinx.coroutines.flow.d<T> j() {
        return this.f57239e;
    }

    public Object q(e<? super T> eVar, c<? super Unit> cVar) {
        Object collect = this.f57239e.collect(eVar, cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }

    public d(kotlinx.coroutines.flow.d<? extends T> dVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(dVar, coroutineContext, i11, bufferOverflow);
    }
}
