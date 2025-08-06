package com.huawei.hms.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Objects;

public final class Checker {
    private Checker() {
    }

    public static void assertHandlerThread(Handler handler) {
        assertHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void assertNonEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("Given String is empty or null");
        }
    }

    public static <T> T assertNonNull(T t11) {
        Objects.requireNonNull(t11, "Null reference");
        return t11;
    }

    public static void assertNotUiThread(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void assertUiThread(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static String checkNonEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static <T> T checkNonNull(T t11) {
        Objects.requireNonNull(t11, "Null reference");
        return t11;
    }

    public static int checkNonZero(int i11) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static long checkNotZero(long j11) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    public static void assertHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T assertNonNull(T t11, String str) {
        Objects.requireNonNull(t11, String.valueOf(str));
        return t11;
    }

    public static <T> T checkNonNull(T t11, String str) {
        Objects.requireNonNull(t11, String.valueOf(str));
        return t11;
    }

    public static int checkNonZero(int i11, String str) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException(String.valueOf(str));
    }

    public static long checkNotZero(long j11, String str) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException(String.valueOf(str));
    }

    public static void assertNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException(String.valueOf(str2));
        }
    }

    public static String checkNonEmpty(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2));
    }
}
