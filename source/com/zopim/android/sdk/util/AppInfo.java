package com.zopim.android.sdk.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.zendesk.logger.Logger;

public class AppInfo {
    private static final String LOG_TAG = "AppInfo";
    private static final String STAGE_DEVELOPMENT = "d";
    private static final String STAGE_PRODUCTION = "p";

    public static String getApplicationName(Context context) {
        if (context == null) {
            Logger.l(LOG_TAG, "Context must not be null. Returning empty string as application name.", new Object[0]);
            return "";
        }
        String str = getChatSdkName() + " user";
        try {
            return context.getString(context.getApplicationInfo().labelRes);
        } catch (Resources.NotFoundException unused) {
            Logger.l(LOG_TAG, "Can not find application name, will return default", new Object[0]);
            return str;
        }
    }

    public static String getApplicationStage(Context context) {
        return StageDetectionUtil.isDebug(context) ? "d" : "p";
    }

    public static String getApplicationVersionName(Context context) {
        if (context == null) {
            Logger.l(LOG_TAG, "Context must not be null. Returning empty string as application version name.", new Object[0]);
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.l(LOG_TAG, "Could not find package name " + context.getPackageName(), new Object[0]);
            e11.printStackTrace();
            return "";
        }
    }

    public static String getChatSdkName() {
        return "Mobile Chat Android";
    }

    public static String getChatSdkVersionName() {
        return "1.4.1";
    }
}
