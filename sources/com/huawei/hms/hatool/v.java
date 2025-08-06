package com.huawei.hms.hatool;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private static m0 f38289a = new m0();

    public static void a(int i11) {
        f38289a.a(i11);
    }

    public static void a(String str, String str2) {
        if (a() && str != null && str2 != null) {
            f38289a.b(3, str, str2);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (c() && str != null && str2 != null) {
            f38289a.b(4, str, String.format(str2, objArr));
        }
    }

    private static boolean a() {
        return f38289a.b(3);
    }

    public static void b(String str, String str2) {
        if (b() && str != null && str2 != null) {
            f38289a.b(6, str, str2);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        d(str, String.format(str2, objArr));
    }

    private static boolean b() {
        return f38289a.b(6);
    }

    public static void c(String str, String str2) {
        if (c() && str != null && str2 != null) {
            f38289a.b(4, str, str2);
        }
    }

    private static boolean c() {
        return f38289a.b(4);
    }

    public static void d(String str, String str2) {
        if (str != null && str2 != null) {
            f38289a.b(4, str, str2);
        }
    }

    private static boolean d() {
        return f38289a.b(5);
    }

    public static void e(String str, String str2) {
        if (str != null && str2 != null) {
            f38289a.b(5, str, str2);
        }
    }

    public static void f(String str, String str2) {
        if (d() && str != null && str2 != null) {
            f38289a.b(5, str, str2);
        }
    }
}
