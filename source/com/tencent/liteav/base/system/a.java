package com.tencent.liteav.base.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.s;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final s<PackageInfo> f21500a = new s<>(b.a());

    public static String a() {
        PackageInfo a11 = f21500a.a();
        if (a11 == null) {
            return "";
        }
        return a11.packageName;
    }

    public static String b() {
        PackageInfo a11;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || (a11 = f21500a.a()) == null) {
            return "";
        }
        return applicationContext.getPackageManager().getApplicationLabel(a11.applicationInfo).toString();
    }

    public static String c() {
        PackageInfo a11 = f21500a.a();
        if (a11 == null) {
            return "";
        }
        return a11.versionName;
    }

    public static /* synthetic */ PackageInfo d() throws Exception {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
    }
}
