package com.engagelab.privates.common;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.component.TransferCheck;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.engagelab.privates.push.utils.NotificationChannelUtil;
import com.engagelab.privates.push.utils.NotificationUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class n extends l {

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap<String, Integer> f64970b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static volatile n f64971c = null;

    public static n b() {
        if (f64971c == null) {
            synchronized (n.class) {
                f64971c = new n();
            }
        }
        return f64971c;
    }

    public void a(Context context, Bundle bundle) {
        String str;
        int i11;
        Context context2 = context;
        try {
            String string = bundle.getString("message");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String messageId = NotificationUtil.getMessageId(jSONObject);
                if (TextUtils.isEmpty(messageId)) {
                    MTCommonLog.d("MTNotificationBusiness", "notificationMessage's messageId is null, can't show this notification");
                    return;
                }
                String optString = jSONObject.optString("override_msg_id");
                if (TextUtils.isEmpty(optString)) {
                    i11 = NotificationUtil.getNotificationId(messageId);
                } else {
                    i11 = NotificationUtil.getNotificationId(optString);
                }
                int optInt = jSONObject.optInt("n_builder_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
                if (optJSONObject == null) {
                    MTCommonLog.d("MTNotificationBusiness", "onMessage failed, can't parse content");
                    return;
                }
                String optString2 = optJSONObject.optString("n_title");
                String optString3 = optJSONObject.optString("n_content");
                Bundle convertJsonToBundle = NotificationUtil.convertJsonToBundle(optJSONObject.optJSONObject("n_extras"));
                String optString4 = optJSONObject.optString("n_small_icon");
                String optString5 = optJSONObject.optString("n_large_icon");
                int optInt2 = optJSONObject.optInt("n_alert_type", -1);
                int optInt3 = optJSONObject.optInt("n_priority");
                str = "MTNotificationBusiness";
                try {
                    String optString6 = optJSONObject.optString(MessageKey.MSG_NOTIFACTION_CATEGORY);
                    String str2 = "message";
                    int optInt4 = optJSONObject.optInt("n_style");
                    String optString7 = optJSONObject.optString("n_big_text");
                    String optString8 = optJSONObject.optString("n_big_pic_path");
                    String str3 = optString6;
                    String[] convertJsonToArray = NotificationUtil.convertJsonToArray(optJSONObject.optString("n_inbox"));
                    String optString9 = optJSONObject.optString("n_channel_id");
                    String optString10 = optJSONObject.optString("n_sound");
                    int optInt5 = optJSONObject.optInt("n_badge_add_num");
                    String optString11 = optJSONObject.optString("intent_uri");
                    NotificationMessage badge = new NotificationMessage().setMessageId(messageId).setOverrideMessageId(optString).setPlatform((byte) 0).setNotificationId(i11).setSmallIcon(optString4).setLargeIcon(optString5).setTitle(optString2).setContent(optString3).setBuilderId(optInt).setExtras(convertJsonToBundle).setStyle(optInt4).setBigText(optString7).setInbox(convertJsonToArray).setBigPicture(optString8).setDefaults(optInt2).setPriority(optInt3).setCategory(str3).setSound(optString10).setChannelId(optString9).setIntentUri(optString11).setBadge(optInt5);
                    Context context3 = context;
                    try {
                        a(context3, badge, bundle.getBoolean(MTPushConstants.Message.KEY_MESSAGE_LIMIT, true));
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable(str2, badge);
                        MTCommonPrivatesApi.sendMessageToMainProcess(context3, 3002, bundle2);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    MTCommonLog.d(str, "onMessage failed " + th.getMessage());
                }
            }
        } catch (Throwable th4) {
            th = th4;
            str = "MTNotificationBusiness";
            MTCommonLog.d(str, "onMessage failed " + th.getMessage());
        }
    }

    public void c(Context context, Bundle bundle) {
        try {
            String string = bundle.getString(MTCoreConstants.Protocol.KEY_PROTOCOL);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                MTCommonLog.d("MTNotificationBusiness", "revokeMessage:" + MTCommonLog.toLogString(jSONObject));
                String optString = jSONObject.optString("ids");
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length == 1) {
                        a(context, split[0], split[0]);
                    } else if (split.length == 2) {
                        a(context, split[0], split[1]);
                    }
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "revokeMessage failed " + th2.getMessage());
        }
    }

    public void d(Context context, Bundle bundle) {
        try {
            bundle.setClassLoader(NotificationMessage.class.getClassLoader());
            NotificationMessage notificationMessage = (NotificationMessage) bundle.getParcelable("message");
            if (notificationMessage != null) {
                a(context, notificationMessage, bundle.getBoolean(MTPushConstants.Message.KEY_MESSAGE_LIMIT, true));
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "showNotification failed " + th2.getMessage());
        }
    }

    public void b(Context context, Bundle bundle) {
        if (bundle != null) {
            a(context, bundle.getInt(MTPushConstants.Notification.KEY_NOTIFY_ID));
        } else if (!f64970b.isEmpty()) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            for (Map.Entry next : f64970b.entrySet()) {
                notificationManager.cancel(((Integer) next.getValue()).intValue());
                MTCommonLog.d("MTNotificationBusiness", "clear notification which messageId:" + ((String) next.getKey()) + ", notificationId:" + next.getValue());
            }
            f64970b.clear();
            MTCommonLog.d("MTNotificationBusiness", "current messageMap size " + f64970b.size());
        }
    }

    public final void b(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            launchIntentForPackage.setFlags(872415232);
            context.startActivity(launchIntentForPackage);
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "launchMainActivity failed " + th2.getMessage());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r7, int r8, android.os.Bundle r9) {
        /*
            r6 = this;
            java.lang.String r0 = "MTNotificationBusiness"
            java.lang.Class<com.engagelab.privates.push.api.NotificationMessage> r1 = com.engagelab.privates.push.api.NotificationMessage.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ all -> 0x00f7 }
            r9.setClassLoader(r1)     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = "message"
            android.os.Parcelable r9 = r9.getParcelable(r1)     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.push.api.NotificationMessage r9 = (com.engagelab.privates.push.api.NotificationMessage) r9     // Catch:{ all -> 0x00f7 }
            if (r9 != 0) goto L_0x0016
            return
        L_0x0016:
            r1 = 3201(0xc81, float:4.486E-42)
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00f7 }
            r2.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = "msg_id"
            java.lang.String r4 = r9.getMessageId()     // Catch:{ all -> 0x00f7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00f7 }
            byte r3 = r9.getPlatform()     // Catch:{ all -> 0x00f7 }
            if (r3 == 0) goto L_0x0045
            r1 = 3202(0xc82, float:4.487E-42)
            java.lang.String r3 = "sdk_type"
            byte r4 = r9.getPlatform()     // Catch:{ all -> 0x00f7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = "tmsg_id"
            java.lang.String r4 = r9.getPlatformMessageId()     // Catch:{ all -> 0x00f7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = "third_msg_status"
            goto L_0x0047
        L_0x0045:
            java.lang.String r3 = "msg_status"
        L_0x0047:
            java.lang.String r4 = "result"
            switch(r8) {
                case 3995: goto L_0x00a8;
                case 3996: goto L_0x008a;
                case 3997: goto L_0x006c;
                case 3998: goto L_0x004e;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x00c5
        L_0x004e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r8.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "onNotificationArrived "
            r8.append(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00f7 }
            r8.append(r9)     // Catch:{ all -> 0x00f7 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r8)     // Catch:{ all -> 0x00f7 }
            r8 = 1018(0x3fa, float:1.427E-42)
            r2.put(r4, r8)     // Catch:{ all -> 0x00f7 }
            goto L_0x00c5
        L_0x006c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r8.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "onNotificationClicked "
            r8.append(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00f7 }
            r8.append(r9)     // Catch:{ all -> 0x00f7 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r8)     // Catch:{ all -> 0x00f7 }
            r8 = 1000(0x3e8, float:1.401E-42)
            r2.put(r4, r8)     // Catch:{ all -> 0x00f7 }
            goto L_0x00c5
        L_0x008a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r8.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "onNotificationDeleted "
            r8.append(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00f7 }
            r8.append(r9)     // Catch:{ all -> 0x00f7 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r8)     // Catch:{ all -> 0x00f7 }
            r8 = 1038(0x40e, float:1.455E-42)
            r2.put(r4, r8)     // Catch:{ all -> 0x00f7 }
            goto L_0x00c5
        L_0x00a8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r8.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "onNotificationOpened "
            r8.append(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00f7 }
            r8.append(r9)     // Catch:{ all -> 0x00f7 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r8)     // Catch:{ all -> 0x00f7 }
            r8 = 1028(0x404, float:1.44E-42)
            r2.put(r4, r8)     // Catch:{ all -> 0x00f7 }
        L_0x00c5:
            com.engagelab.privates.core.api.MTReporter r8 = new com.engagelab.privates.core.api.MTReporter     // Catch:{ all -> 0x00f7 }
            r8.<init>()     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.core.api.MTReporter r8 = r8.setType(r3)     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.core.api.MTReporter r8 = r8.setContent(r9)     // Catch:{ all -> 0x00f7 }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x00f7 }
            r9.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = "protocol"
            r9.putParcelable(r3, r8)     // Catch:{ all -> 0x00f7 }
            r8 = 2233(0x8b9, float:3.129E-42)
            com.engagelab.privates.common.api.MTCommonPrivatesApi.sendMessageToRemoteProcess(r7, r8, r9)     // Catch:{ all -> 0x00f7 }
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x00f7 }
            r8.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = "json"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00f7 }
            r8.putString(r9, r2)     // Catch:{ all -> 0x00f7 }
            com.engagelab.privates.common.api.MTCommonPrivatesApi.sendMessageToMainProcess(r7, r1, r8)     // Catch:{ all -> 0x00f7 }
            goto L_0x0110
        L_0x00f7:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "processRemoteMessage failed "
            r8.append(r9)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r0, r7)
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.engagelab.privates.common.n.b(android.content.Context, int, android.os.Bundle):void");
    }

    public final void b(Context context, String str, Set<String> set) {
        if (!TextUtils.isEmpty(str)) {
            if (set == null) {
                set = new LinkedHashSet<>();
            } else if (set.size() >= 50) {
                Iterator<String> it2 = set.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (set.size() >= 50) {
                        it2.remove();
                    }
                }
            }
            set.add(str);
            MTCommonLog.d("MTNotificationBusiness", "addRevokeMessageId " + str);
            t.b(context, set);
        }
    }

    public final void b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg_id", str);
            jSONObject.put("result", MTPushConstants.Message.CODE_MESSAGE_REVOKE);
            MTReporter content = new MTReporter().setType(MTPushConstants.Message.TYPE_MESSAGE_STATE).setContent(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MTPushConstants.Analysis.KEY_JSON, jSONObject.toString());
            MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.REPORT_MESSAGE_STATE, bundle2);
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "reportRevokeMessage failed " + th2.getMessage());
        }
    }

    public final void a(Context context, NotificationMessage notificationMessage, boolean z11) {
        Notification.Builder builder;
        Notification notification;
        Icon smallIcon;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 11) {
            MTCommonLog.w("MTNotificationBusiness", "api is low than 11, can't show notification");
            return;
        }
        MTCommonLog.d("MTNotificationBusiness", "showNotification " + notificationMessage.toString());
        byte platform = notificationMessage.getPlatform();
        String messageId = notificationMessage.getMessageId();
        String overrideMessageId = notificationMessage.getOverrideMessageId();
        if (z11 && !a(context, platform, messageId, overrideMessageId)) {
            return;
        }
        if (!j.a().c(context)) {
            MTCommonLog.w("MTNotificationBusiness", "is not notificationShowTime, notificationShowTime:" + t.f(context));
        } else if (TextUtils.isEmpty(notificationMessage.getContent())) {
            MTCommonLog.w("MTNotificationBusiness", "notificationMessage's content is null, can't show this notification " + notificationMessage.toString());
        } else {
            boolean d11 = j.a().d(context);
            if (i11 >= 26) {
                builder = new Notification.Builder(context, NotificationChannelUtil.getChannel(context, d11, notificationMessage));
            } else {
                builder = new Notification.Builder(context);
            }
            builder.setAutoCancel(true);
            builder.setWhen(System.currentTimeMillis());
            String title = NotificationUtil.getTitle(context, notificationMessage);
            builder.setContentTitle(title);
            notificationMessage.setTitle(title);
            String content = NotificationUtil.getContent(context, notificationMessage);
            builder.setContentText(NotificationUtil.getContent(context, notificationMessage));
            notificationMessage.setContent(content);
            int defaults = NotificationUtil.getDefaults(context, d11, notificationMessage);
            builder.setDefaults(defaults);
            notificationMessage.setDefaults(defaults);
            builder.setContentIntent(NotificationUtil.getPendingIntent(context, String.valueOf(3003), notificationMessage));
            builder.setDeleteIntent(NotificationUtil.getPendingIntent(context, String.valueOf(3004), notificationMessage));
            int smallIcon2 = NotificationUtil.getSmallIcon(context);
            if (smallIcon2 > 0) {
                builder.setSmallIcon(smallIcon2);
            }
            Bitmap largeIcon = NotificationUtil.getLargeIcon(context, notificationMessage.getLargeIcon());
            if (largeIcon != null) {
                builder.setLargeIcon(largeIcon);
            }
            Uri soundUri = NotificationUtil.getSoundUri(context, d11, notificationMessage);
            if (soundUri != null) {
                builder.setSound(soundUri);
            }
            RemoteViews notificationLayout = NotificationUtil.getNotificationLayout(context, notificationMessage);
            if (notificationLayout != null) {
                builder.setContent(notificationLayout);
            }
            if (i11 >= 16) {
                builder.setPriority(NotificationUtil.getPriority(context, d11, notificationMessage));
            }
            if (i11 >= 17) {
                builder.setStyle(NotificationUtil.getStyle(context, notificationMessage));
            }
            if (i11 >= 21) {
                builder.setVisibility(NotificationUtil.getVisibility(context, d11, notificationMessage));
                if (!TextUtils.isEmpty(notificationMessage.getCategory())) {
                    builder.setCategory(notificationMessage.getCategory());
                }
            }
            if (i11 >= 23 && (smallIcon = NotificationUtil.getSmallIcon(context, notificationMessage)) != null) {
                builder.setSmallIcon(smallIcon);
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            int b11 = j.a().b(context);
            if (f64970b.size() >= b11) {
                Object[] array = f64970b.keySet().toArray();
                Arrays.sort(array);
                for (Object obj : array) {
                    Integer num = f64970b.get(obj);
                    MTCommonLog.d("MTNotificationBusiness", "currentNotificationCount is " + f64970b.size() + ", limit notificationCount [" + b11 + "], need remove messageId[" + obj + "]:notificationId[" + num + "]");
                    notificationManager.cancel(num.intValue());
                    f64970b.remove(obj);
                    if (f64970b.size() < b11) {
                        break;
                    }
                }
            }
            f64970b.put(notificationMessage.getMessageId(), Integer.valueOf(notificationMessage.getNotificationId()));
            MTCommonLog.d("MTNotificationBusiness", "after add, current messageMap size " + f64970b.size());
            if (Build.VERSION.SDK_INT >= 16) {
                notification = builder.build();
            } else {
                notification = builder.getNotification();
            }
            NotificationUtil.setNotificationBadge(context, notification, notificationMessage.getBadge());
            int notificationId = notificationMessage.getNotificationId();
            notificationManager.notify(notificationId, notification);
            PushAutoTrackHelper.onNotify(notificationManager, notificationId, notification);
            MTCommonLog.d("MTNotificationBusiness", "showNotification notificationId:" + notificationMessage.getNotificationId());
        }
    }

    public final void a(Context context) {
        try {
            if (MTGlobal.getLifecycleState()) {
                MTCommonLog.d("MTNotificationBusiness", "pushSdkVersionName:" + MTPushPrivatesApi.SDK_VERSION_NAME + ", isForeground, no need launch");
                return;
            }
            MTCommonLog.d("MTNotificationBusiness", "pushSdkVersionName:" + MTPushPrivatesApi.SDK_VERSION_NAME + ", isBackground, need launch");
            String currentActivityName = MTGlobal.getCurrentActivityName();
            if (!TextUtils.isEmpty(currentActivityName)) {
                a(context, currentActivityName);
            } else {
                b(context);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "launch failed " + th2.getMessage());
        }
    }

    public final void a(Context context, NotificationMessage notificationMessage) {
        try {
            String intentUri = notificationMessage.getIntentUri();
            if (TextUtils.isEmpty(intentUri)) {
                MTCommonLog.d("MTNotificationBusiness", "pushSdkVersionName:" + MTPushPrivatesApi.SDK_VERSION_NAME + ", there is no intentUri, no need transfer");
                a(context);
                return;
            }
            MTCommonLog.d("MTNotificationBusiness", "pushSdkVersionName:" + MTPushPrivatesApi.SDK_VERSION_NAME + ", there is intentUri, need transfer");
            Intent a11 = a(intentUri);
            a11.addFlags(335544320);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", notificationMessage);
            a11.putExtras(bundle);
            context.startActivity(a11);
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "transfer failed " + th2.getMessage());
        }
    }

    public final Intent a(String str) throws URISyntaxException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i11 = 0;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 > 22) {
            i11 = 4;
        }
        Intent parseUri = Intent.parseUri(str, i11);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent((ComponentName) null);
        if (i12 >= 15) {
            parseUri.setSelector((Intent) null);
        }
        return intent;
    }

    public final void a(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), str);
            intent.setFlags(872415232);
            context.startActivity(intent);
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "launchCurrentActivity failed " + th2.getMessage());
        }
    }

    public void a(Context context, int i11, Bundle bundle) {
        MTCommonReceiver commonReceiver;
        try {
            bundle.setClassLoader(NotificationMessage.class.getClassLoader());
            NotificationMessage notificationMessage = (NotificationMessage) bundle.getParcelable("message");
            if (notificationMessage != null && (commonReceiver = MTGlobal.getCommonReceiver(context)) != null) {
                switch (i11) {
                    case 3002:
                        commonReceiver.onNotificationArrived(context, notificationMessage);
                        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ON_NOTIFICATION_ARRIVED, bundle);
                        return;
                    case 3003:
                        MTCommonLog.w("MTNotificationBusiness", "on_notification_clicked");
                        String intentUri = notificationMessage.getIntentUri();
                        if (TransferCheck.isAllowTransfer(context, intentUri, notificationMessage.getIntentSsl())) {
                            MTCommonLog.d("MTNotificationBusiness", "allow transfer to " + intentUri);
                            if (MTPushPrivatesApi.SDK_VERSION_NAME.startsWith("3")) {
                                if (notificationMessage.getPlatform() == 0) {
                                    a(context);
                                }
                                if (notificationMessage.getPlatform() == 8) {
                                    a(context, notificationMessage);
                                }
                            } else {
                                a(context, notificationMessage);
                            }
                        } else {
                            MTCommonLog.d("MTNotificationBusiness", "prevent transfer to " + intentUri);
                        }
                        commonReceiver.onNotificationClicked(context, notificationMessage);
                        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ON_NOTIFICATION_CLICKED, bundle);
                        return;
                    case 3004:
                        commonReceiver.onNotificationDeleted(context, notificationMessage);
                        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ON_NOTIFICATION_DELETED, bundle);
                        return;
                    case 3005:
                        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ON_NOTIFICATION_OPENED, bundle);
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "processMainMessage failed " + th2.getMessage());
        }
    }

    public final void a(Context context, String str, String str2) {
        MTCommonLog.d("MTNotificationBusiness", "revokeNotification reportMessageId:" + str + ",revokeMessageId:" + str2);
        b(context, str2, t.i(context));
        int notificationId = NotificationUtil.getNotificationId(str2);
        Set<String> a11 = t.a(context, (byte) 0);
        if (a11 == null || !a11.contains(str)) {
            MTCommonLog.d("MTNotificationBusiness", "there are no messageId [" + str + "] in cache messageIdSet");
            Set<String> a12 = t.a(context, (byte) 8);
            if (a12 == null || !a12.contains(str)) {
                MTCommonLog.d("MTNotificationBusiness", "there are no messageId [" + str + "] in cache googleMessageIdSet");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("revoke third message ");
                sb2.append(str);
                MTCommonLog.d("MTNotificationBusiness", sb2.toString());
                Bundle bundle = new Bundle();
                bundle.putInt(MTPushConstants.Message.KEY_NOTIFICATION_ID, notificationId);
                MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.CLEAR_PLATFORM_NOTIFICATION, bundle);
            } else if (!a(context, notificationId, true)) {
                MTCommonLog.d("MTNotificationBusiness", "the message [" + str2 + "] is not showing");
            } else {
                a(context, notificationId);
                a(context, str, (byte) 8, "");
            }
        } else if (!a(context, notificationId, true)) {
            MTCommonLog.d("MTNotificationBusiness", "the message [" + str2 + "] is not showing");
        } else {
            a(context, notificationId);
            b(context, str);
        }
    }

    public final void a(Context context, int i11) {
        MTCommonLog.d("MTNotificationBusiness", "cancel notificationId:" + i11);
        ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(i11);
        a(i11);
    }

    public void a(int i11) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = f64970b;
        if (concurrentHashMap == null) {
            MTCommonLog.d("MTNotificationBusiness", "there are no aurora notification");
        } else if (!concurrentHashMap.containsValue(Integer.valueOf(i11))) {
            MTCommonLog.d("MTNotificationBusiness", "there are no aurora notification " + i11);
        } else {
            Iterator<Map.Entry<String, Integer>> it2 = f64970b.entrySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((Integer) it2.next().getValue()).intValue() == i11) {
                        it2.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            MTCommonLog.d("MTNotificationBusiness", "after remove, current messageMap size " + f64970b.size());
        }
    }

    public final boolean a(Context context, int i11, boolean z11) {
        if (Build.VERSION.SDK_INT < 23) {
            return z11;
        }
        for (StatusBarNotification statusBarNotification : ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).getActiveNotifications()) {
            MTCommonLog.d("MTNotificationBusiness", "statusBarNotification:" + statusBarNotification.getId());
            if (statusBarNotification.getId() == i11) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(Context context, byte b11, String str, String str2) {
        Set<String> a11 = t.a(context, b11);
        if (a11 == null || a11.isEmpty() || TextUtils.isEmpty(str) || !a11.contains(str)) {
            Set<String> h11 = t.h(context);
            if (h11 == null || h11.isEmpty() || TextUtils.isEmpty(str) || !str2.contains(str)) {
                Set<String> i11 = t.i(context);
                if (i11 != null && !i11.isEmpty() && !TextUtils.isEmpty(str) && i11.contains(str)) {
                    MTCommonLog.d("MTNotificationBusiness", "the message [" + str + "] had been revoke");
                    b(context, str);
                    return false;
                } else if (a11 == null || a11.isEmpty() || TextUtils.isEmpty(str2) || !a11.contains(str2)) {
                    a(context, b11, str, a11);
                    a(context, str2, h11);
                    return true;
                } else {
                    MTCommonLog.d("MTNotificationBusiness", "the overrideMessage [" + str2 + "] had been show");
                    if (!a(context, NotificationUtil.getNotificationId(str2), true)) {
                        return false;
                    }
                    MTCommonLog.d("MTNotificationBusiness", "the overrideMessage [" + str2 + "] is showing, need override");
                    a(context, b11, str, a11);
                    a(context, str2, h11);
                    return true;
                }
            } else {
                MTCommonLog.d("MTNotificationBusiness", "the message [" + str + "] had been override");
                return false;
            }
        } else {
            MTCommonLog.d("MTNotificationBusiness", "the message [" + str + "] had been show");
            return false;
        }
    }

    public final void a(Context context, byte b11, String str, Set<String> set) {
        if (!TextUtils.isEmpty(str)) {
            if (set == null) {
                set = new LinkedHashSet<>();
            } else if (set.size() >= 50) {
                Iterator<String> it2 = set.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (set.size() >= 50) {
                        it2.remove();
                    }
                }
            }
            set.add(str);
            MTCommonLog.d("MTNotificationBusiness", "addMessageId " + str);
            t.a(context, b11, set);
        }
    }

    public final void a(Context context, String str, Set<String> set) {
        if (!TextUtils.isEmpty(str)) {
            if (set == null) {
                set = new LinkedHashSet<>();
            } else if (set.size() >= 50) {
                Iterator<String> it2 = set.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (set.size() >= 50) {
                        it2.remove();
                    }
                }
            }
            set.add(str);
            MTCommonLog.d("MTNotificationBusiness", "addOverrideMessageId " + str);
            t.a(context, set);
        }
    }

    public final void a(Context context, String str, byte b11, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg_id", str);
            jSONObject.put(HianalyticsBaseData.SDK_TYPE, b11);
            jSONObject.put("tmsg_id", str2);
            jSONObject.put("result", MTPushConstants.Message.CODE_REVOKE_PLATFORM_MESSAGE);
            MTReporter content = new MTReporter().setType(MTPushConstants.Message.TYPE_PLATFORM_MESSAGE_STATE).setContent(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MTPushConstants.Analysis.KEY_JSON, jSONObject.toString());
            MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.REPORT_PLATFORM_MESSAGE_STATE, bundle2);
        } catch (Throwable th2) {
            MTCommonLog.w("MTNotificationBusiness", "reportRevokeMessage failed " + th2.getMessage());
        }
    }
}
