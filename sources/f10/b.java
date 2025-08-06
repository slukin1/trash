package f10;

import d10.l;
import d10.p;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.s1;

public final class b {
    public static final <T> void a(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        CoroutineContext context;
        Object c11;
        c<? super T> a11 = f.a(cVar);
        try {
            context = cVar.getContext();
            c11 = ThreadContextKt.c(context, (Object) null);
            Object invoke = ((l) TypeIntrinsics.e(lVar, 1)).invoke(a11);
            ThreadContextKt.a(context, c11);
            if (invoke != IntrinsicsKt__IntrinsicsKt.d()) {
                Result.a aVar = Result.Companion;
                a11.resumeWith(Result.m3072constructorimpl(invoke));
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            a11.resumeWith(Result.m3072constructorimpl(k.a(th2)));
        }
    }

    public static final <R, T> void b(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r11, c<? super T> cVar) {
        CoroutineContext context;
        Object c11;
        c<? super T> a11 = f.a(cVar);
        try {
            context = cVar.getContext();
            c11 = ThreadContextKt.c(context, (Object) null);
            Object invoke = ((p) TypeIntrinsics.e(pVar, 2)).invoke(r11, a11);
            ThreadContextKt.a(context, c11);
            if (invoke != IntrinsicsKt__IntrinsicsKt.d()) {
                Result.a aVar = Result.Companion;
                a11.resumeWith(Result.m3072constructorimpl(invoke));
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            a11.resumeWith(Result.m3072constructorimpl(k.a(th2)));
        }
    }

    public static final <T, R> Object c(y<? super T> yVar, R r11, p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object obj;
        try {
            obj = ((p) TypeIntrinsics.e(pVar, 2)).invoke(r11, yVar);
        } catch (Throwable th2) {
            obj = new kotlinx.coroutines.y(th2, false, 2, (r) null);
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
            return IntrinsicsKt__IntrinsicsKt.d();
        }
        Object B0 = yVar.B0(obj);
        if (B0 == s1.f57460b) {
            return IntrinsicsKt__IntrinsicsKt.d();
        }
        if (!(B0 instanceof kotlinx.coroutines.y)) {
            return s1.h(B0);
        }
        Throwable th3 = ((kotlinx.coroutines.y) B0).f57583a;
        c<T> cVar = yVar.f57351e;
        if (j0.d() && (cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            th3 = b0.i(th3, (kotlin.coroutines.jvm.internal.c) cVar);
        }
        throw th3;
    }

    public static final <T, R> Object d(y<? super T> yVar, R r11, p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object obj;
        boolean z11 = false;
        try {
            obj = ((p) TypeIntrinsics.e(pVar, 2)).invoke(r11, yVar);
        } catch (Throwable th2) {
            obj = new kotlinx.coroutines.y(th2, false, 2, (r) null);
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
            return IntrinsicsKt__IntrinsicsKt.d();
        }
        Object B0 = yVar.B0(obj);
        if (B0 == s1.f57460b) {
            return IntrinsicsKt__IntrinsicsKt.d();
        }
        if (B0 instanceof kotlinx.coroutines.y) {
            Throwable th3 = ((kotlinx.coroutines.y) B0).f57583a;
            if (!(th3 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th3).coroutine != yVar) {
                z11 = true;
            }
            if (z11) {
                c<T> cVar = yVar.f57351e;
                if (j0.d() && (cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                    th3 = b0.i(th3, (kotlin.coroutines.jvm.internal.c) cVar);
                }
                throw th3;
            } else if (obj instanceof kotlinx.coroutines.y) {
                Throwable th4 = ((kotlinx.coroutines.y) obj).f57583a;
                c<T> cVar2 = yVar.f57351e;
                if (j0.d() && (cVar2 instanceof kotlin.coroutines.jvm.internal.c)) {
                    th4 = b0.i(th4, (kotlin.coroutines.jvm.internal.c) cVar2);
                }
                throw th4;
            }
        } else {
            obj = s1.h(B0);
        }
        return obj;
    }
}
