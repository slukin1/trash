package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.d;
import kotlinx.coroutines.internal.c0;

public final class g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57223a = new c0("NO_VALUE");

    public static final <T> a1<T> a(int i11, int i12, BufferOverflow bufferOverflow) {
        boolean z11 = true;
        if (i11 >= 0) {
            if (i12 >= 0) {
                if (i11 <= 0 && i12 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    z11 = false;
                }
                if (z11) {
                    int i13 = i12 + i11;
                    if (i13 < 0) {
                        i13 = Integer.MAX_VALUE;
                    }
                    return new SharedFlowImpl(i11, i13, bufferOverflow);
                }
                throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
            }
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i12).toString());
        }
        throw new IllegalArgumentException(("replay cannot be negative, but was " + i11).toString());
    }

    public static /* synthetic */ a1 b(int i11, int i12, BufferOverflow bufferOverflow, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        if ((i13 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i11, i12, bufferOverflow);
    }

    public static final <T> d<T> e(f1<? extends T> f1Var, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        if ((i11 == 0 || i11 == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return f1Var;
        }
        return new d(f1Var, coroutineContext, i11, bufferOverflow);
    }

    public static final Object f(Object[] objArr, long j11) {
        return objArr[((int) j11) & (objArr.length - 1)];
    }

    public static final void g(Object[] objArr, long j11, Object obj) {
        objArr[((int) j11) & (objArr.length - 1)] = obj;
    }
}
