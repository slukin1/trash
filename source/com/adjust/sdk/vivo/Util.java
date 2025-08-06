package com.adjust.sdk.vivo;

import android.content.Context;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ReferrerDetails;

public class Util {
    public static synchronized ReferrerDetails getVivoInstallReferrerDetails(Context context, ILogger iLogger) {
        synchronized (Util.class) {
            if (!AdjustVivoReferrer.shouldReadVivoReferrer) {
                return null;
            }
            iLogger.info("getVivoInstallReferrerDetails invoked", new Object[0]);
            VivoInstallReferrerDetails vivoInstallReferrerDetails = VivoReferrerClient.getReferrer(context, iLogger).vivoInstallReferrerDetails;
            if (vivoInstallReferrerDetails == null) {
                return null;
            }
            ReferrerDetails referrerDetails = new ReferrerDetails(vivoInstallReferrerDetails.installReferrer, vivoInstallReferrerDetails.referrerClickTimestampSeconds, vivoInstallReferrerDetails.installBeginTimestampSeconds, -1, -1, vivoInstallReferrerDetails.installVersion, (Boolean) null, (Boolean) null);
            return referrerDetails;
        }
    }
}
