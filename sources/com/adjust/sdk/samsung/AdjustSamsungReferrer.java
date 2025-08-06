package com.adjust.sdk.samsung;

import android.content.Context;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;

public class AdjustSamsungReferrer {
    public static boolean shouldReadSamsungReferrer = true;

    public static void doNotReadSamsungReferrer() {
        shouldReadSamsungReferrer = false;
    }

    public static void getSamsungInstallReferrer(final Context context, final OnSamsungInstallReferrerReadListener onSamsungInstallReferrerReadListener) {
        if (onSamsungInstallReferrerReadListener == null) {
            AdjustFactory.getLogger().error("onSamsungInstallReferrerReadListener can not be null", new Object[0]);
            return;
        }
        new AsyncTaskExecutor<Context, SamsungInstallReferrerResult>() {
            public SamsungInstallReferrerResult doInBackground(Context[] contextArr) {
                try {
                    return SamsungReferrerClient.getReferrer(context, AdjustFactory.getLogger(), 2000);
                } catch (Exception e11) {
                    return new SamsungInstallReferrerResult(e11.getMessage());
                }
            }

            public void onPostExecute(SamsungInstallReferrerResult samsungInstallReferrerResult) {
                if (samsungInstallReferrerResult != null) {
                    SamsungInstallReferrerDetails samsungInstallReferrerDetails = samsungInstallReferrerResult.samsungInstallReferrerDetails;
                    if (samsungInstallReferrerDetails != null) {
                        onSamsungInstallReferrerReadListener.onSamsungInstallReferrerRead(samsungInstallReferrerDetails);
                        return;
                    }
                    String str = samsungInstallReferrerResult.error;
                    if (str != null) {
                        onSamsungInstallReferrerReadListener.onFail(str);
                    } else {
                        onSamsungInstallReferrerReadListener.onFail("SamsungReferrer getInstallReferrer: samsungInstallReferrerDetails is null");
                    }
                } else {
                    onSamsungInstallReferrerReadListener.onFail("SamsungReferrer getInstallReferrer: samsungInstallReferrerResult is null");
                }
            }
        }.execute(context);
    }

    public static void readSamsungReferrer(Context context) {
        shouldReadSamsungReferrer = true;
    }
}
