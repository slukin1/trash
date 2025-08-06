package com.tencent.thumbplayer.tcmedia.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<a> f49720a = new ArrayList<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49721a;

        /* renamed from: b  reason: collision with root package name */
        public Map<Integer, Method> f49722b;

        private a() {
        }
    }

    @Documented
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        boolean a() default false;

        boolean b() default false;

        boolean c() default false;
    }

    public static Method a(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, Method> b11 = b(cls);
        if (b11 == null) {
            return null;
        }
        for (Map.Entry<Integer, Method> value : b11.entrySet()) {
            Method method = (Method) value.getValue();
            if (method != null && str.equals(method.getName()) && a(method, objArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean a(Class<?> cls) {
        String str;
        Iterator<a> it2 = f49720a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next != null && (str = next.f49721a) != null && str.equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|24|25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(java.lang.Class<?> r9, int r10) {
        /*
            java.lang.Class<com.tencent.thumbplayer.tcmedia.utils.n> r0 = com.tencent.thumbplayer.tcmedia.utils.n.class
            monitor-enter(r0)
            boolean r1 = a(r9)     // Catch:{ all -> 0x004c }
            r2 = 1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x004c }
            r1.<init>()     // Catch:{ all -> 0x004c }
            r3 = 0
            java.lang.reflect.Method[] r4 = r9.getMethods()     // Catch:{ Exception -> 0x0047 }
            int r5 = r4.length     // Catch:{ Exception -> 0x0047 }
            r6 = r3
        L_0x0018:
            if (r6 >= r5) goto L_0x0032
            r7 = r4[r6]     // Catch:{ Exception -> 0x0047 }
            java.lang.Class<com.tencent.thumbplayer.tcmedia.utils.n$b> r8 = com.tencent.thumbplayer.tcmedia.utils.n.b.class
            java.lang.annotation.Annotation r8 = r7.getAnnotation(r8)     // Catch:{ Exception -> 0x0047 }
            com.tencent.thumbplayer.tcmedia.utils.n$b r8 = (com.tencent.thumbplayer.tcmedia.utils.n.b) r8     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x002f
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0047 }
            r1.put(r8, r7)     // Catch:{ Exception -> 0x0047 }
            int r10 = r10 + 1
        L_0x002f:
            int r6 = r6 + 1
            goto L_0x0018
        L_0x0032:
            com.tencent.thumbplayer.tcmedia.utils.n$a r10 = new com.tencent.thumbplayer.tcmedia.utils.n$a     // Catch:{ all -> 0x004c }
            r3 = 0
            r10.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x004c }
            r10.f49721a = r9     // Catch:{ all -> 0x004c }
            r10.f49722b = r1     // Catch:{ all -> 0x004c }
            java.util.ArrayList<com.tencent.thumbplayer.tcmedia.utils.n$a> r9 = f49720a     // Catch:{ all -> 0x004c }
            r9.add(r10)     // Catch:{ all -> 0x004c }
            monitor-exit(r0)
            return r2
        L_0x0047:
            r1.clear()     // Catch:{ all -> 0x004c }
            monitor-exit(r0)
            return r3
        L_0x004c:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.n.a(java.lang.Class, int):boolean");
    }

    private static boolean a(Class<?> cls, Object obj) {
        if (!cls.isPrimitive()) {
            return false;
        }
        try {
            return obj.getClass().getField("TYPE").get((Object) null).equals(cls);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a(Method method, Object[] objArr) {
        Class[] parameterTypes = method.getParameterTypes();
        if (objArr == null || objArr.length == 0) {
            return parameterTypes.length == 0;
        }
        if (parameterTypes.length != objArr.length) {
            return false;
        }
        for (int i11 = 0; i11 < parameterTypes.length; i11++) {
            Class cls = parameterTypes[i11];
            if (objArr[i11] == null) {
                if (cls.isPrimitive()) {
                    return false;
                }
            } else if (!cls.isAssignableFrom(objArr[i11].getClass()) && !a((Class<?>) cls, objArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public static int b(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, Method> b11 = b(cls);
        if (b11 == null) {
            return -1;
        }
        for (Map.Entry next : b11.entrySet()) {
            Method method = (Method) next.getValue();
            if (method != null && str.equals(method.getName()) && a(method, objArr)) {
                return ((Integer) next.getKey()).intValue();
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r1 = r1.get(java.lang.Integer.valueOf(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.Class<?> r1, int r2) {
        /*
            java.util.Map r1 = b(r1)
            java.lang.String r0 = "unknown"
            if (r1 != 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r1 = r1.get(r2)
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            if (r1 == 0) goto L_0x001a
            java.lang.String r1 = r1.getName()
            return r1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.n.b(java.lang.Class, int):java.lang.String");
    }

    private static Map<Integer, Method> b(Class<?> cls) {
        String str;
        Iterator<a> it2 = f49720a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next != null && (str = next.f49721a) != null && str.equals(cls.getName())) {
                return next.f49722b;
            }
        }
        return null;
    }

    public static boolean c(Class<?> cls, int i11) {
        Method method;
        Map<Integer, Method> b11 = b(cls);
        if (!(b11 == null || (method = b11.get(Integer.valueOf(i11))) == null)) {
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes != null && exceptionTypes.length > 0) {
                return true;
            }
            b bVar = (b) method.getAnnotation(b.class);
            if (bVar != null) {
                return bVar.a();
            }
        }
        return false;
    }

    public static boolean d(Class<?> cls, int i11) {
        Method method;
        b bVar;
        Map<Integer, Method> b11 = b(cls);
        if (b11 == null || (method = b11.get(Integer.valueOf(i11))) == null || (bVar = (b) method.getAnnotation(b.class)) == null) {
            return false;
        }
        return bVar.b();
    }

    public static boolean e(Class<?> cls, int i11) {
        Method method;
        b bVar;
        Map<Integer, Method> b11 = b(cls);
        if (b11 == null || (method = b11.get(Integer.valueOf(i11))) == null || (bVar = (b) method.getAnnotation(b.class)) == null) {
            return false;
        }
        return bVar.c();
    }

    public static Method f(Class<?> cls, int i11) {
        Map<Integer, Method> b11 = b(cls);
        if (b11 == null) {
            return null;
        }
        return b11.get(Integer.valueOf(i11));
    }
}
