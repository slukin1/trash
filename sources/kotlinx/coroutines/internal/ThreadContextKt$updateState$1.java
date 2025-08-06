package kotlinx.coroutines.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.f2;

public final class ThreadContextKt$updateState$1 extends Lambda implements p<i0, CoroutineContext.a, i0> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    public ThreadContextKt$updateState$1() {
        super(2);
    }

    public final i0 invoke(i0 i0Var, CoroutineContext.a aVar) {
        if (aVar instanceof f2) {
            f2 f2Var = (f2) aVar;
            i0Var.a(f2Var, f2Var.M(i0Var.f57314a));
        }
        return i0Var;
    }
}
