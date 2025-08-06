package com.hbg.lib.common.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.hbg.lib.common.BaseApplication;
import java.util.HashMap;
import java.util.Map;

public class SP {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, SharedPreferences> f67486a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, SharedPreferences.Editor> f67487b = new HashMap();

    public static boolean a(String str) {
        m(str);
        return f67487b.get(str).clear().commit();
    }

    public static boolean b(String str, String str2) {
        m(str);
        return f67486a.get(str).contains(str2);
    }

    public static float c(String str, float f11) {
        return d("_default_", str, f11);
    }

    public static float d(String str, String str2, float f11) {
        m(str);
        return f67486a.get(str).getFloat(str2, f11);
    }

    public static int e(String str, int i11) {
        return f("_default_", str, i11);
    }

    public static int f(String str, String str2, int i11) {
        m(str);
        return f67486a.get(str).getInt(str2, i11);
    }

    public static long g(String str, long j11) {
        return h("_default_", str, j11);
    }

    public static long h(String str, String str2, long j11) {
        m(str);
        return f67486a.get(str).getLong(str2, j11);
    }

    public static String i(String str, String str2) {
        return j("_default_", str, str2);
    }

    public static String j(String str, String str2, String str3) {
        m(str);
        return f67486a.get(str).getString(str2, str3);
    }

    public static boolean k(String str, String str2, boolean z11) {
        m(str);
        return f67486a.get(str).getBoolean(str2, z11);
    }

    public static boolean l(String str, boolean z11) {
        return k("_default_", str, z11);
    }

    public static synchronized void m(String str) {
        synchronized (SP.class) {
            if (f67487b.get(str) == null) {
                if (str.equals("_default_")) {
                    f67486a.put(str, PreferenceManager.getDefaultSharedPreferences(BaseApplication.b()));
                } else {
                    f67486a.put(str, BaseApplication.b().getSharedPreferences(str, 0));
                }
                f67487b.put(str, f67486a.get(str).edit());
            }
        }
    }

    public static boolean n(String str) {
        return o("_default_", str);
    }

    public static boolean o(String str, String str2) {
        m(str);
        return f67487b.get(str).remove(str2).commit();
    }

    public static void p(String str, float f11) {
        t("_default_", str, f11);
    }

    public static void q(String str, int i11) {
        u("_default_", str, i11);
    }

    public static void r(String str, long j11) {
        v("_default_", str, j11);
    }

    public static void s(String str, String str2) {
        w("_default_", str, str2);
    }

    public static void t(String str, String str2, float f11) {
        m(str);
        f67487b.get(str).putFloat(str2, f11).apply();
    }

    public static void u(String str, String str2, int i11) {
        m(str);
        f67487b.get(str).putInt(str2, i11).apply();
    }

    public static void v(String str, String str2, long j11) {
        m(str);
        f67487b.get(str).putLong(str2, j11).apply();
    }

    public static void w(String str, String str2, String str3) {
        m(str);
        f67487b.get(str).putString(str2, str3).apply();
    }

    public static void x(String str, String str2, boolean z11) {
        m(str);
        f67487b.get(str).putBoolean(str2, z11).apply();
    }

    public static void y(String str, boolean z11) {
        x("_default_", str, z11);
    }
}
