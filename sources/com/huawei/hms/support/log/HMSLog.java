package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AndroidException;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.b;
import com.huawei.hms.base.log.d;

public class HMSLog {

    /* renamed from: a  reason: collision with root package name */
    private static final b f38533a = new b();

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (AndroidException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        f38533a.a(3, str, str2);
    }

    public static void e(String str, String str2) {
        f38533a.a(6, str, str2);
    }

    public static void i(String str, String str2) {
        f38533a.a(4, str, str2);
    }

    public static void init(Context context, int i11, String str) {
        b bVar = f38533a;
        bVar.a(context, i11, str);
        bVar.a(str, "============================================================================" + 10 + "====== " + a(context) + 10 + "============================================================================");
    }

    public static boolean isErrorEnable() {
        return f38533a.a(6);
    }

    public static boolean isInfoEnable() {
        return f38533a.a(4);
    }

    public static boolean isWarnEnable() {
        return f38533a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z11) throws IllegalArgumentException {
        if (hMSExtLogger != null) {
            a aVar = new a(hMSExtLogger);
            if (z11) {
                f38533a.a((d) aVar);
            } else {
                f38533a.a().a(aVar);
            }
        } else {
            throw new IllegalArgumentException("extLogger is not able to be null");
        }
    }

    public static void w(String str, String str2) {
        f38533a.a(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th2) {
        f38533a.b(6, str, str2, th2);
    }

    public static void e(String str, long j11, String str2) {
        b bVar = f38533a;
        bVar.a(6, str, "[" + j11 + "] " + str2);
    }

    public static void e(String str, long j11, String str2, Throwable th2) {
        b bVar = f38533a;
        bVar.b(6, str, "[" + j11 + "] " + str2, th2);
    }
}
