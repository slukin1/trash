package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.Constants;
import com.appsflyer.internal.ae;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (intent != null) {
            try {
                str = intent.getStringExtra(Constants.REFERRER);
            } catch (Throwable th2) {
                AFLogger.AFInAppEventType("error in BroadcastReceiver ", th2);
                str = null;
            }
            if (str == null || ae.values(context).getString(Constants.REFERRER, (String) null) == null) {
                String string = AppsFlyerProperties.getInstance().getString("referrer_timestamp");
                long currentTimeMillis = System.currentTimeMillis();
                if (string == null || currentTimeMillis - Long.valueOf(string).longValue() >= 2000) {
                    AFLogger.AFKeystoreWrapper("SingleInstallBroadcastReceiver called");
                    ae.values().AFInAppEventParameterName(context, intent);
                    AppsFlyerProperties.getInstance().set("referrer_timestamp", String.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            }
            ae.values().values(context, str);
        }
    }
}
