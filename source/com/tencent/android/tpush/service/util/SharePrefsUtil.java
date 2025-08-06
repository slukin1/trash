package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Util;

public class SharePrefsUtil {
    public static final String SHAREPRE_WATCH_PORT = "tpush_watchdog_port";

    /* renamed from: a  reason: collision with root package name */
    public static int f69842a = 100;

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f69843b;

    private static SharedPreferences a(Context context) {
        if (f69843b == null) {
            f69843b = context.getSharedPreferences("tpush.vip.shareprefs", 0);
        }
        return f69843b;
    }

    public static boolean getBoolean(Context context, String str, boolean z11) {
        a(context);
        try {
            return f69843b.getBoolean(a(str), z11);
        } catch (Throwable th2) {
            TLogger.e("SharePrefsUtil", "getBoolean", th2);
            return z11;
        }
    }

    public static int getInt(Context context, String str, int i11) {
        a(context);
        return f69843b.getInt(a(str), i11);
    }

    public static long getLong(Context context, String str, long j11) {
        a(context);
        return f69843b.getLong(a(str), j11);
    }

    public static int getSeqId(Context context) {
        int i11 = f69842a + 1;
        f69842a = i11;
        if (i11 == Integer.MAX_VALUE) {
            f69842a = 1;
        }
        TLogger.i("SharePrefsUtil", "seqId = " + f69842a);
        return f69842a;
    }

    public static String getString(Context context, String str, String str2) {
        a(context);
        return f69843b.getString(a(str), str2);
    }

    public static void setBoolean(Context context, String str, boolean z11) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putBoolean(a(str), z11);
            edit.commit();
        } catch (Throwable th2) {
            TLogger.e("SharePrefsUtil", "", th2);
        }
    }

    public static void setInt(Context context, String str, int i11) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putInt(a(str), i11);
            edit.commit();
        } catch (Throwable th2) {
            TLogger.e("SharePrefsUtil", "", th2);
        }
    }

    public static void setLong(Context context, String str, long j11) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putLong(a(str), j11);
            edit.commit();
        } catch (Throwable th2) {
            TLogger.e("SharePrefsUtil", "", th2);
        }
    }

    public static void setString(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putString(a(str), str2);
            edit.commit();
        } catch (Throwable th2) {
            TLogger.e("SharePrefsUtil", "", th2);
        }
    }

    private static String a(String str) {
        return Util.getKey(str);
    }
}
