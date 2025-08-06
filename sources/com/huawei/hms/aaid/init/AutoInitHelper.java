package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper {
    public static void doAutoInit(Context context) {
        try {
            if (isAutoInitEnabled(context)) {
                HMSLog.i("AutoInit", "Push init start");
                new Thread(new a(context)).start();
            }
        } catch (Exception e11) {
            HMSLog.e("AutoInit", "Push init failed", (Throwable) e11);
        }
    }

    public static boolean isAutoInitEnabled(Context context) {
        i a11 = i.a(context);
        if (a11.containsKey("push_kit_auto_init_enabled")) {
            return a11.getBoolean("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void setAutoInitEnabled(Context context, boolean z11) {
        i a11 = i.a(context);
        boolean z12 = a11.getBoolean("push_kit_auto_init_enabled");
        a11.saveBoolean("push_kit_auto_init_enabled", z11);
        if (z11 && !z12) {
            doAutoInit(context);
        }
    }
}
