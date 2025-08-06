package kotlin.collections;

import e10.a;
import java.util.Iterator;

public final class o<T> implements Iterator<m<? extends T>>, a {

    /* renamed from: b  reason: collision with root package name */
    public final Iterator<T> f56658b;

    /* renamed from: c  reason: collision with root package name */
    public int f56659c;

    public o(Iterator<? extends T> it2) {
        this.f56658b = it2;
    }

    /* renamed from: a */
    public final m<T> next() {
        int i11 = this.f56659c;
        this.f56659c = i11 + 1;
        if (i11 < 0) {
            CollectionsKt__CollectionsKt.t();
        }
        return new m<>(i11, this.f56658b.next());
    }

    public final boolean hasNext() {
        return this.f56658b.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
