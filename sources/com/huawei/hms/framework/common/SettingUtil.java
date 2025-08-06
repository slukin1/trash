package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String str, int i11) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i11);
        } catch (RuntimeException e11) {
            Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", (Throwable) e11);
            return i11;
        }
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i11) {
        try {
            return Settings.System.getInt(contentResolver, str, i11);
        } catch (RuntimeException e11) {
            Logger.e(TAG, "Settings System getInt throwFromSystemServer:", (Throwable) e11);
            return i11;
        }
    }
}
