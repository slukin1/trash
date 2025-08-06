package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;

public class InAppMessageActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f69329a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f69330b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f69331c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Intent f69332d;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0010 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025 A[Catch:{ all -> 0x003e, all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003a A[Catch:{ all -> 0x003e, all -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            boolean r4 = com.tencent.android.tpush.XGPushConfig.enableActivityWindowSecFlag     // Catch:{ all -> 0x0010 }
            if (r4 == 0) goto L_0x0010
            android.view.Window r4 = r3.getWindow()     // Catch:{ all -> 0x0010 }
            r0 = 8192(0x2000, float:1.14794E-41)
            r4.setFlags(r0, r0)     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r3.f69329a = r3     // Catch:{ all -> 0x003e }
            android.os.Handler r4 = new android.os.Handler     // Catch:{ all -> 0x003e }
            r4.<init>()     // Catch:{ all -> 0x003e }
            r3.f69330b = r4     // Catch:{ all -> 0x003e }
            android.content.Intent r4 = r3.getIntent()     // Catch:{ all -> 0x003e }
            r3.f69332d = r4     // Catch:{ all -> 0x003e }
            boolean r4 = r3.a((android.content.Intent) r4)     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x003a
            android.content.Intent r4 = r3.f69332d     // Catch:{ all -> 0x003e }
            java.lang.String r0 = "inAppMsg"
            java.lang.String r4 = r4.getStringExtra(r0)     // Catch:{ all -> 0x003e }
            android.content.Intent r0 = r3.f69332d     // Catch:{ all -> 0x003e }
            java.lang.String r1 = "pushChannel"
            r2 = 100
            r0.putExtra(r1, r2)     // Catch:{ all -> 0x003e }
            r3.a((java.lang.String) r4)     // Catch:{ all -> 0x003e }
            goto L_0x0076
        L_0x003a:
            r3.finish()     // Catch:{ all -> 0x003e }
            goto L_0x0076
        L_0x003e:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "InAppMsg start InAppMessageActivity :"
            r0.append(r1)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "InAppMessageActivity"
            com.tencent.android.tpush.logging.TLogger.e(r0, r4)
            r3.finish()     // Catch:{ all -> 0x005d }
            goto L_0x0076
        L_0x005d:
            r4 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "InAppMsg finish InAppMessageActivity :"
            r1.append(r2)
            java.lang.String r4 = r4.toString()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            com.tencent.android.tpush.logging.TLogger.e(r0, r4)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.inappmessage.InAppMessageActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        c cVar = this.f69331c;
        if (cVar != null) {
            cVar.dismiss();
        }
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    private boolean a(Intent intent) {
        if (intent != null && intent.hasExtra(MessageKey.MSG_INAPP_PORTECT_TAG)) {
            String stringExtra = intent.getStringExtra(MessageKey.MSG_INAPP_PORTECT_TAG);
            if (!j.b(stringExtra)) {
                try {
                    Long valueOf = Long.valueOf(Rijndael.decrypt(stringExtra));
                    if (valueOf.longValue() <= 0 || System.currentTimeMillis() < valueOf.longValue()) {
                        return false;
                    }
                    return true;
                } catch (NumberFormatException e11) {
                    TLogger.e("InAppMessageActivity", "InAppMsg checkIntent :" + e11.toString());
                }
            }
        }
        return false;
    }

    private void a(final String str) {
        TLogger.i("InAppMessageActivity", "InAppMsg parseData :" + str);
        if (str != null && !TextUtils.isEmpty(str)) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                /* JADX WARNING: Removed duplicated region for block: B:47:0x0240 A[Catch:{ all -> 0x030a }] */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x02a0 A[Catch:{ all -> 0x030a }] */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x02b5 A[Catch:{ all -> 0x030a }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void TRun() {
                    /*
                        r24 = this;
                        r1 = r24
                        java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x030e }
                        r0.<init>()     // Catch:{ all -> 0x030e }
                        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x030e }
                        java.lang.String r3 = r3     // Catch:{ all -> 0x030e }
                        r2.<init>(r3)     // Catch:{ all -> 0x030e }
                        java.lang.String r3 = "dispContent"
                        org.json.JSONObject r2 = r2.optJSONObject(r3)     // Catch:{ all -> 0x030e }
                        if (r2 != 0) goto L_0x0017
                        return
                    L_0x0017:
                        java.lang.String r3 = "templateType"
                        r4 = 1
                        int r3 = r2.optInt(r3, r4)     // Catch:{ all -> 0x030e }
                        java.lang.String r5 = "Message.template.type"
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x030e }
                        r0.put(r5, r3)     // Catch:{ all -> 0x030e }
                        java.lang.String r3 = "titleLabel"
                        org.json.JSONObject r3 = r2.optJSONObject(r3)     // Catch:{ all -> 0x030e }
                        java.lang.String r6 = "alignment"
                        java.lang.String r7 = "style"
                        java.lang.String r8 = "font"
                        java.lang.String r9 = "size"
                        java.lang.String r10 = "color"
                        java.lang.String r11 = "Title Is Have"
                        java.lang.String r12 = "location"
                        r13 = 20
                        java.lang.String r14 = "text"
                        java.lang.String r4 = ""
                        if (r3 == 0) goto L_0x009c
                        java.lang.String r5 = r3.optString(r14, r4)     // Catch:{ all -> 0x030a }
                        java.lang.String r15 = r3.optString(r10, r4)     // Catch:{ all -> 0x030a }
                        int r17 = r3.optInt(r9, r13)     // Catch:{ all -> 0x030a }
                        java.lang.String r13 = r3.optString(r8, r4)     // Catch:{ all -> 0x030a }
                        r1 = 0
                        int r18 = r3.optInt(r7, r1)     // Catch:{ all -> 0x030a }
                        r1 = 17
                        int r19 = r3.optInt(r6, r1)     // Catch:{ all -> 0x030a }
                        r1 = 0
                        int r3 = r3.optInt(r12, r1)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Title.Text"
                        r0.put(r1, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Title.Color"
                        r0.put(r1, r15)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Title.Size"
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x030a }
                        r0.put(r1, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Title.Align"
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r19)     // Catch:{ all -> 0x030a }
                        r0.put(r1, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Title.Paint"
                        r0.put(r1, r13)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Title.Typeface"
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r18)     // Catch:{ all -> 0x030a }
                        r0.put(r1, r5)     // Catch:{ all -> 0x030a }
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r3 = "Title.Location"
                        r0.put(r1, r3)     // Catch:{ all -> 0x030a }
                        java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x030a }
                        r0.put(r11, r1)     // Catch:{ all -> 0x030a }
                        goto L_0x00a1
                    L_0x009c:
                        java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x030a }
                        r0.put(r11, r1)     // Catch:{ all -> 0x030a }
                    L_0x00a1:
                        java.lang.String r1 = "contentLabel"
                        org.json.JSONObject r1 = r2.optJSONObject(r1)     // Catch:{ all -> 0x030a }
                        java.lang.String r3 = "Message Is Have"
                        if (r1 == 0) goto L_0x0105
                        java.lang.String r5 = r1.optString(r14, r4)     // Catch:{ all -> 0x030a }
                        java.lang.String r10 = r1.optString(r10, r4)     // Catch:{ all -> 0x030a }
                        r11 = 20
                        int r9 = r1.optInt(r9, r11)     // Catch:{ all -> 0x030a }
                        java.lang.String r8 = r1.optString(r8, r4)     // Catch:{ all -> 0x030a }
                        r11 = 0
                        int r7 = r1.optInt(r7, r11)     // Catch:{ all -> 0x030a }
                        r13 = 17
                        int r6 = r1.optInt(r6, r13)     // Catch:{ all -> 0x030a }
                        int r1 = r1.optInt(r12, r11)     // Catch:{ all -> 0x030a }
                        java.lang.String r11 = "Message.Size"
                        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x030a }
                        r0.put(r11, r9)     // Catch:{ all -> 0x030a }
                        java.lang.String r9 = "Message.Align"
                        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x030a }
                        r0.put(r9, r6)     // Catch:{ all -> 0x030a }
                        java.lang.String r6 = "Message.Paint"
                        r0.put(r6, r8)     // Catch:{ all -> 0x030a }
                        java.lang.String r6 = "Message.Typeface"
                        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x030a }
                        r0.put(r6, r7)     // Catch:{ all -> 0x030a }
                        java.lang.String r6 = "Message.Text"
                        r0.put(r6, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r5 = "Message.Color"
                        r0.put(r5, r10)     // Catch:{ all -> 0x030a }
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x030a }
                        java.lang.String r5 = "Message.Location"
                        r0.put(r1, r5)     // Catch:{ all -> 0x030a }
                        java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x030a }
                        r0.put(r3, r1)     // Catch:{ all -> 0x030a }
                        goto L_0x010a
                    L_0x0105:
                        java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x030a }
                        r0.put(r3, r1)     // Catch:{ all -> 0x030a }
                    L_0x010a:
                        java.lang.String r1 = "mediaView"
                        org.json.JSONObject r1 = r2.optJSONObject(r1)     // Catch:{ all -> 0x030a }
                        java.lang.String r3 = "url"
                        java.lang.String r5 = "Media Is Have"
                        if (r1 == 0) goto L_0x016b
                        java.lang.String r6 = r1.optString(r3, r4)     // Catch:{ all -> 0x030a }
                        java.lang.String r7 = "width"
                        r8 = r24
                        com.tencent.android.tpush.inappmessage.InAppMessageActivity r9 = com.tencent.android.tpush.inappmessage.InAppMessageActivity.this     // Catch:{ all -> 0x0307 }
                        android.content.Context r9 = r9.f69329a     // Catch:{ all -> 0x0307 }
                        r10 = 1132396544(0x437f0000, float:255.0)
                        int r9 = com.tencent.android.tpush.inappmessage.SizeUtil.dipTopx(r9, r10)     // Catch:{ all -> 0x0307 }
                        int r7 = r1.optInt(r7, r9)     // Catch:{ all -> 0x0307 }
                        java.lang.String r9 = "height"
                        com.tencent.android.tpush.inappmessage.InAppMessageActivity r10 = com.tencent.android.tpush.inappmessage.InAppMessageActivity.this     // Catch:{ all -> 0x0307 }
                        android.content.Context r10 = r10.f69329a     // Catch:{ all -> 0x0307 }
                        r11 = 1129775104(0x43570000, float:215.0)
                        int r10 = com.tencent.android.tpush.inappmessage.SizeUtil.dipTopx(r10, r11)     // Catch:{ all -> 0x0307 }
                        int r9 = r1.optInt(r9, r10)     // Catch:{ all -> 0x0307 }
                        r10 = 0
                        int r1 = r1.optInt(r12, r10)     // Catch:{ all -> 0x0307 }
                        java.lang.String r10 = "Media url"
                        r0.put(r10, r6)     // Catch:{ all -> 0x0307 }
                        java.lang.String r6 = "Media width"
                        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0307 }
                        r0.put(r6, r7)     // Catch:{ all -> 0x0307 }
                        java.lang.String r6 = "Media heigh"
                        java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0307 }
                        r0.put(r6, r7)     // Catch:{ all -> 0x0307 }
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0307 }
                        java.lang.String r6 = "Media.Location"
                        r0.put(r1, r6)     // Catch:{ all -> 0x0307 }
                        java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0307 }
                        r0.put(r5, r1)     // Catch:{ all -> 0x0307 }
                        goto L_0x0172
                    L_0x016b:
                        r8 = r24
                        java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0307 }
                        r0.put(r5, r1)     // Catch:{ all -> 0x0307 }
                    L_0x0172:
                        java.lang.String r1 = "showCloseBtn"
                        r5 = 1
                        int r1 = r2.optInt(r1, r5)     // Catch:{ all -> 0x0307 }
                        java.lang.String r5 = "Close button"
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0307 }
                        r0.put(r5, r1)     // Catch:{ all -> 0x0307 }
                        java.lang.String r1 = "customBtns"
                        org.json.JSONArray r1 = r2.optJSONArray(r1)     // Catch:{ all -> 0x0307 }
                        java.lang.String r5 = "corner"
                        java.lang.String r6 = "bgColor"
                        java.lang.String r7 = "action"
                        if (r1 == 0) goto L_0x02a5
                        int r9 = r1.length()     // Catch:{ all -> 0x030a }
                        if (r9 <= 0) goto L_0x02a5
                        r10 = 0
                        org.json.JSONObject r11 = r1.getJSONObject(r10)     // Catch:{ all -> 0x030a }
                        java.lang.String r13 = "textSize"
                        java.lang.String r15 = "textColor"
                        java.lang.String r10 = "buttonId"
                        if (r11 == 0) goto L_0x0225
                        r8 = 0
                        int r16 = r11.optInt(r10, r8)     // Catch:{ all -> 0x030a }
                        if (r16 == 0) goto L_0x0225
                        java.lang.String r8 = r11.optString(r6, r4)     // Catch:{ all -> 0x030a }
                        r17 = r3
                        java.lang.String r3 = r11.optString(r14, r4)     // Catch:{ all -> 0x030a }
                        r18 = r2
                        java.lang.String r2 = r11.optString(r15, r4)     // Catch:{ all -> 0x030a }
                        r19 = r15
                        r15 = 20
                        int r20 = r11.optInt(r13, r15)     // Catch:{ all -> 0x030a }
                        r15 = 0
                        int r21 = r11.optInt(r5, r15)     // Catch:{ all -> 0x030a }
                        int r12 = r11.optInt(r12, r15)     // Catch:{ all -> 0x030a }
                        java.lang.String r15 = r11.optString(r7, r4)     // Catch:{ all -> 0x030a }
                        r22 = r7
                        java.lang.String r7 = "actionType"
                        r23 = r5
                        r5 = 0
                        int r7 = r11.optInt(r7, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r5 = "Accept button.Text"
                        r0.put(r5, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r3 = "Accept button.Background color"
                        r0.put(r3, r8)     // Catch:{ all -> 0x030a }
                        java.lang.String r3 = "Accept button.Text color"
                        r0.put(r3, r2)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept button.Text size"
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept button.corner"
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r21)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept button.id"
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept button.action"
                        r0.put(r2, r15)     // Catch:{ all -> 0x030a }
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x030a }
                        java.lang.String r3 = "Button.Location"
                        r0.put(r2, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept button.count"
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept button.action.type"
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r3)     // Catch:{ all -> 0x030a }
                        goto L_0x022f
                    L_0x0225:
                        r18 = r2
                        r17 = r3
                        r23 = r5
                        r22 = r7
                        r19 = r15
                    L_0x022f:
                        r2 = 2
                        if (r9 != r2) goto L_0x02a0
                        r2 = 1
                        org.json.JSONObject r1 = r1.getJSONObject(r2)     // Catch:{ all -> 0x030a }
                        if (r1 == 0) goto L_0x02a0
                        r2 = 0
                        int r3 = r1.optInt(r10, r2)     // Catch:{ all -> 0x030a }
                        if (r3 == 0) goto L_0x02a0
                        java.lang.String r2 = r1.optString(r6, r4)     // Catch:{ all -> 0x030a }
                        java.lang.String r5 = r1.optString(r14, r4)     // Catch:{ all -> 0x030a }
                        r7 = r19
                        java.lang.String r7 = r1.optString(r7, r4)     // Catch:{ all -> 0x030a }
                        r8 = 20
                        int r8 = r1.optInt(r13, r8)     // Catch:{ all -> 0x030a }
                        r9 = r23
                        r10 = 0
                        int r12 = r1.optInt(r9, r10)     // Catch:{ all -> 0x030a }
                        r13 = r22
                        java.lang.String r1 = r1.optString(r13, r4)     // Catch:{ all -> 0x030a }
                        java.lang.String r14 = "actionType"
                        int r11 = r11.optInt(r14, r10)     // Catch:{ all -> 0x030a }
                        java.lang.String r10 = "Accept sec button.Text"
                        r0.put(r10, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r5 = "Accept sec button.Background color"
                        r0.put(r5, r2)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept sec button.Text color"
                        r0.put(r2, r7)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept sec button.Text size"
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept sec button.corner"
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept sec button.id"
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x030a }
                        r0.put(r2, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r2 = "Accept sec button.action"
                        r0.put(r2, r1)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Accept sec button.action.type"
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x030a }
                        r0.put(r1, r2)     // Catch:{ all -> 0x030a }
                        goto L_0x02ab
                    L_0x02a0:
                        r13 = r22
                        r9 = r23
                        goto L_0x02ab
                    L_0x02a5:
                        r18 = r2
                        r17 = r3
                        r9 = r5
                        r13 = r7
                    L_0x02ab:
                        java.lang.String r1 = "bgCard"
                        r2 = r18
                        org.json.JSONObject r1 = r2.optJSONObject(r1)     // Catch:{ all -> 0x030a }
                        if (r1 == 0) goto L_0x02e0
                        r2 = r17
                        java.lang.String r2 = r1.optString(r2, r4)     // Catch:{ all -> 0x030a }
                        java.lang.String r3 = r1.optString(r13, r4)     // Catch:{ all -> 0x030a }
                        r5 = 0
                        int r5 = r1.optInt(r9, r5)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = r1.optString(r6, r4)     // Catch:{ all -> 0x030a }
                        java.lang.String r4 = "Background color"
                        r0.put(r4, r1)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Background image url"
                        r0.put(r1, r2)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Background action"
                        r0.put(r1, r3)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Background corner"
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x030a }
                        r0.put(r1, r2)     // Catch:{ all -> 0x030a }
                    L_0x02e0:
                        java.lang.String r1 = "Layout.Width"
                        r2 = 303(0x12f, float:4.25E-43)
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x030a }
                        r0.put(r1, r2)     // Catch:{ all -> 0x030a }
                        java.lang.String r1 = "Layout.Height"
                        r2 = 600(0x258, float:8.41E-43)
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x030a }
                        r0.put(r1, r2)     // Catch:{ all -> 0x030a }
                        r1 = r24
                        com.tencent.android.tpush.inappmessage.InAppMessageActivity r2 = com.tencent.android.tpush.inappmessage.InAppMessageActivity.this     // Catch:{ all -> 0x030e }
                        android.os.Handler r2 = r2.f69330b     // Catch:{ all -> 0x030e }
                        com.tencent.android.tpush.inappmessage.InAppMessageActivity$1$1 r3 = new com.tencent.android.tpush.inappmessage.InAppMessageActivity$1$1     // Catch:{ all -> 0x030e }
                        r3.<init>(r0)     // Catch:{ all -> 0x030e }
                        r2.post(r3)     // Catch:{ all -> 0x030e }
                        goto L_0x0329
                    L_0x0307:
                        r0 = move-exception
                        r1 = r8
                        goto L_0x030f
                    L_0x030a:
                        r0 = move-exception
                        r1 = r24
                        goto L_0x030f
                    L_0x030e:
                        r0 = move-exception
                    L_0x030f:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "unexpected for InAppMsg:"
                        r2.append(r3)
                        java.lang.String r0 = r0.toString()
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        java.lang.String r2 = "InAppMessageActivity"
                        com.tencent.android.tpush.logging.TLogger.e(r2, r0)
                    L_0x0329:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.inappmessage.InAppMessageActivity.AnonymousClass1.TRun():void");
                }
            });
        }
    }
}
