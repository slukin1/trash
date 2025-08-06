package com.hbg.lib.network.retrofit.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Context f70668a;

    public static int a(String str, int i11) {
        return b("sp_name_network", str, i11);
    }

    public static int b(String str, String str2, int i11) {
        return i(str).getInt(str2, i11);
    }

    public static long c(String str, String str2, long j11) {
        return i(str).getLong(str2, j11);
    }

    public static String d(String str, String str2) {
        return e("sp_name_network", str, str2);
    }

    public static String e(String str, String str2, String str3) {
        return i(str).getString(str2, str3);
    }

    public static boolean f(String str, String str2, boolean z11) {
        return i(str).getBoolean(str2, z11);
    }

    public static boolean g(String str, boolean z11) {
        return f("sp_name_network", str, z11);
    }

    public static Context h() {
        return f70668a;
    }

    public static SharedPreferences i(String str) {
        return f70668a.getSharedPreferences(str, 0);
    }

    public static boolean j() {
        return i("sp_name_network").getBoolean("is_union_pattern", false);
    }

    public static void k(Context context) {
        if (f70668a == null) {
            f70668a = context.getApplicationContext();
        }
    }

    public static void l(String str, int i11) {
        n("sp_name_network", str, i11);
    }

    public static void m(String str, String str2) {
        p("sp_name_network", str, str2);
    }

    public static void n(String str, String str2, int i11) {
        SharedPreferences.Editor edit = i(str).edit();
        edit.putInt(str2, i11);
        edit.apply();
    }

    public static void o(String str, String str2, long j11) {
        SharedPreferences.Editor edit = i(str).edit();
        edit.putLong(str2, j11);
        edit.apply();
    }

    public static void p(String str, String str2, String str3) {
        SharedPreferences.Editor edit = i(str).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static void q(String str, String str2, boolean z11) {
        SharedPreferences.Editor edit = i(str).edit();
        edit.putBoolean(str2, z11);
        edit.apply();
    }

    public static void r(String str, boolean z11) {
        q("sp_name_network", str, z11);
    }

    public static boolean s(boolean z11) {
        if (z11 == j()) {
            return false;
        }
        SharedPreferences.Editor edit = i("sp_name_network").edit();
        edit.putBoolean("is_union_pattern", z11);
        edit.apply();
        return true;
    }
}
