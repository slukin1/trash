package com.alibaba.fastjson;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class e<T> {

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentMap<Type, Type> f14174b = new ConcurrentHashMap(16, 0.75f, 1);

    /* renamed from: c  reason: collision with root package name */
    public static final Type f14175c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public final Type f14176a;

    public static class a extends e<List<String>> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.reflect.Type} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e() {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Class r0 = r2.getClass()
            java.lang.reflect.Type r0 = r0.getGenericSuperclass()
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type[] r0 = r0.getActualTypeArguments()
            r1 = 0
            r0 = r0[r1]
            java.util.concurrent.ConcurrentMap<java.lang.reflect.Type, java.lang.reflect.Type> r1 = f14174b
            java.lang.Object r1 = r1.get(r0)
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            if (r1 != 0) goto L_0x002c
            java.util.concurrent.ConcurrentMap<java.lang.reflect.Type, java.lang.reflect.Type> r1 = f14174b
            r1.putIfAbsent(r0, r0)
            java.util.concurrent.ConcurrentMap<java.lang.reflect.Type, java.lang.reflect.Type> r1 = f14174b
            java.lang.Object r0 = r1.get(r0)
            r1 = r0
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
        L_0x002c:
            r2.f14176a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.e.<init>():void");
    }

    public Type a() {
        return this.f14176a;
    }
}
