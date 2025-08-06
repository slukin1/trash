package com.huawei.hms.framework.common;

import android.text.TextUtils;

public class SystemPropUtils {
    private static final String TAG = "SystemPropUtils";

    public static String getProperty(String str, String str2, String str3, String str4) {
        Class<String> cls = String.class;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Logger.w(TAG, "reflect class for method has exception.");
            return str4;
        }
        try {
            Class<?> cls2 = Class.forName(str3);
            return (String) cls2.getMethod(str, new Class[]{cls, cls}).invoke(cls2, new Object[]{str2, str4});
        } catch (Exception e11) {
            Logger.e(TAG, "getProperty catch exception: ", (Throwable) e11);
            return str4;
        }
    }
}
