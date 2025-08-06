package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ax;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static int f51319a = -1;

    public static q a(Context context) {
        if (a(context)) {
            return q.HUAWEI;
        }
        if (c(context)) {
            return q.OPPO;
        }
        if (d(context)) {
            return q.VIVO;
        }
        return q.f51333f;
    }

    public static boolean b(Context context) {
        Class<Integer> cls = Integer.class;
        Object a11 = ax.a(ax.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object a12 = ax.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (a12 == null || !(a12 instanceof Integer)) {
            b.c("google service is not avaliable");
            f51319a = 0;
            return false;
        }
        int intValue = cls.cast(a12).intValue();
        if (a11 != null) {
            if (a11 instanceof Integer) {
                f51319a = cls.cast(a11).intValue() == intValue ? 1 : 0;
            } else {
                f51319a = 0;
                b.c("google service is not avaliable");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("is google service can be used");
        sb2.append(f51319a > 0);
        b.c(sb2.toString());
        if (f51319a > 0) {
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        boolean z11 = false;
        Object a11 = ax.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (a11 != null && (a11 instanceof Boolean)) {
            z11 = Boolean.class.cast(a11).booleanValue();
        }
        b.c("color os push  is avaliable ? :" + z11);
        return z11;
    }

    public static boolean d(Context context) {
        boolean z11 = false;
        Object a11 = ax.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (a11 != null && (a11 instanceof Boolean)) {
            z11 = Boolean.class.cast(a11).booleanValue();
        }
        b.c("fun touch os push  is avaliable ? :" + z11);
        return z11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2362a(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) == null || !a()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        try {
            String str = (String) ax.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            return !TextUtils.isEmpty(str) && Integer.parseInt(str) >= 9;
        } catch (Exception e11) {
            b.a((Throwable) e11);
        }
    }
}
