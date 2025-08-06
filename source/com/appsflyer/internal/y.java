package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.appsflyer.AFLogger;
import com.facebook.places.model.PlaceFields;

final class y {

    public static final class a {
        public static final y valueOf = new y();
    }

    public static final class d {
        public final String AFInAppEventType;
        public final String AFKeystoreWrapper;
        public final String valueOf;

        public d(String str, String str2, String str3) {
            this.AFKeystoreWrapper = str;
            this.valueOf = str2;
            this.AFInAppEventType = str3;
        }
    }

    public static d AFKeystoreWrapper(Context context) {
        String str;
        String str2;
        String str3;
        String str4 = "unknown";
        String str5 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                int i11 = 0;
                if (21 <= Build.VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i11]);
                        if (!valueOf(networkInfo)) {
                            i11++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else if (!valueOf(connectivityManager.getNetworkInfo(1))) {
                    if (!valueOf(connectivityManager.getNetworkInfo(0))) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (valueOf(activeNetworkInfo)) {
                            if (1 != activeNetworkInfo.getType()) {
                                if (activeNetworkInfo.getType() == 0) {
                                }
                            }
                        }
                    }
                    str4 = "MOBILE";
                }
                str4 = "WIFI";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            str = telephonyManager.getSimOperatorName();
            try {
                str2 = telephonyManager.getNetworkOperatorName();
                if ((str2 == null || str2.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str2 = "CDMA";
                }
            } catch (Throwable th2) {
                th = th2;
                String str6 = str;
                str3 = null;
                str5 = str6;
                AFLogger.AFInAppEventType("Exception while collecting network info. ", th);
                String str7 = str3;
                str = str5;
                str2 = str7;
                return new d(str4, str2, str);
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = null;
            AFLogger.AFInAppEventType("Exception while collecting network info. ", th);
            String str72 = str3;
            str = str5;
            str2 = str72;
            return new d(str4, str2, str);
        }
        return new d(str4, str2, str);
    }

    private static boolean valueOf(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
