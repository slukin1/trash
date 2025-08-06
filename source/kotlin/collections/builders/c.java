package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.f;

public final class c<E> extends f<E> {

    /* renamed from: b  reason: collision with root package name */
    public final MapBuilder<E, ?> f56650b;

    public c(MapBuilder<E, ?> mapBuilder) {
        this.f56650b = mapBuilder;
    }

    public boolean add(E e11) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f56650b.clear();
    }

    public boolean contains(Object obj) {
        return this.f56650b.containsKey(obj);
    }

    public int getSize() {
        return this.f56650b.size();
    }

    public boolean isEmpty() {
        return this.f56650b.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.f56650b.keysIterator$kotlin_stdlib();
    }

    public boolean remove(Object obj) {
        return this.f56650b.removeKey$kotlin_stdlib(obj) >= 0;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        this.f56650b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        this.f56650b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
