package kotlinx.coroutines;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;

public final class g {
    public static final <T> n0<T> a(h0 h0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, p<? super h0, ? super c<? super T>, ? extends Object> pVar) {
        return i.a(h0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final n1 c(h0 h0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar) {
        return i.c(h0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final <T> T e(CoroutineContext coroutineContext, p<? super h0, ? super c<? super T>, ? extends Object> pVar) throws InterruptedException {
        return h.a(coroutineContext, pVar);
    }

    public static final <T> Object g(CoroutineContext coroutineContext, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        return i.e(coroutineContext, pVar, cVar);
    }
}
