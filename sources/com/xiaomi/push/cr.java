package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.vulcan.model.VulcanInfo;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.channel.commonutils.logger.b;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class cr {

    /* renamed from: a  reason: collision with root package name */
    private static int f51527a;

    private static int a(boolean z11) {
        return z11 ? 1 : 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static SharedPreferences m2505a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    /* access modifiers changed from: private */
    public static synchronized void c(Context context, String str, boolean z11, long j11, int i11, long j12, int i12, String str2, int i13) {
        long j13 = j11;
        synchronized (cr.class) {
            SharedPreferences a11 = a(context);
            long j14 = a11.getLong("start_time_for_day", 0);
            if (j14 == 0) {
                co.a("recordDisconnection not initialized");
            } else if (j13 - a11.getLong("last_discnt_time", 0) < 60000) {
                co.a("recordDisconnection anti-shake");
            } else {
                if (j13 - j14 < Period.DAY_MILLS) {
                    int i14 = a11.getInt("discnt_count_in_day", 0);
                    if (i14 > 100) {
                        co.a("recordDisconnection count > 100 in 24H cycle,abandon.");
                        return;
                    } else {
                        a11.edit().putInt("discnt_count_in_day", i14 + 1).apply();
                    }
                } else {
                    co.a("recordDisconnection with the current time exceeds 24H cycle, go on.");
                }
                int i15 = a11.getInt("discnt_count", 0);
                if (i15 == a11.getInt("cnt_count", 0)) {
                    a(context, str, a(z11), j11, i11, j12, i12, str2, i13);
                    a11.edit().putLong("last_discnt_time", j13).putInt("discnt_count", i15 + 1).apply();
                }
                co.a("recordDisconnection complete");
            }
        }
    }

    public static void a(Context context, String str, boolean z11, long j11, int i11, long j12, int i12, String str2, int i13) {
        final Context context2 = context;
        final String str3 = str;
        final boolean z12 = z11;
        final long j13 = j11;
        final int i14 = i11;
        final long j14 = j12;
        final int i15 = i12;
        final String str4 = str2;
        final int i16 = i13;
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    cr.c(context2, str3, z12, j13, i14, j14, i15, str4, i16);
                } catch (Exception e11) {
                    b.a("DisconnectStatsSP onDisconnection exception: " + e11.getMessage());
                }
            }
        });
    }

    public static void a(final Context context, final long j11) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    cr.c(context, j11);
                } catch (Exception e11) {
                    b.a("DisconnectStatsSP onReconnection exception: " + e11.getMessage());
                }
            }
        });
    }

    private static void b(Context context) {
        co.a("resetAfterUpload");
        a(context).edit().putString(VulcanInfo.HOST, (String) null).putString("network_state", (String) null).putString(Constants.REASON, (String) null).putString("ping_interval", (String) null).putString("network_type", (String) null).putString("wifi_digest", (String) null).putString("connected_network_type", (String) null).putString("disconnect_time", (String) null).putString("connected_time", (String) null).putLong("last_discnt_time", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", (String) null).putString("android_vc", (String) null).apply();
    }

    private static void a(Context context, String str, int i11, long j11, int i12, long j12, int i13, String str2, int i14) {
        String str3 = str;
        String str4 = str2;
        co.a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", new Object[]{str3, Integer.valueOf(i11), Long.valueOf(j11), Integer.valueOf(i12), Long.valueOf(j12), Integer.valueOf(i13), str4, Integer.valueOf(i14)}));
        SharedPreferences a11 = a(context);
        String string = a11.getString(VulcanInfo.HOST, (String) null);
        String string2 = a11.getString("network_state", (String) null);
        String string3 = a11.getString(Constants.REASON, (String) null);
        String string4 = a11.getString("ping_interval", (String) null);
        String string5 = a11.getString("network_type", (String) null);
        String string6 = a11.getString("wifi_digest", (String) null);
        String string7 = a11.getString("connected_network_type", (String) null);
        String string8 = a11.getString("disconnect_time", (String) null);
        String str5 = Constants.REASON;
        String string9 = a11.getString("xmsf_vc", (String) null);
        String string10 = a11.getString("android_vc", (String) null);
        String a12 = a(string, str3);
        String a13 = a(string2, i11);
        String a14 = a(string3, i12);
        String str6 = a13;
        String a15 = a(string4, j12);
        String a16 = a(string5, i13);
        String a17 = a(string6, str4);
        String a18 = a(string7, i14);
        String a19 = a(string8, j11);
        String a21 = a(string9, a(context));
        a11.edit().putString(VulcanInfo.HOST, a12).putString("network_state", str6).putString(str5, a14).putString("ping_interval", a15).putString("network_type", a16).putString("wifi_digest", a17).putString("connected_network_type", a18).putString("disconnect_time", a19).putString("xmsf_vc", a21).putString("android_vc", a(string10, Build.VERSION.SDK_INT)).apply();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void c(android.content.Context r10, long r11) {
        /*
            java.lang.Class<com.xiaomi.push.cr> r0 = com.xiaomi.push.cr.class
            monitor-enter(r0)
            android.content.SharedPreferences r1 = a((android.content.Context) r10)     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = "start_time_for_day"
            r3 = 0
            long r5 = r1.getLong(r2, r3)     // Catch:{ all -> 0x0092 }
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r7 = 0
            if (r2 != 0) goto L_0x003b
            android.content.SharedPreferences$Editor r10 = r1.edit()     // Catch:{ all -> 0x0092 }
            java.lang.String r1 = "start_time_for_day"
            android.content.SharedPreferences$Editor r10 = r10.putLong(r1, r11)     // Catch:{ all -> 0x0092 }
            java.lang.String r11 = "last_discnt_time"
            android.content.SharedPreferences$Editor r10 = r10.putLong(r11, r3)     // Catch:{ all -> 0x0092 }
            java.lang.String r11 = "discnt_count_in_day"
            android.content.SharedPreferences$Editor r10 = r10.putInt(r11, r7)     // Catch:{ all -> 0x0092 }
            java.lang.String r11 = "discnt_count"
            android.content.SharedPreferences$Editor r10 = r10.putInt(r11, r7)     // Catch:{ all -> 0x0092 }
            java.lang.String r11 = "cnt_count"
            android.content.SharedPreferences$Editor r10 = r10.putInt(r11, r7)     // Catch:{ all -> 0x0092 }
            r10.apply()     // Catch:{ all -> 0x0092 }
            monitor-exit(r0)
            return
        L_0x003b:
            java.lang.String r2 = "discnt_count"
            int r2 = r1.getInt(r2, r7)     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = "cnt_count"
            int r3 = r1.getInt(r3, r7)     // Catch:{ all -> 0x0092 }
            if (r2 <= r3) goto L_0x0069
            int r3 = r3 + 1
            java.lang.String r4 = "connected_time"
            r8 = 0
            java.lang.String r4 = r1.getString(r4, r8)     // Catch:{ all -> 0x0092 }
            java.lang.String r4 = a((java.lang.String) r4, (long) r11)     // Catch:{ all -> 0x0092 }
            android.content.SharedPreferences$Editor r8 = r1.edit()     // Catch:{ all -> 0x0092 }
            java.lang.String r9 = "cnt_count"
            android.content.SharedPreferences$Editor r3 = r8.putInt(r9, r3)     // Catch:{ all -> 0x0092 }
            java.lang.String r8 = "connected_time"
            android.content.SharedPreferences$Editor r3 = r3.putString(r8, r4)     // Catch:{ all -> 0x0092 }
            r3.apply()     // Catch:{ all -> 0x0092 }
        L_0x0069:
            long r3 = r11 - r5
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0089
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = "start_time_for_day"
            android.content.SharedPreferences$Editor r11 = r1.putLong(r2, r11)     // Catch:{ all -> 0x0092 }
            java.lang.String r12 = "discnt_count_in_day"
            android.content.SharedPreferences$Editor r11 = r11.putInt(r12, r7)     // Catch:{ all -> 0x0092 }
            r11.apply()     // Catch:{ all -> 0x0092 }
            a((android.content.Context) r10)     // Catch:{ all -> 0x0092 }
            goto L_0x0090
        L_0x0089:
            r11 = 10
            if (r2 < r11) goto L_0x0090
            a((android.content.Context) r10)     // Catch:{ all -> 0x0092 }
        L_0x0090:
            monitor-exit(r0)
            return
        L_0x0092:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cr.c(android.content.Context, long):void");
    }

    private static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = OptionsBridge.NULL_VALUE;
        }
        if (str == null || str.length() <= 0) {
            return str2;
        }
        return str + ";" + str2;
    }

    private static String a(String str, int i11) {
        return a(str, String.valueOf(i11));
    }

    private static String a(String str, long j11) {
        return a(str, String.valueOf(j11));
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m2507a(Context context) {
        co.a("upload");
        new cq().a(context, a(context));
        b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static List<cp> m2506a(Context context) {
        SharedPreferences a11 = a(context);
        String[] a12 = a(a11.getString(VulcanInfo.HOST, (String) null));
        if (a12 == null || a12.length <= 0) {
            b.a("DisconnectStatsSP Cached hosts data is empty,drop.");
            return null;
        }
        String[] a13 = a(a11.getString("network_state", (String) null));
        String[] a14 = a(a11.getString(Constants.REASON, (String) null));
        String[] a15 = a(a11.getString("ping_interval", (String) null));
        String[] a16 = a(a11.getString("network_type", (String) null));
        String[] a17 = a(a11.getString("wifi_digest", (String) null));
        String[] a18 = a(a11.getString("connected_network_type", (String) null));
        String[] a19 = a(a11.getString("disconnect_time", (String) null));
        String[] a21 = a(a11.getString("connected_time", (String) null));
        String[] a22 = a(a11.getString("xmsf_vc", (String) null));
        String[] a23 = a(a11.getString("android_vc", (String) null));
        if (a13 == null || a14 == null || a15 == null || a16 == null || a17 == null || a18 == null || a19 == null || a21 == null || a22 == null || a23 == null || a12.length != a13.length || a12.length != a14.length || a12.length != a15.length || a12.length != a16.length || a12.length != a17.length || a12.length != a18.length || a12.length != a19.length || a12.length != a21.length || a12.length != a22.length || a12.length != a23.length) {
            b.a("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        ArrayList arrayList = new ArrayList(a12.length);
        int i11 = 0;
        while (i11 < a12.length) {
            cp cpVar = new cp();
            cpVar.a(1);
            cpVar.a(a12[i11]);
            cpVar.b(t.a(a13[i11], -1));
            cpVar.c(t.a(a14[i11], -1));
            String[] strArr = a13;
            String[] strArr2 = a12;
            cpVar.a(t.a(a15[i11], -1));
            cpVar.d(t.a(a16[i11], -1));
            cpVar.b(a17[i11]);
            cpVar.e(t.a(a18[i11], -1));
            long a24 = t.a(a19[i11], -1);
            long a25 = t.a(a21[i11], -1);
            cpVar.b(a25 - a24);
            cpVar.c(a24);
            cpVar.d(a25);
            cpVar.f(t.a(a22[i11], -1));
            cpVar.g(t.a(a23[i11], -1));
            ArrayList arrayList2 = arrayList;
            arrayList2.add(cpVar);
            i11++;
            a13 = strArr;
            arrayList = arrayList2;
            a15 = a15;
            a14 = a14;
            a12 = strArr2;
            a16 = a16;
        }
        return arrayList;
    }

    private static String[] a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    private static int a(Context context) {
        if (f51527a <= 0) {
            f51527a = j.b(context);
        }
        return f51527a;
    }
}
