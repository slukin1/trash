package kotlinx.coroutines.reactive;

import d10.l;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import z20.b;

@d(c = "kotlinx.coroutines.reactive.ChannelKt", f = "Channel.kt", l = {119}, m = "collect")
public final class ChannelKt$collect$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public ChannelKt$collect$1(c<? super ChannelKt$collect$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelKt.a((b) null, (l) null, this);
    }
}
