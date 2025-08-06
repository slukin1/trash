package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.channel.commonutils.logger.b;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static int f52386a;

    /* renamed from: a  reason: collision with other field name */
    private static long f3264a;

    public static int a(Context context) {
        Bundle bundle;
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f3264a) > Period.DAY_MILLS) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
                    if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                        f52386a = bundle.getInt("SupportForPushVersionCode");
                        f3264a = currentTimeMillis;
                    }
                } catch (Throwable th2) {
                    b.d("exception occurred in getting systemui support version, exception: " + th2);
                }
            }
        }
        return f52386a;
    }

    public static boolean b(Context context) {
        return a(context) >= 3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2920a(Context context) {
        return a(context) >= 2;
    }
}
