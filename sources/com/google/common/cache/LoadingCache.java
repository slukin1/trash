package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    @Deprecated
    V apply(K k11);

    ConcurrentMap<K, V> asMap();

    V get(K k11) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k11);

    void refresh(K k11);
}
