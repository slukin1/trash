package kotlin;

import d10.a;
import java.io.Serializable;

public final class UnsafeLazyImpl<T> implements i<T>, Serializable {
    private Object _value = s.f56861a;
    private a<? extends T> initializer;

    public UnsafeLazyImpl(a<? extends T> aVar) {
        this.initializer = aVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        if (this._value == s.f56861a) {
            this._value = this.initializer.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    public boolean isInitialized() {
        return this._value != s.f56861a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
