package kotlinx.coroutines.channels;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl")
public final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, c<? super BufferedChannel$receiveCatching$1> cVar) {
        super(cVar);
        this.this$0 = bufferedChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object G0 = BufferedChannel.G0(this.this$0, this);
        return G0 == IntrinsicsKt__IntrinsicsKt.d() ? G0 : ChannelResult.b(G0);
    }
}
