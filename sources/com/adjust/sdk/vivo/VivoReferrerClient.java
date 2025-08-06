package com.adjust.sdk.vivo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.adjust.sdk.ILogger;

public class VivoReferrerClient {
    public static VivoInstallReferrerResult getReferrer(Context context, ILogger iLogger) {
        try {
            Bundle call = context.getContentResolver().call(Uri.parse("content://com.vivo.appstore.provider.referrer"), "read_referrer", (String) null, (Bundle) null);
            if (call == null) {
                return new VivoInstallReferrerResult("VivoReferrer read error: resultBundle null");
            }
            String string = call.getString(Constants.INSTALL_REFERRER);
            if (TextUtils.isEmpty(string)) {
                return new VivoInstallReferrerResult("VivoReferrer read error: referrer string null");
            }
            return new VivoInstallReferrerResult(new VivoInstallReferrerDetails(string, call.getLong("referrer_click_timestamp_seconds"), call.getLong("download_begin_timestamp_seconds"), call.getString("install_version")));
        } catch (Exception e11) {
            String str = "VivoReferrer read error: " + e11.getMessage();
            iLogger.info(str, new Object[0]);
            return new VivoInstallReferrerResult(str);
        }
    }
}
