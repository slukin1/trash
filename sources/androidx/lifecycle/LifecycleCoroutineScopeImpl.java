package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.v0;

public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements r {

    /* renamed from: b  reason: collision with root package name */
    public final Lifecycle f9899b;

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineContext f9900c;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        this.f9899b = lifecycle;
        this.f9900c = coroutineContext;
        if (a().b() == Lifecycle.State.DESTROYED) {
            r1.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public Lifecycle a() {
        return this.f9899b;
    }

    public final void e() {
        n1 unused = i.d(this, v0.c().G(), (CoroutineStart) null, new LifecycleCoroutineScopeImpl$register$1(this, (c<? super LifecycleCoroutineScopeImpl$register$1>) null), 2, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f9900c;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (a().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().d(this);
            r1.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }
}
