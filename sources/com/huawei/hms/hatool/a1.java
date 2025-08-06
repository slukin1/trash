package com.huawei.hms.hatool;

import java.util.Map;

public abstract class a1 {
    public static void a(String str, String str2, long j11) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            h11.a(j11);
        }
    }

    public static boolean a(String str, String str2) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            return h11.a();
        }
        return true;
    }

    public static int b(String str, String str2) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            return h11.d();
        }
        return 7;
    }

    public static boolean c(String str, String str2) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            return h11.g();
        }
        return true;
    }

    public static String d(String str, String str2) {
        s0 h11 = h(str, str2);
        return h11 != null ? h11.f() : "";
    }

    public static boolean e(String str, String str2) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            return h11.i();
        }
        return false;
    }

    public static String f(String str, String str2) {
        s0 h11 = h(str, str2);
        return h11 != null ? h11.h() : "";
    }

    public static String g(String str, String str2) {
        s0 h11 = h(str, str2);
        return h11 != null ? h11.n() : "";
    }

    private static s0 h(String str, String str2) {
        l1 a11 = s.c().a(str);
        if (a11 == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return a11.a(str2);
        }
        s0 a12 = a11.a("oper");
        return a12 == null ? a11.a("maint") : a12;
    }

    public static Map<String, String> i(String str, String str2) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            return h11.k();
        }
        return null;
    }

    public static long j(String str, String str2) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            return h11.l();
        }
        return 0;
    }

    public static int k(String str, String str2) {
        s0 h11 = h(str, str2);
        if (h11 != null) {
            return h11.b();
        }
        return 10;
    }

    public static String l(String str, String str2) {
        s0 h11 = h(str, str2);
        return h11 != null ? h11.o() : "";
    }

    public static String m(String str, String str2) {
        s0 h11 = h(str, str2);
        return h11 != null ? h11.q() : "";
    }

    public static String n(String str, String str2) {
        s0 h11 = h(str, str2);
        return h11 != null ? h11.m() : "";
    }

    public static String o(String str, String str2) {
        s0 h11 = h(str, str2);
        return h11 != null ? h11.p() : "";
    }
}
