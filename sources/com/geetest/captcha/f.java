package com.geetest.captcha;

import android.content.Context;
import android.text.TextUtils;

final class f {
    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || "$unknown".equals(str);
    }

    public static long b(Context context, String str) {
        try {
            return context.getSharedPreferences("gt_fp", 0).getLong(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String c(Context context, String str) {
        String a11 = j.a(str.getBytes());
        if (a(a11)) {
            return null;
        }
        a(context, "gt_fp", a11);
        return a11;
    }

    public static String a(Context context, String str) {
        try {
            return context.getSharedPreferences("gt_fp", 0).getString(str, (String) null);
        } catch (Exception unused) {
            return "$unknown";
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("gt_fp", 0).edit().putString(str, str2).apply();
        } catch (Exception unused) {
        }
    }
}
