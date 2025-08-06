package com.alibaba.fastjson.serializer;

import h2.p;

public abstract class AfterFilter implements p {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<JSONSerializer> f14247a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Character> f14248b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Character f14249c = ',';

    public final char f(JSONSerializer jSONSerializer, Object obj, char c11) {
        ThreadLocal<JSONSerializer> threadLocal = f14247a;
        threadLocal.set(jSONSerializer);
        ThreadLocal<Character> threadLocal2 = f14248b;
        threadLocal2.set(Character.valueOf(c11));
        g(obj);
        threadLocal.set((Object) null);
        return threadLocal2.get().charValue();
    }

    public abstract void g(Object obj);
}
