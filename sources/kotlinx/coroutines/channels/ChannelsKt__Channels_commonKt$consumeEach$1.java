package kotlinx.coroutines.channels;

import d10.l;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {106}, m = "consumeEach")
public final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$consumeEach$1(c<? super ChannelsKt__Channels_commonKt$consumeEach$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.c((ReceiveChannel) null, (l) null, this);
    }
}
