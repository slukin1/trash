package com.tencent.tpns.baseapi.base.device;

import android.content.Context;
import com.tencent.tpns.baseapi.core.b.a;
import org.json.JSONObject;

public class GuidInfoManager {

    /* renamed from: a  reason: collision with root package name */
    private static RequestProxy f49754a;

    public static void clearGuidInfo(Context context) {
        a.n(context);
    }

    public static void clearTokenCache() {
        a.a();
    }

    public static void forceExpired(Context context) {
        a.m(context);
    }

    public static int getEncryptLevel(Context context) {
        return a.q(context);
    }

    public static long getExpiredSeconds(Context context) {
        return a.h(context);
    }

    public static GUIDInfo getFinalGuidInfo(Context context, boolean z11, String str) {
        return a.a(context, z11, str, f49754a);
    }

    public static long getGuid(Context context) {
        return a.b(context);
    }

    public static long getLastRefreshTime(Context context) {
        return a.i(context);
    }

    public static synchronized String getLastResolvedGuidServerIP(Context context) {
        String d11;
        synchronized (GuidInfoManager.class) {
            d11 = a.d(context);
        }
        return d11;
    }

    public static String getMqttPassword(Context context) {
        return a.g(context);
    }

    public static String getMqttServer(Context context) {
        return a.c(context);
    }

    public static synchronized String getMqttServerIP(Context context) {
        String e11;
        synchronized (GuidInfoManager.class) {
            e11 = a.e(context);
        }
        return e11;
    }

    public static synchronized long getMqttServerRefreshTime(Context context) {
        long k11;
        synchronized (GuidInfoManager.class) {
            k11 = a.k(context);
        }
        return k11;
    }

    public static String getMqttUserName(Context context) {
        return a.f(context);
    }

    public static int getRefuseRate(Context context) {
        return a.p(context);
    }

    public static String getServerIPAddress(Context context, String str) {
        return a.a(context, str);
    }

    public static String getToken(Context context) {
        return a.a(context, false);
    }

    public static String getTokenFromFile(Context context) {
        return a.a(context, true);
    }

    public static String getTokenList(Context context) {
        return a.a(context);
    }

    public static boolean isExpired(Context context) {
        return a.j(context);
    }

    public static boolean isMqttServerExpired(Context context) {
        return a.l(context);
    }

    public static boolean isServerDestroy(Context context) {
        return a.o(context);
    }

    public static synchronized GUIDInfo refreshConnectInfoSynchronized(Context context, int i11, RefreshCallback refreshCallback, RequestProxy requestProxy) {
        GUIDInfo a11;
        synchronized (GuidInfoManager.class) {
            a11 = a.a(context, i11, (JSONObject) null, requestProxy);
        }
        return a11;
    }

    public static synchronized void setLastResolvedGuidServerIP(Context context, String str) {
        synchronized (GuidInfoManager.class) {
            a.b(context, str);
        }
    }

    public static synchronized void setMqttServerIP(Context context, String str) {
        synchronized (GuidInfoManager.class) {
            a.c(context, str);
        }
    }

    public static synchronized void setMqttServerRefreshTime(Context context, long j11) {
        synchronized (GuidInfoManager.class) {
            a.a(context, j11);
        }
    }

    public static void setRequestProxy(RequestProxy requestProxy) {
        f49754a = requestProxy;
    }

    public static void updateTokenCache(String str) {
        a.a(str);
    }

    public static void wrtieDebugInfo(Context context, String str, String str2) {
        a.a(context, str, str2);
    }
}
