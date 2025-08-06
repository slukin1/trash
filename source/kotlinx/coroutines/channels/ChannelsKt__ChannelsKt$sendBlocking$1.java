package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", l = {58}, m = "invokeSuspend")
final class ChannelsKt__ChannelsKt$sendBlocking$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ m $this_sendBlocking;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__ChannelsKt$sendBlocking$1(m mVar, Object obj, c cVar) {
        super(2, cVar);
        this.$this_sendBlocking = mVar;
        this.$element = obj;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ChannelsKt__ChannelsKt$sendBlocking$1(this.$this_sendBlocking, this.$element, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((ChannelsKt__ChannelsKt$sendBlocking$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            m mVar = this.$this_sendBlocking;
            Object obj2 = this.$element;
            this.label = 1;
            if (mVar.send(obj2, this) == d11) {
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
