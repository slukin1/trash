package kotlinx.serialization.internal;

import c10.a;
import d10.l;
import kotlin.reflect.c;
import kotlinx.serialization.b;

public final class ClassValueCache<T> implements r1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final l<c<?>, b<T>> f57651a;

    /* renamed from: b  reason: collision with root package name */
    public final ClassValueReferences<l<T>> f57652b = new ClassValueReferences<>();

    public ClassValueCache(l<? super c<?>, ? extends b<T>> lVar) {
        this.f57651a = lVar;
    }

    public b<T> a(c<Object> cVar) {
        MutableSoftReference mutableSoftReference = (MutableSoftReference) this.f57652b.get(a.a(cVar));
        T t11 = mutableSoftReference.f57663a.get();
        if (t11 == null) {
            t11 = mutableSoftReference.a(new ClassValueCache$get$$inlined$getOrSet$1(this, cVar));
        }
        return ((l) t11).f57739a;
    }

    public final l<c<?>, b<T>> b() {
        return this.f57651a;
    }
}
