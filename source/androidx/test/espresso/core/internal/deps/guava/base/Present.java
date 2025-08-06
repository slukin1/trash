package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Collections;
import java.util.Set;

final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public Present(T t11) {
        this.reference = t11;
    }

    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    public T get() {
        return this.reference;
    }

    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    public boolean isPresent() {
        return true;
    }

    public T or(T t11) {
        Preconditions.j(t11, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    public T orNull() {
        return this.reference;
    }

    public String toString() {
        String valueOf = String.valueOf(this.reference);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
        sb2.append("Optional.of(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }

    public <V> Optional<V> transform(Function<? super T, V> function) {
        return new Present(Preconditions.j(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    public Optional<T> or(Optional<? extends T> optional) {
        Preconditions.i(optional);
        return this;
    }

    public T or(Supplier<? extends T> supplier) {
        Preconditions.i(supplier);
        return this.reference;
    }
}
