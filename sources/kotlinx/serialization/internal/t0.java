package kotlinx.serialization.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;

public final class t0<E> extends s<E, Set<? extends E>, LinkedHashSet<E>> {

    /* renamed from: b  reason: collision with root package name */
    public final f f57767b;

    public t0(b<E> bVar) {
        super(bVar);
        this.f57767b = new s0(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f57767b;
    }

    /* renamed from: q */
    public LinkedHashSet<E> a() {
        return new LinkedHashSet<>();
    }

    /* renamed from: r */
    public int b(LinkedHashSet<E> linkedHashSet) {
        return linkedHashSet.size();
    }

    /* renamed from: s */
    public void c(LinkedHashSet<E> linkedHashSet, int i11) {
    }

    /* renamed from: t */
    public void n(LinkedHashSet<E> linkedHashSet, int i11, E e11) {
        linkedHashSet.add(e11);
    }

    /* renamed from: u */
    public LinkedHashSet<E> k(Set<? extends E> set) {
        LinkedHashSet<E> linkedHashSet = set instanceof LinkedHashSet ? (LinkedHashSet) set : null;
        return linkedHashSet == null ? new LinkedHashSet<>(set) : linkedHashSet;
    }

    /* renamed from: v */
    public Set<E> l(LinkedHashSet<E> linkedHashSet) {
        return linkedHashSet;
    }
}
