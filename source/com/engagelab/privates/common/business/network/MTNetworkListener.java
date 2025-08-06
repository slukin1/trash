package com.engagelab.privates.common.business.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.engagelab.privates.common.MTCommon;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.log.MTCommonLog;

@TargetApi(21)
public class MTNetworkListener extends ConnectivityManager.NetworkCallback {
    private static final String TAG = "MTNetworkListener";
    private final Context context;

    public MTNetworkListener(Context context2) {
        this.context = context2;
    }

    private void onNetworkState(boolean z11, Network network) {
        try {
            MTCommonLog.d(TAG, "onNetworkState state:" + z11 + ",network:" + network.toString());
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
            Bundle bundle = new Bundle();
            bundle.putBoolean("state", z11);
            bundle.putParcelable("networkInfo", activeNetworkInfo);
            MTCommonPrivatesApi.sendMessage(this.context, MTCommon.THREAD_COMMON, 1007, bundle);
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "onNetworkState failed " + th2.getMessage());
        }
    }

    public void onAvailable(Network network) {
        onNetworkState(true, network);
    }

    public void onLost(Network network) {
        onNetworkState(false, network);
    }
}
