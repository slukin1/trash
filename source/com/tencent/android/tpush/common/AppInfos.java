package com.tencent.android.tpush.common;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import com.tencent.android.tpush.logging.TLogger;
import java.util.ArrayList;
import java.util.List;

public class AppInfos {

    /* renamed from: a  reason: collision with root package name */
    private static String f68888a = "";

    /* renamed from: b  reason: collision with root package name */
    private static Context f68889b;

    public static boolean checkApplicationIcon(Context context) {
        try {
            ApplicationInfo appInfo = getAppInfo(context);
            if (appInfo == null) {
                TLogger.ee("AppInfos", "Failed to init due to null ApplicationInfo.");
                return false;
            } else if (appInfo.icon != 0) {
                return true;
            } else {
                TLogger.ee("AppInfos", "Failed to get Application icon in AndroidManifest.xml, You App maybe can not show notification, Please add Application icon in AndroidManifest.xml");
                return false;
            }
        } catch (Throwable th2) {
            TLogger.w("AppInfos", "unexpected for checkApplicationIcon:" + th2.getMessage());
            return false;
        }
    }

    public static boolean forbidPullupService(Context context) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean(Constants.METADATA_XG_SERVICE_PULL_UP_OFF);
        } catch (Throwable th2) {
            TLogger.w("AppInfos", "unexpected for forbidPullupService", th2);
            return false;
        }
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static Context getAppContext() {
        if (f68889b == null) {
            try {
                f68889b = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Throwable th2) {
                TLogger.e("AppInfos", " get ActivityThread currentApplication failed:" + th2);
            }
        }
        if (f68889b == null) {
            TLogger.e("AppInfos", " App context get null! U should init sdk first.");
        }
        return f68889b;
    }

    public static ApplicationInfo getAppInfo(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable th2) {
            TLogger.ee("AppInfos", "Failed to get Application info", th2);
            return null;
        }
    }

    public static String getAppVersion(Context context) {
        if (j.c(f68888a)) {
            return f68888a;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f68888a = str;
            if (str == null || str.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th2) {
            TLogger.ee("AppInfos", "getAppVersion error!", th2);
        }
        return f68888a;
    }

    public static String getApplicationName(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i11 = applicationInfo.labelRes;
            return i11 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i11);
        } catch (Throwable th2) {
            TLogger.e("AppInfos", "", th2);
            return null;
        }
    }

    public static String getCurAppVersion(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable th2) {
            TLogger.e("AppInfos", "get app version error", th2);
            return "";
        }
    }

    public static String getCurrentPackageName(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String getLauncherPackageName(Context context) {
        ActivityInfo activityInfo;
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null || activityInfo.packageName.equals("android")) {
            return null;
        }
        return resolveActivity.activityInfo.packageName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r2 = r2.metaData.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object getMetaData(android.content.Context r2, java.lang.String r3, java.lang.Object r4) {
        /*
            android.content.pm.PackageManager r0 = r2.getPackageManager()
            java.lang.String r2 = r2.getPackageName()
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r0.getApplicationInfo(r2, r1)
            if (r2 == 0) goto L_0x0019
            android.os.Bundle r2 = r2.metaData
            java.lang.Object r2 = r2.get(r3)
            if (r2 == 0) goto L_0x0019
            return r2
        L_0x0019:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.common.AppInfos.getMetaData(android.content.Context, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static List<String> getRunningPkgsByPkgs(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (isAppOnForeground(context, list.get(i11))) {
                arrayList.clear();
                arrayList.add(list.get(i11));
                return arrayList;
            }
            if (isAppRunning(context, list.get(i11))) {
                arrayList.add(list.get(i11));
            }
        }
        return arrayList;
    }

    public static void init(Context context) {
        f68889b = context.getApplicationContext();
    }

    public static boolean isAppOnForeground(Context context) {
        return isAppOnForeground(context, context.getPackageName());
    }

    public static boolean isAppRunning(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppOnForeground(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(str) && next.importance == 100) {
                return true;
            }
        }
        return false;
    }
}
