package com.google.android.datatransport.runtime.dagger.internal;

import q00.a;

public final class SingleCheck<T> implements a<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile a<T> provider;

    private SingleCheck(a<T> aVar) {
        this.provider = aVar;
    }

    public static <P extends a<T>, T> a<T> provider(P p11) {
        return ((p11 instanceof SingleCheck) || (p11 instanceof DoubleCheck)) ? p11 : new SingleCheck((a) Preconditions.checkNotNull(p11));
    }

    public T get() {
        T t11 = this.instance;
        if (t11 != UNINITIALIZED) {
            return t11;
        }
        a<T> aVar = this.provider;
        if (aVar == null) {
            return this.instance;
        }
        T t12 = aVar.get();
        this.instance = t12;
        this.provider = null;
        return t12;
    }
}
