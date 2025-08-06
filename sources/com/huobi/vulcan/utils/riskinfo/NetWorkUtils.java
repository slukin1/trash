package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetWorkUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f20634a = "NetWorkUtils";

    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                String name = nextElement.getName();
                if (nextElement.isUp()) {
                    String str = f20634a;
                    Log.d(str, "NetworkInterface.getName() = " + name);
                    if (name.contains("tun") || name.contains("ppp") || name.contains("pptp")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e11) {
            Log.e(f20634a, e11.getMessage());
            return false;
        }
    }

    public static boolean b(Context context) {
        NetworkCapabilities networkCapabilities;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 21) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (i11 >= 23) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasTransport(4);
        }
        Network[] allNetworks = connectivityManager.getAllNetworks();
        for (Network networkCapabilities2 : allNetworks) {
            NetworkCapabilities networkCapabilities3 = connectivityManager.getNetworkCapabilities(networkCapabilities2);
            if (networkCapabilities3 != null && networkCapabilities3.hasTransport(4)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r4.equalsIgnoreCase("CDMA2000") == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(android.content.Context r4) {
        /*
            r0 = -1
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r1)
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4
            r1 = 9
            r2 = 1
            if (r4 == 0) goto L_0x0052
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()
            if (r4 == 0) goto L_0x0052
            boolean r3 = r4.isAvailable()
            if (r3 == 0) goto L_0x0052
            int r0 = r4.getType()
            if (r0 != r2) goto L_0x0025
        L_0x0023:
            r0 = r2
            goto L_0x0052
        L_0x0025:
            if (r0 != 0) goto L_0x0051
            int r0 = r4.getSubtype()
            r2 = 3
            switch(r0) {
                case 1: goto L_0x004e;
                case 2: goto L_0x004e;
                case 3: goto L_0x0023;
                case 4: goto L_0x004e;
                case 5: goto L_0x0023;
                case 6: goto L_0x0023;
                case 7: goto L_0x004e;
                case 8: goto L_0x0023;
                case 9: goto L_0x0023;
                case 10: goto L_0x0023;
                case 11: goto L_0x004e;
                case 12: goto L_0x0023;
                case 13: goto L_0x004c;
                case 14: goto L_0x0023;
                case 15: goto L_0x0023;
                default: goto L_0x002f;
            }
        L_0x002f:
            java.lang.String r4 = r4.getSubtypeName()
            java.lang.String r0 = "TD-SCDMA"
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "WCDMA"
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "CDMA2000"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 == 0) goto L_0x0051
            goto L_0x0023
        L_0x004c:
            r4 = 4
            goto L_0x004f
        L_0x004e:
            r4 = 2
        L_0x004f:
            r0 = r4
            goto L_0x0052
        L_0x0051:
            r0 = r1
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.riskinfo.NetWorkUtils.c(android.content.Context):int");
    }

    public static String d(Context context) {
        int c11 = c(context);
        if (c11 == 1) {
            return "wifi";
        }
        if (c11 == 2) {
            return MTCommonConstants.Network.NAME_2G;
        }
        if (c11 == 3) {
            return MTCommonConstants.Network.NAME_3G;
        }
        if (c11 == 4) {
            return MTCommonConstants.Network.NAME_4G;
        }
        if (c11 != 5) {
            return c11 != 9 ? "NO" : GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        return MTCommonConstants.Network.NAME_5G;
    }

    public static boolean e(Context context) {
        return a() || b(context);
    }

    public static String f(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return "";
            }
            return property + ":" + property2;
        }
        String host = Proxy.getHost(context);
        int port = Proxy.getPort(context);
        if (TextUtils.isEmpty(host)) {
            return "";
        }
        return host + ":" + port;
    }
}
