package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.d;
import kotlinx.coroutines.flow.internal.h;
import kotlinx.coroutines.n1;

public final /* synthetic */ class u {
    public static final <T> d<T> a(d<? extends T> dVar, int i11, BufferOverflow bufferOverflow) {
        BufferOverflow bufferOverflow2;
        int i12;
        boolean z11 = true;
        if (i11 >= 0 || i11 == -2 || i11 == -1) {
            if (i11 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z11 = false;
            }
            if (z11) {
                if (i11 == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i12 = 0;
                } else {
                    i12 = i11;
                    bufferOverflow2 = bufferOverflow;
                }
                if (dVar instanceof h) {
                    return h.a.a((h) dVar, (CoroutineContext) null, i12, bufferOverflow2, 1, (Object) null);
                }
                return new d(dVar, (CoroutineContext) null, i12, bufferOverflow2, 2, (r) null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i11).toString());
    }

    public static /* synthetic */ d b(d dVar, int i11, BufferOverflow bufferOverflow, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = -2;
        }
        if ((i12 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return f.c(dVar, i11, bufferOverflow);
    }

    public static final void c(CoroutineContext coroutineContext) {
        if (!(coroutineContext.get(n1.f57382r0) == null)) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
        }
    }

    public static final <T> d<T> d(d<? extends T> dVar) {
        return b(dVar, -1, (BufferOverflow) null, 2, (Object) null);
    }

    public static final <T> d<T> e(d<? extends T> dVar, CoroutineContext coroutineContext) {
        c(coroutineContext);
        if (x.b(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            return dVar;
        }
        if (dVar instanceof h) {
            return h.a.a((h) dVar, coroutineContext, 0, (BufferOverflow) null, 6, (Object) null);
        }
        return new d(dVar, coroutineContext, 0, (BufferOverflow) null, 12, (r) null);
    }
}
