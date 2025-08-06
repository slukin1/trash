package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.n1;

public final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements p<Integer, CoroutineContext.a, Integer> {
    public final /* synthetic */ SafeCollector<?> $this_checkContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$checkContext$result$1(SafeCollector<?> safeCollector) {
        super(2);
        this.$this_checkContext = safeCollector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (CoroutineContext.a) obj2);
    }

    public final Integer invoke(int i11, CoroutineContext.a aVar) {
        CoroutineContext.b key = aVar.getKey();
        CoroutineContext.a aVar2 = this.$this_checkContext.collectContext.get(key);
        if (key != n1.f57382r0) {
            return Integer.valueOf(aVar != aVar2 ? Integer.MIN_VALUE : i11 + 1);
        }
        n1 n1Var = (n1) aVar2;
        n1 b11 = SafeCollector_commonKt.b((n1) aVar, n1Var);
        if (b11 == n1Var) {
            if (n1Var != null) {
                i11++;
            }
            return Integer.valueOf(i11);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b11 + ", expected child of " + n1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
