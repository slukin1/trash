package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;

public class RCUtils {
    public static int a(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1);
    }

    public static boolean b(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", -1) > 0;
    }

    public static boolean c(Context context) {
        return ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
    }

    public static boolean d(Context context) {
        if (a(context) > 0) {
            return true;
        }
        String[] strArr = {"sys.usb.state", "persist.sys.usb.config", "sys.usb.config", "sys.usb.state"};
        for (int i11 = 0; i11 < 4; i11++) {
            String str = strArr[i11];
            if (DeviceInfoUtils.h(str).contains("adb") || DeviceInfoUtils.i(str).contains("adb")) {
                return true;
            }
        }
        if (TextUtils.isEmpty(DeviceInfoUtils.h("service.adb.tcp.port")) && TextUtils.isEmpty(DeviceInfoUtils.i("service.adb.tcp.port"))) {
            return false;
        }
        return true;
    }
}
