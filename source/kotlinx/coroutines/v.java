package kotlinx.coroutines;

import kotlin.Result;

public final class v {
    public static final <T> t<T> a(n1 n1Var) {
        return new u(n1Var);
    }

    public static /* synthetic */ t b(n1 n1Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            n1Var = null;
        }
        return a(n1Var);
    }

    public static final <T> boolean c(t<T> tVar, Object obj) {
        Throwable r02 = Result.m3075exceptionOrNullimpl(obj);
        return r02 == null ? tVar.p(obj) : tVar.o(r02);
    }
}
