package kotlinx.coroutines;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

public final class CoroutineContextKt$hasCopyableElements$1 extends Lambda implements p<Boolean, CoroutineContext.a, Boolean> {
    public static final CoroutineContextKt$hasCopyableElements$1 INSTANCE = new CoroutineContextKt$hasCopyableElements$1();

    public CoroutineContextKt$hasCopyableElements$1() {
        super(2);
    }

    public final Boolean invoke(boolean z11, CoroutineContext.a aVar) {
        return Boolean.valueOf(z11 || (aVar instanceof b0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (CoroutineContext.a) obj2);
    }
}
