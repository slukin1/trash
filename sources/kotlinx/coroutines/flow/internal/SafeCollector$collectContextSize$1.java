package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

public final class SafeCollector$collectContextSize$1 extends Lambda implements p<Integer, CoroutineContext.a, Integer> {
    public static final SafeCollector$collectContextSize$1 INSTANCE = new SafeCollector$collectContextSize$1();

    public SafeCollector$collectContextSize$1() {
        super(2);
    }

    public final Integer invoke(int i11, CoroutineContext.a aVar) {
        return Integer.valueOf(i11 + 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (CoroutineContext.a) obj2);
    }
}
