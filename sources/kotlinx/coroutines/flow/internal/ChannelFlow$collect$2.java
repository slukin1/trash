package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
public final class ChannelFlow$collect$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ e<T> $collector;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collect$2(e<? super T> eVar, ChannelFlow<T> channelFlow, c<? super ChannelFlow$collect$2> cVar) {
        super(2, cVar);
        this.$collector = eVar;
        this.this$0 = channelFlow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.$collector, this.this$0, cVar);
        channelFlow$collect$2.L$0 = obj;
        return channelFlow$collect$2;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((ChannelFlow$collect$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            e<T> eVar = this.$collector;
            ReceiveChannel<T> m11 = this.this$0.m((h0) this.L$0);
            this.label = 1;
            if (f.v(eVar, m11, this) == d11) {
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
