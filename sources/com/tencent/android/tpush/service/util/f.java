package com.tencent.android.tpush.service.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f69855a;

    public static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (f.class) {
            if (f69855a == null) {
                f69855a = context.getSharedPreferences(".tpns.vip.service.xml", 0);
            }
            sharedPreferences = f69855a;
        }
        return sharedPreferences;
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(str, str2);
        a(edit);
    }

    public static String a(Context context, String str, String str2) {
        if (!a(context).contains(str)) {
            return str2;
        }
        return a(context).getString(str, str2);
    }

    @SuppressLint({"NewApi"})
    private static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
