package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    public final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    public final transient int size;

    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        @Weak
        public final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        public int size() {
            return this.multimap.size();
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    @GwtIncompatible
    public static class FieldSettersHolder {
        public static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
        public static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
    }

    public class Keys extends ImmutableMultiset<K> {
        public Keys() {
        }

        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        public int count(Object obj) {
            Collection collection = (Collection) ImmutableMultimap.this.map.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        public Multiset.Entry<K> getEntry(int i11) {
            Map.Entry entry = ImmutableMultimap.this.map.entrySet().asList().get(i11);
            return Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return ImmutableMultimap.this.size();
        }

        @GwtIncompatible
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    @GwtIncompatible
    public static final class KeysSerializedForm implements Serializable {
        public final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        @Weak
        private final transient ImmutableMultimap<K, V> multimap;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public boolean contains(Object obj) {
            return this.multimap.containsValue(obj);
        }

        @GwtIncompatible
        public int copyIntoArray(Object[] objArr, int i11) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> it2 = this.multimap.map.values().iterator();
            while (it2.hasNext()) {
                i11 = ((ImmutableCollection) it2.next()).copyIntoArray(objArr, i11);
            }
            return i11;
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.multimap.size();
        }

        public UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i11) {
        this.map = immutableMap;
        this.size = i11;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf(multimap);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract ImmutableCollection<V> get(K k11);

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.size;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static class Builder<K, V> {
        public Map<K, Collection<V>> builderMap = Platform.preservesInsertionOrderOnPutsMap();
        public Comparator<? super K> keyComparator;
        public Comparator<? super V> valueComparator;

        public ImmutableMultimap<K, V> build() {
            Collection entrySet = this.builderMap.entrySet();
            Comparator comparator = this.keyComparator;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.fromMapEntries(entrySet, this.valueComparator);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> combine(Builder<K, V> builder) {
            for (Map.Entry next : builder.builderMap.entrySet()) {
                putAll(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }

        public Collection<V> newMutableValueCollection() {
            return new ArrayList();
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k11, V v11) {
            CollectPreconditions.checkEntryNotNull(k11, v11);
            Collection collection = this.builderMap.get(k11);
            if (collection == null) {
                Map<K, Collection<V>> map = this.builderMap;
                Collection newMutableValueCollection = newMutableValueCollection();
                map.put(k11, newMutableValueCollection);
                collection = newMutableValueCollection;
            }
            collection.add(v11);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry put : iterable) {
                put(put);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k11, Iterable<? extends V> iterable) {
            if (k11 != null) {
                Collection collection = this.builderMap.get(k11);
                if (collection != null) {
                    for (Object next : iterable) {
                        CollectPreconditions.checkEntryNotNull(k11, next);
                        collection.add(next);
                    }
                    return this;
                }
                Iterator<? extends V> it2 = iterable.iterator();
                if (!it2.hasNext()) {
                    return this;
                }
                Collection newMutableValueCollection = newMutableValueCollection();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    CollectPreconditions.checkEntryNotNull(k11, next2);
                    newMutableValueCollection.add(next2);
                }
                this.builderMap.put(k11, newMutableValueCollection);
                return this;
            }
            throw new NullPointerException("null key in entry: null=" + Iterables.toString(iterable));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k11, V... vArr) {
            return putAll(k11, Arrays.asList(vArr));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry next : multimap.asMap().entrySet()) {
                putAll(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11) {
        return ImmutableListMultimap.of(k11, v11);
    }

    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {
            public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> asMapItr;
            public K currentKey = null;
            public Iterator<V> valueItr = Iterators.emptyIterator();

            {
                this.asMapItr = ImmutableMultimap.this.map.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.valueItr.hasNext() || this.asMapItr.hasNext();
            }

            public Map.Entry<K, V> next() {
                if (!this.valueItr.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.asMapItr.next();
                    this.currentKey = entry.getKey();
                    this.valueItr = ((ImmutableCollection) entry.getValue()).iterator();
                }
                return Maps.immutableEntry(this.currentKey, this.valueItr.next());
            }
        };
    }

    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public UnmodifiableIterator<V> valueIterator() {
        return new UnmodifiableIterator<V>() {
            public Iterator<? extends ImmutableCollection<V>> valueCollectionItr;
            public Iterator<V> valueItr = Iterators.emptyIterator();

            {
                this.valueCollectionItr = ImmutableMultimap.this.map.values().iterator();
            }

            public boolean hasNext() {
                return this.valueItr.hasNext() || this.valueCollectionItr.hasNext();
            }

            public V next() {
                if (!this.valueItr.hasNext()) {
                    this.valueItr = ((ImmutableCollection) this.valueCollectionItr.next()).iterator();
                }
                return this.valueItr.next();
            }
        };
    }

    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12) {
        return ImmutableListMultimap.of(k11, v11, k12, v12);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        return ImmutableListMultimap.of(k11, v11, k12, v12, k13, v13);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf(iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return ImmutableListMultimap.of(k11, v11, k12, v12, k13, v13, k14, v14);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        return ImmutableListMultimap.of(k11, v11, k12, v12, k13, v13, k14, v14, k15, v15);
    }
}
