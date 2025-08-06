package com.hbg.lib.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.BaseApplication;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import i6.k;
import org.greenrobot.eventbus.EventBus;

public class NetworkStatus {

    public static class BaseConnectivityChangeReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public NetworkInfo f67468a;

        /* renamed from: b  reason: collision with root package name */
        public NetworkInfo f67469b;

        public final void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    NetworkInfo networkInfo = this.f67468a;
                    if (networkInfo == null) {
                        this.f67468a = activeNetworkInfo;
                        if (!activeNetworkInfo.isConnected()) {
                            return;
                        }
                        if (this.f67468a.getType() == 0) {
                            EventBus.d().k(ConnectEvent.EVENT_MOBILE_CONNECT);
                            k.d("NetworkStatus", "CONNECTIVITY_ACTION:connect MOBILE");
                        } else if (this.f67468a.getType() == 1) {
                            EventBus.d().k(ConnectEvent.EVENT_WIFI_CONNECT);
                            k.d("NetworkStatus", "CONNECTIVITY_ACTION:connect WIFI");
                        }
                    } else if (networkInfo.getType() != activeNetworkInfo.getType()) {
                        this.f67468a = activeNetworkInfo;
                        if (!activeNetworkInfo.isConnected()) {
                            EventBus.d().k(ConnectEvent.EVENT_NET_DISCONNECT);
                            k.d("NetworkStatus", "CONNECTIVITY_ACTION:disconnect2");
                        } else if (this.f67468a.getType() == 0) {
                            EventBus.d().k(ConnectEvent.EVENT_MOBILE_CONNECT);
                            k.d("NetworkStatus", "CONNECTIVITY_ACTION:connect MOBILE");
                        } else if (this.f67468a.getType() == 1) {
                            EventBus.d().k(ConnectEvent.EVENT_WIFI_CONNECT);
                            k.d("NetworkStatus", "CONNECTIVITY_ACTION:connect WIFI");
                        }
                    } else {
                        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(17);
                        if (this.f67469b == null && networkInfo2 != null) {
                            this.f67469b = networkInfo2;
                            if (networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                                EventBus.d().k(ConnectEvent.EVENT_NET_VPN_CONNECT);
                                k.d("NetworkStatus", "VPN connect");
                            }
                        }
                        NetworkInfo networkInfo3 = this.f67469b;
                        if (!(networkInfo3 == null || networkInfo2 == null)) {
                            if (networkInfo3.getState() != networkInfo2.getState()) {
                                if (networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                                    EventBus.d().k(ConnectEvent.EVENT_NET_VPN_CONNECT);
                                    k.d("NetworkStatus", "VPN connect");
                                } else if (networkInfo2.getState() == NetworkInfo.State.DISCONNECTED) {
                                    EventBus.d().k(ConnectEvent.EVENT_NET_VPN_DISCONNECT);
                                    k.d("NetworkStatus", "VPN disconnect");
                                }
                            }
                            this.f67469b = networkInfo2;
                        }
                        if (this.f67469b != null && networkInfo2 == null) {
                            this.f67469b = null;
                            k.d("NetworkStatus", "VPN disconnect");
                        }
                    }
                } else if (this.f67468a != null) {
                    this.f67468a = null;
                    k.d("NetworkStatus", "CONNECTIVITY_ACTION:disconnect");
                    EventBus.d().k(ConnectEvent.EVENT_NET_DISCONNECT);
                }
            }
        }
    }

    public enum ConnectEvent {
        EVENT_WIFI_CONNECT,
        EVENT_MOBILE_CONNECT,
        EVENT_NET_DISCONNECT,
        EVENT_NET_VPN_CONNECT,
        EVENT_NET_VPN_DISCONNECT
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        switch (activeNetworkInfo.getSubtype()) {
                            case 0:
                                return "NETWORK_TYPE_UNKNOWN";
                            case 1:
                                return "NETWORK_TYPE_GPRS";
                            case 2:
                                return "NETWORK_TYPE_EDGE";
                            case 3:
                                return "NETWORK_TYPE_UMTS";
                            case 4:
                                return "NETWORK_TYPE_CDMA";
                            case 5:
                                return "NETWORK_TYPE_EVDO_0";
                            case 6:
                                return "NETWORK_TYPE_EVDO_A";
                            case 7:
                                return "NETWORK_TYPE_1xRTT";
                            case 8:
                                return "NETWORK_TYPE_HSDPA";
                            case 9:
                                return "NETWORK_TYPE_HSUPA";
                            case 10:
                                return "NETWORK_TYPE_HSPA";
                            case 12:
                                return "NETWORK_TYPE_EVDO_B";
                            case 13:
                                return "NETWORK_TYPE_LTE";
                            default:
                                return "TYPE_MOBILE_DUN";
                        }
                    case 1:
                        return "TYPE_WIFI";
                    case 2:
                        return "TYPE_MOBILE_MMS";
                    case 3:
                        return "TYPE_MOBILE_SUPL";
                    case 4:
                        return "TYPE_MOBILE_DUN";
                    case 5:
                        return "TYPE_MOBILE_HIPRI";
                    case 6:
                        return "TYPE_WIMAX";
                }
            }
            return null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
        if (telephonyManager != null) {
            String simOperator = telephonyManager.getSimOperator();
            return !TextUtils.isEmpty(simOperator) && simOperator.startsWith("4600");
        }
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void d() {
        if (Build.VERSION.SDK_INT >= 33) {
            BaseApplication.b().getApplicationContext().registerReceiver(new BaseConnectivityChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
        } else {
            BaseApplication.b().getApplicationContext().registerReceiver(new BaseConnectivityChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
}
