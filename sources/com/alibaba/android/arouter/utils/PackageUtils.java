package com.alibaba.android.arouter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import b2.a;
import com.alibaba.android.arouter.facade.template.ILogger;

public class PackageUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f14084a;

    /* renamed from: b  reason: collision with root package name */
    public static int f14085b;

    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            a.f12290c.error(ILogger.defaultTag, "Get package info error.");
            return null;
        }
    }

    public static boolean b(Context context) {
        PackageInfo a11 = a(context);
        if (a11 != null) {
            String str = a11.versionName;
            int i11 = a11.versionCode;
            SharedPreferences sharedPreferences = context.getSharedPreferences("SP_AROUTER_CACHE", 0);
            if (str.equals(sharedPreferences.getString("LAST_VERSION_NAME", (String) null)) && i11 == sharedPreferences.getInt("LAST_VERSION_CODE", -1)) {
                return false;
            }
            f14084a = str;
            f14085b = i11;
        }
        return true;
    }

    public static void c(Context context) {
        if (!TextUtils.isEmpty(f14084a) && f14085b != 0) {
            context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putString("LAST_VERSION_NAME", f14084a).putInt("LAST_VERSION_CODE", f14085b).apply();
        }
    }
}
