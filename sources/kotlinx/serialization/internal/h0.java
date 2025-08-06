package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.Set;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;

public final class h0<E> extends s<E, Set<? extends E>, HashSet<E>> {

    /* renamed from: b  reason: collision with root package name */
    public final f f57722b;

    public h0(b<E> bVar) {
        super(bVar);
        this.f57722b = new g0(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f57722b;
    }

    /* renamed from: q */
    public HashSet<E> a() {
        return new HashSet<>();
    }

    /* renamed from: r */
    public int b(HashSet<E> hashSet) {
        return hashSet.size();
    }

    /* renamed from: s */
    public void c(HashSet<E> hashSet, int i11) {
    }

    /* renamed from: t */
    public void n(HashSet<E> hashSet, int i11, E e11) {
        hashSet.add(e11);
    }

    /* renamed from: u */
    public HashSet<E> k(Set<? extends E> set) {
        HashSet<E> hashSet = set instanceof HashSet ? (HashSet) set : null;
        return hashSet == null ? new HashSet<>(set) : hashSet;
    }

    /* renamed from: v */
    public Set<E> l(HashSet<E> hashSet) {
        return hashSet;
    }
}
