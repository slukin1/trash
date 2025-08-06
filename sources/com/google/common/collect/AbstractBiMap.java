package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    @RetainedWith
    public transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    public class BiMapEntry extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        public BiMapEntry(Map.Entry<K, V> entry) {
            this.delegate = entry;
        }

        public V setValue(V v11) {
            AbstractBiMap.this.checkValue(v11);
            Preconditions.checkState(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(v11, getValue())) {
                return v11;
            }
            Preconditions.checkArgument(!AbstractBiMap.this.containsValue(v11), "value already present: %s", (Object) v11);
            V value = this.delegate.setValue(v11);
            Preconditions.checkState(Objects.equal(v11, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v11);
            return value;
        }

        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }
    }

    public class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
        public final Set<Map.Entry<K, V>> esDelegate;

        private EntrySet() {
            this.esDelegate = AbstractBiMap.this.delegate.entrySet();
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean contains(Object obj) {
            return Maps.containsEntryImpl(delegate(), obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        public boolean remove(Object obj) {
            if (!this.esDelegate.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.esDelegate.remove(entry);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public Set<Map.Entry<K, V>> delegate() {
            return this.esDelegate;
        }
    }

    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        public K checkKey(K k11) {
            return this.inverse.checkValue(k11);
        }

        public V checkValue(V v11) {
            return this.inverse.checkKey(v11);
        }

        public /* bridge */ /* synthetic */ Object delegate() {
            return AbstractBiMap.super.delegate();
        }

        @GwtIncompatible
        public Object readResolve() {
            return inverse().inverse();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return AbstractBiMap.super.values();
        }
    }

    public class ValueSet extends ForwardingSet<V> {
        public final Set<V> valuesDelegate;

        private ValueSet() {
            this.valuesDelegate = AbstractBiMap.this.inverse.keySet();
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public String toString() {
            return standardToString();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public Set<V> delegate() {
            return this.valuesDelegate;
        }
    }

    private V putInBothMaps(K k11, V v11, boolean z11) {
        checkKey(k11);
        checkValue(v11);
        boolean containsKey = containsKey(k11);
        if (containsKey && Objects.equal(v11, get(k11))) {
            return v11;
        }
        if (z11) {
            inverse().remove(v11);
        } else {
            Preconditions.checkArgument(!containsValue(v11), "value already present: %s", (Object) v11);
        }
        V put = this.delegate.put(k11, v11);
        updateInverseMap(k11, containsKey, put, v11);
        return put;
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* access modifiers changed from: private */
    public void removeFromInverseMap(V v11) {
        this.inverse.delegate.remove(v11);
    }

    /* access modifiers changed from: private */
    public void updateInverseMap(K k11, boolean z11, V v11, V v12) {
        if (z11) {
            removeFromInverseMap(v11);
        }
        this.inverse.delegate.put(v12, k11);
    }

    @CanIgnoreReturnValue
    public K checkKey(K k11) {
        return k11;
    }

    @CanIgnoreReturnValue
    public V checkValue(V v11) {
        return v11;
    }

    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        final Iterator<Map.Entry<K, V>> it2 = this.delegate.entrySet().iterator();
        return new Iterator<Map.Entry<K, V>>() {
            public Map.Entry<K, V> entry;

            public boolean hasNext() {
                return it2.hasNext();
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.entry != null);
                V value = this.entry.getValue();
                it2.remove();
                AbstractBiMap.this.removeFromInverseMap(value);
                this.entry = null;
            }

            public Map.Entry<K, V> next() {
                Map.Entry<K, V> entry2 = (Map.Entry) it2.next();
                this.entry = entry2;
                return new BiMapEntry(entry2);
            }
        };
    }

    @CanIgnoreReturnValue
    public V forcePut(K k11, V v11) {
        return putInBothMaps(k11, v11, true);
    }

    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @CanIgnoreReturnValue
    public V put(K k11, V v11) {
        return putInBothMaps(k11, v11, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        boolean z11 = true;
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        if (map == map2) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            Object unused = AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    public Map<K, V> delegate() {
        return this.delegate;
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
