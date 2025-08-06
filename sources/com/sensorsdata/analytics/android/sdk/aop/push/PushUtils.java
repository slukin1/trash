package com.sensorsdata.analytics.android.sdk.aop.push;

public class PushUtils {
    public static String getJPushSDKName(byte b11) {
        if (b11 == 1) {
            return "Xiaomi";
        }
        if (b11 == 2) {
            return "HUAWEI";
        }
        if (b11 == 3) {
            return "Meizu";
        }
        if (b11 == 4) {
            return "OPPO";
        }
        if (b11 != 5) {
            return null;
        }
        return "vivo";
    }
}
