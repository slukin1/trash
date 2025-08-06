package kotlinx.coroutines.channels;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk")
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    public int I$0;
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, c<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> cVar) {
        super(cVar);
        this.this$0 = bufferedChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object z11 = this.this$0.H0((g) null, 0, 0, this);
        return z11 == IntrinsicsKt__IntrinsicsKt.d() ? z11 : ChannelResult.b(z11);
    }
}
