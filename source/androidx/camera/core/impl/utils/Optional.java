package androidx.camera.core.impl.utils;

import androidx.core.util.h;
import androidx.core.util.j;
import java.io.Serializable;

public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t11) {
        return t11 == null ? absent() : new Present(t11);
    }

    public static <T> Optional<T> of(T t11) {
        return new Present(h.g(t11));
    }

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(j<? extends T> jVar);

    public abstract T or(T t11);

    public abstract T orNull();

    public abstract String toString();
}
