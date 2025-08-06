package io.reactivex.rxjava3.internal.util;

import j00.h;
import j00.k;
import java.util.ArrayList;
import java.util.List;

public enum ArrayListSupplier implements k<List<Object>>, h<Object, List<Object>> {
    INSTANCE;

    public static <T, O> h<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public static <T> k<List<T>> asSupplier() {
        return INSTANCE;
    }

    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    public List<Object> get() {
        return new ArrayList();
    }
}
