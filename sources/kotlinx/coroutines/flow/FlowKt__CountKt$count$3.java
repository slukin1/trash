package kotlinx.coroutines.flow;

import d10.p;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", l = {29}, m = "count")
public final class FlowKt__CountKt$count$3<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__CountKt$count$3(c<? super FlowKt__CountKt$count$3> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return f.p((d) null, (p) null, this);
    }
}
