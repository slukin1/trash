package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;

public final class f {
    public static final <E> d<E> a(int i11, BufferOverflow bufferOverflow, l<? super E, Unit> lVar) {
        d<E> iVar;
        if (i11 != -2) {
            boolean z11 = false;
            if (i11 == -1) {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    z11 = true;
                }
                if (z11) {
                    return new i(1, BufferOverflow.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            } else if (i11 != 0) {
                if (i11 == Integer.MAX_VALUE) {
                    return new BufferedChannel(Integer.MAX_VALUE, lVar);
                }
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new BufferedChannel(i11, lVar);
                }
                return new i(i11, bufferOverflow, lVar);
            } else if (bufferOverflow == BufferOverflow.SUSPEND) {
                iVar = new BufferedChannel<>(0, lVar);
            } else {
                iVar = new i<>(1, bufferOverflow, lVar);
            }
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            iVar = new BufferedChannel<>(d.f57045s0.a(), lVar);
        } else {
            iVar = new i<>(1, bufferOverflow, lVar);
        }
        return iVar;
    }

    public static /* synthetic */ d b(int i11, BufferOverflow bufferOverflow, l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        if ((i12 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i12 & 4) != 0) {
            lVar = null;
        }
        return a(i11, bufferOverflow, lVar);
    }
}
