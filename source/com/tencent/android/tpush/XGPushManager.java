package com.tencent.android.tpush;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.iproov.sdk.bridge.OptionsBridge;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.MessageManager;
import com.tencent.android.tpush.message.PushMessageManager;
import com.tencent.android.tpush.message.e;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.protocol.m;
import com.tencent.android.tpush.service.protocol.n;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.android.tpush.service.util.h;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GUIDInfo;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.NetworkUtil;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
public class XGPushManager {
    public static int CONNECT_STATE_CONNECTED = 1;
    public static int CONNECT_STATE_DEFAULT = 0;
    public static int CONNECT_STATE_NOT_CONNECTED = -1;
    public static final int MAX_TAG_LENGTH = 50;
    public static final int MAX_TAG_SIZE = 500;
    public static final int OPERATION_FAIL = 1;
    public static final int OPERATION_REQ_REGISTER = 100;
    public static final int OPERATION_REQ_UNREGISTER = 101;
    public static final int OPERATION_SUCCESS = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67874a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Context f67875b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Long f67876c = 0L;

    /* renamed from: d  reason: collision with root package name */
    private static long f67877d = 30000;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile TTask f67878e = null;

    /* renamed from: f  reason: collision with root package name */
    private static volatile Queue<Long> f67879f = new ConcurrentLinkedQueue();

    /* renamed from: g  reason: collision with root package name */
    private static XGPushNotifactionCallback f67880g = null;

    /* renamed from: h  reason: collision with root package name */
    private static XGSysPushNotifactionCallback f67881h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static Map<b, c> f67882i = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f67883j = "0123456789ABCDEF".toCharArray();
    public static Map<String, Long> lastSuccessRegisterMap = new HashMap();

    public static class AccountInfo {
        public String accountName;
        public int accountType;

        public AccountInfo(int i11, String str) {
            this.accountType = i11;
            this.accountName = str;
        }
    }

    public enum AccountType {
        UNKNOWN(0),
        CUSTOM(1),
        QQ(991),
        QQMD5(992),
        IDFA(993),
        IDFMD5(994),
        MAC(995),
        MACMDS(996),
        OAID(997),
        OAIDMD5(998),
        UNIONID(999),
        IMEI(1000),
        IMEIMD5(1001),
        PHONE_NUMBER(1002),
        WX_OPEN_ID(1003),
        QQ_OPEN_ID(1004),
        EMAIL(1005),
        SINA_WEIBO(1006),
        ALIPAY(1007),
        TAOBAO(1008),
        DOUBAN(1009),
        FACEBOOK(1010),
        TWITTER(1011),
        GOOGLE(1012),
        BAIDU(1013),
        JINGDONG(1014),
        LINKEDIN(1015);
        
        private int value;

        private AccountType(int i11) {
            this.value = i11;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class a extends TTask {

        /* renamed from: a  reason: collision with root package name */
        private Context f68007a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f68008b;

        /* renamed from: c  reason: collision with root package name */
        private XGIOperateCallback f68009c;

        /* renamed from: d  reason: collision with root package name */
        private int f68010d;

        /* renamed from: e  reason: collision with root package name */
        private int f68011e = 0;

        /* renamed from: f  reason: collision with root package name */
        private boolean f68012f;

        public a(XGIOperateCallback xGIOperateCallback, Context context, Intent intent, int i11, int i12, boolean z11) {
            super("OperateRunnable");
            this.f68009c = xGIOperateCallback;
            this.f68007a = context;
            this.f68008b = intent;
            this.f68010d = i11;
            this.f68011e = i12;
            this.f68012f = z11;
        }

        public void TRun() {
            try {
                this.f68008b.removeExtra("storage");
                int i11 = this.f68010d;
                if (i11 == 1) {
                    String stringExtra = this.f68008b.getStringExtra("data");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    int intExtra = this.f68008b.getIntExtra("operation", -1);
                    TLogger.d("XGPushManager", "TYPE_RSP - operation:" + intExtra + ", opType:" + this.f68011e);
                    if (intExtra == 0) {
                        String stringExtra2 = this.f68008b.getStringExtra("otherPushToken");
                        Long valueOf = Long.valueOf(this.f68008b.getLongExtra("otherPushType", -1));
                        valueOf.longValue();
                        if (valueOf.longValue() > 0) {
                            if (!j.b(stringExtra2) && !j.b(stringExtra.toString())) {
                                SharePrefsUtil.setString(this.f68007a, stringExtra2, stringExtra.toString());
                            }
                            stringExtra = stringExtra2;
                        }
                        if (this.f68008b.hasExtra("lastNMd5str")) {
                            com.tencent.android.tpush.service.util.c.a(this.f68008b.getStringExtra("lastNMd5str"));
                        }
                        XGIOperateCallback xGIOperateCallback = this.f68009c;
                        if (xGIOperateCallback != null) {
                            if (xGIOperateCallback instanceof b) {
                                ((b) xGIOperateCallback).a(stringExtra, this.f68008b.getIntExtra("flag", -1), this.f68012f);
                            }
                            if (!this.f68012f) {
                                this.f68009c.onSuccess(stringExtra, this.f68008b.getIntExtra("flag", -1));
                            } else {
                                TLogger.d("XGPushManager", "TYPE_RSP - has invoked callback");
                            }
                        }
                        RegisterEntity registerEntity = new RegisterEntity();
                        if (this.f68011e == 0) {
                            registerEntity.state = 0;
                            if (XGPushManager.f67878e != null) {
                                TLogger.d("XGPushManager", "remove registerRunnable4NewDevice");
                                CommonWorkingThread.getInstance().remove(XGPushManager.f67878e);
                                TTask unused = XGPushManager.f67878e = null;
                            }
                        } else {
                            registerEntity.state = 1;
                        }
                        registerEntity.accessId = this.f68008b.getLongExtra("accId", 0);
                        registerEntity.packageName = this.f68007a.getPackageName();
                        registerEntity.token = stringExtra;
                        registerEntity.timestamp = System.currentTimeMillis() / 1000;
                        registerEntity.xgSDKVersion = "1.4.4.2";
                        registerEntity.appVersion = AppInfos.getCurAppVersion(this.f68007a);
                        CacheManager.setCurrentAppRegisterEntity(this.f68007a, registerEntity);
                        if (!j.b(registerEntity.packageName)) {
                            XGPushManager.lastSuccessRegisterMap.put(registerEntity.packageName, Long.valueOf(System.currentTimeMillis() / 1000));
                        }
                        if (this.f68011e == 0) {
                            com.tencent.android.tpush.d.b.a(this.f68007a);
                            if (this.f68011e == 0) {
                                com.tencent.android.tpush.stat.a.a.a(this.f68007a, stringExtra, "firstRegister");
                            }
                        }
                    } else if (intExtra == 1) {
                        this.f68009c.onFail(stringExtra, this.f68008b.getIntExtra("code", -1), this.f68008b.getStringExtra(RemoteMessageConst.MessageBody.MSG));
                    }
                } else if (i11 == 0) {
                    int intExtra2 = this.f68008b.getIntExtra("operation", -1);
                    TLogger.d("XGPushManager", "TYPE_REQ - operation:" + intExtra2 + ", opType:" + this.f68011e);
                    if (intExtra2 == 100) {
                        XGPushManager.f(this.f68007a, this.f68008b, this.f68009c);
                    } else if (intExtra2 == 101) {
                        XGPushManager.g(this.f68007a, this.f68008b, this.f68009c);
                    }
                }
                com.tencent.android.tpush.common.b.a(this.f68007a);
            } catch (Throwable th2) {
                TLogger.e("XGPushManager", "OperateRunnable", th2);
            }
        }
    }

    public static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public Context f68013a = null;

        /* renamed from: b  reason: collision with root package name */
        public Intent f68014b = null;

        /* renamed from: c  reason: collision with root package name */
        public XGIOperateCallback f68015c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f68016d = 0;

        public b(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, int i11) {
            this.f68013a = context;
            this.f68014b = intent;
            this.f68015c = xGIOperateCallback;
            this.f68016d = i11;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|5|6|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0052 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                java.lang.String r0 = "XGPushManager"
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(r3, r4, r5)
                java.util.Map r4 = com.tencent.android.tpush.XGPushManager.f67882i     // Catch:{ all -> 0x0079 }
                int r4 = r4.size()     // Catch:{ all -> 0x0079 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
                r1.<init>()     // Catch:{ all -> 0x0079 }
                java.lang.String r2 = "Service start from app :"
                r1.append(r2)     // Catch:{ all -> 0x0079 }
                java.lang.String r2 = "pkg"
                java.lang.String r2 = r5.getStringExtra(r2)     // Catch:{ all -> 0x0079 }
                r1.append(r2)     // Catch:{ all -> 0x0079 }
                java.lang.String r2 = " , sdk version:"
                r1.append(r2)     // Catch:{ all -> 0x0079 }
                java.lang.String r2 = "ver"
                java.lang.String r5 = r5.getStringExtra(r2)     // Catch:{ all -> 0x0079 }
                r1.append(r5)     // Catch:{ all -> 0x0079 }
                java.lang.String r5 = "mapSize:"
                r1.append(r5)     // Catch:{ all -> 0x0079 }
                r1.append(r4)     // Catch:{ all -> 0x0079 }
                java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0079 }
                com.tencent.android.tpush.logging.TLogger.d(r0, r4)     // Catch:{ all -> 0x0079 }
                java.util.Map r4 = com.tencent.android.tpush.XGPushManager.f67882i     // Catch:{ all -> 0x0052 }
                java.lang.Object r4 = r4.remove(r3)     // Catch:{ all -> 0x0052 }
                com.tencent.android.tpush.XGPushManager$c r4 = (com.tencent.android.tpush.XGPushManager.c) r4     // Catch:{ all -> 0x0052 }
                com.tencent.tpns.baseapi.base.util.CommonWorkingThread r5 = com.tencent.tpns.baseapi.base.util.CommonWorkingThread.getInstance()     // Catch:{ all -> 0x0052 }
                android.os.Handler r5 = r5.getHandler()     // Catch:{ all -> 0x0052 }
                r5.removeCallbacks(r4)     // Catch:{ all -> 0x0052 }
            L_0x0052:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
                r4.<init>()     // Catch:{ all -> 0x0079 }
                java.lang.String r5 = " exec from ServiceStartReceiver operaType:"
                r4.append(r5)     // Catch:{ all -> 0x0079 }
                int r5 = r3.f68016d     // Catch:{ all -> 0x0079 }
                r4.append(r5)     // Catch:{ all -> 0x0079 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0079 }
                com.tencent.android.tpush.logging.TLogger.d(r0, r4)     // Catch:{ all -> 0x0079 }
                android.content.Context r4 = r3.f68013a     // Catch:{ all -> 0x0079 }
                android.content.Intent r5 = r3.f68014b     // Catch:{ all -> 0x0079 }
                com.tencent.android.tpush.XGIOperateCallback r1 = r3.f68015c     // Catch:{ all -> 0x0079 }
                int r2 = r3.f68016d     // Catch:{ all -> 0x0079 }
                com.tencent.android.tpush.XGPushManager.c(r4, r5, r1, r2)     // Catch:{ all -> 0x0079 }
                android.content.Context r4 = r3.f68013a     // Catch:{ all -> 0x0079 }
                com.tencent.android.tpush.common.j.a((android.content.Context) r4, (android.content.BroadcastReceiver) r3)     // Catch:{ all -> 0x0079 }
                goto L_0x007f
            L_0x0079:
                r4 = move-exception
                java.lang.String r5 = "RegisterStartReceiver error"
                com.tencent.android.tpush.logging.TLogger.e(r0, r5, r4)
            L_0x007f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushManager.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public static class c extends TTask {

        /* renamed from: a  reason: collision with root package name */
        public Context f68017a = null;

        /* renamed from: b  reason: collision with root package name */
        public Intent f68018b = null;

        /* renamed from: c  reason: collision with root package name */
        public XGIOperateCallback f68019c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f68020d = -1;

        public c(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, int i11) {
            this.f68017a = context;
            this.f68018b = intent;
            this.f68019c = xGIOperateCallback;
            this.f68020d = i11;
        }

        public void TRun() {
            b bVar = null;
            try {
                for (b bVar2 : XGPushManager.f67882i.keySet()) {
                    if (this == XGPushManager.f67882i.get(bVar2)) {
                        bVar = bVar2;
                    }
                }
                if (bVar != null) {
                    j.a(this.f68017a, (BroadcastReceiver) bVar);
                    XGPushManager.f67882i.remove(bVar);
                    TLogger.d("XGPushManager", "TimeoutRunnable unregister and remove success");
                }
            } catch (Throwable th2) {
                TLogger.e("XGPushManager", " RegisterTimeoutRunnable run error", th2);
                return;
            }
            TLogger.d("XGPushManager", "TimeoutRunnable optera was timeout, opType:" + this.f68020d);
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    c cVar = c.this;
                    XGPushManager.c(cVar.f68017a, cVar.f68018b, cVar.f68019c, cVar.f68020d);
                }
            });
        }
    }

    public static class d implements XGIOperateCallback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f68022a = false;

        /* renamed from: b  reason: collision with root package name */
        public XGIOperateCallback f68023b;

        /* renamed from: c  reason: collision with root package name */
        public TTask f68024c;

        /* renamed from: d  reason: collision with root package name */
        public String f68025d = "";

        public d(XGIOperateCallback xGIOperateCallback, TTask tTask, String str) {
            this.f68023b = xGIOperateCallback;
            this.f68024c = tTask;
            this.f68025d = str;
        }

        public void onFail(Object obj, int i11, String str) {
            if (!this.f68022a) {
                XGIOperateCallback xGIOperateCallback = this.f68023b;
                if (xGIOperateCallback != null) {
                    xGIOperateCallback.onFail(obj, i11, str);
                } else {
                    TLogger.w("XGPushManager", "XGInnerCallback , callback was null, " + this.f68025d + " onFail data:" + obj + " , errCode:" + i11 + ",msg:" + str);
                }
                this.f68022a = true;
                return;
            }
            TLogger.w("XGPushManager", "XGInnerCallback , has invoked callback" + this.f68025d + " onFail data:" + obj + " , errCode:" + i11 + ",msg:" + str);
        }

        public void onSuccess(Object obj, int i11) {
            if (!this.f68022a) {
                if (this.f68024c != null) {
                    CommonWorkingThread.getInstance().execute(this.f68024c);
                } else {
                    XGIOperateCallback xGIOperateCallback = this.f68023b;
                    if (xGIOperateCallback != null) {
                        xGIOperateCallback.onFail(obj, -1, "internel error");
                    } else {
                        TLogger.w("XGPushManager", "XGInnerCallback , callback was null, " + this.f68025d + " onSuccess data:" + obj + " , flag:" + i11);
                    }
                }
                this.f68022a = true;
                return;
            }
            TLogger.w("XGPushManager", "XGInnerCallback , has invoked callback" + this.f68025d + " onSuccess data:" + obj + " , flag:" + i11);
        }
    }

    private XGPushManager() {
    }

    public static long addLocalNotification(Context context, XGLocalMessage xGLocalMessage) {
        return a(context, xGLocalMessage, -1);
    }

    public static void addLocalNotificationList(final Context context, ArrayList<XGLocalMessage> arrayList) {
        Iterator<XGLocalMessage> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final XGLocalMessage next = it2.next();
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    long a11 = XGPushManager.a(context, next, -1);
                    TLogger.i("XGPushManager", "ret :" + a11 + ",msgID:" + next.getMsgId());
                }
            }, 1000);
        }
    }

    @Deprecated
    public static void addTags(Context context, String str, Set<String> set) {
        appendTags(context, str, set);
    }

    @Deprecated
    public static void appendAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        upsertAccounts(context, str, xGIOperateCallback);
    }

    @Deprecated
    public static void appendTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of addTags is invalid.");
            return;
        }
        String a11 = a(set, "addTags");
        if (h.a(a11)) {
            TLogger.ee("XGPushManager", "addTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "addTags -> setTags with all tags = " + a11);
        a(context, a11, 5, -1, (String) null, str);
    }

    @Deprecated
    public static void bindAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        clearAndAppendAccount(context, str, xGIOperateCallback);
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11] & 255;
            int i12 = i11 * 2;
            char[] cArr2 = f67883j;
            cArr[i12] = cArr2[b11 >>> 4];
            cArr[i12 + 1] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    public static void cancelAllNotifaction(Context context) {
        try {
            ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancelAll();
            if (XGPushConfig.isUsedOtherPush(context) && "xiaomi".equalsIgnoreCase(com.tencent.android.tpush.d.d.a(context).k())) {
                Class<MiPushClient> cls = MiPushClient.class;
                String str = MiPushClient.COMMAND_REGISTER;
                cls.getDeclaredMethod("clearNotification", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            }
        } catch (Throwable th2) {
            TLogger.e("XGPushManager", "cancelAllNotifaction error " + th2.toString());
        }
    }

    public static void cancelNotifaction(Context context, int i11) {
        try {
            ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(i11);
        } catch (Throwable th2) {
            TLogger.e("XGPushManager", "cancelNotification error " + th2.toString());
        }
    }

    @Deprecated
    public static void cleanTags(Context context, String str) {
        clearTags(context, str);
    }

    public static void clearAccounts(Context context) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of delAllAccount is null.");
        } else {
            clearAccounts(context, new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.ee("XGPushManager", "TPNS deleteAllAccount failed, errCode =  " + i11 + ", msg = " + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.ii("XGPushManager", "TPNS deleteAllAccount success" + obj);
                }
            });
        }
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(str, 0);
        if (context == null || h.a(str) || h.a(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or account of bindAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        b(context, a11, 0, (String) null, 0, str, xGIOperateCallback);
    }

    public static void clearAndAppendAttributes(Context context, String str, Map<String, String> map, XGIOperateCallback xGIOperateCallback) {
        if (context == null || map == null || map.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or attributes of clearAndAppendAttributes is invalid.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ATTRIBUTE;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        String a11 = a(map);
        if (a("clearAndAppendAttributes", a11)) {
            TLogger.ii("XGPushManager", "clearAndAppendAttributes with all attribute = " + a11);
            b(context, a11, 2, str, xGIOperateCallback);
        }
    }

    @Deprecated
    public static void clearAndAppendTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of setTags is invalid.");
            return;
        }
        String a11 = a(set, "setTags");
        if (h.a(a11)) {
            TLogger.ee("XGPushManager", "setTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTags with all tags = " + a11);
        a(context, a11, 6, -1, (String) null, str);
    }

    public static void clearAttributes(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of clearAttributes is invalid");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ATTRIBUTE;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "Action -> clearAttributes");
        b(context, "{}", 4, str, xGIOperateCallback);
    }

    public static void clearLocalNotifications(Context context) {
        if (context == null) {
            TLogger.e("XGPushManager", "clearLocalNotifications  context==null.");
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (j.a(applicationContext) <= 0) {
                    MessageManager.getInstance().clearAllLocalMsg(applicationContext);
                }
            }
        });
    }

    public static void clearTags(Context context, String str) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of cleanTags is invalid");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> cleanTags");
        a(context, "*", 8, -1, (String) null, str);
    }

    public static void createNotificationChannel(Context context, String str, String str2, boolean z11, boolean z12, boolean z13, Uri uri) {
        createNotificationChannel(context, str, str2, z11, z12, z13, uri, -1);
    }

    @Deprecated
    public static void delAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(str, 0);
        if (context == null || h.a(str) || h.a(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or account of delAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        b(context, a11, 0, (String) null, 3, str, xGIOperateCallback);
    }

    public static void delAccounts(Context context, Set<Integer> set, XGIOperateCallback xGIOperateCallback) {
        if (context == null || set == null || set.size() <= 0) {
            TLogger.ee("XGPushManager", "delAccounts | the parameter context or accounts of delAccounts is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        String b11 = b(set);
        if (h.a(b11)) {
            TLogger.ee("XGPushManager", "delAccounts | accountTypeStr is empty");
            return;
        }
        TLogger.d("XGPushManager", "delAccounts | accountTypeStr : " + b11);
        b(context, b11, 0, (String) null, 7, b11, xGIOperateCallback);
    }

    @Deprecated
    public static void delAccountsByKeys(Context context, Set<Integer> set, XGIOperateCallback xGIOperateCallback) {
        delAccounts(context, set, xGIOperateCallback);
    }

    @Deprecated
    public static void delAllAccount(Context context) {
        clearAccounts(context);
    }

    public static void delAttributes(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or attributes of delAttributes is invalid.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ATTRIBUTE;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        String a11 = a(set);
        if (a("delAttributes", a11)) {
            TLogger.ii("XGPushManager", "delAttributes -> attributes = " + a11);
            b(context, a11, 3, str, xGIOperateCallback);
        }
    }

    @Deprecated
    public static void delTag(Context context, String str) {
        TLogger.ii("XGPushManager", "Action -> deleteTag with tag = " + str);
        if (context == null || str == null || str.trim().length() == 0) {
            TLogger.ee("XGPushManager", "context is null or tagName invalid.");
        } else {
            a(context, str, 2, -1, (String) null, str);
        }
    }

    public static void delTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of deleteTags is invalid.");
            return;
        }
        String a11 = a(set, "deleteTags");
        if (h.a(a11)) {
            TLogger.ee("XGPushManager", "deleteTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "deleteTags -> setTags with all tags = " + a11);
        a(context, a11, 7, -1, (String) null, str);
    }

    public static void deleteKeyValueTag(Context context, String str, String str2) {
        if (context == null || str == null || str.trim().length() == 0) {
            TLogger.ee("XGPushManager", "deleteKeyValueTag context or tagKey invalid.");
            return;
        }
        String str3 = str + "::::" + str2;
        TLogger.ii("XGPushManager", "Action -> deleteKeyValueTag with tag = " + str3);
        a(context, str3, 4, -1, (String) null, str3);
    }

    @Deprecated
    public static void deleteTag(Context context, String str) {
        delTag(context, str);
    }

    @Deprecated
    public static void deleteTags(Context context, String str, Set<String> set) {
        delTags(context, str, set);
    }

    private static void e(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            try {
                BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                    public void onReceive(Context context, final Intent intent) {
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        TLogger.ii("XGPushManager", "Account call back to " + context.getPackageName());
                        try {
                            CommonWorkingThread.getInstance().execute(new TTask() {
                                public void TRun() {
                                    int intExtra = intent.getIntExtra("operation", -1);
                                    String stringExtra = intent.getStringExtra("data");
                                    if (stringExtra == null) {
                                        stringExtra = "";
                                    }
                                    if (intExtra == 0) {
                                        XGIOperateCallback.this.onSuccess(stringExtra, intent.getIntExtra("flag", -1));
                                    } else if (intExtra == 1) {
                                        XGIOperateCallback.this.onFail(stringExtra, intent.getIntExtra("code", -1), intent.getStringExtra(RemoteMessageConst.MessageBody.MSG));
                                    }
                                }
                            });
                        } catch (Throwable th2) {
                            TLogger.e("XGPushManager", "accountManager handle callback error " + th2.toString());
                        }
                        j.a(context, (BroadcastReceiver) this);
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4"), 4);
            } catch (Throwable th2) {
                TLogger.e("XGPushManager", "accountManager registerReceiver error " + th2.toString());
            }
        }
        BroadcastAgent.sendBroadcast(context, intent);
    }

    public static void enableService(Context context, boolean z11) {
        if (context != null) {
            if (!z11 && j.i(context)) {
                TLogger.e("XGPushManager", "TPNS is disable.");
                stopPushService(context);
            }
            TLogger.ii("XGPushManager", "enableService=" + (z11 ? 1 : 0));
            PushMd5Pref.putInt(context, context.getPackageName() + ".enableService", z11);
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void f(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        synchronized (XGPushManager.class) {
            TLogger.ii("XGPushManager", "Action -> Register to TPNS server");
            if (xGIOperateCallback != null) {
                final boolean z11 = false;
                if (intent != null) {
                    try {
                        z11 = intent.getBooleanExtra("invokedCallBack", false);
                    } catch (Throwable th2) {
                        TLogger.e("XGPushManager", "register registerReceiver error " + th2.toString());
                    }
                }
                BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        TLogger.ii("XGPushManager", "Register call back to " + context.getPackageName());
                        try {
                            CommonWorkingThread.getInstance().execute(new a(XGIOperateCallback.this, context, intent, 1, 0, z11));
                        } catch (Throwable th2) {
                            TLogger.e("XGPushManager", "register handle callback error " + th2.toString());
                        }
                        j.a(context, (BroadcastReceiver) this);
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4"), 4);
            }
            BroadcastAgent.sendBroadcast(context, intent);
        }
    }

    /* access modifiers changed from: private */
    public static void g(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        try {
            TLogger.ii("XGPushManager", "Action -> Unregister to TPNS server");
            BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                public void onReceive(final Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    j.a(context, (BroadcastReceiver) this);
                    try {
                        CommonWorkingThread.getInstance().execute(new TTask() {
                            public void TRun() {
                                XGApiConfig.clearRegistered(context);
                                XGPushManager.enableService(context, false);
                                if (XGPushConfig.isUsedOtherPush(context) && com.tencent.android.tpush.d.d.a(context).a()) {
                                    try {
                                        com.tencent.android.tpush.d.d.a(context).e();
                                    } catch (Throwable th2) {
                                        TLogger.e("XGPushManager", "unregister otherPush error " + th2.toString());
                                    }
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        TLogger.e("XGPushManager", "unregister otherPush handle callback error " + th2.toString());
                    }
                    if (XGIOperateCallback.this != null) {
                        try {
                            CommonWorkingThread.getInstance().execute(new a(XGIOperateCallback.this, context, intent, 1, 1, false));
                        } catch (Throwable th3) {
                            TLogger.e("XGPushManager", "unregister handle callback error " + th3.toString());
                        }
                    }
                }
            }, new IntentFilter("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4"), 4);
            BroadcastAgent.sendBroadcast(context, intent);
        } catch (Throwable th2) {
            TLogger.e("XGPushManager", "unregister registerReceiver error " + th2.toString());
        }
    }

    public static void getConnectState(Context context, final XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback == null) {
            TLogger.w("XGPushManager", "The XGIOperateCallback parameter can not be null!");
        } else if (context == null) {
            xGIOperateCallback.onFail(Integer.valueOf(CONNECT_STATE_DEFAULT), ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context parameter can not be null!");
        } else {
            try {
                if (e()) {
                    Integer valueOf = Integer.valueOf(CONNECT_STATE_DEFAULT);
                    ReturnCode returnCode = ReturnCode.CODE_SDK_API_FREQUENCY_LIMIT_ERROR;
                    xGIOperateCallback.onFail(valueOf, returnCode.getType(), returnCode.getStr());
                } else if (!NetworkUtil.isNetworkConnected(context)) {
                    xGIOperateCallback.onFail(Integer.valueOf(CONNECT_STATE_DEFAULT), ReturnCode.CODE_NETWORK_UNREACHABLE.getType(), "no network, please check again!");
                } else if (!j.i(context)) {
                    TLogger.d("XGPushManager", "getConnectState Util.isEnableService false");
                    xGIOperateCallback.onSuccess(Integer.valueOf(CONNECT_STATE_NOT_CONNECTED), 0);
                } else {
                    int c11 = j.c(context);
                    boolean a11 = com.tencent.android.tpush.service.b.a();
                    TLogger.d("XGPushManager", "serviceStatus:" + c11 + ", isHasBinded: " + a11);
                    if (c11 != 1 || !a11) {
                        xGIOperateCallback.onSuccess(Integer.valueOf(CONNECT_STATE_NOT_CONNECTED), 0);
                        return;
                    }
                    Intent intent = new Intent("com.tencent.android.xg.vip.action.CHECK_CONNECT_STATE.V4");
                    BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                        public void onReceive(Context context, final Intent intent) {
                            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                            CommonWorkingThread.getInstance().execute(new TTask() {
                                public void TRun() {
                                    if (intent.getBooleanExtra("connectState", false)) {
                                        XGIOperateCallback.this.onSuccess(Integer.valueOf(XGPushManager.CONNECT_STATE_CONNECTED), 0);
                                    } else {
                                        XGIOperateCallback.this.onSuccess(Integer.valueOf(XGPushManager.CONNECT_STATE_NOT_CONNECTED), 0);
                                    }
                                }
                            });
                            j.a(context, (BroadcastReceiver) this);
                        }
                    }, new IntentFilter("com.tencent.android.xg.vip.action.CHECK_CONNECT_STATE.RESULT.V4"), 4);
                    TLogger.i("XGPushManager", "getConnectState sendBroadcast");
                    BroadcastAgent.sendBroadcast(context, intent);
                }
            } catch (Throwable th2) {
                TLogger.w("XGPushManager", "getConnectState error: " + th2.toString());
            }
        }
    }

    public static Context getContext() {
        return f67875b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r4 = r4.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCustomContentFromIntent(android.content.Context r3, android.content.Intent r4) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "XGPushManager"
            boolean r3 = r3 instanceof android.app.Activity     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x000e
            java.lang.String r3 = "getCustomContentFromIntent parse intent customContent error, please call this method through Activity context"
            com.tencent.android.tpush.logging.TLogger.ee(r1, r3)     // Catch:{ all -> 0x002f }
            return r0
        L_0x000e:
            if (r4 != 0) goto L_0x0016
            java.lang.String r3 = "getCustomContentFromIntent parse intent customContent error, parse null intent"
            com.tencent.android.tpush.logging.TLogger.ee(r1, r3)     // Catch:{ all -> 0x002f }
            return r0
        L_0x0016:
            java.lang.String r3 = "custom_content"
            java.lang.String r3 = r4.getStringExtra(r3)     // Catch:{ all -> 0x002f }
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x002e
            android.net.Uri r4 = r4.getData()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x002e
            java.lang.String r3 = "customContent"
            java.lang.String r3 = r4.getQueryParameter(r3)     // Catch:{ all -> 0x002f }
        L_0x002e:
            return r3
        L_0x002f:
            r3 = move-exception
            java.lang.String r4 = "getCustomContentFromIntent parse intent customContent error: "
            com.tencent.android.tpush.logging.TLogger.w(r1, r4, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushManager.getCustomContentFromIntent(android.content.Context, android.content.Intent):java.lang.String");
    }

    public static XGPushNotificationBuilder getDefaultNotificationBuilder(Context context) {
        XGPushNotificationBuilder notificationBuilder = getNotificationBuilder(context, 0);
        if (notificationBuilder == null) {
            com.tencent.android.tpush.message.b.a(context);
        }
        return notificationBuilder;
    }

    public static XGPushNotifactionCallback getNotifactionCallback() {
        return f67880g;
    }

    public static XGPushNotificationBuilder getNotificationBuilder(Context context, int i11) {
        if (context != null) {
            return com.tencent.android.tpush.message.b.a(context, i11);
        }
        TLogger.e("XGPushManager", "getNotificationBuilder  context == null");
        return null;
    }

    public static String getServiceTag(Context context) {
        if (!Security.checkTpnsSecurityLibSo(context)) {
            return "xg_service_enable";
        }
        return Rijndael.encrypt(XGPushConfig.getAccessId(context) + Constants.ACCEPT_TIME_SEPARATOR_SP + "xg_service_enable");
    }

    public static XGSysPushNotifactionCallback getSysNotifactionCallback() {
        return f67881h;
    }

    public static void initCommonComponents(final Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                com.tencent.android.tpush.d.d.a(context);
                j.g(context);
            }
        });
    }

    public static boolean isNotificationOpened(Context context) {
        return com.tencent.android.tpush.service.util.c.a(context);
    }

    public static String loadOtherPushToken(Context context, boolean z11, long j11) {
        try {
            TLogger.ii("XGPushManager", "start other push channel register !");
            if (!XGPushConfig.isUsedOtherPush(context)) {
                return null;
            }
            com.tencent.android.tpush.d.d.a(context).p();
            if (!com.tencent.android.tpush.d.d.a(context).m()) {
                return null;
            }
            com.tencent.android.tpush.d.d.a(context).c();
            com.tencent.android.tpush.d.d.a(context).d();
            if (!z11) {
                return null;
            }
            String a11 = a(context, j11);
            if (h.a(a11) && XGPushConfig.isUsedOtherPush(context)) {
                ServiceStat.reportTokenFailed(context);
            }
            return a11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void logger(int i11, String str, String str2, Throwable th2) {
        TBaseLogger.addThirdLog(i11, str, str2, th2);
    }

    public static void msgAck(Context context, PushMessageManager pushMessageManager) {
        if (context != null && pushMessageManager != null) {
            TLogger.v("XGPushManager", "Action -> msgAck(" + context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP + pushMessageManager.getMsgId() + ")");
            if (pushMessageManager.getMsgId() > 0) {
                MessageId msgId = MessageManager.getInstance().getMsgId(context, context.getPackageName(), pushMessageManager.getMsgId());
                if (msgId == null) {
                    TLogger.ww("XGPushManager", "Action -> msgAck(" + context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP + pushMessageManager.getMsgId() + ")error, no the id: " + pushMessageManager.getMsgId());
                    return;
                }
                Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
                intent.putExtra("msgId", pushMessageManager.getMsgId());
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, context.getPackageName());
                intent.putExtra("MessageId", msgId);
                intent.putExtra(MessageKey.MSG_CHANNEL_ID, pushMessageManager.getChannelId());
                BroadcastAgent.sendBroadcast(context, intent);
            }
        }
    }

    public static XGPushClickedResult onActivityStarted(Activity activity) {
        Intent intent;
        TLogger.ii("XGPushManager", ">>> onActivityStarted " + activity);
        if (!(activity == null || activity.getIntent() == null || !j.i(activity) || (intent = activity.getIntent()) == null)) {
            try {
                if (intent.hasExtra(com.tencent.android.tpush.common.Constants.TAG_TPUSH_NOTIFICATION)) {
                    Serializable serializableExtra = intent.getSerializableExtra(com.tencent.android.tpush.common.Constants.TAG_TPUSH_NOTIFICATION);
                    intent.removeExtra(com.tencent.android.tpush.common.Constants.TAG_TPUSH_NOTIFICATION);
                    if (serializableExtra != null && (serializableExtra instanceof XGPushClickedResult)) {
                        XGPushClickedResult xGPushClickedResult = (XGPushClickedResult) serializableExtra;
                        xGPushClickedResult.parseIntent(intent);
                        return xGPushClickedResult;
                    }
                }
            } catch (Throwable th2) {
                TLogger.e("XGPushManager", "onActivityStarted", th2);
            }
        }
        return null;
    }

    public static void onActivityStoped(Activity activity) {
    }

    public static void onEvent(Context context, String str, Properties properties) {
        ServiceStat.reportCustomData(context, str, properties);
    }

    public static void onMessageCleared(Context context, XGPushTextMessage xGPushTextMessage) {
        a(context, xGPushTextMessage.a(), "com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
    }

    public static void onMessageClicked(Context context, XGPushTextMessage xGPushTextMessage) {
        a(context, xGPushTextMessage.a(), "com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4");
    }

    public static void onOtherPushRegister(final Context context, final Intent intent) {
        TLogger.d("XGPushManager", "onOtherPushRegister");
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                TLogger.d("XGPushManager", "excute onOtherPushRegister");
                String stringExtra = intent.getStringExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_TOKEN_KEY);
                String stringExtra2 = intent.getStringExtra(com.tencent.android.tpush.common.Constants.OTHER_PUSH_TOKEN);
                if (intent.getIntExtra(com.tencent.android.tpush.common.Constants.PUSH_CHANNEL, 0) != 100 && !h.a(stringExtra) && !h.a(stringExtra2)) {
                    SharePrefsUtil.setString(context, stringExtra, stringExtra2);
                }
                intent.setPackage(context.getPackageName());
                BroadcastAgent.sendBroadcast(context, intent);
            }
        });
    }

    public static void openNotification(Context context) {
        j.j(context);
    }

    public static void openNotificationSettings(Context context) {
        j.k(context);
    }

    public static void queryTags(Context context, String str, int i11, int i12, XGIOperateCallback xGIOperateCallback) {
        if (context == null || i11 < 0 || i12 <= 0) {
            TLogger.ee("XGPushManager", "the parameter context or tags of deleteTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_QUERYTAGS.getType(), ReturnCode.CODE_INVALID_TAG.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "Action -> queryTags");
        if (!b(context) || !j.i(context)) {
            final Context context2 = context;
            final String str2 = str;
            final int i13 = i11;
            final int i14 = i12;
            final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
            registerPush(context, new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    XGIOperateCallback xGIOperateCallback = xGIOperateCallback2;
                    if (xGIOperateCallback != null) {
                        xGIOperateCallback.onFail(obj, i11, str);
                    }
                }

                public void onSuccess(Object obj, int i11) {
                    XGPushManager.b(context2, str2, i13, i14, (String) null, xGIOperateCallback2);
                }
            });
            return;
        }
        b(context, str, i11, i12, (String) null, xGIOperateCallback);
    }

    public static void registerPush(Context context) {
        registerPush(context, new XGIOperateCallback() {
            public void onFail(Object obj, int i11, String str) {
                TLogger.ee("XGPushManager", "TPNS register push failed with token : " + obj + ", errCode : " + i11 + " , msg : " + str);
            }

            public void onSuccess(Object obj, int i11) {
                TLogger.ii("XGPushManager", "TPNS register push success with token : " + obj);
            }
        });
    }

    public static void reportTpnsInfoToBugly(Context context) {
        Class<String> cls = String.class;
        try {
            StringBuilder sb2 = new StringBuilder("TPNS INFO ");
            sb2.append(XGPushConfig.getToken(context));
            Class<?> cls2 = Class.forName("com.tencent.bugly.crashreport.BuglyLog");
            cls2.getMethod("i", new Class[]{cls, cls}).invoke(cls2, new Object[]{sb2.toString(), ""});
            TLogger.d("XGPushManager", "reportTpnsInfoToBugly | report tpnsInfo to bugly : " + sb2.toString());
        } catch (Throwable unused) {
            TLogger.w("XGPushManager", "reportTpnsInfoToBugly | Bugly sdk not found");
        }
    }

    public static void safeSendQuest(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, int i11) {
        int c11 = j.c(context);
        boolean a11 = com.tencent.android.tpush.service.b.a();
        TLogger.d("XGPushManager", "serviceStatus:" + c11 + ", isHasBinded: " + a11);
        if (c11 != 1 || !a11) {
            TLogger.d("XGPushManager", "delay send quest operatorType:" + i11);
            b(context, intent, xGIOperateCallback, i11);
            return;
        }
        TLogger.d("XGPushManager", "send boardcast to pushService， operatorType：" + i11);
        c(context, intent, xGIOperateCallback, i11);
    }

    public static void sendCommReport2Service(Context context, String str, String str2) {
        long accessId = XGPushConfig.getAccessId(context);
        Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.COMM_REPORT.V4");
        intent.putExtra("type", 1);
        intent.putExtra("accessId", Rijndael.encrypt("" + accessId));
        intent.putExtra("msgId", 1000);
        intent.putExtra("broadcastId", 0);
        intent.putExtra("msgTimestamp", System.currentTimeMillis() / 1000);
        intent.putExtra("clientTimestamp", System.currentTimeMillis() / 1000);
        intent.putExtra("pkgName", context.getPackageName());
        intent.putExtra(RemoteMessageConst.MessageBody.MSG, Rijndael.encrypt(str));
        intent.putExtra(TUIConstants.TUIOfflinePush.NOTIFICATION_EXT_KEY, Rijndael.encrypt(str2));
        BroadcastAgent.sendBroadcast(context, intent);
    }

    public static void setContext(Context context) {
        if (f67875b == null && context != null) {
            AppInfos.init(context);
            Context applicationContext = context.getApplicationContext();
            f67875b = applicationContext;
            TGlobalHelper.setContext(applicationContext);
        }
    }

    public static void setDefaultNotificationBuilder(final Context context, final XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context != null && xGPushNotificationBuilder != null) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    com.tencent.android.tpush.message.b.a(context, 0, xGPushNotificationBuilder);
                }
            });
        }
    }

    public static void setKeyValueTag(Context context, String str, String str2) {
        if (context == null || str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0) {
            TLogger.ee("XGPushManager", "setKeyValueTag context or tagKey or tagValue invalid.");
            return;
        }
        String str3 = str + "::::" + str2;
        TLogger.ii("XGPushManager", "Action -> setKeyValueTag with tag = " + str3);
        a(context, str3, 3, -1, (String) null, str3);
    }

    public static void setNotifactionCallback(XGPushNotifactionCallback xGPushNotifactionCallback) {
        f67880g = xGPushNotifactionCallback;
    }

    public static void setPushNotificationBuilder(final Context context, final int i11, final XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        } else if (i11 < 1 || i11 > 4096) {
            throw new IllegalArgumentException("notificationBulderId不在范围[1, 4096].");
        } else if (xGPushNotificationBuilder != null) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    com.tencent.android.tpush.message.b.a(context, i11, xGPushNotificationBuilder);
                }
            });
        }
    }

    public static void setSysNotifactionCallback(XGSysPushNotifactionCallback xGSysPushNotifactionCallback) {
        f67881h = xGSysPushNotifactionCallback;
    }

    @Deprecated
    public static void setTag(Context context, String str) {
        if (context == null || h.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or tagName of setTag is null.");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTag with tag = " + str);
        a(context, str, 1, -1, (String) null, str);
    }

    @Deprecated
    public static void setTags(Context context, String str, Set<String> set) {
        clearAndAppendTags(context, str, set);
    }

    public static void startPushService(Context context) {
        if (context != null) {
            setContext(context);
            TLogger.ii("XGPushManager", context.getPackageName() + "call start Push Service");
            j.g(context);
            if (j.c(context) == 0) {
                j.f(context);
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void stopPushService(android.content.Context r4) {
        /*
            if (r4 == 0) goto L_0x006d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.getPackageName()
            r0.append(r1)
            java.lang.String r1 = " call stop Push Service"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "XGPushManager"
            com.tencent.android.tpush.logging.TLogger.ii(r1, r0)
            android.content.ServiceConnection r0 = com.tencent.android.tpush.service.b.f()     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r2.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "vipConn:"
            r2.append(r3)     // Catch:{ all -> 0x004d }
            r2.append(r0)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004d }
            com.tencent.android.tpush.logging.TLogger.d(r1, r2)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x003c
            r4.unbindService(r0)     // Catch:{ all -> 0x004d }
            com.tencent.android.tpush.service.b.g()     // Catch:{ all -> 0x004d }
        L_0x003c:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x004d }
            r0.<init>()     // Catch:{ all -> 0x004d }
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ all -> 0x004d }
            java.lang.Class<com.tencent.android.tpush.service.XGVipPushService> r2 = com.tencent.android.tpush.service.XGVipPushService.class
            r0.setClass(r1, r2)     // Catch:{ all -> 0x004d }
            r4.stopService(r0)     // Catch:{ all -> 0x004d }
        L_0x004d:
            com.tencent.android.tpush.service.util.g.f(r4)     // Catch:{ all -> 0x006d }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = r4.getPackageName()     // Catch:{ all -> 0x006d }
            r1.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "com.tencent.android.xg.vip.action.KILLSERVICEPROCESS.V4"
            r1.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006d }
            r0.<init>(r1)     // Catch:{ all -> 0x006d }
            com.tencent.android.tpush.common.BroadcastAgent.sendBroadcast(r4, r0)     // Catch:{ all -> 0x006d }
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushManager.stopPushService(android.content.Context):void");
    }

    public static void unregisterPush(Context context) {
        if (context == null) {
            TLogger.e("XGPushManager", "the context of unregisterPush is null");
        } else {
            unregisterPush(context, new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.ee("XGPushManager", "UnRegisterPush push failed with token = " + obj + " , errCode = " + i11 + " , msg = " + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.ii("XGPushManager", "UnRegisterPush push succeed with token = " + obj + " flag = " + i11);
                }
            });
        }
    }

    public static void uploadLogFile(final Context context, final HttpRequestCallback httpRequestCallback) {
        if (context == null || httpRequestCallback == null) {
            TLogger.ee("XGPushManager", "parameter can not be null!");
            return;
        }
        try {
            final AnonymousClass27 r12 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    TLogger.ii("XGPushManager", "action - sendFlush onReceiver");
                    j.a(context, (BroadcastReceiver) this);
                    CommonWorkingThread.getInstance().remove(26);
                    TBaseLogger.uploadLogFile(context.getApplicationContext(), HttpRequestCallback.this);
                }
            };
            BroadcastAgent.registerReceiver(context, r12, new IntentFilter("com.tencent.android.xg.vip.action.FLUSH.RESULT.V4"), 4);
            CommonWorkingThread.getInstance().executeAtTime(new TTask() {
                public void TRun() {
                    TLogger.ii("XGPushManager", "action - executeAtTime");
                    TBaseLogger.uploadLogFile(context.getApplicationContext(), httpRequestCallback);
                    j.a(context, r12);
                }
            }, 26, 3000);
            Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.FLUSH.V4");
            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, Rijndael.encrypt(context.getPackageName()));
            BroadcastAgent.sendBroadcast(context, intent);
        } catch (Throwable th2) {
            TLogger.ww("XGPushManager", "unexpected for uploadLogFile:" + th2.getMessage());
        }
    }

    @Deprecated
    public static void upsertAccounts(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(str, 0);
        if (context == null || h.a(str) || h.a(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        b(context, a11, 0, (String) null, 2, str, xGIOperateCallback);
    }

    public static void upsertAttributes(Context context, String str, Map<String, String> map, XGIOperateCallback xGIOperateCallback) {
        if (context == null || map == null || map.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or attributes of upsertAttributes is invalid.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ATTRIBUTE;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        String a11 = a(map);
        if (a("upsertAttributes", a11)) {
            TLogger.ii("XGPushManager", "upsertAttributes with all attribute = " + a11);
            b(context, a11, 1, str, xGIOperateCallback);
        }
    }

    public static void upsertPhoneNumber(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        try {
            if (!Pattern.compile("^\\+?[1-9]\\d{1,14}$").matcher(str).matches() && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
        } catch (Throwable th2) {
            TLogger.ee("XGPushManager", "the parameter phoneNumber error", th2);
        }
        upsertAccounts(context, str, AccountType.PHONE_NUMBER.getValue(), xGIOperateCallback);
    }

    @Deprecated
    public static void addTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        appendTags(context, str, set, xGIOperateCallback);
    }

    @Deprecated
    public static void appendAccount(Context context, String str, int i11, XGIOperateCallback xGIOperateCallback) {
        upsertAccounts(context, str, i11, xGIOperateCallback);
    }

    @Deprecated
    public static void bindAccount(Context context, String str, int i11, XGIOperateCallback xGIOperateCallback) {
        clearAndAppendAccount(context, str, i11, xGIOperateCallback);
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, int i11, String str2, XGIOperateCallback xGIOperateCallback) {
        if (e()) {
            if (xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_SDK_API_FREQUENCY_LIMIT_ERROR;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
            }
        } else if (j.a(context) <= 0) {
            if (str != null) {
                long accessId = XGPushConfig.getAccessId(context);
                String accessKey = XGPushConfig.getAccessKey(context);
                if (accessId < 0 || h.a(accessKey)) {
                    throw new IllegalArgumentException("The accessId or accessKey not set!");
                }
                Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.ATTRIBUTE.V4");
                intent.putExtra("accId", accessId);
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACC_KEY, Rijndael.encrypt(accessKey));
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, Rijndael.encrypt(context.getPackageName()));
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ATTRIBUTES_TYPE, i11);
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ATTRIBUTES_NAME, Rijndael.encrypt(str));
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ATTRIBUTES_OPER_NAME, str2);
                safeSendQuest(context, intent, xGIOperateCallback, 4);
                return;
            }
            throw new IllegalArgumentException("The attributes parameter can not be null!");
        }
    }

    @Deprecated
    public static void cleanTags(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        clearTags(context, str, xGIOperateCallback);
    }

    public static void createNotificationChannel(Context context, String str, String str2, boolean z11, boolean z12, boolean z13, Uri uri, int i11) {
        String str3 = str;
        int i12 = i11;
        if (Build.VERSION.SDK_INT < 26) {
            TLogger.ii("XGPushManager", "CreateNotificationChannel SDK < 26");
            return;
        }
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Constructor<?> constructor = cls.getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE});
            if (i12 <= 0 || i12 >= 5) {
                i12 = 4;
            }
            Object newInstance = constructor.newInstance(new Object[]{str3, str2, Integer.valueOf(i12)});
            Class<?> cls2 = newInstance.getClass();
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("enableVibration", new Class[]{cls3}).invoke(newInstance, new Object[]{Boolean.valueOf(z11)});
            newInstance.getClass().getMethod("enableLights", new Class[]{cls3}).invoke(newInstance, new Object[]{Boolean.valueOf(z12)});
            Class<?> cls4 = Class.forName("android.media.AudioAttributes");
            Method method = newInstance.getClass().getMethod("setSound", new Class[]{Uri.class, cls4});
            if (!z13) {
                method.invoke(newInstance, new Object[]{null, null});
            } else if (uri != null) {
                method.invoke(newInstance, new Object[]{uri, null});
            }
            Context context2 = context;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{cls}).invoke(notificationManager, new Object[]{newInstance});
            TLogger.ii("XGPushManager", "CreateNotificationChannel channelId: " + str + " success");
        } catch (Throwable th2) {
            TLogger.ee("XGPushManager", "CreateNotificationChannel channelId: " + str + " Error: ", th2);
            th2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str, int i11, long j11, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        if (e()) {
            if (xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_SDK_API_FREQUENCY_LIMIT_ERROR;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
            }
        } else if (j.a(context) <= 0) {
            if (str != null) {
                if (j11 <= 0) {
                    j11 = XGPushConfig.getAccessId(context);
                }
                if (j11 >= 0) {
                    if (j.b(str2)) {
                        str2 = XGPushConfig.getAccessKey(context);
                    }
                    Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.TAG.V4");
                    intent.putExtra("accId", j11);
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACC_KEY, Rijndael.encrypt(str2));
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, Rijndael.encrypt(context.getPackageName()));
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_TAG_TYPE, i11);
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_TAG_NAME, Rijndael.encrypt(str));
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_TAG_OPER_NAME, str3);
                    safeSendQuest(context, intent, xGIOperateCallback, 2);
                    return;
                }
                throw new IllegalArgumentException("The accessId not set!");
            }
            throw new IllegalArgumentException("The tagName parameter can not be null!");
        }
    }

    @Deprecated
    public static void delAllAccount(Context context, XGIOperateCallback xGIOperateCallback) {
        clearAccounts(context, xGIOperateCallback);
    }

    @Deprecated
    public static void deleteTag(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        delTag(context, str, xGIOperateCallback);
    }

    @Deprecated
    public static void deleteTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        delTags(context, str, set, xGIOperateCallback);
    }

    public static void registerPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            a(context, (String) null, -1, (String) null, xGIOperateCallback, -1, (String) null, (String) null, (String) null, (String) null, -1);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    @Deprecated
    public static void setTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        clearAndAppendTags(context, str, set, xGIOperateCallback);
    }

    @Deprecated
    public static void appendAccount(Context context, String str, int i11) {
        upsertAccounts(context, str, i11);
    }

    @Deprecated
    public static void bindAccount(Context context, String str, int i11) {
        clearAndAppendAccount(context, str, i11);
    }

    public static void clearAccounts(Context context, XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of delAllAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        b(context, (String) null, 0, (String) null, 1, "", xGIOperateCallback);
    }

    public static void unregisterPush(Context context, String str, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        a(context, xGIOperateCallback, XGPushConfig.getAccessId(context), XGPushConfig.getAccessKey(context), str, str2, str3);
    }

    @Deprecated
    public static void appendAccount(Context context, String str) {
        upsertAccounts(context, str);
    }

    @Deprecated
    public static void bindAccount(Context context, String str) {
        clearAndAppendAccount(context, str);
    }

    public static void clearTags(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of cleanTags is invalid");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> cleanTags");
        a(context, "", 8, -1, (String) null, str, xGIOperateCallback);
    }

    /* access modifiers changed from: private */
    public static boolean e() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (f67879f == null) {
                f67879f = new ConcurrentLinkedQueue();
            }
            if (f67879f.size() < 10) {
                f67879f.offer(Long.valueOf(currentTimeMillis));
                return false;
            } else if (currentTimeMillis - f67879f.peek().longValue() < 10000) {
                return true;
            } else {
                f67879f.poll();
                f67879f.offer(Long.valueOf(currentTimeMillis));
                return false;
            }
        } catch (Throwable th2) {
            TLogger.i("XGPushManager", "apiRateLimit error: " + th2.toString());
            return false;
        }
    }

    public static void registerPush(Context context, long j11, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            a(context, (String) null, -1, (String) null, xGIOperateCallback, -1, (String) null, (String) null, (String) null, (String) null, j11);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    private static void b(Context context, String str, int i11, String str2, XGIOperateCallback xGIOperateCallback) {
        if (context != null) {
            final Context context2 = context;
            final String str3 = str;
            final int i12 = i11;
            final String str4 = str2;
            final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    if (!XGPushManager.b(context2) || !j.i(context2)) {
                        XGPushManager.registerPush(context2, new d(xGIOperateCallback2, new TTask() {
                            public void TRun() {
                                AnonymousClass3 r02 = AnonymousClass3.this;
                                XGPushManager.c(context2, str3, i12, str4, xGIOperateCallback2);
                            }
                        }, "attributes"));
                        return;
                    }
                    XGPushManager.c(context2, str3, i12, str4, xGIOperateCallback2);
                }
            });
            return;
        }
        throw new IllegalArgumentException("The context parameter can not be null!");
    }

    @Deprecated
    public static void delTag(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        TLogger.ii("XGPushManager", "Action -> deleteTag with tag = " + str);
        if (context == null || str == null || str.trim().length() == 0) {
            TLogger.ee("XGPushManager", "context is null or tagName invalid.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_TAG;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        a(context, str, 2, -1, (String) null, str, xGIOperateCallback);
    }

    @Deprecated
    public static void setTag(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null || h.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or tagName of setTag is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_TAG;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTag with tag = " + str);
        a(context, str, 1, -1, (String) null, str, xGIOperateCallback);
    }

    public static void registerPush(Context context, long j11, AccountInfo accountInfo, XGIOperateCallback xGIOperateCallback) {
        AccountInfo accountInfo2 = accountInfo;
        if (xGIOperateCallback != null) {
            String str = null;
            int i11 = -1;
            if (accountInfo2 != null) {
                str = accountInfo2.accountName;
                i11 = accountInfo2.accountType;
            }
            a(context, str, i11, (String) null, xGIOperateCallback, -1, (String) null, (String) null, (String) null, (String) null, j11);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void unregisterPush(Context context, XGIOperateCallback xGIOperateCallback) {
        a(context, xGIOperateCallback, XGPushConfig.getAccessId(context), XGPushConfig.getAccessKey(context), (String) null, (String) null, (String) null);
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, int i11, int i12, String str2, final XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            throw new IllegalArgumentException("The context parameter can not be null!");
        } else if (j.a(context) <= 0) {
            if (!e()) {
                long accessId = XGPushConfig.getAccessId(context);
                if (accessId >= 0) {
                    String accessKey = XGPushConfig.getAccessKey(context);
                    Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.QUERYTAGS.V4");
                    intent.putExtra("accId", accessId);
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACC_KEY, Rijndael.encrypt(accessKey));
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, Rijndael.encrypt(context.getPackageName()));
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_QUERY_TAGS_OPER_NAME, str);
                    intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_TAG_OFFSET, i11);
                    intent.putExtra("limit", i12);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_TAG_QUERY_TYPE, str2);
                    }
                    if (xGIOperateCallback != null) {
                        try {
                            BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                                public void onReceive(Context context, final Intent intent) {
                                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                                    TLogger.ii("XGPushManager", "Tag call back to " + context.getPackageName());
                                    try {
                                        CommonWorkingThread.getInstance().execute(new TTask() {
                                            public void TRun() {
                                                int intExtra = intent.getIntExtra("operation", -1);
                                                String stringExtra = intent.getStringExtra("data");
                                                if (stringExtra == null) {
                                                    stringExtra = "";
                                                }
                                                if (intExtra == 0) {
                                                    XGIOperateCallback.this.onSuccess(stringExtra, intent.getIntExtra("flag", 0));
                                                } else if (intExtra == 1) {
                                                    XGIOperateCallback.this.onFail(stringExtra, intent.getIntExtra("code", -1), intent.getStringExtra(RemoteMessageConst.MessageBody.MSG));
                                                }
                                            }
                                        });
                                    } catch (Throwable th2) {
                                        TLogger.e("XGPushManager", "tagManager handle callback error " + th2.toString());
                                    }
                                    j.a(context, (BroadcastReceiver) this);
                                }
                            }, new IntentFilter("com.tencent.android.xg.vip.action.QUERYTAGS.RESULT.V4"), 4);
                        } catch (Throwable th2) {
                            TLogger.e("XGPushManager", "tagManager registerReceiver error " + th2.toString());
                        }
                    }
                    BroadcastAgent.sendBroadcast(context, intent);
                    return;
                }
                throw new IllegalArgumentException("The accessId not set!");
            } else if (xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_SDK_API_FREQUENCY_LIMIT_ERROR;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
            }
        }
    }

    public static void appendTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(set, "addTags");
        if (context == null || set == null || set.isEmpty() || TextUtils.isEmpty(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or tags of addTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_TAG;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "addTags -> setTags with all tags = " + a11);
        a(context, a11, 5, -1, (String) null, str, xGIOperateCallback);
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, String str, int i11, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(str, i11);
        if (context == null || h.a(str) || h.a(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or account of clearAndAppendAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        b(context, a11, 0, (String) null, 0, str, xGIOperateCallback);
    }

    public static void clearAndAppendTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(set, "setTags");
        if (context == null || set == null || set.isEmpty() || TextUtils.isEmpty(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or tags of setTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_TAG;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTags with all tags = " + a11);
        a(context, a11, 6, -1, (String) null, str, xGIOperateCallback);
    }

    @Deprecated
    public static void delAccount(Context context, String str, int i11, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(str, i11);
        if (context == null || h.a(str) || h.a(a11)) {
            if (!(context == null || xGIOperateCallback == null)) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
            }
            TLogger.ee("XGPushManager", "the parameter context or account of delAccount is null.");
            return;
        }
        b(context, a11, 0, (String) null, 3, str, xGIOperateCallback);
    }

    public static void delTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(set, "deleteTags");
        if (context == null || set == null || set.isEmpty() || TextUtils.isEmpty(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or tags of deleteTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_TAG;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "deleteTags -> setTags with all tags = " + a11);
        a(context, a11, 7, -1, (String) null, str, xGIOperateCallback);
    }

    @Deprecated
    public static void upsertAccounts(Context context, String str, int i11, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(str, i11);
        if (context == null || h.a(str) || h.a(a11)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        b(context, a11, 0, (String) null, 2, str, xGIOperateCallback);
    }

    public static void queryTags(Context context, String str, int i11, int i12, String str2, XGIOperateCallback xGIOperateCallback) {
        if (context == null || i11 < 0 || i12 <= 0) {
            TLogger.ee("XGPushManager", "the parameter context or tags of deleteTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_QUERYTAGS.getType(), ReturnCode.CODE_INVALID_TAG.getStr());
            }
        } else if (!b(context) || !j.i(context)) {
            final Context context2 = context;
            final String str3 = str;
            final int i13 = i11;
            final int i14 = i12;
            final String str4 = str2;
            final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
            registerPush(context, new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    XGIOperateCallback xGIOperateCallback = xGIOperateCallback2;
                    if (xGIOperateCallback != null) {
                        xGIOperateCallback.onFail(obj, i11, str);
                    }
                }

                public void onSuccess(Object obj, int i11) {
                    XGPushManager.b(context2, str3, i13, i14, str4, xGIOperateCallback2);
                }
            });
        } else {
            b(context, str, i11, i12, str2, xGIOperateCallback);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            a(context, (String) null, -1, (String) null, xGIOperateCallback, -1, (String) null, str, str2, str3, -1);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void a(Context context, XGIOperateCallback xGIOperateCallback, long j11, String str, String str2, String str3, String str4) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            CacheManager.clearTokenCache();
            if (j.i(applicationContext)) {
                com.tencent.android.tpush.service.util.c.f69845a = 2;
                try {
                    long currentTimeMillis = System.currentTimeMillis() - f67876c.longValue();
                    if (f67878e != null && currentTimeMillis < f67877d) {
                        TLogger.d("XGPushManager", "cancel dump register, registerRunnable4NewDevice:" + f67878e);
                        CommonWorkingThread.getInstance().remove(f67878e);
                        f67878e = null;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
                final long j12 = j11;
                final String str5 = str;
                CommonWorkingThread.getInstance().execute(new TTask() {
                    public void TRun() {
                        XGIOperateCallback xGIOperateCallback;
                        try {
                            int a11 = j.a(applicationContext);
                            if (a11 != 0) {
                                XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback2;
                                if (xGIOperateCallback2 != null) {
                                    xGIOperateCallback2.onFail("", a11, "XINGE SDK config error");
                                    return;
                                }
                                return;
                            }
                            long j11 = j12;
                            if (j11 <= 0) {
                                j11 = XGPushConfig.getAccessId(applicationContext);
                            }
                            String accessKey = j.b(str5) ? XGPushConfig.getAccessKey(applicationContext) : str5;
                            String token = XGPushConfig.getToken(applicationContext);
                            if ((j11 <= 0 || j.b(accessKey) || j.b(token)) && (xGIOperateCallback = xGIOperateCallback2) != null) {
                                int type = ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType();
                                xGIOperateCallback.onFail("", type, "The accessId, accessKey or token is invalid! accessId=" + j11);
                                throw new IllegalArgumentException("accessId, accessKey or token is invalid.");
                            }
                            Intent intent = new Intent(applicationContext.getPackageName() + "com.tencent.android.xg.vip.action.UNREGISTER.V4");
                            intent.putExtra("accId", Rijndael.encrypt("" + j11));
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACC_KEY, Rijndael.encrypt(accessKey));
                            intent.putExtra("token", Rijndael.encrypt(token));
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, Rijndael.encrypt(applicationContext.getPackageName()));
                            intent.putExtra("operation", 101);
                            intent.putExtra("opType", 1);
                            XGPushManager.safeSendQuest(applicationContext, intent, xGIOperateCallback2, 1);
                        } catch (Throwable th2) {
                            TLogger.ee("XGPushManager", "unregisterPush", th2);
                        }
                    }
                });
            } else if (xGIOperateCallback != null) {
                xGIOperateCallback.onSuccess("It's already unregistered", 0);
            }
        } else if (xGIOperateCallback != null) {
            xGIOperateCallback.onFail("", ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context parameter can not be null!");
        } else {
            throw new IllegalArgumentException("The context parameter can not be null!");
        }
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, final String str, int i11) {
        if (context == null || h.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of bindAccount is null.");
        } else {
            clearAndAppendAccount(context, str, i11, new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.ee("XGPushManager", "TPNS binderAccount " + str + " failed, errCode =  " + i11 + ", msg = " + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.ii("XGPushManager", "TPNS binderAccount " + str + " success");
                }
            });
        }
    }

    @Deprecated
    public static void delAccount(Context context, final String str) {
        if (context == null || h.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of delAccount is null.");
        } else {
            delAccount(context, str, new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.ee("XGPushManager", "TPNS deleteAccount " + str + " failed, errCode =  " + i11 + ", msg = " + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.ii("XGPushManager", "TPNS deleteAccount " + str + " success");
                }
            });
        }
    }

    @Deprecated
    public static void upsertAccounts(Context context, final String str, int i11) {
        if (context == null || h.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
        } else {
            upsertAccounts(context, str, i11, new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.ee("XGPushManager", "TPNS appendAccount " + str + " failed, errCode =  " + i11 + ", msg = " + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.ii("XGPushManager", "TPNS appendAccount " + str + " success");
                }
            });
        }
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, final String str) {
        if (context == null || h.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of bindAccount is null.");
        } else {
            clearAndAppendAccount(context, str, (XGIOperateCallback) new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.ee("XGPushManager", "TPNS binderAccount " + str + " failed, errCode =  " + i11 + ", msg = " + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.ii("XGPushManager", "TPNS binderAccount " + str + " success");
                }
            });
        }
    }

    @Deprecated
    public static void upsertAccounts(Context context, final String str) {
        if (context == null || h.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
        } else {
            upsertAccounts(context, str, (XGIOperateCallback) new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.ee("XGPushManager", "TPNS appendAccount " + str + " failed, errCode =  " + i11 + ", msg = " + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.ii("XGPushManager", "TPNS appendAccount " + str + " success");
                }
            });
        }
    }

    private static void c(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            try {
                BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                    public void onReceive(Context context, final Intent intent) {
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        TLogger.ii("XGPushManager", "attributes call back to " + context.getPackageName());
                        try {
                            CommonWorkingThread.getInstance().execute(new TTask() {
                                public void TRun() {
                                    int intExtra = intent.getIntExtra("operation", -1);
                                    String stringExtra = intent.getStringExtra("data");
                                    if (stringExtra == null) {
                                        stringExtra = "";
                                    }
                                    if (intExtra == 0) {
                                        XGIOperateCallback.this.onSuccess(stringExtra, intent.getIntExtra("flag", -1));
                                    } else if (intExtra == 1) {
                                        XGIOperateCallback.this.onFail(stringExtra, intent.getIntExtra("code", -1), intent.getStringExtra(RemoteMessageConst.MessageBody.MSG));
                                    }
                                }
                            });
                        } catch (Throwable unused) {
                        }
                        j.a(context, (BroadcastReceiver) this);
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4"), 4);
            } catch (Throwable unused) {
            }
        }
        BroadcastAgent.sendBroadcast(context, intent);
    }

    private static void d(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            try {
                BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                    public void onReceive(Context context, final Intent intent) {
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        TLogger.ii("XGPushManager", "Tag call back to " + context.getPackageName());
                        try {
                            CommonWorkingThread.getInstance().execute(new TTask() {
                                public void TRun() {
                                    int intExtra = intent.getIntExtra("operation", -1);
                                    String stringExtra = intent.getStringExtra("data");
                                    if (stringExtra == null) {
                                        stringExtra = "";
                                    }
                                    if (intExtra == 0) {
                                        XGIOperateCallback.this.onSuccess(stringExtra, intent.getIntExtra("flag", -1));
                                    } else if (intExtra == 1) {
                                        XGIOperateCallback.this.onFail(stringExtra, intent.getIntExtra("code", -1), intent.getStringExtra(RemoteMessageConst.MessageBody.MSG));
                                    }
                                }
                            });
                        } catch (Throwable th2) {
                            TLogger.e("XGPushManager", "tagManager handle callback error " + th2.toString());
                        }
                        j.a(context, (BroadcastReceiver) this);
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.TAG.RESULT.V4"), 4);
            } catch (Throwable th2) {
                TLogger.e("XGPushManager", "tagManager registerReceiver error " + th2.toString());
            }
        }
        BroadcastAgent.sendBroadcast(context, intent);
    }

    public static void upsertAccounts(Context context, List<AccountInfo> list, XGIOperateCallback xGIOperateCallback) {
        String a11 = a(list);
        if (context == null || list == null || list.size() == 0 || TextUtils.isEmpty(a11)) {
            TLogger.ee("XGPushManager", "upsertAccounts | the parameter is illegal.");
            if (context != null && xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.CODE_INVALID_ACCOUNT;
                xGIOperateCallback.onFail("", returnCode.getType(), returnCode.getStr());
                return;
            }
            return;
        }
        b(context, a11, 0, (String) null, 6, "", xGIOperateCallback);
    }

    private static void c(Context context, String str, int i11, long j11, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        if (context != null) {
            final Context context2 = context;
            final String str4 = str;
            final int i12 = i11;
            final long j12 = j11;
            final String str5 = str2;
            final String str6 = str3;
            final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    if (!XGPushManager.b(context2) || !j.i(context2)) {
                        XGPushManager.registerPush(context2, new d(xGIOperateCallback2, new TTask() {
                            public void TRun() {
                                AnonymousClass8 r02 = AnonymousClass8.this;
                                XGPushManager.d(context2, str4, i12, j12, str5, str6, xGIOperateCallback2);
                            }
                        }, "tag"));
                        return;
                    }
                    XGPushManager.d(context2, str4, i12, j12, str5, str6, xGIOperateCallback2);
                }
            });
            return;
        }
        throw new IllegalArgumentException("The context parameter can not be null!");
    }

    /* access modifiers changed from: private */
    public static void c(Context context, Intent intent) {
        if (intent != null) {
            Intent intent2 = new Intent(com.tencent.android.tpush.common.Constants.ACTION_FEEDBACK);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_TAG, 4);
            intent2.putExtra(com.tencent.android.tpush.common.Constants.FEEDBACK_ERROR_CODE, 0);
            intent2.putExtras(intent);
            BroadcastAgent.sendBroadcast(context, intent2);
        }
    }

    private static void d(Context context, String str, int i11, String str2, XGIOperateCallback xGIOperateCallback, long j11, String str3, String str4, String str5, String str6, long j12) {
        final Context context2 = context;
        final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
        final long j13 = j11;
        final String str7 = str3;
        final long j14 = j12;
        final int i12 = i11;
        final String str8 = str;
        final String str9 = str2;
        final String str10 = str4;
        final String str11 = str6;
        final String str12 = str5;
        AnonymousClass24 r02 = new TTask() {
            public void TRun() {
                long j11;
                try {
                    int a11 = j.a(context2);
                    if (a11 != 0) {
                        XGIOperateCallback xGIOperateCallback = xGIOperateCallback2;
                        if (xGIOperateCallback != null) {
                            xGIOperateCallback.onFail("", a11, ReturnCode.errCodeToMsg(a11));
                            return;
                        }
                        return;
                    }
                    long j12 = j13;
                    long j13 = 0;
                    if (j12 <= 0) {
                        j12 = XGPushConfig.getAccessId(context2);
                    }
                    String accessKey = j.b(str7) ? XGPushConfig.getAccessKey(context2) : str7;
                    if (j12 <= 0 || j.b(accessKey)) {
                        XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback2;
                        int type = ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType();
                        xGIOperateCallback2.onFail("", type, "The accessId or accessKey is(are) invalid!@accessId:" + j12 + ", @accessKey:" + accessKey);
                        return;
                    }
                    try {
                        TLogger.ii("XGPushManager", "start other push channel register !");
                        XGPushManager.loadOtherPushToken(context2, true, j14);
                        Intent intent = new Intent(context2.getPackageName() + "com.tencent.android.xg.vip.action.REGISTER.V4");
                        intent.putExtra("accId", Rijndael.encrypt("" + j12));
                        intent.putExtra("accChannel", XGPushConfig.getChannelId(context2));
                        intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACC_KEY, Rijndael.encrypt(accessKey));
                        AccountInfo accountInfo = null;
                        if ((i12 >> 4) != 1) {
                            intent.putExtra("appVer", AppInfos.getCurAppVersion(context2));
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, Rijndael.encrypt(context2.getPackageName()));
                            String str = str8;
                            if (str != null) {
                                accountInfo = new AccountInfo(i12, str);
                                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_TICKET, Rijndael.encrypt(str8));
                            }
                            String str2 = str9;
                            if (str2 != null) {
                                intent.putExtra("qua", Rijndael.encrypt(str2));
                            }
                            intent.putExtra("operation", 100);
                            intent.putExtra("aidl", j.b(context2));
                        }
                        if (XGPushConfig.isUsedOtherPush(context2) && com.tencent.android.tpush.d.d.a(context2).l()) {
                            String k11 = com.tencent.android.tpush.d.d.a(context2).k();
                            String f11 = com.tencent.android.tpush.d.d.a(context2).f();
                            String g11 = com.tencent.android.tpush.d.d.a(context2).g();
                            TLogger.ii("XGPushManager", "other push token is : " + f11 + "  other push type: " + k11 + " other push region: " + g11);
                            if (!j.b(k11) && !j.b(f11)) {
                                intent.putExtra("channelToken", f11);
                                intent.putExtra("channelType", k11);
                                intent.putExtra("deviceRegion", g11);
                            }
                        }
                        intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_TICKET_TYPE, i12);
                        intent.putExtra("currentTimeMillis", System.currentTimeMillis());
                        intent.putExtra("opType", 0);
                        if (!j.b(str10)) {
                            intent.putExtra("url", str10);
                            j13 = 4;
                        }
                        if (!j.b(str11)) {
                            intent.putExtra("otherToken", str11);
                            j11 = !SharePrefsUtil.getString(context2, str11, "").equals(CacheManager.getToken(context2)) ? 2 : 3;
                        } else {
                            j11 = 1;
                        }
                        if (!j.b(str12)) {
                            intent.putExtra("payload", str12);
                        }
                        intent.putExtra("otherPushTokenOpType", j11);
                        intent.putExtra("otherPushType", j13);
                        TLogger.d("XGPushManager", "url = " + str10 + " payload = " + str12 + " otherPushType " + j13 + " otherPushTokenOpType " + j11);
                        Intent a12 = XGPushManager.b(context2, intent, xGIOperateCallback2, accountInfo);
                        if (i.a().b() && a12.getBooleanExtra("httpRegistedFail", false)) {
                            TLogger.d("XGPushManager", "use custom push proxy register failed, not use Tpns channel send register return");
                        } else if (!XGPushConfig.isUsedTpnsChannel(context2)) {
                            TLogger.d("XGPushManager", "registerPush not use Tpns channel service");
                        } else {
                            XGPushManager.safeSendQuest(context2, a12, xGIOperateCallback2, 0);
                            if (!j.a(XGPushConfig.getToken(context2))) {
                                try {
                                    TLogger.d("XGPushManager", "try to setup registerRunnable4NewDevice");
                                    XGPushManager.b(context2, str8, i12, str9, xGIOperateCallback2, j13, str7, str10, str12, str11, j14);
                                } catch (Throwable th2) {
                                    TLogger.e("XGPushManager", "doDumpRegister4NewDevice exe error", th2);
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        TLogger.w("XGPushManager", "exec registerTask failed:" + th3);
                    }
                } catch (Throwable th4) {
                    TLogger.e("XGPushManager", MiPushClient.COMMAND_REGISTER, th4);
                    XGIOperateCallback xGIOperateCallback3 = xGIOperateCallback2;
                    ReturnCode returnCode = ReturnCode.ERRORCODE_UNKNOWN;
                    int type2 = returnCode.getType();
                    xGIOperateCallback3.onFail("", type2, returnCode.getStr() + th4);
                }
            }
        };
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            CommonWorkingThread.getInstance().execute(r02);
        } else {
            r02.run();
        }
    }

    public static String a(Set<String> set, String str) {
        if (set == null) {
            TLogger.ee("XGPushManager", str + " -> the parameter tags is null.");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        Iterator<String> it2 = set.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            String replaceAll = it2.next().replaceAll(" ", "");
            if (replaceAll.length() > 50) {
                TLogger.ww("XGPushManager", str + " -> the tag:" + replaceAll + " length is more than 50, discard it");
            } else {
                if (i11 >= 500) {
                    if (!XGPushConfig.enableDebug) {
                        TLogger.ww("XGPushManager", str + " -> tags size is more than 500, discard some tags");
                        break;
                    }
                    TLogger.ww("XGPushManager", str + " -> tags size is " + (i11 + 1) + ", so discard tag:" + replaceAll);
                } else {
                    if (i11 != 0) {
                        sb2.append(" ");
                    }
                    sb2.append(replaceAll);
                }
                i11++;
            }
        }
        return sb2.toString();
    }

    private static void b(Context context, String str, long j11, String str2, int i11, String str3, XGIOperateCallback xGIOperateCallback) {
        if (context != null) {
            final Context context2 = context;
            final String str4 = str;
            final long j12 = j11;
            final String str5 = str2;
            final int i12 = i11;
            final String str6 = str3;
            final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    if (!XGPushManager.b(context2) || !j.i(context2)) {
                        XGPushManager.registerPush(context2, new d(xGIOperateCallback2, new TTask() {
                            public void TRun() {
                                AnonymousClass10 r02 = AnonymousClass10.this;
                                XGPushManager.a(context2, str4, j12, str5, i12, str6, xGIOperateCallback2);
                            }
                        }, com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT));
                        return;
                    }
                    XGPushManager.a(context2, str4, j12, str5, i12, str6, xGIOperateCallback2);
                }
            });
            return;
        }
        throw new IllegalArgumentException("The context parameter can not be null!");
    }

    public static void c(Context context, String str, int i11, String str2, XGIOperateCallback xGIOperateCallback, long j11, String str3, String str4, String str5, String str6, long j12) {
        d(context, str, i11, str2, xGIOperateCallback, j11, str3, str4, str5, str6, j12);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r5) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = com.tencent.android.tpush.XGPushConfig.getToken(r5)     // Catch:{ all -> 0x0035 }
            boolean r3 = com.tencent.android.tpush.common.j.b((java.lang.String) r2)     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x000d
            return r1
        L_0x000d:
            com.tencent.android.tpush.service.protocol.n r3 = new com.tencent.android.tpush.service.protocol.n     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.tencent.tpns.baseapi.base.util.CacheHelper$Key r0 = com.tencent.android.tpush.e.b.a.b()     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = com.tencent.tpns.baseapi.base.util.CacheHelper.get(r5, r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0033 }
            boolean r4 = com.tencent.android.tpush.common.j.b((java.lang.String) r0)     // Catch:{ all -> 0x0033 }
            if (r4 != 0) goto L_0x0026
            java.lang.String r0 = com.tencent.android.tpush.common.j.e((java.lang.String) r0)     // Catch:{ all -> 0x0033 }
        L_0x0026:
            r3.a(r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = r3.f69802b     // Catch:{ all -> 0x0033 }
            boolean r0 = com.tencent.android.tpush.common.j.b((java.lang.String) r0)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0037
            return r1
        L_0x0032:
            r3 = r0
        L_0x0033:
            r0 = r2
            goto L_0x0036
        L_0x0035:
            r3 = r0
        L_0x0036:
            r2 = r0
        L_0x0037:
            boolean r5 = com.tencent.tpns.baseapi.XGApiConfig.isRegistered(r5)     // Catch:{ all -> 0x0047 }
            if (r5 == 0) goto L_0x0047
            java.lang.String r5 = r3.f69802b     // Catch:{ all -> 0x0047 }
            boolean r5 = android.text.TextUtils.equals(r2, r5)     // Catch:{ all -> 0x0047 }
            if (r5 == 0) goto L_0x0047
            r5 = 1
            return r5
        L_0x0047:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushManager.b(android.content.Context):boolean");
    }

    /* access modifiers changed from: private */
    public static void c(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, int i11) {
        if (i11 == 0) {
            TLogger.d("XGPushManager", "send boardcast to register");
            f(context, intent, xGIOperateCallback);
        } else if (i11 == 1) {
            TLogger.d("XGPushManager", "send boardcast to unregister");
            g(context, intent, xGIOperateCallback);
        } else if (i11 == 2) {
            TLogger.d("XGPushManager", "send boardcast to tag");
            d(context, intent, xGIOperateCallback);
        } else if (i11 == 3) {
            TLogger.d("XGPushManager", "send boardcast to account");
            e(context, intent, xGIOperateCallback);
        } else if (i11 != 4) {
            TLogger.w("XGPushManager", "executeSendQuest , unsupport operatorType:" + i11);
        } else {
            TLogger.d("XGPushManager", "send boardcast to attributes");
            c(context, intent, xGIOperateCallback);
        }
    }

    private static String a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            TLogger.ee("XGPushManager", "getAttributesFromMap -> the parameter attributes is null.");
            return null;
        } else if (map.size() > 50) {
            return "out_size";
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getValue();
                    if (h.a(str)) {
                        return OptionsBridge.EMPTY_VALUE;
                    }
                    if (str.length() > 50) {
                        return "out_length";
                    }
                    jSONObject.put((String) next.getKey(), str);
                }
                return jSONObject.toString();
            } catch (Throwable th2) {
                TLogger.ww("XGPushManager", "unexpected for getAttributesFromMap", th2);
                return null;
            }
        }
    }

    public static void b(Context context, String str, int i11, String str2, XGIOperateCallback xGIOperateCallback, long j11, String str3, String str4, String str5, String str6, long j12) {
        a(context, str, i11, str2, xGIOperateCallback, j11, str3, str4, str5, str6, f67877d, j12);
    }

    /* access modifiers changed from: private */
    public static Intent b(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, AccountInfo accountInfo) {
        m a11;
        JSONObject jSONObject;
        if (context == null || intent == null || xGIOperateCallback == null) {
            TLogger.w("XGPushManager", "handleHttpRegister params error");
            return intent;
        }
        try {
            a11 = m.a(context, intent, false);
            jSONObject = null;
            if (a11 != null) {
                jSONObject = a11.a(context);
            }
        } catch (Throwable th2) {
            TLogger.w("XGPushManager", "handleHttpRegister  failed:" + th2);
        }
        if (a11 == null || jSONObject == null) {
            TLogger.w("XGPushManager", "handleHttpRegister  register json was null");
            return intent;
        }
        if (!j.b(jSONObject.toString())) {
            GUIDInfo finalGuidInfo = GuidInfoManager.getFinalGuidInfo(context, true, jSONObject.toString());
            if (finalGuidInfo != null) {
                if (!finalGuidInfo.isError()) {
                    xGIOperateCallback.onSuccess(finalGuidInfo.token, finalGuidInfo.errCode);
                    XGApiConfig.setRegisterSuccess(context);
                    String f11 = j.f(n.a(context, finalGuidInfo.token));
                    if (!j.b(f11)) {
                        String str = (String) CacheHelper.get(context, com.tencent.android.tpush.e.b.a.a(a11.f69775a + ""));
                        if (str == null || !TextUtils.equals(str, a11.f69796v)) {
                            CacheHelper.set(context, com.tencent.android.tpush.e.b.a.b().set(f11));
                        } else {
                            CacheHelper.set(context, com.tencent.android.tpush.e.b.a.b().set(f11));
                        }
                        com.tencent.android.tpush.service.util.c.a(a11.N);
                    }
                    intent.putExtra("lastNMd5str", a11.N);
                    intent.putExtra("token", finalGuidInfo.token);
                    intent.putExtra("hasRegisted", true);
                    intent.putExtra("invokedCallBack", true);
                    return intent;
                }
            }
            TLogger.w("XGPushManager", "handleHttpRegister error, guidInfo:" + finalGuidInfo);
            if (i.a().b()) {
                if (finalGuidInfo == null) {
                    xGIOperateCallback.onFail("", -5, "getFinalGuidInfo GUID is null");
                } else {
                    xGIOperateCallback.onFail("", finalGuidInfo.errCode, finalGuidInfo.result);
                }
                intent.putExtra("httpRegistedFail", true);
            }
            if (!XGPushConfig.isUsedTpnsChannel(context)) {
                xGIOperateCallback.onFail("", finalGuidInfo.errCode, finalGuidInfo.result);
                intent.putExtra("hasRegisted", false);
                intent.putExtra("invokedCallBack", false);
            }
        } else {
            TLogger.w("XGPushManager", "handleHttpRegister  register jsonStr was null");
        }
        return intent;
    }

    private static String a(Set<String> set) {
        if (set == null) {
            TLogger.ee("XGPushManager", "getAttributesFromSet -> the parameter attributes is null.");
            return null;
        } else if (set.size() > 50) {
            return "out_size";
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String next : set) {
                    if (next.length() > 50) {
                        return "out_length";
                    }
                    jSONObject.put(next, "0");
                }
                return jSONObject.toString();
            } catch (Throwable th2) {
                TLogger.ww("XGPushManager", "unexpected for getAttributesFromSet", th2);
                return null;
            }
        }
    }

    private static boolean a(String str, String str2) {
        if (h.a(str2)) {
            TLogger.ee("XGPushManager", str + " -> getAttributesFromMap return null!!!");
            return false;
        } else if (OptionsBridge.EMPTY_VALUE.equals(str2)) {
            TLogger.ee("XGPushManager", str + " -> the parameter attributes has empty value!");
            return false;
        } else if ("out_length".equals(str2)) {
            TLogger.ee("XGPushManager", str + " -> the parameter attribute_name or attribute_value length is out of limit:50");
            return false;
        } else if (!"out_size".equals(str2)) {
            return true;
        } else {
            TLogger.ee("XGPushManager", str + " -> the parameter attributes size is out of limit:50");
            return false;
        }
    }

    public static void a(Context context, String str, int i11, long j11, String str2, String str3) {
        c(context, str, i11, j11, str2, str3, (XGIOperateCallback) null);
    }

    public static void a(Context context, String str, int i11, long j11, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        c(context, str, i11, j11, str2, str3, xGIOperateCallback);
    }

    public static void a(Context context, String str, long j11, String str2, int i11, String str3, XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            TLogger.ww("XGPushManager", "The context parameter can not be null!");
            if (xGIOperateCallback != null) {
                ReturnCode returnCode = ReturnCode.ERRORCODE_UNKNOWN;
                xGIOperateCallback.onFail("", returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()));
            }
        } else if (j.a(context) > 0) {
            TLogger.i("XGPushManager", "accountManager initGlobal failed");
            if (xGIOperateCallback != null) {
                ReturnCode returnCode2 = ReturnCode.ERRORCODE_UNKNOWN;
                xGIOperateCallback.onFail("", returnCode2.getType(), ReturnCode.errCodeToMsg(returnCode2.getType()));
            }
        } else {
            final String str4 = str;
            final long j12 = j11;
            final Context context2 = context;
            final int i12 = i11;
            final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
            final String str5 = str3;
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    try {
                        String str = str4;
                        if (str == null) {
                            str = "";
                        }
                        String str2 = str;
                        long j11 = j12;
                        if (j11 <= 0) {
                            j11 = XGPushConfig.getAccessId(context2);
                        }
                        long j12 = j11;
                        if (j12 < 0) {
                            throw new IllegalArgumentException("The accessId not set!");
                        } else if (XGPushConfig.isUsedHttpAccountOperate(context2)) {
                            com.tencent.android.tpush.common.a.a(context2, str2, j12, i12, xGIOperateCallback2);
                        } else {
                            String accessKey = XGPushConfig.getAccessKey(context2);
                            Intent intent = new Intent(context2.getPackageName() + "com.tencent.android.xg.vip.action.ACCOUNT.V4");
                            intent.putExtra("accId", j12);
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACC_KEY, Rijndael.encrypt(accessKey));
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT_OP_TYPE, i12);
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT, Rijndael.encrypt(str4));
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT_FEEDBACK, str5);
                            intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, Rijndael.encrypt(context2.getPackageName()));
                            XGPushManager.safeSendQuest(context2, intent, xGIOperateCallback2, 3);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt == 12) {
                sb2.append("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            sb2.append("\\b");
                            break;
                        case 9:
                            sb2.append("\\t");
                            break;
                        case 10:
                            sb2.append("\\n");
                            break;
                        default:
                            if (charAt > 31) {
                                sb2.append(charAt);
                                break;
                            } else {
                                sb2.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                break;
                            }
                    }
                } else {
                    sb2.append('\\');
                    sb2.append(charAt);
                }
            } else {
                sb2.append("\\r");
            }
        }
        return sb2.toString();
    }

    public static XGPushClickedResult a(final Activity activity) {
        TLogger.ii("XGPushManager", ">>> onActivityStarted activity=" + activity);
        if (activity == null || activity.getIntent() == null) {
            return null;
        }
        final Intent intent = activity.getIntent();
        if (!"true".equalsIgnoreCase(intent.getStringExtra(com.tencent.android.tpush.common.Constants.TAG_TPUSH_MESSAGE)) || j.a(activity.getApplicationContext()) > 0) {
            return null;
        }
        XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
        xGPushClickedResult.parseIntent(intent);
        intent.removeExtra(com.tencent.android.tpush.common.Constants.TAG_TPUSH_MESSAGE);
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                XGPushManager.a((Context) activity, intent);
                XGPushManager.c(activity, intent);
            }
        });
        return xGPushClickedResult;
    }

    private static String b(Set<Integer> set) {
        if (set != null && set.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (Integer put : set) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT, "");
                    jSONObject.put("account_type", put);
                    jSONArray.put(jSONObject);
                }
                TLogger.d("XGPushManager", "getAccountTypeSetJson | " + jSONArray.toString());
                return jSONArray.toString();
            } catch (Throwable th2) {
                TLogger.ww("XGPushManager", "getAccountTypeSetJson:", th2);
            }
        }
        return null;
    }

    public static long a(Context context, XGLocalMessage xGLocalMessage, long j11) {
        if (context == null || xGLocalMessage == null) {
            TLogger.e("XGPushManager", "addLocalNotification context == null or msg == null");
            return -1;
        }
        try {
            if (!Security.checkTpnsSecurityLibSo(context)) {
                return -1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            final long j12 = j11;
            final Context context2 = context;
            final XGLocalMessage xGLocalMessage2 = xGLocalMessage;
            final long j13 = currentTimeMillis;
            AnonymousClass16 r42 = new TTask() {
                public void TRun() {
                    try {
                        long j11 = j12;
                        if (j11 <= 0) {
                            j11 = XGPushConfig.getAccessId(context2);
                        }
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append(j11);
                        sb2.append(xGLocalMessage2.getMsgId());
                        sb2.append(context2.getPackageName());
                        String str = "";
                        sb2.append(TextUtils.isEmpty(xGLocalMessage2.getTitle()) ? str : xGLocalMessage2.getTitle());
                        sb2.append(TextUtils.isEmpty(xGLocalMessage2.getContent()) ? str : xGLocalMessage2.getContent());
                        String custom_content = xGLocalMessage2.getCustom_content();
                        if (TextUtils.isEmpty(custom_content) || new JSONObject(custom_content).length() == 0) {
                            custom_content = str;
                        }
                        sb2.append(custom_content);
                        if (xGLocalMessage2.getType() == 1) {
                            sb2.append(TextUtils.isEmpty(xGLocalMessage2.getUrl()) ? str : xGLocalMessage2.getUrl());
                            sb2.append(TextUtils.isEmpty(xGLocalMessage2.getIntent()) ? str : xGLocalMessage2.getIntent());
                            if (!TextUtils.isEmpty(xGLocalMessage2.getActivity())) {
                                str = xGLocalMessage2.getActivity();
                            }
                            sb2.append(str);
                        }
                        String sb3 = sb2.toString();
                        long expirationTimeMs = xGLocalMessage2.getExpirationTimeMs();
                        TLogger.i("XGPushManager", sb3 + ",tag:" + (com.tencent.android.tpush.common.Constants.LOCAL_MESSAGE_FLAG + Md5.md5(sb3)) + ",exp:" + expirationTimeMs);
                        com.tencent.android.tpush.service.protocol.j jVar = new com.tencent.android.tpush.service.protocol.j();
                        jVar.f69741a = xGLocalMessage2.getMsgId();
                        jVar.f69742b = j11;
                        jVar.f69747g = context2.getPackageName();
                        jVar.f69743c = xGLocalMessage2.getBusiMsgId();
                        long j12 = j13;
                        jVar.f69748h = j12 / 1000;
                        jVar.f69751k = -j12;
                        jVar.f69752l = xGLocalMessage2.getTtl();
                        jVar.f69746f = (long) xGLocalMessage2.getType();
                        jVar.f69749i = 0;
                        jVar.f69750j = xGLocalMessage2.getDate();
                        jVar.f69745e = "{\"title\":\"" + xGLocalMessage2.getTitle() + "\",\"content\":\"" + XGPushManager.b(xGLocalMessage2.getContent()) + "\",\"builder_id\":" + xGLocalMessage2.getBuilderId() + ",\"custom_content\":" + xGLocalMessage2.getCustom_content() + ",\"ring\":" + xGLocalMessage2.getRing() + ",\"vibrate\":" + xGLocalMessage2.getVibrate() + ",\"lights\":" + xGLocalMessage2.getLights() + ",\"n_id\":" + xGLocalMessage2.getNotificationId() + ",\"is_show_type\":" + xGLocalMessage2.getNsModel() + ", \"n_ch_id\":\"" + xGLocalMessage2.getChannelId() + "\", \"n_importance\":" + xGLocalMessage2.getNotificationImportance() + ", \"n_category\":\"" + xGLocalMessage2.getNotificationCategory() + "\",\"ring_raw\":\"" + xGLocalMessage2.getRing_raw() + "\",\"icon_type\":" + xGLocalMessage2.getIcon_type() + ",\"color\":" + xGLocalMessage2.getColor() + ",\"icon_res\":\"" + xGLocalMessage2.getIcon_res() + "\",\"xg_media_resources\":\"" + xGLocalMessage2.getTpns_media_resources() + "\",\"style_id\":" + xGLocalMessage2.getStyle_id() + ",\"small_icon\":\"" + xGLocalMessage2.getSmall_icon() + "\",\"badge_type\":" + xGLocalMessage2.getBadgeType() + ",\"thread_id\":\"" + xGLocalMessage2.getThreadId() + "\",\"thread_sumtext\":\"" + xGLocalMessage2.getThreadSumText() + "\",\"clearable\":1,\"accept_time\":[{\"start\":{\"hour\":\"" + xGLocalMessage2.getHour() + "\",\"min\":\"" + xGLocalMessage2.getMin() + "\"},\"end\":{\"hour\":\"23\",\"min\":\"59\"}}],\"action\":{\"action_type\":" + xGLocalMessage2.getAction_type() + ",\"activity\":\"" + xGLocalMessage2.getActivity() + "\",\"browser\":{\"url\":\"" + xGLocalMessage2.getUrl() + "\"},\"intent\":\"" + xGLocalMessage2.getIntent() + "\",\"package_name\":{\"packageDownloadUrl\":\"" + xGLocalMessage2.getPackageDownloadUrl() + "\",\"packageName\":\"" + xGLocalMessage2.getPackageName() + "\"}}}";
                        XGLocalMessage xGLocalMessage = xGLocalMessage2;
                        jVar.f69760t = xGLocalMessage.targetType;
                        jVar.f69761u = xGLocalMessage.source;
                        jVar.f69763w = xGLocalMessage.templateId;
                        jVar.f69764x = xGLocalMessage.traceId;
                        com.tencent.android.tpush.service.channel.a aVar = new com.tencent.android.tpush.service.channel.a(0, "127.0.0.1");
                        Intent intent = new Intent(com.tencent.android.tpush.common.Constants.ACTION_INTERNAL_PUSH_MESSAGE);
                        intent.setPackage(jVar.f69747g);
                        intent.putExtra("msgId", jVar.f69741a);
                        intent.putExtra("content", Rijndael.encrypt(jVar.f69745e));
                        intent.putExtra(MessageKey.MSG_DATE, jVar.f69750j);
                        intent.putExtra("type", jVar.f69746f);
                        intent.putExtra("accId", jVar.f69742b);
                        intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, jVar.f69743c);
                        intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, jVar.f69748h);
                        intent.putExtra(MessageKey.MSG_CREATE_MULTIPKG, jVar.f69749i);
                        intent.putExtra("server_time", jVar.f69751k * 1000);
                        intent.putExtra("ttl", jVar.f69752l);
                        intent.putExtra(MessageKey.MSG_EXPIRE_TIME, expirationTimeMs);
                        intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, xGLocalMessage2.pushChannel);
                        intent.putExtra(MessageKey.MSG_PUSH_TIME, xGLocalMessage2.pushTime);
                        intent.putExtra("groupId", xGLocalMessage2.nGroupId);
                        intent.putExtra(MessageKey.MSG_SERVICE_ACK, true);
                        intent.putExtra(MessageKey.MSG_EXTRA_HOST, j.d(aVar.b()));
                        intent.putExtra(MessageKey.MSG_EXTRA_PORT, aVar.c());
                        intent.putExtra(MessageKey.MSG_EXTRA_PACT, com.tencent.android.tpush.service.c.a(aVar.a()));
                        intent.putExtra(MessageKey.MSG_EXTRA_PUSHTIME, j13);
                        intent.putExtra(MessageKey.MSG_TARGET_TYPE, jVar.f69760t);
                        intent.putExtra("source", jVar.f69761u);
                        intent.putExtra(MessageKey.MSG_TEMPLATE_ID, jVar.f69763w);
                        intent.putExtra(MessageKey.MSG_TRACE_ID, jVar.f69764x);
                        e.a(context2).b(intent);
                    } catch (Throwable th2) {
                        TLogger.e("XGPushManager", "addLocalNotification ", th2);
                    }
                }
            };
            if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                CommonWorkingThread.getInstance().execute(r42);
            } else {
                r42.run();
            }
            return -currentTimeMillis;
        } catch (Throwable th2) {
            TLogger.e("XGPushManager", "addLocalNotification ", th2);
            return 0;
        }
    }

    private static void b(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, int i11) {
        j.f(context);
        b bVar = new b(context, intent, xGIOperateCallback, i11);
        try {
            BroadcastAgent.registerReceiver(context, bVar, new IntentFilter("com.tencent.android.xg.vip.action.SERVICE_START.V4"), 4);
        } catch (Throwable th2) {
            TLogger.e("XGPushManager", "Receiver not registered exception error : ", th2);
        }
        c cVar = new c(context, intent, xGIOperateCallback, i11);
        try {
            f67882i.put(bVar, cVar);
            CommonWorkingThread.getInstance().execute(cVar, 10000);
        } catch (Throwable th3) {
            TLogger.e("XGPushManager", "mapTimeRunnableOfMessage error", th3);
        }
    }

    public static void a(Context context, Intent intent) {
        MessageManager.getInstance().updateCachedMsgIntentToClick(context, intent.getLongExtra("msgId", -1));
        Intent intent2 = new Intent("com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4");
        intent2.putExtras(intent);
        intent2.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, context.getPackageName());
        intent2.putExtra(com.tencent.android.tpush.common.Constants.FLAG_CLICK_TIME, System.currentTimeMillis() / 1000);
        ServiceStat.appReportNotificationClicked(context, intent2);
        BroadcastAgent.sendBroadcast(context, intent2);
    }

    private static void a(Context context, Intent intent, String str) {
        if (context != null && intent != null && str != null) {
            Intent intent2 = new Intent(str);
            intent2.putExtras(intent);
            intent2.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME, context.getPackageName());
            intent2.putExtra(com.tencent.android.tpush.common.Constants.FLAG_CLICK_TIME, System.currentTimeMillis() / 1000);
            if ("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4".equals(str)) {
                intent2.putExtra("action", NotificationAction.delete.getType());
                ServiceStat.appReportNotificationCleared(context, intent2);
            } else if ("com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4".equals(str)) {
                intent2.putExtra("action", NotificationAction.clicked.getType());
                ServiceStat.appReportNotificationClicked(context, intent2);
            }
            BroadcastAgent.sendBroadcast(context, intent2);
        }
    }

    public static void a(Context context, String str, int i11, String str2, XGIOperateCallback xGIOperateCallback, long j11, String str3, String str4, String str5, String str6, long j12) {
        final Context context2 = context;
        final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
        final String str7 = str;
        final int i12 = i11;
        final String str8 = str2;
        final long j13 = j11;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final String str12 = str6;
        final long j14 = j12;
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                XGIOperateCallback xGIOperateCallback;
                if (context2 == null) {
                    xGIOperateCallback2.onFail("", ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context parameter can not be null!");
                } else if (XGPushManager.e()) {
                    XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback2;
                    if (xGIOperateCallback2 != null) {
                        ReturnCode returnCode = ReturnCode.CODE_SDK_API_FREQUENCY_LIMIT_ERROR;
                        xGIOperateCallback2.onFail("", returnCode.getType(), returnCode.getStr());
                    }
                } else if (NetworkUtil.isNetworkConnected(context2) || (xGIOperateCallback = xGIOperateCallback2) == null) {
                    com.tencent.android.tpush.service.util.c.f69845a = 1;
                    XGPushManager.initCommonComponents(context2);
                    Context applicationContext = context2.getApplicationContext();
                    if (!PushPreferences.getBoolean(applicationContext, com.tencent.android.tpush.common.Constants.KEY_START_SERVICE_BY_USER, false)) {
                        PushPreferences.putBoolean(applicationContext, com.tencent.android.tpush.common.Constants.KEY_START_SERVICE_BY_USER, true);
                    }
                    XGPushManager.setContext(applicationContext);
                    XGPushManager.enableService(applicationContext, true);
                    if (!XGPushManager.f67874a) {
                        ServiceStat.reportIsCustomDataAcquisitionVersion(applicationContext);
                        boolean unused = XGPushManager.f67874a = true;
                    }
                    Long unused2 = XGPushManager.f67876c = Long.valueOf(System.currentTimeMillis());
                    XGPushManager.c(applicationContext, str7, i12, str8, xGIOperateCallback2, j13, str9, str10, str11, str12, j14);
                } else {
                    xGIOperateCallback.onFail("", ReturnCode.CODE_NETWORK_UNREACHABLE.getType(), "no network, please check again!");
                }
            }
        });
    }

    public static void a(Context context, String str, int i11, String str2, XGIOperateCallback xGIOperateCallback, long j11, String str3, String str4, String str5, String str6, long j12, long j13) {
        if (f67878e != null) {
            TLogger.d("XGPushManager", "update registerRunnable4NewDevice");
            CommonWorkingThread.getInstance().remove(f67878e);
        }
        final long j14 = j12;
        final Context context2 = context;
        final String str7 = str;
        final int i12 = i11;
        final String str8 = str2;
        final long j15 = j11;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final String str12 = str6;
        final long j16 = j13;
        f67878e = new TTask() {
            public void TRun() {
                try {
                    AnonymousClass1 r52 = new XGIOperateCallback() {
                        public void onFail(Object obj, int i11, String str) {
                            TLogger.d("XGPushManager", "registerRunnable4NewDevice failed, token:" + obj + ",errCode:" + i11 + ",msg:" + str + ",delayMillis:" + j14);
                        }

                        public void onSuccess(Object obj, int i11) {
                            TLogger.d("XGPushManager", "registerRunnable4NewDevice success, token:" + obj + ",delayMillis:" + j14);
                        }
                    };
                    TLogger.d("XGPushManager", "registerRunnable4NewDevice, delayMillis:" + j14 + ",registerRunnable4NewDevice:" + XGPushManager.f67878e);
                    XGPushManager.c(context2, str7, i12, str8, r52, j15, str9, str10, str11, str12, j16);
                } catch (Throwable th2) {
                    TLogger.e("XGPushManager", "doDumpRegister4NewDevice run error", th2);
                }
            }
        };
        CommonWorkingThread.getInstance().execute(f67878e, j12);
    }

    private static String a(Context context, long j11) {
        try {
            if (XGPushConfig.isUsedOtherPush(context) && com.tencent.android.tpush.d.d.a(context).m()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (j11 < 0 || j11 > 4000) {
                    TLogger.ii("XGPushManager", "invalid sync wait other channel push time:" + j11 + ", reset to 4s ");
                    j11 = 4000;
                }
                int i11 = 1000;
                int i12 = ((int) j11) / 2;
                if (i12 != 0 && 1000 > i12) {
                    i11 = 20;
                    if (i12 > 20) {
                        i11 = i12;
                    }
                }
                do {
                    String h11 = com.tencent.android.tpush.d.d.a(context).h();
                    if (!j.b(h11)) {
                        TLogger.ii("XGPushManager", "get chanelToken is : " + h11);
                        com.tencent.android.tpush.d.d.a(context).q();
                        return h11;
                    }
                    String i13 = com.tencent.android.tpush.d.d.a(context).i();
                    if (!j.b(i13)) {
                        TLogger.ii("XGPushManager", "get fcmToken is : " + i13);
                        com.tencent.android.tpush.d.d.a(context).q();
                        return i13;
                    } else if (j11 != 0) {
                        Thread.sleep((long) i11);
                    }
                } while (System.currentTimeMillis() - currentTimeMillis < j11);
            }
        } catch (InterruptedException unused) {
            TLogger.e("XGPushManager", "OtherPush: call getToken InterruptedException!");
            return null;
        } catch (Throwable unused2) {
        }
        TLogger.i("XGPushManager", "Can't get otherPush token ");
        return null;
    }

    private static String a(List<AccountInfo> list) {
        if (!(list == null || list.size() == 0)) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (AccountInfo next : list) {
                    if (next != null && !j.b(next.accountName)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT, next.accountName);
                        jSONObject.put("account_type", next.accountType);
                        jSONArray.put(jSONObject);
                    }
                }
                TLogger.d("XGPushManager", "getAccountInfosJsonArrayString | " + jSONArray.toString());
                if (jSONArray.length() > 0) {
                    return jSONArray.toString();
                }
            } catch (Throwable th2) {
                TLogger.ww("XGPushManager", "getAccountInfosJsonArrayString | ", th2);
            }
        }
        return "";
    }

    private static String a(String str, int i11) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account_type", i11);
            if (i11 == AccountType.PHONE_NUMBER.getValue()) {
                str = bytesToHex(Security.encryptSrvData(str.getBytes()));
            }
            jSONObject.put(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT, str);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Throwable th2) {
            TLogger.ww("XGPushManager", "getTypeAccountsJsonArrayStr:", th2);
            return null;
        }
    }
}
