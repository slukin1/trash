package com.huobi.vulcan.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkUtils {

    public enum NetworkType {
        NETWORK_WIFI,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO;

        public String toString() {
            int i11 = a.f20614a[ordinal()];
            if (i11 == 1) {
                return "WIFI";
            }
            if (i11 == 2) {
                return "4G";
            }
            if (i11 == 3) {
                return "3G";
            }
            if (i11 != 4) {
                return i11 != 5 ? "NO" : GrsBaseInfo.CountryCodeSource.UNKNOWN;
            }
            return "2G";
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20614a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.vulcan.utils.NetworkUtils$NetworkType[] r0 = com.huobi.vulcan.utils.NetworkUtils.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20614a = r0
                com.huobi.vulcan.utils.NetworkUtils$NetworkType r1 = com.huobi.vulcan.utils.NetworkUtils.NetworkType.NETWORK_WIFI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.vulcan.utils.NetworkUtils$NetworkType r1 = com.huobi.vulcan.utils.NetworkUtils.NetworkType.NETWORK_4G     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.vulcan.utils.NetworkUtils$NetworkType r1 = com.huobi.vulcan.utils.NetworkUtils.NetworkType.NETWORK_3G     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.vulcan.utils.NetworkUtils$NetworkType r1 = com.huobi.vulcan.utils.NetworkUtils.NetworkType.NETWORK_2G     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.vulcan.utils.NetworkUtils$NetworkType r1 = com.huobi.vulcan.utils.NetworkUtils.NetworkType.NETWORK_UNKNOWN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.NetworkUtils.a.<clinit>():void");
        }
    }

    public static NetworkInfo a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String b(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Exception e11) {
            LogUtils.b(e11);
            return "";
        }
    }

    public static String c(boolean z11) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress()) {
                            String hostAddress = nextElement2.getHostAddress();
                            boolean z12 = hostAddress.indexOf(58) < 0;
                            if (z11) {
                                if (z12) {
                                    return hostAddress;
                                }
                            } else if (!z12) {
                                int indexOf = hostAddress.indexOf(37);
                                return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (SocketException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static NetworkType d(Context context) {
        NetworkType networkType;
        NetworkType networkType2 = NetworkType.NETWORK_NO;
        NetworkInfo a11 = a(context);
        if (a11 == null || !a11.isAvailable()) {
            return networkType2;
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
                networkType = NetworkType.NETWORK_2G;
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
                networkType = NetworkType.NETWORK_3G;
                break;
            case 13:
            case 18:
                networkType = NetworkType.NETWORK_4G;
                break;
            default:
                String subtypeName = a11.getSubtypeName();
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                    networkType = NetworkType.NETWORK_UNKNOWN;
                    break;
                } else {
                    networkType = NetworkType.NETWORK_3G;
                    break;
                }
                break;
        }
        return networkType;
    }

    public static String e(Context context) {
        try {
            String ssid = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getSSID();
            return !TextUtils.isEmpty(ssid) ? ssid.replace("\"", "") : ssid;
        } catch (Exception e11) {
            LogUtils.b(e11);
            return "";
        }
    }
}
