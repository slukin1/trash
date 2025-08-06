package com.huobi.utils;

import android.text.TextUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.sumsub.sentry.a;

public final class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static String f83721a = (z() + "zh-cn/detail/360000348762");

    /* renamed from: b  reason: collision with root package name */
    public static final String f83722b = (z() + "%s/requests/new?ticket_form_id=114094013272");

    public static void A(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if ("global".equals(str)) {
                ConfigPreferences.m("user_config", "ZENDESK_HUOBI_GLOBAL_DOMAIN", str2);
            } else if (a.f30241h.equals(str)) {
                ConfigPreferences.m("user_config", "ZENDESK_HUOBI_APP_DOMAIN", str2);
            }
        }
    }

    public static String a() {
        return z() + "%s/detail/360000143641";
    }

    public static String b() {
        return v0.c("900001365046");
    }

    public static String c() {
        return z() + "%s/detail/900004083966";
    }

    public static String d() {
        return z() + "{language}/detail/360001403451";
    }

    public static String e() {
        return z() + "%s/detail/900001326406";
    }

    public static String f() {
        return z() + "%s/detail/900004967323";
    }

    public static String g() {
        return z() + "en-us/detail/900002039026";
    }

    public static String h() {
        return z() + "zh-cn/detail/900002039026";
    }

    public static String i() {
        return z() + "%s/detail/900005147823";
    }

    public static String j() {
        return z() + "%s/detail/900000106086";
    }

    public static String k() {
        return z() + "%s/detail/44962565392586";
    }

    public static String l() {
        return z() + "en-us/detail/360000320082";
    }

    public static String m() {
        return z() + "%s/detail/900000312626";
    }

    public static String n() {
        return y() + "%s/detail/900000868826";
    }

    public static String o() {
        return z() + "%s/detail/900000541686";
    }

    public static String p() {
        return y() + "%s/detail/900000927786";
    }

    public static String q() {
        return z() + "%s/detail/900000304326";
    }

    public static String r() {
        return y() + "%s/detail/64935593934668";
    }

    public static String s() {
        return y() + "%s/detail/64935593934668";
    }

    public static String t() {
        return z() + "%s/detail/24930315273813";
    }

    public static String u() {
        return z() + "%s/detail/900000550266";
    }

    public static String v() {
        return z() + "%s/detail/900000541383";
    }

    public static String w() {
        return z() + "%s/detail/900000384186";
    }

    public static String x() {
        return z() + "%s/detail/900000369563";
    }

    public static String y() {
        return z();
    }

    public static String z() {
        return a0.j() + "/support/";
    }
}
