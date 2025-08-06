package com.huobi.vulcan.utils;

import java.lang.reflect.Field;

public class ReflectUtils {
    public static <T> T a(Class<T> cls, Class<?> cls2, String str, Object obj, boolean z11) {
        try {
            Field declaredField = cls2.getDeclaredField(str);
            if (z11) {
                declaredField.setAccessible(true);
            }
            return declaredField.get(obj);
        } catch (SecurityException e11) {
            LogUtils.b(e11);
            return null;
        } catch (NoSuchFieldException e12) {
            LogUtils.b(e12);
            return null;
        } catch (IllegalArgumentException e13) {
            LogUtils.b(e13);
            return null;
        } catch (IllegalAccessException e14) {
            LogUtils.b(e14);
            return null;
        } catch (Throwable th2) {
            LogUtils.b(th2);
            return null;
        }
    }
}
