package org.greenrobot.greendao;

import android.util.Log;

public class DaoLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "greenDAO";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static int d(String str) {
        return Log.d(TAG, str);
    }

    public static int e(String str) {
        return Log.w(TAG, str);
    }

    public static String getStackTraceString(Throwable th2) {
        return Log.getStackTraceString(th2);
    }

    public static int i(String str) {
        return Log.i(TAG, str);
    }

    public static boolean isLoggable(int i11) {
        return Log.isLoggable(TAG, i11);
    }

    public static int println(int i11, String str) {
        return Log.println(i11, TAG, str);
    }

    public static int v(String str) {
        return Log.v(TAG, str);
    }

    public static int w(String str) {
        return Log.w(TAG, str);
    }

    public static int d(String str, Throwable th2) {
        return Log.d(TAG, str, th2);
    }

    public static int e(String str, Throwable th2) {
        return Log.e(TAG, str, th2);
    }

    public static int i(String str, Throwable th2) {
        return Log.i(TAG, str, th2);
    }

    public static int v(String str, Throwable th2) {
        return Log.v(TAG, str, th2);
    }

    public static int w(String str, Throwable th2) {
        return Log.w(TAG, str, th2);
    }

    public static int w(Throwable th2) {
        return Log.w(TAG, th2);
    }
}
