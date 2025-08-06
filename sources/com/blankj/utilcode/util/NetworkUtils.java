package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import com.blankj.utilcode.util.Utils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Utils.a<WifiScanResults>> f63352a = new CopyOnWriteArraySet();

    public static final class NetworkChangedReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public NetworkType f63353a;

        /* renamed from: b  reason: collision with root package name */
        public Set<a> f63354b = new HashSet();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NetworkType b11 = NetworkUtils.b();
                if (NetworkChangedReceiver.this.f63353a != b11) {
                    NetworkType unused = NetworkChangedReceiver.this.f63353a = b11;
                    if (b11 == NetworkType.NETWORK_NO) {
                        for (a onDisconnected : NetworkChangedReceiver.this.f63354b) {
                            onDisconnected.onDisconnected();
                        }
                        return;
                    }
                    for (a a11 : NetworkChangedReceiver.this.f63354b) {
                        a11.a(b11);
                    }
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                a0.J(new a(), 1000);
            }
        }
    }

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    public static final class WifiScanResults {

        /* renamed from: a  reason: collision with root package name */
        public List<ScanResult> f63356a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<ScanResult> f63357b = new ArrayList();
    }

    public interface a {
        void a(NetworkType networkType);

        void onDisconnected();
    }

    public static NetworkInfo a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static NetworkType b() {
        if (c()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo a11 = a();
        if (a11 == null || !a11.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (a11.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (a11.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (a11.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
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
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 20:
                return NetworkType.NETWORK_5G;
            default:
                String subtypeName = a11.getSubtypeName();
                if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return NetworkType.NETWORK_3G;
                }
                return NetworkType.NETWORK_UNKNOWN;
        }
    }

    public static boolean c() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return true;
        }
        return false;
    }
}
