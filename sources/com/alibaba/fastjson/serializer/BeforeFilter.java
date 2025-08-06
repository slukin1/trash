package com.alibaba.fastjson.serializer;

import h2.p;

public abstract class BeforeFilter implements p {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<JSONSerializer> f14254a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Character> f14255b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Character f14256c = ',';

    public final char f(JSONSerializer jSONSerializer, Object obj, char c11) {
        ThreadLocal<JSONSerializer> threadLocal = f14254a;
        threadLocal.set(jSONSerializer);
        ThreadLocal<Character> threadLocal2 = f14255b;
        threadLocal2.set(Character.valueOf(c11));
        g(obj);
        threadLocal.set((Object) null);
        return threadLocal2.get().charValue();
    }

    public abstract void g(Object obj);
}
