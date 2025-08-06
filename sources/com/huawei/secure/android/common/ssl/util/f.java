package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38658a = "f";

    public static String a(String str) {
        Context a11 = ContextUtil.a();
        if (a11 == null) {
            return "";
        }
        try {
            return a11.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            String str2 = f38658a;
            e.d(str2, "getVersion NameNotFoundException : " + e11.getMessage());
            return "";
        } catch (Exception e12) {
            String str3 = f38658a;
            e.d(str3, "getVersion: " + e12.getMessage());
            return "";
        } catch (Throwable unused) {
            e.d(f38658a, "throwable");
            return "";
        }
    }
}
