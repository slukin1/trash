package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

@GwtIncompatible
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    public final V apply(K k11) {
        return getUnchecked(k11);
    }

    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (Object next : iterable) {
            if (!newLinkedHashMap.containsKey(next)) {
                newLinkedHashMap.put(next, get(next));
            }
        }
        return ImmutableMap.copyOf(newLinkedHashMap);
    }

    public V getUnchecked(K k11) {
        try {
            return get(k11);
        } catch (ExecutionException e11) {
            throw new UncheckedExecutionException(e11.getCause());
        }
    }

    public void refresh(K k11) {
        throw new UnsupportedOperationException();
    }
}
