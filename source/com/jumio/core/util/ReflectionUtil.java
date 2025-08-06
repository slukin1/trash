package com.jumio.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {
    public static Class<?> getClass(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    return Class.forName(str);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static <T> T getMember(Class<?> cls, String str, Object obj, boolean z11) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        if (z11) {
            declaredField.setAccessible(true);
        }
        return declaredField.get(obj);
    }

    public static Method getMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        boolean z11;
        if (clsArr == null || clsArr.length == 0 || clsArr[0] == null) {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.getName().contains(str)) {
                    return method;
                }
            }
            return null;
        }
        for (Method method2 : obj.getClass().getDeclaredMethods()) {
            if (method2.getName().equals(str)) {
                Class[] parameterTypes = method2.getParameterTypes();
                if (clsArr.length != parameterTypes.length) {
                    continue;
                } else {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= clsArr.length) {
                            z11 = true;
                            break;
                        } else if (!parameterTypes[i11].isAssignableFrom(clsArr[i11])) {
                            z11 = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (z11) {
                        return method2;
                    }
                }
            }
        }
        return obj.getClass().getDeclaredMethod(str, clsArr);
    }

    public static Object getStaticMember(Class<?> cls, String str, boolean z11) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        if (z11) {
            declaredField.setAccessible(true);
        }
        return declaredField.get((Object) null);
    }

    public static boolean hasClass(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    Class.forName(str);
                    return true;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        return false;
    }

    public static <T> T invokeMethodWithArgs(Class<?> cls, String str, Class<?>[] clsArr, Object obj, Object... objArr) {
        Method method;
        try {
            if (clsArr.length == 1) {
                method = cls.getDeclaredMethod(str, new Class[]{clsArr[0]});
            } else {
                method = cls.getDeclaredMethod(str, clsArr);
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T invokeVoidMethod(Class<?> cls, String str, Object obj, Object... objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setStaticMember(Class<?> cls, String str, boolean z11, Object obj) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        if (z11) {
            declaredField.setAccessible(true);
        }
        declaredField.set((Object) null, obj);
    }
}
