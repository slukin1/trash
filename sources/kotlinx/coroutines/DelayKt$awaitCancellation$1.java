package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", l = {163}, m = "awaitCancellation")
public final class DelayKt$awaitCancellation$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    public DelayKt$awaitCancellation$1(c<? super DelayKt$awaitCancellation$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DelayKt.a(this);
    }
}
