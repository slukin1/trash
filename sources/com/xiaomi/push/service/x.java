package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.push.ax;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.gt;
import com.xiaomi.push.hc;
import com.xiaomi.push.j;
import com.xiaomi.push.service.ae;
import com.xiaomi.push.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public static long f52606a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile ab f3432a;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, hc>> f3433a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f3434a = Executors.newCachedThreadPool();

    public static class a implements Callable<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private Context f52608a;

        /* renamed from: a  reason: collision with other field name */
        private String f3437a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f3438a;

        public a(String str, Context context, boolean z11) {
            this.f52608a = context;
            this.f3437a = str;
            this.f3438a = z11;
        }

        /* renamed from: a */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.f3437a)) {
                com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            } else if (this.f3437a.startsWith("http")) {
                ae.b a11 = ae.a(this.f52608a, this.f3437a, this.f3438a);
                if (a11 != null) {
                    return a11.f3322a;
                }
                com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource");
                return null;
            } else {
                Bitmap a12 = ae.a(this.f52608a, this.f3437a);
                if (a12 != null) {
                    return a12;
                }
                com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource");
                return a12;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f52609a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Notification f3439a;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f52610a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f3440a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3441a = false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3060a(Context context, String str) {
        return g.b(context, str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m3067b(Map<String, String> map) {
        if (map != null) {
            return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.a("meta extra is null");
        return false;
    }

    public static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(hc hcVar) {
        return hcVar.a() == gg.Registration;
    }

    public static boolean e(hc hcVar) {
        return a(hcVar) || c(hcVar) || b(hcVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3061a(Context context, String str, boolean z11) {
        if (j.a() && !z11 && a(context, str)) {
            return true;
        }
        return false;
    }

    public static boolean c(hc hcVar) {
        gt a11 = hcVar.a();
        return a(a11) && a11.f2979b == 0 && !a(hcVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.push.service.x.c m3058a(android.content.Context r22, com.xiaomi.push.hc r23, byte[] r24) {
        /*
            r7 = r22
            r8 = r23
            com.xiaomi.push.service.x$c r9 = new com.xiaomi.push.service.x$c
            r9.<init>()
            java.lang.String r0 = a((com.xiaomi.push.hc) r23)
            r10 = 1
            com.xiaomi.push.g$b r0 = com.xiaomi.push.g.a((android.content.Context) r7, (java.lang.String) r0, (boolean) r10)
            com.xiaomi.push.gt r11 = r23.a()
            r12 = 0
            r13 = 0
            if (r11 == 0) goto L_0x0024
            int r1 = r11.c()
            java.util.Map r2 = r11.a()
            r14 = r2
            goto L_0x0026
        L_0x0024:
            r1 = r12
            r14 = r13
        L_0x0026:
            java.lang.String r2 = a((com.xiaomi.push.hc) r23)
            int r15 = com.xiaomi.push.t.b(r2, r1)
            boolean r1 = com.xiaomi.push.j.a((android.content.Context) r22)
            if (r1 == 0) goto L_0x0084
            com.xiaomi.push.g$b r1 = com.xiaomi.push.g.b.NOT_ALLOWED
            if (r0 != r1) goto L_0x0084
            if (r11 == 0) goto L_0x0066
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r1 = r23.b()
            java.lang.String r2 = b((com.xiaomi.push.hc) r23)
            java.lang.String r3 = r11.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "10:"
            r4.append(r5)
            java.lang.String r5 = a((com.xiaomi.push.hc) r23)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x0066:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Do not notify because user block "
            r0.append(r1)
            java.lang.String r1 = a((com.xiaomi.push.hc) r23)
            r0.append(r1)
            java.lang.String r1 = "‘s notification"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            return r9
        L_0x0084:
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r22)
            if (r0 == 0) goto L_0x00ce
            com.xiaomi.push.service.ab r0 = f3432a
            if (r0 == 0) goto L_0x00ce
            com.xiaomi.push.service.ab r0 = f3432a
            java.lang.String r1 = a((com.xiaomi.push.hc) r23)
            boolean r0 = r0.a((android.content.Context) r7, (int) r15, (java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r14)
            if (r0 == 0) goto L_0x00ce
            if (r11 == 0) goto L_0x00c8
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r1 = r23.b()
            java.lang.String r2 = b((com.xiaomi.push.hc) r23)
            java.lang.String r3 = r11.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "14:"
            r4.append(r5)
            java.lang.String r5 = a((com.xiaomi.push.hc) r23)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x00c8:
            java.lang.String r0 = "Do not notify because card notification is canceled or sequence incorrect"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            return r9
        L_0x00ce:
            android.widget.RemoteViews r0 = a((android.content.Context) r22, (com.xiaomi.push.hc) r23, (byte[]) r24)
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            java.lang.String r3 = r23.b()
            r1 = r22
            r2 = r23
            r4 = r24
            r5 = r15
            r16 = r6
            android.app.PendingIntent r5 = a((android.content.Context) r1, (com.xiaomi.push.hc) r2, (java.lang.String) r3, (byte[]) r4, (int) r5, (android.os.Bundle) r6)
            if (r5 != 0) goto L_0x010b
            if (r11 == 0) goto L_0x0105
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r1 = r23.b()
            java.lang.String r2 = b((com.xiaomi.push.hc) r23)
            java.lang.String r3 = r11.a()
            java.lang.String r4 = "11"
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x0105:
            java.lang.String r0 = "The click PendingIntent is null. "
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            return r9
        L_0x010b:
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r0
            r6 = r15
            com.xiaomi.push.service.x$b r0 = a((android.content.Context) r1, (com.xiaomi.push.hc) r2, (byte[]) r3, (android.widget.RemoteViews) r4, (android.app.PendingIntent) r5, (int) r6)
            long r1 = r0.f52609a
            r9.f52610a = r1
            java.lang.String r1 = a((com.xiaomi.push.hc) r23)
            r9.f3440a = r1
            android.app.Notification r1 = r0.f3439a
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r22)
            if (r0 == 0) goto L_0x013f
            if (r1 == 0) goto L_0x013f
            android.os.Bundle r0 = r1.extras
            if (r0 == 0) goto L_0x013f
            if (r14 == 0) goto L_0x013f
            r2 = r16
            r0.putAll(r2)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "use_clicked_activity"
            java.lang.String r3 = "xmsf.stat.useNCA"
            com.xiaomi.push.service.ag.a((java.util.Map<java.lang.String, java.lang.String>) r14, (android.os.Bundle) r0, (java.lang.String) r2, (java.lang.String) r3, (boolean) r12)
        L_0x013f:
            boolean r0 = com.xiaomi.push.j.a()
            if (r0 == 0) goto L_0x01cb
            java.lang.String r0 = r11.a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x015a
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "message_id"
            java.lang.String r3 = r11.a()
            r0.putString(r2, r3)
        L_0x015a:
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "local_paid"
            java.lang.String r3 = r23.a()
            r0.putString(r2, r3)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "msg_busi_type"
            com.xiaomi.push.service.ag.a((java.util.Map<java.lang.String, java.lang.String>) r14, (android.os.Bundle) r0, (java.lang.String) r2)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "disable_notification_flags"
            com.xiaomi.push.service.ag.a((java.util.Map<java.lang.String, java.lang.String>) r14, (android.os.Bundle) r0, (java.lang.String) r2)
            java.util.Map r0 = r11.b()
            if (r0 != 0) goto L_0x017b
            r0 = r13
            goto L_0x0187
        L_0x017b:
            java.util.Map r0 = r11.b()
            java.lang.String r2 = "score_info"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
        L_0x0187:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0194
            android.os.Bundle r2 = r1.extras
            java.lang.String r3 = "score_info"
            r2.putString(r3, r0)
        L_0x0194:
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "pushUid"
            java.util.Map<java.lang.String, java.lang.String> r3 = r11.f2977a
            java.lang.String r4 = "n_stats_expose"
            java.lang.String r3 = a((java.util.Map<java.lang.String, java.lang.String>) r3, (java.lang.String) r4)
            r0.putString(r2, r3)
            r0 = -1
            boolean r2 = c((com.xiaomi.push.hc) r23)
            if (r2 == 0) goto L_0x01ad
            r0 = 1000(0x3e8, float:1.401E-42)
            goto L_0x01b5
        L_0x01ad:
            boolean r2 = a((com.xiaomi.push.hc) r23)
            if (r2 == 0) goto L_0x01b5
            r0 = 3000(0xbb8, float:4.204E-42)
        L_0x01b5:
            android.os.Bundle r2 = r1.extras
            java.lang.String r3 = "eventMessageType"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.putString(r3, r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "target_package"
            java.lang.String r3 = a((com.xiaomi.push.hc) r23)
            r0.putString(r2, r3)
        L_0x01cb:
            java.util.Map r0 = r11.a()
            if (r0 != 0) goto L_0x01d2
            goto L_0x01df
        L_0x01d2:
            java.util.Map r0 = r11.a()
            java.lang.String r2 = "message_count"
            java.lang.Object r0 = r0.get(r2)
            r13 = r0
            java.lang.String r13 = (java.lang.String) r13
        L_0x01df:
            boolean r0 = com.xiaomi.push.j.a()
            if (r0 == 0) goto L_0x021d
            if (r13 == 0) goto L_0x021d
            int r0 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x01ef }
            com.xiaomi.push.service.ag.a((android.app.Notification) r1, (int) r0)     // Catch:{ NumberFormatException -> 0x01ef }
            goto L_0x021d
        L_0x01ef:
            r0 = move-exception
            android.content.Context r2 = r22.getApplicationContext()
            com.xiaomi.push.du r2 = com.xiaomi.push.du.a((android.content.Context) r2)
            java.lang.String r3 = r23.b()
            java.lang.String r4 = b((com.xiaomi.push.hc) r23)
            java.lang.String r5 = r11.a()
            java.lang.String r6 = "8"
            r2.b(r3, r4, r5, r6)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "fail to set message count. "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
        L_0x021d:
            java.lang.String r0 = a((com.xiaomi.push.hc) r23)
            com.xiaomi.push.service.ag.a((android.app.Notification) r1, (java.lang.String) r0)
            com.xiaomi.push.service.af r2 = com.xiaomi.push.service.af.a((android.content.Context) r7, (java.lang.String) r0)
            boolean r3 = com.xiaomi.push.j.a((android.content.Context) r22)
            if (r3 == 0) goto L_0x023b
            com.xiaomi.push.service.ab r3 = f3432a
            if (r3 == 0) goto L_0x023b
            com.xiaomi.push.service.ab r3 = f3432a
            java.util.Map r4 = r11.a()
            r3.a((com.xiaomi.push.hc) r8, (java.util.Map<java.lang.String, java.lang.String>) r4, (int) r15, (android.app.Notification) r1)
        L_0x023b:
            boolean r3 = com.xiaomi.push.j.a((android.content.Context) r22)
            if (r3 == 0) goto L_0x0257
            com.xiaomi.push.service.ab r3 = f3432a
            if (r3 == 0) goto L_0x0257
            com.xiaomi.push.service.ab r3 = f3432a
            java.util.Map r4 = r11.a()
            boolean r3 = r3.a((java.util.Map<java.lang.String, java.lang.String>) r4, (int) r15, (android.app.Notification) r1)
            if (r3 == 0) goto L_0x0257
            java.lang.String r3 = "consume this notificaiton by agent"
            com.xiaomi.channel.commonutils.logger.b.b(r3)
            goto L_0x0279
        L_0x0257:
            r2.a((int) r15, (android.app.Notification) r1)
            r9.f3441a = r10
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "notification: "
            r3.append(r4)
            java.lang.String r4 = r11.a()
            r3.append(r4)
            java.lang.String r4 = " is notifyied"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3)
        L_0x0279:
            boolean r3 = com.xiaomi.push.j.a()
            if (r3 == 0) goto L_0x0293
            boolean r3 = com.xiaomi.push.j.a((android.content.Context) r22)
            if (r3 == 0) goto L_0x0293
            com.xiaomi.push.service.ad r3 = com.xiaomi.push.service.ad.a()
            r3.a((android.content.Context) r7, (int) r15, (android.app.Notification) r1)
            java.lang.String r3 = r11.a()
            com.xiaomi.push.service.bb.a((android.content.Context) r7, (java.lang.String) r0, (int) r15, (java.lang.String) r3, (android.app.Notification) r1)
        L_0x0293:
            boolean r0 = a((com.xiaomi.push.hc) r23)
            if (r0 == 0) goto L_0x02b4
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.du r16 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r17 = r23.b()
            java.lang.String r18 = b((com.xiaomi.push.hc) r23)
            java.lang.String r19 = r11.a()
            r20 = 3002(0xbba, float:4.207E-42)
            r21 = 0
            r16.a(r17, r18, r19, r20, r21)
        L_0x02b4:
            boolean r0 = c((com.xiaomi.push.hc) r23)
            if (r0 == 0) goto L_0x02d5
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.du r16 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r17 = r23.b()
            java.lang.String r18 = b((com.xiaomi.push.hc) r23)
            java.lang.String r19 = r11.a()
            r20 = 1002(0x3ea, float:1.404E-42)
            r21 = 0
            r16.a(r17, r18, r19, r20, r21)
        L_0x02d5:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x030f
            java.lang.String r0 = r11.a()
            com.xiaomi.push.af r1 = com.xiaomi.push.af.a((android.content.Context) r22)
            java.util.Map r3 = r11.a()
            int r3 = a((java.util.Map<java.lang.String, java.lang.String>) r3)
            if (r3 <= 0) goto L_0x030f
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x030f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "n_timeout_"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r1.a((java.lang.String) r0)
            com.xiaomi.push.service.x$1 r4 = new com.xiaomi.push.service.x$1
            r4.<init>(r0, r2, r15)
            r1.b(r4, r3)
        L_0x030f:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            r0.<init>(r1, r8)
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.hc>> r1 = f3433a
            monitor-enter(r1)
            r1.add(r0)     // Catch:{ all -> 0x032b }
            int r0 = r1.size()     // Catch:{ all -> 0x032b }
            r2 = 100
            if (r0 <= r2) goto L_0x0329
            r1.remove()     // Catch:{ all -> 0x032b }
        L_0x0329:
            monitor-exit(r1)     // Catch:{ all -> 0x032b }
            return r9
        L_0x032b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x032b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.m3058a(android.content.Context, com.xiaomi.push.hc, byte[]):com.xiaomi.push.service.x$c");
    }

    private static int b(Context context, String str) {
        int a11 = a(context, str, "mipush_notification");
        int a12 = a(context, str, "mipush_small_notification");
        if (a11 <= 0) {
            if (a12 > 0) {
                a11 = a12;
            } else {
                a11 = context.getApplicationInfo().icon;
            }
        }
        return a11 == 0 ? context.getApplicationInfo().logo : a11;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e11) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e11);
            return 0;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m3064b(Context context, String str) {
        if (j.a(context) && f3432a != null && !TextUtils.isEmpty(str)) {
            f3432a.a(str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m3065b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static void b(Context context, String str, int i11) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i11).commit();
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m3066b(hc hcVar) {
        gt a11 = hcVar.a();
        return a(a11) && a11.f2979b == 1 && !a(hcVar);
    }

    public static String b(hc hcVar) {
        if (a(hcVar)) {
            return "E100002";
        }
        if (c(hcVar)) {
            return "E100000";
        }
        if (b(hcVar)) {
            return "E100001";
        }
        return d(hcVar) ? "E100003" : "";
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e11) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e11);
            return 3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent b(android.content.Context r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, int r11, android.os.Bundle r12) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r11 == 0) goto L_0x000b
            android.content.Intent r8 = a((android.content.Context) r8, (java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.String>) r10, (int) r11, (android.os.Bundle) r12)
            return r8
        L_0x000b:
            java.lang.String r1 = "notify_effect"
            boolean r2 = r10.containsKey(r1)
            if (r2 != 0) goto L_0x0014
            return r0
        L_0x0014:
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            java.lang.String r3 = "intent_flag"
            java.lang.Object r3 = r10.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ NumberFormatException -> 0x002e }
            if (r4 != 0) goto L_0x0047
            int r2 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x002e }
            goto L_0x0047
        L_0x002e:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Cause by intent_flag: "
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r3)
        L_0x0047:
            java.lang.String r3 = com.xiaomi.push.service.an.f52484a
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = "0"
            java.lang.String r5 = "Cause: "
            if (r3 == 0) goto L_0x007a
            android.content.pm.PackageManager r10 = r8.getPackageManager()     // Catch:{ Exception -> 0x005d }
            android.content.Intent r9 = r10.getLaunchIntentForPackage(r9)     // Catch:{ Exception -> 0x005d }
            goto L_0x018f
        L_0x005d:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r9)
            java.lang.String r9 = "9"
        L_0x0076:
            r3 = r9
        L_0x0077:
            r9 = r0
            goto L_0x0190
        L_0x007a:
            java.lang.String r3 = com.xiaomi.push.service.an.f52485b
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0103
            java.lang.String r3 = "intent_uri"
            boolean r6 = r10.containsKey(r3)
            if (r6 == 0) goto L_0x00d7
            java.lang.Object r10 = r10.get(r3)
            java.lang.String r10 = (java.lang.String) r10
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 == 0) goto L_0x0099
            java.lang.String r3 = "3"
            goto L_0x00a9
        L_0x0099:
            java.lang.String r3 = "#"
            int r6 = r10.indexOf(r3)
            int r3 = r10.lastIndexOf(r3)
            if (r6 == r3) goto L_0x00a8
            java.lang.String r3 = "7"
            goto L_0x00a9
        L_0x00a8:
            r3 = r4
        L_0x00a9:
            if (r10 == 0) goto L_0x00d1
            r6 = 1
            android.content.Intent r10 = android.content.Intent.parseUri(r10, r6)     // Catch:{ URISyntaxException -> 0x00b6 }
            r10.setPackage(r9)     // Catch:{ URISyntaxException -> 0x00b4 }
            goto L_0x00d2
        L_0x00b4:
            r9 = move-exception
            goto L_0x00b8
        L_0x00b6:
            r9 = move-exception
            r10 = r0
        L_0x00b8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            java.lang.String r9 = r9.getMessage()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r9)
            java.lang.String r9 = "10"
            goto L_0x00d3
        L_0x00d1:
            r10 = r0
        L_0x00d2:
            r9 = r3
        L_0x00d3:
            r3 = r9
            r9 = r10
            goto L_0x0190
        L_0x00d7:
            java.lang.String r3 = "class_name"
            boolean r6 = r10.containsKey(r3)
            if (r6 == 0) goto L_0x00ff
            java.lang.Object r10 = r10.get(r3)
            java.lang.String r10 = (java.lang.String) r10
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 == 0) goto L_0x00ee
            java.lang.String r3 = "4"
            goto L_0x00ef
        L_0x00ee:
            r3 = r4
        L_0x00ef:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.ComponentName r7 = new android.content.ComponentName
            r7.<init>(r9, r10)
            r6.setComponent(r7)
        L_0x00fc:
            r9 = r6
            goto L_0x0190
        L_0x00ff:
            java.lang.String r9 = "5"
            goto L_0x0076
        L_0x0103:
            java.lang.String r3 = com.xiaomi.push.service.an.f52486c
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x018e
            java.lang.String r3 = "web_uri"
            java.lang.Object r10 = r10.get(r3)
            java.lang.String r10 = (java.lang.String) r10
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 == 0) goto L_0x011c
            java.lang.String r3 = "6"
            goto L_0x011d
        L_0x011c:
            r3 = r4
        L_0x011d:
            if (r10 == 0) goto L_0x0077
            java.lang.String r10 = r10.trim()
            java.lang.String r6 = "http://"
            boolean r7 = r10.startsWith(r6)
            if (r7 != 0) goto L_0x0144
            java.lang.String r7 = "https://"
            boolean r7 = r10.startsWith(r7)
            if (r7 != 0) goto L_0x0144
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            java.lang.String r3 = "8"
        L_0x0144:
            java.net.URL r6 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0171 }
            r6.<init>(r10)     // Catch:{ MalformedURLException -> 0x0171 }
            java.lang.String r6 = r6.getProtocol()     // Catch:{ MalformedURLException -> 0x0171 }
            java.lang.String r7 = "http"
            boolean r7 = r7.equals(r6)     // Catch:{ MalformedURLException -> 0x0171 }
            if (r7 != 0) goto L_0x015d
            java.lang.String r7 = "https"
            boolean r6 = r7.equals(r6)     // Catch:{ MalformedURLException -> 0x0171 }
            if (r6 == 0) goto L_0x0077
        L_0x015d:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ MalformedURLException -> 0x0171 }
            java.lang.String r7 = "android.intent.action.VIEW"
            r6.<init>(r7)     // Catch:{ MalformedURLException -> 0x0171 }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ MalformedURLException -> 0x016f }
            r6.setData(r10)     // Catch:{ MalformedURLException -> 0x016f }
            com.xiaomi.push.service.ag.a((android.content.Context) r8, (java.lang.String) r9, (android.content.Intent) r6)     // Catch:{ MalformedURLException -> 0x016f }
            goto L_0x00fc
        L_0x016f:
            r9 = move-exception
            goto L_0x0173
        L_0x0171:
            r9 = move-exception
            r6 = r0
        L_0x0173:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r9)
            java.lang.String r9 = "11"
            r3 = r9
            goto L_0x00fc
        L_0x018e:
            r9 = r0
        L_0x018f:
            r3 = r4
        L_0x0190:
            boolean r10 = com.xiaomi.push.j.a((android.content.Context) r8)
            if (r10 == 0) goto L_0x01c8
            if (r12 == 0) goto L_0x01c8
            if (r9 == 0) goto L_0x01b6
            android.content.ComponentName r10 = r9.getComponent()
            if (r10 == 0) goto L_0x01b2
            if (r3 != r4) goto L_0x01a4
            java.lang.String r3 = "1"
        L_0x01a4:
            java.lang.String r4 = "xmsf.stat.tgtCompo"
            java.lang.String r4 = a((java.lang.String) r4, (int) r11)
            java.lang.String r10 = r10.flattenToString()
            r12.putString(r4, r10)
            goto L_0x01b6
        L_0x01b2:
            if (r3 != r4) goto L_0x01b6
            java.lang.String r3 = "2"
        L_0x01b6:
            java.lang.String r10 = "xmsf.stat.notifyEffect"
            java.lang.String r10 = a((java.lang.String) r10, (int) r11)
            r12.putString(r10, r1)
            java.lang.String r10 = "xmsf.stat.uriParse"
            java.lang.String r10 = a((java.lang.String) r10, (int) r11)
            r12.putString(r10, r3)
        L_0x01c8:
            if (r9 == 0) goto L_0x0225
            if (r2 < 0) goto L_0x01cf
            r9.setFlags(r2)
        L_0x01cf:
            a((android.content.Intent) r9)
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            r9.addFlags(r10)
            android.content.pm.PackageManager r10 = r8.getPackageManager()     // Catch:{ Exception -> 0x020e }
            r11 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r10 = r10.resolveActivity(r9, r11)     // Catch:{ Exception -> 0x020e }
            if (r10 == 0) goto L_0x01e4
            return r9
        L_0x01e4:
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x020e }
            r11 = 30
            if (r10 < r11) goto L_0x01f9
            boolean r8 = com.xiaomi.push.j.a((android.content.Context) r8)     // Catch:{ Exception -> 0x020e }
            if (r8 != 0) goto L_0x01f9
            java.lang.String r8 = com.xiaomi.push.service.an.f52486c     // Catch:{ Exception -> 0x020e }
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x020e }
            if (r8 == 0) goto L_0x01f9
            return r9
        L_0x01f9:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020e }
            r8.<init>()     // Catch:{ Exception -> 0x020e }
            java.lang.String r10 = "not resolve activity:"
            r8.append(r10)     // Catch:{ Exception -> 0x020e }
            r8.append(r9)     // Catch:{ Exception -> 0x020e }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x020e }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r8)     // Catch:{ Exception -> 0x020e }
            goto L_0x0225
        L_0x020e:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r8)
        L_0x0225:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, java.util.Map, int, android.os.Bundle):android.content.Intent");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r2, java.lang.String r3, com.xiaomi.push.dw r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r2)
            if (r0 != 0) goto L_0x002c
            java.lang.String r0 = "fcm_icon_uri"
            java.lang.String r0 = a((java.util.Map<java.lang.String, java.lang.String>) r5, (java.lang.String) r0)
            java.lang.String r1 = "fcm_icon_color"
            java.lang.String r5 = a((java.util.Map<java.lang.String, java.lang.String>) r5, (java.lang.String) r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x002c
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x002c
            int r0 = a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            if (r0 <= 0) goto L_0x002c
            r1 = 1
            r4.setSmallIcon(r0)
            r4.a((java.lang.String) r5)
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            if (r1 != 0) goto L_0x0048
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r5 < r0) goto L_0x0041
            int r2 = com.xiaomi.push.service.ag.a((android.content.Context) r2, (java.lang.String) r3)
            android.graphics.drawable.Icon r2 = android.graphics.drawable.Icon.createWithResource(r3, r2)
            r4.setSmallIcon(r2)
            goto L_0x0048
        L_0x0041:
            int r2 = b((android.content.Context) r2, (java.lang.String) r3)
            r4.setSmallIcon(r2)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, com.xiaomi.push.dw, java.util.Map):void");
    }

    private static PendingIntent a(Context context, hc hcVar, String str, byte[] bArr, int i11, Bundle bundle) {
        return a(context, hcVar, str, bArr, i11, 0, a(context, hcVar, str), bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.app.PendingIntent a(android.content.Context r16, com.xiaomi.push.hc r17, java.lang.String r18, byte[] r19, int r20, int r21, boolean r22, android.os.Bundle r23) {
        /*
            r7 = r16
            r0 = r18
            r1 = r19
            boolean r2 = c((com.xiaomi.push.hc) r17)
            if (r2 == 0) goto L_0x000f
            r2 = 1000(0x3e8, float:1.401E-42)
            goto L_0x0019
        L_0x000f:
            boolean r2 = a((com.xiaomi.push.hc) r17)
            if (r2 == 0) goto L_0x0018
            r2 = 3000(0xbb8, float:4.204E-42)
            goto L_0x0019
        L_0x0018:
            r2 = -1
        L_0x0019:
            com.xiaomi.push.gt r3 = r17.a()
            if (r3 == 0) goto L_0x0024
            java.lang.String r4 = r3.a()
            goto L_0x0026
        L_0x0024:
            java.lang.String r4 = ""
        L_0x0026:
            boolean r5 = a((com.xiaomi.push.hc) r17)
            java.lang.String r6 = "eventMessageType"
            r8 = 167772160(0xa000000, float:6.162976E-33)
            r9 = 134217728(0x8000000, float:3.85186E-34)
            r10 = 31
            java.lang.String r11 = "messageId"
            r12 = 0
            if (r3 == 0) goto L_0x00a5
            java.lang.String r13 = r3.f2986e
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x00a5
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.VIEW"
            r1.<init>(r5)
            java.lang.String r5 = r3.f2986e
            android.net.Uri r5 = android.net.Uri.parse(r5)
            r1.setData(r5)
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0073 }
            java.lang.String r13 = r3.f2986e     // Catch:{ MalformedURLException -> 0x0073 }
            r5.<init>(r13)     // Catch:{ MalformedURLException -> 0x0073 }
            java.lang.String r5 = r5.getProtocol()     // Catch:{ MalformedURLException -> 0x0073 }
            java.lang.String r13 = "http"
            boolean r13 = r13.equals(r5)     // Catch:{ MalformedURLException -> 0x0073 }
            if (r13 != 0) goto L_0x006f
            java.lang.String r13 = "https"
            boolean r5 = r13.equals(r5)     // Catch:{ MalformedURLException -> 0x0073 }
            if (r5 == 0) goto L_0x006b
            goto L_0x006f
        L_0x006b:
            r1.setPackage(r0)     // Catch:{ MalformedURLException -> 0x0073 }
            goto L_0x008c
        L_0x006f:
            com.xiaomi.push.service.ag.a((android.content.Context) r7, (java.lang.String) r0, (android.content.Intent) r1)     // Catch:{ MalformedURLException -> 0x0073 }
            goto L_0x008c
        L_0x0073:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r13 = "meet URL exception : "
            r5.append(r13)
            java.lang.String r3 = r3.f2986e
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3)
            r1.setPackage(r0)
        L_0x008c:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r0)
            r1.putExtra(r11, r4)
            r1.putExtra(r6, r2)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r10) goto L_0x00a0
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r7, r12, r1, r8)
            return r0
        L_0x00a0:
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r7, r12, r1, r9)
            return r0
        L_0x00a5:
            java.lang.String r13 = "mipush_payload"
            java.lang.String r14 = "com.xiaomi.mipush.sdk.PushMessageHandler"
            r15 = 1
            java.lang.String r9 = "mipush_notified"
            if (r5 == 0) goto L_0x00d2
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            android.content.ComponentName r12 = new android.content.ComponentName
            java.lang.String r10 = "com.xiaomi.xmsf"
            r12.<init>(r10, r14)
            r8.setComponent(r12)
            r8.putExtra(r13, r1)
            r8.putExtra(r9, r15)
            java.lang.String r1 = java.lang.String.valueOf(r20)
            r8.addCategory(r1)
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r8.addCategory(r1)
            goto L_0x00f5
        L_0x00d2:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r10 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r8.<init>(r10)
            android.content.ComponentName r10 = new android.content.ComponentName
            r10.<init>(r0, r14)
            r8.setComponent(r10)
            r8.putExtra(r13, r1)
            r8.putExtra(r9, r15)
            java.lang.String r1 = java.lang.String.valueOf(r20)
            r8.addCategory(r1)
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r8.addCategory(r1)
        L_0x00f5:
            java.lang.String r1 = "notification_click_button"
            r10 = r21
            r8.putExtra(r1, r10)
            r8.putExtra(r11, r4)
            r8.putExtra(r6, r2)
            if (r5 != 0) goto L_0x0159
            if (r22 == 0) goto L_0x0159
            android.content.Intent r12 = new android.content.Intent
            r12.<init>()
            android.content.ComponentName r0 = a((java.lang.String) r18)
            r12.setComponent(r0)
            r0 = 276824064(0x10800000, float:5.0487098E-29)
            r12.addFlags(r0)
            java.lang.String r0 = "mipush_serviceIntent"
            r12.putExtra(r0, r8)
            r12.putExtra(r11, r4)
            r12.putExtra(r9, r15)
            java.lang.String r0 = java.lang.String.valueOf(r20)
            r12.addCategory(r0)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            r12.addCategory(r0)
            java.lang.String r0 = java.lang.String.valueOf(r21)
            r12.addCategory(r0)
            r0 = r16
            r1 = r12
            r2 = r17
            r5 = r21
            r6 = r23
            a((android.content.Context) r0, (android.content.Intent) r1, (com.xiaomi.push.hc) r2, (com.xiaomi.push.gt) r3, (java.lang.String) r4, (int) r5, (android.os.Bundle) r6)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L_0x0151
            r0 = 167772160(0xa000000, float:6.162976E-33)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r7, r1, r12, r0)
            return r0
        L_0x0151:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r7, r1, r12, r0)
            return r0
        L_0x0159:
            r0 = r16
            r1 = r8
            r2 = r17
            r5 = r21
            r6 = r23
            a((android.content.Context) r0, (android.content.Intent) r1, (com.xiaomi.push.hc) r2, (com.xiaomi.push.gt) r3, (java.lang.String) r4, (int) r5, (android.os.Bundle) r6)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L_0x0173
            r0 = 167772160(0xa000000, float:6.162976E-33)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getService(r7, r1, r8, r0)
            return r0
        L_0x0173:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getService(r7, r1, r8, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.hc, java.lang.String, byte[], int, int, boolean, android.os.Bundle):android.app.PendingIntent");
    }

    private static void a(Context context, Intent intent, hc hcVar, gt gtVar, String str, int i11, Bundle bundle) {
        ComponentName component;
        if (hcVar != null && gtVar != null && !TextUtils.isEmpty(str)) {
            String a11 = a((Map<String, String>) gtVar.a(), i11);
            if (TextUtils.isEmpty(a11)) {
                return;
            }
            if (an.f52484a.equals(a11) || an.f52485b.equals(a11) || an.f52486c.equals(a11)) {
                intent.putExtra("messageId", str);
                intent.putExtra("local_paid", hcVar.f3065a);
                if (!TextUtils.isEmpty(hcVar.f3069b)) {
                    intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, hcVar.f3069b);
                }
                intent.putExtra("job_key", a((Map<String, String>) gtVar.a(), "jobkey"));
                intent.putExtra(i11 + "_" + "target_component", a(context, hcVar.f3069b, (Map<String, String>) gtVar.a(), i11, bundle));
                if (j.a(context) && bundle != null && (component = intent.getComponent()) != null) {
                    bundle.putString(a("xmsf.stat.transfCompo", i11), component.flattenToString());
                }
            }
        }
    }

    private static boolean a(Context context, hc hcVar, String str) {
        if (hcVar == null || hcVar.a() == null || hcVar.a().a() == null || TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("should clicked activity params are null.");
            return false;
        } else if (!Boolean.parseBoolean((String) hcVar.a().a().get("use_clicked_activity")) || !j.a(context, a(str))) {
            return false;
        } else {
            return true;
        }
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004e, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.push.gt r4) {
        /*
            java.lang.String r0 = r4.c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.a()
            if (r4 == 0) goto L_0x0073
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L_0x0051
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0042
            r0 = r3
        L_0x0042:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0073
            goto L_0x0072
        L_0x0051:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L_0x0073
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0064
            r0 = r3
        L_0x0064:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0073
        L_0x0072:
            r1 = r3
        L_0x0073:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.gt):java.lang.String[]");
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static int a(Context context, String str, Map<String, String> map, int i11, Bundle bundle) {
        ComponentName a11;
        Intent b11 = b(context, str, map, i11, bundle);
        if (b11 == null || (a11 = j.a(context, b11)) == null) {
            return 0;
        }
        if (j.a(context) && bundle != null) {
            bundle.putString(a("xmsf.stat.tgtCompo", i11), a11.flattenToString());
        }
        return a11.hashCode();
    }

    public static String a(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + "_" + i11;
    }

    /* JADX WARNING: type inference failed for: r5v37 */
    /* JADX WARNING: type inference failed for: r5v38 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r5v34, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02aa A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0419 A[SYNTHETIC, Splitter:B:158:0x0419] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02a1  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xiaomi.push.service.x.b a(android.content.Context r26, com.xiaomi.push.hc r27, byte[] r28, android.widget.RemoteViews r29, android.app.PendingIntent r30, int r31) {
        /*
            r7 = r26
            r0 = r29
            com.xiaomi.push.service.x$b r8 = new com.xiaomi.push.service.x$b
            r8.<init>()
            com.xiaomi.push.gt r9 = r27.a()
            java.lang.String r10 = a((com.xiaomi.push.hc) r27)
            java.util.Map r11 = r9.a()
            java.lang.String[] r12 = a((android.content.Context) r7, (com.xiaomi.push.gt) r9)
            java.lang.String r13 = "notification_style_type"
            r14 = 1
            if (r0 == 0) goto L_0x002e
            com.xiaomi.push.dw r1 = new com.xiaomi.push.dw
            r1.<init>(r7)
            r1.setCustomContentView((android.widget.RemoteViews) r0)
            r15 = r27
            r5 = r28
            r6 = r31
        L_0x002c:
            r4 = r1
            goto L_0x004f
        L_0x002e:
            if (r11 == 0) goto L_0x0043
            boolean r0 = r11.containsKey(r13)
            if (r0 == 0) goto L_0x0043
            r0 = r12[r14]
            r15 = r27
            r5 = r28
            r6 = r31
            com.xiaomi.push.dw r1 = a((android.content.Context) r7, (com.xiaomi.push.hc) r15, (byte[]) r5, (java.lang.String) r0, (int) r6)
            goto L_0x002c
        L_0x0043:
            r15 = r27
            r5 = r28
            r6 = r31
            com.xiaomi.push.dw r1 = new com.xiaomi.push.dw
            r1.<init>(r7)
            goto L_0x002c
        L_0x004f:
            java.lang.String r3 = r27.b()
            r1 = r4
            r2 = r26
            r14 = r4
            r4 = r27
            r5 = r28
            r6 = r31
            a((com.xiaomi.push.dw) r1, (android.content.Context) r2, (java.lang.String) r3, (com.xiaomi.push.hc) r4, (byte[]) r5, (int) r6)
            r1 = 0
            r0 = r12[r1]
            r14.setContentTitle(r0)
            r2 = 1
            r0 = r12[r2]
            r14.setContentText(r0)
            long r3 = java.lang.System.currentTimeMillis()
            r14.setWhen(r3)
            java.lang.String r0 = "notification_show_when"
            java.lang.String r0 = a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r0)
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            r6 = 24
            if (r5 == 0) goto L_0x0089
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r6) goto L_0x0090
            r14.setShowWhen(r2)
            goto L_0x0090
        L_0x0089:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            r14.setShowWhen(r0)
        L_0x0090:
            r0 = r30
            r14.setContentIntent(r0)
            a((android.content.Context) r7, (java.lang.String) r10, (com.xiaomi.push.dw) r14, (java.util.Map<java.lang.String, java.lang.String>) r11)
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L_0x0114
            java.lang.String r2 = "notification_small_icon_uri"
            if (r11 != 0) goto L_0x00a5
            r5 = 1
            r12 = 0
            goto L_0x00b0
        L_0x00a5:
            java.lang.Object r12 = r11.get(r2)
            java.lang.String r12 = (java.lang.String) r12
            r5 = 1
            android.graphics.Bitmap r12 = a((android.content.Context) r7, (java.lang.String) r12, (boolean) r5)
        L_0x00b0:
            if (r12 == 0) goto L_0x00f3
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r6[r1] = r12
            java.lang.String r12 = "android.graphics.drawable.Icon"
            java.lang.String r1 = "createWithBitmap"
            java.lang.Object r1 = com.xiaomi.push.ax.a((java.lang.String) r12, (java.lang.String) r1, (java.lang.Object[]) r6)
            if (r1 == 0) goto L_0x00d8
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r6 = 0
            r2[r6] = r1
            java.lang.String r1 = "setSmallIcon"
            com.xiaomi.push.ax.a((java.lang.Object) r14, (java.lang.String) r1, (java.lang.Object[]) r2)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "miui.isGrayscaleIcon"
            r1.putBoolean(r2, r5)
            r14.addExtras((android.os.Bundle) r1)
            goto L_0x010b
        L_0x00d8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "failed te get small icon with url:"
            r1.append(r5)
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
            goto L_0x010b
        L_0x00f3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "failed to get small icon url:"
            r1.append(r5)
            java.lang.String r2 = a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
        L_0x010b:
            java.lang.String r1 = "notification_small_icon_color"
            java.lang.String r1 = a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r1)
            r14.a((java.lang.String) r1)
        L_0x0114:
            java.lang.String r1 = "__dynamic_icon_uri"
            java.lang.String r1 = a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r1)
            java.lang.String r2 = "__adiom"
            java.lang.String r2 = a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r2)
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 != 0) goto L_0x012f
            boolean r2 = com.xiaomi.push.j.a()
            if (r2 != 0) goto L_0x012d
            goto L_0x012f
        L_0x012d:
            r2 = 0
            goto L_0x0130
        L_0x012f:
            r2 = 1
        L_0x0130:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x015b
            if (r2 == 0) goto L_0x015b
            java.lang.String r2 = "http"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0150
            r2 = 1
            com.xiaomi.push.service.ae$b r1 = com.xiaomi.push.service.ae.a((android.content.Context) r7, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x014e
            android.graphics.Bitmap r2 = r1.f3322a
            long r5 = r1.f52442a
            r8.f52609a = r5
            goto L_0x0154
        L_0x014e:
            r2 = 0
            goto L_0x0154
        L_0x0150:
            android.graphics.Bitmap r2 = com.xiaomi.push.service.ae.a((android.content.Context) r7, (java.lang.String) r1)
        L_0x0154:
            if (r2 == 0) goto L_0x015b
            r14.setLargeIcon(r2)
            r2 = 1
            goto L_0x015c
        L_0x015b:
            r2 = 0
        L_0x015c:
            if (r11 != 0) goto L_0x0160
            r1 = 0
            goto L_0x016d
        L_0x0160:
            java.lang.String r1 = "notification_large_icon_uri"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r5 = 1
            android.graphics.Bitmap r1 = a((android.content.Context) r7, (java.lang.String) r1, (boolean) r5)
        L_0x016d:
            if (r1 == 0) goto L_0x0172
            r14.setLargeIcon(r1)
        L_0x0172:
            java.lang.String r1 = "com.xiaomi.xmsf"
            if (r11 == 0) goto L_0x01fb
            r5 = 24
            if (r0 < r5) goto L_0x01fb
            java.lang.String r5 = "notification_group"
            java.lang.Object r5 = r11.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "notification_is_summary"
            java.lang.Object r6 = r11.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r12 = "notification_group_disable_default"
            java.lang.Object r12 = r11.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            boolean r16 = android.text.TextUtils.isEmpty(r5)
            if (r16 == 0) goto L_0x01ac
            boolean r16 = com.xiaomi.push.j.a()
            if (r16 != 0) goto L_0x01a8
            if (r12 != 0) goto L_0x01ac
        L_0x01a8:
            java.lang.String r5 = a((com.xiaomi.push.hc) r27)
        L_0x01ac:
            r28 = r5
            r12 = 1
            java.lang.Object[] r5 = new java.lang.Object[r12]
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)
            r16 = 0
            r5[r16] = r12
            java.lang.String r12 = "setGroupSummary"
            com.xiaomi.push.ax.a((java.lang.Object) r14, (java.lang.String) r12, (java.lang.Object[]) r5)
            java.lang.Object r5 = r11.get(r13)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r12 = r26.getPackageName()
            boolean r12 = r1.equals(r12)
            if (r12 == 0) goto L_0x01f8
            java.lang.String r12 = "4"
            boolean r12 = r12.equals(r5)
            if (r12 != 0) goto L_0x01de
            java.lang.String r12 = "3"
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x01f8
        L_0x01de:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r12 = a((com.xiaomi.push.hc) r27)
            r5.append(r12)
            java.lang.String r12 = "_custom_"
            r5.append(r12)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            r12 = 1
            goto L_0x01fe
        L_0x01f8:
            r5 = r28
            goto L_0x01fd
        L_0x01fb:
            r5 = 0
            r6 = 0
        L_0x01fd:
            r12 = 0
        L_0x01fe:
            r13 = 1
            r14.setAutoCancel(r13)
            long r16 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x0219
            java.lang.String r13 = "ticker"
            boolean r18 = r11.containsKey(r13)
            if (r18 == 0) goto L_0x0219
            java.lang.Object r13 = r11.get(r13)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r14.setTicker(r13)
        L_0x0219:
            long r18 = f52606a
            long r18 = r16 - r18
            r20 = 10000(0x2710, double:4.9407E-320)
            int r13 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            java.lang.String r15 = "sound_uri"
            r28 = r2
            if (r13 <= 0) goto L_0x0279
            f52606a = r16
            int r13 = r9.f2973a
            boolean r16 = b((android.content.Context) r7, (java.lang.String) r10)
            if (r16 == 0) goto L_0x0235
            int r13 = a((android.content.Context) r7, (java.lang.String) r10)
        L_0x0235:
            r14.setDefaults(r13)
            if (r11 == 0) goto L_0x0274
            r16 = r13 & 1
            if (r16 == 0) goto L_0x0274
            java.lang.Object r16 = r11.get(r15)
            r2 = r16
            java.lang.String r2 = (java.lang.String) r2
            boolean r16 = android.text.TextUtils.isEmpty(r2)
            if (r16 != 0) goto L_0x0274
            r30 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r16 = r12
            java.lang.String r12 = "android.resource://"
            r1.append(r12)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            boolean r1 = r2.startsWith(r1)
            if (r1 == 0) goto L_0x027f
            r1 = r13 ^ 1
            r14.setDefaults(r1)
            android.net.Uri r1 = android.net.Uri.parse(r2)
            r14.setSound(r1)
            goto L_0x027f
        L_0x0274:
            r30 = r1
            r16 = r12
            goto L_0x027f
        L_0x0279:
            r30 = r1
            r16 = r12
            r13 = -100
        L_0x027f:
            boolean r1 = com.xiaomi.push.j.a((android.content.Context) r26)
            if (r1 == 0) goto L_0x02a1
            com.xiaomi.push.service.ab r1 = f3432a
            if (r1 == 0) goto L_0x0298
            com.xiaomi.push.service.ab r1 = f3432a
            long r1 = r1.a((android.content.Context) r7, (com.xiaomi.push.dw) r14, (java.util.Map<java.lang.String, java.lang.String>) r11)
            r17 = r5
            r12 = r6
            long r5 = r8.f52609a
            long r5 = r5 + r1
            r8.f52609a = r5
            goto L_0x02a4
        L_0x0298:
            r17 = r5
            r12 = r6
            java.lang.String r1 = "Handle focus notification error, because the object of NotificationAgent is null."
            com.xiaomi.channel.commonutils.logger.b.d(r1)
            goto L_0x02a4
        L_0x02a1:
            r17 = r5
            r12 = r6
        L_0x02a4:
            java.lang.String r1 = "0"
            r2 = 26
            if (r11 == 0) goto L_0x0399
            if (r0 < r2) goto L_0x0399
            com.xiaomi.push.service.af r18 = com.xiaomi.push.service.af.a((android.content.Context) r7, (java.lang.String) r10)
            int r0 = a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r0 <= 0) goto L_0x02cb
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            int r0 = r0 * 1000
            r19 = r3
            long r2 = (long) r0
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            r2 = 0
            r6[r2] = r0
            java.lang.String r0 = "setTimeoutAfter"
            com.xiaomi.push.ax.a((java.lang.Object) r14, (java.lang.String) r0, (java.lang.Object[]) r6)
            goto L_0x02cd
        L_0x02cb:
            r19 = r3
        L_0x02cd:
            com.xiaomi.push.service.ac.a((com.xiaomi.push.gt) r9)
            java.lang.String r0 = "channel_id"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x02e8
            android.content.pm.ApplicationInfo r2 = r26.getApplicationInfo()
            int r2 = r2.targetSdkVersion
            r3 = 26
            if (r2 < r3) goto L_0x036e
        L_0x02e8:
            java.lang.String r2 = a((android.content.Context) r7, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            int r23 = b((java.util.Map<java.lang.String, java.lang.String>) r11)
            int r3 = r9.f2973a
            java.lang.String r4 = "channel_description"
            java.lang.Object r4 = r11.get(r4)
            r21 = r4
            java.lang.String r21 = (java.lang.String) r21
            java.lang.Object r4 = r11.get(r15)
            r24 = r4
            java.lang.String r24 = (java.lang.String) r24
            java.lang.String r4 = "channel_perm"
            java.lang.Object r4 = r11.get(r4)
            r25 = r4
            java.lang.String r25 = (java.lang.String) r25
            r4 = r19
            com.xiaomi.push.service.bb.a((android.content.Context) r7, (java.util.Map<java.lang.String, java.lang.String>) r11, (com.xiaomi.push.dw) r14, (long) r4)
            r19 = r0
            r20 = r2
            r22 = r3
            java.lang.String r0 = com.xiaomi.push.service.ac.a(r18, r19, r20, r21, r22, r23, r24, r25)
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r2 = 0
            r3[r2] = r0
            java.lang.String r0 = "setChannelId"
            com.xiaomi.push.ax.a((java.lang.Object) r14, (java.lang.String) r0, (java.lang.Object[]) r3)
            r0 = -100
            if (r13 != r0) goto L_0x0337
            boolean r0 = com.xiaomi.push.service.ag.a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r0 == 0) goto L_0x0337
            r6 = r12
            com.xiaomi.push.service.ag.a((android.app.Notification.Builder) r14, (boolean) r6)
            goto L_0x0338
        L_0x0337:
            r6 = r12
        L_0x0338:
            java.lang.String r0 = com.xiaomi.push.service.ag.a((java.lang.Object) r11)
            java.lang.String r2 = "pulldown"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0359
            boolean r0 = com.xiaomi.push.service.ag.a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r0 == 0) goto L_0x0359
            java.lang.String r0 = "pull_down_pop_type"
            java.lang.Object r0 = r11.get(r0)
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 == 0) goto L_0x0359
            com.xiaomi.push.service.ag.a((android.app.Notification.Builder) r14, (boolean) r6)
        L_0x0359:
            java.lang.String r0 = com.xiaomi.push.service.ag.a((java.lang.Object) r11)
            java.lang.String r2 = "tts"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x036e
            boolean r0 = com.xiaomi.push.service.ag.a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r0 == 0) goto L_0x036e
            com.xiaomi.push.service.ag.a((android.app.Notification.Builder) r14, (boolean) r6)
        L_0x036e:
            java.lang.String r0 = "background_color"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x03b2
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0394 }
            r2 = 1
            r14.setOngoing(r2)     // Catch:{ Exception -> 0x0394 }
            r14.setColor(r0)     // Catch:{ Exception -> 0x0394 }
            java.lang.String r0 = "setColorized"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0394 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0394 }
            r4 = 0
            r3[r4] = r2     // Catch:{ Exception -> 0x0394 }
            com.xiaomi.push.ax.a((java.lang.Object) r14, (java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0394 }
            goto L_0x03b2
        L_0x0394:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)
            goto L_0x03b2
        L_0x0399:
            if (r11 == 0) goto L_0x03b2
            r2 = 26
            if (r0 >= r2) goto L_0x03b2
            int r0 = c((java.util.Map<java.lang.String, java.lang.String>) r11)
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 0
            r3[r2] = r0
            java.lang.String r0 = "setPriority"
            com.xiaomi.push.ax.a((java.lang.Object) r14, (java.lang.String) r0, (java.lang.Object[]) r3)
        L_0x03b2:
            if (r17 == 0) goto L_0x03ce
            if (r16 != 0) goto L_0x03c1
            com.xiaomi.push.service.ad r0 = com.xiaomi.push.service.ad.a()
            r5 = r17
            java.lang.String r5 = r0.a((android.content.Context) r7, (android.app.Notification.Builder) r14, (java.lang.String) r5)
            goto L_0x03c3
        L_0x03c1:
            r5 = r17
        L_0x03c3:
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r2 = 0
            r0[r2] = r5
            java.lang.String r2 = "setGroup"
            com.xiaomi.push.ax.a((java.lang.Object) r14, (java.lang.String) r2, (java.lang.Object[]) r0)
        L_0x03ce:
            boolean r0 = com.xiaomi.push.j.c()
            if (r0 == 0) goto L_0x03f7
            java.lang.String r0 = r26.getPackageName()
            r2 = r30
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x03f7
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            r0[r2] = r7
            r2 = 1
            r0[r2] = r14
            r2 = 2
            java.lang.String r3 = a((com.xiaomi.push.hc) r27)
            r0[r2] = r3
            java.lang.String r2 = "miui.util.NotificationHelper"
            java.lang.String r3 = "setTargetPkg"
            com.xiaomi.push.ax.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object[]) r0)
        L_0x03f7:
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r26)
            if (r0 == 0) goto L_0x0468
            boolean r0 = com.xiaomi.push.r.b(r26)
            if (r0 == 0) goto L_0x0468
            if (r11 == 0) goto L_0x0468
            java.lang.String r0 = "miui.fold.timeout"
            boolean r2 = r11.containsKey(r0)
            if (r2 == 0) goto L_0x0468
            java.lang.Object r2 = r11.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0468
            java.lang.Long r3 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x044b }
            long r3 = r3.longValue()     // Catch:{ all -> 0x044b }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0436
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x044b }
            r5.<init>()     // Catch:{ all -> 0x044b }
            r5.putLong(r0, r3)     // Catch:{ all -> 0x044b }
            r14.addExtras((android.os.Bundle) r5)     // Catch:{ all -> 0x044b }
            goto L_0x0468
        L_0x0436:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x044b }
            r0.<init>()     // Catch:{ all -> 0x044b }
            java.lang.String r3 = "illegal history notification fold timeout value , time: "
            r0.append(r3)     // Catch:{ all -> 0x044b }
            r0.append(r2)     // Catch:{ all -> 0x044b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x044b }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ all -> 0x044b }
            goto L_0x0468
        L_0x044b:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "exception occurred in setting history notification fold timeout time, time: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " exception: "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
        L_0x0468:
            android.app.Notification r0 = r14.getNotification()
            if (r28 == 0) goto L_0x0477
            boolean r2 = com.xiaomi.push.j.a()
            if (r2 == 0) goto L_0x0477
            a((android.app.Notification) r0)
        L_0x0477:
            if (r11 == 0) goto L_0x04fe
            android.os.Bundle r2 = r0.extras
            if (r2 != 0) goto L_0x0484
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r0.extras = r2
        L_0x0484:
            java.lang.String r2 = "enable_keyguard"
            java.lang.Object r3 = r11.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x049f
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            com.xiaomi.push.service.ag.b(r0, r2)
        L_0x049f:
            java.lang.String r2 = "enable_float"
            java.lang.Object r3 = r11.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x04ba
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            com.xiaomi.push.service.ag.a((android.app.Notification) r0, (boolean) r2)
        L_0x04ba:
            java.lang.String r2 = "float_small_win"
            java.lang.Object r3 = r11.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x04de
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x04de
            boolean r1 = com.xiaomi.push.g.d(r7, r10)
            if (r1 == 0) goto L_0x04de
            r1 = 0
            com.xiaomi.push.service.ag.a((android.app.Notification) r0, (boolean) r1)
        L_0x04de:
            java.lang.String r1 = "section_is_prr"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r1 = com.xiaomi.push.t.a((java.lang.String) r1, (int) r2)
            java.lang.String r3 = "section_prr_cl"
            java.lang.Object r3 = r11.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            int r2 = com.xiaomi.push.t.a((java.lang.String) r3, (int) r2)
            if (r1 < 0) goto L_0x04fe
            if (r2 < 0) goto L_0x04fe
            com.xiaomi.push.service.ag.a((android.app.Notification) r0, (int) r1, (int) r2)
        L_0x04fe:
            r8.f3439a = r0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.hc, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.x$b");
    }

    @TargetApi(16)
    private static void a(dw dwVar, Context context, String str, hc hcVar, byte[] bArr, int i11) {
        PendingIntent a11;
        PendingIntent a12;
        PendingIntent a13;
        PendingIntent a14;
        dw dwVar2 = dwVar;
        Map a15 = hcVar.a().a();
        if (!TextUtils.equals("3", (CharSequence) a15.get("notification_style_type")) && !TextUtils.equals("4", (CharSequence) a15.get("notification_style_type"))) {
            Bundle bundle = new Bundle();
            if (b((Map<String, String>) a15)) {
                for (int i12 = 1; i12 <= 3; i12++) {
                    String str2 = (String) a15.get(String.format("cust_btn_%s_n", new Object[]{Integer.valueOf(i12)}));
                    if (!TextUtils.isEmpty(str2) && (a14 = a(context, str, hcVar, bArr, i11, i12, bundle)) != null) {
                        dwVar.addAction(0, str2, a14);
                    }
                }
                dwVar.addExtras(bundle);
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) a15.get("notification_style_button_left_name")) && (a13 = a(context, str, hcVar, bArr, i11, 1, bundle)) != null) {
                dwVar.addAction(0, (CharSequence) a15.get("notification_style_button_left_name"), a13);
            }
            if (!TextUtils.isEmpty((CharSequence) a15.get("notification_style_button_mid_name")) && (a12 = a(context, str, hcVar, bArr, i11, 2, bundle)) != null) {
                dwVar.addAction(0, (CharSequence) a15.get("notification_style_button_mid_name"), a12);
            }
            if (!TextUtils.isEmpty((CharSequence) a15.get("notification_style_button_right_name")) && (a11 = a(context, str, hcVar, bArr, i11, 3, bundle)) != null) {
                dwVar.addAction(0, (CharSequence) a15.get("notification_style_button_right_name"), a11);
            }
            dwVar.addExtras(bundle);
        }
    }

    private static PendingIntent a(Context context, String str, hc hcVar, byte[] bArr, int i11, int i12, Bundle bundle) {
        Map a11 = hcVar.a().a();
        if (a11 == null) {
            return null;
        }
        boolean a12 = a(context, hcVar, str);
        if (a12) {
            return a(context, hcVar, str, bArr, i11, i12, a12, bundle);
        }
        Intent a13 = a(context, str, (Map<String, String>) a11, i12, bundle);
        if (a13 == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, a13, 167772160);
        }
        return PendingIntent.getActivity(context, 0, a13, 134217728);
    }

    public static String a(Map<String, String> map, int i11) {
        String str;
        if (i11 == 0) {
            str = "notify_effect";
        } else {
            str = b(map) ? String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(i11)}) : i11 == 1 ? "notification_style_button_left_notify_effect" : i11 == 2 ? "notification_style_button_mid_notify_effect" : i11 == 3 ? "notification_style_button_right_notify_effect" : i11 == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m3057a(Context context, String str, Map<String, String> map, int i11, Bundle bundle) {
        if (b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(i11)}), String.format("cust_btn_%s_iu", new Object[]{Integer.valueOf(i11)}), String.format("cust_btn_%s_ic", new Object[]{Integer.valueOf(i11)}), String.format("cust_btn_%s_wu", new Object[]{Integer.valueOf(i11)}), i11, bundle);
        } else if (i11 == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri", i11, bundle);
        } else {
            if (i11 == 2) {
                return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri", i11, bundle);
            }
            if (i11 == 3) {
                return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri", i11, bundle);
            }
            if (i11 != 4) {
                return null;
            }
            return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri", i11, bundle);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Intent a(android.content.Context r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, android.os.Bundle r12) {
        /*
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r0 = com.xiaomi.push.service.an.f52484a
            boolean r0 = r0.equals(r7)
            java.lang.String r2 = "0"
            java.lang.String r3 = "Cause: "
            if (r0 == 0) goto L_0x0041
            android.content.pm.PackageManager r6 = r4.getPackageManager()     // Catch:{ Exception -> 0x0024 }
            android.content.Intent r5 = r6.getLaunchIntentForPackage(r5)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0155
        L_0x0024:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r5)
            java.lang.String r5 = "9"
        L_0x003d:
            r8 = r5
            r5 = r1
            goto L_0x0156
        L_0x0041:
            java.lang.String r0 = com.xiaomi.push.service.an.f52485b
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00c7
            boolean r10 = r6.containsKey(r8)
            if (r10 == 0) goto L_0x009d
            java.lang.Object r6 = r6.get(r8)
            java.lang.String r6 = (java.lang.String) r6
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L_0x005e
            java.lang.String r8 = "3"
            goto L_0x006e
        L_0x005e:
            java.lang.String r8 = "#"
            int r9 = r6.indexOf(r8)
            int r8 = r6.lastIndexOf(r8)
            if (r9 == r8) goto L_0x006d
            java.lang.String r8 = "7"
            goto L_0x006e
        L_0x006d:
            r8 = r2
        L_0x006e:
            if (r6 == 0) goto L_0x0097
            r9 = 1
            android.content.Intent r6 = android.content.Intent.parseUri(r6, r9)     // Catch:{ URISyntaxException -> 0x007c }
            r6.setPackage(r5)     // Catch:{ URISyntaxException -> 0x007a }
            r5 = r8
            goto L_0x0099
        L_0x007a:
            r5 = move-exception
            goto L_0x007e
        L_0x007c:
            r5 = move-exception
            r6 = r1
        L_0x007e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            java.lang.String r5 = r5.getMessage()
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r5)
            java.lang.String r5 = "10"
            goto L_0x0099
        L_0x0097:
            r5 = r8
            r6 = r1
        L_0x0099:
            r8 = r5
            r5 = r6
            goto L_0x0156
        L_0x009d:
            boolean r8 = r6.containsKey(r9)
            if (r8 == 0) goto L_0x00c3
            java.lang.Object r6 = r6.get(r9)
            java.lang.String r6 = (java.lang.String) r6
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L_0x00b2
            java.lang.String r8 = "4"
            goto L_0x00b3
        L_0x00b2:
            r8 = r2
        L_0x00b3:
            android.content.Intent r9 = new android.content.Intent
            r9.<init>()
            android.content.ComponentName r10 = new android.content.ComponentName
            r10.<init>(r5, r6)
            r9.setComponent(r10)
        L_0x00c0:
            r5 = r9
            goto L_0x0156
        L_0x00c3:
            java.lang.String r5 = "5"
            goto L_0x003d
        L_0x00c7:
            java.lang.String r8 = com.xiaomi.push.service.an.f52486c
            boolean r8 = r8.equals(r7)
            if (r8 == 0) goto L_0x0154
            java.lang.Object r6 = r6.get(r10)
            java.lang.String r6 = (java.lang.String) r6
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0150
            java.lang.String r6 = r6.trim()
            java.lang.String r8 = "http://"
            boolean r9 = r6.startsWith(r8)
            if (r9 != 0) goto L_0x0101
            java.lang.String r9 = "https://"
            boolean r9 = r6.startsWith(r9)
            if (r9 != 0) goto L_0x0101
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.String r8 = "8"
            goto L_0x0102
        L_0x0101:
            r8 = r2
        L_0x0102:
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0133 }
            r9.<init>(r6)     // Catch:{ MalformedURLException -> 0x0133 }
            java.lang.String r9 = r9.getProtocol()     // Catch:{ MalformedURLException -> 0x0133 }
            java.lang.String r10 = "http"
            boolean r10 = r10.equals(r9)     // Catch:{ MalformedURLException -> 0x0133 }
            if (r10 != 0) goto L_0x011e
            java.lang.String r10 = "https"
            boolean r9 = r10.equals(r9)     // Catch:{ MalformedURLException -> 0x0133 }
            if (r9 == 0) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r9 = r1
            goto L_0x012f
        L_0x011e:
            android.content.Intent r9 = new android.content.Intent     // Catch:{ MalformedURLException -> 0x0133 }
            java.lang.String r10 = "android.intent.action.VIEW"
            r9.<init>(r10)     // Catch:{ MalformedURLException -> 0x0133 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ MalformedURLException -> 0x0131 }
            r9.setData(r6)     // Catch:{ MalformedURLException -> 0x0131 }
            com.xiaomi.push.service.ag.a((android.content.Context) r4, (java.lang.String) r5, (android.content.Intent) r9)     // Catch:{ MalformedURLException -> 0x0131 }
        L_0x012f:
            r5 = r8
            goto L_0x014d
        L_0x0131:
            r5 = move-exception
            goto L_0x0135
        L_0x0133:
            r5 = move-exception
            r9 = r1
        L_0x0135:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r5)
            java.lang.String r5 = "11"
        L_0x014d:
            r8 = r5
            goto L_0x00c0
        L_0x0150:
            java.lang.String r5 = "6"
            goto L_0x003d
        L_0x0154:
            r5 = r1
        L_0x0155:
            r8 = r2
        L_0x0156:
            boolean r6 = com.xiaomi.push.j.a((android.content.Context) r4)
            if (r6 == 0) goto L_0x018e
            if (r12 == 0) goto L_0x018e
            if (r5 == 0) goto L_0x017c
            android.content.ComponentName r6 = r5.getComponent()
            if (r6 == 0) goto L_0x0178
            if (r8 != r2) goto L_0x016a
            java.lang.String r8 = "1"
        L_0x016a:
            java.lang.String r9 = "xmsf.stat.tgtCompo"
            java.lang.String r9 = a((java.lang.String) r9, (int) r11)
            java.lang.String r6 = r6.flattenToString()
            r12.putString(r9, r6)
            goto L_0x017c
        L_0x0178:
            if (r8 != r2) goto L_0x017c
            java.lang.String r8 = "2"
        L_0x017c:
            java.lang.String r6 = "xmsf.stat.notifyEffect"
            java.lang.String r6 = a((java.lang.String) r6, (int) r11)
            r12.putString(r6, r7)
            java.lang.String r6 = "xmsf.stat.uriParse"
            java.lang.String r6 = a((java.lang.String) r6, (int) r11)
            r12.putString(r6, r8)
        L_0x018e:
            if (r5 == 0) goto L_0x01e8
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r5.addFlags(r6)
            android.content.pm.PackageManager r6 = r4.getPackageManager()     // Catch:{ Exception -> 0x01d1 }
            r8 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r6 = r6.resolveActivity(r5, r8)     // Catch:{ Exception -> 0x01d1 }
            if (r6 == 0) goto L_0x01a2
            return r5
        L_0x01a2:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01d1 }
            r8 = 30
            if (r6 < r8) goto L_0x01b7
            boolean r4 = com.xiaomi.push.j.a((android.content.Context) r4)     // Catch:{ Exception -> 0x01d1 }
            if (r4 != 0) goto L_0x01b7
            java.lang.String r4 = com.xiaomi.push.service.an.f52486c     // Catch:{ Exception -> 0x01d1 }
            boolean r4 = r4.equals(r7)     // Catch:{ Exception -> 0x01d1 }
            if (r4 == 0) goto L_0x01b7
            return r5
        L_0x01b7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d1 }
            r4.<init>()     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r6 = "not resolve activity:"
            r4.append(r6)     // Catch:{ Exception -> 0x01d1 }
            r4.append(r5)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r5 = "for buttons"
            r4.append(r5)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01d1 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r4)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x01e8
        L_0x01d1:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r4)
        L_0x01e8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, android.os.Bundle):android.content.Intent");
    }

    @TargetApi(16)
    private static dw a(Context context, hc hcVar, byte[] bArr, String str, int i11) {
        Bitmap bitmap;
        String a11 = a(hcVar);
        Map a12 = hcVar.a().a();
        String str2 = (String) a12.get("notification_style_type");
        dw a13 = (!j.a(context) || f3432a == null) ? null : f3432a.a(context, i11, a11, (Map<String, String>) a12);
        if (a13 != null) {
            a13.a((Map<String, String>) a12);
            return a13;
        } else if ("2".equals(str2)) {
            dw dwVar = new dw(context);
            if (TextUtils.isEmpty((String) a12.get("notification_bigPic_uri"))) {
                bitmap = null;
            } else {
                bitmap = a(context, (String) a12.get("notification_bigPic_uri"), false);
            }
            if (bitmap == null) {
                com.xiaomi.channel.commonutils.logger.b.a("can not get big picture.");
                return dwVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(dwVar);
            bigPictureStyle.bigPicture(bitmap);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            dwVar.setStyle(bigPictureStyle);
            return dwVar;
        } else if ("1".equals(str2)) {
            dw dwVar2 = new dw(context);
            dwVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return dwVar2;
        } else if ("4".equals(str2) && j.a()) {
            dv dvVar = new dv(context, a11);
            if (!TextUtils.isEmpty((CharSequence) a12.get("notification_banner_image_uri"))) {
                dvVar.setLargeIcon(a(context, (String) a12.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty((CharSequence) a12.get("notification_banner_icon_uri"))) {
                dvVar.b(a(context, (String) a12.get("notification_banner_icon_uri"), false));
            }
            dvVar.a((Map<String, String>) a12);
            return dvVar;
        } else if (!"3".equals(str2) || !j.a()) {
            return new dw(context);
        } else {
            dx dxVar = new dx(context, i11, a11);
            if (!TextUtils.isEmpty((CharSequence) a12.get("notification_colorful_button_text"))) {
                Bundle bundle = new Bundle();
                PendingIntent a14 = a(context, a11, hcVar, bArr, i11, 4, bundle);
                if (a14 != null) {
                    dxVar.a((CharSequence) a12.get("notification_colorful_button_text"), a14).a((String) a12.get("notification_colorful_button_bg_color"));
                }
                dxVar.addExtras(bundle);
            }
            if (!TextUtils.isEmpty((CharSequence) a12.get("notification_colorful_bg_color"))) {
                dxVar.b((String) a12.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty((CharSequence) a12.get("notification_colorful_bg_image_uri"))) {
                dxVar.a(a(context, (String) a12.get("notification_colorful_bg_image_uri"), false));
            }
            dxVar.a((Map<String, String>) a12);
            return dxVar;
        }
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get(OptionsBridge.TIMEOUT_KEY);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static RemoteViews a(Context context, hc hcVar, byte[] bArr) {
        gt a11 = hcVar.a();
        String a12 = a(hcVar);
        if (!(a11 == null || a11.a() == null)) {
            Map a13 = a11.a();
            String str = (String) a13.get("layout_name");
            String str2 = (String) a13.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a12);
                    int identifier = resourcesForApplication.getIdentifier(str, TtmlNode.TAG_LAYOUT, a12);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a12, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a12);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a12);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a12);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has(CrashHianalyticsData.TIME)) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject(CrashHianalyticsData.TIME);
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a12);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e11) {
                        com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e12) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e12);
                }
            }
        }
        return null;
    }

    private static Bitmap a(Context context, int i11) {
        return a(context.getResources().getDrawable(i11));
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i11 = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i11 = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i11, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static Notification a(Notification notification) {
        Object a11 = ax.a((Object) notification, "extraNotification");
        if (a11 != null) {
            ax.a(a11, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static String a(hc hcVar) {
        gt a11;
        if (!(!"com.xiaomi.xmsf".equals(hcVar.f3069b) || (a11 = hcVar.a()) == null || a11.a() == null)) {
            String str = (String) a11.a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hcVar.f3069b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m3059a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i11) {
        a(context, str, i11, -1);
    }

    public static void a(Context context, String str, int i11, int i12) {
        int i13;
        if (context != null && !TextUtils.isEmpty(str) && i11 >= -1) {
            af a11 = af.a(context, str);
            List b11 = a11.b();
            if (!t.a(b11)) {
                LinkedList linkedList = new LinkedList();
                boolean z11 = false;
                if (i11 == -1) {
                    z11 = true;
                    i13 = 0;
                } else {
                    i13 = ((str.hashCode() / 10) * 10) + i11;
                }
                Iterator it2 = b11.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    StatusBarNotification statusBarNotification = (StatusBarNotification) it2.next();
                    if (!TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                        int id2 = statusBarNotification.getId();
                        if (z11) {
                            linkedList.add(statusBarNotification);
                            a11.a(id2);
                        } else if (i13 == id2) {
                            d.a(context, statusBarNotification, i12);
                            linkedList.add(statusBarNotification);
                            a11.a(id2);
                            break;
                        }
                    }
                }
                a(context, (LinkedList<? extends Object>) linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            af a11 = af.a(context, str);
            List<StatusBarNotification> b11 = a11.b();
            if (!t.a(b11)) {
                LinkedList linkedList = new LinkedList();
                for (StatusBarNotification statusBarNotification : b11) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                        int id2 = statusBarNotification.getId();
                        String a12 = ag.a(notification);
                        String b12 = ag.b(notification);
                        if (!TextUtils.isEmpty(a12) && !TextUtils.isEmpty(b12) && a(a12, str2) && a(b12, str3)) {
                            linkedList.add(statusBarNotification);
                            a11.a(id2);
                        }
                    }
                }
                a(context, (LinkedList<? extends Object>) linkedList);
            }
        }
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            az.a(context, "category_clear_notification", "clear_notification", (long) linkedList.size(), "");
        }
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3063a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static boolean a(gt gtVar) {
        if (gtVar == null) {
            return false;
        }
        String a11 = gtVar.a();
        if (TextUtils.isEmpty(a11) || a11.length() != 22 || "satuigmo".indexOf(a11.charAt(0)) < 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3062a(hc hcVar) {
        gt a11 = hcVar.a();
        return a(a11) && a11.l();
    }

    private static Bitmap a(Context context, String str, boolean z11) {
        Future submit = f3434a.submit(new a(str, context, z11));
        try {
            Bitmap bitmap = (Bitmap) submit.get(180, TimeUnit.SECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            submit.cancel(true);
            return bitmap;
        } catch (InterruptedException e11) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
        } catch (ExecutionException e12) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e12);
        } catch (TimeoutException e13) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e13);
        } catch (Throwable th2) {
            submit.cancel(true);
            throw th2;
        }
        submit.cancel(true);
        return null;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(map.get("channel_name"))) {
            return g.b(context, str);
        }
        return map.get("channel_name");
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i11) {
        return b(context, str, map, i11, (Bundle) null);
    }

    private static void a(Intent intent) {
        if (intent != null) {
            int flags = intent.getFlags() & -2 & -3 & -65;
            if (Build.VERSION.SDK_INT >= 21) {
                flags &= -129;
            }
            intent.setFlags(flags);
        }
    }

    private static void a(Context context, String str, dw dwVar, Map<String, String> map) {
        int a11 = a(context, str, "mipush_small_notification");
        int a12 = a(context, str, "mipush_notification");
        if (!j.a(context)) {
            if (a11 > 0) {
                dwVar.setSmallIcon(a11);
            } else {
                b(context, str, dwVar, map);
            }
            if (a12 > 0) {
                dwVar.setLargeIcon(a(context, a12));
            }
        } else if (a11 <= 0 || a12 <= 0) {
            b(context, str, dwVar, map);
        } else {
            dwVar.setSmallIcon(a11);
            dwVar.setLargeIcon(a(context, a12));
        }
    }
}
