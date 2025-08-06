package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.c;

public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean a(F f11);

    public abstract c<Unit>[] b(F f11);
}
