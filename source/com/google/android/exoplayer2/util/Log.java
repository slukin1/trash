package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    private Log() {
    }

    @Pure
    private static String appendThrowableString(String str, Throwable th2) {
        String throwableString = getThrowableString(th2);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = throwableString.replace("\n", "\n  ");
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + String.valueOf(replace).length());
        sb2.append(valueOf);
        sb2.append("\n  ");
        sb2.append(replace);
        sb2.append(10);
        return sb2.toString();
    }

    @Pure
    public static void d(String str, String str2) {
        if (logLevel == 0) {
            android.util.Log.d(str, str2);
        }
    }

    @Pure
    public static void e(String str, String str2) {
        if (logLevel <= 3) {
            android.util.Log.e(str, str2);
        }
    }

    @Pure
    public static int getLogLevel() {
        return logLevel;
    }

    @Pure
    public static String getThrowableString(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        if (isCausedByUnknownHostException(th2)) {
            return "UnknownHostException (no network)";
        }
        if (!logStackTraces) {
            return th2.getMessage();
        }
        return android.util.Log.getStackTraceString(th2).trim().replace("\t", "    ");
    }

    @Pure
    public static void i(String str, String str2) {
        if (logLevel <= 1) {
            android.util.Log.i(str, str2);
        }
    }

    @Pure
    private static boolean isCausedByUnknownHostException(Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void setLogLevel(int i11) {
        logLevel = i11;
    }

    public static void setLogStackTraces(boolean z11) {
        logStackTraces = z11;
    }

    @Pure
    public static void w(String str, String str2) {
        if (logLevel <= 2) {
            android.util.Log.w(str, str2);
        }
    }

    @Pure
    public boolean getLogStackTraces() {
        return logStackTraces;
    }

    @Pure
    public static void d(String str, String str2, Throwable th2) {
        d(str, appendThrowableString(str2, th2));
    }

    @Pure
    public static void e(String str, String str2, Throwable th2) {
        e(str, appendThrowableString(str2, th2));
    }

    @Pure
    public static void i(String str, String str2, Throwable th2) {
        i(str, appendThrowableString(str2, th2));
    }

    @Pure
    public static void w(String str, String str2, Throwable th2) {
        w(str, appendThrowableString(str2, th2));
    }
}
