package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;

public class e {
    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    public static Intent b(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            HMSLog.w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    public static boolean c(Context context, String str) {
        if (!(context == null || str == null || "".equals(str))) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                HMSLog.d("PushSelfShowLog", str + " is installed");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 11;
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static Boolean a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (queryIntentActivities.get(i11).activityInfo != null && str.equals(queryIntentActivities.get(i11).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", e11.toString(), (Throwable) e11);
        }
        return Boolean.FALSE;
    }

    public static int a() {
        return b() ? 67108864 : 134217728;
    }

    public static boolean a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }
}
