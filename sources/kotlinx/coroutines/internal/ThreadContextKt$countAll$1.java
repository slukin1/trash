package kotlinx.coroutines.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.f2;

public final class ThreadContextKt$countAll$1 extends Lambda implements p<Object, CoroutineContext.a, Object> {
    public static final ThreadContextKt$countAll$1 INSTANCE = new ThreadContextKt$countAll$1();

    public ThreadContextKt$countAll$1() {
        super(2);
    }

    public final Object invoke(Object obj, CoroutineContext.a aVar) {
        if (!(aVar instanceof f2)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int intValue = num != null ? num.intValue() : 1;
        return intValue == 0 ? aVar : Integer.valueOf(intValue + 1);
    }
}
