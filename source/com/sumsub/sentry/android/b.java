package com.sumsub.sentry.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.sumsub.sns.internal.log.a;
import com.sumsub.sns.internal.log.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f30260a = new b();

    public final PackageInfo a(Context context) {
        return a(context, 0);
    }

    public final String b(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT < 31) {
            return String.valueOf(packageInfo.versionCode);
        }
        return String.valueOf(packageInfo.getLongVersionCode());
    }

    public final String c(PackageInfo packageInfo) {
        return packageInfo.versionName;
    }

    public final PackageInfo a(Context context, int i11) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i11);
        } catch (Throwable th2) {
            a.f34862a.e(c.a(this), "Error getting package info.", th2);
            return null;
        }
    }

    public final String a(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return b(packageInfo);
    }
}
