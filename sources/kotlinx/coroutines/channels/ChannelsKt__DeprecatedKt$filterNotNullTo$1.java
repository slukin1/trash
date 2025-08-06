package kotlinx.coroutines.channels;

import java.util.Collection;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {487}, m = "filterNotNullTo")
public final class ChannelsKt__DeprecatedKt$filterNotNullTo$1<E, C extends Collection<? super E>> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$filterNotNullTo$1(c<? super ChannelsKt__DeprecatedKt$filterNotNullTo$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.e((ReceiveChannel) null, (Collection) null, this);
    }
}
