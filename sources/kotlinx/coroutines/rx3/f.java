package kotlinx.coroutines.rx3;

import d10.p;
import h00.l;
import io.reactivex.rxjava3.core.Single;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public final class f {
    public static final <T> Single<T> b(CoroutineContext coroutineContext, p<? super h0, ? super c<? super T>, ? extends Object> pVar) {
        if (coroutineContext.get(n1.f57382r0) == null) {
            return c(g1.f57277b, coroutineContext, pVar);
        }
        throw new IllegalArgumentException(("Single context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + coroutineContext).toString());
    }

    public static final <T> Single<T> c(h0 h0Var, CoroutineContext coroutineContext, p<? super h0, ? super c<? super T>, ? extends Object> pVar) {
        return Single.b(new e(h0Var, coroutineContext, pVar));
    }

    public static final void d(h0 h0Var, CoroutineContext coroutineContext, p pVar, l lVar) {
        d dVar = new d(CoroutineContextKt.e(h0Var, coroutineContext), lVar);
        lVar.setCancellable(new a(dVar));
        dVar.e1(CoroutineStart.DEFAULT, dVar, pVar);
    }
}
