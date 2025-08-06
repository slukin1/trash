package kotlinx.coroutines.channels;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.m;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {487, 278}, m = "toChannel")
public final class ChannelsKt__DeprecatedKt$toChannel$1<E, C extends m<? super E>> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$toChannel$1(c<? super ChannelsKt__DeprecatedKt$toChannel$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return h.s((ReceiveChannel) null, null, this);
    }
}
