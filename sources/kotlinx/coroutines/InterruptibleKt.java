package kotlinx.coroutines;

import d10.a;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;

public final class InterruptibleKt {
    public static final <T> Object b(CoroutineContext coroutineContext, a<? extends T> aVar, c<? super T> cVar) {
        return g.g(coroutineContext, new InterruptibleKt$runInterruptible$2(aVar, (c<? super InterruptibleKt$runInterruptible$2>) null), cVar);
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, a aVar, c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return b(coroutineContext, aVar, cVar);
    }

    public static final <T> T d(CoroutineContext coroutineContext, a<? extends T> aVar) {
        l2 l2Var;
        try {
            l2Var = new l2(p1.k(coroutineContext));
            l2Var.d();
            T invoke = aVar.invoke();
            l2Var.a();
            return invoke;
        } catch (InterruptedException e11) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e11);
        } catch (Throwable th2) {
            l2Var.a();
            throw th2;
        }
    }
}
