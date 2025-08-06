package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.y;

public final class f<T> extends y<T> {
    public f(CoroutineContext coroutineContext, c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    public boolean d0(Throwable th2) {
        if (th2 instanceof ChildCancelledException) {
            return true;
        }
        return Y(th2);
    }
}
