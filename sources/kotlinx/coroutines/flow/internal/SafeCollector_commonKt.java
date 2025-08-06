package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.n1;

public final class SafeCollector_commonKt {
    public static final void a(SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new SafeCollector_commonKt$checkContext$result$1(safeCollector))).intValue() != safeCollector.collectContextSize) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    public static final n1 b(n1 n1Var, n1 n1Var2) {
        while (n1Var != null) {
            if (n1Var == n1Var2 || !(n1Var instanceof y)) {
                return n1Var;
            }
            n1Var = n1Var.getParent();
        }
        return null;
    }
}
