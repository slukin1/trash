package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Collections;
import java.util.Set;

final class Absent<T> extends Optional<T> {
    public static final Absent<Object> INSTANCE = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    public Set<T> asSet() {
        return Collections.emptySet();
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public int hashCode() {
        return 2040732332;
    }

    public boolean isPresent() {
        return false;
    }

    public T or(T t11) {
        return Preconditions.j(t11, "use Optional.orNull() instead of Optional.or(null)");
    }

    public T orNull() {
        return null;
    }

    public String toString() {
        return "Optional.absent()";
    }

    public <V> Optional<V> transform(Function<? super T, V> function) {
        Preconditions.i(function);
        return Optional.absent();
    }

    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) Preconditions.i(optional);
    }

    public T or(Supplier<? extends T> supplier) {
        return Preconditions.j(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
