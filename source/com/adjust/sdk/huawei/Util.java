package com.adjust.sdk.huawei;

import android.content.Context;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ReferrerDetails;

public class Util {
    public static synchronized ReferrerDetails getHuaweiAdsInstallReferrerDetails(Context context, ILogger iLogger) {
        synchronized (Util.class) {
            if (!AdjustHuaweiReferrer.shouldReadHuaweiReferrer) {
                return null;
            }
            iLogger.info("getHuaweiAdsInstallReferrerDetails invoked", new Object[0]);
            HuaweiInstallReferrerResult huaweiAdsInstallReferrer = HuaweiReferrerClient.getHuaweiAdsInstallReferrer(context, iLogger);
            if (huaweiAdsInstallReferrer == null) {
                return null;
            }
            HuaweiInstallReferrerDetails huaweiInstallReferrerDetails = huaweiAdsInstallReferrer.huaweiInstallReferrerDetails;
            if (huaweiInstallReferrerDetails == null) {
                return null;
            }
            ReferrerDetails referrerDetails = new ReferrerDetails(huaweiInstallReferrerDetails.installReferrer, huaweiInstallReferrerDetails.referrerClickTimestampSeconds, huaweiInstallReferrerDetails.installBeginTimestampSeconds);
            return referrerDetails;
        }
    }

    public static synchronized ReferrerDetails getHuaweiAppGalleryInstallReferrerDetails(Context context, ILogger iLogger) {
        synchronized (Util.class) {
            if (!AdjustHuaweiReferrer.shouldReadHuaweiReferrer) {
                return null;
            }
            iLogger.info("getHuaweiAppGalleryInstallReferrerDetails invoked", new Object[0]);
            HuaweiInstallReferrerResult huaweiAppGalleryInstallReferrer = HuaweiReferrerClient.getHuaweiAppGalleryInstallReferrer(context, iLogger);
            if (huaweiAppGalleryInstallReferrer == null) {
                return null;
            }
            HuaweiInstallReferrerDetails huaweiInstallReferrerDetails = huaweiAppGalleryInstallReferrer.huaweiInstallReferrerDetails;
            if (huaweiInstallReferrerDetails == null) {
                return null;
            }
            ReferrerDetails referrerDetails = new ReferrerDetails(huaweiInstallReferrerDetails.installReferrer, huaweiInstallReferrerDetails.referrerClickTimestampSeconds, huaweiInstallReferrerDetails.installBeginTimestampSeconds);
            return referrerDetails;
        }
    }
}
