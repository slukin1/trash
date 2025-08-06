package kotlinx.coroutines.internal;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.e0;

public final class OnUndeliveredElementKt {
    public static final <E> l<Throwable, Unit> a(l<? super E, Unit> lVar, E e11, CoroutineContext coroutineContext) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(lVar, e11, coroutineContext);
    }

    public static final <E> void b(l<? super E, Unit> lVar, E e11, CoroutineContext coroutineContext) {
        UndeliveredElementException c11 = c(lVar, e11, (UndeliveredElementException) null);
        if (c11 != null) {
            e0.a(coroutineContext, c11);
        }
    }

    public static final <E> UndeliveredElementException c(l<? super E, Unit> lVar, E e11, UndeliveredElementException undeliveredElementException) {
        try {
            lVar.invoke(e11);
        } catch (Throwable th2) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th2) {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e11, th2);
            }
            ExceptionsKt__ExceptionsKt.a(undeliveredElementException, th2);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(lVar, obj, undeliveredElementException);
    }
}
