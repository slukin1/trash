package com.engagelab.privates.common;

import android.content.Context;
import android.content.SharedPreferences;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f64982a;

    public static String a(Context context) {
        return c(context).getString("platform_token_fail", "");
    }

    public static int b(Context context) {
        return c(context).getInt("platform_token_fail_from", 0);
    }

    public static SharedPreferences c(Context context) {
        if (f64982a == null) {
            f64982a = context.getApplicationContext().getSharedPreferences("com.engagelab.privates.push.prefs.platform", 0);
        }
        return f64982a;
    }

    public static void a(Context context, String str) {
        c(context).edit().putString("platform_token_fail", str).commit();
    }

    public static void a(Context context, int i11) {
        c(context).edit().putInt("platform_token_fail_from", i11).commit();
    }
}
