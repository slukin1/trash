package com.huobi.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import bh.l;
import bh.m;
import bh.n;
import bh.o;
import bh.p;
import bh.q;
import bh.s;
import bh.t;
import com.business.common.interceptor.ResponseHeaderInterceptor;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.router.HbgRouter;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.app.startuptasks.ADJustTask;
import com.huobi.app.startuptasks.ARouterTask;
import com.huobi.app.startuptasks.ActivityCallBackTask;
import com.huobi.app.startuptasks.AppsFlyerInitializer;
import com.huobi.app.startuptasks.BaseAppStartTask;
import com.huobi.app.startuptasks.CrashTask;
import com.huobi.app.startuptasks.EdgeEngineInitTask;
import com.huobi.app.startuptasks.FirebaseInitTask;
import com.huobi.app.startuptasks.GlobalConfigTask;
import com.huobi.app.startuptasks.HuobiDebugTask;
import com.huobi.app.startuptasks.MarketWidgetManagerTask;
import com.huobi.app.startuptasks.NetWorkTask;
import com.huobi.app.startuptasks.RMSTask;
import com.huobi.app.startuptasks.ShareTask;
import com.huobi.app.startuptasks.SystemConfigTask;
import com.huobi.app.startuptasks.SystemTask;
import com.huobi.app.startuptasks.TradeMarginTogetherTask;
import com.huobi.app.startuptasks.UIHandlerTask;
import com.huobi.app.startuptasks.WebViewTask;
import com.huobi.app.startuptasks.WoodPeckerTask;
import com.huobi.app.util.StartAppUtil;
import com.huobi.dynamiclangs.Crowdin;
import com.huobi.framework.im.common.ImManager;
import com.huobi.kyc.util.KycProxy;
import com.huobi.utils.k0;
import com.huobi.vulcan.model.VulcanInfo;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataDynamicSuperProperties;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import i6.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import ky.f;
import ky.g;
import ky.j;
import org.json.JSONObject;
import tg.r;

public class HuobiApplicationUtil {

    /* renamed from: a  reason: collision with root package name */
    public static BusinessCallbacks.ImGroupTrackListener f42137a;

    /* renamed from: b  reason: collision with root package name */
    public static BusinessCallbacks.ActivityActionListener f42138b;

    /* renamed from: c  reason: collision with root package name */
    public static md.b f42139c;

    public class a extends TimerTask {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Exception f42140b;

        public a(Exception exc) {
            this.f42140b = exc;
        }

        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("error_message", this.f42140b.getMessage());
                nc.c.a("INIT_TASK_ERROR", hashMap);
            } catch (Exception unused) {
                this.f42140b.printStackTrace();
            }
        }
    }

    public class b implements SensorsDataDynamicSuperProperties {
        public JSONObject getDynamicSuperProperties() {
            String str;
            try {
                boolean F0 = r.x().F0();
                JSONObject put = new JSONObject().put("is_login", F0).put("language_type", AppLanguageHelper.getInstance().getSensorsLanguage()).put(VulcanInfo.PLATFORM_TYPE, n0.f32119g);
                if (F0) {
                    try {
                        KycProxy l11 = KycProxy.l();
                        if (l11.m() != null) {
                            if (l11.m().getBaseInfo() != null) {
                                str = String.valueOf(l11.m().getBaseInfo().getCountryId());
                                if (!(!"0".equals(str) || l11.o() == null || l11.o().getUser_info() == null || l11.o().getUser_info().getAuth_country() == null)) {
                                    str = l11.o().getUser_info().getAuth_country().get("2");
                                }
                                if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                                    put.put("kyc_country_id", str);
                                }
                                put.put("register_country_id", r.x().M().c());
                            }
                        }
                        str = "0";
                        str = l11.o().getUser_info().getAuth_country().get("2");
                        put.put("kyc_country_id", str);
                    } catch (Exception e11) {
                        i6.d.d(e11.getMessage());
                    }
                    try {
                        put.put("register_country_id", r.x().M().c());
                    } catch (Exception e12) {
                        i6.d.d(e12.getMessage());
                    }
                }
                return put;
            } catch (Exception e13) {
                e13.printStackTrace();
                return null;
            }
        }
    }

    public class c implements md.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Application f42141a;

        public c(Application application) {
            this.f42141a = application;
        }

        public void a(String str) {
            Intent m11 = k0.m(this.f42141a, 40);
            m11.setFlags(268435456);
            this.f42141a.startActivity(m11);
            Bundle bundle = new Bundle();
            bundle.putString("liveId", str);
            HbgRouter.i(this.f42141a, "/live/room", bundle);
        }
    }

    public class d implements BusinessCallbacks.ImGroupTrackListener {
        public void onGroupChatIn(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupid", str);
            nc.c cVar = nc.c.f19348a;
            nc.c.a("APP_LIVE_group_visit", hashMap);
        }

        public void onGroupChatOut(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupid", str);
            nc.c cVar = nc.c.f19348a;
            nc.c.a("APP_LIVE_group_out", hashMap);
        }

        public void onGroupChatQuit(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupid", str);
            nc.c cVar = nc.c.f19348a;
            nc.c.a("APP_LIVE_group_outgroup", hashMap);
        }

        public void onGroupChatSend(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupid", str);
            nc.c cVar = nc.c.f19348a;
            nc.c.a("APP_LIVE_group_chat", hashMap);
        }

        public void onGroupChatShare(String str) {
            if (!StringUtils.p(str)) {
                BaseModuleConfig.a a11 = BaseModuleConfig.a();
                String a02 = a11.a0("live/chat-group?groupId=" + StringUtils.b(str));
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", a02);
                com.blankj.utilcode.util.a.g(Intent.createChooser(intent, "share"));
                LiveTrackUtils.b(str);
            }
        }
    }

    public class e implements BusinessCallbacks.ActivityActionListener {
        public Context onAttachBaseContext(Context context) {
            return com.tencent.qcloud.tuikit.tuichat.a.a(this, AppLanguageHelper.getInstance().attachBaseContext(context));
        }

        public Resources onGetResources(Resources resources) {
            return resources;
        }
    }

    public static /* synthetic */ g A(Context context, j jVar) {
        return new SmartRefreshHeader(context);
    }

    public static /* synthetic */ f B(Context context, j jVar) {
        return new SmartRefreshFooter(context);
    }

    public static void C(Context context, Application application) {
        StartAppUtil.f42183a = System.currentTimeMillis();
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil attachBaseContext start              0");
        ah.a.c().a();
        ah.b b11 = TimeMonitorManager.a().b("app_cold_launch_time");
        if (b11 != null) {
            b11.c();
        }
        js.b.f(application, false);
        q(context);
        androidx.multidex.a.l(context);
        BaseApplication.f(application);
        fs.a.c().b().execute(n.f12388b);
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil attachBaseContext  end              ");
        StartAppUtil.f42184b = System.currentTimeMillis();
    }

    public static void D(Application application) {
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil onCreate start              ");
        StartAppUtil.f42185c = System.currentTimeMillis();
        Log.d("VERSION_CODE:", "105400");
        new CrashTask().c();
        new ShareTask().c();
        c9.c.b().a(qf.a.a());
        c9.c.b().a(new ResponseHeaderInterceptor());
        bh.j.c().getSharedPreferences("mmkv_need_init_first", 0);
        if (r("pro.huobi", application)) {
            StartAppUtil.c(q.f12391b);
            fs.a.c().a().execute(o.f12389b);
            ArrayList<BaseAppStartTask> arrayList = new ArrayList<>();
            arrayList.add(new UIHandlerTask());
            arrayList.add(new NetWorkTask());
            arrayList.add(new GlobalConfigTask());
            arrayList.add(new WebViewTask());
            arrayList.add(new ARouterTask());
            arrayList.add(new ActivityCallBackTask());
            arrayList.add(new WoodPeckerTask());
            arrayList.add(new MarketWidgetManagerTask());
            arrayList.add(new FirebaseInitTask());
            arrayList.add(new EdgeEngineInitTask());
            arrayList.add(new RMSTask());
            arrayList.add(new SystemConfigTask());
            for (BaseAppStartTask baseAppStartTask : arrayList) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    baseAppStartTask.c();
                } catch (Throwable th2) {
                    k.j("Application.onCreate.task.run(Throwable) task=" + baseAppStartTask.b(), th2);
                }
                i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil task " + baseAppStartTask.b() + " " + (System.currentTimeMillis() - currentTimeMillis));
            }
            fs.a.c().b().execute(m.f12387b);
            gj.d.n().Q(System.currentTimeMillis());
            StartAppUtil.c(new l(application));
            com.huobi.edgeengine.debugger.l.f44036a.c().add("symbolselection");
            com.huobi.edgeengine.debugger.r.m(application, true);
        }
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil onCreate end                    ");
        MTCorePrivatesApi.configDebugMode(application, true);
        MTPushPrivatesApi.init(application);
        if (TextUtils.isEmpty(ku.b.e().h(application))) {
            ku.b.e().b(application);
        }
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(t.f12394a);
        SmartRefreshLayout.setDefaultRefreshFooterCreator(s.f12393a);
    }

    public static void k(Application application) {
        long currentTimeMillis = System.currentTimeMillis();
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil asyncInit start                    ");
        xm.c.c();
        Crowdin.a();
        AppLanguageHelper.getInstance().initAppLanguage(application);
        o(application);
        new AppsFlyerInitializer().a(application);
        try {
            ApplicationInfo applicationInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128);
            Twitter.initialize(new TwitterConfig.Builder(application).twitterAuthConfig(new TwitterAuthConfig(applicationInfo.metaData.getString("com.twitter.sdk.android.CONSUMER_KEY"), applicationInfo.metaData.getString("com.twitter.sdk.android.CONSUMER_SECRET"))).build());
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
        }
        m();
        n(application);
        rf.b.a(application);
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil asyncInit end            " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static String l(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == Process.myPid() && (str = next.processName) != null) {
                return str;
            }
        }
        return null;
    }

    public static void m() {
        f42137a = new d();
        f42138b = new e();
        ImManager imManager = ImManager.INSTANCE;
        imManager.setActivityActionListener(f42138b);
        imManager.setGroupTrackListener(f42137a);
    }

    public static void n(Application application) {
        f42139c = new c(application);
        md.a.f22950a.m(f42139c);
    }

    public static void o(Application application) {
        SAConfigOptions sAConfigOptions = new SAConfigOptions("https://report.daumoon.com/sa?project=production");
        sAConfigOptions.setAutoTrackEventType(15).enableLog(false);
        sAConfigOptions.enableVisualizedAutoTrack(true);
        sAConfigOptions.enableJavaScriptBridge(true);
        sAConfigOptions.enableTrackPageLeave(true);
        SensorsDataAPI.startWithConfigOptions(application, sAConfigOptions);
        SensorsDataAPI.sharedInstance().registerDynamicSuperProperties(new b());
        HashMap hashMap = new HashMap();
        hashMap.put("main_ts", Long.valueOf(StartAppUtil.f42183a));
        hashMap.put("Step_willFinishLaunch_td", Long.valueOf(StartAppUtil.f42184b - StartAppUtil.f42183a));
        hashMap.put("Step_willFinishLaunch_ts", Long.valueOf(StartAppUtil.f42184b));
        hashMap.put("Step_didFinishLaunch_td", Long.valueOf(StartAppUtil.f42185c - StartAppUtil.f42184b));
        hashMap.put("Step_didFinishLaunch_ts", Long.valueOf(StartAppUtil.f42185c));
        ah.a.c().g("appStartTime", hashMap);
    }

    public static void p() {
    }

    public static void q(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            String l11 = l(context);
            if (!TextUtils.equals("pro.huobi", l11)) {
                WebView.setDataDirectorySuffix(l11 + "huobi");
            }
        }
    }

    public static boolean r(String str, Application application) {
        String l11 = l(application);
        return !StringUtils.p(l11) && l11.equals(str);
    }

    public static /* synthetic */ void z(Application application) {
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil addTask start              ");
        ArrayList<BaseAppStartTask> arrayList = new ArrayList<>();
        arrayList.add(new SystemTask());
        arrayList.add(new HuobiDebugTask());
        arrayList.add(new ADJustTask());
        for (BaseAppStartTask baseAppStartTask : arrayList) {
            long currentTimeMillis = System.currentTimeMillis();
            baseAppStartTask.c();
            i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil task " + baseAppStartTask.b() + " " + (System.currentTimeMillis() - currentTimeMillis));
        }
        StartAppUtil.f(bh.r.f12392b);
        ArrayList<BaseAppStartTask> arrayList2 = new ArrayList<>();
        arrayList2.add(new TradeMarginTogetherTask());
        for (BaseAppStartTask baseAppStartTask2 : arrayList2) {
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                baseAppStartTask2.c();
            } catch (Exception e11) {
                new Timer().schedule(new a(e11), 5000);
            }
            i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil task " + baseAppStartTask2.b() + " " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        SP.y("isAdEnabled", true);
        if (0 == SP.g("appFirstLaunchTime", 0)) {
            SP.r("appFirstLaunchTime", System.currentTimeMillis());
        }
        fs.a.c().a().execute(p.f12390b);
        fs.a.c().a().execute(new bh.k(application));
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiApplicationUtil addTask end              ");
        StartAppUtil.e();
    }
}
