package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;

@GwtCompatible
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(K k11, V v11, RemovalCause removalCause) {
        super(k11, v11);
        this.cause = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(K k11, V v11, RemovalCause removalCause) {
        return new RemovalNotification<>(k11, v11, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
