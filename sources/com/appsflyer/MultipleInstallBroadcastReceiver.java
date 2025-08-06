package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.adjust.sdk.Constants;
import com.appsflyer.internal.ae;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
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
                AFLogger.AFKeystoreWrapper("MultipleInstallBroadcastReceiver called");
                ae.values().AFInAppEventParameterName(context, intent);
                for (ResolveInfo next : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0)) {
                    String action = intent.getAction();
                    if (next.activityInfo.packageName.equals(context.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(action) && !getClass().getName().equals(next.activityInfo.name)) {
                        StringBuilder sb2 = new StringBuilder("trigger onReceive: class: ");
                        sb2.append(next.activityInfo.name);
                        AFLogger.AFKeystoreWrapper(sb2.toString());
                        try {
                            ((BroadcastReceiver) Class.forName(next.activityInfo.name).newInstance()).onReceive(context, intent);
                        } catch (Throwable th3) {
                            StringBuilder sb3 = new StringBuilder("error in BroadcastReceiver ");
                            sb3.append(next.activityInfo.name);
                            AFLogger.AFInAppEventType(sb3.toString(), th3);
                        }
                    }
                }
                return;
            }
            ae.values().values(context, str);
        }
    }
}
