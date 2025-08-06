package kotlinx.coroutines.reactive;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", l = {209}, m = "flowProcessing")
public final class FlowSubscription$flowProcessing$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowSubscription<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowSubscription$flowProcessing$1(FlowSubscription<T> flowSubscription, c<? super FlowSubscription$flowProcessing$1> cVar) {
        super(cVar);
        this.this$0 = flowSubscription;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k1(this);
    }
}
