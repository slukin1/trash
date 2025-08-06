package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
public final class StateFlowImpl$collect$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StateFlowImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(StateFlowImpl<T> stateFlowImpl, c<? super StateFlowImpl$collect$1> cVar) {
        super(cVar);
        this.this$0 = stateFlowImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect((e) null, this);
    }
}
