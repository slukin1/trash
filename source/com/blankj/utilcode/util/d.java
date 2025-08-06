package com.blankj.utilcode.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Objects;

public final class d {
    public static int a() {
        return b(Utils.a().getPackageName());
    }

    public static int b(String str) {
        if (a0.C(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public static String c() {
        String d11 = d(Utils.a().getPackageName());
        Objects.requireNonNull(d11, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppVersionName() marked by @androidx.annotation.NonNull");
        return d11;
    }

    public static String d(String str) {
        String str2;
        if (a0.C(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                str2 = "";
            } else {
                str2 = packageInfo.versionName;
            }
            if (str2 != null) {
                return str2;
            }
            throw new NullPointerException("Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppVersionName() marked by @androidx.annotation.NonNull");
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
