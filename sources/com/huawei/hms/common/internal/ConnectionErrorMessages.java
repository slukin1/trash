package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

public class ConnectionErrorMessages {
    private static boolean a(Context context) {
        return context != null && Util.isAvailableLibExist(context) && AvailableUtil.isInstallerLibExist(context);
    }

    public static String getErrorDialogButtonMessage(Activity activity, int i11) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i11 != 1) {
            if (i11 != 2) {
                return ResourceLoaderUtil.getString("hms_confirm");
            }
            if (a(activity)) {
                return ResourceLoaderUtil.getString("hms_update");
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        } else if (a(activity)) {
            return ResourceLoaderUtil.getString("hms_install");
        } else {
            return ResourceLoaderUtil.getString("hms_confirm");
        }
    }

    public static String getErrorMessage(Activity activity, int i11) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i11 != 1 && i11 != 2) {
            return null;
        }
        if (a(activity)) {
            return ResourceLoaderUtil.getString("hms_update_title");
        }
        return activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), new Object[]{Util.getAppName(activity, activity.getPackageName())});
    }

    public static String getErrorTitle(Activity activity, int i11) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
                }
                if (i11 != 9) {
                    HMSLog.e("HuaweiApiAvailability", "Unexpected error code " + i11);
                    return null;
                }
                HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
                return null;
            } else if (a(activity)) {
                return ResourceLoaderUtil.getString("hms_update_message");
            } else {
                return null;
            }
        } else if (a(activity)) {
            return ResourceLoaderUtil.getString("hms_install_message");
        } else {
            return null;
        }
    }
}
