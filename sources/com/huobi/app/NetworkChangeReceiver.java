package com.huobi.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import i6.k;

public class NetworkChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                k.o("[NetworkState]", "Network Disconnect!");
                return;
            }
            NetworkInfo.State state = activeNetworkInfo.getState();
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            String extraInfo = activeNetworkInfo.getExtraInfo();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("state=");
            sb2.append(state);
            sb2.append(" typeName=");
            sb2.append(typeName);
            String str2 = "";
            if (TextUtils.isEmpty(subtypeName)) {
                str = str2;
            } else {
                str = " subtypeName=" + subtypeName;
            }
            sb2.append(str);
            if (!TextUtils.isEmpty(extraInfo)) {
                str2 = " extraInfo=" + extraInfo;
            }
            sb2.append(str2);
            k.o("[NetworkState]", sb2.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
