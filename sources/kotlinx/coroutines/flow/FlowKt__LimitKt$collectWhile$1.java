package kotlinx.coroutines.flow;

import d10.p;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", l = {136}, m = "collectWhile")
public final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__LimitKt$collectWhile$1(c<? super FlowKt__LimitKt$collectWhile$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__LimitKt.b((d) null, (p) null, this);
    }
}
