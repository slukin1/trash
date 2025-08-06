package com.huobi.woodpecker;

import android.content.Context;
import android.text.TextUtils;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.HexUtil;
import com.huobi.woodpecker.utils.MD5Util;
import kv.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f21001a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f21002b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f21003c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f21004d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f21005e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f21006f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f21007g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f21008h = "";

    /* renamed from: i  reason: collision with root package name */
    public static String f21009i = "";

    public static String a() {
        return HexUtil.b(MD5Util.b(vu.b.b(ContextUtil.g()) + System.currentTimeMillis()));
    }

    public static String b() {
        return d.a();
    }

    public static String c() {
        return ContextUtil.f();
    }

    public static String d() {
        return ContextUtil.l();
    }

    public static String e() {
        if (TextUtils.isEmpty(f21007g)) {
            return ContextUtil.d();
        }
        return f21007g;
    }

    public static int f() {
        return f21002b;
    }

    public static long g() {
        return f21001a ? 60000 : 300000;
    }

    public static long h() {
        return 30000;
    }

    public static double i() {
        return 1.0d;
    }

    public static String j() {
        return f21009i;
    }

    public static String k() {
        return f21005e;
    }

    public static String l() {
        return ContextUtil.m();
    }

    public static String m() {
        return f21008h;
    }

    public static String n() {
        return f21006f;
    }

    public static String o() {
        return p(WoodPeckerSDK.f().e());
    }

    public static String p(Context context) {
        if (TextUtils.isEmpty(f21004d) || "00000000000000000000000000000000".equalsIgnoreCase(f21004d)) {
            String b11 = vu.b.b(context);
            f21004d = b11;
            if (TextUtils.isEmpty(b11)) {
                f21004d = "00000000000000000000000000000000";
            }
        }
        return f21004d;
    }

    public static String q() {
        return f21003c;
    }

    public static void r(String str) {
        f21007g = str;
    }

    public static void s(int i11) {
        f21002b = i11;
    }

    public static void t(boolean z11) {
        f21001a = z11;
    }

    public static void u(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < strArr.length; i11++) {
                sb2.append(strArr[i11]);
                if (i11 < strArr.length - 1) {
                    sb2.append(',');
                }
            }
            f21009i = sb2.toString();
        }
    }

    public static void v(String str) {
        f21005e = str;
    }

    public static void w(String str) {
        f21008h = str;
    }

    public static void x(String str) {
        f21006f = str;
        vu.d.k().n();
    }

    public static void y(String str) {
        if (TextUtils.isEmpty(str) || "00000000000000000000000000000000".equalsIgnoreCase(str)) {
            str = vu.b.b(WoodPeckerSDK.f().e());
            if (TextUtils.isEmpty(str)) {
                str = "00000000000000000000000000000000";
            }
        }
        f21004d = str;
    }

    public static void z(String str) {
        f21003c = str;
    }
}
