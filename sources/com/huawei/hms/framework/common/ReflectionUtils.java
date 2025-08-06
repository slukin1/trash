package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            Logger.w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    private static Class<?> getClass(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Field getField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                final Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField;
            } catch (IllegalArgumentException e11) {
                Logger.e(TAG, "Exception in getField :: IllegalArgumentException:", (Throwable) e11);
            } catch (NoSuchFieldException e12) {
                Logger.e(TAG, "Exception in getField :: NoSuchFieldException:", (Throwable) e12);
            } catch (SecurityException e13) {
                Logger.e(TAG, "not security int method getField,SecurityException:", (Throwable) e13);
            }
        }
        return null;
    }

    public static Object getFieldObj(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Field declaredField = obj.getClass().getDeclaredField(str);
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(obj);
        } catch (IllegalAccessException e11) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", (Throwable) e11);
            return null;
        } catch (IllegalArgumentException e12) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", (Throwable) e12);
            return null;
        } catch (NoSuchFieldException e13) {
            Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", (Throwable) e13);
            return null;
        } catch (SecurityException e14) {
            Logger.e(TAG, "not security int method getFieldObj,SecurityException:", (Throwable) e14);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null || str == null) {
            Logger.w(TAG, "targetClass is  null pr name is null:");
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (SecurityException e11) {
            Logger.e(TAG, "SecurityException:", (Throwable) e11);
            return null;
        } catch (NoSuchMethodException e12) {
            Logger.e(TAG, "NoSuchMethodException:", (Throwable) e12);
            return null;
        }
    }

    public static Object getStaticFieldObj(String str, String str2) {
        Class<?> cls;
        if (str == null || (cls = getClass(str)) == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            final Field declaredField = cls.getDeclaredField(str2);
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(cls);
        } catch (IllegalAccessException e11) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", (Throwable) e11);
            return null;
        } catch (IllegalArgumentException e12) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", (Throwable) e12);
            return null;
        } catch (NoSuchFieldException e13) {
            Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", (Throwable) e13);
            return null;
        } catch (SecurityException e14) {
            Logger.e(TAG, "not security int method getStaticFieldObj,SecurityException:", (Throwable) e14);
            return null;
        }
    }

    private static Object invoke(Object obj, Method method, Object... objArr) throws UnsupportedOperationException {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e11) {
            Logger.e(TAG, "RuntimeException in invoke:", (Throwable) e11);
            return null;
        } catch (Exception e12) {
            Logger.e(TAG, "Exception in invoke:", (Throwable) e12);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i11 = 0; i11 < length; i11++) {
                setClassType(clsArr, objArr[i11], i11);
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke((Object) null, method, objArr);
    }

    private static void setClassType(Class<?>[] clsArr, Object obj, int i11) {
        if (obj instanceof Integer) {
            clsArr[i11] = Integer.TYPE;
        } else if (obj instanceof Long) {
            clsArr[i11] = Long.TYPE;
        } else if (obj instanceof Double) {
            clsArr[i11] = Double.TYPE;
        } else if (obj instanceof Float) {
            clsArr[i11] = Float.TYPE;
        } else if (obj instanceof Boolean) {
            clsArr[i11] = Boolean.TYPE;
        } else if (obj instanceof Character) {
            clsArr[i11] = Character.TYPE;
        } else if (obj instanceof Byte) {
            clsArr[i11] = Byte.TYPE;
        } else if (obj instanceof Void) {
            clsArr[i11] = Void.TYPE;
        } else if (obj instanceof Short) {
            clsArr[i11] = Short.TYPE;
        } else {
            clsArr[i11] = obj.getClass();
        }
    }

    private static void tryLoadClass(String str) throws ClassNotFoundException {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader != null) {
            classLoader.loadClass(str);
            return;
        }
        throw new ClassNotFoundException("not found classloader");
    }

    public static boolean checkCompatible(String str, String str2, Class<?>... clsArr) {
        if (str == null || str2 == null) {
            Logger.w(TAG, "targetClass is  null or name is null:");
            return false;
        }
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            Logger.v(TAG, "has method : " + str2);
            return true;
        } catch (RuntimeException unused) {
            Logger.w(TAG, str + " RuntimeException");
            return false;
        } catch (Exception unused2) {
            Logger.w(TAG, str2 + " NoSuchMethodException");
            return false;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke((Object) null, method, objArr);
    }
}
