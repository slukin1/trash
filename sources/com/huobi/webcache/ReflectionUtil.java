package com.huobi.webcache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReflectionUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f20657a;

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f20658a;

        /* renamed from: b  reason: collision with root package name */
        public final T f20659b;
    }

    static {
        HashMap hashMap = new HashMap();
        f20657a = hashMap;
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

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return b(obj, str, objArr);
        } catch (Throwable th2) {
            throw l(th2);
        }
    }

    public static <T> T b(Object obj, String str, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return e(obj.getClass(), str, h(objArr)).invoke(obj, i(objArr));
    }

    public static boolean c(Class<?>[] clsArr, Class<?>[] clsArr2) {
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
                if (!clsArr[i11].isAssignableFrom(clsArr2[i11])) {
                    Map<Class<?>, Class<?>> map = f20657a;
                    if (!map.containsKey(clsArr[i11]) || !map.get(clsArr[i11]).equals(map.get(clsArr2[i11]))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static Method d(Method[] methodArr, String str, Class<?>[] clsArr) {
        Objects.requireNonNull(str, "Method name must not be null.");
        for (Method method : methodArr) {
            if (method.getName().equals(str) && c(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    public static Method e(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method d11 = d(cls.getDeclaredMethods(), str, clsArr);
        if (d11 != null) {
            d11.setAccessible(true);
            return d11;
        } else if (cls.getSuperclass() != null) {
            return e(cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    public static <T> T f(Object obj, String str) {
        try {
            return g(obj, str);
        } catch (Throwable th2) {
            throw l(th2);
        }
    }

    public static <T> T g(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Class cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
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
        return field.get(obj);
    }

    public static Class<?>[] h(Object... objArr) {
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
                clsArr[i11] = aVar.f20658a;
            }
        }
        return clsArr;
    }

    public static Object[] i(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            a aVar = objArr[i11];
            if (aVar == null || !(aVar instanceof a)) {
                objArr2[i11] = aVar;
            } else {
                objArr2[i11] = aVar.f20659b;
            }
        }
        return objArr2;
    }

    public static void j(Object obj, String str, Object obj2) {
        try {
            k(obj, str, obj2);
        } catch (Throwable th2) {
            throw l(th2);
        }
    }

    public static void k(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
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

    public static RuntimeException l(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            return (RuntimeException) th2;
        }
        return new RuntimeException(th2);
    }
}
