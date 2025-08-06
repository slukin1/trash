package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import java.util.Map;
import q00.a;

public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, a<V>> implements Lazy<Map<K, a<V>>> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, a<V>> {
        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map);
        }

        private Builder(int i11) {
            super(i11);
        }

        public Builder<K, V> put(K k11, a<V> aVar) {
            super.put(k11, aVar);
            return this;
        }

        public Builder<K, V> putAll(a<Map<K, a<V>>> aVar) {
            super.putAll(aVar);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder(int i11) {
        return new Builder<>(i11);
    }

    private MapProviderFactory(Map<K, a<V>> map) {
        super(map);
    }

    public Map<K, a<V>> get() {
        return contributingMap();
    }
}
