package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.k;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.i;

public final class t0 {
    public static final <T> void a(s0<? super T> s0Var, int i11) {
        boolean z11 = true;
        if (j0.a()) {
            if (!(i11 != -1)) {
                throw new AssertionError();
            }
        }
        c<? super T> e11 = s0Var.e();
        if (i11 != 4) {
            z11 = false;
        }
        if (z11 || !(e11 instanceof i) || b(i11) != b(s0Var.f57458d)) {
            d(s0Var, e11, z11);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((i) e11).f57310e;
        CoroutineContext context = e11.getContext();
        if (coroutineDispatcher.B(context)) {
            coroutineDispatcher.w(context, s0Var);
        } else {
            e(s0Var);
        }
    }

    public static final boolean b(int i11) {
        return i11 == 1 || i11 == 2;
    }

    public static final boolean c(int i11) {
        return i11 == 2;
    }

    public static final <T> void d(s0<? super T> s0Var, c<? super T> cVar, boolean z11) {
        Object obj;
        Object j11 = s0Var.j();
        Throwable f11 = s0Var.f(j11);
        if (f11 != null) {
            Result.a aVar = Result.Companion;
            obj = k.a(f11);
        } else {
            Result.a aVar2 = Result.Companion;
            obj = s0Var.g(j11);
        }
        Object r32 = Result.m3072constructorimpl(obj);
        if (z11) {
            i iVar = (i) cVar;
            c<T> cVar2 = iVar.f57311f;
            Object obj2 = iVar.f57313h;
            CoroutineContext context = cVar2.getContext();
            Object c11 = ThreadContextKt.c(context, obj2);
            o2<?> g11 = c11 != ThreadContextKt.f57289a ? CoroutineContextKt.g(cVar2, context, c11) : null;
            try {
                iVar.f57311f.resumeWith(r32);
                Unit unit = Unit.f56620a;
            } finally {
                if (g11 == null || g11.f1()) {
                    ThreadContextKt.a(context, c11);
                }
            }
        } else {
            cVar.resumeWith(r32);
        }
    }

    public static final void e(s0<?> s0Var) {
        EventLoop b11 = g2.f57278a.b();
        if (b11.P()) {
            b11.J(s0Var);
            return;
        }
        b11.N(true);
        try {
            d(s0Var, s0Var.e(), true);
            do {
            } while (b11.S());
        } catch (Throwable th2) {
            b11.G(true);
            throw th2;
        }
        b11.G(true);
    }
}
