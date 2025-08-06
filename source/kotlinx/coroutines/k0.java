package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.k;
import kotlinx.coroutines.internal.i;

public final class k0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(c<?> cVar) {
        Object obj;
        if (cVar instanceof i) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m3072constructorimpl(cVar + '@' + b(cVar));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        Throwable r22 = Result.m3075exceptionOrNullimpl(obj);
        String str = obj;
        if (r22 != null) {
            str = cVar.getClass().getName() + '@' + b(cVar);
        }
        return (String) str;
    }
}
