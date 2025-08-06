package kotlin.collections;

import e10.a;
import java.util.Iterator;

public final class n<T> implements Iterable<m<? extends T>>, a {

    /* renamed from: b  reason: collision with root package name */
    public final d10.a<Iterator<T>> f56657b;

    public n(d10.a<? extends Iterator<? extends T>> aVar) {
        this.f56657b = aVar;
    }

    public Iterator<m<T>> iterator() {
        return new o(this.f56657b.invoke());
    }
}
