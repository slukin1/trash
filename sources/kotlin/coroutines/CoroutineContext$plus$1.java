package kotlin.coroutines;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Lambda;

public final class CoroutineContext$plus$1 extends Lambda implements p<CoroutineContext, CoroutineContext.a, CoroutineContext> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    public CoroutineContext$plus$1() {
        super(2);
    }

    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.a aVar) {
        CombinedContext combinedContext;
        CoroutineContext minusKey = coroutineContext.minusKey(aVar.getKey());
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (minusKey == emptyCoroutineContext) {
            return aVar;
        }
        d.b bVar = d.f56672p0;
        d dVar = (d) minusKey.get(bVar);
        if (dVar == null) {
            combinedContext = new CombinedContext(minusKey, aVar);
        } else {
            CoroutineContext minusKey2 = minusKey.minusKey(bVar);
            if (minusKey2 == emptyCoroutineContext) {
                return new CombinedContext(aVar, dVar);
            }
            combinedContext = new CombinedContext(new CombinedContext(minusKey2, aVar), dVar);
        }
        return combinedContext;
    }
}
