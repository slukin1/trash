package kv;

import android.util.Log;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f22885a = false;

    public static String a() {
        return Thread.currentThread().toString() + ":" + Thread.currentThread().getId() + ":\t";
    }

    public static void b(String str) {
        c("ZLog", str);
    }

    public static void c(String str, String str2) {
        if (f22885a) {
            Log.d(str, "\tHBWP:::" + str2);
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        if (f22885a) {
            Log.d(str, "\tHBWP:::" + str2, th2);
        }
    }

    public static void e(String str, String str2) {
        if (f22885a) {
            Log.d(str, "\tHBWP:::" + a() + str2);
        }
    }

    public static void f(String str, String str2) {
        if (f22885a) {
            Log.e(str, "\tHBWP:::" + str2);
        }
    }

    public static void g(String str, String str2, Throwable th2) {
        if (f22885a) {
            Log.e(str, "\tHBWP:::" + str2, th2);
        }
    }

    public static void h(String str, String str2) {
        if (f22885a) {
            Log.e(str, "\tHBWP:::" + a() + str2);
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        if (f22885a) {
            Log.e(str, "\tHBWP:::" + a() + str2, th2);
        }
    }

    public static void j(String str) {
        k("ZLog", str);
    }

    public static void k(String str, String str2) {
        if (f22885a) {
            Log.i(str, "\tHBWP:::" + str2);
        }
    }

    public static boolean l() {
        return f22885a;
    }

    public static void m(String str, String str2) {
        if (f22885a) {
            Log.i(str, "\tHBWP:::" + a() + str2);
        }
    }

    public static void n(boolean z11) {
        f22885a = z11;
    }

    public static void o(String str, String str2) {
        if (f22885a) {
            Log.w(str, "\tHBWP:::" + str2);
        }
    }

    public static void p(String str, String str2, Throwable th2) {
        if (f22885a) {
            Log.w(str, "\tHBWP:::" + str2, th2);
        }
    }
}
