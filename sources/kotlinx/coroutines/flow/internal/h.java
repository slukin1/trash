package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.d;

public interface h<T> extends d<T> {

    public static final class a {
        public static /* synthetic */ d a(h hVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                if ((i12 & 2) != 0) {
                    i11 = -3;
                }
                if ((i12 & 4) != 0) {
                    bufferOverflow = BufferOverflow.SUSPEND;
                }
                return hVar.c(coroutineContext, i11, bufferOverflow);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    d<T> c(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow);
}
