package com.alibaba.sdk.android.tbrest.utils;

import android.util.Log;

public class LogUtil {
    public static void a(String str) {
        Log.d("RestApi", str);
    }

    public static void b(String str) {
        Log.e("RestApi", str);
    }

    public static void c(String str, Throwable th2) {
        Log.e("RestApi", str, th2);
    }

    public static void d(String str) {
        Log.i("RestApi", str);
    }

    public static void e(String str, Throwable th2) {
        Log.w("RestApi", str, th2);
    }
}
