package com.mob.commons.cc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private u f27141a;

    /* renamed from: b  reason: collision with root package name */
    private LinkedList<Object> f27142b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, Object> f27143c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Class<?>> f27144d;

    /* renamed from: e  reason: collision with root package name */
    private s f27145e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27146f;

    public s(HashMap<String, Object> hashMap, u uVar) {
        this.f27141a = uVar;
        this.f27143c = new HashMap<>(hashMap);
        this.f27144d = new HashMap<>();
    }

    public void a(Object obj) {
        this.f27142b.push(obj);
    }

    public void b(String str, Object obj) {
        if (this.f27143c.containsKey(str)) {
            this.f27143c.put(str, obj);
            return;
        }
        s sVar = this.f27145e;
        if (sVar != null) {
            sVar.b(str, obj);
            return;
        }
        throw new RuntimeException("\"" + str + "\" has not defined");
    }

    public s c() {
        return this.f27145e;
    }

    public int d() {
        return this.f27142b.size();
    }

    public void e() {
        this.f27146f = true;
    }

    public boolean f() {
        return this.f27146f;
    }

    public u g() {
        return this.f27141a;
    }

    public Object a() {
        return this.f27142b.pop();
    }

    public void a(String str, Object obj) {
        if (!this.f27143c.containsKey(str)) {
            this.f27143c.put(str, obj);
            return;
        }
        throw new RuntimeException("\"" + str + "\" has defined");
    }

    public Object a(String str) {
        for (s sVar = this; sVar != null; sVar = sVar.f27145e) {
            if (sVar.f27143c.containsKey(str)) {
                return sVar.f27143c.get(str);
            }
        }
        throw new RuntimeException("Can not find \"" + str + "\"");
    }

    public Class<?> b(String str) {
        for (s sVar = this; sVar != null; sVar = sVar.f27145e) {
            if (sVar.f27144d.containsKey(str)) {
                return sVar.f27144d.get(str);
            }
        }
        throw new RuntimeException("Can not find class " + str);
    }

    public void a(String str, Class<?> cls) {
        this.f27144d.put(str, cls);
    }

    public s b() {
        s sVar = new s(new HashMap(), this.f27141a);
        sVar.f27145e = this;
        return sVar;
    }

    public Object a(final Object obj, final boolean z11, Class<?>... clsArr) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new InvocationHandler() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.mob.commons.cc.z} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object invoke(java.lang.Object r3, java.lang.reflect.Method r4, java.lang.Object[] r5) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r3 = 0
                    java.lang.Object r0 = r3     // Catch:{ all -> 0x003d }
                    if (r0 == 0) goto L_0x001a
                    boolean r1 = r0 instanceof com.mob.commons.cc.z     // Catch:{ all -> 0x003d }
                    if (r1 == 0) goto L_0x000c
                    com.mob.commons.cc.z r0 = (com.mob.commons.cc.z) r0     // Catch:{ all -> 0x003d }
                    goto L_0x001b
                L_0x000c:
                    java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x003d }
                    java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x003d }
                    java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x003d }
                    r0 = r4
                    com.mob.commons.cc.z r0 = (com.mob.commons.cc.z) r0     // Catch:{ all -> 0x003d }
                    goto L_0x001b
                L_0x001a:
                    r0 = r3
                L_0x001b:
                    if (r0 == 0) goto L_0x003d
                    r4 = 0
                    if (r5 != 0) goto L_0x0022
                    java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x003d }
                L_0x0022:
                    boolean r1 = r4     // Catch:{ all -> 0x003d }
                    if (r1 == 0) goto L_0x002b
                    java.util.LinkedList r5 = r0.b(r5)     // Catch:{ all -> 0x003d }
                    goto L_0x002f
                L_0x002b:
                    java.util.LinkedList r5 = r0.b(r5)     // Catch:{ all -> 0x003b }
                L_0x002f:
                    boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x003d }
                    if (r0 == 0) goto L_0x0036
                    goto L_0x003a
                L_0x0036:
                    java.lang.Object r3 = r5.get(r4)     // Catch:{ all -> 0x003d }
                L_0x003a:
                    return r3
                L_0x003b:
                    r4 = move-exception
                    throw r4     // Catch:{ all -> 0x003e }
                L_0x003d:
                    r4 = r3
                L_0x003e:
                    if (r4 != 0) goto L_0x0041
                    return r3
                L_0x0041:
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.s.AnonymousClass1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
            }
        });
    }

    public void a(Method method, int i11) throws Throwable {
        Object[] objArr = new Object[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = a();
        }
        a(method, objArr);
    }

    public void a(Method method, Object[] objArr) throws Throwable {
        Object obj;
        if (Modifier.isStatic(method.getModifiers())) {
            obj = null;
        } else if (objArr.length > 0) {
            obj = objArr[0];
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                objArr2[i11] = objArr[i12];
                i11 = i12;
            }
            objArr = objArr2;
        } else {
            throw new RuntimeException("receiver not found");
        }
        method.setAccessible(true);
        for (int i13 = 0; i13 < objArr.length; i13++) {
            if (method.getParameterTypes()[i13].isInterface() && (objArr[i13] instanceof z)) {
                objArr[i13] = a(objArr[i13], true, method.getParameterTypes()[i13]);
            }
        }
        if (method.getReturnType() == Void.TYPE) {
            method.invoke(obj, objArr);
        } else {
            a(method.invoke(obj, objArr));
        }
    }
}
