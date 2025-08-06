package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import q00.a;

abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    /* access modifiers changed from: private */
    public final Map<K, a<V>> contributingMap;

    public static abstract class Builder<K, V, V2> {
        public final LinkedHashMap<K, a<V>> map;

        public Builder(int i11) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i11);
        }

        public Builder<K, V, V2> put(K k11, a<V> aVar) {
            this.map.put(Preconditions.checkNotNull(k11, "key"), Preconditions.checkNotNull(aVar, "provider"));
            return this;
        }

        public Builder<K, V, V2> putAll(a<Map<K, V2>> aVar) {
            if (aVar instanceof DelegateFactory) {
                return putAll(((DelegateFactory) aVar).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) aVar).contributingMap);
            return this;
        }
    }

    public AbstractMapFactory(Map<K, a<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    public final Map<K, a<V>> contributingMap() {
        return this.contributingMap;
    }

    public abstract /* synthetic */ Object get();
}
