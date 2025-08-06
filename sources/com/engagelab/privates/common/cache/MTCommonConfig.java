package com.engagelab.privates.common.cache;

import android.content.Context;
import android.content.SharedPreferences;

public class MTCommonConfig {
    private static final String APP_CHANNEL = "app_channel";
    private static final String APP_KEY = "app_key";
    private static final String DEVICE_ID = "device_id";
    private static final String NAME = "com.engagelab.privates.common.prefs";
    private static final String SDK_VERSION_CODE = "sdk_version_code";
    private static final String SDK_VERSION_NAME = "sdk_version_name";
    private static SharedPreferences sharedPreferences;

    public static String getAppChannel(Context context) {
        return getSP(context).getString(APP_CHANNEL, "");
    }

    public static String getAppKey(Context context) {
        return getSP(context).getString(APP_KEY, "");
    }

    public static String getDeviceId(Context context) {
        return getSP(context).getString("device_id", "");
    }

    private static SharedPreferences getSP(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(NAME, 0);
        }
        return sharedPreferences;
    }

    public static int getSdkVersionCode(Context context) {
        return getSP(context).getInt(SDK_VERSION_CODE, 0);
    }

    public static String getSdkVersionName(Context context) {
        return getSP(context).getString(SDK_VERSION_NAME, "");
    }

    public static void setAppChannel(Context context, String str) {
        getSP(context).edit().putString(APP_CHANNEL, str).commit();
    }

    public static void setAppKey(Context context, String str) {
        getSP(context).edit().putString(APP_KEY, str).commit();
    }

    public static void setDeviceId(Context context, String str) {
        getSP(context).edit().putString("device_id", str).commit();
    }

    public static void setSdkVersionCode(Context context, int i11) {
        getSP(context).edit().putInt(SDK_VERSION_CODE, i11).commit();
    }

    public static void setSdkVersionName(Context context, String str) {
        getSP(context).edit().putString(SDK_VERSION_NAME, str).commit();
    }
}
