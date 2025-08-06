package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.AbstractMap;

public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(K k11, V v11, RemovalCause removalCause) {
        super(k11, v11);
        this.cause = (RemovalCause) Preconditions.i(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(K k11, V v11, RemovalCause removalCause) {
        return new RemovalNotification<>(k11, v11, removalCause);
    }
}
