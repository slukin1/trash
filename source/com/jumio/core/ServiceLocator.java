package com.jumio.core;

import android.content.Context;
import com.jumio.core.ServiceLocatorInterface;
import java.util.Map;
import jumio.core.d2;
import kotlin.Pair;

public final class ServiceLocator implements ServiceLocatorInterface {
    public static final ServiceLocator INSTANCE = new ServiceLocator();

    /* renamed from: a  reason: collision with root package name */
    public static volatile Context f39027a;

    public static Object a(Class cls) {
        Object obj;
        if (cls == null) {
            return null;
        }
        INSTANCE.getClass();
        try {
            obj = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            obj = null;
        }
        if (obj != null) {
            return obj;
        }
        INSTANCE.getClass();
        try {
            return cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{f39027a});
        } catch (Exception unused2) {
            return null;
        }
    }

    public void bindReflectionClass(String str, String str2, int i11) {
    }

    public <T> void bindServiceClass(Class<T> cls, Class<? extends T> cls2, int i11) {
    }

    public <T> void bindServiceInstance(Class<T> cls, T t11, int i11) {
    }

    public synchronized void destroy() {
        f39027a = null;
    }

    public Map<String, Pair<Integer, Class<?>>> getDefaultClassMappings(ServiceLocatorInterface serviceLocatorInterface) {
        return ServiceLocatorInterface.DefaultImpls.getDefaultClassMappings(this, serviceLocatorInterface);
    }

    public Map<String, Pair<Integer, Object>> getDefaultInstanceMappings(ServiceLocatorInterface serviceLocatorInterface) {
        return ServiceLocatorInterface.DefaultImpls.getDefaultInstanceMappings(this, serviceLocatorInterface);
    }

    public Map<String, Pair<Integer, d2>> getDefaultPluginMappings(ServiceLocatorInterface serviceLocatorInterface) {
        return ServiceLocatorInterface.DefaultImpls.getDefaultPluginMappings(this, serviceLocatorInterface);
    }

    public Map<String, Pair<Integer, String>> getDefaultReflectionMappings(ServiceLocatorInterface serviceLocatorInterface) {
        return ServiceLocatorInterface.DefaultImpls.getDefaultReflectionMappings(this, serviceLocatorInterface);
    }

    public int getPRIORITY_DEFAULT() {
        return ServiceLocatorInterface.DefaultImpls.getPRIORITY_DEFAULT(this);
    }

    public int getPRIORITY_MAX() {
        return ServiceLocatorInterface.DefaultImpls.getPRIORITY_MAX(this);
    }

    public int getPRIORITY_MIDDLE() {
        return ServiceLocatorInterface.DefaultImpls.getPRIORITY_MIDDLE(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ac, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T getServiceImplementation(java.lang.Class<T> r8, d10.a<? extends T> r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r8.isInterface()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00d4
            android.content.Context r0 = f39027a     // Catch:{ all -> 0x00e0 }
            r1 = 0
            if (r0 == 0) goto L_0x00ae
            java.util.Map r0 = r7.getDefaultInstanceMappings(r7)     // Catch:{ all -> 0x00e0 }
            java.util.Map r2 = r7.getDefaultClassMappings(r7)     // Catch:{ all -> 0x00e0 }
            java.util.Map r3 = r7.getDefaultReflectionMappings(r7)     // Catch:{ all -> 0x00e0 }
            java.util.Map r4 = r7.getDefaultPluginMappings(r7)     // Catch:{ all -> 0x00e0 }
            java.lang.String r5 = r8.getName()     // Catch:{ all -> 0x00e0 }
            java.util.Set r6 = r0.keySet()     // Catch:{ all -> 0x00e0 }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x00e0 }
            if (r6 == 0) goto L_0x003f
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x00e0 }
            kotlin.Pair r0 = (kotlin.Pair) r0     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r0.getSecond()     // Catch:{ all -> 0x00e0 }
            goto L_0x0038
        L_0x0037:
            r0 = r1
        L_0x0038:
            if (r0 != 0) goto L_0x003c
            goto L_0x00ae
        L_0x003c:
            r1 = r0
            goto L_0x00ae
        L_0x003f:
            java.util.Set r0 = r2.keySet()     // Catch:{ all -> 0x00e0 }
            boolean r0 = r0.contains(r5)     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x0060
            java.lang.Object r0 = r2.get(r5)     // Catch:{ all -> 0x00e0 }
            kotlin.Pair r0 = (kotlin.Pair) r0     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x0058
            java.lang.Object r0 = r0.getSecond()     // Catch:{ all -> 0x00e0 }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x00e0 }
            goto L_0x0059
        L_0x0058:
            r0 = r1
        L_0x0059:
            java.lang.Object r0 = a(r0)     // Catch:{ all -> 0x00e0 }
            if (r0 != 0) goto L_0x003c
            goto L_0x00ae
        L_0x0060:
            java.util.Set r0 = r3.keySet()     // Catch:{ all -> 0x00e0 }
            boolean r0 = r0.contains(r5)     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = r3.get(r5)     // Catch:{ all -> 0x00e0 }
            kotlin.Pair r0 = (kotlin.Pair) r0     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x0079
            java.lang.Object r0 = r0.getSecond()     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00e0 }
            goto L_0x007a
        L_0x0079:
            r0 = r1
        L_0x007a:
            java.lang.Class r0 = com.jumio.core.util.ReflectionUtil.getClass(r0)     // Catch:{ all -> 0x00e0 }
            java.lang.Object r0 = a(r0)     // Catch:{ all -> 0x00e0 }
            if (r0 != 0) goto L_0x003c
            goto L_0x00ae
        L_0x0085:
            java.util.Set r0 = r4.keySet()     // Catch:{ all -> 0x00e0 }
            boolean r0 = r0.contains(r5)     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00ae
            java.lang.Class<jumio.core.e2> r0 = jumio.core.e2.class
            r2 = 2
            java.lang.Object r0 = com.jumio.core.ServiceLocatorInterface.DefaultImpls.getServiceImplementation$default(r7, r0, r1, r2, r1)     // Catch:{ all -> 0x00e0 }
            jumio.core.e2 r0 = (jumio.core.e2) r0     // Catch:{ all -> 0x00e0 }
            java.lang.Object r2 = r4.get(r5)     // Catch:{ all -> 0x00e0 }
            kotlin.Pair r2 = (kotlin.Pair) r2     // Catch:{ all -> 0x00e0 }
            if (r2 == 0) goto L_0x00ae
            java.lang.Object r2 = r2.getSecond()     // Catch:{ all -> 0x00e0 }
            jumio.core.d2 r2 = (jumio.core.d2) r2     // Catch:{ all -> 0x00e0 }
            if (r2 == 0) goto L_0x00ae
            com.jumio.core.plugins.Plugin r0 = r0.a((jumio.core.d2) r2)     // Catch:{ all -> 0x00e0 }
            if (r0 != 0) goto L_0x003c
        L_0x00ae:
            if (r1 != 0) goto L_0x00d2
            if (r9 == 0) goto L_0x00b7
            java.lang.Object r1 = r9.invoke()     // Catch:{ all -> 0x00e0 }
            goto L_0x00d2
        L_0x00b7:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ all -> 0x00e0 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r0.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r1 = "Cannot locate or create instance of class "
            r0.append(r1)     // Catch:{ all -> 0x00e0 }
            r0.append(r8)     // Catch:{ all -> 0x00e0 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x00e0 }
            r9.<init>(r8)     // Catch:{ all -> 0x00e0 }
            throw r9     // Catch:{ all -> 0x00e0 }
        L_0x00d2:
            monitor-exit(r7)
            return r1
        L_0x00d4:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00e0 }
            java.lang.String r9 = "Provided class is not an interface"
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00e0 }
            r8.<init>(r9)     // Catch:{ all -> 0x00e0 }
            throw r8     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.ServiceLocator.getServiceImplementation(java.lang.Class, d10.a):java.lang.Object");
    }

    public synchronized void init(Context context) {
        if (context.getApplicationContext() != null) {
            f39027a = context.getApplicationContext();
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public boolean unbind(Class<?> cls, int i11) {
        return false;
    }
}
