package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class SafeCollector_commonKt$unsafeFlow$1$collect$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ l this$0;

    public SafeCollector_commonKt$unsafeFlow$1$collect$1(l lVar, c cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
