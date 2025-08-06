package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.m;

public class co {

    /* renamed from: a  reason: collision with root package name */
    private static int f51505a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static cs f2615a;

    /* renamed from: a  reason: collision with other field name */
    private static String f2616a;

    public static void a(Context context, fb fbVar) {
        if (a(context)) {
            if (f2615a == null) {
                f2615a = new cs(context);
            }
            fbVar.a((fe) f2615a);
            a("startStats");
        }
    }

    public static void b(Context context, fb fbVar) {
        cs csVar = f2615a;
        if (csVar != null) {
            fbVar.b((fe) csVar);
            f2615a = null;
            a("stopStats");
        }
    }

    private static synchronized void b(String str) {
        synchronized (co.class) {
            if ("WIFI-ID-UNKNOWN".equals(str)) {
                String str2 = f2616a;
                if (str2 == null || !str2.startsWith("W-")) {
                    f2616a = null;
                }
            } else {
                f2616a = str;
            }
            a("updateNetId new networkId = " + str + ", finally netId = " + f2616a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2498a(Context context) {
        return cl.a(context);
    }

    public static void a(Context context, String str, int i11) {
        if (!a(context)) {
            a("onDisconnection shouldSampling = false");
            return;
        }
        Context context2 = context;
        String str2 = str;
        int i12 = i11;
        cr.a(context2, str2, av.b(context), System.currentTimeMillis(), i12, m.a(context).b(), a(context), a(), f51505a);
        a("onDisconnection");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2497a(Context context) {
        if (!a(context)) {
            a("onReconnection shouldSampling = false");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f51505a = a(context);
        cr.a(context, currentTimeMillis);
        a("onReconnection connectedNetworkType = " + f51505a);
    }

    public static void a(Context context, String str) {
        if (!a(context)) {
            a("onWifiChanged shouldSampling = false");
            return;
        }
        a("onWifiChanged wifiDigest = " + str);
        if (!TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [com.xiaomi.push.aw] */
    private static int a(Context context) {
        String str;
        try {
            ? a11 = av.a();
            if (a11 == 0) {
                b((String) null);
                return -1;
            } else if (a11.a() == 0) {
                String b11 = a11.b();
                if (TextUtils.isEmpty(b11) || GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(b11)) {
                    str = null;
                } else {
                    str = "M-" + b11;
                }
                b(str);
                return 0;
            } else {
                if (a11.a() != 1) {
                    if (a11.a() != 6) {
                        b((String) null);
                        return -1;
                    }
                }
                b("WIFI-ID-UNKNOWN");
                return 1;
            }
        } catch (Exception e11) {
            b.d("DisconnectStatsHelper getNetType occurred error: " + e11.getMessage());
            b((String) null);
            return -1;
        }
    }

    private static synchronized String a() {
        String str;
        synchronized (co.class) {
            str = f2616a;
        }
        return str;
    }

    public static void a(String str) {
        cl.a("Push-DiscntStats", str);
    }
}
