package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.j1;

public final class o extends SharedFlowImpl<Integer> implements j1<Integer> {
    public o(int i11) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        d(Integer.valueOf(i11));
    }

    /* renamed from: Y */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(((Number) L()).intValue());
        }
        return valueOf;
    }

    public final boolean Z(int i11) {
        boolean d11;
        synchronized (this) {
            d11 = d(Integer.valueOf(((Number) L()).intValue() + i11));
        }
        return d11;
    }
}
