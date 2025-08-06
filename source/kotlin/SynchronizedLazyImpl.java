package kotlin;

import d10.a;
import java.io.Serializable;
import kotlin.jvm.internal.r;

final class SynchronizedLazyImpl<T> implements i<T>, Serializable {
    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(a<? extends T> aVar, Object obj) {
        this.initializer = aVar;
        this._value = s.f56861a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        T t11;
        T t12 = this._value;
        T t13 = s.f56861a;
        if (t12 != t13) {
            return t12;
        }
        synchronized (this.lock) {
            t11 = this._value;
            if (t11 == t13) {
                t11 = this.initializer.invoke();
                this._value = t11;
                this.initializer = null;
            }
        }
        return t11;
    }

    public boolean isInitialized() {
        return this._value != s.f56861a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SynchronizedLazyImpl(a aVar, Object obj, int i11, r rVar) {
        this(aVar, (i11 & 2) != 0 ? null : obj);
    }
}
