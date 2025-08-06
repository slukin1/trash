package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

public class c2 extends a<Unit> {
    public c2(CoroutineContext coroutineContext, boolean z11) {
        super(coroutineContext, true, z11);
    }

    public boolean t0(Throwable th2) {
        e0.a(getContext(), th2);
        return true;
    }
}
