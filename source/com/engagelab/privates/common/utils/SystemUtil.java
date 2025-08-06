package com.engagelab.privates.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

public class SystemUtil {
    private static final String TAG = "SystemUtil";

    public static String getCountry(Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService("country_detector");
            if (systemService == null) {
                return "";
            }
            Object invoke = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]).invoke(systemService, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) invoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(invoke, new Object[0]);
            int intValue = ((Integer) invoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(invoke, new Object[0])).intValue();
            if (intValue == 0 || intValue == 1) {
                return str;
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getSystemProperty(Context context, String str, String str2) {
        Class<String> cls = String.class;
        try {
            return (String) ReflectUtil.invokeStaticMethod(context.getClassLoader().loadClass("android.os.SystemProperties"), "get", new Object[]{str, str2}, new Class[]{cls, cls});
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean isNetworkConnecting(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int isSystemApp(Context context) {
        try {
            String str = context.getApplicationInfo().sourceDir;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.startsWith("/system/app/")) {
                return 1;
            }
            str.startsWith("/data/app/");
            return 0;
        } catch (Throwable unused) {
        }
    }
}
