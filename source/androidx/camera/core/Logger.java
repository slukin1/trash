package androidx.camera.core;

import android.os.Build;
import android.util.Log;

public final class Logger {
    public static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    private Logger() {
    }

    public static void d(String str, String str2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 3)) {
            Log.d(truncateTag, str2);
        }
    }

    public static void e(String str, String str2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 6)) {
            Log.e(truncateTag, str2);
        }
    }

    public static int getMinLogLevel() {
        return sMinLogLevel;
    }

    public static void i(String str, String str2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 4)) {
            Log.i(truncateTag, str2);
        }
    }

    public static boolean isDebugEnabled(String str) {
        return isLogLevelEnabled(truncateTag(str), 3);
    }

    public static boolean isErrorEnabled(String str) {
        return isLogLevelEnabled(truncateTag(str), 6);
    }

    public static boolean isInfoEnabled(String str) {
        return isLogLevelEnabled(truncateTag(str), 4);
    }

    private static boolean isLogLevelEnabled(String str, int i11) {
        return sMinLogLevel <= i11 || Log.isLoggable(str, i11);
    }

    public static boolean isWarnEnabled(String str) {
        return isLogLevelEnabled(truncateTag(str), 5);
    }

    public static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    public static void setMinLogLevel(int i11) {
        sMinLogLevel = i11;
    }

    private static String truncateTag(String str) {
        return (Build.VERSION.SDK_INT > 25 || 23 >= str.length()) ? str : str.substring(0, 23);
    }

    public static void w(String str, String str2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 5)) {
            Log.w(truncateTag, str2);
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 3)) {
            Log.d(truncateTag, str2, th2);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 6)) {
            Log.e(truncateTag, str2, th2);
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 4)) {
            Log.i(truncateTag, str2, th2);
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        String truncateTag = truncateTag(str);
        if (isLogLevelEnabled(truncateTag, 5)) {
            Log.w(truncateTag, str2, th2);
        }
    }
}
