package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.k;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
public final class ChannelFlow$collectToFun$1 extends SuspendLambda implements p<k<? super T>, c<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collectToFun$1(ChannelFlow<T> channelFlow, c<? super ChannelFlow$collectToFun$1> cVar) {
        super(2, cVar);
        this.this$0 = channelFlow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, cVar);
        channelFlow$collectToFun$1.L$0 = obj;
        return channelFlow$collectToFun$1;
    }

    public final Object invoke(k<? super T> kVar, c<? super Unit> cVar) {
        return ((ChannelFlow$collectToFun$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            ChannelFlow<T> channelFlow = this.this$0;
            this.label = 1;
            if (channelFlow.h((k) this.L$0, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            kotlin.k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
