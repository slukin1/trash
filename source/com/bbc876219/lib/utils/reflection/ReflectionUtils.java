package com.bbc876219.lib.utils.reflection;

import com.bbc876219.lib.zlog.Log;
import i0.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class ReflectionUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Method f63248a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f63249b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f63250c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f63251d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f63252e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f63253f;

    /* renamed from: g  reason: collision with root package name */
    public static Method f63254g;

    /* renamed from: h  reason: collision with root package name */
    public static Method f63255h;

    /* renamed from: i  reason: collision with root package name */
    public static Method f63256i;

    /* renamed from: j  reason: collision with root package name */
    public static Method f63257j;

    /* renamed from: k  reason: collision with root package name */
    public static Map<String, Field> f63258k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public static Map<String, Method> f63259l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public static final b<String, Field> f63260m = new a(30);

    public static class a extends b<String, Field> {
        public a(int i11) {
            super(i11);
        }

        /* renamed from: a */
        public int sizeOf(String str, Field field) {
            return 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "ReflectionUtils.<clinit>"
            java.lang.String r2 = "ReflectionUtils"
            r3 = 1
            r4 = 0
            java.lang.Class<java.lang.Class> r5 = java.lang.Class.class
            java.lang.String r6 = "forName"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0017 }
            r7[r4] = r0     // Catch:{ NoSuchMethodException -> 0x0017 }
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x0017 }
            f63248a = r5     // Catch:{ NoSuchMethodException -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r5 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r5)
        L_0x001b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "static initializer() called forName="
            r5.append(r6)
            java.lang.reflect.Method r6 = f63248a
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r5)
            r5 = 2
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            java.lang.String r7 = "getDeclaredMethod"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x0046 }
            r8[r4] = r0     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.Class<java.lang.Class[]> r9 = java.lang.Class[].class
            r8[r3] = r9     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0046 }
            f63249b = r6     // Catch:{ NoSuchMethodException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r6 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r6)
        L_0x004a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "static initializer() called getDeclaredMethod="
            r6.append(r7)
            java.lang.reflect.Method r7 = f63249b
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r6)
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            java.lang.String r7 = "getDeclaredMethods"
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x006e }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x006e }
            f63253f = r6     // Catch:{ NoSuchMethodException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r6 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r6)
        L_0x0072:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "static initializer() called getDeclaredMethods="
            r6.append(r7)
            java.lang.reflect.Method r7 = f63253f
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r6)
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            java.lang.String r7 = "getMethod"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x009c }
            r8[r4] = r0     // Catch:{ NoSuchMethodException -> 0x009c }
            java.lang.Class<java.lang.Class[]> r9 = java.lang.Class[].class
            r8[r3] = r9     // Catch:{ NoSuchMethodException -> 0x009c }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x009c }
            f63250c = r6     // Catch:{ NoSuchMethodException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r6 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r6)
        L_0x00a0:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "static initializer() called getMethod="
            r6.append(r7)
            java.lang.reflect.Method r7 = f63250c
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r6)
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            java.lang.String r7 = "getDeclaredField"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x00c6 }
            r8[r4] = r0     // Catch:{ NoSuchMethodException -> 0x00c6 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x00c6 }
            f63251d = r6     // Catch:{ NoSuchMethodException -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r6 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r6)
        L_0x00ca:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "static initializer() called getDeclaredField="
            r6.append(r7)
            java.lang.reflect.Method r7 = f63251d
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r6)
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            java.lang.String r7 = "getDeclaredFields"
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x00ee }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x00ee }
            f63252e = r6     // Catch:{ NoSuchMethodException -> 0x00ee }
            goto L_0x00f2
        L_0x00ee:
            r6 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r6)
        L_0x00f2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "static initializer() called getDeclaredFields="
            r6.append(r7)
            java.lang.reflect.Method r7 = f63252e
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r6)
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            java.lang.String r7 = "getField"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0118 }
            r8[r4] = r0     // Catch:{ NoSuchMethodException -> 0x0118 }
            java.lang.reflect.Method r0 = r6.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0118 }
            f63254g = r0     // Catch:{ NoSuchMethodException -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r0 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r0)
        L_0x011c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "static initializer() called getField="
            r0.append(r6)
            java.lang.reflect.Method r6 = f63254g
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r0)
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            java.lang.String r6 = "getDeclaredConstructor"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0144 }
            java.lang.Class<java.lang.Class[]> r8 = java.lang.Class[].class
            r7[r4] = r8     // Catch:{ NoSuchMethodException -> 0x0144 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x0144 }
            f63257j = r0     // Catch:{ NoSuchMethodException -> 0x0144 }
            goto L_0x0148
        L_0x0144:
            r0 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r0)
        L_0x0148:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "static initializer() called getDeclaredConstructor="
            r0.append(r6)
            java.lang.reflect.Method r6 = f63257j
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r0)
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            java.lang.String r6 = "getConstructor"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0170 }
            java.lang.Class<java.lang.Class[]> r8 = java.lang.Class[].class
            r7[r4] = r8     // Catch:{ NoSuchMethodException -> 0x0170 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x0170 }
            f63255h = r0     // Catch:{ NoSuchMethodException -> 0x0170 }
            goto L_0x0174
        L_0x0170:
            r0 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r0)
        L_0x0174:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "static initializer() called getConstructor="
            r0.append(r6)
            java.lang.reflect.Method r6 = f63255h
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r0)
            java.lang.Class<java.lang.reflect.Constructor> r0 = java.lang.reflect.Constructor.class
            java.lang.String r6 = "newInstance"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x019c }
            java.lang.Class<java.lang.Object[]> r8 = java.lang.Object[].class
            r7[r4] = r8     // Catch:{ NoSuchMethodException -> 0x019c }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x019c }
            f63256i = r0     // Catch:{ NoSuchMethodException -> 0x019c }
            goto L_0x01a0
        L_0x019c:
            r0 = move-exception
            com.bbc876219.lib.zlog.Log.d(r2, r1, r0)
        L_0x01a0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "static initializer() called newInstance="
            r0.append(r1)
            java.lang.reflect.Method r1 = f63256i
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bbc876219.lib.zlog.Log.c(r2, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 27
            if (r0 <= r1) goto L_0x023c
            java.lang.reflect.Method r0 = f63248a     // Catch:{ all -> 0x0236 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x0236 }
            java.lang.String r6 = "dalvik.system.VMRuntime"
            r1[r4] = r6     // Catch:{ all -> 0x0236 }
            r6 = 0
            java.lang.Object r0 = r0.invoke(r6, r1)     // Catch:{ all -> 0x0236 }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x0236 }
            java.lang.reflect.Method r1 = f63249b     // Catch:{ all -> 0x0236 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x0236 }
            java.lang.String r8 = "getRuntime"
            r7[r4] = r8     // Catch:{ all -> 0x0236 }
            r7[r3] = r6     // Catch:{ all -> 0x0236 }
            java.lang.Object r1 = r1.invoke(r0, r7)     // Catch:{ all -> 0x0236 }
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch:{ all -> 0x0236 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0236 }
            r7.<init>()     // Catch:{ all -> 0x0236 }
            java.lang.String r8 = "ReflectionUtils<clinit>: getRuntime = "
            r7.append(r8)     // Catch:{ all -> 0x0236 }
            java.lang.String r8 = r1.getName()     // Catch:{ all -> 0x0236 }
            r7.append(r8)     // Catch:{ all -> 0x0236 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0236 }
            com.bbc876219.lib.zlog.Log.c(r2, r7)     // Catch:{ all -> 0x0236 }
            java.lang.reflect.Method r7 = f63249b     // Catch:{ all -> 0x0236 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0236 }
            java.lang.String r8 = "setHiddenApiExemptions"
            r5[r4] = r8     // Catch:{ all -> 0x0236 }
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ all -> 0x0236 }
            java.lang.Class<java.lang.String[]> r9 = java.lang.String[].class
            r8[r4] = r9     // Catch:{ all -> 0x0236 }
            r5[r3] = r8     // Catch:{ all -> 0x0236 }
            java.lang.Object r0 = r7.invoke(r0, r5)     // Catch:{ all -> 0x0236 }
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch:{ all -> 0x0236 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0236 }
            r5.<init>()     // Catch:{ all -> 0x0236 }
            java.lang.String r7 = "ReflectionUtils<clinit>: setHiddenApiExemptions"
            r5.append(r7)     // Catch:{ all -> 0x0236 }
            java.lang.String r7 = r0.getName()     // Catch:{ all -> 0x0236 }
            r5.append(r7)     // Catch:{ all -> 0x0236 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0236 }
            com.bbc876219.lib.zlog.Log.c(r2, r5)     // Catch:{ all -> 0x0236 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0236 }
            java.lang.Object r1 = r1.invoke(r6, r5)     // Catch:{ all -> 0x0236 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0236 }
            java.lang.String r5 = "L"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ all -> 0x0236 }
            r3[r4] = r5     // Catch:{ all -> 0x0236 }
            r0.invoke(r1, r3)     // Catch:{ all -> 0x0236 }
            goto L_0x023c
        L_0x0236:
            r0 = move-exception
            java.lang.String r1 = "ReflectionUtils<clinit>: "
            com.bbc876219.lib.zlog.Log.d(r2, r1, r0)
        L_0x023c:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            f63258k = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            f63259l = r0
            com.bbc876219.lib.utils.reflection.ReflectionUtils$a r0 = new com.bbc876219.lib.utils.reflection.ReflectionUtils$a
            r1 = 30
            r0.<init>(r1)
            f63260m = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbc876219.lib.utils.reflection.ReflectionUtils.<clinit>():void");
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e11) {
            Log.d("ReflectionUtils", "get " + str + " Class", e11);
            return null;
        }
    }

    public static Class<?> b(String str) {
        try {
            return (Class) f63248a.invoke((Object) null, new Object[]{str});
        } catch (Exception e11) {
            Log.d("ReflectionUtils", "get " + str + " Class", e11);
            return null;
        }
    }

    public static <T> T c(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field field;
        Class<?> cls = obj.getClass();
        String e11 = e(obj, str);
        b<String, Field> bVar = f63260m;
        synchronized (bVar) {
            field = bVar.get(e11);
        }
        if (field == null) {
            while (field == null) {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            }
            field.setAccessible(true);
            f63260m.put(e11, field);
        }
        return field.get(obj);
    }

    public static String d(Class cls, String str) {
        return String.format("%s_%s", new Object[]{cls.getCanonicalName(), str});
    }

    public static String e(Object obj, String str) {
        return d(obj.getClass(), str);
    }

    public static <T> T f(Class<?> cls, String str) throws NoSuchFieldException, IllegalAccessException {
        Field field;
        String d11 = d(cls, str);
        b<String, Field> bVar = f63260m;
        synchronized (bVar) {
            field = bVar.get(d11);
        }
        while (field == null) {
            field = cls.getDeclaredField(str);
            if (field != null) {
                field.setAccessible(true);
                f63260m.put(d11, field);
            } else {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return field.get((Object) null);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T g(java.lang.Class<?> r5, java.lang.String r6) throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
        /*
            java.lang.String r0 = d(r5, r6)
            i0.b<java.lang.String, java.lang.reflect.Field> r1 = f63260m
            monitor-enter(r1)
            java.lang.Object r0 = r1.get(r0)     // Catch:{ all -> 0x003a }
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch:{ all -> 0x003a }
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
        L_0x000e:
            r1 = 1
            if (r0 != 0) goto L_0x0031
            java.lang.reflect.Method r2 = f63251d     // Catch:{ InvocationTargetException -> 0x0024 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ InvocationTargetException -> 0x0024 }
            r4 = 0
            r3[r4] = r6     // Catch:{ InvocationTargetException -> 0x0024 }
            java.lang.Object r2 = r2.invoke(r5, r3)     // Catch:{ InvocationTargetException -> 0x0024 }
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2     // Catch:{ InvocationTargetException -> 0x0024 }
            r2.setAccessible(r1)     // Catch:{ InvocationTargetException -> 0x0023 }
            r0 = r2
            goto L_0x0028
        L_0x0023:
            r0 = r2
        L_0x0024:
            java.lang.Class r5 = r5.getSuperclass()
        L_0x0028:
            if (r5 == 0) goto L_0x002b
            goto L_0x000e
        L_0x002b:
            java.lang.NoSuchFieldException r5 = new java.lang.NoSuchFieldException
            r5.<init>()
            throw r5
        L_0x0031:
            r0.setAccessible(r1)
            r5 = 0
            java.lang.Object r5 = r0.get(r5)
            return r5
        L_0x003a:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbc876219.lib.utils.reflection.ReflectionUtils.g(java.lang.Class, java.lang.String):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.reflect.Method} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object h(java.lang.Class<?> r4, java.lang.Object r5, java.lang.String r6, java.lang.Class[] r7, java.lang.Object[] r8, java.lang.Object r9) {
        /*
            if (r5 != 0) goto L_0x0003
            goto L_0x0007
        L_0x0003:
            java.lang.Class r4 = r5.getClass()     // Catch:{ Exception -> 0x0057 }
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r1 = r4.getName()     // Catch:{ Exception -> 0x0057 }
            r0.append(r1)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r1 = "#"
            r0.append(r1)     // Catch:{ Exception -> 0x0057 }
            r0.append(r6)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0057 }
            java.util.Map<java.lang.String, java.lang.reflect.Method> r1 = f63259l     // Catch:{ Exception -> 0x0057 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x0057 }
            java.util.Map<java.lang.String, java.lang.reflect.Method> r2 = f63259l     // Catch:{ all -> 0x0054 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0054 }
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2     // Catch:{ all -> 0x0054 }
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            if (r2 != 0) goto L_0x004f
            java.lang.reflect.Method r1 = f63249b     // Catch:{ Exception -> 0x0057 }
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0057 }
            r3 = 0
            r2[r3] = r6     // Catch:{ Exception -> 0x0057 }
            r6 = 1
            r2[r6] = r7     // Catch:{ Exception -> 0x0057 }
            java.lang.Object r4 = r1.invoke(r4, r2)     // Catch:{ Exception -> 0x0057 }
            r2 = r4
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2     // Catch:{ Exception -> 0x0057 }
            r2.setAccessible(r6)     // Catch:{ Exception -> 0x0057 }
            java.util.Map<java.lang.String, java.lang.reflect.Method> r4 = f63259l     // Catch:{ Exception -> 0x0057 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x0057 }
            java.util.Map<java.lang.String, java.lang.reflect.Method> r6 = f63259l     // Catch:{ all -> 0x004c }
            r6.put(r0, r2)     // Catch:{ all -> 0x004c }
            monitor-exit(r4)     // Catch:{ all -> 0x004c }
            goto L_0x004f
        L_0x004c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004c }
            throw r5     // Catch:{ Exception -> 0x0057 }
        L_0x004f:
            java.lang.Object r4 = r2.invoke(r5, r8)     // Catch:{ Exception -> 0x0057 }
            return r4
        L_0x0054:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbc876219.lib.utils.reflection.ReflectionUtils.h(java.lang.Class, java.lang.Object, java.lang.String, java.lang.Class[], java.lang.Object[], java.lang.Object):java.lang.Object");
    }
}
