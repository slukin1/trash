package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.x0;

public final class EmittedSource implements x0 {

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<?> f9888b;

    /* renamed from: c  reason: collision with root package name */
    public final MediatorLiveData<?> f9889c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9890d;

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        this.f9888b = liveData;
        this.f9889c = mediatorLiveData;
    }

    public final void c() {
        if (!this.f9890d) {
            this.f9889c.c(this.f9888b);
            this.f9890d = true;
        }
    }

    public void dispose() {
        n1 unused = i.d(i0.a(v0.c().G()), (CoroutineContext) null, (CoroutineStart) null, new EmittedSource$dispose$1(this, (c<? super EmittedSource$dispose$1>) null), 3, (Object) null);
    }
}
