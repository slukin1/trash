package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.p;
import kotlin.coroutines.c;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

public final class PausingDispatcherKt {
    public static final <T> Object a(Lifecycle lifecycle, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        return d(lifecycle, Lifecycle.State.CREATED, pVar, cVar);
    }

    public static final <T> Object b(Lifecycle lifecycle, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        return d(lifecycle, Lifecycle.State.RESUMED, pVar, cVar);
    }

    public static final <T> Object c(Lifecycle lifecycle, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        return d(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }

    public static final <T> Object d(Lifecycle lifecycle, Lifecycle.State state, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        return g.g(v0.c().G(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, (c<? super PausingDispatcherKt$whenStateAtLeast$2>) null), cVar);
    }
}
