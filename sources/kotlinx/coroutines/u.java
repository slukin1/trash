package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.jvm.internal.r;

public final class u<T> extends JobSupport implements t<T> {
    public u(n1 n1Var) {
        super(true);
        v0(n1Var);
    }

    public T f() {
        return j0();
    }

    public Object j(c<? super T> cVar) {
        Object V = V(cVar);
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        return V;
    }

    public boolean o(Throwable th2) {
        return A0(new y(th2, false, 2, (r) null));
    }

    public boolean p(T t11) {
        return A0(t11);
    }

    public boolean p0() {
        return true;
    }
}
