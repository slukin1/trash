package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;

public interface d extends CoroutineContext.a {

    /* renamed from: p0  reason: collision with root package name */
    public static final b f56672p0 = b.f56673b;

    public static final class a {
        public static <E extends CoroutineContext.a> E a(d dVar, CoroutineContext.b<E> bVar) {
            if (bVar instanceof b) {
                b bVar2 = (b) bVar;
                if (!bVar2.a(dVar.getKey())) {
                    return null;
                }
                E b11 = bVar2.b(dVar);
                if (b11 instanceof CoroutineContext.a) {
                    return b11;
                }
                return null;
            } else if (d.f56672p0 == bVar) {
                return dVar;
            } else {
                return null;
            }
        }

        public static CoroutineContext b(d dVar, CoroutineContext.b<?> bVar) {
            if (!(bVar instanceof b)) {
                return d.f56672p0 == bVar ? EmptyCoroutineContext.INSTANCE : dVar;
            }
            b bVar2 = (b) bVar;
            return (!bVar2.a(dVar.getKey()) || bVar2.b(dVar) == null) ? dVar : EmptyCoroutineContext.INSTANCE;
        }
    }

    public static final class b implements CoroutineContext.b<d> {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ b f56673b = new b();
    }

    void e(c<?> cVar);

    <T> c<T> y(c<? super T> cVar);
}
