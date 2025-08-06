package kotlinx.coroutines;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

public final class CoroutineContextKt$foldCopies$1 extends Lambda implements p<CoroutineContext, CoroutineContext.a, CoroutineContext> {
    public static final CoroutineContextKt$foldCopies$1 INSTANCE = new CoroutineContextKt$foldCopies$1();

    public CoroutineContextKt$foldCopies$1() {
        super(2);
    }

    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.a aVar) {
        if (aVar instanceof b0) {
            return coroutineContext.plus(((b0) aVar).l());
        }
        return coroutineContext.plus(aVar);
    }
}
