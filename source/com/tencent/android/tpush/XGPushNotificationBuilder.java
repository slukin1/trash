package com.tencent.android.tpush;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.g;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import org.json.JSONObject;

public abstract class XGPushNotificationBuilder {
    public static final String BASIC_NOTIFICATION_BUILDER_TYPE = "basic";
    public static final String CUSTOM_NOTIFICATION_BUILDER_TYPE = "custom";
    public String A;
    public Integer B = null;
    public Bitmap C = null;
    public Integer D = null;
    public String E = null;
    private String F = "xg-channle-id";
    private boolean G = false;

    /* renamed from: a  reason: collision with root package name */
    public String f68026a = "xg-channle-id";

    /* renamed from: b  reason: collision with root package name */
    public String f68027b = "message";

    /* renamed from: c  reason: collision with root package name */
    public Integer f68028c = null;

    /* renamed from: d  reason: collision with root package name */
    public PendingIntent f68029d = null;

    /* renamed from: e  reason: collision with root package name */
    public RemoteViews f68030e = null;

    /* renamed from: f  reason: collision with root package name */
    public RemoteViews f68031f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f68032g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f68033h = 0;

    /* renamed from: i  reason: collision with root package name */
    public Integer f68034i = null;
    public Boolean isSupportNotificationGroup;

    /* renamed from: j  reason: collision with root package name */
    public PendingIntent f68035j = null;

    /* renamed from: k  reason: collision with root package name */
    public Integer f68036k = null;

    /* renamed from: l  reason: collision with root package name */
    public Integer f68037l = null;

    /* renamed from: m  reason: collision with root package name */
    public Integer f68038m = null;

    /* renamed from: n  reason: collision with root package name */
    public Integer f68039n = null;

    /* renamed from: o  reason: collision with root package name */
    public Integer f68040o = null;

    /* renamed from: p  reason: collision with root package name */
    public Integer f68041p = null;

    /* renamed from: q  reason: collision with root package name */
    public Integer f68042q = null;

    /* renamed from: r  reason: collision with root package name */
    public Uri f68043r = null;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f68044s = null;

    /* renamed from: t  reason: collision with root package name */
    public long[] f68045t = null;

    /* renamed from: u  reason: collision with root package name */
    public Long f68046u = null;

    /* renamed from: v  reason: collision with root package name */
    public Integer f68047v = null;

    /* renamed from: w  reason: collision with root package name */
    public Bitmap f68048w = null;

    /* renamed from: x  reason: collision with root package name */
    public Integer f68049x = null;

    /* renamed from: y  reason: collision with root package name */
    public String f68050y = "";

    /* renamed from: z  reason: collision with root package name */
    public int f68051z = -1;

    /* JADX WARNING: Removed duplicated region for block: B:71:0x0314 A[Catch:{ all -> 0x03b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0366 A[Catch:{ all -> 0x03b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0386 A[Catch:{ all -> 0x03b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0394 A[Catch:{ all -> 0x03b5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object a(android.app.Notification.Builder r21, android.content.Context r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r4 = "android.app.NotificationChannel"
            java.lang.String r5 = "android.media.AudioAttributes"
            java.lang.String r0 = "xg-channle-id"
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            java.lang.String r7 = "XGPushNotificationBuilder"
            java.lang.String r9 = r1.getChannelId(r3)     // Catch:{ all -> 0x03ba }
            int r10 = r1.f68051z     // Catch:{ all -> 0x03ba }
            r11 = -1
            if (r10 != r11) goto L_0x001a
            r10 = 4
        L_0x001a:
            boolean r11 = r9.equals(r0)     // Catch:{ all -> 0x03ba }
            java.lang.String r13 = "enableLights"
            java.lang.String r14 = "enableVibration"
            java.lang.String r15 = "setSound"
            java.lang.String r12 = "setChannelId"
            r17 = 0
            if (r11 == 0) goto L_0x0225
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0221 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0221 }
            r11 = 3
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ all -> 0x0221 }
            r8[r17] = r6     // Catch:{ all -> 0x0221 }
            java.lang.Class<java.lang.CharSequence> r11 = java.lang.CharSequence.class
            r16 = 1
            r8[r16] = r11     // Catch:{ all -> 0x0221 }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0221 }
            r16 = 2
            r8[r16] = r11     // Catch:{ all -> 0x0221 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r8)     // Catch:{ all -> 0x0221 }
            java.lang.Integer r8 = r1.f68034i     // Catch:{ all -> 0x0221 }
            if (r8 != 0) goto L_0x0051
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0221 }
            r1.f68034i = r8     // Catch:{ all -> 0x0221 }
        L_0x0051:
            java.lang.Integer r8 = r1.f68034i     // Catch:{ all -> 0x0221 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0221 }
            switch(r8) {
                case 0: goto L_0x006e;
                case 1: goto L_0x006b;
                case 2: goto L_0x0068;
                case 3: goto L_0x0065;
                case 4: goto L_0x0062;
                case 5: goto L_0x005f;
                case 6: goto L_0x005c;
                case 7: goto L_0x0070;
                default: goto L_0x005a;
            }     // Catch:{ all -> 0x0221 }
        L_0x005a:
            r0 = r9
            goto L_0x0070
        L_0x005c:
            java.lang.String r0 = "xg-l-v-channle-id"
            goto L_0x0070
        L_0x005f:
            java.lang.String r0 = "xg-s-l-channle-id"
            goto L_0x0070
        L_0x0062:
            java.lang.String r0 = "xg-l-channle-id"
            goto L_0x0070
        L_0x0065:
            java.lang.String r0 = "xg-s-v-channle-id"
            goto L_0x0070
        L_0x0068:
            java.lang.String r0 = "xg-v-channle-id"
            goto L_0x0070
        L_0x006b:
            java.lang.String r0 = "xg-s-channle-id"
            goto L_0x0070
        L_0x006e:
            java.lang.String r0 = "xg-n-channle-id"
        L_0x0070:
            android.net.Uri r8 = r1.f68043r     // Catch:{ all -> 0x0221 }
            if (r8 == 0) goto L_0x00bd
            java.lang.String r0 = com.tencent.android.tpush.service.util.c.a((android.content.Context) r3, (android.net.Uri) r8)     // Catch:{ all -> 0x0221 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0221 }
            r8.<init>()     // Catch:{ all -> 0x0221 }
            java.lang.String r9 = "get exist channel: "
            r8.append(r9)     // Catch:{ all -> 0x0221 }
            r8.append(r0)     // Catch:{ all -> 0x0221 }
            java.lang.String r9 = " with sound "
            r8.append(r9)     // Catch:{ all -> 0x0221 }
            android.net.Uri r9 = r1.f68043r     // Catch:{ all -> 0x0221 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0221 }
            r8.append(r9)     // Catch:{ all -> 0x0221 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0221 }
            com.tencent.android.tpush.logging.TLogger.d(r7, r8)     // Catch:{ all -> 0x0221 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0221 }
            if (r8 != 0) goto L_0x00a1
            goto L_0x00bd
        L_0x00a1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0221 }
            r0.<init>()     // Catch:{ all -> 0x0221 }
            java.lang.String r8 = r1.getChannelId(r3)     // Catch:{ all -> 0x0221 }
            r0.append(r8)     // Catch:{ all -> 0x0221 }
            java.lang.String r8 = "-"
            r0.append(r8)     // Catch:{ all -> 0x0221 }
            int r8 = r1.b((android.content.Context) r3)     // Catch:{ all -> 0x0221 }
            r0.append(r8)     // Catch:{ all -> 0x0221 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0221 }
        L_0x00bd:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0221 }
            r8.<init>()     // Catch:{ all -> 0x0221 }
            java.lang.String r9 = "XGPushNotification create notificationChannle, channelId:"
            r8.append(r9)     // Catch:{ all -> 0x0221 }
            r8.append(r0)     // Catch:{ all -> 0x0221 }
            java.lang.String r9 = ", channelName:"
            r8.append(r9)     // Catch:{ all -> 0x0221 }
            java.lang.String r9 = r1.getChannelName(r3)     // Catch:{ all -> 0x0221 }
            r8.append(r9)     // Catch:{ all -> 0x0221 }
            java.lang.String r9 = ", importance:"
            r8.append(r9)     // Catch:{ all -> 0x0221 }
            r8.append(r10)     // Catch:{ all -> 0x0221 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0221 }
            com.tencent.android.tpush.logging.TLogger.i(r7, r8)     // Catch:{ all -> 0x0221 }
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0221 }
            r8[r17] = r0     // Catch:{ all -> 0x0221 }
            java.lang.String r3 = r1.getChannelName(r3)     // Catch:{ all -> 0x0221 }
            r9 = 1
            r8[r9] = r3     // Catch:{ all -> 0x0221 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0221 }
            r9 = 2
            r8[r9] = r3     // Catch:{ all -> 0x0221 }
            java.lang.Object r3 = r4.newInstance(r8)     // Catch:{ all -> 0x0221 }
            java.lang.Class r4 = r3.getClass()     // Catch:{ all -> 0x03b5 }
            java.lang.Class[] r8 = new java.lang.Class[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Class<android.net.Uri> r9 = android.net.Uri.class
            r8[r17] = r9     // Catch:{ all -> 0x03b5 }
            r9 = 1
            r8[r9] = r5     // Catch:{ all -> 0x03b5 }
            java.lang.reflect.Method r4 = r4.getMethod(r15, r8)     // Catch:{ all -> 0x03b5 }
            java.lang.Class r5 = r3.getClass()     // Catch:{ all -> 0x03b5 }
            java.lang.Class[] r8 = new java.lang.Class[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x03b5 }
            r8[r17] = r9     // Catch:{ all -> 0x03b5 }
            java.lang.reflect.Method r5 = r5.getMethod(r14, r8)     // Catch:{ all -> 0x03b5 }
            java.lang.Class r8 = r3.getClass()     // Catch:{ all -> 0x03b5 }
            r10 = 1
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ all -> 0x03b5 }
            r11[r17] = r9     // Catch:{ all -> 0x03b5 }
            java.lang.reflect.Method r8 = r8.getMethod(r13, r11)     // Catch:{ all -> 0x03b5 }
            java.lang.Integer r9 = r1.f68034i     // Catch:{ all -> 0x03b5 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x03b5 }
            switch(r9) {
                case 0: goto L_0x01dd;
                case 1: goto L_0x01cb;
                case 2: goto L_0x01ac;
                case 3: goto L_0x0198;
                case 4: goto L_0x0179;
                case 5: goto L_0x0164;
                case 6: goto L_0x0146;
                case 7: goto L_0x0133;
                default: goto L_0x0131;
            }     // Catch:{ all -> 0x03b5 }
        L_0x0131:
            goto L_0x01f9
        L_0x0133:
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r10[r17] = r11     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            r5[r17] = r11     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
            goto L_0x01f9
        L_0x0146:
            r9 = 2
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            r9 = 0
            r10[r17] = r9     // Catch:{ all -> 0x03b5 }
            r11 = 1
            r10[r11] = r9     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r9[r17] = r10     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r9)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            r5[r17] = r10     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
            goto L_0x01f9
        L_0x0164:
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r10[r17] = r11     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r5[r17] = r9     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
            goto L_0x01f9
        L_0x0179:
            r9 = 2
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            r9 = 0
            r10[r17] = r9     // Catch:{ all -> 0x03b5 }
            r11 = 1
            r10[r11] = r9     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r9[r17] = r10     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r9)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r5[r17] = r9     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
            goto L_0x01f9
        L_0x0198:
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r10[r17] = r11     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r5[r17] = r9     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
            goto L_0x01f9
        L_0x01ac:
            r9 = 2
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            r9 = 0
            r10[r17] = r9     // Catch:{ all -> 0x03b5 }
            r11 = 1
            r10[r11] = r9     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r9[r17] = r10     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r9)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r5[r17] = r9     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
            goto L_0x01f9
        L_0x01cb:
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r10[r17] = r11     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            r5[r17] = r11     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
            goto L_0x01f9
        L_0x01dd:
            r9 = 2
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x03b5 }
            r9 = 0
            r10[r17] = r9     // Catch:{ all -> 0x03b5 }
            r11 = 1
            r10[r11] = r9     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r9[r17] = r10     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r9)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            r5[r17] = r10     // Catch:{ all -> 0x03b5 }
            r8.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
        L_0x01f9:
            android.net.Uri r5 = r1.f68043r     // Catch:{ all -> 0x03b5 }
            if (r5 == 0) goto L_0x0209
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x03b5 }
            r8[r17] = r5     // Catch:{ all -> 0x03b5 }
            r5 = 0
            r9 = 1
            r8[r9] = r5     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r8)     // Catch:{ all -> 0x03b5 }
        L_0x0209:
            java.lang.Class r4 = r21.getClass()     // Catch:{ all -> 0x03b5 }
            r5 = 1
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ all -> 0x03b5 }
            r8[r17] = r6     // Catch:{ all -> 0x03b5 }
            java.lang.reflect.Method r4 = r4.getMethod(r12, r8)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x03b5 }
            r5[r17] = r0     // Catch:{ all -> 0x03b5 }
            r4.invoke(r2, r5)     // Catch:{ all -> 0x03b5 }
            r1.F = r0     // Catch:{ all -> 0x03b5 }
            goto L_0x03d9
        L_0x0221:
            r0 = move-exception
            r8 = 0
            goto L_0x03bd
        L_0x0225:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r0.<init>()     // Catch:{ all -> 0x03ba }
            java.lang.String r8 = "XGPushNotification create notificationChannel has channelId:"
            r0.append(r8)     // Catch:{ all -> 0x03ba }
            r0.append(r9)     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03ba }
            com.tencent.android.tpush.logging.TLogger.i(r7, r0)     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch:{ all -> 0x028d }
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0     // Catch:{ all -> 0x028d }
            java.lang.Class r8 = r0.getClass()     // Catch:{ all -> 0x028d }
            java.lang.String r11 = "getNotificationChannel"
            r18 = r13
            r19 = r14
            r13 = 1
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x028b }
            r14[r17] = r6     // Catch:{ all -> 0x028b }
            java.lang.reflect.Method r8 = r8.getMethod(r11, r14)     // Catch:{ all -> 0x028b }
            java.lang.Object[] r11 = new java.lang.Object[r13]     // Catch:{ all -> 0x028b }
            r11[r17] = r9     // Catch:{ all -> 0x028b }
            java.lang.Object r8 = r8.invoke(r0, r11)     // Catch:{ all -> 0x028b }
            r1.F = r9     // Catch:{ all -> 0x0289 }
            if (r8 == 0) goto L_0x02ae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0289 }
            r0.<init>()     // Catch:{ all -> 0x0289 }
            java.lang.String r11 = "Use old notificationChannel id:"
            r0.append(r11)     // Catch:{ all -> 0x0289 }
            r0.append(r9)     // Catch:{ all -> 0x0289 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0289 }
            com.tencent.android.tpush.logging.TLogger.ii(r7, r0)     // Catch:{ all -> 0x0289 }
            java.lang.Class r0 = r21.getClass()     // Catch:{ all -> 0x0289 }
            r11 = 1
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x0289 }
            r13[r17] = r6     // Catch:{ all -> 0x0289 }
            java.lang.reflect.Method r0 = r0.getMethod(r12, r13)     // Catch:{ all -> 0x0289 }
            java.lang.Object[] r13 = new java.lang.Object[r11]     // Catch:{ all -> 0x0289 }
            r13[r17] = r9     // Catch:{ all -> 0x0289 }
            r0.invoke(r2, r13)     // Catch:{ all -> 0x0289 }
            return r8
        L_0x0289:
            r0 = move-exception
            goto L_0x0293
        L_0x028b:
            r0 = move-exception
            goto L_0x0292
        L_0x028d:
            r0 = move-exception
            r18 = r13
            r19 = r14
        L_0x0292:
            r8 = 0
        L_0x0293:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b8 }
            r11.<init>()     // Catch:{ all -> 0x03b8 }
            java.lang.String r13 = "XGPushNotification getNotificationChannel Error: "
            r11.append(r13)     // Catch:{ all -> 0x03b8 }
            java.lang.String r13 = r0.getMessage()     // Catch:{ all -> 0x03b8 }
            r11.append(r13)     // Catch:{ all -> 0x03b8 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03b8 }
            com.tencent.android.tpush.logging.TLogger.ee(r7, r11)     // Catch:{ all -> 0x03b8 }
            r0.printStackTrace()     // Catch:{ all -> 0x03b8 }
        L_0x02ae:
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x03b8 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x03b8 }
            r5 = 3
            java.lang.Class[] r11 = new java.lang.Class[r5]     // Catch:{ all -> 0x03b8 }
            r11[r17] = r6     // Catch:{ all -> 0x03b8 }
            java.lang.Class<java.lang.CharSequence> r5 = java.lang.CharSequence.class
            r13 = 1
            r11[r13] = r5     // Catch:{ all -> 0x03b8 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x03b8 }
            r13 = 2
            r11[r13] = r5     // Catch:{ all -> 0x03b8 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r11)     // Catch:{ all -> 0x03b8 }
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x03b8 }
            r5[r17] = r9     // Catch:{ all -> 0x03b8 }
            java.lang.String r3 = r1.getChannelName(r3)     // Catch:{ all -> 0x03b8 }
            r11 = 1
            r5[r11] = r3     // Catch:{ all -> 0x03b8 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x03b8 }
            r10 = 2
            r5[r10] = r3     // Catch:{ all -> 0x03b8 }
            java.lang.Object r3 = r4.newInstance(r5)     // Catch:{ all -> 0x03b8 }
            java.lang.Class r4 = r3.getClass()     // Catch:{ all -> 0x03b5 }
            java.lang.Class[] r5 = new java.lang.Class[r10]     // Catch:{ all -> 0x03b5 }
            java.lang.Class<android.net.Uri> r8 = android.net.Uri.class
            r5[r17] = r8     // Catch:{ all -> 0x03b5 }
            r8 = 1
            r5[r8] = r0     // Catch:{ all -> 0x03b5 }
            java.lang.reflect.Method r0 = r4.getMethod(r15, r5)     // Catch:{ all -> 0x03b5 }
            java.lang.Class r4 = r3.getClass()     // Catch:{ all -> 0x03b5 }
            java.lang.Class[] r5 = new java.lang.Class[r8]     // Catch:{ all -> 0x03b5 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x03b5 }
            r5[r17] = r8     // Catch:{ all -> 0x03b5 }
            r10 = r19
            java.lang.reflect.Method r4 = r4.getMethod(r10, r5)     // Catch:{ all -> 0x03b5 }
            java.lang.Class r5 = r3.getClass()     // Catch:{ all -> 0x03b5 }
            r10 = 1
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ all -> 0x03b5 }
            r11[r17] = r8     // Catch:{ all -> 0x03b5 }
            r8 = r18
            java.lang.reflect.Method r5 = r5.getMethod(r8, r11)     // Catch:{ all -> 0x03b5 }
            java.lang.Integer r8 = r1.f68034i     // Catch:{ all -> 0x03b5 }
            if (r8 == 0) goto L_0x0366
            int r8 = r8.intValue()     // Catch:{ all -> 0x03b5 }
            r10 = 1
            r8 = r8 & r10
            if (r8 == r10) goto L_0x0327
            r8 = 2
            java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ all -> 0x03b5 }
            r8 = 0
            r11[r17] = r8     // Catch:{ all -> 0x03b5 }
            r11[r10] = r8     // Catch:{ all -> 0x03b5 }
            r0.invoke(r3, r11)     // Catch:{ all -> 0x03b5 }
        L_0x0327:
            java.lang.Integer r8 = r1.f68034i     // Catch:{ all -> 0x03b5 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x03b5 }
            r10 = 2
            r8 = r8 & r10
            if (r8 != r10) goto L_0x033c
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r10[r17] = r8     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            goto L_0x0346
        L_0x033c:
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r10[r17] = r8     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
        L_0x0346:
            java.lang.Integer r4 = r1.f68034i     // Catch:{ all -> 0x03b5 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x03b5 }
            r8 = 4
            r4 = r4 & r8
            if (r4 != r8) goto L_0x035b
            r4 = 1
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r8[r17] = r4     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r8)     // Catch:{ all -> 0x03b5 }
            goto L_0x0382
        L_0x035b:
            r4 = 1
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r8[r17] = r4     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r8)     // Catch:{ all -> 0x03b5 }
            goto L_0x0382
        L_0x0366:
            r8 = 2
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x03b5 }
            r8 = 0
            r10[r17] = r8     // Catch:{ all -> 0x03b5 }
            r11 = 1
            r10[r11] = r8     // Catch:{ all -> 0x03b5 }
            r0.invoke(r3, r10)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r8 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x03b5 }
            r8[r17] = r10     // Catch:{ all -> 0x03b5 }
            r4.invoke(r3, r8)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r4 = new java.lang.Object[r11]     // Catch:{ all -> 0x03b5 }
            r4[r17] = r10     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r4)     // Catch:{ all -> 0x03b5 }
        L_0x0382:
            java.lang.Integer r4 = r1.f68036k     // Catch:{ all -> 0x03b5 }
            if (r4 == 0) goto L_0x0390
            r4 = 1
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x03b5 }
            r8[r17] = r4     // Catch:{ all -> 0x03b5 }
            r5.invoke(r3, r8)     // Catch:{ all -> 0x03b5 }
        L_0x0390:
            android.net.Uri r4 = r1.f68043r     // Catch:{ all -> 0x03b5 }
            if (r4 == 0) goto L_0x03a0
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x03b5 }
            r5[r17] = r4     // Catch:{ all -> 0x03b5 }
            r4 = 0
            r8 = 1
            r5[r8] = r4     // Catch:{ all -> 0x03b5 }
            r0.invoke(r3, r5)     // Catch:{ all -> 0x03b5 }
        L_0x03a0:
            java.lang.Class r0 = r21.getClass()     // Catch:{ all -> 0x03b5 }
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x03b5 }
            r5[r17] = r6     // Catch:{ all -> 0x03b5 }
            java.lang.reflect.Method r0 = r0.getMethod(r12, r5)     // Catch:{ all -> 0x03b5 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x03b5 }
            r4[r17] = r9     // Catch:{ all -> 0x03b5 }
            r0.invoke(r2, r4)     // Catch:{ all -> 0x03b5 }
            goto L_0x03d9
        L_0x03b5:
            r0 = move-exception
            r8 = r3
            goto L_0x03bd
        L_0x03b8:
            r0 = move-exception
            goto L_0x03bd
        L_0x03ba:
            r0 = move-exception
            r4 = 0
            r8 = r4
        L_0x03bd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "XGPushNotification create channel Error: "
            r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.tencent.android.tpush.logging.TLogger.ee(r7, r2)
            r0.printStackTrace()
            r3 = r8
        L_0x03d9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushNotificationBuilder.a(android.app.Notification$Builder, android.content.Context):java.lang.Object");
    }

    private int b(Context context) {
        int i11 = SharePrefsUtil.getInt(context, Constants.SOUND_CHANNEL_COUNT, 0);
        SharePrefsUtil.setInt(context, Constants.SOUND_CHANNEL_COUNT, i11 + 1);
        return i11;
    }

    private Notification c(Context context) {
        NotificationCompat.e eVar = new NotificationCompat.e(context);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        Integer num = this.f68047v;
        if (num != null) {
            eVar.X(num.intValue());
        }
        Integer num2 = this.D;
        if (num2 != null) {
            eVar.x(num2.intValue());
        }
        if (this.f68049x != null) {
            try {
                if (this.f68032g <= 0) {
                    eVar.J(BitmapFactory.decodeResource(context.getResources(), this.f68049x.intValue()));
                }
            } catch (OutOfMemoryError e11) {
                TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setLargeIcon res oom " + e11.toString());
            }
        }
        Bitmap bitmap = this.f68048w;
        if (bitmap != null && this.f68032g <= 0) {
            eVar.J(bitmap);
        }
        String str = this.A;
        if (str == null) {
            this.A = getTitle(context);
        } else {
            eVar.C(str);
        }
        CharSequence charSequence = this.f68044s;
        if (charSequence == null || this.f68030e != null) {
            eVar.B(charSequence);
            eVar.e0(this.f68044s);
        } else {
            bigTextStyle.y(charSequence);
            eVar.c0(bigTextStyle);
            eVar.B(this.f68044s);
            eVar.e0(this.f68044s);
        }
        if (this.C != null) {
            try {
                eVar.c0(new NotificationCompat.BigPictureStyle().A(this.C));
            } catch (Throwable th2) {
                TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setStyle error " + th2.toString());
            }
        }
        if (this.f68032g > 0 && (this.f68033h == 1 || Build.VERSION.SDK_INT >= 31 || ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor())) {
            eVar.c0(new NotificationCompat.DecoratedCustomViewStyle());
        }
        if (this.E != null && Build.VERSION.SDK_INT >= 24) {
            String j11 = d.j();
            if (!MTPushConstants.Manufacturer.OPPO.equals(j11) && ((this.f68032g <= 0 || !"vivo".equals(j11)) && this.f68032g != 3)) {
                eVar.H(this.E);
            }
        }
        eVar.V(true);
        String str2 = this.f68050y;
        if (str2 != null && !TextUtils.isEmpty(str2.trim())) {
            eVar.u(this.f68050y);
        }
        eVar.i0(1);
        return eVar.g();
    }

    public static void createNotificationChannel(Context context, Object obj, XGPushNotificationBuilder xGPushNotificationBuilder) {
        int i11;
        TLogger.d("XGPushNotificationBuilder", "createNotificationChannel");
        if (obj != null) {
            try {
                Class<?> cls = Class.forName("android.app.NotificationChannel");
                if (xGPushNotificationBuilder != null) {
                    try {
                        i11 = xGPushNotificationBuilder.getNotificationImportance();
                    } catch (Throwable unused) {
                    }
                } else {
                    i11 = -1;
                }
                if (i11 != -1) {
                    TLogger.d("XGPushNotificationBuilder", "createNotificationChannel, importance:" + i11);
                    cls.getMethod("setImportance", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i11)});
                }
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{cls}).invoke(notificationManager, new Object[]{obj});
            } catch (Throwable th2) {
                TLogger.ee("XGPushNotificationBuilder", "XGPushNotification createNotificationChannel Error: ", th2);
            }
        }
    }

    public abstract void a(JSONObject jSONObject);

    public abstract void b(JSONObject jSONObject);

    public abstract Pair<Notification, Object> buildNotification(Context context);

    public void decode(String str) {
        JSONObject jSONObject = new JSONObject(str);
        b(jSONObject);
        this.f68028c = (Integer) CommonHelper.jsonGet(jSONObject, "audioStringType", (Object) null);
        this.f68034i = (Integer) CommonHelper.jsonGet(jSONObject, n0.j.a.f32226g, (Object) null);
        this.f68036k = (Integer) CommonHelper.jsonGet(jSONObject, "flags", (Object) null);
        this.f68037l = (Integer) CommonHelper.jsonGet(jSONObject, "icon", (Object) null);
        this.f68038m = (Integer) CommonHelper.jsonGet(jSONObject, "iconLevel", (Object) null);
        this.f68039n = (Integer) CommonHelper.jsonGet(jSONObject, "ledARGB", (Object) null);
        this.f68040o = (Integer) CommonHelper.jsonGet(jSONObject, "ledOffMS", (Object) null);
        this.f68041p = (Integer) CommonHelper.jsonGet(jSONObject, "ledOnMS", (Object) null);
        this.f68042q = (Integer) CommonHelper.jsonGet(jSONObject, "number", (Object) null);
        String str2 = (String) CommonHelper.jsonGet(jSONObject, RemoteMessageConst.Notification.SOUND, (Object) null);
        this.f68047v = (Integer) CommonHelper.jsonGet(jSONObject, "smallIcon", (Object) null);
        this.f68049x = (Integer) CommonHelper.jsonGet(jSONObject, "notificationLargeIcon", (Object) null);
        if (str2 != null) {
            this.f68043r = Uri.parse(str2);
        }
        String str3 = (String) CommonHelper.jsonGet(jSONObject, MessageKey.MSG_VIBRATE, (Object) null);
        if (str3 != null) {
            String[] split = str3.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = split.length;
            this.f68045t = new long[length];
            for (int i11 = 0; i11 < length; i11++) {
                try {
                    this.f68045t[i11] = Long.valueOf(split[i11]).longValue();
                } catch (NumberFormatException e11) {
                    TLogger.w("XGPushNotificationBuilder", "parse vibrate str error " + e11.toString());
                }
            }
        }
        this.B = (Integer) CommonHelper.jsonGet(jSONObject, "notificationId", (Object) null);
        this.E = (String) CommonHelper.jsonGet(jSONObject, "thread_id", (Object) null);
        this.f68050y = (String) CommonHelper.jsonGet(jSONObject, "nCategory", (Object) null);
        this.f68051z = ((Integer) CommonHelper.jsonGet(jSONObject, "nImportance", -1)).intValue();
    }

    public void encode(JSONObject jSONObject) {
        a(jSONObject);
        CommonHelper.jsonPut(jSONObject, "audioStringType", this.f68028c);
        CommonHelper.jsonPut(jSONObject, n0.j.a.f32226g, this.f68034i);
        CommonHelper.jsonPut(jSONObject, "flags", this.f68036k);
        CommonHelper.jsonPut(jSONObject, "icon", this.f68037l);
        CommonHelper.jsonPut(jSONObject, "iconLevel", this.f68038m);
        CommonHelper.jsonPut(jSONObject, "ledARGB", this.f68039n);
        CommonHelper.jsonPut(jSONObject, "ledOffMS", this.f68040o);
        CommonHelper.jsonPut(jSONObject, "ledOnMS", this.f68041p);
        CommonHelper.jsonPut(jSONObject, "number", this.f68042q);
        CommonHelper.jsonPut(jSONObject, RemoteMessageConst.Notification.SOUND, this.f68043r);
        CommonHelper.jsonPut(jSONObject, "smallIcon", this.f68047v);
        CommonHelper.jsonPut(jSONObject, "notificationLargeIcon", this.f68049x);
        if (this.f68045t != null) {
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            while (true) {
                long[] jArr = this.f68045t;
                if (i11 >= jArr.length) {
                    break;
                }
                sb2.append(String.valueOf(jArr[i11]));
                if (i11 != this.f68045t.length - 1) {
                    sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                i11++;
            }
            CommonHelper.jsonPut(jSONObject, MessageKey.MSG_VIBRATE, sb2.toString());
        }
        CommonHelper.jsonPut(jSONObject, "notificationId", this.B);
        CommonHelper.jsonPut(jSONObject, "thread_id", this.E);
        CommonHelper.jsonPut(jSONObject, "nCategory", this.f68050y);
        CommonHelper.jsonPut(jSONObject, "nImportance", Integer.valueOf(this.f68051z));
    }

    public int getApplicationIcon(Context context) {
        return context.getApplicationInfo().icon;
    }

    public int getAudioStringType() {
        return this.f68028c.intValue();
    }

    public String getChannelId(Context context) {
        String notificationChannelID;
        if (!this.f68026a.equals("xg-channle-id") || (notificationChannelID = XGPushConfig.getNotificationChannelID(context)) == null || TextUtils.isEmpty(notificationChannelID)) {
            return this.f68026a;
        }
        return notificationChannelID;
    }

    public String getChannelName(Context context) {
        String notificationChannelName;
        if (!this.f68027b.equals("message") || (notificationChannelName = XGPushConfig.getNotificationChannelName(context)) == null || TextUtils.isEmpty(notificationChannelName)) {
            return this.f68027b;
        }
        return notificationChannelName;
    }

    @SuppressLint({"NewApi"})
    public Pair<Notification, Object> getChannelNotification(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        Integer num = this.f68047v;
        if (num != null) {
            builder.setSmallIcon(num.intValue());
        }
        Integer num2 = this.D;
        if (num2 != null) {
            builder.setColor(num2.intValue());
        }
        if (this.f68049x != null) {
            try {
                if (this.f68032g <= 0) {
                    builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.f68049x.intValue()));
                }
            } catch (OutOfMemoryError e11) {
                TLogger.w("XGPushNotificationBuilder", "getChannelNotification setLargeIcon res oom " + e11.toString());
            }
        }
        Bitmap bitmap = this.f68048w;
        if (bitmap != null && this.f68032g <= 0) {
            builder.setLargeIcon(bitmap);
        }
        String str = this.A;
        if (str == null) {
            this.A = getTitle(context);
        } else {
            builder.setContentTitle(str);
        }
        CharSequence charSequence = this.f68044s;
        if (charSequence == null || this.f68030e != null) {
            builder.setContentText(charSequence);
            builder.setTicker(this.f68044s);
        } else {
            bigTextStyle.bigText(charSequence);
            builder.setStyle(bigTextStyle);
            builder.setContentText(this.f68044s);
            builder.setTicker(this.f68044s);
        }
        if (this.C != null) {
            try {
                builder.setStyle(new Notification.BigPictureStyle().bigPicture(this.C));
            } catch (Throwable th2) {
                TLogger.w("XGPushNotificationBuilder", "getChannelNotification setStyle error " + th2.toString());
            }
        }
        if (this.f68032g > 0 && (this.f68033h == 1 || Build.VERSION.SDK_INT >= 31 || ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor())) {
            builder.setStyle(new Notification.DecoratedCustomViewStyle());
        }
        if (this.E != null) {
            String j11 = d.j();
            if (!MTPushConstants.Manufacturer.OPPO.equals(j11) && ((this.f68032g <= 0 || !"vivo".equals(j11)) && this.f68032g != 3)) {
                builder.setGroup(this.E);
            }
        }
        builder.setShowWhen(true);
        String str2 = this.f68050y;
        if (str2 != null && !TextUtils.isEmpty(str2.trim())) {
            builder.setCategory(this.f68050y);
        }
        builder.setVisibility(1);
        return new Pair<>(builder.build(), a(builder, context));
    }

    public Integer getColor() {
        return this.D;
    }

    public PendingIntent getContentIntent() {
        return this.f68029d;
    }

    public String getCurrentChannelId() {
        String str = this.F;
        return (str == null || str.length() <= 0) ? "xg-channle-id" : this.F;
    }

    public int getCustomLayoutType() {
        return this.f68032g;
    }

    public int getDefaults() {
        return this.f68034i.intValue();
    }

    public int getFlags() {
        return this.f68036k.intValue();
    }

    public Integer getIcon() {
        return this.f68037l;
    }

    public int getIconLevel() {
        return this.f68038m.intValue();
    }

    public Bitmap getLargeIcon() {
        return this.f68048w;
    }

    public int getLedARGB() {
        return this.f68039n.intValue();
    }

    public int getLedOffMS() {
        return this.f68040o.intValue();
    }

    public int getLedOnMS() {
        return this.f68041p.intValue();
    }

    public String getNotificationCategory() {
        String str = this.f68050y;
        return (str == null || TextUtils.isEmpty(str.trim())) ? "" : this.f68050y;
    }

    public int getNotificationImportance() {
        int i11 = this.f68051z;
        if (i11 < 0 || i11 > 5) {
            return -1;
        }
        return i11;
    }

    public Integer getNotificationLargeIcon() {
        return this.f68049x;
    }

    public int getNumber() {
        return this.f68042q.intValue();
    }

    public Bitmap getRichIcon() {
        return this.C;
    }

    public Integer getSmallIcon() {
        return this.f68047v;
    }

    public Uri getSound() {
        return this.f68043r;
    }

    public String getThread_id() {
        return this.E;
    }

    public CharSequence getTickerText() {
        return this.f68044s;
    }

    public String getTitle(Context context) {
        if (this.A == null) {
            this.A = (String) context.getApplicationContext().getPackageManager().getApplicationLabel(context.getApplicationInfo());
        }
        return this.A;
    }

    public abstract String getType();

    public long[] getVibrate() {
        return this.f68045t;
    }

    public long getWhen() {
        return this.f68046u.longValue();
    }

    public boolean isRecommandNotification() {
        String str = this.f68050y;
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f68050y.equals("recommendation") || this.f68050y.equals("social") || this.f68050y.equals("promo");
    }

    public boolean isSupportNotificationGroup(Context context) {
        Boolean bool = this.isSupportNotificationGroup;
        if (bool != null) {
            return bool.booleanValue();
        }
        long accessId = XGPushConfig.getAccessId(context);
        String str = "";
        if (accessId != -1) {
            str = accessId + str;
        }
        if (str.startsWith("150") || str.startsWith("158") || str.startsWith("159")) {
            boolean e11 = g.e();
            boolean isRecommandNotification = isRecommandNotification();
            if (e11 && isRecommandNotification) {
                TLogger.ii("XGPushNotificationBuilder", "internal accessid：+" + accessId + " , over huawei harmony 4.0 OS device don't support create Notitification Group");
                Boolean bool2 = Boolean.FALSE;
                this.isSupportNotificationGroup = bool2;
                return bool2.booleanValue();
            }
        } else {
            TLogger.ii("XGPushNotificationBuilder", "foreign accessid:" + accessId + " can create Notification Group");
        }
        this.isSupportNotificationGroup = Boolean.TRUE;
        TLogger.ii("XGPushNotificationBuilder", "can create Notitification Group");
        return this.isSupportNotificationGroup.booleanValue();
    }

    public boolean needAutoFilterNotification(Context context) {
        if (!XGPushConfig.autoFilterHuaweiPublicNotification) {
            TLogger.d("XGPushNotificationBuilder", " not set autoFilterHuaweiPublicNotification flag");
            return false;
        } else if (!g.e()) {
            TLogger.d("XGPushNotificationBuilder", " not huawei HarmongOS4");
            return false;
        } else {
            String str = this.f68050y;
            if (str != null && !TextUtils.isEmpty(str) && !isRecommandNotification()) {
                return false;
            }
            TLogger.d("XGPushNotificationBuilder", "current notification is huawei harmonyOS 4.0 public information Notification");
            return true;
        }
    }

    public XGPushNotificationBuilder setAudioStringType(int i11) {
        this.f68028c = Integer.valueOf(i11);
        return this;
    }

    public void setChannelId(String str) {
        this.f68026a = str;
    }

    public void setChannelName(String str) {
        this.f68027b = str;
    }

    public XGPushNotificationBuilder setColor(Integer num) {
        this.D = num;
        return this;
    }

    public XGPushNotificationBuilder setContentIntent(PendingIntent pendingIntent) {
        this.f68029d = pendingIntent;
        return this;
    }

    public XGPushNotificationBuilder setContentView(RemoteViews remoteViews) {
        this.f68030e = remoteViews;
        return this;
    }

    public XGPushNotificationBuilder setCustomLayoutType(int i11) {
        this.f68032g = i11;
        return this;
    }

    public XGPushNotificationBuilder setDefaults(int i11) {
        Integer num = this.f68034i;
        if (num == null) {
            this.f68034i = Integer.valueOf(i11);
        } else {
            this.f68034i = Integer.valueOf(i11 | num.intValue());
        }
        return this;
    }

    public XGPushNotificationBuilder setFlags(int i11) {
        Integer num = this.f68036k;
        if (num == null) {
            this.f68036k = Integer.valueOf(i11);
        } else {
            this.f68036k = Integer.valueOf(i11 | num.intValue());
        }
        return this;
    }

    public XGPushNotificationBuilder setIcon(Integer num) {
        this.f68037l = num;
        return this;
    }

    public XGPushNotificationBuilder setIconLevel(int i11) {
        this.f68038m = Integer.valueOf(i11);
        return this;
    }

    public XGPushNotificationBuilder setLargeIcon(Bitmap bitmap) {
        this.f68048w = bitmap;
        return this;
    }

    public XGPushNotificationBuilder setLedARGB(int i11) {
        this.f68039n = Integer.valueOf(i11);
        return this;
    }

    public XGPushNotificationBuilder setLedOffMS(int i11) {
        this.f68040o = Integer.valueOf(i11);
        return this;
    }

    public XGPushNotificationBuilder setLedOnMS(int i11) {
        this.f68041p = Integer.valueOf(i11);
        return this;
    }

    public void setNotificationCategory(String str) {
        this.f68050y = str;
    }

    public boolean setNotificationImportance(int i11) {
        if (i11 <= 0 || i11 > 5) {
            TLogger.w("XGPushNotificationBuilder", "invalid notification importance , notificationImportance:" + i11);
            return false;
        }
        this.f68051z = i11;
        return true;
    }

    public XGPushNotificationBuilder setNotificationLargeIcon(int i11) {
        this.f68049x = Integer.valueOf(i11);
        return this;
    }

    public XGPushNotificationBuilder setNumber(int i11) {
        this.f68042q = Integer.valueOf(i11);
        return this;
    }

    public XGPushNotificationBuilder setRichIcon(Bitmap bitmap) {
        this.C = bitmap;
        return this;
    }

    public void setRunAsSysAndAndBuildSdk26(boolean z11) {
        this.G = z11;
    }

    public XGPushNotificationBuilder setSmallIcon(Integer num) {
        this.f68047v = num;
        return this;
    }

    public XGPushNotificationBuilder setSound(Uri uri) {
        this.f68043r = uri;
        return this;
    }

    public void setThread_id(String str) {
        this.E = str;
    }

    public XGPushNotificationBuilder setTickerText(CharSequence charSequence) {
        this.f68044s = charSequence;
        return this;
    }

    public void setTitle(String str) {
        this.A = str;
    }

    public void setUseStdStyle(int i11) {
        this.f68033h = i11;
    }

    public XGPushNotificationBuilder setVibrate(long[] jArr) {
        this.f68045t = jArr;
        return this;
    }

    public XGPushNotificationBuilder setWhen(long j11) {
        this.f68046u = Long.valueOf(j11);
        return this;
    }

    public XGPushNotificationBuilder setbigContentView(RemoteViews remoteViews) {
        this.f68031f = remoteViews;
        return this;
    }

    public Pair<Notification, Object> a(Context context) {
        Object obj;
        Notification notification;
        if (this.B == null) {
            this.B = 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("XGPushNotification Build.VERSION.SDK_INT: ");
        int i11 = Build.VERSION.SDK_INT;
        sb2.append(i11);
        sb2.append(", targetSDK:");
        sb2.append(context.getApplicationInfo().targetSdkVersion);
        TLogger.ii("XGPushNotificationBuilder", sb2.toString());
        if (i11 < 26 || (context.getApplicationInfo().targetSdkVersion < 26 && !this.G)) {
            notification = c(context);
            obj = null;
        } else {
            Pair<Notification, Object> channelNotification = getChannelNotification(context);
            notification = (Notification) channelNotification.first;
            obj = channelNotification.second;
        }
        Integer num = this.f68028c;
        if (num != null) {
            notification.audioStreamType = num.intValue();
        }
        PendingIntent pendingIntent = this.f68029d;
        if (pendingIntent != null) {
            notification.contentIntent = pendingIntent;
        }
        RemoteViews remoteViews = this.f68031f;
        if (remoteViews != null) {
            notification.bigContentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f68030e;
        if (remoteViews2 != null) {
            notification.contentView = remoteViews2;
        }
        Integer num2 = this.f68034i;
        if (num2 != null) {
            notification.defaults = num2.intValue();
        }
        Integer num3 = this.f68037l;
        if (num3 != null) {
            notification.icon = num3.intValue();
        }
        PendingIntent pendingIntent2 = this.f68035j;
        if (pendingIntent2 != null) {
            notification.deleteIntent = pendingIntent2;
        }
        Integer num4 = this.f68036k;
        if (num4 != null) {
            notification.flags = num4.intValue();
        } else {
            notification.flags = 16;
        }
        Integer num5 = this.f68038m;
        if (num5 != null) {
            notification.iconLevel = num5.intValue();
        }
        Integer num6 = this.f68039n;
        if (num6 != null) {
            notification.ledARGB = num6.intValue();
        }
        Integer num7 = this.f68040o;
        if (num7 != null) {
            notification.ledOffMS = num7.intValue();
        }
        Integer num8 = this.f68041p;
        if (num8 != null) {
            notification.ledOnMS = num8.intValue();
        }
        Integer num9 = this.f68042q;
        if (num9 != null) {
            notification.number = num9.intValue();
        }
        Uri uri = this.f68043r;
        if (uri != null) {
            notification.sound = uri;
        }
        long[] jArr = this.f68045t;
        if (jArr != null) {
            notification.vibrate = jArr;
        }
        Long l11 = this.f68046u;
        if (l11 != null) {
            notification.when = l11.longValue();
        } else {
            notification.when = System.currentTimeMillis();
        }
        return new Pair<>(notification, obj);
    }
}
