package com.adjust.sdk.huawei;

import android.content.Context;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;

public class AdjustHuaweiReferrer {
    public static boolean shouldReadHuaweiReferrer = true;

    public static void doNotReadHuaweiReferrer() {
        shouldReadHuaweiReferrer = false;
    }

    public static void getHuaweiAdsInstallReferrer(final Context context, final OnHuaweiInstallReferrerReadListener onHuaweiInstallReferrerReadListener) {
        if (onHuaweiInstallReferrerReadListener == null) {
            AdjustFactory.getLogger().error("onHuaweiInstallReferrerReadListener can not be null", new Object[0]);
            return;
        }
        new AsyncTaskExecutor<Context, HuaweiInstallReferrerResult>() {
            public HuaweiInstallReferrerResult doInBackground(Context[] contextArr) {
                try {
                    return HuaweiReferrerClient.getHuaweiAdsInstallReferrer(context, AdjustFactory.getLogger());
                } catch (Exception e11) {
                    return new HuaweiInstallReferrerResult(e11.getMessage());
                }
            }

            public void onPostExecute(HuaweiInstallReferrerResult huaweiInstallReferrerResult) {
                if (huaweiInstallReferrerResult != null) {
                    HuaweiInstallReferrerDetails huaweiInstallReferrerDetails = huaweiInstallReferrerResult.huaweiInstallReferrerDetails;
                    if (huaweiInstallReferrerDetails != null) {
                        onHuaweiInstallReferrerReadListener.onInstallReferrerDetailsRead(huaweiInstallReferrerDetails);
                        return;
                    }
                    String str = huaweiInstallReferrerResult.error;
                    if (str != null) {
                        onHuaweiInstallReferrerReadListener.onFail(str);
                    } else {
                        onHuaweiInstallReferrerReadListener.onFail("HuaweiReferrer getInstallReferrer: huaweiInstallReferrerDetails is null");
                    }
                } else {
                    onHuaweiInstallReferrerReadListener.onFail("HuaweiReferrer getInstallReferrer: huaweiInstallReferrerResult is null");
                }
            }
        }.execute(context);
    }

    public static void getHuaweiAppGalleryInstallReferrer(final Context context, final OnHuaweiInstallReferrerReadListener onHuaweiInstallReferrerReadListener) {
        if (onHuaweiInstallReferrerReadListener == null) {
            AdjustFactory.getLogger().error("onHuaweiInstallReferrerReadListener can not be null", new Object[0]);
            return;
        }
        new AsyncTaskExecutor<Context, HuaweiInstallReferrerResult>() {
            public HuaweiInstallReferrerResult doInBackground(Context[] contextArr) {
                try {
                    return HuaweiReferrerClient.getHuaweiAppGalleryInstallReferrer(context, AdjustFactory.getLogger());
                } catch (Exception e11) {
                    return new HuaweiInstallReferrerResult(e11.getMessage());
                }
            }

            public void onPostExecute(HuaweiInstallReferrerResult huaweiInstallReferrerResult) {
                if (huaweiInstallReferrerResult != null) {
                    HuaweiInstallReferrerDetails huaweiInstallReferrerDetails = huaweiInstallReferrerResult.huaweiInstallReferrerDetails;
                    if (huaweiInstallReferrerDetails != null) {
                        onHuaweiInstallReferrerReadListener.onInstallReferrerDetailsRead(huaweiInstallReferrerDetails);
                        return;
                    }
                    String str = huaweiInstallReferrerResult.error;
                    if (str != null) {
                        onHuaweiInstallReferrerReadListener.onFail(str);
                    } else {
                        onHuaweiInstallReferrerReadListener.onFail("HuaweiReferrer getInstallReferrer: huaweiInstallReferrerDetails is null");
                    }
                } else {
                    onHuaweiInstallReferrerReadListener.onFail("HuaweiReferrer getInstallReferrer: huaweiInstallReferrerResult is null");
                }
            }
        }.execute(context);
    }

    public static void readHuaweiReferrer(Context context) {
        shouldReadHuaweiReferrer = true;
    }
}
