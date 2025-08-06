package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import com.facebook.places.model.PlaceFields;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackAppViewScreenUrl;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class SensorsDataUtils {
    public static final String COMMAND_HARMONYOS_VERSION = "getprop hw_sc.build.platform.version";
    private static final String SHARED_PREF_APP_VERSION = "sensorsdata.app.version";
    private static final String SHARED_PREF_DEVICE_ID_KEY = "sensorsdata.device.id";
    private static final String SHARED_PREF_EDITS_FILE = "sensorsdata";
    private static final String SHARED_PREF_USER_AGENT_KEY = "sensorsdata.user.agent";
    private static final String TAG = "SA.SensorsDataUtils";
    private static String androidID = "";
    private static final Map<String, String> deviceUniqueIdentifiersMap = new HashMap();
    private static boolean isUniApp = false;
    private static final List<String> mInvalidAndroidId = new ArrayList<String>() {
        {
            add("9774d56d682e549c");
            add("0123456789abcdef");
            add("0000000000000000");
        }
    };
    private static final Set<String> mPermissionGrantedSet = new HashSet();
    private static final String marshmallowMacAddress = "02:00:00:00:00:00";
    private static final Map<String, String> sCarrierMap = new HashMap<String, String>() {
        {
            put("46000", "中国移动");
            put("46002", "中国移动");
            put("46007", "中国移动");
            put("46008", "中国移动");
            put("46001", "中国联通");
            put("46006", "中国联通");
            put("46009", "中国联通");
            put("46003", "中国电信");
            put("46005", "中国电信");
            put("46011", "中国电信");
            put("46004", "中国卫通");
            put("46020", "中国铁通");
        }
    };

    /* JADX WARNING: Removed duplicated region for block: B:17:0x001c A[SYNTHETIC, Splitter:B:17:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0022 A[Catch:{ Exception -> 0x0066 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkHasPermission(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.Class<androidx.core.content.ContextCompat> r0 = androidx.core.content.ContextCompat.class
            java.lang.String r1 = "SA.SensorsDataUtils"
            r2 = 1
            java.util.Set<java.lang.String> r3 = mPermissionGrantedSet     // Catch:{ Exception -> 0x0066 }
            boolean r3 = r3.contains(r10)     // Catch:{ Exception -> 0x0066 }
            if (r3 == 0) goto L_0x000e
            return r2
        L_0x000e:
            r3 = 0
            int r4 = androidx.core.content.ContextCompat.RECEIVER_VISIBLE_TO_INSTANT_APPS     // Catch:{ Exception -> 0x0013 }
            r4 = r0
            goto L_0x0014
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 != 0) goto L_0x0019
            int r4 = androidx.core.content.ContextCompat.RECEIVER_VISIBLE_TO_INSTANT_APPS     // Catch:{ Exception -> 0x0019 }
            goto L_0x001a
        L_0x0019:
            r0 = r4
        L_0x001a:
            if (r0 != 0) goto L_0x0022
            java.util.Set<java.lang.String> r9 = mPermissionGrantedSet     // Catch:{ Exception -> 0x0066 }
            r9.add(r10)     // Catch:{ Exception -> 0x0066 }
            return r2
        L_0x0022:
            java.lang.String r4 = "checkSelfPermission"
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0066 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r8 = 0
            r6[r8] = r7     // Catch:{ Exception -> 0x0066 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r2] = r7     // Catch:{ Exception -> 0x0066 }
            java.lang.reflect.Method r0 = r0.getMethod(r4, r6)     // Catch:{ Exception -> 0x0066 }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0066 }
            r4[r8] = r9     // Catch:{ Exception -> 0x0066 }
            r4[r2] = r10     // Catch:{ Exception -> 0x0066 }
            java.lang.Object r9 = r0.invoke(r3, r4)     // Catch:{ Exception -> 0x0066 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x0066 }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x0066 }
            if (r9 == 0) goto L_0x0060
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066 }
            r9.<init>()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r0 = "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\""
            r9.append(r0)     // Catch:{ Exception -> 0x0066 }
            r9.append(r10)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r10 = "\" />"
            r9.append(r10)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0066 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r9)     // Catch:{ Exception -> 0x0066 }
            return r8
        L_0x0060:
            java.util.Set<java.lang.String> r9 = mPermissionGrantedSet     // Catch:{ Exception -> 0x0066 }
            r9.add(r10)     // Catch:{ Exception -> 0x0066 }
            return r2
        L_0x0066:
            r9 = move-exception
            java.lang.String r9 = r9.toString()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.checkHasPermission(android.content.Context, java.lang.String):boolean");
    }

    public static boolean checkVersionIsNew(Context context, String str) {
        try {
            String string = SAStoreManager.getInstance().getString(SHARED_PREF_APP_VERSION, "");
            if (TextUtils.isEmpty(str) || str.equals(string)) {
                return false;
            }
            SAStoreManager.getInstance().setString(SHARED_PREF_APP_VERSION, str);
            return true;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return true;
        }
    }

    private static Class<?> compatActivity() {
        Class<?> cls;
        try {
            cls = ReflectUtil.getClassByName("androidx.appcompat.app.AppCompatActivity");
        } catch (Exception unused) {
            cls = null;
        }
        if (cls != null) {
            return cls;
        }
        try {
            return ReflectUtil.getClassByName("androidx.appcompat.app.AppCompatActivity");
        } catch (Exception unused2) {
            return cls;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b A[Catch:{ Exception -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[Catch:{ Exception -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getActivityTitle(android.app.Activity r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x004b
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x004b }
            r2 = 11
            if (r1 < r2) goto L_0x0014
            java.lang.String r1 = getToolbarTitle(r4)     // Catch:{ Exception -> 0x004b }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x004b }
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x004b }
            if (r2 == 0) goto L_0x0023
            java.lang.CharSequence r1 = r4.getTitle()     // Catch:{ Exception -> 0x004b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004b }
        L_0x0023:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x004b }
            if (r2 == 0) goto L_0x004a
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch:{ Exception -> 0x004b }
            if (r2 == 0) goto L_0x004a
            android.content.ComponentName r4 = r4.getComponentName()     // Catch:{ Exception -> 0x004b }
            r3 = 0
            android.content.pm.ActivityInfo r4 = r2.getActivityInfo(r4, r3)     // Catch:{ Exception -> 0x004b }
            java.lang.CharSequence r3 = r4.loadLabel(r2)     // Catch:{ Exception -> 0x004b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x004b }
            if (r3 != 0) goto L_0x004a
            java.lang.CharSequence r4 = r4.loadLabel(r2)     // Catch:{ Exception -> 0x004b }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x004b }
        L_0x004a:
            return r1
        L_0x004b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(android.app.Activity):java.lang.String");
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidID(Context context) {
        try {
            if (TextUtils.isEmpty(androidID)) {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                androidID = string;
                if (!isValidAndroidId(string)) {
                    androidID = "";
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return androidID;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[Catch:{ Exception -> 0x004c, Error -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047 A[Catch:{ Exception -> 0x004c, Error -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[ExcHandler: Error (r5v2 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCarrier(android.content.Context r5) {
        /*
            r0 = 0
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            boolean r1 = checkHasPermission(r5, r1)     // Catch:{ Exception -> 0x005c, Error -> 0x0051 }
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r5.getSystemService(r1)     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            if (r1 == 0) goto L_0x0060
            java.lang.String r2 = r1.getSimOperator()     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            r4 = 28
            if (r3 < r4) goto L_0x002c
            java.lang.CharSequence r3 = r1.getSimCarrierIdName()     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            if (r4 != 0) goto L_0x002c
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            goto L_0x002d
        L_0x002c:
            r3 = r0
        L_0x002d:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            if (r4 == 0) goto L_0x0041
            int r3 = r1.getSimState()     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            r4 = 5
            if (r3 != r4) goto L_0x003f
            java.lang.String r3 = r1.getSimOperatorName()     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            goto L_0x0041
        L_0x003f:
            java.lang.String r3 = "未知"
        L_0x0041:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            if (r1 != 0) goto L_0x0060
            java.lang.String r5 = operatorToCarrier(r5, r2, r3)     // Catch:{ Exception -> 0x004c, Error -> 0x0051 }
            return r5
        L_0x004c:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)     // Catch:{ Exception -> 0x005c, Error -> 0x0051 }
            goto L_0x0060
        L_0x0051:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = "SA.SensorsDataUtils"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r5)
            goto L_0x0060
        L_0x005c:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getCarrier(android.content.Context):java.lang.String");
    }

    private static String getCarrierFromJsonObject(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private static String getDeviceID(Context context, int i11) {
        TelephonyManager telephonyManager;
        String deviceId;
        String str = "";
        try {
            String str2 = "deviceID" + i11;
            Map<String, String> map = deviceUniqueIdentifiersMap;
            if (map.containsKey(str2)) {
                str = map.get(str2);
            }
            if (TextUtils.isEmpty(str) && hasReadPhoneStatePermission(context) && (telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE)) != null) {
                if (i11 == -1) {
                    deviceId = telephonyManager.getDeviceId();
                } else if (i11 != -2 || Build.VERSION.SDK_INT < 26) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        deviceId = telephonyManager.getDeviceId(i11);
                    }
                    map.put(str2, str);
                } else {
                    deviceId = telephonyManager.getMeid();
                }
                str = deviceId;
                map.put(str2, str);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return str;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager;
        String str;
        String str2 = "";
        try {
            Map<String, String> map = deviceUniqueIdentifiersMap;
            if (map.containsKey("IMEI")) {
                str2 = map.get("IMEI");
            }
            if (TextUtils.isEmpty(str2) && hasReadPhoneStatePermission(context) && (telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE)) != null) {
                int i11 = Build.VERSION.SDK_INT;
                if (i11 > 28) {
                    if (telephonyManager.hasCarrierPrivileges()) {
                        str = telephonyManager.getImei();
                    }
                    map.put("IMEI", str2);
                } else if (i11 >= 26) {
                    str = telephonyManager.getImei();
                } else {
                    str = telephonyManager.getDeviceId();
                }
                str2 = str;
                map.put("IMEI", str2);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return str2;
    }

    public static String getIMEIOld(Context context) {
        return getDeviceID(context, -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[SYNTHETIC, Splitter:B:25:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getJsonFromAssets(java.lang.String r4, android.content.Context r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x002e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x002e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x002e }
            java.io.InputStream r4 = r5.open(r4)     // Catch:{ IOException -> 0x002e }
            r3.<init>(r4)     // Catch:{ IOException -> 0x002e }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002e }
        L_0x0018:
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            if (r4 == 0) goto L_0x0022
            r0.append(r4)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            goto L_0x0018
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0026:
            r4 = move-exception
            r1 = r2
            goto L_0x0041
        L_0x0029:
            r4 = move-exception
            r1 = r2
            goto L_0x002f
        L_0x002c:
            r4 = move-exception
            goto L_0x0041
        L_0x002e:
            r4 = move-exception
        L_0x002f:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x003c:
            java.lang.String r4 = r0.toString()
            return r4
        L_0x0041:
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x004b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getJsonFromAssets(java.lang.String, android.content.Context):java.lang.String");
    }

    public static String getMEID(Context context) {
        return getDeviceID(context, -2);
    }

    @SuppressLint({"MissingPermission"})
    public static String getMacAddress(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String str = marshmallowMacAddress;
        String str2 = "";
        try {
            Map<String, String> map = deviceUniqueIdentifiersMap;
            if (map.containsKey("macAddress")) {
                str2 = map.get("macAddress");
            }
            if (!TextUtils.isEmpty(str2) || !checkHasPermission(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getMacAddress() == null) {
                return str2;
            }
            String macAddress = connectionInfo.getMacAddress();
            if (str.equals(macAddress)) {
                String macAddressByInterface = getMacAddressByInterface();
                if (macAddressByInterface != null) {
                    str = macAddressByInterface;
                }
            } else {
                str = macAddress;
            }
            try {
                map.put("macAddress", str);
                return str;
            } catch (Exception e11) {
                e = e11;
                str2 = str;
                SALog.printStackTrace(e);
                return str2;
            }
        } catch (Exception e12) {
            e = e12;
            SALog.printStackTrace(e);
            return str2;
        }
    }

    private static String getMacAddressByInterface() {
        try {
            for (T t11 : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if ("wlan0".equalsIgnoreCase(t11.getName())) {
                    byte[] hardwareAddress = t11.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        sb2.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i11])}));
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void getScreenNameAndTitleFromActivity(JSONObject jSONObject, Activity activity) {
        PackageManager packageManager;
        if (activity != null && jSONObject != null) {
            try {
                jSONObject.put(AopConstants.SCREEN_NAME, activity.getClass().getCanonicalName());
                String str = null;
                if (!TextUtils.isEmpty(activity.getTitle())) {
                    str = activity.getTitle().toString();
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    String toolbarTitle = getToolbarTitle(activity);
                    if (!TextUtils.isEmpty(toolbarTitle)) {
                        str = toolbarTitle;
                    }
                }
                if (TextUtils.isEmpty(str) && (packageManager = activity.getPackageManager()) != null) {
                    str = packageManager.getActivityInfo(activity.getComponentName(), 0).loadLabel(packageManager).toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(AopConstants.TITLE, str);
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static String getScreenUrl(Object obj) {
        String str = null;
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof ScreenAutoTracker) {
                str = ((ScreenAutoTracker) obj).getScreenUrl();
            } else {
                SensorsDataAutoTrackAppViewScreenUrl sensorsDataAutoTrackAppViewScreenUrl = (SensorsDataAutoTrackAppViewScreenUrl) obj.getClass().getAnnotation(SensorsDataAutoTrackAppViewScreenUrl.class);
                if (sensorsDataAutoTrackAppViewScreenUrl != null) {
                    str = sensorsDataAutoTrackAppViewScreenUrl.url();
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return str == null ? obj.getClass().getCanonicalName() : str;
    }

    public static String getSlot(Context context, int i11) {
        return getDeviceID(context, i11);
    }

    public static String getToolbarTitle(Activity activity) {
        Object invoke;
        CharSequence charSequence;
        try {
            if (!"com.tencent.connect.common.AssistActivity".equals(SnapCache.getInstance().getCanonicalName(activity.getClass()))) {
                int i11 = Build.VERSION.SDK_INT;
                ActionBar actionBar = i11 >= 11 ? activity.getActionBar() : null;
                if (actionBar == null) {
                    try {
                        Class<?> compatActivity = compatActivity();
                        if (!(compatActivity == null || !compatActivity.isInstance(activity) || (invoke = activity.getClass().getMethod("getSupportActionBar", new Class[0]).invoke(activity, new Object[0])) == null || (charSequence = (CharSequence) invoke.getClass().getMethod("getTitle", new Class[0]).invoke(invoke, new Object[0])) == null)) {
                            return charSequence.toString();
                        }
                    } catch (Exception unused) {
                    }
                } else if (i11 >= 11 && !TextUtils.isEmpty(actionBar.getTitle())) {
                    return actionBar.getTitle().toString();
                }
                return null;
            } else if (!TextUtils.isEmpty(activity.getTitle())) {
                return activity.getTitle().toString();
            } else {
                return null;
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void handleSchemeUrl(Activity activity, Intent intent) {
        SASchemeHelper.handleSchemeUrl(activity, intent);
    }

    private static boolean hasReadPhoneStatePermission(Context context) {
        if (Build.VERSION.SDK_INT > 28) {
            if (checkHasPermission(context, "android.permission.READ_PRECISE_PHONE_STATE")) {
                return true;
            }
            SALog.i(TAG, "Don't have permission android.permission.READ_PRECISE_PHONE_STATE,getDeviceID failed");
            return false;
        } else if (checkHasPermission(context, "android.permission.READ_PHONE_STATE")) {
            return true;
        } else {
            SALog.i(TAG, "Don't have permission android.permission.READ_PHONE_STATE,getDeviceID failed");
            return false;
        }
    }

    public static void initUniAppStatus() {
        try {
            Class.forName("io.dcloud.application.DCloudApplication");
            isUniApp = true;
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean isDoubleClick(View view) {
        if (view == null) {
            return false;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i11 = R.id.sensors_analytics_tag_view_onclick_timestamp;
            String str = (String) view.getTag(i11);
            if (!TextUtils.isEmpty(str) && elapsedRealtime - Long.parseLong(str) < 500) {
                return true;
            }
            view.setTag(i11, String.valueOf(elapsedRealtime));
            return false;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static boolean isUniApp() {
        return isUniApp;
    }

    public static boolean isValidAndroidId(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !mInvalidAndroidId.contains(str.toLowerCase(Locale.getDefault()));
    }

    public static void mergeJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (!(obj instanceof Date) || "$time".equals(next)) {
                    jSONObject2.put(next, obj);
                } else {
                    jSONObject2.put(next, TimeUtils.formatDate((Date) obj, Locale.CHINA));
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static JSONObject mergeSuperJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!TextUtils.isEmpty(next) && next.equalsIgnoreCase(next2)) {
                        keys2.remove();
                    }
                }
            }
            mergeJSONObject(jSONObject, jSONObject2);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return jSONObject2;
    }

    private static String operatorToCarrier(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            Map<String, String> map = sCarrierMap;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            String jsonFromAssets = getJsonFromAssets("sa_mcc_mnc_mini.json", context);
            if (TextUtils.isEmpty(jsonFromAssets)) {
                map.put(str, str2);
                return str2;
            }
            String carrierFromJsonObject = getCarrierFromJsonObject(new JSONObject(jsonFromAssets), str);
            if (!TextUtils.isEmpty(carrierFromJsonObject)) {
                map.put(str, carrierFromJsonObject);
                return carrierFromJsonObject;
            }
            return str2;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
