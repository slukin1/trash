package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.m;
import kotlinx.coroutines.h0;

public final class b<T> extends ChannelFlow<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57214g = AtomicIntegerFieldUpdater.newUpdater(b.class, "consumed");
    private volatile int consumed;

    /* renamed from: e  reason: collision with root package name */
    public final ReceiveChannel<T> f57215e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f57216f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(ReceiveChannel receiveChannel, boolean z11, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, r rVar) {
        this(receiveChannel, z11, (i12 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 8) != 0 ? -3 : i11, (i12 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public Object collect(e<? super T> eVar, c<? super Unit> cVar) {
        if (this.f57237c == -3) {
            n();
            Object a11 = FlowKt__ChannelsKt.c(eVar, this.f57215e, this.f57216f, cVar);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
        }
        Object collect = super.collect(eVar, cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }

    public String f() {
        return "channel=" + this.f57215e;
    }

    public Object h(k<? super T> kVar, c<? super Unit> cVar) {
        Object a11 = FlowKt__ChannelsKt.c(new m(kVar), this.f57215e, this.f57216f, cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    public ChannelFlow<T> i(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new b(this.f57215e, this.f57216f, coroutineContext, i11, bufferOverflow);
    }

    public d<T> j() {
        return new b(this.f57215e, this.f57216f, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (r) null);
    }

    public ReceiveChannel<T> m(h0 h0Var) {
        n();
        if (this.f57237c == -3) {
            return this.f57215e;
        }
        return super.m(h0Var);
    }

    public final void n() {
        if (this.f57216f) {
            boolean z11 = true;
            if (f57214g.getAndSet(this, 1) != 0) {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    public b(ReceiveChannel<? extends T> receiveChannel, boolean z11, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f57215e = receiveChannel;
        this.f57216f = z11;
        this.consumed = 0;
    }
}
