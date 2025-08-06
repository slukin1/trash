package kotlin.coroutines;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

public final class CombinedContext$toString$1 extends Lambda implements p<String, CoroutineContext.a, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    public CombinedContext$toString$1() {
        super(2);
    }

    public final String invoke(String str, CoroutineContext.a aVar) {
        if (str.length() == 0) {
            return aVar.toString();
        }
        return str + ", " + aVar;
    }
}
