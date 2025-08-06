package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;

public final class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle lifecycle, Lifecycle.State state, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar, c<? super Unit> cVar) {
        if (!(state != Lifecycle.State.INITIALIZED)) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        } else if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return Unit.f56620a;
        } else {
            Object g11 = i0.g(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, (c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3>) null), cVar);
            return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
        }
    }

    public static final Object b(LifecycleOwner lifecycleOwner, Lifecycle.State state, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar, c<? super Unit> cVar) {
        Object a11 = a(lifecycleOwner.getLifecycle(), state, pVar, cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }
}
