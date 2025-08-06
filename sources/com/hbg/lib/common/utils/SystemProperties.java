package com.hbg.lib.common.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class SystemProperties {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f67492a = d(c("android.os.SystemProperties"));

    public static String a(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String b(String str, String str2) {
        Method method = f67492a;
        if (method != null) {
            try {
                return a(f((String) method.invoke((Object) null, new Object[]{str})), str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        return java.lang.ClassLoader.getSystemClassLoader().loadClass(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> c(java.lang.String r1) {
        /*
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0005 }
            return r1
        L_0x0005:
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ ClassNotFoundException -> 0x000e }
            java.lang.Class r1 = r0.loadClass(r1)     // Catch:{ ClassNotFoundException -> 0x000e }
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.SystemProperties.c(java.lang.String):java.lang.Class");
    }

    public static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("get", new Class[]{String.class});
        } catch (Exception unused) {
            return null;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String f(String str) {
        String e11 = e(str);
        if (TextUtils.isEmpty(e11)) {
            return null;
        }
        return e11;
    }
}
