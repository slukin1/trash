package com.tencent.android.tpush.service.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.TypeStr;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.a.a;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f69856a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static long f69857b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static long f69858c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static int f69859d = -1;

    public static List<ResolveInfo> a(Context context) {
        TLogger.d("ServiceUtil", "action - getLocalPushAppsInfo");
        if (context == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            context.getPackageManager();
            for (ResolveInfo resolveInfo : new ArrayList()) {
                hashMap.put(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo);
            }
            return new ArrayList(hashMap.values());
        } catch (Throwable th2) {
            TLogger.e("ServiceUtil", "getLocalPushAppsInfo", th2);
            return null;
        }
    }

    public static void b(Context context) {
        TLogger.d("ServiceUtil", "action - pullUpServerConfigPkgs");
        try {
            Map<String, String> map = a.a(context).K;
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    if (!g(context, (String) next.getKey())) {
                        String str = "am startservice -n " + ((String) next.getKey()) + "/" + ((String) next.getValue());
                        Process exec = Runtime.getRuntime().exec(str);
                        int waitFor = exec.waitFor();
                        if (waitFor != 0) {
                            str = "am startservice --user 0 -n " + ((String) next.getKey()) + "/" + ((String) next.getValue());
                            TLogger.d("ServiceUtil", "start service:" + str);
                            exec = Runtime.getRuntime().exec(str);
                            waitFor = exec.waitFor();
                        }
                        if (waitFor != 0) {
                            TLogger.e("ServiceUtil", "pullUpServerConfigPkgs error exec cmd:" + str + ",exitValud:" + exec.exitValue());
                        }
                    }
                }
                return;
            }
            TLogger.d("ServiceUtil", "pullUpServerConfigPkgs no pull up packages map");
        } catch (Throwable th2) {
            TLogger.e("ServiceUtil", "", th2);
        }
    }

    public static void c(Context context) {
        try {
            if (CloudManager.getInstance(context).getAppClsAlive() == 1) {
                TLogger.d("ServiceUtil", "disable pull up group");
                return;
            }
            JSONArray pullupArrProviderAndActivity = CloudManager.getInstance(context).getPullupArrProviderAndActivity();
            if (pullupArrProviderAndActivity != null) {
                if (pullupArrProviderAndActivity.length() != 0) {
                    for (int i11 = 0; i11 < pullupArrProviderAndActivity.length(); i11++) {
                        a(context, pullupArrProviderAndActivity.optJSONObject(i11));
                    }
                    return;
                }
            }
            TLogger.i("ServiceUtil", "pullupOtherServiceByProviderAndActivity no running");
        } catch (Throwable th2) {
            TLogger.e("ServiceUtil", "pullupOtherServiceByProviderAndActivity" + th2);
        }
    }

    /* access modifiers changed from: private */
    public static boolean f(Context context, String str) {
        String str2;
        if (str == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next != null && (str2 = next.processName) != null && str2.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean g(Context context, String str) {
        if (j.b(str)) {
            return false;
        }
        String pullupBlackList = CloudManager.getInstance(context).getPullupBlackList();
        if (j.b(pullupBlackList)) {
            return false;
        }
        return pullupBlackList.contains(str);
    }

    public static void d(Context context) {
        if (com.tencent.android.tpush.f.a.a(context)) {
            TLogger.dd("ServiceUtil", "Run As SysPush, Not pull up other XGService");
        } else if (GuidInfoManager.isServerDestroy(context)) {
            TLogger.ii("ServiceUtil", "server destroy, Not pull up other app");
        } else if (ChannelUtils.isMiuiV12()) {
            TLogger.dd("ServiceUtil", "Run As MIUI 12, Not pull up other XGService");
        } else if (CloudManager.getInstance(context).disablePullUp()) {
            TLogger.dd("ServiceUtil", " Not pull up other XGService with cloud");
        } else if (a(context.getPackageName())) {
            TLogger.dd("ServiceUtil", context.getPackageName() + " ignore pull up");
        } else {
            TLogger.d("ServiceUtil", "not in ignore app list");
            if (PushPreferences.getBoolean(context, Constants.ENABLE_PULL_UP_OTHER_APP, false)) {
                TLogger.i("ServiceUtil", "default pull up other app");
                try {
                    g(context);
                } catch (Throwable th2) {
                    TLogger.e("ServiceUtil", "pullUpXGServiceByProvider" + th2);
                }
                c(context);
                b(context);
                return;
            }
            TLogger.ii("ServiceUtil", "disable pull up other app");
        }
    }

    public static void e(Context context) {
        try {
            String d11 = b.d(context);
            TLogger.d("ServiceUtil", "serviceSafeExit @ " + d11);
            if (d11 != null && d11.contains(":xg_vip_service")) {
                XGVipPushService.a().stopSelf();
            }
        } catch (Throwable th2) {
            TLogger.e("ServiceUtil", "unexpected for serviceSafeExit", th2);
        }
    }

    public static void f(Context context) {
        try {
            TLogger.d("ServiceUtil", "cancelPingAlarmManager");
            Intent intent = new Intent(Constants.XG_PUSH_SERVICE_PING_ACTION);
            intent.setClassName(context, "com.tencent.android.tpush.XGPushReceiver");
            intent.setPackage(context.getPackageName());
            int i11 = 134217728;
            if (Build.VERSION.SDK_INT >= 31) {
                i11 = 167772160;
            }
            PushAutoTrackHelper.hookIntentGetBroadcast(context, 0, intent, i11);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i11);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, 0, intent, i11);
            TPushAlarmManager.getAlarmManager(context).cancal(broadcast);
        } catch (Throwable th2) {
            TLogger.w("ServiceUtil", "cancelPingAlarmManager error: " + th2.toString());
        }
    }

    private static void g(final Context context) {
        TLogger.d("ServiceUtil", "action - pullUpXGServiceByProvider on 2s later");
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                List<ResolveInfo> a11 = g.a(context);
                if (a11 != null) {
                    int i11 = 0;
                    for (ResolveInfo next : a11) {
                        i11++;
                        if (MTPushConstants.Manufacturer.OPPO.equals(j.b())) {
                            if (i11 > 2) {
                                return;
                            }
                        } else if (i11 > 4) {
                            return;
                        }
                        String str = next.activityInfo.applicationInfo.packageName;
                        if (!g.g(context, str) && !j.b(str) && !context.getPackageName().equals(str) && !g.b(context, str) && g.a(context, str)) {
                            try {
                                String str2 = "content://" + str + ".XGVIP_PUSH_AUTH/" + TypeStr.pullupxg.getStr();
                                Uri parse = Uri.parse(str2);
                                TLogger.d("ServiceUtil", "pull up by provider, pkgName: " + str + ", uri:" + str2);
                                ProviderMessage.getType(context, parse);
                                Thread.sleep(200);
                            } catch (Throwable th2) {
                                TLogger.e("ServiceUtil", "pull up by provider error" + th2);
                            }
                        }
                    }
                    return;
                }
                TLogger.ii("ServiceUtil", "pullupXGServices  with null content");
            }
        }, 2000);
    }

    public static List<String> a() {
        if (f69856a.isEmpty()) {
            f69856a.add("com.jingdong.app.mall");
            f69856a.add("com.ifeng.news2");
        }
        return f69856a;
    }

    public static List<ResolveInfo> c(Context context, String str) {
        if (context != null) {
            try {
                return context.getPackageManager().queryIntentServices(new Intent(str), 512);
            } catch (Throwable th2) {
                TLogger.e("ServiceUtil", "getLocalPushServicesInfo", th2);
                return null;
            }
        } else {
            TLogger.e("ServiceUtil", "getLocalPushServicesInfo the context == null");
            return null;
        }
    }

    public static boolean a(String str) {
        return a().contains(str);
    }

    public static void a(final Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString("name", "");
            if (!j.b(optString) && !g(context, optString) && !f(context, optString)) {
                TLogger.d("ServiceUtil", "action - pullUpOtherServiceByProviderAndActivityJSONOject, proName:" + optString);
                String optString2 = jSONObject.optString(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "");
                if (!j.b(optString2)) {
                    try {
                        Intent intent = new Intent(optString2);
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                    } catch (Throwable unused) {
                        TLogger.d("ServiceUtil", "unexpected for start activity for action:" + optString2);
                    }
                } else {
                    String optString3 = jSONObject.optString("schema", "");
                    if (!j.b(optString3)) {
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(optString3));
                            intent2.setFlags(268435456);
                            context.startActivity(intent2);
                        } catch (Throwable unused2) {
                            TLogger.d("ServiceUtil", "unexpected for start activity for schema:" + optString3);
                        }
                    }
                }
                final String optString4 = jSONObject.optString("url", "");
                if (!j.b(optString4)) {
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            try {
                                if (!g.f(context, optString)) {
                                    ProviderMessage.getType(context, Uri.parse("content://" + optString4));
                                }
                            } catch (Throwable unused) {
                                TLogger.d("ServiceUtil", "unexpected for start provider for providerUrl:" + optString4);
                            }
                        }
                    }, 2000);
                }
            }
        }
    }

    public static boolean b(Context context, String str) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null || runningServices.size() <= 0) {
                return false;
            }
            String name = XGVipPushService.class.getName();
            for (ActivityManager.RunningServiceInfo next : runningServices) {
                if (next.pid != 0 && name.equals(next.service.getClassName())) {
                    String packageName = next.service.getPackageName();
                    if (j.c(packageName) && packageName.equals(str)) {
                        TLogger.d("ServiceUtil", "isSurvive srvPkg :" + packageName);
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            TLogger.e("ServiceUtil", "checkXGServiceV3IsRunningByPkgName", th2);
            return false;
        }
    }

    public static long b(Intent intent) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
            if (j.b(stringExtra)) {
                stringExtra = simpleDateFormat.format(new Date());
            }
            long time = simpleDateFormat.parse(stringExtra).getTime();
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra("content")));
            if (jSONObject.isNull("accept_time")) {
                return time;
            }
            String string = jSONObject.getString("accept_time");
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return time;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(jSONArray.getString(i12)).getString("start"));
                int intValue = (Integer.valueOf(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_HOUR)).intValue() * 60) + Integer.valueOf(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue();
                if (intValue < i11 || i11 == 0) {
                    i11 = intValue;
                }
            }
            long j11 = time + (((long) (i11 * 60)) * 1000);
            TLogger.i("Utils", "get acceptTime = " + string + " , acceptBeginTime= " + j11);
            return j11;
        } catch (Throwable th2) {
            TLogger.d("ServiceUtil", "getAcceptBeginTime " + th2.toString());
            return 0;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context.createPackageContext(str, 0), XGVipPushService.class), 0);
            if (queryIntentServices != null) {
                if (!queryIntentServices.isEmpty()) {
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (resolveInfo.serviceInfo.processName.contains("xg_vip_service")) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            TLogger.w("ServiceUtil", "unexpected for isXGServiceV4ProcssNameConfigByName:" + th2.getMessage());
        }
    }

    public static Intent a(int i11, String str, int i12) {
        Intent intent = new Intent(Constants.ACTION_FEEDBACK);
        if (!(str == null || str.length() == 0)) {
            intent.setPackage(str);
        }
        intent.putExtra(Constants.FEEDBACK_TAG, i12);
        intent.putExtra(Constants.FEEDBACK_ERROR_CODE, i11);
        return intent;
    }

    public static boolean a(Intent intent) {
        try {
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra("content")));
            if (jSONObject.isNull("accept_time")) {
                return true;
            }
            String string = jSONObject.getString("accept_time");
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return true;
            }
            Calendar instance = Calendar.getInstance();
            int i11 = (instance.get(11) * 60) + instance.get(12);
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i12));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("start"));
                int intValue = (Integer.valueOf(jSONObject3.getString(MessageKey.MSG_ACCEPT_TIME_HOUR)).intValue() * 60) + Integer.valueOf(jSONObject3.getString(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue();
                JSONObject jSONObject4 = new JSONObject(jSONObject2.getString("end"));
                int intValue2 = (Integer.valueOf(jSONObject4.getString(MessageKey.MSG_ACCEPT_TIME_HOUR)).intValue() * 60) + Integer.valueOf(jSONObject4.getString(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue();
                TLogger.i("ServiceUtil", ">> check accept time, current:" + i11 + ", startTime:" + intValue + ", endTime:" + intValue2);
                if (intValue <= i11 && i11 <= intValue2) {
                    return true;
                }
            }
            TLogger.w("Utils", " discurd the msg due to time not accepted! acceptTime = " + string + " , curTime= " + i11);
            return false;
        } catch (Throwable th2) {
            TLogger.d("ServiceUtil", "checkAcceptTime " + th2.toString());
            return true;
        }
    }
}
