package com.adjust.sdk.vivo;

import android.content.Context;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;

public class AdjustVivoReferrer {
    public static boolean shouldReadVivoReferrer = true;

    public static void doNotReadVivoReferrer() {
        shouldReadVivoReferrer = false;
    }

    public static void getVivoInstallReferrer(final Context context, final OnVivoInstallReferrerReadListener onVivoInstallReferrerReadListener) {
        if (onVivoInstallReferrerReadListener == null) {
            AdjustFactory.getLogger().error("onVivoInstallReferrerReadListener can not be null", new Object[0]);
            return;
        }
        new AsyncTaskExecutor<Context, VivoInstallReferrerResult>() {
            public VivoInstallReferrerResult doInBackground(Context[] contextArr) {
                try {
                    return VivoReferrerClient.getReferrer(context, AdjustFactory.getLogger());
                } catch (Exception e11) {
                    return new VivoInstallReferrerResult(e11.getMessage());
                }
            }

            public void onPostExecute(VivoInstallReferrerResult vivoInstallReferrerResult) {
                if (vivoInstallReferrerResult != null) {
                    VivoInstallReferrerDetails vivoInstallReferrerDetails = vivoInstallReferrerResult.vivoInstallReferrerDetails;
                    if (vivoInstallReferrerDetails != null) {
                        onVivoInstallReferrerReadListener.onVivoInstallReferrerRead(vivoInstallReferrerDetails);
                        return;
                    }
                    String str = vivoInstallReferrerResult.error;
                    if (str != null) {
                        onVivoInstallReferrerReadListener.onFail(str);
                    } else {
                        onVivoInstallReferrerReadListener.onFail("VivoReferrer getInstallReferrer: xiaomiInstallReferrerDetails is null");
                    }
                } else {
                    onVivoInstallReferrerReadListener.onFail("VivoReferrer getInstallReferrer: vivoInstallReferrerResult is null");
                }
            }
        }.execute(context);
    }

    public static void readVivoReferrer(Context context) {
        shouldReadVivoReferrer = true;
    }
}
