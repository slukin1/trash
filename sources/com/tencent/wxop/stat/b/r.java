package com.tencent.wxop.stat.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static String f51030a = "";

    private static WifiInfo T(Context context) {
        WifiManager wifiManager;
        if (!a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    public static String U(Context context) {
        try {
            WifiInfo T = T(context);
            if (T != null) {
                return T.getBSSID();
            }
            return null;
        } catch (Throwable th2) {
            Log.e("MtaSDK", "encode error", th2);
            return null;
        }
    }

    public static String V(Context context) {
        try {
            WifiInfo T = T(context);
            if (T != null) {
                return T.getSSID();
            }
            return null;
        } catch (Throwable th2) {
            Log.e("MtaSDK", "encode error", th2);
            return null;
        }
    }

    public static boolean W(Context context) {
        try {
            if (!a(context, "android.permission.INTERNET") || !a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    return true;
                }
                Log.w("MtaSDK", "Network error");
                return false;
            }
            return false;
        } catch (Throwable th2) {
            Log.e("MtaSDK", "isNetworkAvailable error", th2);
        }
    }

    public static JSONArray X(Context context) {
        List<ScanResult> scanResults;
        try {
            if (!a(context, "android.permission.INTERNET") || !a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (scanResults = wifiManager.getScanResults()) == null || scanResults.size() <= 0) {
                return null;
            }
            Collections.sort(scanResults, new s());
            JSONArray jSONArray = new JSONArray();
            int i11 = 0;
            while (i11 < scanResults.size() && i11 < 10) {
                ScanResult scanResult = scanResults.get(i11);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bs", scanResult.BSSID);
                jSONObject.put("ss", scanResult.SSID);
                jSONArray.put(jSONObject);
                i11++;
            }
            return jSONArray;
        } catch (Throwable th2) {
            Log.e("MtaSDK", "isWifiNet error", th2);
            return null;
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th2) {
                Log.e("MtaSDK", "jsonPut error", th2);
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th2) {
            Log.e("MtaSDK", "checkPermission error", th2);
            return false;
        }
    }

    public static String b(Context context) {
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
                return null;
            }
            Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
            return null;
        } catch (Throwable th2) {
            Log.e("MtaSDK", "get device id error", th2);
            return null;
        }
    }

    public static String c(Context context) {
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e11) {
                Log.e("MtaSDK", "get wifi address error", e11);
                return "";
            }
        } else {
            Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
    }

    public static String q(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(h.e(g.b(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th2) {
            Log.e("MtaSDK", "encode error", th2);
            return str;
        }
    }

    public static String t(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(g.c(h.d(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th2) {
            Log.e("MtaSDK", "decode error", th2);
            return str;
        }
    }
}
