package kotlinx.coroutines.flow;

import d10.q;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {22}, m = "reduce")
public final class FlowKt__ReduceKt$reduce$1<S, T extends S> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__ReduceKt$reduce$1(c<? super FlowKt__ReduceKt$reduce$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return f.U((d) null, (q) null, this);
    }
}
