package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>((Object) null);
    private final T instance;

    private InstanceFactory(T t11) {
        this.instance = t11;
    }

    public static <T> Factory<T> create(T t11) {
        return new InstanceFactory(Preconditions.checkNotNull(t11, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t11) {
        if (t11 == null) {
            return nullInstanceFactory();
        }
        return new InstanceFactory(t11);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return NULL_INSTANCE_FACTORY;
    }

    public T get() {
        return this.instance;
    }
}
