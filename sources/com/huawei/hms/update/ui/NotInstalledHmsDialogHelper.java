package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;

public class NotInstalledHmsDialogHelper {
    private static void a(Context context) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
    }

    public static String getAppName(Activity activity) {
        return activity == null ? "" : a(activity, activity.getPackageName());
    }

    public static int getConfirmResId(Activity activity) {
        Checker.checkNonNull(activity, "activity must not be null");
        a(activity);
        return ResourceLoaderUtil.getStringId("hms_confirm");
    }

    public static AlertDialog.Builder getDialogBuilder(Activity activity) {
        Checker.checkNonNull(activity, "activity must not be null");
        a(activity);
        int stringId = ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints");
        String a11 = a(activity, activity.getPackageName());
        return new AlertDialog.Builder(activity, UIUtil.getDialogThemeId(activity)).setMessage(activity.getString(stringId, new Object[]{a11}));
    }

    private static String a(Context context, String str) {
        if (context == null) {
            HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
            if (applicationLabel == null) {
                return "";
            }
            return applicationLabel.toString();
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get app name.");
            return "";
        }
    }
}
