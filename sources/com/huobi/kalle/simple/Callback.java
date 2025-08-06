package com.huobi.kalle.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import lm.h;

public abstract class Callback<Succeed, Failed> {
    public Type a() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Type b() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public abstract void c();

    public abstract void d();

    public abstract void e(Exception exc);

    public abstract void f(h<Succeed, Failed> hVar);

    public abstract void g();
}
