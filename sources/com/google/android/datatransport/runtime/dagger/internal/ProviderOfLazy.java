package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import q00.a;

public final class ProviderOfLazy<T> implements a<Lazy<T>> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final a<T> provider;

    private ProviderOfLazy(a<T> aVar) {
        this.provider = aVar;
    }

    public static <T> a<Lazy<T>> create(a<T> aVar) {
        return new ProviderOfLazy((a) Preconditions.checkNotNull(aVar));
    }

    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }
}
