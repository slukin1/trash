package kotlinx.coroutines.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.f2;

public final class ThreadContextKt$findOne$1 extends Lambda implements p<f2<?>, CoroutineContext.a, f2<?>> {
    public static final ThreadContextKt$findOne$1 INSTANCE = new ThreadContextKt$findOne$1();

    public ThreadContextKt$findOne$1() {
        super(2);
    }

    public final f2<?> invoke(f2<?> f2Var, CoroutineContext.a aVar) {
        if (f2Var != null) {
            return f2Var;
        }
        if (aVar instanceof f2) {
            return (f2) aVar;
        }
        return null;
    }
}
