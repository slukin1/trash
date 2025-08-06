package com.tencent.thumbplayer.tcmedia.utils;

import java.lang.reflect.Method;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static Method f49715a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f49716b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f49717c;

    static {
        Class<String> cls = String.class;
        try {
            f49715a = Class.class.getDeclaredMethod("forName", new Class[]{cls});
            f49716b = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{cls, Class[].class});
            f49717c = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{cls});
        } catch (Throwable th2) {
            TPLogUtil.e("TPPrimaryReflectUtil", th2.getMessage());
        }
    }

    public static Object a(Object obj, String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method a11 = a(str, str2, clsArr);
            if (a11 != null) {
                return a11.invoke(obj, objArr);
            }
            return null;
        } catch (Throwable th2) {
            TPLogUtil.e("TPPrimaryReflectUtil", th2.getMessage());
            return null;
        }
    }

    private static Method a(String str, String str2, Class[] clsArr) {
        Method method = null;
        if (!a()) {
            return null;
        }
        try {
            Method method2 = f49716b;
            Object[] objArr = {str2, clsArr};
            Method method3 = (Method) method2.invoke((Class) f49715a.invoke((Object) null, new Object[]{str}), objArr);
            try {
                method3.setAccessible(true);
                return method3;
            } catch (Throwable th2) {
                th = th2;
                method = method3;
                TPLogUtil.e("TPPrimaryReflectUtil", th.getMessage());
                return method;
            }
        } catch (Throwable th3) {
            th = th3;
            TPLogUtil.e("TPPrimaryReflectUtil", th.getMessage());
            return method;
        }
    }

    private static boolean a() {
        return (f49715a == null || f49716b == null || f49717c == null) ? false : true;
    }
}
