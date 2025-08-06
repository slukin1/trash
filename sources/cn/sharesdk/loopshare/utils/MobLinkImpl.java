package cn.sharesdk.loopshare.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.LoopShareActivity;
import cn.sharesdk.loopshare.RestoreSceneListener;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.SceneRestorable;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.beans.ServerData;
import cn.sharesdk.loopshare.utils.AppStatus;
import cn.sharesdk.loopshare.utils.AsyncProtocol;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MobLinkImpl {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static int f13687a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, RestoreSceneListener> f13688b;

    /* renamed from: c  reason: collision with root package name */
    private SceneRestorable f13689c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f13690d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f13691e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile Integer f13692f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public AppStatus f13693g = AppStatus.a();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public AppListener f13694h = new AppListener();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Class<? extends Activity>> f13695i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private a f13696j = new a();

    /* renamed from: k  reason: collision with root package name */
    private b f13697k = new b();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public WeakReference<Activity> f13698l = null;

    public class AppListener extends AppStatus.OnAppStatusListener {
        private AppListener() {
        }

        public void onAppStatusChanged(boolean z11) {
            MobLinkImpl.this.a(z11);
        }

        public void onCreated(Activity activity, Bundle bundle) {
            Intent intent = activity.getIntent();
            MobLinkImpl.this.a("onCreated", intent, activity);
            int isAuth = MobSDK.isAuth();
            NLog instance = MobLinkLog.getInstance();
            instance.d(MobLinkLog.FORMAT, "onCreated is intAuth, " + isAuth);
            NLog instance2 = MobLinkLog.getInstance();
            instance2.d(MobLinkLog.FORMAT, "onCreated is intAuth className, " + activity.getLocalClassName());
            Integer unused = MobLinkImpl.this.f13692f = Integer.valueOf(isAuth);
            SSDKLog b11 = SSDKLog.b();
            b11.a("Moblink", "onCreated(intAuth)==" + isAuth);
            SSDKLog b12 = SSDKLog.b();
            b12.a("Moblink", "onCreated(activity)==" + activity.getLocalClassName());
            SSDKLog b13 = SSDKLog.b();
            b13.a("Moblink", "onCreated(MOBLINK_INTERNAL_INTENT)==" + intent.getBooleanExtra("moblink_internal_intent", false));
            boolean z11 = activity instanceof LoopShareActivity;
            if (!z11 && !intent.getBooleanExtra("moblink_internal_intent", false)) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Not internal intent, ignore!");
            } else if (isAuth == 1 || isAuth == 2) {
                intent.putExtra("moblink_internal_intent", false);
                if (!z11) {
                    MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> Start main logic during CREATE.");
                }
                String stringExtra = intent.getStringExtra("_wxobject_message_ext");
                if (c.a(stringExtra)) {
                    NLog instance3 = MobLinkLog.getInstance();
                    instance3.d(MobLinkLog.FORMAT, "wechat mini program url: " + stringExtra);
                    intent.setData(Uri.parse(stringExtra));
                    MobLinkImpl.this.b(intent, activity);
                }
                if (c.b(intent)) {
                    SSDKLog.b().a("Moblink", "onCreated moblink有数据");
                    SSDKLog b14 = SSDKLog.b();
                    b14.a("Moblink", "onCreated moblink有数据(activity)==" + activity.getLocalClassName());
                    MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "HAS scene, process.");
                    MobLinkImpl.this.b(intent, activity);
                    return;
                }
                SSDKLog.b().a("Moblink", "moblink无数据");
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "NO scene, ignore.");
            } else if (z11) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Privacy Agreement is not agree, open client launchAc");
                MobLinkImpl.this.c(activity, intent);
            }
        }

        public void onResumed(Activity activity) {
            super.onResumed(activity);
            Intent intent = activity.getIntent();
            MobLinkImpl.this.a("onResumed", intent, activity);
            if (MobLinkImpl.this.f13692f == null) {
                Integer unused = MobLinkImpl.this.f13692f = Integer.valueOf(MobSDK.isAuth());
            }
            if (MobLinkImpl.this.f13692f.intValue() == 0) {
                MobLinkImpl.this.a(activity, intent);
            }
            SSDKLog b11 = SSDKLog.b();
            b11.a("Moblink", "onResumed(intAuth)==" + MobLinkImpl.this.f13692f);
            NLog instance = MobLinkLog.getInstance();
            instance.d(MobLinkLog.FORMAT, "onResumed is saveIsAuth," + MobLinkImpl.this.f13692f);
            if (MobLinkImpl.this.f13692f.intValue() == 1 || MobLinkImpl.this.f13692f.intValue() == 2) {
                SSDKLog b12 = SSDKLog.b();
                b12.a("Moblink", "onResumed（MOBLINK_INTERNAL_INTENT）==" + intent.getBooleanExtra("moblink_internal_intent", false));
                if (intent.getBooleanExtra("moblink_internal_intent", false)) {
                    intent.putExtra("moblink_internal_intent", false);
                    MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> Start main logic during RESUME.");
                    MobLinkImpl.this.b(intent, activity);
                } else {
                    MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> NO main logic during RESUME.");
                }
                if (intent.getBooleanExtra("moblink_skip_server_restore", false)) {
                    MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restored through scheme, skip server-restoring.");
                    intent.putExtra("moblink_skip_server_restore", false);
                } else if (MobLinkImpl.this.c(intent)) {
                    SSDKLog.b().a("Moblink", "onresume里面的服务器还原");
                    MobLinkImpl.this.c(intent, activity);
                }
            } else if (activity instanceof LoopShareActivity) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Privacy Agreement is not agree, open client launchAc");
                MobLinkImpl.this.c(activity, intent);
            }
        }
    }

    public class a extends AsyncProtocol.a<ConfigData> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public b f13711b;

        private a() {
        }

        /* renamed from: a */
        public void onReceiveData(ConfigData configData) {
            super.onReceiveData(configData);
            NLog instance = MobLinkLog.getInstance();
            instance.d(MobLinkLog.FORMAT, "config onReceiveData：" + configData);
            if (!ServerData.a((ServerData) configData) || this.f13711b == null) {
                NLog instance2 = MobLinkLog.getInstance();
                instance2.d(MobLinkLog.FORMAT, "config endRestoreScene：" + configData);
                MobLinkImpl.this.d();
            } else {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config onReceiveData resume");
                MobLinkImpl.this.a(this.f13711b.b(), this.f13711b.a(), this.f13711b.c());
            }
            this.f13711b = null;
        }
    }

    public class b extends AsyncProtocol.a<SceneData> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public b f13713b;

        /* renamed from: c  reason: collision with root package name */
        private int f13714c;

        private b() {
        }

        public void a(int i11) {
            this.f13714c = i11;
        }

        /* renamed from: a */
        public void onReceiveData(SceneData sceneData) {
            super.onReceiveData(sceneData);
            SSDKLog b11 = SSDKLog.b();
            b11.a("Moblink", "我是服务还原data[SceneDataListener]==" + new Hashon().fromObject(sceneData));
            if (sceneData == null || !sceneData.a_() || this.f13713b == null) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Server scene data is invalid, terminate!");
                int i11 = this.f13714c;
                if (i11 == 2) {
                    AsyncProtocol.a("", i11, 3);
                } else if (i11 == 3 && sceneData != null && !sceneData.a_()) {
                    AsyncProtocol.a("", this.f13714c, 3);
                }
                MobLinkImpl.this.d();
            } else {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Server scene data is valid, start restoring!");
                SSDKLog.b().a("Moblink", "我是服务还原data[SceneDataListener]==开始还原");
                MobLinkImpl.this.a(this.f13713b.b(), this.f13713b.a(), sceneData.a(), this.f13714c);
            }
            this.f13713b = null;
        }
    }

    public MobLinkImpl() {
        if (MobSDK.isForb()) {
            a((Activity) null, (Intent) null);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "[MobLinkImpl]Enter the countdown for the first time, wait for the privacy agreement, and then initialize.");
            return;
        }
        MobLinkLog.prepare();
        this.f13693g.a((AppStatus.OnAppStatusListener) this.f13694h);
    }

    public static /* synthetic */ int a() {
        int i11 = f13687a;
        f13687a = i11 + 1;
        return i11;
    }

    private void f(Intent intent, Activity activity) {
        SceneData.Res a11 = d.a(intent);
        if (a11 == null) {
            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: Target activity started, but no Scene!");
        } else if (activity instanceof SceneRestorable) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Current activity is SceneRestorable, return scene data to it");
            ((SceneRestorable) activity).onReturnSceneData(a11);
        } else {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Current activity is NOT SceneRestorable, use activity delegate instead");
            SceneRestorable sceneRestorable = this.f13689c;
            if (sceneRestorable != null) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Return scene data to activity delegate");
                sceneRestorable.onReturnSceneData(a11);
            } else {
                MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: No delegate found, scene data can not be returned!");
            }
        }
        a(false);
        d();
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Upload log");
        String c11 = c.c(intent.getData());
        String link = a11 != null ? a11.getLink() : null;
        if (!TextUtils.isEmpty(c11) && !TextUtils.isEmpty(link)) {
            h.a(c11);
        }
        if (!intent.getBooleanExtra("moblink_intent_from_server", false)) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Destroy scene data on server. END flow!");
            AsyncProtocol.b();
        }
    }

    private void g(Intent intent, Activity activity) {
        b(intent, activity);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c A[Catch:{ all -> 0x000b }, LOOP:0: B:12:0x001c->B:15:0x0030, LOOP_START, PHI: r3 
      PHI: (r3v1 boolean) = (r3v0 boolean), (r3v6 boolean) binds: [B:11:0x0014, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(android.content.Intent r6) {
        /*
            r5 = this;
            java.util.ArrayList<java.lang.Class<? extends android.app.Activity>> r0 = r5.f13695i
            monitor-enter(r0)
            r1 = 0
            if (r6 == 0) goto L_0x000d
            android.content.ComponentName r6 = r6.getComponent()     // Catch:{ all -> 0x000b }
            goto L_0x000e
        L_0x000b:
            r6 = move-exception
            goto L_0x0037
        L_0x000d:
            r6 = r1
        L_0x000e:
            if (r6 == 0) goto L_0x0014
            java.lang.String r1 = r6.getClassName()     // Catch:{ all -> 0x000b }
        L_0x0014:
            java.util.ArrayList<java.lang.Class<? extends android.app.Activity>> r6 = r5.f13695i     // Catch:{ all -> 0x000b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x000b }
            r2 = 0
            r3 = r2
        L_0x001c:
            boolean r4 = r6.hasNext()     // Catch:{ all -> 0x000b }
            if (r4 == 0) goto L_0x0032
            java.lang.Object r3 = r6.next()     // Catch:{ all -> 0x000b }
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x000b }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x000b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x000b }
            if (r3 == 0) goto L_0x001c
        L_0x0032:
            if (r3 != 0) goto L_0x0035
            r2 = 1
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r2
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.loopshare.utils.MobLinkImpl.d(android.content.Intent):boolean");
    }

    private String e() {
        return "ssdk" + MobSDK.getAppkey();
    }

    /* access modifiers changed from: private */
    public void c(Intent intent, Activity activity) {
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "CAUTION: Restore through server!");
        this.f13691e = true;
        a(intent, activity, true);
    }

    private void e(Intent intent, Activity activity) {
        SSDKLog.b().a("Moblink", "jumpToTargetActivity");
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Preparing to jump to target activity");
        int intExtra = intent.getIntExtra("moblink_log_scene_source", 1);
        SceneData.Res a11 = d.a(intent);
        if (a11 != null) {
            NLog instance = MobLinkLog.getInstance();
            instance.w(MobLinkLog.FORMAT, "scene:" + a11.getPath() + " params:" + a11.getParams());
        } else {
            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "scene is null");
        }
        String c11 = c.c(intent);
        NLog instance2 = MobLinkLog.getInstance();
        instance2.w(MobLinkLog.FORMAT, "jumpToTargetActivity scheme is ," + c11);
        Class a12 = a(c11, (Scene) a11);
        if (a12 != null) {
            NLog instance3 = MobLinkLog.getInstance();
            instance3.d(MobLinkLog.FORMAT, "Restoring completed. Clazz from app: " + a12.getName());
            a(activity, a12, intent);
            c(c11, (Scene) a11);
            AsyncProtocol.a("", intExtra, 1);
            return;
        }
        Class a13 = a(a11, intExtra);
        if (a13 != null) {
            NLog instance4 = MobLinkLog.getInstance();
            instance4.d(MobLinkLog.FORMAT, "Restoring completed. No Clazz from app, so obtain from MOB console: " + a13.getName());
            a(activity, a13, intent);
            c(c11, (Scene) a11);
            AsyncProtocol.a("", intExtra, 1);
        } else if (a11 != null) {
            a(activity);
            b(c11, (Scene) a11);
            if (a13 == null) {
                AsyncProtocol.a("", intExtra, 5);
            } else {
                AsyncProtocol.a("", intExtra, 6);
            }
        } else {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restoring failed. Clazz can NOT be obtained through either app nor console");
            b(c11, (Scene) a11);
            AsyncProtocol.a("", intExtra, 2);
        }
    }

    /* access modifiers changed from: private */
    public void b(Intent intent, Activity activity) {
        this.f13691e = true;
        a(intent, activity, false);
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore through scheme, mark intent to skip server-restoring.");
        intent.putExtra("moblink_skip_server_restore", true);
    }

    private boolean c() {
        return ServerData.a((ServerData) AsyncProtocol.a());
    }

    /* access modifiers changed from: private */
    public boolean c(Intent intent) {
        NLog instance = MobLinkLog.getInstance();
        instance.d(MobLinkLog.FORMAT, "enableServerRestore: " + this.f13690d);
        if (!this.f13690d || !d(intent)) {
            return false;
        }
        return true;
    }

    private boolean b(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null || !c.d(data)) {
            return false;
        }
        String host = data.getHost();
        ConfigData a11 = AsyncProtocol.a();
        String e11 = a11 != null ? a11.e() : null;
        if (host == null || !host.equals(e11)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f13691e = false;
    }

    private void d(Intent intent, Activity activity) {
        if (activity instanceof LoopShareActivity) {
            e(intent, activity);
        } else {
            f(intent, activity);
        }
    }

    public void c(String str, Scene scene) {
        RestoreSceneListener a11 = a(str);
        if (a11 != null) {
            a11.completeRestore(scene);
        }
    }

    /* access modifiers changed from: private */
    public void c(Activity activity, Intent intent) {
        SSDKLog b11 = SSDKLog.b();
        b11.a("Moblink", "activityName(startAppLaunchActivity)==" + activity.getLocalClassName());
        String a11 = a((Context) activity);
        String packageName = DH.SyncMtd.getPackageName();
        Intent intent2 = new Intent();
        intent2.setData(intent.getData());
        intent2.setClassName(packageName, a11);
        intent2.putExtra("moblink_internal_intent", false);
        intent2.putExtra("moblink_start_launcher", true);
        activity.startActivity(intent2);
    }

    public void a(RestoreSceneListener restoreSceneListener) {
        if (this.f13688b == null) {
            this.f13688b = new HashMap<>();
        }
        this.f13688b.put("key_moblink_default_restore_scene_listener", restoreSceneListener);
    }

    /* access modifiers changed from: private */
    public void b(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity, LoopShareActivity.class);
        intent.addFlags(268435456);
        intent2.setData(intent.getData());
        activity.startActivity(intent2);
    }

    public void a(String str, RestoreSceneListener restoreSceneListener) {
        if (this.f13688b == null) {
            this.f13688b = new HashMap<>();
        }
        if ("sdfwe435fdsr34656uthfwer32ufeh439==".equals(str)) {
            str = e();
        }
        this.f13688b.put(str, restoreSceneListener);
    }

    public void b(String str, Scene scene) {
        RestoreSceneListener a11 = a(str);
        if (a11 != null) {
            a11.notFoundScene(scene);
        }
    }

    /* access modifiers changed from: private */
    public void b(Activity activity, SceneRestorable sceneRestorable) {
        SceneRestorable sceneRestorable2 = this.f13689c;
        this.f13689c = sceneRestorable;
        Intent intent = activity != null ? activity.getIntent() : null;
        if (!this.f13691e && sceneRestorable2 == null && c.b(intent)) {
            g(intent, activity);
        }
    }

    public void a(Scene scene, ActionListener<String> actionListener) {
        if (!MobSDK.isForb()) {
            a.a(scene, actionListener);
        }
    }

    /* access modifiers changed from: private */
    public void a(Intent intent, Activity activity, boolean z11) {
        if (!c()) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "NO valid config, obtain config from server first");
            if (!this.f13696j.b()) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config is requsting");
                this.f13696j.a();
                b unused = this.f13696j.f13711b = new b(activity, intent, z11);
                a.a(this.f13696j);
                return;
            }
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config is requsting,so skip it");
        } else if (!z11 && b(intent)) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore Model: App Link");
            String a11 = c.a(intent);
            NLog instance = MobLinkLog.getInstance();
            instance.d(MobLinkLog.FORMAT, "linkId: " + a11);
            if (TextUtils.isEmpty(a11)) {
                d();
            } else if (!this.f13697k.b()) {
                this.f13697k.a(2);
                this.f13697k.a();
                b unused2 = this.f13697k.f13713b = new b(activity, intent, z11);
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Obtain scene from server through 'ul'");
                a.a(a11, (AsyncProtocol.DataListener<SceneData>) this.f13697k);
            }
        } else if (!z11 && a(intent)) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore Model: Scheme");
            intent.putExtra("moblink_log_scene_source", 1);
            d(intent, activity);
        } else if (!z11 || !c(intent)) {
            d();
        } else {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore Model: YYB or First run");
            boolean b11 = AppStatus.a().b();
            ConfigData a12 = AsyncProtocol.a();
            boolean a13 = a12 != null ? a12.a() : true;
            NLog instance2 = MobLinkLog.getInstance();
            instance2.d(MobLinkLog.FORMAT, "isAppFirstRun: " + b11 + ", isOpenYyb: " + a13);
            if (b11 || a13) {
                this.f13697k.a(3);
                b unused3 = this.f13697k.f13713b = new b(activity, intent, z11);
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Obtain scene from server through 'reco'");
                a.a(this.f13693g.c(), (AsyncProtocol.DataListener<SceneData>) this.f13697k);
                return;
            }
            d();
        }
    }

    private boolean a(Intent intent) {
        boolean z11;
        Uri data;
        if (intent == null || intent.getData() == null || (data = intent.getData()) == null || !c.e(data)) {
            z11 = false;
        } else {
            String str = data.getScheme() + "://" + data.getHost();
            ConfigData a11 = AsyncProtocol.a();
            z11 = g.a(str, a11 != null ? a11.d() : null);
        }
        if (!z11) {
            AsyncProtocol.a("", 1, 3);
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public void a(String str, Intent intent, Activity activity) {
        if (intent == null && activity != null) {
            intent = activity.getIntent();
        }
        Boolean bool = null;
        Uri data = intent != null ? intent.getData() : null;
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            bool = Boolean.valueOf(extras.getBoolean("moblink_internal_intent"));
        }
        NLog instance = MobLinkLog.getInstance();
        instance.d(MobLinkLog.FORMAT, "(logIntent, method is)" + str + "(), activity:" + activity + "\nextras: " + extras + "\nmoblink_internal_intent: " + bool + "\nuri: " + data + "\nintent:" + intent);
    }

    public void a(Class<? extends Activity>... clsArr) {
        if (!MobSDK.isForb()) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "CAUTION: 'Skip restore from wx' feature is activated!");
            synchronized (this.f13695i) {
                this.f13695i.clear();
                Collections.addAll(this.f13695i, clsArr);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z11) {
        NLog instance = MobLinkLog.getInstance();
        instance.d(MobLinkLog.FORMAT, "setEnableServerRestore: " + z11);
        this.f13690d = z11;
    }

    public void a(Intent intent, Activity activity) {
        if (!MobSDK.isForb()) {
            a("onNewIntent", intent, activity);
            if (intent == null || !intent.getBooleanExtra("moblink_internal_intent", false)) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "No main logic during NEWINTENT.");
                return;
            }
            intent.putExtra("moblink_internal_intent", false);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> Start main logic during NEWINTENT.");
            b(intent, activity);
        }
    }

    /* access modifiers changed from: private */
    public void a(final Activity activity, final Intent intent) {
        if (activity != null) {
            this.f13698l = new WeakReference<>(activity);
        }
        new Thread(new Runnable() {
            public void run() {
                Looper.prepare();
                final AnonymousClass1 r02 = new Handler(Looper.myLooper()) {
                    public void handleMessage(Message message) {
                        super.handleMessage(message);
                        try {
                            if (message.what == 1) {
                                AppStatus unused = MobLinkImpl.this.f13693g = AppStatus.a();
                                MobLinkImpl.this.f13693g.a((AppStatus.OnAppStatusListener) MobLinkImpl.this.f13694h);
                                MobLinkLog.prepare();
                                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "[loopRequestIsAuth(handler)]Privacy agreement confirmed, start to initialize.");
                                ComponentName componentName = new ComponentName(MobSDK.getContext().getPackageName(), LoopShareActivity.class.getName());
                                Intent intent = new Intent();
                                intent.addFlags(268435456);
                                intent.setComponent(componentName);
                                MobSDK.getContext().startActivity(intent);
                            }
                            Looper.myLooper().quit();
                        } catch (Throwable th2) {
                            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, th2);
                        }
                    }
                };
                r02.post(new Runnable() {
                    public void run() {
                        try {
                            int isAuth = MobSDK.isAuth();
                            if (isAuth == 0) {
                                MobLinkImpl.a();
                                if (MobLinkImpl.f13687a == 90) {
                                    r02.removeCallbacks(this);
                                    return;
                                }
                                Log.e("Moblink", "Privacy Agreement is not agree, Please agree to the privacy agreement first ");
                                r02.postDelayed(this, 1000);
                            } else if (isAuth != 1 && isAuth != 2) {
                                r02.removeCallbacks(this);
                            } else if (!MobSDK.isForb()) {
                                r02.removeCallbacks(this);
                                if (MobLinkImpl.this.f13698l != null) {
                                    ((Activity) MobLinkImpl.this.f13698l.get()).runOnUiThread(new Runnable() {
                                        public void run() {
                                            if (MobLinkImpl.this.f13694h != null) {
                                                AnonymousClass1 r02 = AnonymousClass1.this;
                                                MobLinkImpl.this.b(activity, intent);
                                            }
                                        }
                                    });
                                    return;
                                }
                                Message obtain = Message.obtain();
                                obtain.what = 1;
                                r02.sendMessage(obtain);
                            }
                        } catch (Throwable th2) {
                            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, th2);
                        }
                    }
                });
                Looper.loop();
            }
        }).start();
    }

    private Class a(SceneData.Res res, int i11) {
        String action = res != null ? res.getAction() : null;
        if (action == null) {
            AsyncProtocol.a("", i11, 4);
            return null;
        }
        NLog instance = MobLinkLog.getInstance();
        instance.d(MobLinkLog.FORMAT, "Find controller from SceneData.Res.action. action: " + action);
        try {
            return ReflectHelper.getClass(action);
        } catch (Throwable th2) {
            MobLinkLog.getInstance().w(th2, MobLinkLog.FORMAT, "CAUTION: Specified class can NOT be found, restoring may terminated!");
            return null;
        }
    }

    public Class a(String str, Scene scene) {
        NLog instance = MobLinkLog.getInstance();
        instance.d(MobLinkLog.FORMAT, "onWillRestoreScene scheme is, " + str);
        RestoreSceneListener a11 = a(str);
        if (a11 != null) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Global RestoreSceneListener is implemented!");
            return a11.willRestoreScene(scene);
        }
        MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: Global RestoreSceneListener is NOT implemented!");
        return null;
    }

    private RestoreSceneListener a(String str) {
        HashMap<String, RestoreSceneListener> hashMap = this.f13688b;
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        RestoreSceneListener restoreSceneListener = this.f13688b.get("key_moblink_default_restore_scene_listener");
        if ("key_moblink_default_restore_scene_listener".equals(str) || !this.f13688b.containsKey(str)) {
            NLog instance = MobLinkLog.getInstance();
            instance.d(MobLinkLog.FORMAT, "Use default RestoreSceneListener. scheme: " + str);
            return restoreSceneListener;
        }
        RestoreSceneListener restoreSceneListener2 = this.f13688b.get(str);
        NLog instance2 = MobLinkLog.getInstance();
        instance2.d(MobLinkLog.FORMAT, "Use customized RestoreSceneListener. scheme: " + str);
        return restoreSceneListener2;
    }

    /* access modifiers changed from: private */
    public void a(Intent intent, Activity activity, SceneData.Res res, int i11) {
        Uri a11 = a(res);
        Intent intent2 = new Intent();
        intent2.setData(a11);
        intent2.putExtra("moblink_intent_from_server", true);
        intent2.putExtra("moblink_log_scene_source", i11);
        SSDKLog b11 = SSDKLog.b();
        b11.a("Moblink", "服务器还原(doRestoreFromServerScene)==" + activity.getLocalClassName());
        e(intent2, activity);
    }

    private void a(Activity activity, Class cls, Intent intent) {
        Intent intent2 = new Intent();
        intent2.setClass(activity, cls);
        intent2.setData(intent.getData());
        intent2.addFlags(536870912);
        intent2.putExtra("moblink_internal_intent", true);
        activity.startActivity(intent2);
    }

    private Uri a(SceneData.Res res) {
        String a11 = d.a(res);
        ConfigData a12 = AsyncProtocol.a();
        String d11 = a12 != null ? a12.d() : null;
        if (TextUtils.isEmpty(d11) || TextUtils.isEmpty(a11)) {
            return null;
        }
        return Uri.parse(d11 + "?params=" + URLEncoder.encode(a11));
    }

    public void a(final Activity activity, final SceneRestorable sceneRestorable) {
        if (!MobSDK.isForb()) {
            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: Activity delegate set, this operation is NOT recommended except Cocos2d or Unity3d!");
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        MobLinkImpl.this.b(activity, sceneRestorable);
                    }
                });
            }
        }
    }

    private String a(Context context) {
        String packageName = DH.SyncMtd.getPackageName();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageName);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity != null) {
            return resolveActivity.activityInfo.name;
        }
        return null;
    }

    private void a(Activity activity) {
        String a11 = a((Context) activity);
        String packageName = DH.SyncMtd.getPackageName();
        Intent intent = new Intent();
        intent.setClassName(packageName, a11);
        intent.putExtra("moblink_internal_intent", false);
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }
}
