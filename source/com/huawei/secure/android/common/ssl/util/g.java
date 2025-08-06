package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f38659a;

    public static long a(String str, long j11, Context context) {
        return c(context).getLong(str, j11);
    }

    public static String b(String str, String str2, Context context) {
        return c(context).getString(str, str2);
    }

    public static synchronized SharedPreferences c(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (g.class) {
            if (f38659a == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    f38659a = context.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
                } else {
                    f38659a = context.getApplicationContext().getSharedPreferences("aegis", 0);
                }
            }
            sharedPreferences = f38659a;
        }
        return sharedPreferences;
    }

    public static void d(String str, long j11, Context context) {
        c(context).edit().putLong(str, j11).apply();
    }

    public static void e(String str, String str2, Context context) {
        c(context).edit().putString(str, str2).apply();
    }
}
