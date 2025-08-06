package kotlin.collections;

import e10.a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.q;

public final class g<T> implements Collection<T>, a {

    /* renamed from: b  reason: collision with root package name */
    public final T[] f56652b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f56653c;

    public g(T[] tArr, boolean z11) {
        this.f56652b = tArr;
        this.f56653c = z11;
    }

    public int a() {
        return this.f56652b.length;
    }

    public boolean add(T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return ArraysKt___ArraysKt.C(this.f56652b, obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f56652b.length == 0;
    }

    public Iterator<T> iterator() {
        return h.a(this.f56652b);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return a();
    }

    public final Object[] toArray() {
        return CollectionsKt__CollectionsJVMKt.b(this.f56652b, this.f56653c);
    }

    public <T> T[] toArray(T[] tArr) {
        return q.b(this, tArr);
    }
}
