package com.sensorsdata.analytics.android.advert.utils;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sumsub.sns.internal.core.analytics.d;

public class SAAdvertUtils {
    public static String getAndroidId(Context context) {
        return AbstractSensorsDataAPI.getConfigOptions().isDataCollectEnable() ? SensorsDataUtils.getAndroidID(context) : "";
    }

    public static boolean isFirstTrackInstallation(boolean z11) {
        if (z11) {
            return SAStoreManager.getInstance().getString(DbParams.PersistentName.FIRST_INSTALL_CALLBACK, "true").equals("true");
        }
        return SAStoreManager.getInstance().getString(DbParams.PersistentName.FIRST_INSTALL, "true").equals("true");
    }

    public static void setTrackInstallation(boolean z11) {
        if (z11) {
            SAStoreManager.getInstance().setString(DbParams.PersistentName.FIRST_INSTALL_CALLBACK, d.f31895b);
        }
        SAStoreManager.getInstance().setString(DbParams.PersistentName.FIRST_INSTALL, d.f31895b);
    }
}
