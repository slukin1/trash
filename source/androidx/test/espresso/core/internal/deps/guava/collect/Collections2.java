package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.Collection;

public final class Collections2 {
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    public static StringBuilder b(int i11) {
        CollectPreconditions.b(i11, "size");
        return new StringBuilder((int) Math.min(((long) i11) * 8, 1073741824));
    }
}
