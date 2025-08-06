package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.g;

public final /* synthetic */ class r1 {
    public static final w a(n1 n1Var) {
        return new o1(n1Var);
    }

    public static /* synthetic */ w b(n1 n1Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            n1Var = null;
        }
        return p1.a(n1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        n1 n1Var = (n1) coroutineContext.get(n1.f57382r0);
        if (n1Var != null) {
            n1Var.b(cancellationException);
        }
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cancellationException = null;
        }
        p1.c(coroutineContext, cancellationException);
    }

    public static final void e(CoroutineContext coroutineContext, CancellationException cancellationException) {
        g<n1> children;
        n1 n1Var = (n1) coroutineContext.get(n1.f57382r0);
        if (n1Var != null && (children = n1Var.getChildren()) != null) {
            for (n1 b11 : children) {
                b11.b(cancellationException);
            }
        }
    }

    public static /* synthetic */ void f(CoroutineContext coroutineContext, CancellationException cancellationException, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cancellationException = null;
        }
        p1.e(coroutineContext, cancellationException);
    }

    public static final x0 g(n1 n1Var, x0 x0Var) {
        return n1Var.L(new z0(x0Var));
    }

    public static final void h(CoroutineContext coroutineContext) {
        n1 n1Var = (n1) coroutineContext.get(n1.f57382r0);
        if (n1Var != null) {
            p1.j(n1Var);
        }
    }

    public static final void i(n1 n1Var) {
        if (!n1Var.isActive()) {
            throw n1Var.A();
        }
    }

    public static final n1 j(CoroutineContext coroutineContext) {
        n1 n1Var = (n1) coroutineContext.get(n1.f57382r0);
        if (n1Var != null) {
            return n1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean k(CoroutineContext coroutineContext) {
        n1 n1Var = (n1) coroutineContext.get(n1.f57382r0);
        if (n1Var != null) {
            return n1Var.isActive();
        }
        return true;
    }
}
