package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;

public final class Iterables {
    public static <T> T a(Iterable<? extends T> iterable, T t11) {
        return Iterators.c(iterable.iterator(), t11);
    }

    public static boolean b(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static String c(Iterable<?> iterable) {
        return Iterators.e(iterable.iterator());
    }

    public static <F, T> Iterable<T> d(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.i(iterable);
        Preconditions.i(function);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.f(iterable.iterator(), function);
            }
        };
    }
}
