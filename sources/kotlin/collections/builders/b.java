package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class b<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final MapBuilder<K, V> f56649b;

    public b(MapBuilder<K, V> mapBuilder) {
        this.f56649b = mapBuilder;
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean b(Map.Entry<? extends K, ? extends V> entry) {
        return this.f56649b.containsEntry$kotlin_stdlib(entry);
    }

    public boolean c(Map.Entry entry) {
        return this.f56649b.removeEntry$kotlin_stdlib(entry);
    }

    public void clear() {
        this.f56649b.clear();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.f56649b.containsAllEntries$kotlin_stdlib(collection);
    }

    /* renamed from: d */
    public boolean add(Map.Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public int getSize() {
        return this.f56649b.size();
    }

    public boolean isEmpty() {
        return this.f56649b.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f56649b.entriesIterator$kotlin_stdlib();
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        this.f56649b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        this.f56649b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
