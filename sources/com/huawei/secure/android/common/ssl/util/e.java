package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

public class e {
    public static String a(String str) {
        return "SecurityComp10200303: " + str;
    }

    public static void b(String str, String str2) {
    }

    public static void c(String str, String str2, Throwable th2) {
        Log.e(a(str), str2, th2);
    }

    public static void d(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void e(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void f(String str, String str2) {
        Log.w(a(str), str2);
    }
}
