package kotlin;

import java.io.Serializable;

public final class InitializedLazyImpl<T> implements i<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t11) {
        this.value = t11;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
