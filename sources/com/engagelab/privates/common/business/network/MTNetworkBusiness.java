package com.engagelab.privates.common.business.network;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;

public class MTNetworkBusiness {
    public static final int STATE_NETWORK_CONNECTED = 1;
    public static final int STATE_NETWORK_DISCONNECTED = 0;
    private static final String TAG = "MTNetworkBusiness";
    private static volatile MTNetworkBusiness instance;
    private boolean init = false;
    private MTNetworkListener networkListener;
    private int networkState = 0;

    public static MTNetworkBusiness getInstance() {
        if (instance == null) {
            synchronized (MTNetworkBusiness.class) {
                instance = new MTNetworkBusiness();
            }
        }
        return instance;
    }

    public void init(Context context) {
        if (!this.init) {
            this.init = true;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 26) {
                try {
                    MTNetworkListener mTNetworkListener = new MTNetworkListener(context);
                    this.networkListener = mTNetworkListener;
                    connectivityManager.registerDefaultNetworkCallback(mTNetworkListener);
                } catch (Throwable unused) {
                    NetworkRequest build = new NetworkRequest.Builder().build();
                    MTNetworkListener mTNetworkListener2 = new MTNetworkListener(context);
                    this.networkListener = mTNetworkListener2;
                    connectivityManager.registerNetworkCallback(build, mTNetworkListener2);
                }
            } else if (i11 >= 21) {
                NetworkRequest build2 = new NetworkRequest.Builder().build();
                MTNetworkListener mTNetworkListener3 = new MTNetworkListener(context);
                this.networkListener = mTNetworkListener3;
                connectivityManager.registerNetworkCallback(build2, mTNetworkListener3);
            } else {
                MTCommonReceiver commonReceiver = MTGlobal.getCommonReceiver(context);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(commonReceiver, intentFilter);
            }
        }
    }

    public void onMainNetworkState(Context context, Bundle bundle) {
        boolean z11;
        NetworkInfo networkInfo = (NetworkInfo) bundle.getParcelable("networkInfo");
        if (bundle.containsKey("state")) {
            z11 = bundle.getBoolean("state");
        } else {
            z11 = networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED;
        }
        Bundle onMainNetworkState = onMainNetworkState(context, z11, networkInfo);
        int i11 = MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED;
        int i12 = 1004;
        if (z11 && this.networkState == 1) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("state", false);
            bundle2.putInt("type", 0);
            bundle2.putString("name", "unknown");
            bundle2.putString(MTCommonConstants.Network.KEY_RADIO, "unknown");
            MTCommonLog.d(TAG, "onMainNetworkState network is connecting, new network connected");
            MTCommonPrivatesApi.sendMessageToMainProcess(context, 1004, bundle2);
            if (MTGlobal.isNeedRemoteProcess) {
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED, bundle2);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onMainNetworkState ");
        sb2.append(z11 ? "connected" : "disConnected");
        sb2.append(" currentNetwork:");
        sb2.append(MTGlobal.getNetworkName());
        MTCommonLog.d(TAG, sb2.toString());
        this.networkState = z11 ? 1 : 0;
        if (z11) {
            i12 = 1003;
        }
        MTCommonPrivatesApi.sendMessageToMainProcess(context, i12, onMainNetworkState);
        if (MTGlobal.isNeedRemoteProcess) {
            if (z11) {
                i11 = MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED;
            }
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, i11, onMainNetworkState);
        }
    }

    public void onRemoteNetworkState(Context context, Bundle bundle) {
        if (bundle != null) {
            boolean z11 = bundle.getBoolean("state");
            int i11 = bundle.getInt("type");
            String string = bundle.getString("name");
            String string2 = bundle.getString(MTCommonConstants.Network.KEY_RADIO);
            MTGlobal.setNetworkState(z11);
            MTGlobal.setNetworkType(i11);
            if (TextUtils.isEmpty(string)) {
                string = "unknown";
            }
            MTGlobal.setNetworkName(string);
            if (TextUtils.isEmpty(string2)) {
                string2 = "unknown";
            }
            MTGlobal.setNetworkRadio(string2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onRemoteNetworkState ");
            sb2.append(z11 ? "connected" : "disConnected");
            sb2.append(" currentNetwork:");
            sb2.append(MTGlobal.getNetworkName());
            MTCommonLog.d(TAG, sb2.toString());
        }
    }

    public void release(Context context) {
        this.networkState = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback(this.networkListener);
        } else {
            context.unregisterReceiver(MTGlobal.getCommonReceiver(context));
        }
    }

    public Bundle onMainNetworkState(Context context, boolean z11, NetworkInfo networkInfo) {
        Bundle bundle = new Bundle();
        if (!z11) {
            MTGlobal.setNetworkState(false);
            MTGlobal.setNetworkType(0);
            MTGlobal.setNetworkName("unknown");
            MTGlobal.setNetworkRadio("unknown");
            bundle.putBoolean("state", false);
            bundle.putInt("type", 0);
            bundle.putString("name", "unknown");
            bundle.putString(MTCommonConstants.Network.KEY_RADIO, "unknown");
            return bundle;
        }
        MTGlobal.setNetworkState(true);
        bundle.putBoolean("state", true);
        if (networkInfo.getType() == 1) {
            MTGlobal.setNetworkType(1);
            MTGlobal.setNetworkName("wifi");
            MTGlobal.setNetworkRadio("wifi");
            bundle.putInt("type", 1);
            bundle.putString("name", "wifi");
            bundle.putString(MTCommonConstants.Network.KEY_RADIO, "wifi");
            return bundle;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                MTGlobal.setNetworkType(2);
                MTGlobal.setNetworkName(MTCommonConstants.Network.NAME_2G);
                MTGlobal.setNetworkRadio(MTCommonConstants.Network.RADIO_2G);
                bundle.putInt("type", 2);
                bundle.putString("name", MTCommonConstants.Network.NAME_2G);
                bundle.putString(MTCommonConstants.Network.KEY_RADIO, MTCommonConstants.Network.RADIO_2G);
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                MTGlobal.setNetworkType(3);
                MTGlobal.setNetworkName(MTCommonConstants.Network.NAME_3G);
                MTGlobal.setNetworkRadio(MTCommonConstants.Network.RADIO_3G);
                bundle.putInt("type", 3);
                bundle.putString("name", MTCommonConstants.Network.NAME_3G);
                bundle.putString(MTCommonConstants.Network.KEY_RADIO, MTCommonConstants.Network.RADIO_3G);
                break;
            case 13:
            case 18:
            case 19:
                MTGlobal.setNetworkType(4);
                MTGlobal.setNetworkName(MTCommonConstants.Network.NAME_4G);
                MTGlobal.setNetworkRadio(MTCommonConstants.Network.RADIO_4G);
                bundle.putInt("type", 4);
                bundle.putString("name", MTCommonConstants.Network.NAME_4G);
                bundle.putString(MTCommonConstants.Network.KEY_RADIO, MTCommonConstants.Network.RADIO_4G);
                break;
            case 20:
                MTGlobal.setNetworkType(5);
                MTGlobal.setNetworkName(MTCommonConstants.Network.NAME_5G);
                MTGlobal.setNetworkRadio(MTCommonConstants.Network.RADIO_5G);
                bundle.putInt("type", 5);
                bundle.putString("name", MTCommonConstants.Network.NAME_5G);
                bundle.putString(MTCommonConstants.Network.KEY_RADIO, MTCommonConstants.Network.RADIO_5G);
                break;
            default:
                MTGlobal.setNetworkType(0);
                MTGlobal.setNetworkName("unknown");
                MTGlobal.setNetworkRadio("unknown");
                bundle.putInt("type", 0);
                bundle.putString("name", "unknown");
                bundle.putString(MTCommonConstants.Network.KEY_RADIO, "unknown");
                break;
        }
        return bundle;
    }
}
