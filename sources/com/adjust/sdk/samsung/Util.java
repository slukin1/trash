package com.adjust.sdk.samsung;

import android.content.Context;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ReferrerDetails;

public class Util {
    public static synchronized ReferrerDetails getSamsungInstallReferrerDetails(Context context, ILogger iLogger) {
        ILogger iLogger2 = iLogger;
        synchronized (Util.class) {
            if (!AdjustSamsungReferrer.shouldReadSamsungReferrer) {
                return null;
            }
            iLogger2.info("getSamsungInstallReferrerDetails invoked", new Object[0]);
            SamsungInstallReferrerResult referrer = SamsungReferrerClient.getReferrer(context, iLogger2, 2000);
            if (referrer == null) {
                return null;
            }
            SamsungInstallReferrerDetails samsungInstallReferrerDetails = referrer.samsungInstallReferrerDetails;
            if (samsungInstallReferrerDetails == null) {
                return null;
            }
            ReferrerDetails referrerDetails = new ReferrerDetails(samsungInstallReferrerDetails.installReferrer, samsungInstallReferrerDetails.referrerClickTimestampSeconds, samsungInstallReferrerDetails.installBeginTimestampSeconds, -1, -1, (String) null, (Boolean) null, (Boolean) null);
            return referrerDetails;
        }
    }
}
