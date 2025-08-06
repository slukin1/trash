package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", l = {96}, m = "invokeSuspend")
public final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ m<T> $collector;
    public final /* synthetic */ kotlinx.coroutines.flow.d<T> $flow;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelLimitedFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.d<? extends T> dVar, m<T> mVar, c<? super ChannelLimitedFlowMerge$collectTo$2$1> cVar) {
        super(2, cVar);
        this.$flow = dVar;
        this.$collector = mVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.$flow, this.$collector, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((ChannelLimitedFlowMerge$collectTo$2$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            kotlinx.coroutines.flow.d<T> dVar = this.$flow;
            m<T> mVar = this.$collector;
            this.label = 1;
            if (dVar.collect(mVar, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
