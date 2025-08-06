package androidx.test.espresso.core.internal.deps.guava.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t11) {
        return t11 == null ? absent() : new Present(t11);
    }

    public static <T> Optional<T> of(T t11) {
        return new Present(Preconditions.i(t11));
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.i(iterable);
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() {

                    /* renamed from: d  reason: collision with root package name */
                    public final Iterator<? extends Optional<? extends T>> f11158d;

                    {
                        this.f11158d = (Iterator) Preconditions.i(iterable.iterator());
                    }

                    public T a() {
                        while (this.f11158d.hasNext()) {
                            Optional optional = (Optional) this.f11158d.next();
                            if (optional.isPresent()) {
                                return optional.get();
                            }
                        }
                        return b();
                    }
                };
            }
        };
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t11);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
