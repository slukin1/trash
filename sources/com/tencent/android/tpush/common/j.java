package com.tencent.android.tpush.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.sumsub.sns.internal.ml.autocapture.a;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.XGPushReceiver;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.util.g;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.android.tpush.stat.StatServiceImpl;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttTools;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.x500.X500Principal;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static String f68924a = null;

    /* renamed from: b  reason: collision with root package name */
    private static AtomicBoolean f68925b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static boolean f68926c = false;

    /* renamed from: d  reason: collision with root package name */
    private static final X500Principal f68927d = new X500Principal("CN=Android Debug,O=Android,C=US");

    /* renamed from: e  reason: collision with root package name */
    private static String f68928e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f68929f = "";

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        try {
            return Float.valueOf(str2.replace(InstructionFileId.DOT, "")).floatValue() > Float.valueOf(str.replace(InstructionFileId.DOT, "")).floatValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        TLogger.d("Util", "action getServiceStatus");
        if (context == null) {
            return 0;
        }
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null || runningServices.size() <= 0) {
                return 0;
            }
            String name = XGVipPushService.class.getName();
            for (ActivityManager.RunningServiceInfo next : runningServices) {
                String className = next.service.getClassName();
                String packageName = next.service.getPackageName();
                if (name.equals(className) && packageName.equals(context.getPackageName())) {
                    return next.pid != 0 ? 1 : 2;
                }
            }
            return 0;
        } catch (Throwable th2) {
            TLogger.e("Util", "getServiceStatus", th2);
            return 0;
        }
    }

    public static void d(Context context) {
        TLogger.d("Util", "action getServiceStatus");
        if (context != null) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
                if (runningServices != null && runningServices.size() > 0) {
                    String name = XGVipPushService.class.getName();
                    for (ActivityManager.RunningServiceInfo next : runningServices) {
                        String className = next.service.getClassName();
                        String packageName = next.service.getPackageName();
                        if (name.equals(className) && packageName.equals(context.getPackageName()) && !TextUtils.isEmpty(next.process) && !TextUtils.equals(next.process, context.getPackageName())) {
                            Logger.d("Util", "xgvipPushservice process:" + next.process);
                            int i11 = next.pid;
                            if (i11 != 0) {
                                Process.killProcess(i11);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                TLogger.e("Util", "getServiceStatus", th2);
            }
        }
    }

    public static void e(Context context) {
        TLogger.d("Util", "startCurrentAppService " + context.getPackageName());
        context.startService(new Intent(context, XGVipPushService.class));
    }

    public static void f(final Context context) {
        if (context == null) {
            return;
        }
        if (!XGPushConfig.isUsedTpnsChannel(context)) {
            TLogger.ii("Util", "startService abolish, not use Tpns channel service");
            return;
        }
        try {
            if (g.a(context.getPackageName())) {
                e(context);
                return;
            }
            b.b(context.getApplicationContext());
            b.a(context);
            TLogger.v("Util", "Action -> start Local Service()");
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    if (j.c(context) != 1) {
                        try {
                            TLogger.v("Util", "Action2 -> start Local Service()");
                            b.a(context);
                        } catch (Throwable th2) {
                            TLogger.e("Util", "CommonWorkingThread StartService", th2);
                        }
                    }
                }
            }, a.f34923p);
        } catch (Throwable th2) {
            TLogger.e("Util", "StartService", th2);
        }
    }

    public static void g(Context context) {
        if (context != null && !f68926c) {
            try {
                f(context, XGVipPushService.class.getName());
                f(context, TpnsActivity.class.getName());
                f(context, XGPushProvider.class.getName());
                f(context, SettingsContentProvider.class.getName());
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                int length = activityInfoArr.length;
                int i11 = 0;
                while (i11 < length) {
                    String str = activityInfoArr[i11].name;
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass(str);
                        if (XGPushBaseReceiver.class.isAssignableFrom(loadClass) || loadClass.getName().equals(XGPushReceiver.class.getName())) {
                            f(context, str);
                            i11++;
                        } else {
                            i11++;
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                }
            } catch (Throwable th2) {
                TLogger.e("Util", "enableComponents", th2);
            }
            f68926c = true;
        }
    }

    public static void h(final Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        String b11 = j.b();
                        TLogger.i("filter components", "deviceType: " + b11);
                        if (!ChannelUtils.isBrandXiaoMi() && !ChannelUtils.isBrandBlackShark() && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-xiaomi", Boolean.TRUE)).booleanValue()) {
                            j.b(packageManager, context, "com.xiaomi.push.service.XMPushService");
                            j.b(packageManager, context, "com.xiaomi.push.service.XMJobService");
                            j.b(packageManager, context, "com.xiaomi.mipush.sdk.PushMessageHandler");
                            j.b(packageManager, context, "com.xiaomi.mipush.sdk.MessageHandleService");
                            j.b(packageManager, context, "com.xiaomi.push.service.receivers.NetworkStatusReceiver");
                            j.b(packageManager, context, "com.xiaomi.push.service.receivers.PingReceiver");
                            j.b(packageManager, context, "com.tencent.android.mipush.XMPushMessageReceiver");
                        }
                        if (!ChannelUtils.isBrandHuaWei() && !ChannelUtils.isBrandHonor() && !ChannelUtils.isEmuiOrOhosVersion()) {
                            TLogger.i("filter components", "disable device huawei");
                            if (((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-huawei-v4", Boolean.TRUE)).booleanValue()) {
                                j.b(packageManager, context, "com.huawei.agconnect.core.provider.AGConnectInitializeProvider");
                                j.b(packageManager, context, "com.huawei.agconnect.core.ServiceDiscovery");
                                j.b(packageManager, context, "com.tencent.android.hwpushv3.HWHmsMessageService");
                                j.b(packageManager, context, "com.huawei.hms.support.api.push.PushMsgReceiver");
                                j.b(packageManager, context, "com.huawei.hms.support.api.push.PushReceiver");
                                j.b(packageManager, context, "com.huawei.hms.support.api.push.PushProvider");
                            }
                        }
                        if (!ChannelUtils.isBrandMeiZu() && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-meizu", Boolean.TRUE)).booleanValue()) {
                            j.b(packageManager, context, "com.tencent.android.mzpush.MZPushMessageReceiver");
                            j.b(packageManager, context, "com.meizu.cloud.pushsdk.SystemReceiver");
                            j.b(packageManager, context, "com.meizu.cloud.pushsdk.NotificationService");
                        }
                        if (!MTPushConstants.Manufacturer.OPPO.equals(b11) && !MTPushConstants.Manufacturer.ONEPLUS.equals(b11) && !MTPushConstants.Manufacturer.REALME.equals(b11) && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-oppo", Boolean.TRUE)).booleanValue()) {
                            j.b(packageManager, context, "com.heytap.msp.push.service.CompatibleDataMessageCallbackService");
                            j.b(packageManager, context, "com.heytap.msp.push.service.DataMessageCallbackService");
                        }
                        if (!"vivo".equals(b11) && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-vivo", Boolean.TRUE)).booleanValue()) {
                            j.b(packageManager, context, "com.vivo.push.sdk.service.CommandClientService");
                            j.b(packageManager, context, "com.vivo.push.sdk.LinkProxyClientActivity");
                            j.b(packageManager, context, "com.tencent.android.vivopush.VivoPushMessageReceiver");
                        }
                    }
                } catch (Throwable th2) {
                    TLogger.w("Util", "unexpected for disableComponents", th2);
                }
            }
        });
    }

    public static boolean i(Context context) {
        return XGApiConfig.isEnableService(context);
    }

    public static void j(Context context) {
        try {
            if (MTPushConstants.Manufacturer.OPPO.equals(b())) {
                Intent intent = new Intent("oppo.safecenter.intent.action.CHANGE_NOTIFICATION_STATE");
                intent.putExtra(Constants.PACKAGE_NAME, context.getPackageName());
                intent.putExtra("allow_notify", true);
                BroadcastAgent.sendBroadcast(context, intent);
            }
        } catch (Throwable th2) {
            TLogger.d("openNotification", "openNotification", th2);
        }
    }

    public static void k(Context context) {
        String b11 = b();
        if (!MTPushConstants.Manufacturer.MEIZU.equals(b11) && MTPushConstants.Manufacturer.OPPO.equals(b11)) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity");
                intent.setAction("com.coloros.notificationmanager.app.detail");
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                intent.putExtra("pkg_name", context.getPackageName());
                intent.putExtra("app_name", AppInfos.getApplicationName(context));
                intent.putExtra("class_name", context.getPackageName());
                context.startActivity(intent);
            } catch (Throwable th2) {
                TLogger.d("Util", "openNotificationSettings", th2);
            }
        }
    }

    public static void l(Context context) {
        String a11 = a(context, "otherpush_config.json");
        if (!b(a11)) {
            try {
                JSONObject jSONObject = new JSONObject(a11);
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("xiaomi");
                    if (optJSONObject != null) {
                        d.f68945a = optJSONObject.optString("appid", (String) null);
                        d.f68946b = optJSONObject.optString("appkey", (String) null);
                    }
                } catch (Throwable unused) {
                }
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(MTPushConstants.Manufacturer.MEIZU);
                    if (optJSONObject2 != null) {
                        d.f68947c = optJSONObject2.optString("appid", (String) null);
                        d.f68948d = optJSONObject2.optString("appkey", (String) null);
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th2) {
                TLogger.e("Util", "", th2);
            }
        }
    }

    public static String m(Context context) {
        try {
            if (b(f68928e)) {
                f68928e = String.valueOf(CommonHelper.getMetaData(context, Constants.HUAWEI_HMS_CLIENT_APPID, ""));
            }
            if (TextUtils.isEmpty(f68928e)) {
                f68928e = d.f68952h;
            }
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for getHwConfig");
        }
        return f68928e;
    }

    public static String n(Context context) {
        try {
            if (b(f68929f)) {
                f68929f = String.valueOf(CommonHelper.getMetaData(context, "com.vivo.push.app_id", ""));
            }
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for getVivoConfig");
        }
        return f68929f;
    }

    public static boolean o(Context context) {
        try {
            return ((Boolean) CommonHelper.getMetaData(context, "ENABLE_OTHER_PUSH", Boolean.FALSE)).booleanValue();
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for init isUsedOtherPush4Plugin");
            return false;
        }
    }

    public static byte p(Context context) {
        byte type = MobileType.UNKNOWN.getType();
        if (context == null) {
            return type;
        }
        try {
            String simOperator = CustomDeviceInfos.getSimOperator(context);
            if (simOperator == null) {
                return type;
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                if (!simOperator.equals("46020")) {
                    if (!simOperator.equals("46001")) {
                        if (!simOperator.equals("46006")) {
                            if (simOperator.equals("46003") || simOperator.equals("46005")) {
                                return MobileType.TELCOM.getType();
                            }
                            return type;
                        }
                    }
                    return MobileType.UNICOM.getType();
                }
            }
            return MobileType.CHINAMOBILE.getType();
        } catch (Throwable th2) {
            TLogger.e("Util", "getIsp", th2);
            return type;
        }
    }

    public static String q(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
                if (next.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                    return next.activityInfo.name;
                }
            }
            return "";
        } catch (Throwable th2) {
            TLogger.e("Util", "get launcher class name error: " + th2.toString());
            return "";
        }
    }

    private static void r(final Context context) {
        try {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    TLogger.d("Util", "load sdk config data");
                    XGPushConfig.getAccessId(context);
                    XGPushConfig.getAccessKey(context);
                    XGPushConfig.getToken(context);
                }
            });
        } catch (Throwable th2) {
            TLogger.w("Util", "loadConfigData error: " + th2.toString());
        }
    }

    private static void s(final Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            try {
                new Thread(new TTask() {
                    /* JADX WARNING: Can't wrap try/catch for region: R(20:3|4|5|(4:7|8|9|(1:11))(2:12|13)|14|15|16|17|18|(2:20|(4:23|(2:26|83)|80|21))|27|28|29|30|(4:32|(2:33|(1:35)(1:84))|36|(1:38)(2:39|(2:41|(1:43))))(1:44)|45|46|49|50|87) */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00e1 */
                    /* JADX WARNING: Removed duplicated region for block: B:32:0x012c A[Catch:{ all -> 0x0230 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:44:0x0208 A[Catch:{ all -> 0x0230 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:59:0x023c A[SYNTHETIC, Splitter:B:59:0x023c] */
                    /* JADX WARNING: Removed duplicated region for block: B:64:0x0246 A[SYNTHETIC, Splitter:B:64:0x0246] */
                    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void TRun() {
                        /*
                            r15 = this;
                            java.lang.String r0 = "checkVersionUpdate"
                            java.lang.String r1 = "UTF-8"
                            java.lang.String r2 = "1.4.4.2"
                            java.lang.String r3 = "conn.disconnect()"
                            java.lang.String r4 = "outStream.close()"
                            java.lang.String r5 = ""
                            java.lang.String r6 = "Util"
                            android.content.Context r7 = r3
                            java.lang.String r7 = com.tencent.android.tpush.XGPushConfig.getToken(r7)
                            boolean r7 = android.text.TextUtils.isEmpty(r7)
                            if (r7 == 0) goto L_0x001b
                            return
                        L_0x001b:
                            r7 = 0
                            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0235 }
                            r8.<init>()     // Catch:{ all -> 0x0235 }
                            java.lang.String r9 = "sdkStatus"
                            r10 = 1
                            r8.put(r9, r10)     // Catch:{ all -> 0x0235 }
                            java.lang.String r9 = "sdkType"
                            java.lang.String r11 = "android"
                            r8.put(r9, r11)     // Catch:{ all -> 0x0235 }
                            java.lang.String r9 = "sdkVersion"
                            r8.put(r9, r2)     // Catch:{ all -> 0x0235 }
                            java.net.URL r9 = new java.net.URL     // Catch:{ all -> 0x0235 }
                            java.lang.String r11 = "https://log.tpns.tencent.com/device/v4/sdk/list"
                            r9.<init>(r11)     // Catch:{ all -> 0x0235 }
                            java.lang.String r11 = r9.getProtocol()     // Catch:{ all -> 0x0235 }
                            java.lang.String r11 = r11.toLowerCase()     // Catch:{ all -> 0x0235 }
                            java.lang.String r12 = "https"
                            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0235 }
                            if (r11 == 0) goto L_0x0068
                            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ all -> 0x0235 }
                            javax.net.ssl.HttpsURLConnection r9 = (javax.net.ssl.HttpsURLConnection) r9     // Catch:{ all -> 0x0235 }
                            org.apache.http.conn.ssl.X509HostnameVerifier r11 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ all -> 0x0233 }
                            r9.setHostnameVerifier(r11)     // Catch:{ all -> 0x0233 }
                            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0233 }
                            r12 = 20
                            if (r11 >= r12) goto L_0x006e
                            com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory r11 = new com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory     // Catch:{ all -> 0x0233 }
                            javax.net.ssl.SSLSocketFactory r12 = r9.getSSLSocketFactory()     // Catch:{ all -> 0x0233 }
                            r11.<init>(r12)     // Catch:{ all -> 0x0233 }
                            r9.setSSLSocketFactory(r11)     // Catch:{ all -> 0x0233 }
                            goto L_0x006e
                        L_0x0068:
                            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ all -> 0x0235 }
                            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ all -> 0x0235 }
                        L_0x006e:
                            r11 = 15000(0x3a98, float:2.102E-41)
                            r9.setReadTimeout(r11)     // Catch:{ all -> 0x0233 }
                            r9.setDoInput(r10)     // Catch:{ all -> 0x0233 }
                            r9.setDoOutput(r10)     // Catch:{ all -> 0x0233 }
                            r10 = 0
                            r9.setUseCaches(r10)     // Catch:{ all -> 0x0233 }
                            java.lang.String r12 = "POST"
                            r9.setRequestMethod(r12)     // Catch:{ all -> 0x0233 }
                            java.lang.String r12 = "Content-Type"
                            java.lang.String r13 = "json"
                            r9.setRequestProperty(r12, r13)     // Catch:{ all -> 0x0233 }
                            r9.setConnectTimeout(r11)     // Catch:{ all -> 0x0233 }
                            android.content.Context r11 = r3     // Catch:{ all -> 0x0233 }
                            long r11 = com.tencent.tpns.baseapi.XGApiConfig.getAccessId(r11)     // Catch:{ all -> 0x0233 }
                            android.content.Context r13 = r3     // Catch:{ all -> 0x0233 }
                            java.lang.String r13 = com.tencent.tpns.baseapi.XGApiConfig.getAccessKey(r13)     // Catch:{ all -> 0x0233 }
                            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
                            r14.<init>()     // Catch:{ all -> 0x00e1 }
                            r14.append(r11)     // Catch:{ all -> 0x00e1 }
                            r14.append(r5)     // Catch:{ all -> 0x00e1 }
                            java.lang.String r11 = r14.toString()     // Catch:{ all -> 0x00e1 }
                            java.lang.String r12 = r8.toString()     // Catch:{ all -> 0x00e1 }
                            byte[] r12 = r12.getBytes(r1)     // Catch:{ all -> 0x00e1 }
                            java.util.Map r11 = com.tencent.tpns.baseapi.base.util.HttpHelper.getSignAuthHeader(r11, r13, r12)     // Catch:{ all -> 0x00e1 }
                            if (r11 == 0) goto L_0x00e1
                            java.util.Set r11 = r11.entrySet()     // Catch:{ all -> 0x00e1 }
                            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x00e1 }
                        L_0x00bd:
                            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x00e1 }
                            if (r12 == 0) goto L_0x00e1
                            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x00e1 }
                            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ all -> 0x00e1 }
                            java.lang.Object r13 = r12.getKey()     // Catch:{ all -> 0x00e1 }
                            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00e1 }
                            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x00e1 }
                            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x00e1 }
                            boolean r14 = com.tencent.tpns.baseapi.base.util.Util.isNullOrEmptyString(r13)     // Catch:{ all -> 0x00e1 }
                            if (r14 != 0) goto L_0x00bd
                            if (r12 == 0) goto L_0x00bd
                            r9.setRequestProperty(r13, r12)     // Catch:{ all -> 0x00e1 }
                            goto L_0x00bd
                        L_0x00e1:
                            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0233 }
                            byte[] r8 = r8.getBytes(r1)     // Catch:{ all -> 0x0233 }
                            java.io.DataOutputStream r11 = new java.io.DataOutputStream     // Catch:{ all -> 0x0233 }
                            java.io.OutputStream r12 = r9.getOutputStream()     // Catch:{ all -> 0x0233 }
                            r11.<init>(r12)     // Catch:{ all -> 0x0233 }
                            r11.write(r8)     // Catch:{ all -> 0x0230 }
                            r11.flush()     // Catch:{ all -> 0x0230 }
                            int r7 = r9.getResponseCode()     // Catch:{ all -> 0x0230 }
                            java.lang.String r8 = r9.getResponseMessage()     // Catch:{ all -> 0x0230 }
                            int r12 = r9.getContentLength()     // Catch:{ all -> 0x0230 }
                            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                            r13.<init>()     // Catch:{ all -> 0x0230 }
                            java.lang.String r14 = "http recv response status code:"
                            r13.append(r14)     // Catch:{ all -> 0x0230 }
                            r13.append(r7)     // Catch:{ all -> 0x0230 }
                            java.lang.String r14 = ", responseMsg:"
                            r13.append(r14)     // Catch:{ all -> 0x0230 }
                            r13.append(r8)     // Catch:{ all -> 0x0230 }
                            java.lang.String r14 = ",contentLength:"
                            r13.append(r14)     // Catch:{ all -> 0x0230 }
                            r13.append(r12)     // Catch:{ all -> 0x0230 }
                            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x0230 }
                            com.tencent.tpns.baseapi.base.util.Logger.d(r6, r12)     // Catch:{ all -> 0x0230 }
                            r12 = 200(0xc8, float:2.8E-43)
                            if (r7 != r12) goto L_0x0208
                            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x0230 }
                            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x0230 }
                            java.io.InputStream r12 = r9.getInputStream()     // Catch:{ all -> 0x0230 }
                            r8.<init>(r12, r1)     // Catch:{ all -> 0x0230 }
                            r7.<init>(r8)     // Catch:{ all -> 0x0230 }
                            r1 = r5
                        L_0x013b:
                            java.lang.String r8 = r7.readLine()     // Catch:{ all -> 0x0230 }
                            if (r8 == 0) goto L_0x0151
                            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                            r12.<init>()     // Catch:{ all -> 0x0230 }
                            r12.append(r1)     // Catch:{ all -> 0x0230 }
                            r12.append(r8)     // Catch:{ all -> 0x0230 }
                            java.lang.String r1 = r12.toString()     // Catch:{ all -> 0x0230 }
                            goto L_0x013b
                        L_0x0151:
                            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                            r8.<init>()     // Catch:{ all -> 0x0230 }
                            java.lang.String r12 = "http get response data:"
                            r8.append(r12)     // Catch:{ all -> 0x0230 }
                            r8.append(r1)     // Catch:{ all -> 0x0230 }
                            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0230 }
                            com.tencent.tpns.baseapi.base.util.Logger.d(r6, r8)     // Catch:{ all -> 0x0230 }
                            r7.close()     // Catch:{ all -> 0x0230 }
                            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0230 }
                            r7.<init>(r1)     // Catch:{ all -> 0x0230 }
                            java.lang.String r1 = "retCode"
                            r8 = -1
                            int r1 = r7.optInt(r1, r8)     // Catch:{ all -> 0x0230 }
                            if (r1 == 0) goto L_0x0190
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                            r1.<init>()     // Catch:{ all -> 0x0230 }
                            r1.append(r0)     // Catch:{ all -> 0x0230 }
                            java.lang.String r2 = "errMsg"
                            java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x0230 }
                            r1.append(r2)     // Catch:{ all -> 0x0230 }
                            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0230 }
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r1)     // Catch:{ all -> 0x0230 }
                            goto L_0x0224
                        L_0x0190:
                            java.lang.String r1 = "sdkInfos"
                            org.json.JSONArray r1 = r7.getJSONArray(r1)     // Catch:{ all -> 0x0230 }
                            if (r1 == 0) goto L_0x0224
                            org.json.JSONObject r1 = r1.getJSONObject(r10)     // Catch:{ all -> 0x0230 }
                            java.lang.String r7 = "version"
                            java.lang.String r7 = r1.optString(r7, r5)     // Catch:{ all -> 0x0230 }
                            java.lang.String r8 = "date"
                            java.lang.String r8 = r1.optString(r8, r5)     // Catch:{ all -> 0x0230 }
                            java.lang.String r10 = "enDesc"
                            java.lang.String r10 = r1.optString(r10, r5)     // Catch:{ all -> 0x0230 }
                            java.lang.String r12 = "domainUrl"
                            java.lang.String r1 = r1.optString(r12, r5)     // Catch:{ all -> 0x0230 }
                            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                            r5.<init>()     // Catch:{ all -> 0x0230 }
                            java.lang.String r12 = "the current server TPNS sdk version is "
                            r5.append(r12)     // Catch:{ all -> 0x0230 }
                            r5.append(r7)     // Catch:{ all -> 0x0230 }
                            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0230 }
                            com.tencent.tpns.baseapi.base.util.Logger.d(r6, r5)     // Catch:{ all -> 0x0230 }
                            boolean r5 = com.tencent.android.tpush.common.j.b((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ all -> 0x0230 }
                            if (r5 == 0) goto L_0x0224
                            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                            r5.<init>()     // Catch:{ all -> 0x0230 }
                            java.lang.String r12 = "The latest release of TPNS SDK is now available, you can download it or update by Gradle. The details are as follows:\r\nnewSdkVersion = "
                            r5.append(r12)     // Catch:{ all -> 0x0230 }
                            r5.append(r7)     // Catch:{ all -> 0x0230 }
                            java.lang.String r7 = "\r\ncurrentSDKVersion = "
                            r5.append(r7)     // Catch:{ all -> 0x0230 }
                            r5.append(r2)     // Catch:{ all -> 0x0230 }
                            java.lang.String r2 = "\r\nreleaseDate = "
                            r5.append(r2)     // Catch:{ all -> 0x0230 }
                            r5.append(r8)     // Catch:{ all -> 0x0230 }
                            java.lang.String r2 = "\r\nreleaseNote = "
                            r5.append(r2)     // Catch:{ all -> 0x0230 }
                            r5.append(r10)     // Catch:{ all -> 0x0230 }
                            java.lang.String r2 = "\r\nreleaseSDKUrl = "
                            r5.append(r2)     // Catch:{ all -> 0x0230 }
                            r5.append(r1)     // Catch:{ all -> 0x0230 }
                            java.lang.String r1 = "\r\n"
                            r5.append(r1)     // Catch:{ all -> 0x0230 }
                            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0230 }
                            com.tencent.android.tpush.logging.TLogger.i(r6, r1)     // Catch:{ all -> 0x0230 }
                            goto L_0x0224
                        L_0x0208:
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                            r1.<init>()     // Catch:{ all -> 0x0230 }
                            java.lang.String r2 = "Server response error code:"
                            r1.append(r2)     // Catch:{ all -> 0x0230 }
                            r1.append(r7)     // Catch:{ all -> 0x0230 }
                            java.lang.String r2 = ", error:"
                            r1.append(r2)     // Catch:{ all -> 0x0230 }
                            r1.append(r8)     // Catch:{ all -> 0x0230 }
                            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0230 }
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r1)     // Catch:{ all -> 0x0230 }
                        L_0x0224:
                            r11.close()     // Catch:{ all -> 0x0228 }
                            goto L_0x022c
                        L_0x0228:
                            r0 = move-exception
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r4, r0)
                        L_0x022c:
                            r9.disconnect()     // Catch:{ all -> 0x024a }
                            goto L_0x024e
                        L_0x0230:
                            r1 = move-exception
                            r7 = r11
                            goto L_0x0237
                        L_0x0233:
                            r1 = move-exception
                            goto L_0x0237
                        L_0x0235:
                            r1 = move-exception
                            r9 = r7
                        L_0x0237:
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r0, r1)     // Catch:{ all -> 0x024f }
                            if (r7 == 0) goto L_0x0244
                            r7.close()     // Catch:{ all -> 0x0240 }
                            goto L_0x0244
                        L_0x0240:
                            r0 = move-exception
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r4, r0)
                        L_0x0244:
                            if (r9 == 0) goto L_0x024e
                            r9.disconnect()     // Catch:{ all -> 0x024a }
                            goto L_0x024e
                        L_0x024a:
                            r0 = move-exception
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r3, r0)
                        L_0x024e:
                            return
                        L_0x024f:
                            r0 = move-exception
                            if (r7 == 0) goto L_0x025a
                            r7.close()     // Catch:{ all -> 0x0256 }
                            goto L_0x025a
                        L_0x0256:
                            r1 = move-exception
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r4, r1)
                        L_0x025a:
                            if (r9 == 0) goto L_0x0264
                            r9.disconnect()     // Catch:{ all -> 0x0260 }
                            goto L_0x0264
                        L_0x0260:
                            r1 = move-exception
                            com.tencent.tpns.baseapi.base.util.Logger.e(r6, r3, r1)
                        L_0x0264:
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.common.j.AnonymousClass2.TRun():void");
                    }
                }).start();
            } catch (Throwable th2) {
                Logger.e("Util", "checkVersionUpdate error " + th2.toString());
            }
        } else {
            Logger.d("Util", "It is release");
        }
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 32;
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(RC4.decrypt(com.tencent.android.tpush.service.channel.security.a.a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th2) {
            TLogger.e("Util", "decode error", th2);
            return str;
        }
    }

    public static boolean b(Context context) {
        try {
            List<ResolveInfo> c11 = g.c(context, context.getPackageName() + Constants.RPC_SUFFIX);
            if (c11 == null || c11.size() <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            TLogger.e("Util", "Util -> isAIDLConfiged", th2);
            return false;
        }
    }

    public static void a(JSONObject jSONObject, String str, long j11) {
        if (str != null && j11 > 0) {
            try {
                jSONObject.put(str, j11);
            } catch (Throwable unused) {
            }
        }
    }

    public static int a(Context context) {
        if (f68925b.get()) {
            return 0;
        }
        try {
            TBaseLogger.init(context);
            if (XGPushManager.getContext() == null) {
                XGPushManager.setContext(context);
            }
            if (b.e() == null) {
                b.b(context);
            }
            XGPushProvider.fetchProviderAuthorities(context);
            if (!i(context)) {
                TLogger.ee("Util", "XG is disable");
                return ReturnCode.CODE_SERVICE_DISABLED.getType();
            } else if (!Security.checkTpnsSecurityLibSo(context)) {
                TLogger.ee("Util", "can not load library from so file");
                ReturnCode returnCode = ReturnCode.CODE_SO_ERROR;
                ServiceStat.reportErrCode(context, returnCode.getType(), "can not load library from so file", 0, ErrCode.ERROR_INNER_TYPE);
                return returnCode.getType();
            } else {
                AppInfos.checkApplicationIcon(context);
                StatServiceImpl.init(context);
                r(context);
                h(context);
                s(context);
                f68925b.set(true);
                return 0;
            }
        } catch (Throwable th2) {
            TLogger.e("Util", "Util -> initGlobal", th2);
            return -1;
        }
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean e(Context context, String str) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.equals(str) && next.importance == 100) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    private static void f(Context context, String str) {
        if (context != null && str != null) {
            try {
                if (str.trim().length() != 0) {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        ComponentName componentName = new ComponentName(context.getPackageName(), str);
                        if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                            packageManager.setComponentEnabledSetting(componentName, 1, 1);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(PackageManager packageManager, Context context, String str) {
        if (context != null && str != null) {
            try {
                if (str.trim().length() != 0) {
                    if (packageManager != null) {
                        ComponentName componentName = new ComponentName(context.getPackageName(), str);
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    public static boolean c(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            TLogger.e("Util", "unexpected for isFirstInstall: " + th2.getMessage());
            return false;
        }
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(com.tencent.android.tpush.service.channel.security.a.b(RC4.encrypt(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th2) {
            TLogger.e("Util", "encode error", th2);
            return str;
        }
    }

    public static boolean b(Context context, String str) {
        return MqttTools.isPushMsgTopic(context, str) || MqttTools.isAesPushMsgTopic(context, str) || MqttTools.isGZipPushMsgTopic(context, str) || MqttTools.isGZipAesPushMsgTopic(context, str);
    }

    public static long d(String str) {
        if (str == null || str.equals("0") || str.equals("")) {
            return 0;
        }
        String trim = str.trim();
        long[] jArr = new long[4];
        int indexOf = trim.indexOf(InstructionFileId.DOT);
        int i11 = indexOf + 1;
        int indexOf2 = trim.indexOf(InstructionFileId.DOT, i11);
        int i12 = indexOf2 + 1;
        int indexOf3 = trim.indexOf(InstructionFileId.DOT, i12);
        try {
            jArr[3] = Long.parseLong(trim.substring(0, indexOf));
            jArr[2] = Long.parseLong(trim.substring(i11, indexOf2));
            jArr[1] = Long.parseLong(trim.substring(i12, indexOf3));
            jArr[0] = Long.parseLong(trim.substring(indexOf3 + 1));
        } catch (Throwable th2) {
            for (int i13 = 0; i13 < 4; i13++) {
                jArr[i13] = 0;
            }
            TLogger.e("Util", "service Util@@parseIpAddress(" + trim + ")", th2);
        }
        return (jArr[0] << 24) + (jArr[1] << 16) + (jArr[2] << 8) + jArr[3];
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            BroadcastAgent.unregisterReceiver(context, broadcastReceiver);
            return true;
        } catch (Throwable th2) {
            TLogger.e("Util", "safeUnregisterReceiver error", th2);
            return false;
        }
    }

    public static void a() {
        try {
            PowerManager.WakeLock b11 = com.tencent.android.tpush.service.d.a().b();
            if (b11 != null) {
                if (b11.isHeld()) {
                    b11.release();
                }
                TLogger.d("Util", "stop WakeLock CPU");
            }
        } catch (Throwable th2) {
            TLogger.e("Util", "stopWakeLock", th2);
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, true);
    }

    public static void a(Context context, int i11) {
        if (2 == i11) {
            try {
                d.f68947c = ((String) CommonHelper.getMetaData(context, "com.meizu.push.api_id", "")).substring(4);
                d.f68948d = ((String) CommonHelper.getMetaData(context, "com.meizu.push.api_key", "")).substring(4);
                TLogger.d("Util", "mz:" + d.f68947c + ", " + d.f68948d);
            } catch (Throwable unused) {
                TLogger.w("Util", "unexpected for init mz");
            }
        } else if (1 == i11) {
            try {
                d.f68945a = ((String) CommonHelper.getMetaData(context, "com.xiaomi.push.api_id", "")).substring(4);
                d.f68946b = ((String) CommonHelper.getMetaData(context, "com.xiaomi.push.api_key", "")).substring(4);
                TLogger.d("Util", "mi:" + d.f68945a + ", " + d.f68946b);
            } catch (Throwable unused2) {
                TLogger.w("Util", "unexpected for init xm");
            }
        } else if (6 == i11) {
            try {
                d.f68949e = ((String) CommonHelper.getMetaData(context, "com.oppo.push.api_id", "")).substring(4);
                d.f68950f = ((String) CommonHelper.getMetaData(context, "com.oppo.push.api_key", "")).substring(4);
                TLogger.d("Util", "oppo:" + d.f68949e + ", " + d.f68950f);
            } catch (Throwable unused3) {
                TLogger.w("Util", "unexpected for init oppo");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:12|13|(2:14|(1:16)(1:51))|17|18|19|20|21|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0050 A[SYNTHETIC, Splitter:B:33:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0055 A[SYNTHETIC, Splitter:B:37:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = f68924a
            boolean r0 = b((java.lang.String) r0)
            if (r0 != 0) goto L_0x000b
            java.lang.String r3 = f68924a
            return r3
        L_0x000b:
            r0 = 0
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ all -> 0x0045 }
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ all -> 0x0045 }
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ all -> 0x0045 }
            if (r3 != 0) goto L_0x001b
            return r0
        L_0x001b:
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "UTF-8"
            r4.<init>(r3, r1)     // Catch:{ all -> 0x0045 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0043 }
            r3.<init>(r4)     // Catch:{ all -> 0x0043 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x0047 }
            r1.<init>()     // Catch:{ all -> 0x0047 }
        L_0x002c:
            java.lang.String r2 = r3.readLine()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0036
            r1.append(r2)     // Catch:{ all -> 0x0047 }
            goto L_0x002c
        L_0x0036:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0047 }
            f68924a = r1     // Catch:{ all -> 0x0047 }
            r3.close()     // Catch:{ all -> 0x003f }
        L_0x003f:
            r4.close()     // Catch:{ all -> 0x0042 }
        L_0x0042:
            return r1
        L_0x0043:
            r3 = r0
            goto L_0x0047
        L_0x0045:
            r3 = r0
            r4 = r3
        L_0x0047:
            java.lang.String r1 = "Util"
            java.lang.String r2 = "assets is null"
            com.tencent.android.tpush.logging.TLogger.d(r1, r2)     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x0053
            r3.close()     // Catch:{ all -> 0x0053 }
        L_0x0053:
            if (r4 == 0) goto L_0x0058
            r4.close()     // Catch:{ all -> 0x0058 }
        L_0x0058:
            return r0
        L_0x0059:
            r0 = move-exception
            if (r3 == 0) goto L_0x005f
            r3.close()     // Catch:{ all -> 0x005f }
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r4.close()     // Catch:{ all -> 0x0064 }
        L_0x0064:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.common.j.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean a(long j11, long j12) {
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            String format = simpleDateFormat.format(Long.valueOf(j11));
            String format2 = simpleDateFormat2.format(Long.valueOf(j12));
            Date parse = simpleDateFormat.parse(format);
            Date parse2 = simpleDateFormat2.parse(format2);
            instance.setTime(parse);
            instance2.setTime(parse2);
            return a(instance, instance2);
        } catch (Throwable unused) {
            Logger.w("Util", "");
            return false;
        }
    }

    public static boolean a(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            return false;
        }
        try {
            if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str, boolean z11) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    Logger.w("Util", "get current activities for currentActivityThread, activities is null");
                    return false;
                }
                for (Object next : map.values()) {
                    Class<?> cls2 = next.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(next)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(next);
                        if (activity == null) {
                            Logger.w("Util", "[getCurrentActivity] activity is null");
                            return false;
                        } else if (!activity.getPackageName().equals(context.getPackageName())) {
                            Logger.w("Util", "current activity packageName: " + activity.getPackageName() + ", appPackageName: " + context.getPackageName());
                            return false;
                        } else {
                            Logger.d("Util", "getCurrentActivity: " + activity.getLocalClassName());
                            return true;
                        }
                    }
                }
            } catch (Throwable th2) {
                Logger.w("Util", "[getCurrentActivity] error: " + th2.getMessage());
                if (z11) {
                    return e(context, str);
                }
            }
        }
        return false;
    }
}
