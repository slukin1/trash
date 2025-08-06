package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();

    public static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        public static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> set) {
            return new ForwardingSet<Map.Entry<K, V>>() {
                public Iterator<Map.Entry<K, V>> iterator() {
                    return UnmodifiableEntry.transformEntries(super.iterator());
                }

                public Object[] toArray() {
                    return standardToArray();
                }

                public <T> T[] toArray(T[] tArr) {
                    return standardToArray(tArr);
                }

                public Set<Map.Entry<K, V>> delegate() {
                    return set;
                }
            };
        }

        public V setValue(V v11) {
            throw new UnsupportedOperationException();
        }

        private UnmodifiableEntry(Map.Entry<K, V> entry) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(entry);
        }

        /* access modifiers changed from: private */
        public static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> it2) {
            return Iterators.transform(it2, new Function<Map.Entry<K, V>, Map.Entry<K, V>>() {
                public Map.Entry<K, V> apply(Map.Entry<K, V> entry) {
                    return new UnmodifiableEntry(entry);
                }
            });
        }

        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }
    }

    private <T extends B> T trustedGet(TypeToken<T> typeToken) {
        return this.backingMap.get(typeToken);
    }

    private <T extends B> T trustedPut(TypeToken<T> typeToken, T t11) {
        return this.backingMap.put(typeToken, t11);
    }

    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return trustedGet(TypeToken.of(cls));
    }

    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t11) {
        return trustedPut(TypeToken.of(cls), t11);
    }

    public Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    public <T extends B> T getInstance(TypeToken<T> typeToken) {
        return trustedGet(typeToken.rejectTypeVariables());
    }

    @CanIgnoreReturnValue
    @Deprecated
    public B put(TypeToken<? extends B> typeToken, B b11) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @CanIgnoreReturnValue
    public <T extends B> T putInstance(TypeToken<T> typeToken, T t11) {
        return trustedPut(typeToken.rejectTypeVariables(), t11);
    }
}
