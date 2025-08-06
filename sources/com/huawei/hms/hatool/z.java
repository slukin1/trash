package com.huawei.hms.hatool;

public abstract class z {
    public static String a(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null ? c11.a() : "";
    }

    public static boolean b(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null && c11.e();
    }

    private static j0 c(String str, String str2) {
        s0 a11;
        l1 a12 = s.c().a(str);
        if (a12 == null || (a11 = a12.a(str2)) == null) {
            return null;
        }
        return a11.j();
    }

    public static String d(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null ? c11.b() : "";
    }

    public static boolean e(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null && c11.f();
    }

    public static boolean f(String str, String str2) {
        s0 a11;
        l1 a12 = s.c().a(str);
        if (a12 == null || (a11 = a12.a(str2)) == null) {
            return false;
        }
        return a11.c();
    }

    public static String g(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null ? c11.d() : "";
    }

    public static boolean h(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null && c11.g();
    }

    public static boolean i(String str, String str2) {
        s0 a11;
        l1 a12 = s.c().a(str);
        if (a12 == null || (a11 = a12.a(str2)) == null) {
            return false;
        }
        return a11.e();
    }

    public static String j(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null ? c11.c() : "";
    }

    public static boolean k(String str, String str2) {
        j0 c11 = c(str, str2);
        return c11 != null && c11.h();
    }
}
