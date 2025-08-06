package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223, 224}, m = "emit")
public final class FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ r0 this$0;

    public FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1(r0 r0Var, c cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
