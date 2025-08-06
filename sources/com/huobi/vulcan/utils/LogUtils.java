package com.huobi.vulcan.utils;

import android.util.Log;

public class LogUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f20611a = "mlr";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f20612b = true;

    /* renamed from: c  reason: collision with root package name */
    public static Object f20613c = new Object();

    public static void a(String str) {
        if (!f20612b) {
            return;
        }
        if (str == null || str.length() <= 0) {
            Log.e(f20611a, str);
            return;
        }
        int i11 = 0;
        int length = str.length();
        while (true) {
            int i12 = i11 + 4096;
            if (i12 >= length) {
                Log.e(f20611a, str.substring(i11, length));
                return;
            } else {
                Log.e(f20611a, str.substring(i11, i12));
                i11 = i12;
            }
        }
    }

    public static void b(Throwable th2) {
        if (f20612b) {
            Log.e(f20611a, "", th2);
        }
    }

    public static void c(String str, String str2) {
        d(str, str2, true);
    }

    public static void d(String str, String str2, boolean z11) {
        synchronized (f20613c) {
            FileUtils.j(str + com.jumio.commons.log.LogUtils.NEW_LINE, str2, z11);
        }
    }

    public static void e(String str) {
        if (!f20612b) {
            return;
        }
        if (str == null || str.length() <= 0) {
            Log.w(f20611a, str);
            return;
        }
        int i11 = 0;
        int length = str.length();
        while (true) {
            int i12 = i11 + 4096;
            if (i12 >= length) {
                Log.w(f20611a, str.substring(i11, length));
                return;
            } else {
                Log.w(f20611a, str.substring(i11, i12));
                i11 = i12;
            }
        }
    }
}
