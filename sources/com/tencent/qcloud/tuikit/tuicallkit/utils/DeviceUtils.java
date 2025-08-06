package com.tencent.qcloud.tuikit.tuicallkit.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import java.util.List;

public class DeviceUtils {
    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static boolean isAppRunningForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.importance == 100 && next.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isServiceRunning(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        if (!(context == null || TextUtils.isEmpty(str) || (runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) == null || runningServices.size() == 0)) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (str.equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setScreenLockParams(Window window) {
        if (window != null) {
            if (((PowerManager) window.getContext().getSystemService("power")).isScreenOn()) {
                window.addFlags(4718720);
            } else {
                window.addFlags(6815872);
            }
        }
    }
}
