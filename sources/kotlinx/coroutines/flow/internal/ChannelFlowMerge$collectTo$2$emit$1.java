package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", l = {66}, m = "emit")
final class ChannelFlowMerge$collectTo$2$emit$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ c<Object> this$0;

    public ChannelFlowMerge$collectTo$2$emit$1(c<Object> cVar, c<? super ChannelFlowMerge$collectTo$2$emit$1> cVar2) {
        super(cVar2);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
