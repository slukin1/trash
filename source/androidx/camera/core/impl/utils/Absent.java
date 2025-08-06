package androidx.camera.core.impl.utils;

import androidx.core.util.h;
import androidx.core.util.j;

final class Absent<T> extends Optional<T> {
    public static final Absent<Object> sInstance = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    private Object readResolve() {
        return sInstance;
    }

    public static <T> Optional<T> withType() {
        return sInstance;
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
        return h.h(t11, "use Optional.orNull() instead of Optional.or(null)");
    }

    public T orNull() {
        return null;
    }

    public String toString() {
        return "Optional.absent()";
    }

    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) h.g(optional);
    }

    public T or(j<? extends T> jVar) {
        return h.h(jVar.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
