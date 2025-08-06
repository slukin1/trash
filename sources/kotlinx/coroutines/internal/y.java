package kotlinx.coroutines.internal;

import d10.l;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.a;
import kotlinx.coroutines.a0;

public class y<T> extends a<T> implements c {

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f57351e;

    public y(CoroutineContext coroutineContext, kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, true, true);
        this.f57351e = cVar;
    }

    public void U(Object obj) {
        j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f57351e), a0.a(obj, this.f57351e), (l) null, 2, (Object) null);
    }

    public void b1(Object obj) {
        kotlin.coroutines.c<T> cVar = this.f57351e;
        cVar.resumeWith(a0.a(obj, cVar));
    }

    public final c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f57351e;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean w0() {
        return true;
    }
}
