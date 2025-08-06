package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.h;
import kotlinx.coroutines.n1;

public final class d1<T> implements j1<T>, d, h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final n1 f57220b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j1<T> f57221c;

    public d1(j1<? extends T> j1Var, n1 n1Var) {
        this.f57220b = n1Var;
        this.f57221c = j1Var;
    }

    public List<T> a() {
        return this.f57221c.a();
    }

    public d<T> c(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return k1.d(this, coroutineContext, i11, bufferOverflow);
    }

    public Object collect(e<? super T> eVar, c<?> cVar) {
        return this.f57221c.collect(eVar, cVar);
    }

    public T getValue() {
        return this.f57221c.getValue();
    }
}
