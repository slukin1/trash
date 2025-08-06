package kotlinx.coroutines;

import d10.l;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.internal.b0;

public final class a0 {
    public static final <T> Object a(Object obj, c<? super T> cVar) {
        if (obj instanceof y) {
            Result.a aVar = Result.Companion;
            Throwable th2 = ((y) obj).f57583a;
            if (j0.d() && (cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                th2 = b0.i(th2, (kotlin.coroutines.jvm.internal.c) cVar);
            }
            return Result.m3072constructorimpl(k.a(th2));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m3072constructorimpl(obj);
    }

    public static final <T> Object b(Object obj, l<? super Throwable, Unit> lVar) {
        Throwable r02 = Result.m3075exceptionOrNullimpl(obj);
        if (r02 != null) {
            return new y(r02, false, 2, (r) null);
        }
        if (lVar != null) {
            return new z(obj, lVar);
        }
        return obj;
    }

    public static final <T> Object c(Object obj, k<?> kVar) {
        Throwable r02 = Result.m3075exceptionOrNullimpl(obj);
        if (r02 != null) {
            if (j0.d() && (kVar instanceof kotlin.coroutines.jvm.internal.c)) {
                r02 = b0.i(r02, (kotlin.coroutines.jvm.internal.c) kVar);
            }
            obj = new y(r02, false, 2, (r) null);
        }
        return obj;
    }

    public static /* synthetic */ Object d(Object obj, l lVar, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
