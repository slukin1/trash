package f10;

import d10.l;
import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.k;
import kotlinx.coroutines.internal.j;

public final class a {
    public static final void a(c<?> cVar, Throwable th2) {
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m3072constructorimpl(k.a(th2)));
        throw th2;
    }

    public static final <T> void b(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        try {
            c c11 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(lVar, cVar));
            Result.a aVar = Result.Companion;
            j.c(c11, Result.m3072constructorimpl(Unit.f56620a), (l) null, 2, (Object) null);
        } catch (Throwable th2) {
            a(cVar, th2);
        }
    }

    public static final <R, T> void c(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r11, c<? super T> cVar, l<? super Throwable, Unit> lVar) {
        try {
            c c11 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(pVar, r11, cVar));
            Result.a aVar = Result.Companion;
            j.b(c11, Result.m3072constructorimpl(Unit.f56620a), lVar);
        } catch (Throwable th2) {
            a(cVar, th2);
        }
    }

    public static final void d(c<? super Unit> cVar, c<?> cVar2) {
        try {
            c c11 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
            Result.a aVar = Result.Companion;
            j.c(c11, Result.m3072constructorimpl(Unit.f56620a), (l) null, 2, (Object) null);
        } catch (Throwable th2) {
            a(cVar2, th2);
        }
    }

    public static /* synthetic */ void e(p pVar, Object obj, c cVar, l lVar, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, cVar, lVar);
    }
}
