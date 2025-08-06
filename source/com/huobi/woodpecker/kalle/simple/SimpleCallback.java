package com.huobi.woodpecker.kalle.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class SimpleCallback<V> extends Callback<V, String> {
    public Type a() {
        return String.class;
    }

    public Type b() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void c() {
    }

    public void d() {
    }

    public void e(Exception exc) {
    }

    public void g() {
    }
}
