package kotlinx.coroutines;

import d10.p;
import f10.b;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.f;
import kotlinx.coroutines.internal.y;

public final class i0 {
    public static final h0 a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(n1.f57382r0) == null) {
            coroutineContext = coroutineContext.plus(r1.b((n1) null, 1, (Object) null));
        }
        return new f(coroutineContext);
    }

    public static final h0 b() {
        return new f(e2.b((n1) null, 1, (Object) null).plus(v0.c()));
    }

    public static final void c(h0 h0Var, String str, Throwable th2) {
        d(h0Var, d1.a(str, th2));
    }

    public static final void d(h0 h0Var, CancellationException cancellationException) {
        n1 n1Var = (n1) h0Var.getCoroutineContext().get(n1.f57382r0);
        if (n1Var != null) {
            n1Var.b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + h0Var).toString());
    }

    public static /* synthetic */ void e(h0 h0Var, String str, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        c(h0Var, str, th2);
    }

    public static /* synthetic */ void f(h0 h0Var, CancellationException cancellationException, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cancellationException = null;
        }
        d(h0Var, cancellationException);
    }

    public static final <R> Object g(p<? super h0, ? super c<? super R>, ? extends Object> pVar, c<? super R> cVar) {
        y yVar = new y(cVar.getContext(), cVar);
        Object c11 = b.c(yVar, yVar, pVar);
        if (c11 == IntrinsicsKt__IntrinsicsKt.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return c11;
    }

    public static final void h(h0 h0Var) {
        p1.i(h0Var.getCoroutineContext());
    }

    public static final boolean i(h0 h0Var) {
        n1 n1Var = (n1) h0Var.getCoroutineContext().get(n1.f57382r0);
        if (n1Var != null) {
            return n1Var.isActive();
        }
        return true;
    }

    public static final h0 j(h0 h0Var, CoroutineContext coroutineContext) {
        return new f(h0Var.getCoroutineContext().plus(coroutineContext));
    }
}
