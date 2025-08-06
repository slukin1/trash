package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.e;

public final class g {
    public static final void a(AbortFlowException abortFlowException, e<?> eVar) {
        if (abortFlowException.owner != eVar) {
            throw abortFlowException;
        }
    }
}
