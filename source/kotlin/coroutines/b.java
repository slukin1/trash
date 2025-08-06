package kotlin.coroutines;

import d10.l;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.a;

public abstract class b<B extends CoroutineContext.a, E extends B> implements CoroutineContext.b<E> {

    /* renamed from: b  reason: collision with root package name */
    public final l<CoroutineContext.a, E> f56670b;

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineContext.b<?> f56671c;

    public b(CoroutineContext.b<B> bVar, l<? super CoroutineContext.a, ? extends E> lVar) {
        this.f56670b = lVar;
        this.f56671c = bVar instanceof b ? ((b) bVar).f56671c : bVar;
    }

    public final boolean a(CoroutineContext.b<?> bVar) {
        return bVar == this || this.f56671c == bVar;
    }

    public final E b(CoroutineContext.a aVar) {
        return (CoroutineContext.a) this.f56670b.invoke(aVar);
    }
}
