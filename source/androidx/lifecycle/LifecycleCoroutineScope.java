package androidx.lifecycle;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public abstract class LifecycleCoroutineScope implements h0 {
    public abstract Lifecycle a();

    public final n1 b(p<? super h0, ? super c<? super Unit>, ? extends Object> pVar) {
        return i.d(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenCreated$1(this, pVar, (c<? super LifecycleCoroutineScope$launchWhenCreated$1>) null), 3, (Object) null);
    }

    public final n1 c(p<? super h0, ? super c<? super Unit>, ? extends Object> pVar) {
        return i.d(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenResumed$1(this, pVar, (c<? super LifecycleCoroutineScope$launchWhenResumed$1>) null), 3, (Object) null);
    }

    public final n1 d(p<? super h0, ? super c<? super Unit>, ? extends Object> pVar) {
        return i.d(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenStarted$1(this, pVar, (c<? super LifecycleCoroutineScope$launchWhenStarted$1>) null), 3, (Object) null);
    }
}
