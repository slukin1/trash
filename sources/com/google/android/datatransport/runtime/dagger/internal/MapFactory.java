package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import q00.a;

public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {
    private static final a<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.emptyMap());

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        public MapFactory<K, V> build() {
            return new MapFactory<>(this.map);
        }

        private Builder(int i11) {
            super(i11);
        }

        public Builder<K, V> put(K k11, a<V> aVar) {
            super.put(k11, aVar);
            return this;
        }

        public Builder<K, V> putAll(a<Map<K, V>> aVar) {
            super.putAll(aVar);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder(int i11) {
        return new Builder<>(i11);
    }

    public static <K, V> a<Map<K, V>> emptyMapProvider() {
        return EMPTY;
    }

    private MapFactory(Map<K, a<V>> map) {
        super(map);
    }

    public Map<K, V> get() {
        LinkedHashMap newLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (Map.Entry entry : contributingMap().entrySet()) {
            newLinkedHashMapWithExpectedSize.put(entry.getKey(), ((a) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }
}
