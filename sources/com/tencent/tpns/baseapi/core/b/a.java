package com.tencent.tpns.baseapi.core.b;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.push.AttributionReporter;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.DNSResolver;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GUIDInfo;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.device.RequestProxy;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.Util;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49854a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String f49855b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static boolean f49856c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f49857d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f49858e = null;

    /* renamed from: f  reason: collision with root package name */
    private static long f49859f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f49860g = false;

    /* renamed from: h  reason: collision with root package name */
    private static long f49861h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f49862i = false;

    private static String d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String lastResolvedGuidServerIP = GuidInfoManager.getLastResolvedGuidServerIP(context);
        if (TextUtils.isEmpty(lastResolvedGuidServerIP)) {
            return str;
        }
        String a11 = a(str, lastResolvedGuidServerIP);
        Logger.d("GuidInfoManagerImpl", "replaceGuidHostWithLastResolvedIP | lastResolvedIp : " + lastResolvedGuidServerIP + "; guidServerAddr : " + str + "; ipAddr : " + a11);
        return a11;
    }

    public static synchronized String e(Context context) {
        String str;
        synchronized (a.class) {
            if (f49858e == null) {
                Logger.i("GuidInfoManagerImpl", "MqttServerAddr null, get from Shar");
                f49858e = PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_DEFAULT_ADDRESS", "");
            }
            Logger.i("GuidInfoManagerImpl", "Get mqttServerIP: " + f49858e);
            str = f49858e;
        }
        return str;
    }

    public static String f(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_USERNAME", (String) null);
    }

    public static String g(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_PASSWORD", (String) null);
    }

    public static long h(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_EXPIRED_SECONDS", 43200);
    }

    public static long i(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_LAST_REFRESH_TIME", 0);
    }

    public static boolean j(Context context) {
        long i11 = i(context.getApplicationContext());
        if (!f49860g) {
            f49860g = true;
            if (XGApiConfig.getAccessId(context) != PushPreferences.getLong(context, "XG_GUID_LAST_ACCESSID", 0)) {
                Logger.d("GuidInfoManagerImpl", "New AccessId need to refresh token");
                n(context);
                return true;
            }
        }
        long currentTimeMillis = (System.currentTimeMillis() - i11) / 1000;
        Logger.i("GuidInfoManagerImpl", "GuidInfo gapSeconds = " + currentTimeMillis + ", compare to " + h(context.getApplicationContext()));
        if (currentTimeMillis > h(context.getApplicationContext())) {
            return true;
        }
        return false;
    }

    public static long k(Context context) {
        if (f49861h == 0) {
            Logger.i("GuidInfoManagerImpl", "MqttServerLastRefreshTime null, get from Shar");
            f49861h = PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0);
        }
        Logger.i("GuidInfoManagerImpl", "Get mqttServerLastRefreshTime: " + f49861h);
        return f49861h;
    }

    public static boolean l(Context context) {
        Logger.d("GuidInfoManagerImpl", "Check MqttServer expired?");
        long currentTimeMillis = (System.currentTimeMillis() - k(context)) / 1000;
        Logger.i("GuidInfoManagerImpl", "MqttServerAddr gapSeconds = " + currentTimeMillis + ", " + 1800);
        return currentTimeMillis > 1800;
    }

    public static void m(Context context) {
        TBaseLogger.ii("GuidInfoManagerImpl", "Force expired guidInfo, let its refreshTime 0");
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
    }

    public static void n(Context context) {
        a();
        Logger.d("GuidInfoManagerImpl", "clearGuidInfo");
        b(context, "", "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("XG_GUID_TOKEN", "");
        contentValues.put("XG_GUID_TOKEN_LIST", (String) null);
        contentValues.put("XG_GUID_MQTT_SERVER", "");
        contentValues.put("XG_GUID_MQTT_USERNAME", "");
        contentValues.put("XG_GUID_MQTT_PASSWORD", "");
        contentValues.put("XG_GUID_EXPIRED_SECONDS", 172800);
        contentValues.put("XG_GUID_LAST_REFRESH_TIME", 0L);
        contentValues.put("XG_GUID_SERVER_PENALTY_TIME", 0L);
        contentValues.put("XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0L);
        ContentValues reset = CloudManager.getInstance(context).reset();
        if (reset != null) {
            contentValues.putAll(reset);
        }
        PushPreferences.putContentValues(context, contentValues);
    }

    public static boolean o(Context context) {
        if (!f49862i) {
            f49862i = true;
            if (s(context)) {
                PushPreferences.putLong(context, "XG_GUID_SERVER_PENALTY_TIME", 0);
                return false;
            }
        }
        if (PushPreferences.getLong(context, "XG_GUID_SERVER_PENALTY_TIME", 0) > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public static int p(Context context) {
        if (PushPreferences.getLong(context, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0) > System.currentTimeMillis()) {
            return PushPreferences.getInt(context.getApplicationContext(), "XG_GUID_SERVER_ABANDON_RATE", 0);
        }
        PushPreferences.putLong(context, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0);
        return 0;
    }

    public static int q(Context context) {
        return PushPreferences.getInt(context.getApplicationContext(), "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
    }

    private static Pair<String, String> r(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tpush.vip.service.shareprefs", 0);
        String a11 = a(context, false);
        String a12 = a(context);
        if (a11 == null) {
            a11 = sharedPreferences.getString(b("XG_GUID_TOKEN"), (String) null);
        }
        if (a12 == null) {
            a12 = sharedPreferences.getString(b("XG_GUID_TOKEN_LIST"), (String) null);
        }
        if (!Util.isNullOrEmptyString(a11)) {
            if (a12 == null) {
                a12 = b(a11, a12);
            } else if (!a12.contains(a11)) {
                a12 = b(a11, a12);
            }
        }
        return new Pair<>(a11, a12);
    }

    private static boolean s(Context context) {
        long j11 = PushPreferences.getLong(context, "XG_GUID_LAST_APP_VERSION_CODE", 0);
        long curVersionCode = Util.getCurVersionCode(context);
        if (j11 == curVersionCode) {
            return false;
        }
        PushPreferences.putLong(context, "XG_GUID_LAST_APP_VERSION_CODE", curVersionCode);
        if (curVersionCode <= j11) {
            return false;
        }
        Logger.i("GuidInfoManagerImpl", "App is Update");
        return true;
    }

    public static GUIDInfo a(Context context, boolean z11, String str, RequestProxy requestProxy) {
        Logger.d("GuidInfoManagerImpl", "getFinalMqttServerAddrAndGuidInfo");
        if (!z11) {
            return a(context, requestProxy);
        }
        GUIDInfo gUIDInfo = new GUIDInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(MiPushClient.COMMAND_REGISTER, 1);
            jSONObject.put("from", 1);
            gUIDInfo = a(context, 0, jSONObject, requestProxy);
            if (!gUIDInfo.isError()) {
                String hostToIp = DNSResolver.hostToIp(gUIDInfo.mqttServer, gUIDInfo.mqttPortList);
                if (!Util.isNullOrEmptyString(hostToIp)) {
                    Logger.i("GuidInfoManagerImpl", "Get MqttServer: " + gUIDInfo.mqttServer + ", save address: " + hostToIp);
                    c(context, hostToIp);
                    a(context, System.currentTimeMillis());
                }
                gUIDInfo.mqttServerIP = hostToIp;
            }
        } catch (Throwable unused) {
            gUIDInfo.errCode = ErrCode.INNER_ERROR_JSON;
        }
        return gUIDInfo;
    }

    private static JSONObject b(Context context, long j11) {
        JSONObject jSONObject = new JSONObject();
        long accessId = XGApiConfig.getAccessId(context);
        String accessKey = XGApiConfig.getAccessKey(context);
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject.put("accessId", accessId);
        jSONObject.put("accessKey", accessKey);
        jSONObject.put("deviceType", 0);
        jSONObject.put("sdkVersion", "1.4.4.2");
        jSONObject.put("seq", j11);
        jSONObject.put("cloudVersion", CloudManager.getInstance(context).getCloudVersion());
        b bVar = new b();
        bVar.f49865a = Util.getCurAppVersion(context);
        bVar.f49867c = "android";
        bVar.f49868d = context.getPackageName();
        bVar.f49869e = Build.VERSION.RELEASE;
        if (!Util.isNullOrEmptyString(bVar.f49865a)) {
            jSONObject.put(AttributionReporter.APP_VERSION, bVar.f49865a);
        }
        if (!Util.isNullOrEmptyString(bVar.f49868d)) {
            jSONObject.put("appPkgName", bVar.f49868d);
        }
        jSONObject.put("deviceInfo", bVar.a());
        jSONObject.put("protocolVersion", 2);
        jSONObject.put("timestamp", currentTimeMillis);
        return jSONObject;
    }

    public static String c(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER", (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void c(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.Class<com.tencent.tpns.baseapi.core.b.a> r0 = com.tencent.tpns.baseapi.core.b.a.class
            monitor-enter(r0)
            boolean r1 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r5)     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            java.lang.String r1 = "GuidInfoManagerImpl"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r2.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "Save mqttServerIP: "
            r2.append(r3)     // Catch:{ all -> 0x0036 }
            r2.append(r5)     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0036 }
            com.tencent.tpns.baseapi.base.util.Logger.i(r1, r2)     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = f49858e     // Catch:{ all -> 0x0036 }
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0034
            f49858e = r5     // Catch:{ all -> 0x0036 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "XG_GUID_MQTT_SERVER_DEFAULT_ADDRESS"
            com.tencent.tpns.baseapi.base.PushPreferences.putString(r4, r1, r5)     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r0)
            return
        L_0x0036:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.c(android.content.Context, java.lang.String):void");
    }

    public static synchronized String d(Context context) {
        String str;
        synchronized (a.class) {
            if (f49857d == null) {
                f49857d = PushPreferences.getString(context.getApplicationContext(), "XG_LAST_RESOLVED_GUID_SERVER_IP", "");
                Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp is null, get from Shar");
            }
            Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp : " + f49857d);
            str = f49857d;
        }
        return str;
    }

    public static GUIDInfo a(Context context, RequestProxy requestProxy) {
        GUIDInfo gUIDInfo;
        GUIDInfo gUIDInfo2 = new GUIDInfo();
        if (o(context)) {
            Logger.e("GuidInfoManagerImpl", "getFinalMqttServerAddrAndGuidInfo: Resources have been destroyed");
            gUIDInfo2.errCode = ErrCode.GUID_INFO_SERVER_DESTROY;
            return gUIDInfo2;
        } else if (j(context)) {
            Logger.ii("GuidInfoManagerImpl", "Guid expired, request for new one.");
            GUIDInfo a11 = a(context, 0, (JSONObject) null, requestProxy);
            if (!a11.isError()) {
                String hostToIp = DNSResolver.hostToIp(a11.mqttServer, a11.mqttPortList);
                if (Util.isNullOrEmptyString(hostToIp)) {
                    hostToIp = e(context);
                    Logger.i("GuidInfoManagerImpl", "MqttServer domain resolver failed, get from shar: " + hostToIp);
                } else {
                    Logger.i("GuidInfoManagerImpl", "Get MqttServer: " + a11.mqttServer + ", save address: " + hostToIp);
                    c(context, hostToIp);
                    a(context, System.currentTimeMillis());
                }
                a11.mqttServerIP = hostToIp;
                return a11;
            } else if (a11.errCode == 10030006) {
                Logger.d("GuidInfoManagerImpl", "Get guidServer error GUID_SERVER_DESTROY, directly return");
                return a11;
            } else {
                Logger.i("GuidInfoManagerImpl", "Get guidServer error, guid == null;");
                GUIDInfo guidInfoFromShar = GUIDInfo.getGuidInfoFromShar(context);
                if (!guidInfoFromShar.isError()) {
                    a11 = guidInfoFromShar;
                }
                a11.mqttServerIP = e(context);
                return a11;
            }
        } else {
            Logger.i("GuidInfoManagerImpl", "GuidInfo not expired. Check mqttServer");
            String e11 = e(context);
            if (l(context)) {
                Logger.i("GuidInfoManagerImpl", "Mqtt expired. Last MqttServer address: " + e11);
                gUIDInfo = GUIDInfo.getGuidInfoFromShar(context);
                if (!Util.isNullOrEmptyString(gUIDInfo.mqttServer)) {
                    String hostToIp2 = DNSResolver.hostToIp(gUIDInfo.mqttServer, gUIDInfo.mqttPortList);
                    if (Util.isNullOrEmptyString(hostToIp2)) {
                        gUIDInfo.mqttServerIP = e11;
                        return gUIDInfo;
                    }
                    if (e11 != null) {
                        int lastIndexOf = e11.lastIndexOf(":");
                        int lastIndexOf2 = hostToIp2.lastIndexOf(":");
                        if (!(lastIndexOf > 0 ? e11.substring(0, lastIndexOf) : e11).equals(lastIndexOf2 > 0 ? hostToIp2.substring(0, lastIndexOf2) : hostToIp2)) {
                            Logger.w("GuidInfoManagerImpl", "MqttServerAddr changed, request guidServer for new one.");
                            GUIDInfo a12 = a(context, 1, (JSONObject) null, requestProxy);
                            if (GuidInfoManager.isServerDestroy(context)) {
                                Logger.e("GuidInfoManagerImpl", "Resources have been destroyed");
                                gUIDInfo.errCode = ErrCode.GUID_INFO_SERVER_DESTROY;
                                return gUIDInfo;
                            } else if (a12 == null || a12.isError()) {
                                Logger.i("GuidInfoManagerImpl", "Get new server guid error, get guid and finalMqttServerAddr from Shar");
                                gUIDInfo.mqttServerIP = e11;
                                return gUIDInfo;
                            } else {
                                if (!Util.isNullOrEmptyString(a12.mqttServer)) {
                                    String hostToIp3 = DNSResolver.hostToIp(a12.mqttServer, a12.mqttPortList);
                                    if (!Util.isNullOrEmptyString(hostToIp3)) {
                                        Logger.i("GuidInfoManagerImpl", "Get MqttServer: " + a12.mqttServer + ", save address: " + hostToIp3);
                                        c(context, hostToIp3);
                                        a(context, System.currentTimeMillis());
                                        e11 = hostToIp3;
                                    }
                                    gUIDInfo = a12;
                                } else {
                                    Logger.e("GuidInfoManagerImpl", "get new server guid error");
                                }
                                hostToIp2 = e11;
                            }
                        }
                    }
                    e11 = hostToIp2;
                } else {
                    Logger.e("GuidInfoManagerImpl", "get local GUIDInfo guid error");
                }
            } else {
                Logger.i("GuidInfoManagerImpl", "MqttServer not expired.");
                gUIDInfo = GUIDInfo.getGuidInfoFromShar(context);
            }
            if (gUIDInfo != null && !gUIDInfo.isError()) {
                if (!Util.isNullOrEmptyString(e11)) {
                    gUIDInfo.mqttServerIP = e11;
                } else if (!Util.isNullOrEmptyString(gUIDInfo.mqttServer)) {
                    gUIDInfo.mqttServerIP = gUIDInfo.mqttServer;
                }
            }
            Logger.i("GuidInfoManagerImpl", "Guid status: " + gUIDInfo);
            return gUIDInfo;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ all -> 0x006d }, LOOP:0: B:8:0x001b->B:10:0x0021, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031 A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[Catch:{ all -> 0x006d }, LOOP:1: B:15:0x0037->B:17:0x003f, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r4, java.lang.String r5) {
        /*
            if (r5 == 0) goto L_0x000f
            boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0009
            goto L_0x000f
        L_0x0009:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x006d }
            r0.<init>(r5)     // Catch:{ all -> 0x006d }
            goto L_0x0014
        L_0x000f:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
        L_0x0014:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x006d }
            r5.<init>()     // Catch:{ all -> 0x006d }
            r1 = 0
            r2 = r1
        L_0x001b:
            int r3 = r0.length()     // Catch:{ all -> 0x006d }
            if (r2 >= r3) goto L_0x002b
            java.lang.String r3 = r0.getString(r2)     // Catch:{ all -> 0x006d }
            r5.add(r3)     // Catch:{ all -> 0x006d }
            int r2 = r2 + 1
            goto L_0x001b
        L_0x002b:
            boolean r0 = r5.contains(r4)     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0034
            r5.remove(r4)     // Catch:{ all -> 0x006d }
        L_0x0034:
            r5.add(r1, r4)     // Catch:{ all -> 0x006d }
        L_0x0037:
            int r4 = r5.size()     // Catch:{ all -> 0x006d }
            r0 = 10
            if (r4 <= r0) goto L_0x0049
            int r4 = r5.size()     // Catch:{ all -> 0x006d }
            int r4 = r4 + -1
            r5.remove(r4)     // Catch:{ all -> 0x006d }
            goto L_0x0037
        L_0x0049:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x006d }
            r4.<init>(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "GuidInfoManagerImpl"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r1 = "Update tokenList: "
            r0.append(r1)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x006d }
            r0.append(r1)     // Catch:{ all -> 0x006d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006d }
            com.tencent.tpns.baseapi.base.util.Logger.i(r5, r0)     // Catch:{ all -> 0x006d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x006d }
            return r4
        L_0x006d:
            r4 = move-exception
            r4.printStackTrace()
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.b(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tpush.vip.service.shareprefs", 0).edit();
        edit.putString(b("XG_GUID_TOKEN"), str);
        edit.putString(b("XG_GUID_TOKEN_LIST"), str2);
        edit.commit();
    }

    public static long b(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_GUID", 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.Class<com.tencent.tpns.baseapi.core.b.a> r0 = com.tencent.tpns.baseapi.core.b.a.class
            monitor-enter(r0)
            boolean r1 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r5)     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            java.lang.String r1 = "GuidInfoManagerImpl"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r2.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "setLastResolvedGuidServerIP | lastGuidServerIp : "
            r2.append(r3)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = f49857d     // Catch:{ all -> 0x0040 }
            r2.append(r3)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "; newGuidServerIp : "
            r2.append(r3)     // Catch:{ all -> 0x0040 }
            r2.append(r5)     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0040 }
            com.tencent.tpns.baseapi.base.util.Logger.i(r1, r2)     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = f49857d     // Catch:{ all -> 0x0040 }
            boolean r1 = r5.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0040 }
            if (r1 != 0) goto L_0x003e
            f49857d = r5     // Catch:{ all -> 0x0040 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = "XG_LAST_RESOLVED_GUID_SERVER_IP"
            com.tencent.tpns.baseapi.base.PushPreferences.putString(r4, r1, r5)     // Catch:{ all -> 0x0040 }
        L_0x003e:
            monitor-exit(r0)
            return
        L_0x0040:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.b(android.content.Context, java.lang.String):void");
    }

    private static String b(String str) {
        return Util.getKey(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3 A[SYNTHETIC, Splitter:B:41:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c8 A[Catch:{ all -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3 A[Catch:{ all -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d4 A[Catch:{ all -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c3 A[SYNTHETIC, Splitter:B:76:0x01c3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.tpns.baseapi.base.device.GUIDInfo a(android.content.Context r29, int r30, org.json.JSONObject r31, com.tencent.tpns.baseapi.base.device.RequestProxy r32) {
        /*
            r1 = r29
            r2 = r32
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = "GUID server service code "
            java.lang.String r5 = ""
            com.tencent.tpns.baseapi.base.device.GUIDInfo r6 = new com.tencent.tpns.baseapi.base.device.GUIDInfo
            r6.<init>()
            r7 = -1
            java.lang.String r8 = "GuidInfoManagerImpl"
            if (r1 != 0) goto L_0x001c
            java.lang.String r0 = "context null"
            com.tencent.tpns.baseapi.base.util.Logger.e(r8, r0)
            r6.errCode = r7
            return r6
        L_0x001c:
            boolean r0 = com.tencent.tpns.baseapi.base.device.GuidInfoManager.isServerDestroy(r29)
            r9 = 10030006(0x990bb6, float:1.4055032E-38)
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = "refreshConnectInfoSynchronized: Resources have been destroyed"
            com.tencent.tpns.baseapi.base.util.Logger.e(r8, r0)
            r6.errCode = r9
            return r6
        L_0x002d:
            java.lang.String r0 = "action - refreshConnectInfoSynchronized"
            com.tencent.tpns.baseapi.base.util.Logger.d(r8, r0)
            long r10 = com.tencent.tpns.baseapi.XGApiConfig.getAccessId(r29)
            java.lang.String r12 = com.tencent.tpns.baseapi.XGApiConfig.getAccessKey(r29)
            boolean r0 = com.tencent.tpns.baseapi.base.util.Util.checkAccessId(r10)
            if (r0 == 0) goto L_0x043f
            boolean r0 = com.tencent.tpns.baseapi.base.util.Util.checkAccessKey(r12)
            if (r0 != 0) goto L_0x0048
            goto L_0x043f
        L_0x0048:
            long r13 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r15 = "RefreshTime: "
            r0.append(r15)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.tencent.tpns.baseapi.base.util.Logger.i(r8, r0)
            android.util.Pair r0 = r(r29)
            java.lang.Object r15 = r0.first
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r0 = r0.second
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r7 = "Send request to GuidServer: "
            r17 = r4
            if (r31 == 0) goto L_0x0078
            r4 = r31
        L_0x0075:
            r18 = r3
            goto L_0x008a
        L_0x0078:
            org.json.JSONObject r0 = b((android.content.Context) r1, (long) r13)     // Catch:{ all -> 0x007e }
            r4 = r0
            goto L_0x0075
        L_0x007e:
            r0 = move-exception
            r4 = r0
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ee(r8, r7, r4)
            r4 = -101(0xffffffffffffff9b, float:NaN)
            r6.errCode = r4
            r18 = r3
            r4 = 0
        L_0x008a:
            java.lang.String r3 = "token"
            if (r15 == 0) goto L_0x0091
            r4.put(r3, r15)     // Catch:{ all -> 0x00af }
        L_0x0091:
            boolean r0 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r9)     // Catch:{ all -> 0x00af }
            r31 = r3
            java.lang.String r3 = "tokenList"
            if (r0 != 0) goto L_0x00a6
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x00a4 }
            r0.<init>(r9)     // Catch:{ all -> 0x00a4 }
            r4.put(r3, r0)     // Catch:{ all -> 0x00a4 }
            goto L_0x00b9
        L_0x00a4:
            r0 = move-exception
            goto L_0x00b2
        L_0x00a6:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x00a4 }
            r0.<init>()     // Catch:{ all -> 0x00a4 }
            r4.put(r3, r0)     // Catch:{ all -> 0x00a4 }
            goto L_0x00b9
        L_0x00af:
            r0 = move-exception
            r31 = r3
        L_0x00b2:
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ee(r8, r7, r0)
            r3 = -101(0xffffffffffffff9b, float:NaN)
            r6.errCode = r3
        L_0x00b9:
            java.lang.String r0 = "XG_SDK_CHANNEL"
            java.lang.Object r0 = com.tencent.tpns.baseapi.base.util.CommonHelper.getMetaData(r1, r0, r5)     // Catch:{ all -> 0x00db }
            java.lang.String r3 = "none"
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00db }
            goto L_0x00c9
        L_0x00c8:
            r0 = r3
        L_0x00c9:
            java.lang.String r7 = r0.trim()     // Catch:{ all -> 0x00db }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00db }
            if (r7 == 0) goto L_0x00d4
            goto L_0x00d5
        L_0x00d4:
            r3 = r0
        L_0x00d5:
            java.lang.String r0 = "sdkChannel"
            r4.put(r0, r3)     // Catch:{ all -> 0x00db }
            goto L_0x00e1
        L_0x00db:
            r0 = move-exception
            java.lang.String r3 = "get sdk channel failed: "
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ee(r8, r3, r0)
        L_0x00e1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Send request to GuidServer with token: "
            r0.append(r3)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ii(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Send Guid request, params: "
            r0.append(r3)
            java.lang.String r3 = r4.toString()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.i(r8, r0)
            java.lang.String r3 = "\n "
            java.lang.String r0 = "Get response from GuidServer: "
            r7 = -502(0xfffffffffffffe0a, float:NaN)
            if (r2 == 0) goto L_0x016b
            boolean r15 = r32.hasProxy()
            if (r15 == 0) goto L_0x016b
            java.lang.String r15 = "use proxy request guidInfo"
            com.tencent.tpns.baseapi.base.util.Logger.i(r8, r15)
            org.json.JSONObject r2 = r2.onRegister(r4)     // Catch:{ all -> 0x0148 }
            if (r2 == 0) goto L_0x0145
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0148 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r4.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r15 = "Get response from proxy: "
            r4.append(r15)     // Catch:{ all -> 0x0142 }
            r4.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0142 }
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ii(r8, r4)     // Catch:{ all -> 0x0142 }
            r26 = r3
            goto L_0x01b8
        L_0x0142:
            r0 = move-exception
            r5 = r2
            goto L_0x0149
        L_0x0145:
            r6.errCode = r7     // Catch:{ all -> 0x0148 }
            return r6
        L_0x0148:
            r0 = move-exception
        L_0x0149:
            java.lang.String r1 = "use proxy request guidInfo fail, "
            com.tencent.tpns.baseapi.base.util.Logger.e(r8, r1, r0)
            r1 = -504(0xfffffffffffffe08, float:NaN)
            r6.errCode = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r3)
            java.lang.String r0 = com.tencent.tpns.baseapi.base.util.Util.getThrowableToString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6.result = r0
            return r6
        L_0x016b:
            java.lang.String r2 = com.tencent.tpns.baseapi.core.a.d(r29)
            java.lang.String r22 = com.tencent.tpns.baseapi.core.net.a.a((java.lang.String) r2)
            java.lang.String r15 = a((android.content.Context) r1, (java.lang.String) r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r26 = r3
            java.lang.String r3 = "Send to GuidServerIpAddr: "
            r7.append(r3)
            r7.append(r15)
            java.lang.String r3 = r7.toString()
            com.tencent.tpns.baseapi.base.util.Logger.i(r8, r3)
            com.tencent.tpns.baseapi.core.net.a r19 = com.tencent.tpns.baseapi.core.net.a.a((android.content.Context) r29)
            java.lang.String r23 = r4.toString()
            com.tencent.tpns.baseapi.core.b.a$1 r3 = new com.tencent.tpns.baseapi.core.b.a$1
            r3.<init>(r1, r13)
            r25 = 1
            r20 = r15
            r21 = r2
            r24 = r3
            java.lang.String r2 = r19.a(r20, r21, r22, r23, r24, r25)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ii(r8, r3)
        L_0x01b8:
            boolean r3 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r2)
            if (r3 == 0) goto L_0x01c3
            r3 = -502(0xfffffffffffffe0a, float:NaN)
            r6.errCode = r3
            return r6
        L_0x01c3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
            r3.<init>()     // Catch:{ all -> 0x041a }
            java.lang.String r4 = "cf5f04cd36"
            r3.append(r4)     // Catch:{ all -> 0x041a }
            r3.append(r10)     // Catch:{ all -> 0x041a }
            r3.append(r12)     // Catch:{ all -> 0x041a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x041a }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x041a }
            r4.<init>(r2)     // Catch:{ all -> 0x041a }
            java.lang.String r7 = "data"
            java.lang.String r7 = r4.optString(r7, r5)     // Catch:{ all -> 0x041a }
            boolean r12 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r7)     // Catch:{ all -> 0x041a }
            r15 = 0
            if (r12 != 0) goto L_0x0216
            byte[] r7 = android.util.Base64.decode(r7, r15)     // Catch:{ all -> 0x041a }
            r12 = r18
            byte[] r3 = r3.getBytes(r12)     // Catch:{ all -> 0x041a }
            byte[] r3 = com.tencent.tpns.baseapi.base.util.RC4.decrypt(r7, r3)     // Catch:{ all -> 0x041a }
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x041a }
            r7.<init>(r3, r12)     // Catch:{ all -> 0x041a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0212 }
            r2.<init>()     // Catch:{ all -> 0x0212 }
            java.lang.String r3 = "decode response:"
            r2.append(r3)     // Catch:{ all -> 0x0212 }
            r2.append(r7)     // Catch:{ all -> 0x0212 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0212 }
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.d(r8, r2)     // Catch:{ all -> 0x0212 }
            r2 = r7
            goto L_0x0216
        L_0x0212:
            r0 = move-exception
            r2 = r7
            goto L_0x041b
        L_0x0216:
            r6.result = r2     // Catch:{ all -> 0x041a }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x041a }
            r3.<init>(r2)     // Catch:{ all -> 0x041a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
            r7.<init>()     // Catch:{ all -> 0x041a }
            r7.append(r0)     // Catch:{ all -> 0x041a }
            r7.append(r2)     // Catch:{ all -> 0x041a }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x041a }
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.d(r8, r0)     // Catch:{ all -> 0x041a }
            java.lang.String r0 = "retCode"
            r7 = -1
            int r0 = r4.optInt(r0, r7)     // Catch:{ all -> 0x041a }
            java.lang.String r12 = "msg"
            java.lang.String r5 = r4.optString(r12, r5)     // Catch:{ all -> 0x041a }
            java.lang.String r12 = " error msg "
            if (r0 != r7) goto L_0x025f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
            r1.<init>()     // Catch:{ all -> 0x041a }
            java.lang.String r3 = "GUID server error code "
            r1.append(r3)     // Catch:{ all -> 0x041a }
            r1.append(r0)     // Catch:{ all -> 0x041a }
            r1.append(r12)     // Catch:{ all -> 0x041a }
            r1.append(r5)     // Catch:{ all -> 0x041a }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x041a }
            com.tencent.tpns.baseapi.base.util.Logger.e(r8, r0)     // Catch:{ all -> 0x041a }
            r0 = -502(0xfffffffffffffe0a, float:NaN)
            r6.errCode = r0     // Catch:{ all -> 0x041a }
            return r6
        L_0x025f:
            r18 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r7 = "penaltySeconds"
            r15 = 10030007(0x990bb7, float:1.4055033E-38)
            r20 = r10
            r10 = 0
            if (r0 == 0) goto L_0x02c8
            if (r0 != r15) goto L_0x026f
            goto L_0x02c8
        L_0x026f:
            r15 = 10030006(0x990bb6, float:1.4055032E-38)
            if (r0 != r15) goto L_0x02ab
            long r3 = r3.optLong(r7, r10)     // Catch:{ all -> 0x041a }
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            java.lang.String r7 = "XG_GUID_SERVER_PENALTY_TIME"
            if (r5 != 0) goto L_0x0282
            com.tencent.tpns.baseapi.base.PushPreferences.putLong(r1, r7, r10)     // Catch:{ all -> 0x041a }
            goto L_0x02a3
        L_0x0282:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
            r5.<init>()     // Catch:{ all -> 0x041a }
            java.lang.String r9 = "GUID destroy receive penaltySeconds: "
            r5.append(r9)     // Catch:{ all -> 0x041a }
            r5.append(r3)     // Catch:{ all -> 0x041a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x041a }
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ww(r8, r5)     // Catch:{ all -> 0x041a }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x041a }
            java.lang.Long.signum(r3)
            long r3 = r3 * r18
            long r9 = r9 + r3
            com.tencent.tpns.baseapi.base.PushPreferences.putLong(r1, r7, r9)     // Catch:{ all -> 0x041a }
        L_0x02a3:
            java.lang.String r1 = "GUID -> Server has been destroy"
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ww(r8, r1)     // Catch:{ all -> 0x041a }
            r6.errCode = r0     // Catch:{ all -> 0x041a }
            return r6
        L_0x02ab:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
            r1.<init>()     // Catch:{ all -> 0x041a }
            r15 = r17
            r1.append(r15)     // Catch:{ all -> 0x0417 }
            r1.append(r0)     // Catch:{ all -> 0x0417 }
            r1.append(r12)     // Catch:{ all -> 0x0417 }
            r1.append(r5)     // Catch:{ all -> 0x0417 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0417 }
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ee(r8, r1)     // Catch:{ all -> 0x0417 }
            r6.errCode = r0     // Catch:{ all -> 0x0417 }
            return r6
        L_0x02c8:
            r15 = r17
            com.tencent.tpns.baseapi.base.util.CloudManager r5 = com.tencent.tpns.baseapi.base.util.CloudManager.getInstance(r29)     // Catch:{ all -> 0x0417 }
            java.lang.String r12 = "cloud"
            r10 = 0
            java.lang.String r11 = r3.optString(r12, r10)     // Catch:{ all -> 0x0417 }
            r5.parseCloudConfig(r11, r13)     // Catch:{ all -> 0x0417 }
            r5 = r31
            java.lang.String r4 = r4.optString(r5, r10)     // Catch:{ all -> 0x0417 }
            java.lang.String r5 = "mqttServer"
            java.lang.String r5 = r3.optString(r5, r10)     // Catch:{ all -> 0x0417 }
            java.lang.String r11 = "userName"
            java.lang.String r11 = r3.optString(r11, r10)     // Catch:{ all -> 0x0417 }
            boolean r12 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r11)     // Catch:{ all -> 0x0417 }
            if (r12 == 0) goto L_0x02f6
            java.lang.String r11 = "mqttKey"
            java.lang.String r11 = r3.optString(r11, r10)     // Catch:{ all -> 0x0417 }
        L_0x02f6:
            java.lang.String r12 = "passWord"
            java.lang.String r12 = r3.optString(r12, r10)     // Catch:{ all -> 0x0417 }
            boolean r16 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r12)     // Catch:{ all -> 0x0417 }
            if (r16 == 0) goto L_0x0308
            java.lang.String r12 = "mqttSecret"
            java.lang.String r12 = r3.optString(r12, r10)     // Catch:{ all -> 0x0417 }
        L_0x0308:
            if (r4 == 0) goto L_0x03fc
            if (r5 == 0) goto L_0x03fc
            if (r11 == 0) goto L_0x03fc
            if (r12 != 0) goto L_0x0312
            goto L_0x03fc
        L_0x0312:
            java.lang.String r10 = "guid"
            r17 = r15
            r15 = 0
            int r10 = r3.optInt(r10, r15)     // Catch:{ all -> 0x041a }
            r16 = r2
            long r1 = (long) r10
            java.lang.String r10 = "expiredSeconds"
            r31 = r0
            r24 = r1
            r27 = r13
            r0 = 0
            long r13 = r3.optLong(r10, r0)     // Catch:{ all -> 0x03f8 }
            java.lang.String r0 = "encrypt"
            int r0 = r3.optInt(r0, r15)     // Catch:{ all -> 0x03f8 }
            r6.token = r4     // Catch:{ all -> 0x03f8 }
            java.lang.String r1 = "invalidTokenList"
            org.json.JSONArray r1 = r3.optJSONArray(r1)     // Catch:{ all -> 0x03f8 }
            if (r1 == 0) goto L_0x0354
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f8 }
            r2.<init>()     // Catch:{ all -> 0x03f8 }
            java.lang.String r10 = "Get invalidTokenList: "
            r2.append(r10)     // Catch:{ all -> 0x03f8 }
            r2.append(r1)     // Catch:{ all -> 0x03f8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03f8 }
            com.tencent.tpns.baseapi.base.util.Logger.i(r8, r2)     // Catch:{ all -> 0x03f8 }
            java.lang.String r9 = a((org.json.JSONArray) r1, (java.lang.String) r9)     // Catch:{ all -> 0x03f8 }
        L_0x0354:
            java.lang.String r1 = b((java.lang.String) r4, (java.lang.String) r9)     // Catch:{ all -> 0x03f8 }
            java.lang.String r2 = "mqttPortList"
            org.json.JSONArray r2 = r3.optJSONArray(r2)     // Catch:{ all -> 0x03f8 }
            if (r2 == 0) goto L_0x0366
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03f8 }
            r6.mqttPortList = r2     // Catch:{ all -> 0x03f8 }
        L_0x0366:
            r6.tokenList = r1     // Catch:{ all -> 0x03f8 }
            java.lang.String r2 = "sslMqttServer"
            r9 = 0
            java.lang.String r2 = r3.optString(r2, r9)     // Catch:{ all -> 0x03f8 }
            boolean r9 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r2)     // Catch:{ all -> 0x03f8 }
            if (r9 != 0) goto L_0x0378
            r6.mqttServer = r2     // Catch:{ all -> 0x03f8 }
            goto L_0x037a
        L_0x0378:
            r6.mqttServer = r5     // Catch:{ all -> 0x03f8 }
        L_0x037a:
            r6.passWord = r12     // Catch:{ all -> 0x03f8 }
            r6.userName = r11     // Catch:{ all -> 0x03f8 }
            r9 = r27
            r6.refreshTime = r9     // Catch:{ all -> 0x03f8 }
            r9 = r24
            r6.guid = r9     // Catch:{ all -> 0x03f8 }
            r6.expiredSeconds = r13     // Catch:{ all -> 0x03f8 }
            r9 = r20
            r6.guidLastAccessid = r9     // Catch:{ all -> 0x03f8 }
            r6.encrypt = r0     // Catch:{ all -> 0x03f8 }
            r0 = r31
            r2 = 10030007(0x990bb7, float:1.4055033E-38)
            if (r0 != r2) goto L_0x03d3
            java.lang.String r0 = "refuseRate"
            r2 = 0
            int r0 = r3.optInt(r0, r2)     // Catch:{ all -> 0x03f8 }
            r6.refuseRate = r0     // Catch:{ all -> 0x03f8 }
            r9 = 0
            long r2 = r3.optLong(r7, r9)     // Catch:{ all -> 0x03f8 }
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x03b0
            java.lang.String r0 = "XG_GUID_SERVER_ABANDON_PENALTY_TIME"
            r5 = r29
            com.tencent.tpns.baseapi.base.PushPreferences.putLong(r5, r0, r9)     // Catch:{ all -> 0x03f8 }
            goto L_0x03d8
        L_0x03b0:
            r5 = r29
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f8 }
            r0.<init>()     // Catch:{ all -> 0x03f8 }
            java.lang.String r7 = "GUID exceed receive penaltySeconds: "
            r0.append(r7)     // Catch:{ all -> 0x03f8 }
            r0.append(r2)     // Catch:{ all -> 0x03f8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03f8 }
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ww(r8, r0)     // Catch:{ all -> 0x03f8 }
            java.lang.String r0 = "XG_GUID_SERVER_ABANDON_PENALTY_TIME"
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03f8 }
            long r2 = r2 * r18
            long r9 = r9 + r2
            com.tencent.tpns.baseapi.base.PushPreferences.putLong(r5, r0, r9)     // Catch:{ all -> 0x03f8 }
            goto L_0x03d8
        L_0x03d3:
            r0 = 0
            r5 = r29
            r6.refuseRate = r0     // Catch:{ all -> 0x03f8 }
        L_0x03d8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f8 }
            r0.<init>()     // Catch:{ all -> 0x03f8 }
            java.lang.String r2 = "GUID -> write token: "
            r0.append(r2)     // Catch:{ all -> 0x03f8 }
            r2 = r16
            r0.append(r2)     // Catch:{ all -> 0x041a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x041a }
            com.tencent.tpns.baseapi.base.util.Logger.d(r8, r0)     // Catch:{ all -> 0x041a }
            r6.saveGuidToSha(r5)     // Catch:{ all -> 0x041a }
            com.tencent.tpns.baseapi.base.device.GuidInfoManager.updateTokenCache(r4)     // Catch:{ all -> 0x041a }
            b(r5, r4, r1)     // Catch:{ all -> 0x041a }
            return r6
        L_0x03f8:
            r0 = move-exception
            r2 = r16
            goto L_0x041b
        L_0x03fc:
            r17 = r15
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
            r0.<init>()     // Catch:{ all -> 0x041a }
            java.lang.String r1 = "GUID_INFO_INCOMPLETE, result: "
            r0.append(r1)     // Catch:{ all -> 0x041a }
            r0.append(r2)     // Catch:{ all -> 0x041a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x041a }
            com.tencent.tpns.baseapi.base.util.Logger.e(r8, r0)     // Catch:{ all -> 0x041a }
            r0 = -502(0xfffffffffffffe0a, float:NaN)
            r6.errCode = r0     // Catch:{ all -> 0x041a }
            return r6
        L_0x0417:
            r0 = move-exception
            r1 = r15
            goto L_0x041d
        L_0x041a:
            r0 = move-exception
        L_0x041b:
            r1 = r17
        L_0x041d:
            com.tencent.tpns.baseapi.base.util.Logger.e(r8, r1, r0)
            r1 = -503(0xfffffffffffffe09, float:NaN)
            r6.errCode = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r2 = r26
            r1.append(r2)
            java.lang.String r0 = com.tencent.tpns.baseapi.base.util.Util.getThrowableToString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6.result = r0
            return r6
        L_0x043f:
            r0 = -501(0xfffffffffffffe0b, float:NaN)
            r6.errCode = r0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.a(android.content.Context, int, org.json.JSONObject, com.tencent.tpns.baseapi.base.device.RequestProxy):com.tencent.tpns.baseapi.base.device.GUIDInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ all -> 0x005f }, LOOP:0: B:8:0x001b->B:10:0x0021, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031 A[Catch:{ all -> 0x005f }, LOOP:1: B:11:0x002b->B:13:0x0031, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(org.json.JSONArray r4, java.lang.String r5) {
        /*
            if (r5 == 0) goto L_0x000f
            boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0009
            goto L_0x000f
        L_0x0009:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x005f }
            r0.<init>(r5)     // Catch:{ all -> 0x005f }
            goto L_0x0014
        L_0x000f:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x005f }
            r0.<init>()     // Catch:{ all -> 0x005f }
        L_0x0014:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x005f }
            r5.<init>()     // Catch:{ all -> 0x005f }
            r1 = 0
            r2 = r1
        L_0x001b:
            int r3 = r0.length()     // Catch:{ all -> 0x005f }
            if (r2 >= r3) goto L_0x002b
            java.lang.String r3 = r0.getString(r2)     // Catch:{ all -> 0x005f }
            r5.add(r3)     // Catch:{ all -> 0x005f }
            int r2 = r2 + 1
            goto L_0x001b
        L_0x002b:
            int r0 = r4.length()     // Catch:{ all -> 0x005f }
            if (r1 >= r0) goto L_0x003b
            java.lang.String r0 = r4.getString(r1)     // Catch:{ all -> 0x005f }
            r5.remove(r0)     // Catch:{ all -> 0x005f }
            int r1 = r1 + 1
            goto L_0x002b
        L_0x003b:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x005f }
            r4.<init>(r5)     // Catch:{ all -> 0x005f }
            java.lang.String r5 = "GuidInfoManagerImpl"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r0.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r1 = "Update tokenList: "
            r0.append(r1)     // Catch:{ all -> 0x005f }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x005f }
            r0.append(r1)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005f }
            com.tencent.tpns.baseapi.base.util.Logger.i(r5, r0)     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005f }
            return r4
        L_0x005f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.a(org.json.JSONArray, java.lang.String):java.lang.String");
    }

    public static void a(String str) {
        f49855b = str;
    }

    public static String a(Context context, boolean z11) {
        if (!z11) {
            try {
                if (!TextUtils.isEmpty(f49855b)) {
                    return f49855b;
                }
            } catch (Throwable th2) {
                Logger.e("GuidInfoManagerImpl", "getToken Throwable: ", th2);
                return "";
            }
        }
        String string = PushPreferences.getString(context.getApplicationContext(), "XG_GUID_TOKEN", (String) null);
        f49855b = string;
        return string;
    }

    public static void a() {
        f49855b = null;
    }

    public static String a(Context context) {
        try {
            return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_TOKEN_LIST", (String) null);
        } catch (Throwable th2) {
            Logger.e("GuidInfoManagerImpl", "getGuid Throwable: ", th2);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075 A[Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getGuidServerIPAddress | XGConfig guidServerHostAddr : "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "GuidInfoManagerImpl"
            com.tencent.tpns.baseapi.base.util.Logger.d(r2, r1)
            if (r9 != 0) goto L_0x001b
            return r10
        L_0x001b:
            r1 = 0
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            r4.<init>(r10)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r4 = r4.getHost()     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.net.InetAddress r4 = java.net.InetAddress.getByName(r4)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            boolean r5 = r4 instanceof java.net.Inet6Address     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            if (r5 == 0) goto L_0x004d
            if (r4 == 0) goto L_0x004b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            r5.<init>()     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r6 = "["
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r4 = r4.getHostAddress()     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            r5.append(r4)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r4 = "]"
            r5.append(r4)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r4 = r5.toString()     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            goto L_0x0053
        L_0x004b:
            r4 = r0
            goto L_0x0053
        L_0x004d:
            if (r4 == 0) goto L_0x004b
            java.lang.String r4 = r4.getHostAddress()     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
        L_0x0053:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            r5.<init>()     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r6 = "getGuidServerIPAddress | update lastResolvedGuidServerIP , guidServerIPAddr : "
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            r5.append(r0)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r6 = "; guidServerIp : "
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            r5.append(r4)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            java.lang.String r5 = r5.toString()     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            com.tencent.tpns.baseapi.base.util.Logger.d(r2, r5)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            if (r5 != 0) goto L_0x0078
            com.tencent.tpns.baseapi.base.device.GuidInfoManager.setLastResolvedGuidServerIP(r9, r4)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
        L_0x0078:
            java.lang.String r0 = a((java.lang.String) r10, (java.lang.String) r4)     // Catch:{ UnknownHostException -> 0x0081, all -> 0x007d }
            goto L_0x0084
        L_0x007d:
            r1 = move-exception
            r3 = -505(0xfffffffffffffe07, float:NaN)
            goto L_0x0084
        L_0x0081:
            r1 = move-exception
            r3 = -506(0xfffffffffffffe06, float:NaN)
        L_0x0084:
            r4 = r3
            if (r1 == 0) goto L_0x00d3
            java.lang.String r0 = d(r9, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "getGuidServerAddress | exception "
            r10.append(r3)
            java.lang.String r3 = r1.toString()
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ee(r2, r10, r1)
            boolean r10 = f49856c
            if (r10 != 0) goto L_0x00d3
            boolean r10 = com.tencent.tpns.baseapi.base.util.NetworkUtil.isNetworkConnected(r9)
            if (r10 == 0) goto L_0x00ce
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "GUID DNS Throw Error: "
            r10.append(r3)
            java.lang.String r1 = r1.getMessage()
            r10.append(r1)
            java.lang.String r5 = r10.toString()
            r6 = 0
            java.lang.String r8 = ""
            r3 = r9
            com.tencent.tpns.baseapi.base.util.StatHelper.reportErrCode(r3, r4, r5, r6, r8)
            r9 = 1
            f49856c = r9
            goto L_0x00d3
        L_0x00ce:
            java.lang.String r9 = "getGuidServerAddress Throw Error: network unavailable"
            com.tencent.tpns.baseapi.base.util.Logger.w(r2, r9)
        L_0x00d3:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "getGuidServerIPAddress | result guidServerIPAddress : "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.tencent.tpns.baseapi.base.util.Logger.d(r2, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        String str3 = "";
        try {
            Matcher matcher = Pattern.compile("(?<=//|)((\\w|-)+\\.)+(\\w|-)+(:\\d*)?").matcher(str);
            if (matcher.find()) {
                str3 = matcher.group();
            }
            String replace = str.replace(str3, str2);
            Logger.d("GuidInfoManagerImpl", "replaceHostWithIp | host : " + str3 + "; ipAddr : " + replace);
            return replace;
        } catch (Throwable th2) {
            TBaseLogger.ee("GuidInfoManagerImpl", "replaceHostWithIp exception ", th2);
            return str;
        }
    }

    public static void a(Context context, long j11) {
        Logger.i("GuidInfoManagerImpl", "Last time: " + f49861h + ", this time: " + j11);
        if (f49861h != j11) {
            Logger.i("GuidInfoManagerImpl", "Save mqttServerLastRefreshTime: " + j11);
            f49861h = j11;
            PushPreferences.putLong(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", j11);
        }
    }

    public static void a(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        PushPreferences.putString(context, "XG_GUID_TOKEN", str2);
        PushPreferences.putString(context, "XG_GUID_MQTT_SERVER", str);
        PushPreferences.putString(context, "XG_GUID_MQTT_USERNAME", "c34c9f3c514aa3560c38f74407f1a5bb");
        PushPreferences.putString(context, "XG_GUID_MQTT_PASSWORD", "9d8afb2ae393e47e7f3bbd254ed8c72e");
        PushPreferences.putLong(context, "XG_GUID_EXPIRED_SECONDS", 172800);
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", currentTimeMillis);
    }
}
