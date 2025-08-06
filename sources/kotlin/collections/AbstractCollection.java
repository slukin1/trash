package kotlin.collections;

import e10.a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;

public abstract class AbstractCollection<E> implements Collection<E>, a {
    public boolean add(E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(E e11) {
        if (isEmpty()) {
            return false;
        }
        for (Object b11 : this) {
            if (x.b(b11, e11)) {
                return true;
            }
        }
        return false;
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

    public abstract int getSize();

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract Iterator<E> iterator();

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
        return getSize();
    }

    public Object[] toArray() {
        return q.a(this);
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.k0(this, ", ", "[", "]", 0, (CharSequence) null, new AbstractCollection$toString$1(this), 24, (Object) null);
    }

    public <T> T[] toArray(T[] tArr) {
        return q.b(this, tArr);
    }
}
