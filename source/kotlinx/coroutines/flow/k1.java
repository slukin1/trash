package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.k;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.j0;

public final class k1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57271a = new c0("NONE");

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f57272b = new c0("PENDING");

    public static final <T> b1<T> a(T t11) {
        if (t11 == null) {
            t11 = k.f57265a;
        }
        return new StateFlowImpl(t11);
    }

    public static final <T> d<T> d(j1<? extends T> j1Var, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        boolean z11 = true;
        if (j0.a()) {
            if (!(i11 != -1)) {
                throw new AssertionError();
            }
        }
        if (i11 < 0 || i11 >= 2) {
            z11 = false;
        }
        if ((z11 || i11 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return j1Var;
        }
        return g1.e(j1Var, coroutineContext, i11, bufferOverflow);
    }
}
