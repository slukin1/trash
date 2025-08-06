package com.tencent.android.tpush.message;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.firebase.messaging.CommonNotificationBuilder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.InnerTpnsActivity;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.XGBasicPushNotificationBuilder;
import com.tencent.android.tpush.XGCustomPushNotificationBuilder;
import com.tencent.android.tpush.XGNotifaction;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushNotifactionCallback;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.tencent.android.tpush.XGSysNotifaction;
import com.tencent.android.tpush.XGSysPushNotifactionCallback;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.f.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile BroadcastReceiver f69420a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile BroadcastReceiver f69421b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static MediaPlayer f69422c;

    /* renamed from: d  reason: collision with root package name */
    private static Bitmap f69423d;

    /* renamed from: com.tencent.android.tpush.message.b$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69428a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tencent.android.tpush.NotificationAction[] r0 = com.tencent.android.tpush.NotificationAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f69428a = r0
                com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.activity     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f69428a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.url     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f69428a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.intent     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f69428a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.intent_with_action     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f69428a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.action_package     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.b.AnonymousClass3.<clinit>():void");
        }
    }

    public static String b(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    return activityInfo.name;
                }
            }
        } catch (Throwable th2) {
            TLogger.e("MessageHelper", "get Activity error", th2);
        }
        return null;
    }

    private static void c(Context context, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        Object metaData;
        int identifier;
        String s11 = dVar.s();
        if (s11 != null && !TextUtils.isEmpty(s11) && (identifier = context.getResources().getIdentifier(s11, "drawable", context.getPackageName())) > 0) {
            xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier));
        }
        if (xGPushNotificationBuilder.getSmallIcon() == null && (metaData = CommonHelper.getMetaData(context, CommonNotificationBuilder.METADATA_DEFAULT_ICON, (Object) null)) != null) {
            try {
                int intValue = ((Integer) metaData).intValue();
                TLogger.i("MessageHelper", "get meta-data fcm_default_notification_icon " + intValue);
                if (intValue > 0) {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
                TLogger.w("MessageHelper", "get meta-data fcm_default_notification_icon invalid resource id: " + metaData);
            }
        }
        if (xGPushNotificationBuilder.getSmallIcon() != null) {
            return;
        }
        if (d.j().equals(Constants.REFERRER_API_GOOGLE)) {
            int identifier2 = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
            if (identifier2 > 0) {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier2));
            } else {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
            }
        } else {
            xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
        }
    }

    private static String a(int i11) {
        return "TPUSH_NOTIF_BUILDID_" + String.valueOf(i11);
    }

    public static synchronized XGPushNotificationBuilder a(Context context) {
        XGPushNotificationBuilder flags;
        synchronized (b.class) {
            flags = new XGBasicPushNotificationBuilder().setFlags(16);
        }
        return flags;
    }

    public static void a(Context context, int i11, XGPushNotificationBuilder xGPushNotificationBuilder) {
        String a11 = a(i11);
        JSONObject jSONObject = new JSONObject();
        xGPushNotificationBuilder.encode(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        CommonHelper.jsonPut(jSONObject2, xGPushNotificationBuilder.getType(), jSONObject.toString());
        PushPreferences.putString(context, a11, jSONObject2.toString());
    }

    private static XGPushNotificationBuilder b(Context context, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        Object metaData;
        if (xGPushNotificationBuilder == null) {
            xGPushNotificationBuilder = XGPushManager.getDefaultNotificationBuilder(context);
        }
        if (xGPushNotificationBuilder == null) {
            xGPushNotificationBuilder = a(context);
        }
        if (dVar.j() != 0) {
            xGPushNotificationBuilder.setFlags(16);
        }
        if (XGPushConfig.isEnableNotificationSound(context) && dVar.h() != 0) {
            if (!TextUtils.isEmpty(dVar.q())) {
                int identifier = context.getResources().getIdentifier(dVar.q(), "raw", context.getPackageName());
                if (identifier > 0) {
                    xGPushNotificationBuilder.setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + identifier));
                } else {
                    xGPushNotificationBuilder.setDefaults(1);
                }
            } else {
                xGPushNotificationBuilder.setDefaults(1);
            }
        }
        if (dVar.i() != 0) {
            xGPushNotificationBuilder.setDefaults(2);
        }
        if (dVar.p() != 0) {
            xGPushNotificationBuilder.setDefaults(4);
            xGPushNotificationBuilder.setFlags(1);
        }
        c(context, dVar, xGPushNotificationBuilder);
        int t11 = dVar.t();
        String r11 = dVar.r();
        Integer layoutIconId = xGPushNotificationBuilder instanceof XGCustomPushNotificationBuilder ? ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).getLayoutIconId() : null;
        if (r11 != null && !TextUtils.isEmpty(r11)) {
            if (t11 <= 0) {
                int identifier2 = context.getResources().getIdentifier(r11, "drawable", context.getPackageName());
                if (identifier2 > 0) {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), identifier2));
                    if (layoutIconId != null) {
                        ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).setLayoutIconDrawableId(identifier2);
                    }
                } else {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
                }
            } else {
                Bitmap a11 = a(r11);
                if (a11 == null) {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
                } else {
                    xGPushNotificationBuilder.setLargeIcon(a11);
                    if (layoutIconId != null) {
                        ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).setLayoutIconDrawableBmp(a11);
                    }
                    if (r11.equals(dVar.n())) {
                        f69423d = a11;
                    }
                }
            }
        }
        int B = dVar.B();
        if (B > 0) {
            xGPushNotificationBuilder.setColor(Integer.valueOf(B));
        }
        if (xGPushNotificationBuilder.getColor() == null && (metaData = CommonHelper.getMetaData(context, CommonNotificationBuilder.METADATA_DEFAULT_COLOR, (Object) null)) != null) {
            try {
                int intValue = ((Integer) metaData).intValue();
                TLogger.i("MessageHelper", "get meta-data fcm_default_notification_color " + intValue);
                if (intValue > 0) {
                    xGPushNotificationBuilder.setColor(Integer.valueOf(context.getResources().getColor(intValue)));
                }
            } catch (Throwable unused) {
                TLogger.w("MessageHelper", "get meta-data fcm_default_notification_color invalid resource id: " + metaData);
            }
        }
        xGPushNotificationBuilder.setNotificationCategory(dVar.F());
        xGPushNotificationBuilder.setNotificationImportance(dVar.G());
        return xGPushNotificationBuilder;
    }

    public static XGPushNotificationBuilder a(Context context, int i11) {
        XGPushNotificationBuilder xGCustomPushNotificationBuilder;
        String string;
        XGPushNotificationBuilder xGPushNotificationBuilder = null;
        if (context == null) {
            return null;
        }
        String string2 = PushPreferences.getString(context, a(i11), (String) null);
        if (string2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(string2);
                if (jSONObject.has("basic")) {
                    xGCustomPushNotificationBuilder = new XGBasicPushNotificationBuilder();
                    try {
                        string = jSONObject.getString("basic");
                    } catch (JSONException e11) {
                        e = e11;
                        xGPushNotificationBuilder = xGCustomPushNotificationBuilder;
                        TLogger.e("MessageHelper", "unexpected for getNotificationBuilder", e);
                        return xGPushNotificationBuilder;
                    }
                } else if (!jSONObject.has("custom")) {
                    return null;
                } else {
                    xGCustomPushNotificationBuilder = new XGCustomPushNotificationBuilder();
                    string = jSONObject.getString("custom");
                }
                xGPushNotificationBuilder = xGCustomPushNotificationBuilder;
                xGPushNotificationBuilder.decode(string);
            } catch (JSONException e12) {
                e = e12;
            }
        } else {
            TLogger.i("MessageHelper", "PushNotificationBuilder not found :" + i11);
        }
        return xGPushNotificationBuilder;
    }

    public static Intent a(Context context, d.a aVar, boolean z11, PushMessageManager pushMessageManager, boolean z12) {
        int i11;
        int i12;
        Class<InnerTpnsActivity> cls = InnerTpnsActivity.class;
        NotificationAction notificationAction = NotificationAction.getNotificationAction(aVar.f69459a);
        Intent intent = null;
        if (notificationAction == null) {
            return null;
        }
        int i13 = AnonymousClass3.f69428a[notificationAction.ordinal()];
        if (i13 == 1) {
            intent = new Intent(com.tencent.android.tpush.common.Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            String str = aVar.f69460b;
            if (j.b(str)) {
                str = b(context);
            }
            d.a.C0749a aVar2 = aVar.f69461c;
            if (aVar2 == null || (i12 = aVar2.f69469a) <= 0) {
                intent.setFlags(67108864);
            } else {
                intent.setFlags(i12);
            }
            intent.putExtra("activity", str);
            NotificationAction notificationAction2 = NotificationAction.activity;
            intent.putExtra("notificationActionType", notificationAction2.getType());
            intent.putExtra("action_type", notificationAction2.getType());
            intent.putExtra(com.tencent.android.tpush.common.Constants.PUSH_CHANNEL, pushMessageManager.pushChannel);
            intent.setClass(context, cls);
        } else if (i13 == 2) {
            intent = new Intent(com.tencent.android.tpush.common.Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            intent.putExtra("activity", aVar.f69464f);
            intent.putExtra("action_type", aVar.f69459a);
            intent.putExtra("notificationActionType", NotificationAction.url.getType());
            intent.putExtra(com.tencent.android.tpush.common.Constants.PUSH_CHANNEL, pushMessageManager.pushChannel);
            intent.setClass(context, cls);
        } else if (i13 == 3 || i13 == 4) {
            intent = new Intent(com.tencent.android.tpush.common.Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            intent.putExtra("activity", aVar.f69462d);
            intent.putExtra("action_type", aVar.f69459a);
            int i14 = aVar.f69459a;
            NotificationAction notificationAction3 = NotificationAction.intent_with_action;
            if (i14 == notificationAction3.getType()) {
                intent.putExtra("notificationActionType", notificationAction3.getType());
            } else {
                intent.putExtra("notificationActionType", NotificationAction.intent.getType());
            }
            intent.putExtra(com.tencent.android.tpush.common.Constants.PUSH_CHANNEL, pushMessageManager.pushChannel);
            intent.setClass(context, cls);
        } else if (i13 != 5) {
            TLogger.e("MessageHelper", "getIntentByOpenType unknown action_type: " + aVar.f69459a);
        } else {
            intent = new Intent(com.tencent.android.tpush.common.Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            String str2 = aVar.f69466h;
            if (j.b(str2)) {
                return intent;
            }
            intent.putExtra("action_type", aVar.f69459a);
            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_DOWNLOAD_URL, aVar.f69468j);
            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_NAME, str2);
            intent.putExtra("activity", str2);
            intent.putExtra("notificationActionType", NotificationAction.action_package.getType());
            intent.putExtra(com.tencent.android.tpush.common.Constants.PUSH_CHANNEL, pushMessageManager.pushChannel);
            intent.setClass(context, cls);
        }
        if (intent != null) {
            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACTION_CONFIRM, aVar.f69465g);
            intent.putExtra("msgId", pushMessageManager.getMsgId());
            intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, pushMessageManager.getBusiMsgId());
            intent.putExtra(MessageKey.MSG_PUSH_TIME, pushMessageManager.pushTime);
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, pushMessageManager.pushChannel);
            intent.putExtra("groupId", pushMessageManager.getGroupId());
            intent.putExtra(MessageKey.MSG_TARGET_TYPE, pushMessageManager.getTargetType());
            intent.putExtra("source", pushMessageManager.getSource());
            d dVar = (d) pushMessageManager.getMessageHolder();
            intent.putExtra(com.tencent.android.tpush.common.Constants.TAG_TPUSH_MESSAGE, "true");
            intent.putExtra("title", Rijndael.encrypt(dVar.d()));
            intent.putExtra("content", Rijndael.encrypt(dVar.e()));
            if (dVar.f() != null) {
                intent.putExtra("custom_content", Rijndael.encrypt(dVar.f()));
            }
            intent.putExtra("msgId", pushMessageManager.getMsgId());
            intent.putExtra("accId", pushMessageManager.getAccessId());
            intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, pushMessageManager.getBusiMsgId());
            intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, pushMessageManager.getTimestamps());
            intent.putExtra("group_id", pushMessageManager.getGroupId());
            intent.putExtra(MessageKey.MSG_TEMPLATE_ID, pushMessageManager.getTemplateId());
            intent.putExtra(MessageKey.MSG_TRACE_ID, pushMessageManager.getTraceId());
            intent.putExtra(MessageKey.MSG_PORTECT_TAG, Rijndael.encrypt("" + (System.currentTimeMillis() - 1000)));
            int k11 = dVar.k();
            if (k11 <= 0) {
                k11 = b(context, dVar.g());
            }
            intent.putExtra(MessageKey.NOTIFACTION_ID, k11);
        }
        if (intent != null && z12) {
            d.a.C0749a aVar3 = aVar.f69461c;
            if (aVar3 == null || (i11 = aVar3.f69469a) <= 0) {
                intent.setFlags(67108864);
            } else {
                intent.setFlags(i11);
            }
        }
        return intent;
    }

    private static synchronized int b(Context context, int i11) {
        int i12;
        synchronized (b.class) {
            i12 = 0;
            try {
                String str = "_XINGE_NOTIF_NUMBER_" + String.valueOf(i11);
                int i13 = PushPreferences.getInt(context, str, 0);
                if (i13 < 2147483646) {
                    i12 = i13;
                }
                PushPreferences.putInt(context, str, i12 + 1);
            } catch (Throwable th2) {
                TLogger.e("MessageHelper", "", th2);
            }
        }
        return i12;
    }

    @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
    public static void a(Context context, Context context2, PushMessageManager pushMessageManager) {
        boolean z11;
        Context context3;
        boolean z12;
        PushMessageManager pushMessageManager2;
        int i11;
        String str;
        Intent intent;
        boolean z13;
        String str2;
        Intent intent2;
        Notification notification;
        int i12;
        Context context4 = context;
        if (context2 == null) {
            context3 = context4;
            z11 = false;
        } else {
            context3 = context2;
            z11 = true;
        }
        d dVar = (d) pushMessageManager.getMessageHolder();
        d.a l11 = dVar.l();
        XGPushNotificationBuilder a11 = a(context4, dVar.g());
        if (a11 == null || dVar.u() == 1) {
            a11 = b(context4, dVar, a11);
        }
        XGPushNotificationBuilder xGPushNotificationBuilder = a11;
        a(context4, dVar, xGPushNotificationBuilder);
        String f11 = dVar.f();
        if (j.b(f11) || "{}".equalsIgnoreCase(f11)) {
            pushMessageManager2 = pushMessageManager;
            z12 = false;
        } else {
            pushMessageManager2 = pushMessageManager;
            z12 = true;
        }
        Intent a12 = a(context4, l11, z12, pushMessageManager2, z11);
        if (a12 == null) {
            TLogger.e("MessageHelper", "unexpected action intent null, Action -> showNotification terminate");
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context4.getSystemService(RemoteMessageConst.NOTIFICATION);
        int k11 = dVar.k();
        if (k11 == -1) {
            notificationManager.cancelAll();
        }
        int i13 = 134217728;
        d.a.C0749a aVar = l11.f69461c;
        if (aVar != null && (i12 = aVar.f69470b) > 0) {
            i13 = i12;
        }
        int i14 = i13 | TPMediaCodecProfileLevel.HEVCHighTierLevel62;
        int i15 = k11;
        boolean a13 = a(context, pushMessageManager, dVar, xGPushNotificationBuilder, k11, i14);
        if (dVar.D() <= 0 || a13 || !TextUtils.isEmpty(dVar.d()) || !TextUtils.isEmpty(dVar.e())) {
            a12.putExtra(com.tencent.android.tpush.common.Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT, a13);
            if (f69420a == null) {
                f69420a = new BroadcastReceiver() {
                    public void onReceive(final Context context, final Intent intent) {
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        final String stringExtra = intent.getStringExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME);
                        TLogger.ii("MessageHelper", "onReceive: Notification has canceled! pkg name: " + stringExtra);
                        if (a.a(context.getApplicationContext()) || (!j.b(stringExtra) && stringExtra.equals(context.getPackageName()))) {
                            CommonWorkingThread.getInstance().execute(new TTask() {
                                public void TRun() {
                                    MessageManager.getInstance().updateCachedMsgIntentToCancel(context, intent.getLongExtra("msgId", -1));
                                    Intent intent = new Intent(com.tencent.android.tpush.common.Constants.ACTION_FEEDBACK);
                                    intent.setPackage(stringExtra);
                                    intent.putExtras(intent);
                                    intent.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_TAG, 4);
                                    BroadcastAgent.sendBroadcast(context, intent);
                                    Intent intent2 = new Intent("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
                                    intent2.putExtras(intent);
                                    intent2.putExtra(com.tencent.android.tpush.common.Constants.FLAG_CLICK_TIME, System.currentTimeMillis() / 1000);
                                    ServiceStat.appReportNotificationCleared(context, intent2);
                                    BroadcastAgent.sendBroadcast(context, intent2);
                                }
                            });
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(context3.getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
                BroadcastAgent.registerReceiver(context3, f69420a, intentFilter, 4);
            }
            Intent intent3 = new Intent(context3.getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
            intent3.setPackage(context3.getPackageName());
            intent3.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, context.getPackageName());
            intent3.putExtra("action", NotificationAction.delete.getType());
            intent3.putExtras(a12);
            int i16 = Build.VERSION.SDK_INT;
            if (i16 == 19) {
                i11 = i14;
                PushAutoTrackHelper.hookIntentGetActivity(context4, i15, a12, i11);
                PendingIntent activity = PendingIntent.getActivity(context4, i15, a12, i11);
                PushAutoTrackHelper.hookPendingIntentGetActivity(activity, context4, i15, a12, i11);
                activity.cancel();
            } else {
                i11 = i14;
            }
            if (!z11) {
                PushAutoTrackHelper.hookIntentGetActivity(context4, i15, a12, i11);
                PendingIntent activity2 = PendingIntent.getActivity(context4, i15, a12, i11);
                PushAutoTrackHelper.hookPendingIntentGetActivity(activity2, context4, i15, a12, i11);
                xGPushNotificationBuilder.setContentIntent(activity2);
            } else if (i16 >= 26) {
                xGPushNotificationBuilder.setRunAsSysAndAndBuildSdk26(true);
            }
            if (f69421b == null) {
                f69421b = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        String action = intent.getAction();
                        if (action != null) {
                            String stringExtra = intent.getStringExtra(MessageKey.MSG_AUDIO_URL);
                            if (!action.equals(context.getPackageName() + ".APP_PUSH_MEDIA.PLAY") || TextUtils.isEmpty(stringExtra)) {
                                if (action.equals(context.getPackageName() + ".APP_PUSH_MEDIA.STOP")) {
                                    try {
                                        if (b.f69422c != null) {
                                            b.f69422c.stop();
                                            b.f69422c.release();
                                            MediaPlayer unused = b.f69422c = null;
                                        }
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                }
                            } else {
                                try {
                                    if (b.f69422c == null) {
                                        MediaPlayer unused2 = b.f69422c = new MediaPlayer();
                                        b.f69422c.setAudioStreamType(3);
                                    }
                                    b.f69422c.reset();
                                    b.f69422c.setDataSource(stringExtra);
                                    b.f69422c.prepare();
                                    b.f69422c.start();
                                } catch (IllegalArgumentException e11) {
                                    e11.printStackTrace();
                                } catch (IllegalStateException e12) {
                                    e12.printStackTrace();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                        }
                    }
                };
                IntentFilter intentFilter2 = new IntentFilter();
                StringBuilder sb2 = new StringBuilder();
                str = com.tencent.android.tpush.common.Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT;
                sb2.append(context.getPackageName());
                sb2.append(".APP_PUSH_MEDIA.PLAY");
                intentFilter2.addAction(sb2.toString());
                intentFilter2.addAction(context.getPackageName() + ".APP_PUSH_MEDIA.STOP");
                BroadcastAgent.registerReceiver(context4, f69421b, intentFilter2, 4);
            } else {
                str = com.tencent.android.tpush.common.Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT;
            }
            Pair<Notification, Object> buildNotification = xGPushNotificationBuilder.buildNotification(context4);
            Notification notification2 = (Notification) buildNotification.first;
            Object obj = buildNotification.second;
            PushAutoTrackHelper.hookIntentGetBroadcast(context3, i15, intent3, i11);
            PendingIntent broadcast = PendingIntent.getBroadcast(context3, i15, intent3, i11);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context3, i15, intent3, i11);
            notification2.deleteIntent = broadcast;
            boolean d11 = j.d(context3, context.getPackageName());
            boolean z14 = dVar.x() == 1 && d11;
            StringBuilder sb3 = new StringBuilder();
            Intent intent4 = a12;
            sb3.append("is_show_type:");
            sb3.append(dVar.x());
            sb3.append(", OnForeground:");
            sb3.append(d11);
            TLogger.d("MessageHelper", sb3.toString());
            if (z11) {
                XGSysPushNotifactionCallback sysNotifactionCallback = XGPushManager.getSysNotifactionCallback();
                if (sysNotifactionCallback == null) {
                    TLogger.ee("MessageHelper", "XG Sys Push init Error, no notifactionCallback!");
                    return;
                } else if (z14) {
                    TLogger.d("MessageHelper", "appOnForeground ");
                    intent2 = intent4;
                } else {
                    intent2 = intent4;
                    sysNotifactionCallback.handleNotify(new XGSysNotifaction(context.getPackageName(), i15, notification2, intent2, i11, obj));
                }
            } else {
                intent2 = intent4;
                XGPushNotifactionCallback notifactionCallback = XGPushManager.getNotifactionCallback();
                if (notifactionCallback != null || !xGPushNotificationBuilder.needAutoFilterNotification(context4)) {
                    if (obj != null) {
                        XGPushNotificationBuilder.createNotificationChannel(context4, obj, xGPushNotificationBuilder);
                    }
                    if (z14) {
                        TLogger.d("MessageHelper", "appOnForeground ");
                    } else {
                        if (notifactionCallback == null) {
                            int y11 = dVar.y();
                            if (y11 == -2) {
                                XGPushConfig.changeHuaweiBadgeNum(context4, 1);
                            } else if (y11 >= 0) {
                                XGPushConfig.setBadgeNum(context4, y11);
                            }
                            try {
                                String j11 = com.tencent.android.tpush.d.d.j();
                                String z15 = dVar.z();
                                if (TextUtils.isEmpty(z15) || i16 < 24 || MTPushConstants.Manufacturer.OPPO.equals(j11) || ((a13 && "vivo".equals(j11)) || (a13 && xGPushNotificationBuilder.getCustomLayoutType() == 3 && xGPushNotificationBuilder.isSupportNotificationGroup(context4)))) {
                                    str2 = str;
                                    notification = notification2;
                                    z13 = a13;
                                    intent = intent2;
                                    notificationManager.notify(i15, notification);
                                    PushAutoTrackHelper.onNotify(notificationManager, i15, notification);
                                } else {
                                    String A = dVar.A();
                                    int intValue = xGPushNotificationBuilder.getSmallIcon().intValue();
                                    Integer color = xGPushNotificationBuilder.getColor();
                                    String currentChannelId = xGPushNotificationBuilder.getCurrentChannelId();
                                    String d12 = dVar.d();
                                    String notificationCategory = xGPushNotificationBuilder.getNotificationCategory();
                                    str2 = str;
                                    notification = notification2;
                                    z13 = a13;
                                    intent = intent2;
                                    try {
                                        Notification a14 = a(context, d12, currentChannelId, z15, A, intValue, color, notificationCategory);
                                        int i17 = -z15.hashCode();
                                        notificationManager.notify(i17, a14);
                                        PushAutoTrackHelper.onNotify(notificationManager, i17, a14);
                                        TLogger.i("MessageHelper", "show group notification " + z15);
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    notificationManager.notify(i15, notification);
                                    PushAutoTrackHelper.onNotify(notificationManager, i15, notification);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str2 = str;
                                notification = notification2;
                                z13 = a13;
                                intent = intent2;
                                TLogger.e("MessageHelper", "show group notification error: " + th.toString());
                                notificationManager.notify(i15, notification);
                                PushAutoTrackHelper.onNotify(notificationManager, i15, notification);
                                Intent intent5 = new Intent(com.tencent.android.tpush.common.Constants.ACTION_FEEDBACK);
                                intent5.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_ERROR_CODE, 0);
                                intent5.setPackage(context.getPackageName());
                                intent5.putExtras(intent);
                                intent5.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_TAG, 5);
                                intent5.putExtra(MessageKey.NOTIFACTION_ID, i15);
                                intent5.putExtra(str2, z13);
                                BroadcastAgent.sendBroadcast(context4, intent5);
                                return;
                            }
                        } else {
                            str2 = str;
                            Notification notification3 = notification2;
                            z13 = a13;
                            intent = intent2;
                            TLogger.i("MessageHelper", "call notifactionCallback:" + notification3);
                            notifactionCallback.handleNotify(new XGNotifaction(context4, i15, notification3, dVar));
                            TLogger.d("MessageHelper", "not appOnForeground ");
                        }
                        Intent intent52 = new Intent(com.tencent.android.tpush.common.Constants.ACTION_FEEDBACK);
                        intent52.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_ERROR_CODE, 0);
                        intent52.setPackage(context.getPackageName());
                        intent52.putExtras(intent);
                        intent52.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_TAG, 5);
                        intent52.putExtra(MessageKey.NOTIFACTION_ID, i15);
                        intent52.putExtra(str2, z13);
                        BroadcastAgent.sendBroadcast(context4, intent52);
                        return;
                    }
                } else {
                    TLogger.dd("MessageHelper", "drop huawei public message Notification");
                    return;
                }
            }
            str2 = str;
            z13 = a13;
            intent = intent2;
            Intent intent522 = new Intent(com.tencent.android.tpush.common.Constants.ACTION_FEEDBACK);
            intent522.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_ERROR_CODE, 0);
            intent522.setPackage(context.getPackageName());
            intent522.putExtras(intent);
            intent522.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_TAG, 5);
            intent522.putExtra(MessageKey.NOTIFACTION_ID, i15);
            intent522.putExtra(str2, z13);
            BroadcastAgent.sendBroadcast(context4, intent522);
            return;
        }
        TLogger.w("MessageHelper", "customLayout but title and content null");
    }

    private static boolean a(Context context, PushMessageManager pushMessageManager, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder, int i11, int i12) {
        Context context2 = context;
        XGPushNotificationBuilder xGPushNotificationBuilder2 = xGPushNotificationBuilder;
        int i13 = i11;
        int i14 = i12;
        RemoteViews a11 = a(context, pushMessageManager, dVar, xGPushNotificationBuilder);
        if (a11 != null) {
            xGPushNotificationBuilder2.setCustomLayoutType(dVar.D());
            xGPushNotificationBuilder2.setUseStdStyle(dVar.E());
            xGPushNotificationBuilder2.setContentView(a11);
            xGPushNotificationBuilder2.setbigContentView(a11);
            return true;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            int identifier = context.getResources().getIdentifier("xg_notification", TtmlNode.TAG_LAYOUT, context.getPackageName());
            if (identifier != 0) {
                TLogger.d("MessageHelper", "has xg_notification layout");
                int identifier2 = context.getResources().getIdentifier("xg_notification_icon", "id", context.getPackageName());
                int identifier3 = context.getResources().getIdentifier("xg_notification_style_title", "id", context.getPackageName());
                int identifier4 = context.getResources().getIdentifier("xg_notification_date", "id", context.getPackageName());
                int identifier5 = context.getResources().getIdentifier("xg_notification_style_content", "id", context.getPackageName());
                int identifier6 = context.getResources().getIdentifier("xg_notification_audio_play", "id", context.getPackageName());
                int identifier7 = context.getResources().getIdentifier("xg_notification_audio_stop", "id", context.getPackageName());
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), identifier);
                if (!(identifier2 == 0 || identifier3 == 0 || identifier5 == 0)) {
                    remoteViews.setTextViewText(identifier3, dVar.d());
                    remoteViews.setTextViewText(identifier5, dVar.e());
                    if (!TextUtils.isEmpty(dVar.r())) {
                        Bitmap a12 = a(dVar.r());
                        if (a12 == null) {
                            remoteViews.setImageViewResource(identifier2, context.getApplicationInfo().icon);
                        } else {
                            remoteViews.setImageViewBitmap(identifier2, a12);
                        }
                    } else {
                        remoteViews.setImageViewResource(identifier2, context.getApplicationInfo().icon);
                    }
                }
                if (identifier4 != 0) {
                    remoteViews.setTextViewText(identifier4, String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()))));
                }
                if (!(identifier6 == 0 || identifier7 == 0 || TextUtils.isEmpty(dVar.o()))) {
                    remoteViews.setViewVisibility(identifier6, 0);
                    remoteViews.setViewVisibility(identifier7, 0);
                    Intent intent = new Intent(context.getPackageName() + ".APP_PUSH_MEDIA.PLAY");
                    intent.putExtra("msgId", pushMessageManager.getMsgId());
                    intent.putExtra(MessageKey.MSG_AUDIO_URL, dVar.o());
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, context.getPackageName());
                    PushAutoTrackHelper.hookIntentGetBroadcast(context2, i13, intent, i14);
                    PendingIntent broadcast = PendingIntent.getBroadcast(context2, i13, intent, i14);
                    PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context2, i13, intent, i14);
                    remoteViews.setOnClickPendingIntent(identifier6, broadcast);
                    Intent intent2 = new Intent(context.getPackageName() + ".APP_PUSH_MEDIA.STOP");
                    intent2.putExtra("msgId", pushMessageManager.getMsgId());
                    intent2.putExtra(MessageKey.MSG_AUDIO_URL, dVar.o());
                    intent2.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, context.getPackageName());
                    PushAutoTrackHelper.hookIntentGetBroadcast(context2, i13, intent2, i14);
                    PendingIntent broadcast2 = PendingIntent.getBroadcast(context2, i13, intent2, i14);
                    PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast2, context2, i13, intent2, i14);
                    remoteViews.setOnClickPendingIntent(identifier7, broadcast2);
                }
                xGPushNotificationBuilder2.setContentView(remoteViews);
                return true;
            }
            TLogger.d("MessageHelper", "no xg_notification layout");
        }
        return false;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[Catch:{ all -> 0x0064, all -> 0x02f1 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099 A[Catch:{ all -> 0x0064, all -> 0x02f1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.widget.RemoteViews a(android.content.Context r19, com.tencent.android.tpush.message.PushMessageManager r20, com.tencent.android.tpush.message.d r21, com.tencent.android.tpush.XGPushNotificationBuilder r22) {
        /*
            r1 = r19
            java.lang.String r2 = "id"
            java.lang.String r3 = "MessageHelper"
            r4 = 0
            java.lang.String r5 = r19.getPackageName()     // Catch:{ all -> 0x02f1 }
            int r6 = r21.D()     // Catch:{ all -> 0x02f1 }
            if (r6 > 0) goto L_0x0017
            java.lang.String r0 = "no valid custom layout type"
            com.tencent.android.tpush.logging.TLogger.d(r3, r0)     // Catch:{ all -> 0x02f1 }
            return r4
        L_0x0017:
            java.lang.String r0 = r21.C()     // Catch:{ all -> 0x02f1 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02f1 }
            if (r7 == 0) goto L_0x0022
            return r4
        L_0x0022:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x02f1 }
            r7.<init>(r0)     // Catch:{ all -> 0x02f1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f1 }
            r0.<init>()     // Catch:{ all -> 0x02f1 }
            java.lang.String r8 = "custom layout param: "
            r0.append(r8)     // Catch:{ all -> 0x02f1 }
            java.lang.String r8 = r7.toString()     // Catch:{ all -> 0x02f1 }
            r0.append(r8)     // Catch:{ all -> 0x02f1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02f1 }
            com.tencent.android.tpush.logging.TLogger.i(r3, r0)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r0 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            java.lang.String r8 = "custom_notification_layout"
            java.lang.String r9 = "layout"
            int r8 = r0.getIdentifier(r8, r9, r5)     // Catch:{ all -> 0x02f1 }
            if (r8 != 0) goto L_0x0053
            java.lang.String r0 = "no custom_notification_layout"
            com.tencent.android.tpush.logging.TLogger.d(r3, r0)     // Catch:{ all -> 0x02f1 }
            return r4
        L_0x0053:
            java.lang.String r0 = "text_color"
            java.lang.String r9 = r7.optString(r0)     // Catch:{ all -> 0x02f1 }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x02f1 }
            if (r0 != 0) goto L_0x0086
            int r0 = android.graphics.Color.parseColor(r9)     // Catch:{ all -> 0x0064 }
            goto L_0x0087
        L_0x0064:
            r0 = move-exception
            r11 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f1 }
            r0.<init>()     // Catch:{ all -> 0x02f1 }
            java.lang.String r12 = "parse color String \""
            r0.append(r12)     // Catch:{ all -> 0x02f1 }
            r0.append(r9)     // Catch:{ all -> 0x02f1 }
            java.lang.String r9 = "\" error: "
            r0.append(r9)     // Catch:{ all -> 0x02f1 }
            java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x02f1 }
            r0.append(r9)     // Catch:{ all -> 0x02f1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02f1 }
            com.tencent.android.tpush.logging.TLogger.w(r3, r0)     // Catch:{ all -> 0x02f1 }
        L_0x0086:
            r0 = 0
        L_0x0087:
            android.widget.RemoteViews r9 = new android.widget.RemoteViews     // Catch:{ all -> 0x02f1 }
            r9.<init>(r5, r8)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r8 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            java.lang.String r11 = "custom_layout_bg"
            int r8 = r8.getIdentifier(r11, r2, r5)     // Catch:{ all -> 0x02f1 }
            if (r8 != 0) goto L_0x0099
            return r4
        L_0x0099:
            java.lang.String r11 = r21.d()     // Catch:{ all -> 0x02f1 }
            java.lang.String r12 = r21.e()     // Catch:{ all -> 0x02f1 }
            java.lang.String r13 = r21.n()     // Catch:{ all -> 0x02f1 }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x02f1 }
            if (r14 == 0) goto L_0x00ac
            return r4
        L_0x00ac:
            android.graphics.Bitmap r13 = a((java.lang.String) r13)     // Catch:{ all -> 0x02f1 }
            if (r13 != 0) goto L_0x00b8
            java.lang.String r0 = "custom layout load background failed"
            com.tencent.android.tpush.logging.TLogger.w(r3, r0)     // Catch:{ all -> 0x02f1 }
            return r4
        L_0x00b8:
            java.lang.String r14 = "elements"
            java.lang.String r15 = "setMaxHeight"
            java.lang.String r10 = "bg_url"
            r4 = 1
            if (r6 == r4) goto L_0x01fe
            r11 = 2
            if (r6 == r11) goto L_0x01ef
            r11 = 3
            if (r6 == r11) goto L_0x00c9
            r6 = 0
            return r6
        L_0x00c9:
            android.content.res.Resources r6 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            java.lang.String r11 = "custom_layout_top_right_button"
            int r6 = r6.getIdentifier(r11, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r11 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            java.lang.String r15 = "custom_layout_top_right_icon"
            int r11 = r11.getIdentifier(r15, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r15 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            java.lang.String r4 = "custom_layout_bottom_content"
            int r4 = r15.getIdentifier(r4, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r15 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            r17 = r8
            java.lang.String r8 = "custom_layout_bottom_timestamp"
            int r8 = r15.getIdentifier(r8, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r15 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            r18 = r13
            java.lang.String r13 = "custom_layout_main_board_3"
            int r2 = r15.getIdentifier(r13, r2, r5)     // Catch:{ all -> 0x02f1 }
            if (r6 == 0) goto L_0x01ed
            if (r11 == 0) goto L_0x01ed
            if (r4 == 0) goto L_0x01ed
            if (r8 == 0) goto L_0x01ed
            if (r2 != 0) goto L_0x010b
            goto L_0x01ed
        L_0x010b:
            boolean r5 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x02f1 }
            if (r5 == 0) goto L_0x0118
            java.lang.String r0 = "custom layout type 3 but null content"
            com.tencent.android.tpush.logging.TLogger.w(r3, r0)     // Catch:{ all -> 0x02f1 }
            r1 = 0
            return r1
        L_0x0118:
            org.json.JSONObject r5 = r7.optJSONObject(r14)     // Catch:{ all -> 0x02f1 }
            if (r5 == 0) goto L_0x01b7
            java.lang.String r7 = "top_right_button"
            org.json.JSONObject r5 = r5.optJSONObject(r7)     // Catch:{ all -> 0x02f1 }
            if (r5 == 0) goto L_0x01b7
            java.lang.String r7 = "text"
            java.lang.String r7 = r5.optString(r7)     // Catch:{ all -> 0x02f1 }
            java.lang.String r13 = "action"
            org.json.JSONObject r13 = r5.optJSONObject(r13)     // Catch:{ all -> 0x02f1 }
            boolean r14 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x02f1 }
            if (r14 != 0) goto L_0x01b2
            if (r13 != 0) goto L_0x013c
            goto L_0x01b2
        L_0x013c:
            com.tencent.android.tpush.message.d$a r14 = new com.tencent.android.tpush.message.d$a     // Catch:{ all -> 0x02f1 }
            r14.<init>()     // Catch:{ all -> 0x02f1 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x02f1 }
            r14.a(r13)     // Catch:{ all -> 0x02f1 }
            r13 = r20
            r15 = 0
            android.content.Intent r13 = a(r1, r14, r15, r13, r15)     // Catch:{ all -> 0x02f1 }
            if (r13 != 0) goto L_0x0157
            java.lang.String r1 = "unexpected action top right button intent null"
            com.tencent.android.tpush.logging.TLogger.d(r3, r1)     // Catch:{ all -> 0x02f1 }
            goto L_0x01b7
        L_0x0157:
            r15 = 0
            r9.setViewVisibility(r6, r15)     // Catch:{ all -> 0x02f1 }
            r9.setTextViewText(r6, r7)     // Catch:{ all -> 0x02f1 }
            if (r0 == 0) goto L_0x0163
            r9.setTextColor(r6, r0)     // Catch:{ all -> 0x02f1 }
        L_0x0163:
            java.lang.String r7 = "isCustomLayout"
            r15 = 1
            r13.putExtra(r7, r15)     // Catch:{ all -> 0x02f1 }
            java.lang.String r7 = "isButtonClickInCustomLayout"
            r13.putExtra(r7, r15)     // Catch:{ all -> 0x02f1 }
            r7 = 134217728(0x8000000, float:3.85186E-34)
            com.tencent.android.tpush.message.d$a$a r14 = r14.f69461c     // Catch:{ all -> 0x02f1 }
            if (r14 == 0) goto L_0x0179
            int r14 = r14.f69470b     // Catch:{ all -> 0x02f1 }
            if (r14 <= 0) goto L_0x0179
            r7 = r14
        L_0x0179:
            int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02f1 }
            r15 = 31
            if (r14 < r15) goto L_0x0182
            r14 = 33554432(0x2000000, float:9.403955E-38)
            r7 = r7 | r14
        L_0x0182:
            int r14 = r21.k()     // Catch:{ all -> 0x02f1 }
            r15 = 0
            r13.setAction(r15)     // Catch:{ all -> 0x02f1 }
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetActivity(r1, r14, r13, r7)     // Catch:{ all -> 0x02f1 }
            android.app.PendingIntent r15 = android.app.PendingIntent.getActivity(r1, r14, r13, r7)     // Catch:{ all -> 0x02f1 }
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetActivity(r15, r1, r14, r13, r7)     // Catch:{ all -> 0x02f1 }
            r9.setOnClickPendingIntent(r6, r15)     // Catch:{ all -> 0x02f1 }
            java.lang.String r1 = r5.optString(r10)     // Catch:{ all -> 0x02f1 }
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x02f1 }
            if (r5 != 0) goto L_0x01b7
            android.graphics.Bitmap r1 = a((java.lang.String) r1)     // Catch:{ all -> 0x02f1 }
            if (r1 == 0) goto L_0x01b7
            r5 = 0
            r9.setViewVisibility(r11, r5)     // Catch:{ all -> 0x02f1 }
            r9.setImageViewBitmap(r11, r1)     // Catch:{ all -> 0x02f1 }
            r9.setOnClickPendingIntent(r11, r15)     // Catch:{ all -> 0x02f1 }
            goto L_0x01b7
        L_0x01b2:
            java.lang.String r1 = "custom layout type 3 but null top right button info"
            com.tencent.android.tpush.logging.TLogger.d(r3, r1)     // Catch:{ all -> 0x02f1 }
        L_0x01b7:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x02f1 }
            java.lang.String r5 = "hh:mm aa"
            r1.<init>(r5)     // Catch:{ all -> 0x02f1 }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x02f1 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02f1 }
            r5.<init>(r6)     // Catch:{ all -> 0x02f1 }
            long r5 = r5.getTime()     // Catch:{ all -> 0x02f1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x02f1 }
            java.lang.String r1 = r1.format(r5)     // Catch:{ all -> 0x02f1 }
            r9.setTextViewText(r4, r12)     // Catch:{ all -> 0x02f1 }
            r9.setTextViewText(r8, r1)     // Catch:{ all -> 0x02f1 }
            if (r0 == 0) goto L_0x01e1
            r9.setTextColor(r4, r0)     // Catch:{ all -> 0x02f1 }
            r9.setTextColor(r8, r0)     // Catch:{ all -> 0x02f1 }
        L_0x01e1:
            r4 = r17
            r6 = r18
            r9.setImageViewBitmap(r4, r6)     // Catch:{ all -> 0x02f1 }
            r1 = 0
            r9.setViewVisibility(r2, r1)     // Catch:{ all -> 0x02f1 }
            return r9
        L_0x01ed:
            r1 = 0
            return r1
        L_0x01ef:
            r4 = r8
            r6 = r13
            r0 = 120(0x78, float:1.68E-43)
            int r0 = com.tencent.android.tpush.inappmessage.SizeUtil.dpToPx(r1, r0)     // Catch:{ all -> 0x02f1 }
            r9.setInt(r4, r15, r0)     // Catch:{ all -> 0x02f1 }
            r9.setImageViewBitmap(r4, r6)     // Catch:{ all -> 0x02f1 }
            return r9
        L_0x01fe:
            r4 = r8
            r6 = r13
            android.content.res.Resources r8 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            java.lang.String r13 = "custom_layout_title"
            int r8 = r8.getIdentifier(r13, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r13 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            r16 = r15
            java.lang.String r15 = "custom_layout_content"
            int r13 = r13.getIdentifier(r15, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r15 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            java.lang.String r1 = "custom_layout_icon_left"
            int r1 = r15.getIdentifier(r1, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r15 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            r17 = r4
            java.lang.String r4 = "custom_layout_icon_right"
            int r4 = r15.getIdentifier(r4, r2, r5)     // Catch:{ all -> 0x02f1 }
            android.content.res.Resources r15 = r19.getResources()     // Catch:{ all -> 0x02f1 }
            r18 = r6
            java.lang.String r6 = "custom_layout_main_board"
            int r2 = r15.getIdentifier(r6, r2, r5)     // Catch:{ all -> 0x02f1 }
            if (r8 == 0) goto L_0x02ef
            if (r13 == 0) goto L_0x02ef
            if (r1 == 0) goto L_0x02ef
            if (r4 == 0) goto L_0x02ef
            if (r2 != 0) goto L_0x0244
            goto L_0x02ef
        L_0x0244:
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x02f1 }
            if (r5 == 0) goto L_0x0257
            boolean r5 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x02f1 }
            if (r5 == 0) goto L_0x0257
            java.lang.String r0 = "custom layout type 1 but null title and content"
            com.tencent.android.tpush.logging.TLogger.w(r3, r0)     // Catch:{ all -> 0x02f1 }
            r1 = 0
            return r1
        L_0x0257:
            org.json.JSONObject r5 = r7.optJSONObject(r14)     // Catch:{ all -> 0x02f1 }
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x027c
            java.lang.String r7 = "left_icon"
            org.json.JSONObject r7 = r5.optJSONObject(r7)     // Catch:{ all -> 0x02f1 }
            if (r7 == 0) goto L_0x026c
            java.lang.String r7 = r7.optString(r10)     // Catch:{ all -> 0x02f1 }
            goto L_0x026d
        L_0x026c:
            r7 = r6
        L_0x026d:
            java.lang.String r11 = "right_icon"
            org.json.JSONObject r5 = r5.optJSONObject(r11)     // Catch:{ all -> 0x02f1 }
            if (r5 == 0) goto L_0x0279
            java.lang.String r6 = r5.optString(r10)     // Catch:{ all -> 0x02f1 }
        L_0x0279:
            r5 = r6
            r6 = r7
            goto L_0x027d
        L_0x027c:
            r5 = r6
        L_0x027d:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x02f1 }
            if (r7 == 0) goto L_0x0285
            r7 = 0
            return r7
        L_0x0285:
            r7 = 0
            android.graphics.Bitmap r6 = a((java.lang.String) r6)     // Catch:{ all -> 0x02f1 }
            if (r6 != 0) goto L_0x0292
            java.lang.String r0 = "custom layout load left icon failed"
            com.tencent.android.tpush.logging.TLogger.w(r3, r0)     // Catch:{ all -> 0x02f1 }
            return r7
        L_0x0292:
            r9.setImageViewBitmap(r1, r6)     // Catch:{ all -> 0x02f1 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x02f1 }
            if (r1 != 0) goto L_0x02a4
            android.graphics.Bitmap r1 = a((java.lang.String) r5)     // Catch:{ all -> 0x02f1 }
            if (r1 == 0) goto L_0x02a4
            r9.setImageViewBitmap(r4, r1)     // Catch:{ all -> 0x02f1 }
        L_0x02a4:
            java.lang.String r1 = r21.d()     // Catch:{ all -> 0x02f1 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x02f1 }
            r4 = 8
            if (r1 == 0) goto L_0x02b3
            r9.setViewVisibility(r8, r4)     // Catch:{ all -> 0x02f1 }
        L_0x02b3:
            java.lang.String r1 = r21.e()     // Catch:{ all -> 0x02f1 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x02f1 }
            if (r1 == 0) goto L_0x02c0
            r9.setViewVisibility(r13, r4)     // Catch:{ all -> 0x02f1 }
        L_0x02c0:
            java.lang.String r1 = r21.d()     // Catch:{ all -> 0x02f1 }
            r9.setTextViewText(r8, r1)     // Catch:{ all -> 0x02f1 }
            java.lang.String r1 = r21.e()     // Catch:{ all -> 0x02f1 }
            r9.setTextViewText(r13, r1)     // Catch:{ all -> 0x02f1 }
            if (r0 == 0) goto L_0x02d6
            r9.setTextColor(r8, r0)     // Catch:{ all -> 0x02f1 }
            r9.setTextColor(r13, r0)     // Catch:{ all -> 0x02f1 }
        L_0x02d6:
            r0 = r17
            r1 = r18
            r9.setImageViewBitmap(r0, r1)     // Catch:{ all -> 0x02f1 }
            r1 = 80
            r4 = r19
            int r1 = com.tencent.android.tpush.inappmessage.SizeUtil.dpToPx(r4, r1)     // Catch:{ all -> 0x02f1 }
            r4 = r16
            r9.setInt(r0, r4, r1)     // Catch:{ all -> 0x02f1 }
            r1 = 0
            r9.setViewVisibility(r2, r1)     // Catch:{ all -> 0x02f1 }
            return r9
        L_0x02ef:
            r1 = 0
            return r1
        L_0x02f1:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "setCustomRemoteViews error: "
            r1.append(r2)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.tencent.android.tpush.logging.TLogger.w(r3, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.b.a(android.content.Context, com.tencent.android.tpush.message.PushMessageManager, com.tencent.android.tpush.message.d, com.tencent.android.tpush.XGPushNotificationBuilder):android.widget.RemoteViews");
    }

    private static void a(Context context, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        Bitmap bitmap;
        if (dVar.m() > 0) {
            xGPushNotificationBuilder.setIcon(Integer.valueOf(dVar.m()));
        }
        String n11 = dVar.n();
        if (n11 != null && !TextUtils.isEmpty(n11)) {
            if (!n11.equals(dVar.r()) || (bitmap = f69423d) == null) {
                bitmap = a(n11);
            }
            f69423d = null;
            if (bitmap != null) {
                xGPushNotificationBuilder.setRichIcon(bitmap);
            }
        }
        if (xGPushNotificationBuilder.getSmallIcon() == null && xGPushNotificationBuilder.getLargeIcon() == null && xGPushNotificationBuilder.getIcon() == null) {
            int identifier = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
            if (identifier > 0) {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier));
            } else {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
            }
            xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
        }
        xGPushNotificationBuilder.setTitle(dVar.d());
        xGPushNotificationBuilder.setTickerText(dVar.e());
        if (XGPushConfig.isEnableNotificationSound(context)) {
            String v11 = dVar.v();
            if (!TextUtils.isEmpty(v11)) {
                xGPushNotificationBuilder.setChannelId(v11);
            }
            if (!TextUtils.isEmpty(dVar.w())) {
                xGPushNotificationBuilder.setChannelName(dVar.w());
            }
        }
        if (!TextUtils.isEmpty(dVar.z())) {
            xGPushNotificationBuilder.setThread_id(dVar.z());
        }
    }

    private static Notification a(Context context, String str, String str2, String str3, String str4, int i11, Integer num, String str5) {
        NotificationCompat.e eVar = new NotificationCompat.e(context);
        eVar.H(str3).I(true).r(true);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationCompat.e.class.getMethod("setChannelId", new Class[]{String.class}).invoke(eVar, new Object[]{str2});
            } catch (Throwable th2) {
                TLogger.e("MessageHelper", "NotificationGroup setChannelId error", th2);
            }
        }
        if (i11 > 0) {
            eVar.X(i11);
        } else {
            eVar.X(context.getApplicationInfo().icon);
        }
        if (num != null) {
            eVar.x(num.intValue());
        }
        if (!TextUtils.isEmpty(str4)) {
            eVar.c0(new NotificationCompat.BigTextStyle().A(str4));
        }
        if (ChannelUtils.isBrandBlackShark()) {
            if (!TextUtils.isEmpty(str)) {
                eVar.C(str);
            } else {
                eVar.C(" ");
            }
        }
        TLogger.d("MessageHelper", "groupNotifyBuilder category:" + str5);
        if (str5 != null && !TextUtils.isEmpty(str5.trim())) {
            eVar.u(str5);
        }
        return eVar.g();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e6 A[SYNTHETIC, Splitter:B:54:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00eb A[Catch:{ IOException -> 0x00f4 }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f0 A[Catch:{ IOException -> 0x00f4 }, DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(java.lang.String r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "loadRemoteImage "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "MessageHelper"
            com.tencent.android.tpush.logging.TLogger.d(r2, r0)
            r0 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x00c2 }
            r3.<init>(r10)     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = r3.getProtocol()     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = "https"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00c2 }
            if (r4 == 0) goto L_0x004a
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ all -> 0x00c2 }
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ all -> 0x00c2 }
            org.apache.http.conn.ssl.X509HostnameVerifier r4 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ all -> 0x00bf }
            r3.setHostnameVerifier(r4)     // Catch:{ all -> 0x00bf }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00bf }
            r5 = 20
            if (r4 >= r5) goto L_0x0050
            com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory r4 = new com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory     // Catch:{ all -> 0x00bf }
            javax.net.ssl.SSLSocketFactory r5 = r3.getSSLSocketFactory()     // Catch:{ all -> 0x00bf }
            r4.<init>(r5)     // Catch:{ all -> 0x00bf }
            r3.setSSLSocketFactory(r4)     // Catch:{ all -> 0x00bf }
            goto L_0x0050
        L_0x004a:
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ all -> 0x00c2 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ all -> 0x00c2 }
        L_0x0050:
            r4 = 20000(0x4e20, float:2.8026E-41)
            r3.setConnectTimeout(r4)     // Catch:{ all -> 0x00bf }
            r3.setReadTimeout(r4)     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "charset"
            java.lang.String r5 = "UTF-8"
            r3.setRequestProperty(r4, r5)     // Catch:{ all -> 0x00bf }
            r4 = 1
            r3.setDoInput(r4)     // Catch:{ all -> 0x00bf }
            r4 = 0
            r3.setUseCaches(r4)     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = "Connection"
            java.lang.String r6 = "Keep-Alive"
            r3.setRequestProperty(r5, r6)     // Catch:{ all -> 0x00bf }
            int r5 = r3.getResponseCode()     // Catch:{ all -> 0x00bf }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 == r6) goto L_0x007f
            r3.disconnect()     // Catch:{ IOException -> 0x007e }
        L_0x007e:
            return r0
        L_0x007f:
            java.io.InputStream r5 = r3.getInputStream()     // Catch:{ all -> 0x00bf }
            if (r5 == 0) goto L_0x00b6
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00b3 }
            r6.<init>()     // Catch:{ all -> 0x00b3 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x00b1 }
        L_0x008e:
            int r8 = r5.read(r7)     // Catch:{ all -> 0x00b1 }
            r9 = -1
            if (r8 == r9) goto L_0x0099
            r6.write(r7, r4, r8)     // Catch:{ all -> 0x00b1 }
            goto L_0x008e
        L_0x0099:
            byte[] r7 = r6.toByteArray()     // Catch:{ all -> 0x00b1 }
            byte[] r8 = r6.toByteArray()     // Catch:{ all -> 0x00b1 }
            int r8 = r8.length     // Catch:{ all -> 0x00b1 }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeByteArray(r7, r4, r8)     // Catch:{ all -> 0x00b1 }
            r5.close()     // Catch:{ IOException -> 0x00b0 }
            r6.close()     // Catch:{ IOException -> 0x00b0 }
            r3.disconnect()     // Catch:{ IOException -> 0x00b0 }
            return r10
        L_0x00b0:
            return r0
        L_0x00b1:
            r4 = move-exception
            goto L_0x00c6
        L_0x00b3:
            r4 = move-exception
            r6 = r0
            goto L_0x00c6
        L_0x00b6:
            if (r5 == 0) goto L_0x00bb
            r5.close()     // Catch:{ IOException -> 0x00be }
        L_0x00bb:
            r3.disconnect()     // Catch:{ IOException -> 0x00be }
        L_0x00be:
            return r0
        L_0x00bf:
            r4 = move-exception
            r5 = r0
            goto L_0x00c5
        L_0x00c2:
            r4 = move-exception
            r3 = r0
            r5 = r3
        L_0x00c5:
            r6 = r5
        L_0x00c6:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r7.<init>()     // Catch:{ all -> 0x00f5 }
            r7.append(r1)     // Catch:{ all -> 0x00f5 }
            r7.append(r10)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = " error: "
            r7.append(r10)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x00f5 }
            r7.append(r10)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = r7.toString()     // Catch:{ all -> 0x00f5 }
            com.tencent.android.tpush.logging.TLogger.w(r2, r10)     // Catch:{ all -> 0x00f5 }
            if (r5 == 0) goto L_0x00e9
            r5.close()     // Catch:{ IOException -> 0x00f4 }
        L_0x00e9:
            if (r6 == 0) goto L_0x00ee
            r6.close()     // Catch:{ IOException -> 0x00f4 }
        L_0x00ee:
            if (r3 == 0) goto L_0x00f4
            r3.disconnect()     // Catch:{ IOException -> 0x00f4 }
        L_0x00f4:
            return r0
        L_0x00f5:
            r10 = move-exception
            if (r5 == 0) goto L_0x00fb
            r5.close()     // Catch:{ IOException -> 0x0106 }
        L_0x00fb:
            if (r6 == 0) goto L_0x0100
            r6.close()     // Catch:{ IOException -> 0x0106 }
        L_0x0100:
            if (r3 == 0) goto L_0x0107
            r3.disconnect()     // Catch:{ IOException -> 0x0106 }
            goto L_0x0107
        L_0x0106:
            return r0
        L_0x0107:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.b.a(java.lang.String):android.graphics.Bitmap");
    }

    public static void a(Context context, PushMessageManager pushMessageManager) {
        if (pushMessageManager.getMessageHolder() instanceof d) {
            TLogger.ii("MessageHelper", "Action -> showNotification " + pushMessageManager.getContent());
            d dVar = (d) pushMessageManager.getMessageHolder();
            if (dVar == null || dVar.l() == null) {
                TLogger.e("MessageHelper", "showNotification holder == null || holder.getAction() == null");
                return;
            }
            try {
                Context applicationContext = context.getApplicationContext();
                if (!a.a(applicationContext) || pushMessageManager.getAppPkgName() == null || pushMessageManager.getAppPkgName().equals(applicationContext.getPackageName())) {
                    a(applicationContext, (Context) null, pushMessageManager);
                    return;
                }
                TLogger.ii("MessageHelper", "receive otehr app notification: " + pushMessageManager.getAppPkgName());
                a(applicationContext.createPackageContext(pushMessageManager.getAppPkgName(), 3), applicationContext, pushMessageManager);
            } catch (Throwable th2) {
                TLogger.ww("MessageHelper", "showNotification Throwable:", th2);
            }
        }
    }
}
