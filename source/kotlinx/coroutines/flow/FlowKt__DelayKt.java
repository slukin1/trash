package kotlinx.coroutines.flow;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.h0;

public final /* synthetic */ class FlowKt__DelayKt {
    public static final <T> d<T> a(d<? extends T> dVar, l<? super T, Long> lVar) {
        return b(dVar, lVar);
    }

    public static final <T> d<T> b(d<? extends T> dVar, l<? super T, Long> lVar) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$debounceInternal$1(lVar, dVar, (c<? super FlowKt__DelayKt$debounceInternal$1>) null));
    }

    public static final ReceiveChannel<Unit> c(h0 h0Var, long j11, long j12) {
        boolean z11 = true;
        if (j11 >= 0) {
            if (j12 < 0) {
                z11 = false;
            }
            if (z11) {
                return ProduceKt.d(h0Var, (CoroutineContext) null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j12, j11, (c<? super FlowKt__DelayKt$fixedPeriodTicker$3>) null), 1, (Object) null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j12 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j11 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel d(h0 h0Var, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = j11;
        }
        return f.D(h0Var, j11, j12);
    }
}
