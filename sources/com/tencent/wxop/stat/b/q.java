package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class q {

    /* renamed from: db  reason: collision with root package name */
    private static SharedPreferences f51029db;

    private static synchronized SharedPreferences S(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (q.class) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(".mta-wxop", 0);
            f51029db = sharedPreferences2;
            if (sharedPreferences2 == null) {
                f51029db = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f51029db;
        }
        return sharedPreferences;
    }

    public static int a(Context context, String str, int i11) {
        return S(context).getInt(l.e(context, "wxop_" + str), i11);
    }

    public static void a(Context context, String str, long j11) {
        String e11 = l.e(context, "wxop_" + str);
        SharedPreferences.Editor edit = S(context).edit();
        edit.putLong(e11, j11);
        edit.commit();
    }

    public static String b(Context context, String str, String str2) {
        return S(context).getString(l.e(context, "wxop_" + str), str2);
    }

    public static void b(Context context, String str, int i11) {
        String e11 = l.e(context, "wxop_" + str);
        SharedPreferences.Editor edit = S(context).edit();
        edit.putInt(e11, i11);
        edit.commit();
    }

    public static void c(Context context, String str, String str2) {
        String e11 = l.e(context, "wxop_" + str);
        SharedPreferences.Editor edit = S(context).edit();
        edit.putString(e11, str2);
        edit.commit();
    }

    public static long f(Context context, String str) {
        return S(context).getLong(l.e(context, "wxop_" + str), 0);
    }
}
