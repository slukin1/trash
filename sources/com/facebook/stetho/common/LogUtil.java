package com.facebook.stetho.common;

import java.util.Locale;

public class LogUtil {
    private static final String TAG = "stetho";

    public static void d(String str, Object... objArr) {
        d(format(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        e(format(str, objArr));
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        i(format(str, objArr));
    }

    public static boolean isLoggable(int i11) {
        if (i11 == 5 || i11 == 6) {
            return true;
        }
        return LogRedirector.isLoggable(TAG, i11);
    }

    public static void v(String str, Object... objArr) {
        v(format(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        w(format(str, objArr));
    }

    public static void d(Throwable th2, String str, Object... objArr) {
        d(th2, format(str, objArr));
    }

    public static void e(Throwable th2, String str, Object... objArr) {
        e(th2, format(str, objArr));
    }

    public static void i(Throwable th2, String str, Object... objArr) {
        i(th2, format(str, objArr));
    }

    public static void v(Throwable th2, String str, Object... objArr) {
        v(th2, format(str, objArr));
    }

    public static void w(Throwable th2, String str, Object... objArr) {
        w(th2, format(str, objArr));
    }

    public static void d(String str) {
        if (isLoggable(3)) {
            LogRedirector.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (isLoggable(6)) {
            LogRedirector.e(TAG, str);
        }
    }

    public static void i(String str) {
        if (isLoggable(4)) {
            LogRedirector.i(TAG, str);
        }
    }

    public static void v(String str) {
        if (isLoggable(2)) {
            LogRedirector.v(TAG, str);
        }
    }

    public static void w(String str) {
        if (isLoggable(5)) {
            LogRedirector.w(TAG, str);
        }
    }

    public static void d(Throwable th2, String str) {
        if (isLoggable(3)) {
            LogRedirector.d(TAG, str, th2);
        }
    }

    public static void e(Throwable th2, String str) {
        if (isLoggable(6)) {
            LogRedirector.e(TAG, str, th2);
        }
    }

    public static void i(Throwable th2, String str) {
        if (isLoggable(4)) {
            LogRedirector.i(TAG, str, th2);
        }
    }

    public static void v(Throwable th2, String str) {
        if (isLoggable(2)) {
            LogRedirector.v(TAG, str, th2);
        }
    }

    public static void w(Throwable th2, String str) {
        if (isLoggable(5)) {
            LogRedirector.w(TAG, str, th2);
        }
    }
}
