package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.h;
import kotlinx.coroutines.n1;

public final class c1<T> implements f1<T>, d, h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final n1 f57218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f1<T> f57219c;

    public c1(f1<? extends T> f1Var, n1 n1Var) {
        this.f57218b = n1Var;
        this.f57219c = f1Var;
    }

    public List<T> a() {
        return this.f57219c.a();
    }

    public d<T> c(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return g1.e(this, coroutineContext, i11, bufferOverflow);
    }

    public Object collect(e<? super T> eVar, c<?> cVar) {
        return this.f57219c.collect(eVar, cVar);
    }
}
