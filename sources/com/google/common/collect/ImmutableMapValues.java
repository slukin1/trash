package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map;

@GwtCompatible(emulated = true)
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    /* access modifiers changed from: private */
    public final ImmutableMap<K, V> map;

    @GwtIncompatible
    public static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableMap<?, V> map;

        public SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        public Object readResolve() {
            return this.map.values();
        }
    }

    public ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> asList = this.map.entrySet().asList();
        return new ImmutableList<V>() {
            public V get(int i11) {
                return ((Map.Entry) asList.get(i11)).getValue();
            }

            public boolean isPartialView() {
                return true;
            }

            public int size() {
                return asList.size();
            }
        };
    }

    public boolean contains(Object obj) {
        return obj != null && Iterators.contains(iterator(), obj);
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.map.size();
    }

    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this.map);
    }

    public UnmodifiableIterator<V> iterator() {
        return new UnmodifiableIterator<V>() {
            public final UnmodifiableIterator<Map.Entry<K, V>> entryItr;

            {
                this.entryItr = ImmutableMapValues.this.map.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.entryItr.hasNext();
            }

            public V next() {
                return this.entryItr.next().getValue();
            }
        };
    }
}
