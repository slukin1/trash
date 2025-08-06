package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$4", f = "Count.kt", l = {30}, m = "emit")
public final class FlowKt__CountKt$count$4$emit$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowKt__CountKt$count$4<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__CountKt$count$4$emit$1(FlowKt__CountKt$count$4<? super T> flowKt__CountKt$count$4, c<? super FlowKt__CountKt$count$4$emit$1> cVar) {
        super(cVar);
        this.this$0 = flowKt__CountKt$count$4;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
