package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    public Lazy(T t11) {
        this.instance = t11;
    }

    public T get() {
        T t11 = this.instance;
        T t12 = UNINITIALIZED;
        if (t11 == t12) {
            synchronized (this) {
                t11 = this.instance;
                if (t11 == t12) {
                    t11 = this.provider.get();
                    this.instance = t11;
                    this.provider = null;
                }
            }
        }
        return t11;
    }

    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }

    public Lazy(Provider<T> provider2) {
        this.provider = provider2;
    }
}
