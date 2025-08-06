package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.c;

public final class d<V> extends c<V> {

    /* renamed from: b  reason: collision with root package name */
    public final MapBuilder<?, V> f56651b;

    public d(MapBuilder<?, V> mapBuilder) {
        this.f56651b = mapBuilder;
    }

    public int a() {
        return this.f56651b.size();
    }

    public boolean add(V v11) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f56651b.clear();
    }

    public boolean contains(Object obj) {
        return this.f56651b.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.f56651b.isEmpty();
    }

    public Iterator<V> iterator() {
        return this.f56651b.valuesIterator$kotlin_stdlib();
    }

    public boolean remove(Object obj) {
        return this.f56651b.removeValue$kotlin_stdlib(obj);
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        this.f56651b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        this.f56651b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
