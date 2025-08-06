package com.tencent.android.tpush;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.aaid.HmsInstanceId;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.c;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.b;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.e.b.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.android.tpush.service.util.g;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.LoggerInterface;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
public class XGPushConfig {
    public static final String TPUSH_ACCESS_CHANNAL = "XG_V4_CHANNEL_ID";
    public static final String TPUSH_ACCESS_ID = "XG_V2_ACCESS_ID";
    public static final String TPUSH_ACCESS_KEY = "XG_V2_ACCESS_KEY";
    public static final String TPUSH_IS_FOREIGINPUSH = "TPUSH_IS_FOREIGINPUSH";
    public static boolean _isHuaweiDebug = false;

    /* renamed from: a  reason: collision with root package name */
    private static String f67854a = "";
    public static boolean autoFilterHuaweiPublicNotification = false;
    public static boolean autoInit = true;

    /* renamed from: b  reason: collision with root package name */
    private static String f67855b = "";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f67856c = true;

    /* renamed from: d  reason: collision with root package name */
    private static String f67857d = "";

    /* renamed from: e  reason: collision with root package name */
    private static long f67858e = -1;
    public static boolean enableActivityWindowSecFlag = false;
    public static Boolean enableApplist = null;
    public static boolean enableDebug = false;
    public static Boolean enableLocation;
    public static Boolean enableNotification;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f67859f;
    public static Boolean fcmIsSuccess;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f67860g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f67861h;

    /* renamed from: i  reason: collision with root package name */
    private static Boolean f67862i;
    public static Boolean isUsedFcmPush;
    public static Boolean isUsedOtherPush;

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f67863j;

    /* renamed from: k  reason: collision with root package name */
    private static Boolean f67864k;

    /* renamed from: l  reason: collision with root package name */
    private static SharedPreferences f67865l;
    public static String notificationChannelID;
    public static String notificationChannelName;
    public static Boolean useFcmFirst;

    public static class Build {
        /* access modifiers changed from: private */
        public Context context;

        public Build(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Build enableDebug(boolean z11) {
            XGPushConfig.enableDebug(this.context, z11);
            return this;
        }

        public Build enableFcmPush(boolean z11) {
            XGPushConfig.enableOtherPush(this.context, z11);
            return this;
        }

        public Build enableOtherPush(boolean z11) {
            XGPushConfig.enableOtherPush(this.context, z11);
            return this;
        }

        public Build setHuaweiDebug(boolean z11) {
            XGPushConfig.setHuaweiDebug(z11);
            return this;
        }

        public Build setLogLevel(final int i11) {
            TBaseLogger.setDebugLevel(i11);
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    try {
                        Context access$000 = Build.this.context;
                        PushPreferences.putInt(access$000, "com.tencent.android.tpush.log_level," + Build.this.context.getPackageName(), i11);
                    } catch (Throwable th2) {
                        TLogger.w("XGPushConfig", "XGPushConfig.Build.setLogLevel sharedPf put error " + th2.toString());
                    }
                }
            });
            return this;
        }

        public Build setMiPushAppId(String str) {
            XGPushConfig.setMiPushAppId(this.context, str);
            return this;
        }

        public Build setMiPushAppKey(String str) {
            XGPushConfig.setMiPushAppKey(this.context, str);
            return this;
        }

        public Build setMzPushAppId(String str) {
            XGPushConfig.setMzPushAppId(this.context, str);
            return this;
        }

        public Build setMzPushAppKey(String str) {
            XGPushConfig.setMzPushAppKey(this.context, str);
            return this;
        }

        public Build setOppoPushAppId(String str) {
            XGPushConfig.setOppoPushAppId(this.context, str);
            return this;
        }

        public Build setOppoPushAppKey(String str) {
            XGPushConfig.setOppoPushAppKey(this.context, str);
            return this;
        }
    }

    private static void a(Context context, boolean z11) {
        if (context != null) {
            MqttConfig.enableAlarmManager(context, z11);
            if (!z11) {
                g.f(context);
            }
        }
    }

    public static void changeHuaweiBadgeNum(Context context, int i11) {
        c.a(context, i11);
    }

    public static void clearAllCache(final Context context) {
        TLogger.dd("XGPushConfig", "clear All tpns Cache");
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                try {
                    TLogger.d("XGPushConfig", "excute clear All tpns Cache");
                    j.d(context);
                    CacheHelper.set(context, a.b().set(""));
                    GuidInfoManager.clearGuidInfo(context);
                    context.getSharedPreferences("device_id.vip", 0).edit().clear().commit();
                    context.getSharedPreferences(".xg.vip.settings.xml", 0).edit().clear().commit();
                    context.getSharedPreferences("tpush.vip.shareprefs", 0).edit().clear().commit();
                    context.getSharedPreferences("tpush.vip.shareprefs.sub", 0).edit().clear().commit();
                    context.getSharedPreferences("tpush.vip.service.shareprefs", 0).edit().clear().commit();
                    context.getSharedPreferences(Constants.APP_PREF_NAME, 0).edit().clear().commit();
                    TLogger.d("XGPushConfig", "excute clear All tpns Cache success");
                } catch (Throwable th2) {
                    TLogger.w("XGPushConfig", "XGPushConfig clearAllCache error " + th2);
                }
            }
        });
    }

    public static void enableAutoStart(Context context, boolean z11) {
        if (context != null) {
            TLogger.i("XGPushConfig", "enableAutoStart: " + z11);
            a(context, z11);
        }
    }

    public static void enableDebug(final Context context, final boolean z11) {
        if (context != null) {
            enableDebug = z11;
            CommonWorkingThread.getInstance().execute(new TTask() {
                @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
                public void TRun() {
                    try {
                        TLogger.enableDebug(context, z11);
                        Context context = context;
                        PushPreferences.putInt(context, "com.tencent.android.tpush.debug," + context.getPackageName(), z11 ? 1 : 0);
                        Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4");
                        intent.putExtra("debugMode", z11);
                        BroadcastAgent.sendBroadcast(context, intent);
                    } catch (Throwable th2) {
                        TLogger.e("XGPushConfig", "enableDebug ", th2);
                    }
                }
            });
        }
    }

    public static void enableFcmPush(Context context, boolean z11) {
        if (context != null) {
            Boolean bool = isUsedFcmPush;
            if (bool == null || bool.booleanValue() != z11) {
                isUsedFcmPush = Boolean.valueOf(z11);
                CacheHelper.set(context, a.d().set(Integer.valueOf(z11 ? 1 : 0)));
                setNotTryFcm(context, z11);
            }
        }
    }

    public static void enableHttpAccountOperate(Context context, boolean z11) {
        if (context != null) {
            Boolean bool = f67860g;
            if (bool == null || bool.booleanValue() != z11) {
                f67860g = Boolean.valueOf(z11);
                CacheHelper.set(context, a.c(getAccessId(context) + "").set(Boolean.valueOf(z11)));
            }
        }
    }

    public static void enableHuaweiV3Update(Context context, boolean z11) {
        if (!z11 || context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            TLogger.i("XGPushConfig", "enableHuaweiV3Update context not instanceof Activity, would not update");
        } else if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            Class<HmsInstanceId> cls = HmsInstanceId.class;
            try {
                String str = HmsInstanceId.TAG;
                cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            } catch (Throwable th2) {
                TLogger.e("XGPushConfig", "enableHuaweiV3Update error, not find Hms V3 Sdk", th2);
            }
        } else {
            TLogger.i("XGPushConfig", "enableHuaweiV3Update not Huawei device");
        }
    }

    public static void enableNotificationSound(Context context, boolean z11, String str, String str2) {
        if (context != null) {
            Boolean bool = f67862i;
            if (bool == null || bool.booleanValue() != z11) {
                f67862i = Boolean.valueOf(z11);
                CacheHelper.set(context, a.i().set(Boolean.valueOf(z11)));
                if (z11) {
                    TLogger.i("XGPushConfig", "enableNotificationSound true");
                    setNotificationChannelID(context, (String) null);
                    setNotificationChannelName(context, (String) null);
                } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    TLogger.i("XGPushConfig", "enableNotificationSound false should assign a pair of notification channelId and channelName.");
                } else {
                    TLogger.i("XGPushConfig", "enableNotificationSound false with channelId: " + str + " and channelName: " + str2);
                    XGPushManager.createNotificationChannel(context, str, str2, true, true, false, (Uri) null);
                    setNotificationChannelID(context, str);
                    setNotificationChannelName(context, str2);
                }
            }
        }
    }

    public static void enableOppoNotification(Context context, boolean z11) {
        d.a(context, z11);
    }

    public static void enableOtherPush(Context context, boolean z11) {
        if (context != null) {
            Boolean bool = isUsedOtherPush;
            if (bool == null || bool.booleanValue() != z11) {
                isUsedOtherPush = Boolean.valueOf(z11);
                CacheHelper.set(context, a.c().set(Integer.valueOf(z11 ? 1 : 0)));
                enableFcmPush(context, z11);
            }
        }
    }

    public static void enablePullUpOtherApp(Context context, boolean z11) {
        if (context == null) {
            TLogger.ww("XGPushConfig", "context is null");
            return;
        }
        Boolean bool = f67859f;
        if (bool == null || z11 != bool.booleanValue()) {
            f67859f = Boolean.valueOf(z11);
            TLogger.d("XGPushConfig", "action - enablePullUpOtherApp:" + z11);
            PushPreferences.putBoolean(context, Constants.ENABLE_PULL_UP_OTHER_APP, z11);
        }
    }

    public static void enableShowInMsg(Context context, boolean z11) {
        if (context != null) {
            Boolean bool = f67863j;
            if (bool == null || bool.booleanValue() != z11) {
                f67863j = Boolean.valueOf(z11);
                CacheHelper.set(context, a.g().set(Boolean.valueOf(z11)));
            }
        }
    }

    public static void enableTpnsChannel(Context context, boolean z11) {
        if (context != null) {
            Boolean bool = f67861h;
            if (bool == null || bool.booleanValue() != z11) {
                f67861h = Boolean.valueOf(z11);
                CacheHelper.set(context, a.h().set(Boolean.valueOf(z11)));
            }
        }
    }

    public static synchronized long getAccessId(Context context) {
        long accessId;
        synchronized (XGPushConfig.class) {
            accessId = XGApiConfig.getAccessId(context);
        }
        return accessId;
    }

    public static synchronized String getAccessKey(Context context) {
        String accessKey;
        synchronized (XGPushConfig.class) {
            accessKey = XGApiConfig.getAccessKey(context);
        }
        return accessKey;
    }

    public static List<Long> getAccessidList(Context context) {
        ArrayList arrayList = new ArrayList(2);
        if (context == null) {
            return arrayList;
        }
        long accessId = getAccessId(context);
        if (accessId > 0) {
            arrayList.add(Long.valueOf(accessId));
        }
        long qQAccessId = XGPush4Msdk.getQQAccessId(context);
        if (qQAccessId > 0) {
            arrayList.add(Long.valueOf(qQAccessId));
        }
        Object metaData = CommonHelper.getMetaData(context, TPUSH_ACCESS_ID, (Object) null);
        if (metaData != null) {
            try {
                long longValue = Long.valueOf(metaData.toString()).longValue();
                if (!arrayList.contains(Long.valueOf(longValue))) {
                    arrayList.add(Long.valueOf(longValue));
                }
            } catch (Throwable th2) {
                TLogger.w("XGPushConfig", "get accessId from getMetaData failed: ", th2);
            }
        }
        return arrayList;
    }

    public static synchronized long getChannelId(Context context) {
        Object metaData;
        synchronized (XGPushConfig.class) {
            if (context == null) {
                long j11 = f67858e;
                return j11;
            }
            long j12 = f67858e;
            if (j12 != -1) {
                return j12;
            }
            if (!Security.checkTpnsSecurityLibSo(context)) {
                long j13 = f67858e;
                return j13;
            }
            if (f67858e == -1 && (metaData = CommonHelper.getMetaData(context, TPUSH_ACCESS_CHANNAL, (Object) null)) != null) {
                try {
                    f67858e = Long.valueOf(metaData.toString()).longValue();
                } catch (Throwable th2) {
                    TLogger.w("XGPushConfig", "get channelId from getMetaData failed: ", th2);
                    f67858e = -1;
                }
            }
            if (f67858e == -1) {
                TLogger.d("XGPushConfig", "channelId is not empty");
            }
            long j14 = f67858e;
            return j14;
        }
    }

    public static String getFacilityImei(Context context) {
        return f67857d;
    }

    public static String getGameServer(Context context) {
        return f67855b;
    }

    public static String getInstallChannel(Context context) {
        return f67854a;
    }

    public static String getNotificationChannelID(Context context) {
        if (context == null) {
            return null;
        }
        String str = notificationChannelID;
        if (str != null && !TextUtils.isEmpty(str)) {
            return notificationChannelID;
        }
        String string = PushPreferences.getString(context, context.getPackageName() + ".notification.channelID", "");
        notificationChannelID = string;
        return string;
    }

    public static String getNotificationChannelName(Context context) {
        if (context == null) {
            return null;
        }
        String str = notificationChannelName;
        if (str != null && !TextUtils.isEmpty(str)) {
            return notificationChannelName;
        }
        String string = PushPreferences.getString(context, context.getPackageName() + ".notification.channelName", "");
        notificationChannelName = string;
        return string;
    }

    public static String getOtherPushErrCode(Context context) {
        if (context == null) {
            return "errCode : -102 , errMsg : context == null";
        }
        try {
            Boolean valueOf = Boolean.valueOf(isUsedOtherPush(context));
            isUsedOtherPush = valueOf;
            if (!valueOf.booleanValue()) {
                return "errCode : -101 , errMsg : Manufacturer channel is not opened";
            }
            return SharePrefsUtil.getString(context, Constants.OTHER_PUSH_ERROR_CODE, "errCode : -100 , errMsg : unknown");
        } catch (Throwable th2) {
            TLogger.dd("XGPushConfig", "getOtherPushErrCode error: " + th2.getMessage());
            return "";
        }
    }

    public static String getOtherPushToken(Context context) {
        try {
            return d.a(context).f();
        } catch (Throwable th2) {
            TLogger.e("XGPushConfig", "getOtherPushToken", th2);
            return null;
        }
    }

    public static String getOtherPushType(Context context) {
        try {
            return d.a(context).k();
        } catch (Throwable th2) {
            TLogger.e("XGPushConfig", "getOtherPushToken", th2);
            return null;
        }
    }

    public static boolean getReportDebugMode(Context context) {
        if (PushPreferences.getInt(context, context.getPackageName() + ".report.mode", 0) != 0) {
            return true;
        }
        return false;
    }

    public static XGServerInfo getServerIpList(Context context) {
        if (context != null) {
            return new XGServerInfo(PushPreferences.getString(context, "com.tencent.android.xg.vip.action.custom.iplist.local", (String) null));
        }
        return null;
    }

    public static boolean getStatAutoPage(Context context) {
        return f67856c;
    }

    public static String getToken(Context context) {
        if (context != null) {
            return CacheManager.getToken(context);
        }
        TLogger.e("XGPushConfig", "null context");
        return null;
    }

    public static Build init(Context context) {
        if (context != null) {
            return new Build(context);
        }
        TLogger.ee("XGPushConfig", "context is null");
        return null;
    }

    public static boolean isEnableDebug(Context context) {
        if (PushPreferences.getInt(context, "com.tencent.android.tpush.debug," + context.getPackageName(), 0) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isEnableNotificationSound(Context context) {
        if (context == null) {
            return true;
        }
        if (f67862i == null) {
            f67862i = (Boolean) CacheHelper.get(context, a.i());
        }
        if (!f67862i.booleanValue()) {
            TLogger.i("XGPushConfig", "isEnableNotificationSound false, ignore channelId or ring config from backend");
        }
        return f67862i.booleanValue();
    }

    public static boolean isEnableShowInMsg(Context context) {
        if (context == null) {
            return false;
        }
        if (f67863j == null) {
            f67863j = (Boolean) CacheHelper.get(context, a.g());
        }
        return f67863j.booleanValue();
    }

    public static boolean isForeiginPush(Context context) {
        if (f67864k == null) {
            try {
                Object metaData = CommonHelper.getMetaData(context, TPUSH_IS_FOREIGINPUSH, (Object) null);
                if (metaData == null) {
                    Boolean bool = Boolean.FALSE;
                    f67864k = bool;
                    return bool.booleanValue();
                } else if ("true".equals(metaData.toString())) {
                    f67864k = Boolean.TRUE;
                } else {
                    f67864k = Boolean.FALSE;
                }
            } catch (Throwable unused) {
                f67864k = Boolean.FALSE;
            }
        }
        return f67864k.booleanValue();
    }

    public static boolean isHuaweiDebug() {
        return _isHuaweiDebug;
    }

    public static boolean isLocationEnable(Context context) {
        if (enableLocation == null) {
            boolean z11 = true;
            if (PushPreferences.getInt(context, "com.tencent.android.tpush.enable_location," + context.getPackageName(), 1) == 0) {
                z11 = false;
            }
            enableLocation = Boolean.valueOf(z11);
        }
        return enableLocation.booleanValue();
    }

    public static boolean isNotTryFcm(Context context) {
        boolean z11 = false;
        if (context == null) {
            return false;
        }
        if (fcmIsSuccess == null) {
            if (((Integer) CacheHelper.get(context, a.e())).intValue() != 0) {
                z11 = true;
            }
            fcmIsSuccess = Boolean.valueOf(z11);
        }
        return fcmIsSuccess.booleanValue();
    }

    public static boolean isNotificationShowEnable(Context context) {
        if (context != null) {
            try {
                if (f67865l == null) {
                    f67865l = context.getSharedPreferences(Constants.APP_PREF_NAME, 0);
                }
                return f67865l.getBoolean(Util.getKey(Constants.SETTINGS_ENABLE_SHOW_NOTIFICATION), true);
            } catch (Throwable th2) {
                TLogger.e("XGPushConfig", "isNotificationShowEnable", th2);
            }
        }
        return true;
    }

    public static boolean isReportApplistEnable(Context context) {
        if (enableApplist == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("com.tencent.android.tpush.enable_applist,");
            sb2.append(context.getPackageName());
            enableApplist = Boolean.valueOf(PushPreferences.getInt(context, sb2.toString(), 1) != 0);
        }
        if (com.tencent.android.tpush.service.a.a.a(context).F == -1) {
            return enableApplist.booleanValue();
        }
        return com.tencent.android.tpush.service.a.a.a(context).F == 1;
    }

    public static boolean isReportNotificationStatusEnable(Context context) {
        if (enableNotification == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("com.tencent.android.tpush.enable_NOTIICATION,");
            sb2.append(context.getPackageName());
            enableNotification = Boolean.valueOf(PushPreferences.getInt(context, sb2.toString(), 1) != 0);
        }
        if (com.tencent.android.tpush.service.a.a.a(context).G == -1) {
            return enableNotification.booleanValue();
        }
        return com.tencent.android.tpush.service.a.a.a(context).G == 1;
    }

    public static boolean isUseFcmFirst(Context context) {
        boolean z11 = false;
        if (context == null) {
            return false;
        }
        if (useFcmFirst == null) {
            if (((Integer) CacheHelper.get(context, a.f())).intValue() != 0) {
                z11 = true;
            }
            useFcmFirst = Boolean.valueOf(z11);
        }
        return useFcmFirst.booleanValue();
    }

    public static boolean isUsedFcmPush(Context context) {
        boolean z11 = false;
        if (context == null) {
            return false;
        }
        if (isUsedFcmPush == null) {
            if (((Integer) CacheHelper.get(context, a.d())).intValue() != 0) {
                z11 = true;
            }
            isUsedFcmPush = Boolean.valueOf(z11);
        }
        return isUsedFcmPush.booleanValue();
    }

    public static boolean isUsedHttpAccountOperate(Context context) {
        boolean z11 = false;
        if (context == null) {
            return false;
        }
        if (!isUsedTpnsChannel(context)) {
            f67860g = Boolean.TRUE;
        }
        if (f67860g == null) {
            int useHttp = CloudManager.getInstance(context).useHttp();
            TLogger.d("XGPushConfig", "accountManagerByHttp from cloud: " + useHttp);
            if (useHttp == 0) {
                f67860g = (Boolean) CacheHelper.get(context, a.c(getAccessId(context) + ""));
            } else {
                if (useHttp == 1) {
                    z11 = true;
                }
                f67860g = Boolean.valueOf(z11);
            }
        }
        TLogger.d("XGPushConfig", "isUsedHttpAccountOperate: " + f67860g);
        return f67860g.booleanValue();
    }

    public static boolean isUsedOtherPush(Context context) {
        boolean z11 = false;
        if (context == null) {
            return false;
        }
        if (isUsedOtherPush == null) {
            if (((Integer) CacheHelper.get(context, a.c())).intValue() != 0) {
                z11 = true;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            isUsedOtherPush = valueOf;
            if (!valueOf.booleanValue()) {
                isUsedOtherPush = Boolean.valueOf(d.a(context).b());
            }
            if (!isUsedOtherPush.booleanValue()) {
                isUsedOtherPush = Boolean.valueOf(j.o(context));
            }
        }
        TLogger.v("XGPushConfig", "isUsedOtherPush:" + isUsedOtherPush);
        return isUsedOtherPush.booleanValue();
    }

    public static boolean isUsedTpnsChannel(Context context) {
        boolean z11 = false;
        if (context == null) {
            return false;
        }
        if (f67861h == null) {
            int useTpnsChannel = CloudManager.getInstance(context).useTpnsChannel();
            TLogger.d("XGPushConfig", "useTpnsChannel from cloud: " + useTpnsChannel);
            if (useTpnsChannel == 0) {
                f67861h = (Boolean) CacheHelper.get(context, a.h());
            } else {
                if (useTpnsChannel == 1) {
                    z11 = true;
                }
                f67861h = Boolean.valueOf(z11);
            }
        }
        TLogger.d("XGPushConfig", "isUsedTpnsChannel: " + f67861h);
        return f67861h.booleanValue();
    }

    public static void resetBadgeNum(Context context) {
        c.b(context);
    }

    public static void resetHuaweiBadgeNum(Context context) {
        c.a(context);
    }

    public static void setAccessId(Context context, long j11) {
        if (j11 != getAccessId(context)) {
            CacheHelper.set(context, a.b().set(""));
        }
        XGApiConfig.setAccessId(context, j11);
    }

    public static void setAccessKey(Context context, String str) {
        XGApiConfig.setAccessKey(context, str);
    }

    public static void setAutoFilterHuaweiPublicNotificationFlag(boolean z11) {
        autoFilterHuaweiPublicNotification = z11;
    }

    public static void setAutoInit(boolean z11) {
        autoInit = z11;
    }

    public static void setBadgeNum(Context context, int i11) {
        c.c(context, i11);
    }

    public static void setEnableActivityWindowSecFlag(boolean z11) {
        enableActivityWindowSecFlag = z11;
    }

    public static void setForeiginPushEnable(Context context, boolean z11) {
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z11) {
        MqttConfig.setForeignWeakAlarmMode(context, z11);
    }

    public static void setGameServer(Context context, String str) {
        if (context != null && str != null && str.trim().length() != 0) {
            f67855b = str;
        }
    }

    public static void setHeartbeatInterval(final Context context, final int i11) {
        if (context != null && i11 >= 10 && i11 < 36000) {
            try {
                MqttConfig.setKeepAliveInterval(context, i11);
                CommonWorkingThread.getInstance().execute(new TTask() {
                    @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
                    public void TRun() {
                        try {
                            Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4");
                            intent.putExtra(MTPushConstants.Geofence.KEY_INTERVAL, i11);
                            BroadcastAgent.sendBroadcast(context, intent);
                        } catch (Throwable th2) {
                            TLogger.e("XGPushConfig", "setHeartbeatInterval ", th2);
                        }
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("XGPushConfig", "setHeartbeatInterval", th2);
            }
        }
    }

    public static void setHeartbeatIntervalMs(Context context, int i11) {
        setHeartbeatInterval(context, i11 / 1000);
    }

    public static void setHuaweiBadgeNum(Context context, int i11) {
        c.b(context, i11);
    }

    public static void setHuaweiDebug(boolean z11) {
        _isHuaweiDebug = z11;
    }

    public static void setImei(Context context, String str) {
        f67857d = str;
    }

    public static void setInstallChannel(Context context, String str) {
        if (context != null && str != null && str.trim().length() != 0) {
            f67854a = str;
        }
    }

    public static void setLocationEnable(Context context, boolean z11) {
        Boolean bool = enableLocation;
        if (bool == null || bool.booleanValue() != z11) {
            enableLocation = Boolean.valueOf(z11);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_location," + context.getPackageName(), z11 ? 1 : 0);
        }
    }

    public static void setMiPushAppId(Context context, String str) {
        d.a(context, str);
    }

    public static void setMiPushAppKey(Context context, String str) {
        d.b(context, str);
    }

    public static void setMzPushAppId(Context context, String str) {
        d.c(context, str);
    }

    public static void setMzPushAppKey(Context context, String str) {
        d.d(context, str);
    }

    public static void setNotTryFcm(Context context, boolean z11) {
        if (context != null) {
            Boolean bool = fcmIsSuccess;
            if (bool == null || bool.booleanValue() != z11) {
                fcmIsSuccess = Boolean.valueOf(z11);
                CacheHelper.set(context, a.e().set(Integer.valueOf(z11 ? 1 : 0)));
            }
        }
    }

    public static void setNotificationChannelID(Context context, String str) {
        if (context != null) {
            notificationChannelID = str;
            PushPreferences.putString(context, context.getPackageName() + ".notification.channelID", str);
        }
    }

    public static void setNotificationChannelName(Context context, String str) {
        if (context != null) {
            notificationChannelName = str;
            PushPreferences.putString(context, context.getPackageName() + ".notification.channelName", str);
        }
    }

    public static void setNotificationShowEnable(Context context, boolean z11) {
        if (context != null) {
            try {
                if (f67865l == null) {
                    f67865l = context.getSharedPreferences(Constants.APP_PREF_NAME, 0);
                }
                SharedPreferences.Editor edit = f67865l.edit();
                edit.putBoolean(Util.getKey(Constants.SETTINGS_ENABLE_SHOW_NOTIFICATION), z11);
                edit.commit();
            } catch (Throwable th2) {
                TLogger.e("XGPushConfig", "setNotificationShowEnable", th2);
            }
        }
    }

    public static void setOPPOBadgeNum(Context context, int i11) {
        c.d(context, i11);
    }

    public static void setOppoPushAppId(Context context, String str) {
        d.e(context, str);
    }

    public static void setOppoPushAppKey(Context context, String str) {
        d.f(context, str);
    }

    public static void setPowerSaveMode(Context context, boolean z11) {
        XGApiConfig.setPowerSaveMode(context, z11);
    }

    public static void setReportApplistEnable(Context context, boolean z11) {
        Boolean bool = enableApplist;
        if (bool == null || bool.booleanValue() != z11) {
            enableApplist = Boolean.valueOf(z11);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_applist," + context.getPackageName(), z11 ? 1 : 0);
        }
    }

    public static void setReportDebugMode(Context context, boolean z11) {
        if (context != null) {
            PushPreferences.putInt(context, context.getPackageName() + ".report.mode", z11 ? 1 : 0);
        }
    }

    public static void setReportNotificationStatusEnable(Context context, boolean z11) {
        Boolean bool = enableNotification;
        if (bool == null || bool.booleanValue() != z11) {
            enableNotification = Boolean.valueOf(z11);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_NOTIICATION," + context.getPackageName(), z11 ? 1 : 0);
        }
    }

    public static void setRequestProxy(XGPushProxy xGPushProxy) {
        if (xGPushProxy == null) {
            TLogger.ee("XGPushConfig", "setRequestProxy fail, proxy was null");
        } else {
            i.a().a(xGPushProxy);
        }
    }

    public static void setServerIpList(Context context, XGServerInfo xGServerInfo) {
        if (context != null && xGServerInfo != null) {
            PushPreferences.putString(context, "com.tencent.android.xg.vip.action.custom.iplist.local", xGServerInfo.getIpArray().toString());
        }
    }

    public static void setStatAutoPage(Context context, boolean z11) {
        f67856c = z11;
    }

    public static void setTPushLogger(LoggerInterface loggerInterface) {
        TBaseLogger.setLogger(loggerInterface);
    }

    public static void setUseFcmFirst(final Context context, boolean z11) {
        if (context != null) {
            Boolean bool = useFcmFirst;
            if (bool == null || bool.booleanValue() != z11) {
                useFcmFirst = Boolean.valueOf(z11);
                CacheHelper.set(context, a.f().set(Integer.valueOf(useFcmFirst.booleanValue() ? 1 : 0)));
                CommonWorkingThread.getInstance().execute(new TTask() {
                    public void TRun() {
                        XGPushManager.loadOtherPushToken(context, false, -1);
                        b.a(context);
                    }
                });
            }
        }
    }

    public static void setVivoBadgeNum(Context context, int i11) {
        c.e(context, i11);
    }

    public static void setfcmSenderId(Context context, String str) {
        com.tencent.android.tpush.d.a.b(context, str);
    }
}
