package com.tencent.liteav.base;

import java.util.Locale;

public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";
    private static final boolean useChromiumLog = true;

    private Log() {
    }

    public static void d(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(3, str, formatLogWithStack(str2, getThrowableToLog(objArr), objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(6, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    private static String formatLog(String str, Throwable th2, Object... objArr) {
        if (objArr != null) {
            return ((th2 != null || objArr.length <= 0) && objArr.length <= 1) ? str : String.format(Locale.US, str, objArr);
        }
        return str;
    }

    private static String formatLogWithStack(String str, Throwable th2, Object... objArr) {
        return "[" + getCallOrigin() + "] " + formatLog(str, th2, objArr);
    }

    private static String getCallOrigin() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i11 = 0;
        while (true) {
            if (i11 >= stackTrace.length) {
                break;
            } else if (stackTrace[i11].getClassName().equals(name)) {
                i11 += 3;
                break;
            } else {
                i11++;
            }
        }
        return stackTrace[i11].getFileName() + ":" + stackTrace[i11].getLineNumber();
    }

    public static String getStackTraceString(Throwable th2) {
        return android.util.Log.getStackTraceString(th2);
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Throwable th2 = objArr[objArr.length - 1];
        if (!(th2 instanceof Throwable)) {
            return null;
        }
        return th2;
    }

    public static void i(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(4, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    private static boolean isDebug() {
        return true;
    }

    public static boolean isLoggable(String str, int i11) {
        if (isDebug() || i11 > 4) {
            return android.util.Log.isLoggable(str, i11);
        }
        return false;
    }

    private static native void nativeWriteLogToNative(int i11, String str, String str2);

    public static String normalizeTag(String str) {
        if (str.startsWith(sTagPrefix)) {
            return str;
        }
        int i11 = 0;
        if (str.startsWith(sDeprecatedTagPrefix)) {
            i11 = 3;
        }
        return sTagPrefix + str.substring(i11, str.length());
    }

    public static void v(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(2, str, formatLogWithStack(str2, getThrowableToLog(objArr), objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(5, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    public static void wtf(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(7, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }
}
