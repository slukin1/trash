package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static int f38401a;

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x019b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01a0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r8, com.huawei.hms.push.o r9) {
        /*
            java.lang.Class<com.huawei.hms.push.n> r0 = com.huawei.hms.push.n.class
            monitor-enter(r0)
            if (r8 == 0) goto L_0x019f
            boolean r1 = a((com.huawei.hms.push.o) r9)     // Catch:{ all -> 0x019c }
            if (r1 == 0) goto L_0x000d
            goto L_0x019f
        L_0x000d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r1.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r2 = "showNotification, the msg id = "
            r1.append(r2)     // Catch:{ all -> 0x019c }
            java.lang.String r2 = r9.o()     // Catch:{ all -> 0x019c }
            r1.append(r2)     // Catch:{ all -> 0x019c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x019c }
            java.lang.String r2 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.d(r2, r1)     // Catch:{ all -> 0x019c }
            int r1 = f38401a     // Catch:{ all -> 0x019c }
            if (r1 != 0) goto L_0x0048
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r1.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r2 = r8.getPackageName()     // Catch:{ all -> 0x019c }
            r1.append(r2)     // Catch:{ all -> 0x019c }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019c }
            r1.append(r2)     // Catch:{ all -> 0x019c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x019c }
            int r1 = r1.hashCode()     // Catch:{ all -> 0x019c }
            f38401a = r1     // Catch:{ all -> 0x019c }
        L_0x0048:
            java.lang.String r1 = r9.k()     // Catch:{ all -> 0x019c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x019c }
            r2 = 1
            if (r1 == 0) goto L_0x00d1
            java.lang.String r1 = r9.p()     // Catch:{ all -> 0x019c }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x019c }
            if (r3 != 0) goto L_0x007a
            int r1 = r1.hashCode()     // Catch:{ all -> 0x019c }
            r9.a((int) r1)     // Catch:{ all -> 0x019c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r3.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r4 = "notification msgTag = "
            r3.append(r4)     // Catch:{ all -> 0x019c }
            r3.append(r1)     // Catch:{ all -> 0x019c }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x019c }
            java.lang.String r3 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.d(r3, r1)     // Catch:{ all -> 0x019c }
        L_0x007a:
            int r1 = r9.r()     // Catch:{ all -> 0x019c }
            r3 = -1
            if (r1 == r3) goto L_0x00c5
            int r1 = r9.r()     // Catch:{ all -> 0x019c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r3.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r4 = r9.j()     // Catch:{ all -> 0x019c }
            r3.append(r4)     // Catch:{ all -> 0x019c }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019c }
            r3.append(r4)     // Catch:{ all -> 0x019c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x019c }
            int r3 = r3.hashCode()     // Catch:{ all -> 0x019c }
            int r4 = r3 + 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r5.<init>()     // Catch:{ all -> 0x019c }
            int r6 = r9.r()     // Catch:{ all -> 0x019c }
            r5.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r6 = r9.j()     // Catch:{ all -> 0x019c }
            r5.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r6 = r8.getPackageName()     // Catch:{ all -> 0x019c }
            r5.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x019c }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x019c }
            goto L_0x0115
        L_0x00c5:
            int r1 = f38401a     // Catch:{ all -> 0x019c }
            int r1 = r1 + r2
            int r3 = r1 + 1
            int r4 = r3 + 1
            int r5 = r4 + 1
            f38401a = r5     // Catch:{ all -> 0x019c }
            goto L_0x0115
        L_0x00d1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r1.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r3 = r9.k()     // Catch:{ all -> 0x019c }
            r1.append(r3)     // Catch:{ all -> 0x019c }
            java.lang.String r3 = r9.j()     // Catch:{ all -> 0x019c }
            r1.append(r3)     // Catch:{ all -> 0x019c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x019c }
            int r1 = r1.hashCode()     // Catch:{ all -> 0x019c }
            int r3 = f38401a     // Catch:{ all -> 0x019c }
            int r3 = r3 + r2
            int r4 = r3 + 1
            f38401a = r4     // Catch:{ all -> 0x019c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r5.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r6 = r9.k()     // Catch:{ all -> 0x019c }
            r5.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r6 = r9.j()     // Catch:{ all -> 0x019c }
            r5.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r6 = r8.getPackageName()     // Catch:{ all -> 0x019c }
            r5.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x019c }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x019c }
        L_0x0115:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r6.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r7 = "notifyId:"
            r6.append(r7)     // Catch:{ all -> 0x019c }
            r6.append(r1)     // Catch:{ all -> 0x019c }
            java.lang.String r7 = ",openNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x019c }
            r6.append(r3)     // Catch:{ all -> 0x019c }
            java.lang.String r7 = ",delNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x019c }
            r6.append(r4)     // Catch:{ all -> 0x019c }
            java.lang.String r7 = ",alarmNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x019c }
            r6.append(r5)     // Catch:{ all -> 0x019c }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x019c }
            java.lang.String r7 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.d(r7, r6)     // Catch:{ all -> 0x019c }
            r6 = 4
            int[] r6 = new int[r6]     // Catch:{ all -> 0x019c }
            r7 = 0
            r6[r7] = r1     // Catch:{ all -> 0x019c }
            r6[r2] = r3     // Catch:{ all -> 0x019c }
            r2 = 2
            r6[r2] = r4     // Catch:{ all -> 0x019c }
            int r2 = r9.e()     // Catch:{ all -> 0x019c }
            if (r2 <= 0) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            r5 = r7
        L_0x0156:
            r2 = 3
            r6[r2] = r5     // Catch:{ all -> 0x019c }
            r3 = 0
            boolean r4 = com.huawei.hms.push.e.d()     // Catch:{ all -> 0x019c }
            if (r4 == 0) goto L_0x0164
            android.app.Notification r3 = a((android.content.Context) r8, (com.huawei.hms.push.o) r9, (int[]) r6)     // Catch:{ all -> 0x019c }
        L_0x0164:
            java.lang.String r4 = "notification"
            java.lang.Object r4 = r8.getSystemService(r4)     // Catch:{ all -> 0x019c }
            android.app.NotificationManager r4 = (android.app.NotificationManager) r4     // Catch:{ all -> 0x019c }
            if (r4 == 0) goto L_0x019a
            if (r3 == 0) goto L_0x019a
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x019c }
            r6 = 26
            if (r5 < r6) goto L_0x018a
            java.lang.String r5 = "hms_push_channel"
            int r5 = com.huawei.hms.utils.ResourceLoaderUtil.getStringId(r5)     // Catch:{ all -> 0x019c }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ all -> 0x019c }
            android.app.NotificationChannel r6 = new android.app.NotificationChannel     // Catch:{ all -> 0x019c }
            java.lang.String r7 = "HwPushChannelID"
            r6.<init>(r7, r5, r2)     // Catch:{ all -> 0x019c }
            r4.createNotificationChannel(r6)     // Catch:{ all -> 0x019c }
        L_0x018a:
            r4.notify(r1, r3)     // Catch:{ all -> 0x019c }
            java.lang.String r1 = r9.o()     // Catch:{ all -> 0x019c }
            java.lang.String r9 = r9.b()     // Catch:{ all -> 0x019c }
            java.lang.String r2 = "100"
            com.huawei.hms.push.l.a(r8, r1, r9, r2)     // Catch:{ all -> 0x019c }
        L_0x019a:
            monitor-exit(r0)
            return
        L_0x019c:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        L_0x019f:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.n.a(android.content.Context, com.huawei.hms.push.o):void");
    }

    private static PendingIntent b(Context context, o oVar, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], a(context, oVar, iArr, "2", 268435456), e.a());
    }

    private static PendingIntent c(Context context, o oVar, int[] iArr) {
        Intent a11 = a(context, oVar, iArr, "1", 268435456);
        if (!a()) {
            return PendingIntent.getBroadcast(context, iArr[1], a11, e.a());
        }
        a11.setClass(context, TransActivity.class);
        a11.setFlags(268468224);
        return PendingIntent.getActivity(context, iArr[1], a11, e.a());
    }

    private static void d(o oVar, Notification.Builder builder) {
        String t11 = oVar.t();
        String i11 = oVar.i();
        if (TextUtils.isEmpty(i11)) {
            builder.setContentText(t11);
            return;
        }
        builder.setContentText(i11);
        if (!TextUtils.isEmpty(t11)) {
            builder.setContentTitle(t11);
        }
    }

    @SuppressLint({"NewApi"})
    private static void b(Context context, Notification.Builder builder, o oVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String j11 = oVar.j();
            if (!TextUtils.isEmpty(j11)) {
                bundle.putString("hw_origin_sender_package_name", j11);
                builder.setExtras(bundle);
            }
        }
    }

    private static void c(o oVar, Notification.Builder builder) {
        builder.setTicker(oVar.w());
    }

    private static void b(o oVar, Notification.Builder builder) {
        String s11 = oVar.s();
        if (!TextUtils.isEmpty(s11)) {
            builder.setSubText(s11);
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static Intent a(Context context, o oVar, int[] iArr, String str, int i11) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", oVar.n()).putExtra("selfshow_token", oVar.x()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i11);
        return intent;
    }

    private static Notification a(Context context, o oVar, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (j.a(oVar) == k.STYLE_BIGTEXT) {
            j.a(builder, oVar.f(), oVar);
        }
        h.a(context, builder, oVar);
        b(oVar, builder);
        d(oVar, builder);
        a(context, oVar, builder);
        a(builder);
        a(oVar, builder);
        c(oVar, builder);
        builder.setContentIntent(c(context, oVar, iArr));
        builder.setDeleteIntent(b(context, oVar, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        b(context, builder, oVar);
        a(context, builder, oVar);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    private static void a(Context context, Notification.Builder builder, o oVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11 && e.a(context)) {
            Bundle bundle = new Bundle();
            String j11 = oVar.j();
            HMSLog.i("PushSelfShowLog", "the package name of notification is:" + j11);
            if (!TextUtils.isEmpty(j11)) {
                String a11 = e.a(context, j11);
                HMSLog.i("PushSelfShowLog", "the app name is:" + a11);
                if (a11 != null) {
                    bundle.putCharSequence("android.extraAppName", a11);
                }
            }
            builder.setExtras(bundle);
        }
    }

    private static void a(Context context, o oVar, Notification.Builder builder) {
        Bitmap a11 = h.a(context, oVar);
        if (a11 != null) {
            builder.setLargeIcon(a11);
        }
    }

    private static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    private static void a(o oVar, Notification.Builder builder) {
        boolean z11 = true;
        if (oVar.d() != 1) {
            z11 = false;
        }
        builder.setAutoCancel(z11);
        builder.setOngoing(false);
    }

    private static boolean a(o oVar) {
        return oVar == null || (TextUtils.isEmpty(oVar.t()) && TextUtils.isEmpty(oVar.i()));
    }
}
