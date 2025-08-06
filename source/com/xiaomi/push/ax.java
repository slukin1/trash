package com.xiaomi.push;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ax {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f51410a;

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f51411a;

        /* renamed from: a  reason: collision with other field name */
        public final T f2545a;
    }

    static {
        HashMap hashMap = new HashMap();
        f51410a = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        Class cls2 = Integer.TYPE;
        hashMap.put(Integer.class, cls2);
        Class cls3 = Float.TYPE;
        hashMap.put(Float.class, cls3);
        Class cls4 = Long.TYPE;
        hashMap.put(Long.class, cls4);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(cls, cls);
        Class cls5 = Byte.TYPE;
        hashMap.put(cls5, cls5);
        Class cls6 = Character.TYPE;
        hashMap.put(cls6, cls6);
        Class cls7 = Short.TYPE;
        hashMap.put(cls7, cls7);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    public static <T> T a(Object obj, String str) {
        try {
            return a((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e11) {
            Log.w("JavaCalls", "Meet exception when call getField '" + str + "' in " + obj + ", " + e11);
            return null;
        }
    }

    public static void b(Object obj, String str, Object obj2) {
        Class cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                continue;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
                continue;
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    public static <T> T a(Class<? extends Object> cls, String str) {
        try {
            return a(cls, (Object) null, str);
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Meet exception when call getStaticField '");
            sb2.append(str);
            sb2.append("' in ");
            sb2.append(cls != null ? cls.getSimpleName() : "");
            sb2.append(", ");
            sb2.append(e11);
            Log.w("JavaCalls", sb2.toString());
            return null;
        }
    }

    public static <T> T a(String str, String str2) {
        try {
            return a((Class<? extends Object>) s.a((Context) null, str), (Object) null, str2);
        } catch (Exception e11) {
            Log.w("JavaCalls", "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e11);
            return null;
        }
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        return a(obj.getClass(), str, (Class<?>[]) a(objArr)).invoke(obj, a(objArr));
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.Class<? extends java.lang.Object> r2, java.lang.Object r3, java.lang.String r4) {
        /*
            r0 = 0
        L_0x0001:
            r1 = 1
            if (r0 != 0) goto L_0x0019
            java.lang.reflect.Field r0 = r2.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x000c }
            r0.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x000c }
            goto L_0x0010
        L_0x000c:
            java.lang.Class r2 = r2.getSuperclass()
        L_0x0010:
            if (r2 == 0) goto L_0x0013
            goto L_0x0001
        L_0x0013:
            java.lang.NoSuchFieldException r2 = new java.lang.NoSuchFieldException
            r2.<init>()
            throw r2
        L_0x0019:
            r0.setAccessible(r1)
            java.lang.Object r2 = r0.get(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ax.a(java.lang.Class, java.lang.Object, java.lang.String):java.lang.Object");
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Exception e11) {
            Log.w("JavaCalls", "Meet exception when call setField '" + str + "' in " + obj + ", " + e11);
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return b(obj, str, objArr);
        } catch (Exception e11) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj + ", " + e11);
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return a(s.a((Context) null, str), str2, objArr);
        } catch (Exception e11) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str + ", " + e11);
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method a11 = a(cls.getDeclaredMethods(), str, clsArr);
        if (a11 != null) {
            a11.setAccessible(true);
            return a11;
        } else if (cls.getSuperclass() != null) {
            return a((Class<?>) cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        Objects.requireNonNull(str, "Method name must not be null.");
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a((Class<?>[]) method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            if (clsArr.length == 0) {
                return true;
            }
            return false;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i11 = 0; i11 < clsArr.length; i11++) {
                if (clsArr2[i11] != null && !clsArr[i11].isAssignableFrom(clsArr2[i11])) {
                    Map<Class<?>, Class<?>> map = f51410a;
                    if (!map.containsKey(clsArr[i11]) || !map.get(clsArr[i11]).equals(map.get(clsArr2[i11]))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        return a(cls, str, (Class<?>[]) a(objArr)).invoke((Object) null, a(objArr));
    }

    private static Class<?>[] a(Object... objArr) {
        Class<?> cls;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            a aVar = objArr[i11];
            if (aVar == null || !(aVar instanceof a)) {
                if (aVar == null) {
                    cls = null;
                } else {
                    cls = aVar.getClass();
                }
                clsArr[i11] = cls;
            } else {
                clsArr[i11] = aVar.f51411a;
            }
        }
        return clsArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static Object[] m2413a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            a aVar = objArr[i11];
            if (aVar == null || !(aVar instanceof a)) {
                objArr2[i11] = aVar;
            } else {
                objArr2[i11] = aVar.f2545a;
            }
        }
        return objArr2;
    }
}
