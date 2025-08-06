package com.tencent.android.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.otherpush.OtherPushClient;
import com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class XGFcmListenerService extends FirebaseMessagingService {
    private static final String TAG = "XGFcmListenerService";

    private static HashMap<String, Object> strToHashMap(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                hashMap.put(valueOf, jSONObject.get(valueOf));
            }
            return hashMap;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x019a A[SYNTHETIC, Splitter:B:45:0x019a] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ee A[Catch:{ all -> 0x01f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0298 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0299 A[SYNTHETIC, Splitter:B:88:0x0299] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage r43) {
        /*
            r42 = this;
            java.lang.String r1 = "action_type"
            java.lang.String r2 = "action"
            java.lang.String r3 = "custom_content"
            java.lang.String r4 = "type"
            java.lang.String r5 = "XGFcmListenerService"
            if (r43 != 0) goto L_0x000d
            return
        L_0x000d:
            java.util.Map r6 = r43.getData()
            if (r6 != 0) goto L_0x0014
            return
        L_0x0014:
            java.lang.String r7 = r43.getFrom()
            com.tencent.android.tpush.XGPushManager.startPushService(r42)
            java.lang.String r8 = "title"
            java.lang.Object r0 = r6.get(r8)
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            r10 = -1
            java.lang.Object r0 = r6.get(r4)     // Catch:{ NumberFormatException -> 0x0032 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x0032 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0032 }
            long r10 = (long) r0
            goto L_0x004b
        L_0x0032:
            r0 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "type from Srv format Error: "
            r12.append(r13)
            java.lang.String r0 = r0.getMessage()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            com.tencent.android.tpush.logging.TLogger.e(r5, r0)
        L_0x004b:
            java.lang.String r12 = "pushChannel"
            java.lang.Object r0 = r6.get(r12)
            r13 = r0
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = "content"
            java.lang.Object r0 = r6.get(r14)
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            r16 = r1
            java.lang.String r1 = "msgId"
            java.lang.Object r0 = r6.get(r1)
            r17 = r2
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            r18 = r3
            java.lang.String r3 = "busiMsgId"
            java.lang.Object r0 = r6.get(r3)
            r43 = r14
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
            r19 = r8
            java.lang.String r8 = "pushTime"
            java.lang.Object r0 = r6.get(r8)
            r20 = r0
            java.lang.String r20 = (java.lang.String) r20
            r21 = r8
            java.lang.String r8 = "groupId"
            java.lang.Object r0 = r6.get(r8)
            r22 = r8
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
            r23 = r12
            java.lang.String r12 = "templateId"
            java.lang.Object r0 = r6.get(r12)
            r24 = r12
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            r25 = r12
            java.lang.String r12 = "traceId"
            java.lang.Object r0 = r6.get(r12)
            r26 = r12
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            r27 = r12
            java.lang.String r12 = "targetType"
            java.lang.Object r0 = r6.get(r12)
            r28 = r12
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            r29 = r4
            java.lang.String r4 = "source"
            java.lang.Object r0 = r6.get(r4)
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            r30 = 0
            if (r12 == 0) goto L_0x00ed
            long r32 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x00cf }
            r34 = r32
            r33 = r4
            goto L_0x00f1
        L_0x00cf:
            r0 = move-exception
            r32 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r33 = r4
            java.lang.String r4 = "targetType from Srv format Error: "
            r0.append(r4)
            java.lang.String r4 = r32.getMessage()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.tencent.android.tpush.logging.TLogger.e(r5, r0)
            goto L_0x00ef
        L_0x00ed:
            r33 = r4
        L_0x00ef:
            r34 = r30
        L_0x00f1:
            if (r6 == 0) goto L_0x0119
            long r36 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00fc }
            r32 = r3
            r3 = r36
            goto L_0x011d
        L_0x00fc:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r32 = r3
            java.lang.String r3 = "source from Srv format Error: "
            r0.append(r3)
            java.lang.String r3 = r4.getMessage()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.tencent.android.tpush.logging.TLogger.e(r5, r0)
            goto L_0x011b
        L_0x0119:
            r32 = r3
        L_0x011b:
            r3 = r30
        L_0x011d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r36 = r3
            java.lang.String r3 = "[FCM Notification] From: "
            r0.append(r3)
            r0.append(r7)
            java.lang.String r3 = ", title: "
            r0.append(r3)
            r0.append(r9)
            java.lang.String r3 = ", type: "
            r0.append(r3)
            r0.append(r10)
            java.lang.String r3 = ", content: "
            r0.append(r3)
            r0.append(r15)
            java.lang.String r3 = ", strMsgid: "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r3 = ", strBusiMsgId: "
            r0.append(r3)
            r0.append(r14)
            java.lang.String r3 = " , groupId : "
            r0.append(r3)
            r0.append(r8)
            java.lang.String r3 = ", strTargetType: "
            r0.append(r3)
            r0.append(r12)
            java.lang.String r3 = ", strSource: "
            r0.append(r3)
            r0.append(r6)
            java.lang.String r3 = " , pushChannel = "
            r0.append(r3)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.tencent.android.tpush.logging.TLogger.d(r5, r0)
            if (r2 == 0) goto L_0x0188
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0183 }
            r0 = 1
            goto L_0x018d
        L_0x0183:
            long r6 = java.lang.System.currentTimeMillis()
            goto L_0x018c
        L_0x0188:
            long r6 = java.lang.System.currentTimeMillis()
        L_0x018c:
            r0 = 0
        L_0x018d:
            if (r14 == 0) goto L_0x0196
            long r38 = java.lang.Long.parseLong(r14)     // Catch:{ NumberFormatException -> 0x0196 }
            r3 = r38
            goto L_0x0198
        L_0x0196:
            r3 = r30
        L_0x0198:
            if (r20 == 0) goto L_0x01a2
            long r30 = java.lang.Long.parseLong(r20)     // Catch:{ NumberFormatException -> 0x01a2 }
            r38 = 1000(0x3e8, double:4.94E-321)
            long r30 = r30 * r38
        L_0x01a2:
            r40 = r30
            r12 = 101(0x65, float:1.42E-43)
            android.content.Intent r14 = new android.content.Intent     // Catch:{ all -> 0x021c }
            r14.<init>()     // Catch:{ all -> 0x021c }
            r14.putExtra(r1, r6)     // Catch:{ all -> 0x021c }
            r1 = r32
            r14.putExtra(r1, r3)     // Catch:{ all -> 0x021c }
            r1 = r29
            r14.putExtra(r1, r10)     // Catch:{ all -> 0x021c }
            r1 = r23
            r14.putExtra(r1, r12)     // Catch:{ all -> 0x021c }
            r1 = r13
            r2 = r21
            r12 = r40
            r14.putExtra(r2, r12)     // Catch:{ all -> 0x020c }
            r2 = r22
            r14.putExtra(r2, r8)     // Catch:{ all -> 0x020c }
            r22 = r10
            r11 = r28
            r9 = r34
            r14.putExtra(r11, r9)     // Catch:{ all -> 0x0204 }
            r28 = r3
            r11 = r33
            r2 = r36
            r14.putExtra(r11, r2)     // Catch:{ all -> 0x01fe }
            r4 = r24
            r11 = r25
            r14.putExtra(r4, r11)     // Catch:{ all -> 0x01f8 }
            r25 = r1
            r1 = r26
            r4 = r27
            r14.putExtra(r1, r4)     // Catch:{ all -> 0x01f6 }
            if (r0 == 0) goto L_0x0241
            android.app.Application r0 = r42.getApplication()     // Catch:{ all -> 0x01f6 }
            com.tencent.android.tpush.stat.ServiceStat.appReportServiceReceived(r0, r14)     // Catch:{ all -> 0x01f6 }
            goto L_0x0241
        L_0x01f6:
            r0 = move-exception
            goto L_0x022d
        L_0x01f8:
            r0 = move-exception
            r25 = r1
            r4 = r27
            goto L_0x022d
        L_0x01fe:
            r0 = move-exception
            r11 = r25
            r4 = r27
            goto L_0x0219
        L_0x0204:
            r0 = move-exception
            r28 = r3
            r11 = r25
            r4 = r27
            goto L_0x0217
        L_0x020c:
            r0 = move-exception
            r28 = r3
            r22 = r10
            r11 = r25
            r4 = r27
            r9 = r34
        L_0x0217:
            r2 = r36
        L_0x0219:
            r25 = r1
            goto L_0x022d
        L_0x021c:
            r0 = move-exception
            r28 = r3
            r22 = r10
            r11 = r25
            r4 = r27
            r9 = r34
            r2 = r36
            r25 = r13
            r12 = r40
        L_0x022d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r14 = "report service receive error: "
            r1.append(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.tencent.android.tpush.logging.TLogger.e(r5, r0)
        L_0x0241:
            com.tencent.android.tpush.XGLocalMessage r1 = new com.tencent.android.tpush.XGLocalMessage
            r1.<init>()
            r26 = r15
            r14 = r22
            int r0 = (int) r14
            r1.setType(r0)
            r1.setMsgId(r6)
            r6 = r28
            r1.setBusiMsgId(r6)
            r1.nGroupId = r8
            r1.pushTime = r12
            r1.targetType = r9
            r1.source = r2
            r1.templateId = r11
            r1.traceId = r4
            r3 = 101(0x65, float:1.42E-43)
            r1.pushChannel = r3
            java.util.Date r0 = new java.util.Date
            long r6 = java.lang.System.currentTimeMillis()
            r0.<init>(r6)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMdd-HH-mm"
            r2.<init>(r4)
            java.lang.String r0 = r2.format(r0)
            java.lang.String r2 = "-"
            java.lang.String[] r0 = r0.split(r2)
            int r2 = r0.length
            r4 = 3
            r6 = 2
            if (r2 < r4) goto L_0x0296
            r2 = 0
            r4 = r0[r2]
            r1.setDate(r4)
            r2 = 1
            r4 = r0[r2]
            r1.setHour(r4)
            r0 = r0[r6]
            r1.setMin(r0)
        L_0x0296:
            if (r26 != 0) goto L_0x0299
            return
        L_0x0299:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0445 }
            r4 = r26
            r0.<init>(r4)     // Catch:{ all -> 0x0445 }
            r4 = r19
            boolean r7 = r0.isNull(r4)     // Catch:{ all -> 0x0445 }
            if (r7 != 0) goto L_0x02af
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0445 }
            r1.setTitle(r4)     // Catch:{ all -> 0x0445 }
        L_0x02af:
            r4 = r43
            boolean r7 = r0.isNull(r4)     // Catch:{ all -> 0x0445 }
            if (r7 != 0) goto L_0x02be
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0445 }
            r1.setContent(r4)     // Catch:{ all -> 0x0445 }
        L_0x02be:
            r4 = r18
            boolean r7 = r0.isNull(r4)     // Catch:{ all -> 0x0445 }
            if (r7 != 0) goto L_0x02e1
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0445 }
            if (r4 == 0) goto L_0x02e1
            java.lang.String r7 = r4.trim()     // Catch:{ all -> 0x0445 }
            java.lang.String r8 = "{}"
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0445 }
            if (r7 != 0) goto L_0x02e1
            java.util.HashMap r4 = strToHashMap(r4)     // Catch:{ all -> 0x0445 }
            if (r4 == 0) goto L_0x02e1
            r1.setCustomContent(r4)     // Catch:{ all -> 0x0445 }
        L_0x02e1:
            java.lang.String r4 = "builder_id"
            int r4 = r0.optInt(r4)     // Catch:{ all -> 0x0445 }
            long r7 = (long) r4     // Catch:{ all -> 0x0445 }
            r1.setBuilderId(r7)     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = "ring"
            r2 = 1
            int r4 = r0.optInt(r4, r2)     // Catch:{ all -> 0x0445 }
            r1.setRing(r4)     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = "ring_raw"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ all -> 0x0445 }
            r1.setRing_raw(r4)     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = "icon_res"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ all -> 0x0445 }
            r1.setIcon_res(r4)     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = "small_icon"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ all -> 0x0445 }
            r1.setSmall_icon(r4)     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = "lights"
            r2 = 1
            int r4 = r0.optInt(r4, r2)     // Catch:{ all -> 0x0445 }
            r1.setLights(r4)     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = "vibrate"
            int r2 = r0.optInt(r4, r2)     // Catch:{ all -> 0x0445 }
            r1.setVibrate(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "icon_type"
            r4 = 0
            int r2 = r0.optInt(r2, r4)     // Catch:{ all -> 0x0445 }
            r1.setIcon_type(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "n_id"
            int r2 = r0.optInt(r2)     // Catch:{ all -> 0x0445 }
            r1.setNotificationId(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "style_id"
            r4 = 0
            int r2 = r0.optInt(r2, r4)     // Catch:{ all -> 0x0445 }
            r1.setStyle_id(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "is_show_type"
            int r2 = r0.optInt(r2, r6)     // Catch:{ all -> 0x0445 }
            r1.setNsModel(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "n_ch_id"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0445 }
            r1.setChannelId(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "n_category"
            java.lang.String r4 = ""
            java.lang.String r2 = r0.optString(r2, r4)     // Catch:{ all -> 0x0445 }
            r1.setNotificationCategory(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "n_importance"
            r4 = -1
            int r2 = r0.optInt(r2, r4)     // Catch:{ all -> 0x0445 }
            r1.setNotificationImportance(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "xg_media_resources"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0445 }
            r1.setTpns_media_resources(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "color"
            r6 = 0
            int r2 = r0.optInt(r2, r6)     // Catch:{ all -> 0x0445 }
            r1.setColor(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "badge_type"
            int r2 = r0.optInt(r2, r4)     // Catch:{ all -> 0x0445 }
            r1.setBadgeType(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "thread_id"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0445 }
            r1.setThreadId(r2)     // Catch:{ all -> 0x0445 }
            java.lang.String r2 = "thread_sumtext"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0445 }
            r1.setThreadSumText(r2)     // Catch:{ all -> 0x0445 }
            if (r25 == 0) goto L_0x03a6
            boolean r2 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x0445 }
            if (r2 != 0) goto L_0x03a6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0445 }
            int r12 = r2.intValue()     // Catch:{ all -> 0x0445 }
            goto L_0x03a7
        L_0x03a6:
            r12 = r3
        L_0x03a7:
            r1.pushChannel = r12     // Catch:{ all -> 0x0445 }
            r2 = r17
            boolean r3 = r0.isNull(r2)     // Catch:{ all -> 0x0445 }
            if (r3 != 0) goto L_0x045a
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0445 }
            java.lang.String r0 = r0.getString(r2)     // Catch:{ all -> 0x0445 }
            r3.<init>(r0)     // Catch:{ all -> 0x0445 }
            r2 = r16
            boolean r0 = r3.isNull(r2)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x03c9
            int r0 = r3.getInt(r2)     // Catch:{ all -> 0x0445 }
            r1.setAction_type(r0)     // Catch:{ all -> 0x0445 }
        L_0x03c9:
            java.lang.String r0 = "activity"
            boolean r0 = r3.isNull(r0)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x03da
            java.lang.String r0 = "activity"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x0445 }
            r1.setActivity(r0)     // Catch:{ all -> 0x0445 }
        L_0x03da:
            java.lang.String r0 = "intent"
            boolean r0 = r3.isNull(r0)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x03eb
            java.lang.String r0 = "intent"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x0445 }
            r1.setIntent(r0)     // Catch:{ all -> 0x0445 }
        L_0x03eb:
            java.lang.String r0 = "browser"
            boolean r0 = r3.isNull(r0)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x040f
            java.lang.String r0 = "browser"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x0445 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0445 }
            r2.<init>(r0)     // Catch:{ all -> 0x0445 }
            java.lang.String r0 = "url"
            boolean r0 = r2.isNull(r0)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x040f
            java.lang.String r0 = "url"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x0445 }
            r1.setUrl(r0)     // Catch:{ all -> 0x0445 }
        L_0x040f:
            java.lang.String r0 = "package_name"
            boolean r0 = r3.isNull(r0)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x045a
            java.lang.String r0 = "package_name"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x0445 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0445 }
            r2.<init>(r0)     // Catch:{ all -> 0x0445 }
            java.lang.String r0 = "packageDownloadUrl"
            boolean r0 = r2.isNull(r0)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x0433
            java.lang.String r0 = "packageDownloadUrl"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x0445 }
            r1.setPackageDownloadUrl(r0)     // Catch:{ all -> 0x0445 }
        L_0x0433:
            java.lang.String r0 = "packageName"
            boolean r0 = r2.isNull(r0)     // Catch:{ all -> 0x0445 }
            if (r0 != 0) goto L_0x045a
            java.lang.String r0 = "packageName"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x0445 }
            r1.setPackageName(r0)     // Catch:{ all -> 0x0445 }
            goto L_0x045a
        L_0x0445:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "get local msg from json error: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.tencent.android.tpush.logging.TLogger.e(r5, r0)
        L_0x045a:
            android.content.Context r0 = r42.getApplicationContext()
            com.tencent.android.tpush.XGPushManager.addLocalNotification(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.fcm.XGFcmListenerService.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    public void onNewToken(String str) {
        try {
            TLogger.d(TAG, "Refreshed token: " + str);
            OtherPushImpl.setToken(getApplicationContext(), str);
            OtherPushClient.updateToken(getApplicationContext());
        } catch (Throwable th2) {
            TLogger.e(TAG, "onNewToken error: " + th2.toString());
        }
    }
}
