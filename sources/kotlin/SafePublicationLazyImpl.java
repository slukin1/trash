package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.r;

final class SafePublicationLazyImpl<T> implements i<T>, Serializable {
    public static final a Companion = new a((r) null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final  reason: not valid java name */
    private final Object f3455final;
    private volatile d10.a<? extends T> initializer;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public SafePublicationLazyImpl(d10.a<? extends T> aVar) {
        this.initializer = aVar;
        s sVar = s.f56861a;
        this._value = sVar;
        this.f3455final = sVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        T t11 = this._value;
        T t12 = s.f56861a;
        if (t11 != t12) {
            return t11;
        }
        d10.a<? extends T> aVar = this.initializer;
        if (aVar != null) {
            T invoke = aVar.invoke();
            if (androidx.concurrent.futures.a.a(valueUpdater, this, t12, invoke)) {
                this.initializer = null;
                return invoke;
            }
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
