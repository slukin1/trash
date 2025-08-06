package com.tencent.a.a.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import com.tencent.wxop.stat.b.g;
import org.json.JSONObject;

public final class h {
    private static void a(String str, Throwable th2) {
        Log.e("MID", str, th2);
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (d(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th2) {
            a("checkPermission error", th2);
            return false;
        }
    }

    public static String b(Context context) {
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getDeviceId();
                return deviceId != null ? deviceId : "";
            }
            Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
            return "";
        } catch (Throwable th2) {
            Log.w("MID", th2);
            return "";
        }
    }

    public static String c(Context context) {
        String str;
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e11) {
                str = "get wifi address error" + e11;
            }
        } else {
            str = "Could not get permission of android.permission.ACCESS_WIFI_STATE";
            Log.i("MID", str);
            return "";
        }
    }

    public static boolean d(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean e(String str) {
        return str != null && str.trim().length() >= 40;
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(g.c(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th2) {
            a("decode error", th2);
            return str;
        }
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(g.b(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th2) {
            a("decode error", th2);
            return str;
        }
    }
}
