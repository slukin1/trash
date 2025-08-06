package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

public final class am {
    private static String AFInAppEventParameterName;
    private static String values;

    public static void AFKeystoreWrapper(String str) {
        if (AFInAppEventParameterName == null) {
            valueOf(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        }
        String str2 = AFInAppEventParameterName;
        if (str2 != null) {
            AFLogger.AFKeystoreWrapper(str.replace(str2, values));
        }
    }

    public static void valueOf(String str) {
        AFInAppEventParameterName = str;
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (i11 == 0 || i11 == str.length() - 1) {
                sb2.append(str.charAt(i11));
            } else {
                sb2.append("*");
            }
        }
        values = sb2.toString();
    }
}
