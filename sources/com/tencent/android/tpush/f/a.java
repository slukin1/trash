package com.tencent.android.tpush.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.reflecttools.Reflect;
import com.tencent.tpns.reflecttools.ReflectException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f69327a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f69328b;

    public static boolean a(Context context) {
        if (f69327a == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo.uid <= 1000 || (applicationInfo.flags & 1) != 0) {
                try {
                    Class.forName("com.tencent.tpns.syspush.XGSystemPush");
                    f69327a = Boolean.TRUE;
                    TLogger.ii("SysPush", "Run As SysPush!");
                } catch (Throwable unused) {
                    f69327a = Boolean.FALSE;
                    TLogger.ii("SysPush", "Run in sys app, but not found sys push sdk");
                    return f69327a.booleanValue();
                }
            } else {
                f69327a = Boolean.FALSE;
                TLogger.d("SysPush", "Run in normal app");
            }
        }
        return f69327a.booleanValue();
    }

    public static boolean b(Context context) {
        if (f69328b == null) {
            try {
                for (ProviderInfo next : context.getPackageManager().queryContentProviders((String) null, 0, 0)) {
                    if (next.name.equals("com.tencent.tpns.syspush.XGSystemPushProvider") && next.authority.equals(Constants.XG_SYS_PUSH_AUTH)) {
                        TLogger.d("SysPush", "get sys push content provider");
                        ApplicationInfo applicationInfo = next.applicationInfo;
                        if (context.getPackageName().equals(applicationInfo.packageName)) {
                            f69328b = Boolean.FALSE;
                            TLogger.i("SysPush", "Get isUseXgSysDevice false, beacuse it is itself");
                            return f69328b.booleanValue();
                        } else if (applicationInfo.uid <= 1000 || (applicationInfo.flags & 1) != 0) {
                            f69328b = Boolean.TRUE;
                            TLogger.i("SysPush", "Get isUseXgSysDevice true -> uid:" + applicationInfo.uid + ", applicationInfo.flags:" + applicationInfo.flags);
                            return f69328b.booleanValue();
                        }
                    }
                }
            } catch (Throwable th2) {
                TLogger.w("SysPush", "isUseXgSysDevice Throwable ", th2);
            }
            f69328b = Boolean.FALSE;
        }
        TLogger.i("SysPush", "isUseXgSysDevice: " + f69328b);
        return f69328b.booleanValue();
    }

    public static boolean a(Context context, long j11, String str) {
        try {
            return ((Boolean) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("checkAccessIdAndPackage", context, Long.valueOf(j11), str).get()).booleanValue();
        } catch (ReflectException unused) {
            return false;
        }
    }

    public static String a(Context context, long j11) {
        try {
            return (String) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getAppPackage", context, Long.valueOf(j11)).get();
        } catch (ReflectException unused) {
            return null;
        }
    }

    public static int a() {
        try {
            return ((Integer) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getPushChannelType").get()).intValue();
        } catch (ReflectException unused) {
            return -1;
        }
    }
}
