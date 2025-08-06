package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {152}, m = "invokeSuspend")
public final class ChannelFlowOperator$collectWithContextUndispatched$2 extends SuspendLambda implements p<e<? super T>, c<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlowOperator<S, T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator<S, T> channelFlowOperator, c<? super ChannelFlowOperator$collectWithContextUndispatched$2> cVar) {
        super(2, cVar);
        this.this$0 = channelFlowOperator;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelFlowOperator$collectWithContextUndispatched$2 channelFlowOperator$collectWithContextUndispatched$2 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.this$0, cVar);
        channelFlowOperator$collectWithContextUndispatched$2.L$0 = obj;
        return channelFlowOperator$collectWithContextUndispatched$2;
    }

    public final Object invoke(e<? super T> eVar, c<? super Unit> cVar) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            ChannelFlowOperator<S, T> channelFlowOperator = this.this$0;
            this.label = 1;
            if (channelFlowOperator.q((e) this.L$0, this) == d11) {
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
