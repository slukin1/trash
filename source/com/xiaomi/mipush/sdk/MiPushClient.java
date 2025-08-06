package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.af;
import com.xiaomi.push.ao;
import com.xiaomi.push.av;
import com.xiaomi.push.bc;
import com.xiaomi.push.dh;
import com.xiaomi.push.di;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gu;
import com.xiaomi.push.ha;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.i;
import com.xiaomi.push.j;
import com.xiaomi.push.m;
import com.xiaomi.push.p;
import com.xiaomi.push.s;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    /* access modifiers changed from: private */
    public static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j11) {
            this.resultCode = j11;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r11);
    }

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j11, String str2, List<String> list) {
        }

        public void onInitializeResult(long j11, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z11) {
        }

        public void onSubscribeResult(long j11, String str, String str2) {
        }

        public void onUnsubscribeResult(long j11, String str, String str2) {
        }

        public void setCategory(String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        private long resultCode = -1;
        private String token = null;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        public void setResultCode(long j11) {
            this.resultCode = j11;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1);
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            p.a(edit);
        }
    }

    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        p.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        p.a(edit);
    }

    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 4);
                            if (packageInfo != null) {
                                MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    b.a(th2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            int length = serviceInfoArr.length;
            int i11 = 0;
            while (i11 < length) {
                ServiceInfo serviceInfo = serviceInfoArr[i11];
                if (!serviceInfo.exported || !serviceInfo.enabled || !"com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) || context.getPackageName().equals(serviceInfo.packageName)) {
                    i11++;
                } else {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        for (String str : getAllAlias(context)) {
            edit.remove("alias_" + str);
        }
        for (String str2 : getAllUserAccount(context)) {
            edit.remove("account_" + str2);
        }
        for (String str3 : getAllTopic(context)) {
            edit.remove("topic_" + str3);
        }
        edit.remove("accept_time");
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        u.a(context).f();
    }

    public static void clearNotification(Context context, int i11) {
        u.a(context).a(i11);
    }

    public static void disablePush(Context context) {
        u.a(context).a(true);
    }

    public static void enablePush(Context context) {
        u.a(context).a(false);
    }

    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("alias_")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("topic_") && !next.contains("**ALL**")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("account_")) {
                arrayList.add(next.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.a(context).c()) {
            return b.a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return j.b();
    }

    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_FCM);
    }

    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_COS);
    }

    public static boolean getOpenVIVOPush(Context context) {
        return e.a(context).b(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.a(context).c()) {
            return b.a(context).c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        dt.a((dt.a) new dt.a() {
            public void uploader(Context context, gk gkVar) {
                MiTinyDataClient.upload(context, gkVar);
            }
        });
        Config a11 = dt.a(context);
        a.a(context).a("6_0_1-C");
        ClientReportClient.init(context, a11, new dr(context), new ds(context));
        a.a(context);
        k.a(context, a11);
        ah.a(context).a((ah.a) new ah.a(100, "perf event job update") {
            public void onCallback() {
                dt.a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, (String) null, (ICallbackResult) null);
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(p.a(sContext).a(v.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(p.a(sContext).a(v.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        p a11 = p.a(sContext);
        v vVar = v.UPLOAD_HUAWEI_TOKEN;
        if ("syncing".equals(a11.a(vVar))) {
            u.a(sContext).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, ZendeskBlipsProvider.ACTION_CORE_INIT);
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        p a12 = p.a(sContext);
        v vVar2 = v.UPLOAD_COS_TOKEN;
        if ("syncing".equals(a12.a(vVar2))) {
            u.a(sContext).a((String) null, vVar2, d.ASSEMBLE_PUSH_COS, ZendeskBlipsProvider.ACTION_CORE_INIT);
        }
        p a13 = p.a(sContext);
        v vVar3 = v.UPLOAD_FTOS_TOKEN;
        if ("syncing".equals(a13.a(vVar3))) {
            u.a(context).a((String) null, vVar3, d.ASSEMBLE_PUSH_FTOS, ZendeskBlipsProvider.ACTION_CORE_INIT);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void reInitialize(Context context, gu guVar) {
        b.e("re-register reason: " + guVar);
        String a11 = bc.a(6);
        String a12 = b.a(context).a();
        String b11 = b.a(context).b();
        b.a(context).a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.a(context).a(Constants.a());
        b.a(context).a(a12, b11, a11);
        hg hgVar = new hg();
        hgVar.a(aj.b());
        hgVar.b(a12);
        hgVar.e(b11);
        hgVar.f(a11);
        hgVar.d(context.getPackageName());
        hgVar.c(g.a(context, context.getPackageName()));
        hgVar.b(g.a(context, context.getPackageName()));
        hgVar.h("6_0_1-C");
        hgVar.a(60001);
        hgVar.a(guVar);
        int a13 = i.a();
        if (a13 >= 0) {
            hgVar.c(a13);
        }
        u.a(context).a(hgVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            m.a(context.getApplicationContext(), new NetworkStatusReceiver((Object) null), intentFilter, 2);
        } catch (Throwable th2) {
            b.a("dynamic register network status receiver failed:" + th2);
        }
        av.a(sContext);
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), (String) null, uPSRegisterCallBack);
    }

    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            p.a(edit);
        }
    }

    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAccount : getAllUserAccount(context)) {
                removeAccount(context, removeAccount);
            }
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAlias : getAllAlias(context)) {
                removeAlias(context, removeAlias);
            }
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeTopic : getAllTopic(context)) {
                removeTopic(context, removeTopic);
            }
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void removeWindow(Context context) {
        u.a(context).e();
    }

    public static void reportAppRunInBackground(Context context, boolean z11) {
        if (b.a(context).b()) {
            gq gqVar = z11 ? gq.APP_SLEEP : gq.APP_WAKEUP;
            hf hfVar = new hf();
            hfVar.b(b.a(context).a());
            hfVar.c(gqVar.f2942a);
            hfVar.d(context.getPackageName());
            hfVar.a(aj.a());
            hfVar.a(false);
            u.a(context).a(hfVar, gg.Notification, false, (gt) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, gt gtVar, String str2, String str3) {
        hf hfVar = new hf();
        if (TextUtils.isEmpty(str3)) {
            b.d("do not report clicked message");
            return;
        }
        hfVar.b(str3);
        hfVar.c("bar:click");
        hfVar.a(str);
        hfVar.a(false);
        u.a(context).a(hfVar, gg.Notification, false, true, gtVar, true, str2, str3);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, (gt) null, (String) null);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ah.a(sContext).a(gl.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dh.a().a(new i(context));
            af.a(sContext).a((Runnable) new Runnable() {
                public void run() {
                    di.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        af.a(sContext).a(new o(sContext), ah.a(sContext).a(gl.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i11, int i12, int i13, int i14, String str) {
        Context context2 = context;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int i18 = i14;
        if (i15 < 0 || i15 >= 24 || i17 < 0 || i17 >= 24 || i16 < 0 || i16 >= 60 || i18 < 0 || i18 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60);
        long j11 = ((((long) ((i15 * 60) + i16)) + rawOffset) + 1440) % 1440;
        long j12 = ((((long) ((i17 * 60) + i18)) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j11 / 60), Long.valueOf(j11 % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j12 / 60), Long.valueOf(j12 % 60)}));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12)}));
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i13), Integer.valueOf(i14)}));
        if (!acceptTimeSet(context2, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context2, ee.COMMAND_SET_ACCEPT_TIME.f2769a, (ArrayList<String>) arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ee.COMMAND_SET_ACCEPT_TIME.f2769a, 0, (String) null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context2, PushMessageHelper.generateCommandMessage(ee.COMMAND_SET_ACCEPT_TIME.f2769a, arrayList2, 0, (String) null, (String) null, (List<String>) null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ee.COMMAND_SET_ALIAS.f2769a, str, str2);
        }
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        ee eeVar = ee.COMMAND_SET_ALIAS;
        if (!eeVar.f2769a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) >= Period.DAY_MILLS) {
            if (!ee.COMMAND_UNSET_ALIAS.f2769a.equalsIgnoreCase(str) || aliasSetTime(context, str2) >= 0) {
                ee eeVar2 = ee.COMMAND_SET_ACCOUNT;
                if (!eeVar2.f2769a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) >= Period.MIN60_MILLS) {
                    if (!ee.COMMAND_UNSET_ACCOUNT.f2769a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                        setCommand(context, str, (ArrayList<String>) arrayList, str3);
                        return;
                    }
                    b.a("Don't cancel account for " + bc.a(arrayList.toString(), 3) + " is unseted");
                } else if (1 == PushMessageHelper.getPushMode(context)) {
                    PushMessageHandler.a(context, str3, str, 0, (String) null, arrayList);
                } else {
                    PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eeVar2.f2769a, arrayList, 0, (String) null, str3, (List<String>) null));
                }
            } else {
                b.a("Don't cancel alias for " + bc.a(arrayList.toString(), 3) + " is unseted");
            }
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str3, str, 0, (String) null, arrayList);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eeVar.f2769a, arrayList, 0, (String) null, str3, (List<String>) null));
        }
    }

    public static void setLocalNotificationType(Context context, int i11) {
        u.a(context).b(i11 & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ee.COMMAND_SET_ACCOUNT.f2769a, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000) {
            return true;
        }
        return false;
    }

    private static boolean shouldSendRegRequest(Context context) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > 5000) {
            return true;
        }
        return false;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return u.a(context).a();
    }

    public static void subscribe(Context context, String str, String str2) {
        String str3 = str;
        if (!TextUtils.isEmpty(b.a(context).a()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > Period.DAY_MILLS) {
                hk hkVar = new hk();
                String a11 = aj.a();
                hkVar.a(a11);
                hkVar.b(b.a(context).a());
                hkVar.c(str);
                hkVar.d(context.getPackageName());
                hkVar.e(str2);
                b.e("cmd:" + ee.COMMAND_SUBSCRIBE_TOPIC + ", " + a11);
                u.a(context).a(hkVar, gg.Subscription, (gt) null);
                return;
            }
            String str4 = str2;
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0, (String) null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            Context context2 = context;
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ee.COMMAND_SUBSCRIBE_TOPIC.f2769a, arrayList, 0, (String) null, (String) null, (List<String>) null));
        }
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    public static void syncAssembleFCMPushToken(Context context) {
        u.a(context).a((String) null, v.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM, "");
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken((String) null);
            tokenResult.getToken();
            tokenResult.setResultCode(0);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        f.c(context);
        ah.a(context).a();
        if (b.a(context).b()) {
            hm hmVar = new hm();
            hmVar.a(aj.a());
            hmVar.b(b.a(context).a());
            hmVar.c(b.a(context).c());
            hmVar.e(b.a(context).b());
            hmVar.d(context.getPackageName());
            u.a(context).a(hmVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.a(context).b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ee.COMMAND_UNSET_ALIAS.f2769a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ee.COMMAND_UNSET_ACCOUNT.f2769a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.a(context).b()) {
            if (topicSubscribedTime(context, str) < 0) {
                b.a("Don't cancel subscribe for " + bc.a(str, 3) + " is unsubscribed");
                return;
            }
            ho hoVar = new ho();
            String a11 = aj.a();
            hoVar.a(a11);
            hoVar.b(b.a(context).a());
            hoVar.c(str);
            hoVar.d(context.getPackageName());
            hoVar.e(str2);
            b.e("cmd:" + ee.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a11);
            u.a(context).a(hoVar, gg.UnSubscription, (gt) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() {
            public void run() {
                if (j.d()) {
                    return;
                }
                if (i.b(MiPushClient.sContext) != null || ao.a(MiPushClient.sContext).a()) {
                    hf hfVar = new hf();
                    hfVar.b(b.a(MiPushClient.sContext).a());
                    hfVar.c(gq.ClientInfoUpdate.f2942a);
                    hfVar.a(aj.a());
                    hfVar.a((Map<String, String>) new HashMap());
                    String str = "";
                    String b11 = i.b(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(b11)) {
                        str = str + bc.a(b11);
                    }
                    String d11 = i.d(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d11)) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + d11;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hfVar.a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    ao.a(MiPushClient.sContext).a((Map<String, String>) hfVar.a());
                    int a11 = i.a();
                    if (a11 >= 0) {
                        hfVar.a().put("space_id", Integer.toString(a11));
                    }
                    u.a(MiPushClient.sContext).a(hfVar, gg.Notification, false, (gt) null);
                }
            }
        }).start();
    }

    public static void clearNotification(Context context, String str, String str2) {
        u.a(context).a(str, str2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02b8 A[Catch:{ all -> 0x02cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initialize(android.content.Context r18, java.lang.String r19, java.lang.String r20, com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback r21, java.lang.String r22, com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult r23) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "update_devId"
            android.content.Context r4 = r18.getApplicationContext()     // Catch:{ all -> 0x02cf }
            com.xiaomi.channel.commonutils.logger.b.a((android.content.Context) r4)     // Catch:{ all -> 0x02cf }
            java.lang.String r4 = "sdk_version = 6_0_1-C"
            com.xiaomi.channel.commonutils.logger.b.e(r4)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.ao r4 = com.xiaomi.push.ao.a((android.content.Context) r18)     // Catch:{ all -> 0x02cf }
            r4.a()     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.cy.a(r18)     // Catch:{ all -> 0x02cf }
            if (r2 == 0) goto L_0x0023
            com.xiaomi.mipush.sdk.PushMessageHandler.a((com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback) r21)     // Catch:{ all -> 0x02cf }
        L_0x0023:
            if (r23 == 0) goto L_0x0028
            com.xiaomi.mipush.sdk.PushMessageHandler.a((com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult) r23)     // Catch:{ all -> 0x02cf }
        L_0x0028:
            android.content.Context r4 = sContext     // Catch:{ all -> 0x02cf }
            boolean r4 = com.xiaomi.push.s.a((android.content.Context) r4)     // Catch:{ all -> 0x02cf }
            if (r4 == 0) goto L_0x0035
            android.content.Context r4 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.m.a(r4)     // Catch:{ all -> 0x02cf }
        L_0x0035:
            android.content.Context r4 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r4 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r4)     // Catch:{ all -> 0x02cf }
            int r4 = r4.a()     // Catch:{ all -> 0x02cf }
            int r5 = com.xiaomi.mipush.sdk.Constants.a()     // Catch:{ all -> 0x02cf }
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L_0x0049
            r4 = r6
            goto L_0x004a
        L_0x0049:
            r4 = r7
        L_0x004a:
            if (r4 != 0) goto L_0x0063
            android.content.Context r5 = sContext     // Catch:{ all -> 0x02cf }
            boolean r5 = shouldSendRegRequest(r5)     // Catch:{ all -> 0x02cf }
            if (r5 != 0) goto L_0x0063
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.u r0 = com.xiaomi.mipush.sdk.u.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            r0.a()     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = "Could not send  register message within 5s repeatly ."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            return
        L_0x0063:
            r5 = 60001(0xea61, float:8.408E-41)
            java.lang.String r8 = "6_0_1-C"
            if (r4 != 0) goto L_0x01bd
            android.content.Context r9 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r9 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r9)     // Catch:{ all -> 0x02cf }
            boolean r9 = r9.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x02cf }
            if (r9 == 0) goto L_0x01bd
            android.content.Context r9 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r9 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r9)     // Catch:{ all -> 0x02cf }
            boolean r9 = r9.f()     // Catch:{ all -> 0x02cf }
            if (r9 != 0) goto L_0x01bd
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            int r0 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r0)     // Catch:{ all -> 0x02cf }
            r1 = 0
            if (r6 != r0) goto L_0x00a0
            java.lang.String r0 = "callback"
            checkNotNull(r2, r0)     // Catch:{ all -> 0x02cf }
            r9 = 0
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r0 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x02cf }
            r2.onInitializeResult(r9, r1, r0)     // Catch:{ all -> 0x02cf }
            goto L_0x00c6
        L_0x00a0:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x02cf }
            r12.<init>()     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r0 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x02cf }
            r12.add(r0)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.ee r0 = com.xiaomi.push.ee.COMMAND_REGISTER     // Catch:{ all -> 0x02cf }
            java.lang.String r11 = r0.f2769a     // Catch:{ all -> 0x02cf }
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r11, r12, r13, r15, r16, r17)     // Catch:{ all -> 0x02cf }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r2, r0)     // Catch:{ all -> 0x02cf }
        L_0x00c6:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.u r0 = com.xiaomi.mipush.sdk.u.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            r0.a()     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r0 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            boolean r0 = r0.a()     // Catch:{ all -> 0x02cf }
            if (r0 == 0) goto L_0x0165
            com.xiaomi.push.hf r0 = new com.xiaomi.push.hf     // Catch:{ all -> 0x02cf }
            r0.<init>()     // Catch:{ all -> 0x02cf }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r2 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r2)     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x02cf }
            r0.b((java.lang.String) r2)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.gq r2 = com.xiaomi.push.gq.ClientInfoUpdate     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = r2.f2942a     // Catch:{ all -> 0x02cf }
            r0.c((java.lang.String) r2)     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = com.xiaomi.push.service.aj.a()     // Catch:{ all -> 0x02cf }
            r0.a((java.lang.String) r2)     // Catch:{ all -> 0x02cf }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x02cf }
            r2.<init>()     // Catch:{ all -> 0x02cf }
            r0.f3081a = r2     // Catch:{ all -> 0x02cf }
            java.lang.String r4 = "app_version"
            android.content.Context r9 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r10 = r9.getPackageName()     // Catch:{ all -> 0x02cf }
            java.lang.String r9 = com.xiaomi.push.g.a((android.content.Context) r9, (java.lang.String) r10)     // Catch:{ all -> 0x02cf }
            r2.put(r4, r9)     // Catch:{ all -> 0x02cf }
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f3081a     // Catch:{ all -> 0x02cf }
            java.lang.String r4 = "app_version_code"
            android.content.Context r9 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r10 = r9.getPackageName()     // Catch:{ all -> 0x02cf }
            int r9 = com.xiaomi.push.g.a((android.content.Context) r9, (java.lang.String) r10)     // Catch:{ all -> 0x02cf }
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x02cf }
            r2.put(r4, r9)     // Catch:{ all -> 0x02cf }
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f3081a     // Catch:{ all -> 0x02cf }
            java.lang.String r4 = "push_sdk_vn"
            r2.put(r4, r8)     // Catch:{ all -> 0x02cf }
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f3081a     // Catch:{ all -> 0x02cf }
            java.lang.String r4 = "push_sdk_vc"
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x02cf }
            r2.put(r4, r5)     // Catch:{ all -> 0x02cf }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r2 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r2)     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x02cf }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x02cf }
            if (r4 != 0) goto L_0x014f
            java.util.Map<java.lang.String, java.lang.String> r4 = r0.f3081a     // Catch:{ all -> 0x02cf }
            java.lang.String r5 = "deviceid"
            r4.put(r5, r2)     // Catch:{ all -> 0x02cf }
        L_0x014f:
            android.content.Context r2 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.u r2 = com.xiaomi.mipush.sdk.u.a((android.content.Context) r2)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.gg r4 = com.xiaomi.push.gg.Notification     // Catch:{ all -> 0x02cf }
            r2.a(r0, (com.xiaomi.push.gg) r4, (boolean) r7, (com.xiaomi.push.gt) r1)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.u r0 = com.xiaomi.mipush.sdk.u.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x02cf }
            r0.a((android.content.Context) r1)     // Catch:{ all -> 0x02cf }
        L_0x0165:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            boolean r0 = com.xiaomi.push.l.a((android.content.Context) r0, (java.lang.String) r3, (boolean) r7)     // Catch:{ all -> 0x02cf }
            if (r0 != 0) goto L_0x0175
            updateImeiOrOaid()     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.l.a((android.content.Context) r0, (java.lang.String) r3, (boolean) r6)     // Catch:{ all -> 0x02cf }
        L_0x0175:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            boolean r0 = shouldUseMIUIPush(r0)     // Catch:{ all -> 0x02cf }
            if (r0 == 0) goto L_0x0293
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            boolean r0 = shouldPullNotification(r0)     // Catch:{ all -> 0x02cf }
            if (r0 == 0) goto L_0x0293
            com.xiaomi.push.hf r2 = new com.xiaomi.push.hf     // Catch:{ all -> 0x02cf }
            r2.<init>()     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r0 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = r0.a()     // Catch:{ all -> 0x02cf }
            r2.b((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.gq r0 = com.xiaomi.push.gq.PullOfflineMessage     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = r0.f2942a     // Catch:{ all -> 0x02cf }
            r2.c((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = com.xiaomi.push.service.aj.a()     // Catch:{ all -> 0x02cf }
            r2.a((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            r2.a((boolean) r7)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.u r1 = com.xiaomi.mipush.sdk.u.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.gg r3 = com.xiaomi.push.gg.Notification     // Catch:{ all -> 0x02cf }
            r4 = 0
            r5 = 0
            r6 = 0
            r1.a(r2, (com.xiaomi.push.gg) r3, (boolean) r4, (com.xiaomi.push.gt) r5, (boolean) r6)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            addPullNotificationTime(r0)     // Catch:{ all -> 0x02cf }
            goto L_0x0293
        L_0x01bd:
            r2 = 6
            java.lang.String r2 = com.xiaomi.push.bc.a((int) r2)     // Catch:{ all -> 0x02cf }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r3 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r3)     // Catch:{ all -> 0x02cf }
            r3.a()     // Catch:{ all -> 0x02cf }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r3 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r3)     // Catch:{ all -> 0x02cf }
            int r7 = com.xiaomi.mipush.sdk.Constants.a()     // Catch:{ all -> 0x02cf }
            r3.a((int) r7)     // Catch:{ all -> 0x02cf }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.b r3 = com.xiaomi.mipush.sdk.b.a((android.content.Context) r3)     // Catch:{ all -> 0x02cf }
            r3.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.MiTinyDataClient$a r3 = com.xiaomi.mipush.sdk.MiTinyDataClient.a.a()     // Catch:{ all -> 0x02cf }
            java.lang.String r7 = "com.xiaomi.xmpushsdk.tinydataPending.appId"
            r3.b((java.lang.String) r7)     // Catch:{ all -> 0x02cf }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x02cf }
            clearExtras(r3)     // Catch:{ all -> 0x02cf }
            clearNotification(r18)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.hg r3 = new com.xiaomi.push.hg     // Catch:{ all -> 0x02cf }
            r3.<init>()     // Catch:{ all -> 0x02cf }
            java.lang.String r7 = com.xiaomi.push.service.aj.b()     // Catch:{ all -> 0x02cf }
            r3.a((java.lang.String) r7)     // Catch:{ all -> 0x02cf }
            r3.b((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            r3.e((java.lang.String) r1)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x02cf }
            r3.d((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            r3.f((java.lang.String) r2)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r1 = r0.getPackageName()     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = com.xiaomi.push.g.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ all -> 0x02cf }
            r3.c((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r1 = r0.getPackageName()     // Catch:{ all -> 0x02cf }
            int r0 = com.xiaomi.push.g.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ all -> 0x02cf }
            r3.b((int) r0)     // Catch:{ all -> 0x02cf }
            r3.h((java.lang.String) r8)     // Catch:{ all -> 0x02cf }
            r3.a((int) r5)     // Catch:{ all -> 0x02cf }
            com.xiaomi.push.gu r0 = com.xiaomi.push.gu.Init     // Catch:{ all -> 0x02cf }
            r3.a((com.xiaomi.push.gu) r0)     // Catch:{ all -> 0x02cf }
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x02cf }
            if (r0 != 0) goto L_0x0240
            r0 = r22
            r3.g((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
        L_0x0240:
            boolean r0 = com.xiaomi.push.j.d()     // Catch:{ all -> 0x02cf }
            if (r0 != 0) goto L_0x0273
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = com.xiaomi.push.i.c(r0)     // Catch:{ all -> 0x02cf }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02cf }
            if (r1 != 0) goto L_0x0273
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x02cf }
            r1.<init>()     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = com.xiaomi.push.bc.a((java.lang.String) r0)     // Catch:{ all -> 0x02cf }
            r1.append(r0)     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = ","
            r1.append(r0)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = com.xiaomi.push.i.e(r0)     // Catch:{ all -> 0x02cf }
            r1.append(r0)     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x02cf }
            r3.i(r0)     // Catch:{ all -> 0x02cf }
        L_0x0273:
            int r0 = com.xiaomi.push.i.a()     // Catch:{ all -> 0x02cf }
            if (r0 < 0) goto L_0x027c
            r3.c((int) r0)     // Catch:{ all -> 0x02cf }
        L_0x027c:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.u r0 = com.xiaomi.mipush.sdk.u.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            r0.a((com.xiaomi.push.hg) r3, (boolean) r4)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r1 = "mipush_extra"
            r2 = 4
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x02cf }
            java.lang.String r1 = "mipush_registed"
            r0.getBoolean(r1, r6)     // Catch:{ all -> 0x02cf }
        L_0x0293:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            addRegRequestTime(r0)     // Catch:{ all -> 0x02cf }
            scheduleOcVersionCheckJob()     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            scheduleDataCollectionJobs(r0)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            initEventPerfLogic(r0)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.w.a((android.content.Context) r0)     // Catch:{ all -> 0x02cf }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x02cf }
            java.lang.String r1 = "com.xiaomi.xmsf"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x02cf }
            if (r0 != 0) goto L_0x02cb
            com.xiaomi.channel.commonutils.logger.LoggerInterface r0 = com.xiaomi.mipush.sdk.Logger.getUserLogger()     // Catch:{ all -> 0x02cf }
            if (r0 == 0) goto L_0x02c7
            android.content.Context r0 = sContext     // Catch:{ all -> 0x02cf }
            com.xiaomi.channel.commonutils.logger.LoggerInterface r1 = com.xiaomi.mipush.sdk.Logger.getUserLogger()     // Catch:{ all -> 0x02cf }
            com.xiaomi.mipush.sdk.Logger.setLogger(r0, r1)     // Catch:{ all -> 0x02cf }
        L_0x02c7:
            r0 = 2
            com.xiaomi.channel.commonutils.logger.b.a((int) r0)     // Catch:{ all -> 0x02cf }
        L_0x02cb:
            operateSyncAction(r18)     // Catch:{ all -> 0x02cf }
            goto L_0x02d3
        L_0x02cf:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)
        L_0x02d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.initialize(android.content.Context, java.lang.String, java.lang.String, com.xiaomi.mipush.sdk.MiPushClient$MiPushClientCallback, java.lang.String, com.xiaomi.mipush.sdk.MiPushClient$ICallbackResult):void");
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, (ICallbackResult) null);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        gt gtVar = new gt();
        gtVar.a(miPushMessage.getMessageId());
        gtVar.b(miPushMessage.getTopic());
        gtVar.d(miPushMessage.getDescription());
        gtVar.c(miPushMessage.getTitle());
        gtVar.c(miPushMessage.getNotifyId());
        gtVar.a(miPushMessage.getNotifyType());
        gtVar.b(miPushMessage.getPassThrough());
        gtVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), gtVar, (String) null);
    }

    public static void clearNotification(Context context) {
        u.a(context).a(-1);
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, (String) null, (ICallbackResult) null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        s.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
        af.a(context2).a((Runnable) new Runnable() {
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, (MiPushClientCallback) null, str3, iCallbackResult);
            }
        });
    }

    public static void reportMessageClicked(Context context, String str, gt gtVar, String str2) {
        hf hfVar = new hf();
        if (!TextUtils.isEmpty(str2)) {
            hfVar.b(str2);
        } else if (b.a(context).b()) {
            hfVar.b(b.a(context).a());
        } else {
            b.d("do not report clicked message");
            return;
        }
        hfVar.c("bar:click");
        hfVar.a(str);
        hfVar.a(false);
        u.a(context).a(hfVar, gg.Notification, false, gtVar);
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(b.a(context).a())) {
            ha haVar = new ha();
            String a11 = aj.a();
            haVar.a(a11);
            haVar.b(b.a(context).a());
            haVar.c(str);
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                haVar.a(it2.next());
            }
            haVar.e(str2);
            haVar.d(context.getPackageName());
            b.e("cmd:" + str + ", " + a11);
            u.a(context).a(haVar, gg.Command, (gt) null);
        }
    }
}
