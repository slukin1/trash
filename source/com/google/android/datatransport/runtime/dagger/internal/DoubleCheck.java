package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import q00.a;

public final class DoubleCheck<T> implements a<T>, Lazy<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile a<T> provider;

    private DoubleCheck(a<T> aVar) {
        this.provider = aVar;
    }

    public static <P extends a<T>, T> Lazy<T> lazy(P p11) {
        if (p11 instanceof Lazy) {
            return (Lazy) p11;
        }
        return new DoubleCheck((a) Preconditions.checkNotNull(p11));
    }

    public static <P extends a<T>, T> a<T> provider(P p11) {
        Preconditions.checkNotNull(p11);
        if (p11 instanceof DoubleCheck) {
            return p11;
        }
        return new DoubleCheck(p11);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (!(obj != UNINITIALIZED && !(obj instanceof MemoizedSentinel)) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t11 = this.instance;
        T t12 = UNINITIALIZED;
        if (t11 == t12) {
            synchronized (this) {
                t11 = this.instance;
                if (t11 == t12) {
                    t11 = this.provider.get();
                    this.instance = reentrantCheck(this.instance, t11);
                    this.provider = null;
                }
            }
        }
        return t11;
    }
}
