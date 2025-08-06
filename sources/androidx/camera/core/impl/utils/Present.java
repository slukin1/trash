package androidx.camera.core.impl.utils;

import androidx.core.util.h;
import androidx.core.util.j;

final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T mReference;

    public Present(T t11) {
        this.mReference = t11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.mReference.equals(((Present) obj).mReference);
        }
        return false;
    }

    public T get() {
        return this.mReference;
    }

    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    public boolean isPresent() {
        return true;
    }

    public T or(T t11) {
        h.h(t11, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    public T orNull() {
        return this.mReference;
    }

    public String toString() {
        return "Optional.of(" + this.mReference + ")";
    }

    public Optional<T> or(Optional<? extends T> optional) {
        h.g(optional);
        return this;
    }

    public T or(j<? extends T> jVar) {
        h.g(jVar);
        return this.mReference;
    }
}
