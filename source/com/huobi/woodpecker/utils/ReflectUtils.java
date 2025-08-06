package com.huobi.woodpecker.utils;

import java.lang.reflect.Field;
import kv.e;

public class ReflectUtils {
    public static <T> T a(Class<T> cls, Class<?> cls2, String str, Object obj, boolean z11) {
        try {
            Field declaredField = cls2.getDeclaredField(str);
            if (z11) {
                declaredField.setAccessible(true);
            }
            return declaredField.get(obj);
        } catch (SecurityException e11) {
            e.p("RefledctUtils", e11.getMessage(), e11);
            return null;
        } catch (NoSuchFieldException e12) {
            e.p("RefledctUtils", e12.getMessage(), e12);
            return null;
        } catch (IllegalArgumentException e13) {
            e.p("RefledctUtils", e13.getMessage(), e13);
            return null;
        } catch (IllegalAccessException e14) {
            e.p("RefledctUtils", e14.getMessage(), e14);
            return null;
        } catch (Throwable th2) {
            e.p("RefledctUtils", th2.getMessage(), th2);
            return null;
        }
    }

    public static <T> T b(Class<T> cls, Class<?> cls2, String str, Object obj, T t11, boolean z11, boolean z12) {
        try {
            Field declaredField = cls2.getDeclaredField(str);
            if (z11) {
                declaredField.setAccessible(true);
            }
            if (z12) {
                Field declaredField2 = Field.class.getDeclaredField("accessFlags");
                declaredField2.setAccessible(true);
                declaredField2.setInt(declaredField, declaredField.getModifiers() & -17);
            }
            declaredField.set(obj, t11);
            return null;
        } catch (SecurityException e11) {
            e.p("RefledctUtils", e11.getMessage(), e11);
            return null;
        } catch (NoSuchFieldException e12) {
            e.p("RefledctUtils", e12.getMessage(), e12);
            return null;
        } catch (IllegalArgumentException e13) {
            e.p("RefledctUtils", e13.getMessage(), e13);
            return null;
        } catch (IllegalAccessException e14) {
            e.p("RefledctUtils", e14.getMessage(), e14);
            return null;
        } catch (Throwable th2) {
            e.p("RefledctUtils", th2.getMessage(), th2);
            return null;
        }
    }
}
