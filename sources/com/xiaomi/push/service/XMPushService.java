package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.af;
import com.xiaomi.push.ah;
import com.xiaomi.push.av;
import com.xiaomi.push.aw;
import com.xiaomi.push.ax;
import com.xiaomi.push.bb;
import com.xiaomi.push.bi;
import com.xiaomi.push.ch;
import com.xiaomi.push.co;
import com.xiaomi.push.cu;
import com.xiaomi.push.cy;
import com.xiaomi.push.dc;
import com.xiaomi.push.dq;
import com.xiaomi.push.du;
import com.xiaomi.push.ea;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import com.xiaomi.push.ez;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fe;
import com.xiaomi.push.ff;
import com.xiaomi.push.fg;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gg;
import com.xiaomi.push.gl;
import com.xiaomi.push.hc;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.hv;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.n;
import com.xiaomi.push.y;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMPushService extends Service implements fe {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f52395b = false;

    /* renamed from: a  reason: collision with root package name */
    private int f52396a = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f3277a = 0;

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f3278a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f3279a = null;

    /* renamed from: a  reason: collision with other field name */
    private ez f3280a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public fb f3281a;

    /* renamed from: a  reason: collision with other field name */
    private fc f3282a;

    /* renamed from: a  reason: collision with other field name */
    private fg f3283a = new fg() {
        public void a(fp fpVar) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a((j) new m(fpVar));
        }

        public void a(es esVar) {
            if (e.a(esVar)) {
                at.a().a(esVar.e(), SystemClock.elapsedRealtime(), (long) XMPushService.this.a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a((j) new d(esVar));
        }
    };

    /* renamed from: a  reason: collision with other field name */
    private a f3284a;

    /* renamed from: a  reason: collision with other field name */
    private f f3285a;

    /* renamed from: a  reason: collision with other field name */
    private k f3286a;

    /* renamed from: a  reason: collision with other field name */
    private r f3287a;

    /* renamed from: a  reason: collision with other field name */
    private t f3288a;

    /* renamed from: a  reason: collision with other field name */
    private ak f3289a = null;

    /* renamed from: a  reason: collision with other field name */
    private as f3290a;

    /* renamed from: a  reason: collision with other field name */
    private h f3291a;

    /* renamed from: a  reason: collision with other field name */
    private n f3292a = null;

    /* renamed from: a  reason: collision with other field name */
    public Class f3293a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private Object f3294a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<n> f3295a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private Collection<aa> f3296a = Collections.synchronizedCollection(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f3297a = false;

    /* renamed from: b  reason: collision with other field name */
    private int f3298b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f52397c = -1;

    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        private final Object f3304a;

        private a() {
            this.f3304a = new Object();
        }

        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!an.f52501r.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.a("[Alarm] cancel the old ping timer");
                ea.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000);
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }

        private void a(long j11) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f3304a) {
                try {
                    this.f3304a.wait(j11);
                } catch (InterruptedException e11) {
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] interrupt from waiting state. " + e11);
                }
            }
        }

        /* access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f3304a) {
                try {
                    this.f3304a.notifyAll();
                } catch (Exception e11) {
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] notify lock. " + e11);
                }
            }
        }
    }

    public static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        private final am.b f52415a;

        public c(am.b bVar) {
            super(12);
            this.f52415a = bVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2953a() {
            this.f52415a.a(am.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return TextUtils.equals(((c) obj).f52415a.f52470g, this.f52415a.f52470g);
        }

        public int hashCode() {
            return this.f52415a.f52470g.hashCode();
        }

        public String a() {
            return "bind time out. chid=" + this.f52415a.f52470g;
        }
    }

    public class d extends j {

        /* renamed from: a  reason: collision with root package name */
        private es f52416a = null;

        public d(es esVar) {
            super(8);
            this.f52416a = esVar;
        }

        public String a() {
            return "receive a message.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2954a() {
            XMPushService.a(XMPushService.this).a(this.f52416a);
            if (e.a(this.f52416a)) {
                XMPushService.this.a((j) new at.a(), 15000);
            }
        }
    }

    public class e extends j {
        public e() {
            super(1);
        }

        public String a() {
            return "do reconnect..";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2955a() {
            if (XMPushService.this.a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.a("should not connect. quit the job.");
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        public void onReceive(Context context, Intent intent) {
            av.a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class g extends j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f3307a;

        /* renamed from: b  reason: collision with root package name */
        public int f52420b;

        public g(int i11, Exception exc) {
            super(2);
            this.f52420b = i11;
            this.f3307a = exc;
        }

        public String a() {
            return "disconnect the connection.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2956a() {
            XMPushService.this.a(this.f52420b, this.f3307a);
        }
    }

    public class h extends j {
        public h() {
            super(65535);
        }

        public String a() {
            return "Init Job";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2957a() {
            XMPushService.b(XMPushService.this);
        }
    }

    public class i extends j {

        /* renamed from: a  reason: collision with root package name */
        private long f52422a;

        /* renamed from: a  reason: collision with other field name */
        private Intent f3308a = null;

        public i(Intent intent) {
            super(15);
            this.f3308a = intent;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2958a() {
            XMPushService.this.a(this.f3308a, this.f52422a);
        }

        public String a() {
            return "Handle intent action = " + this.f3308a.getAction();
        }

        public void a(long j11) {
            this.f52422a = j11;
        }
    }

    public static abstract class j extends n.b {
        public j(int i11) {
            super(i11);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m2959a();

        public void run() {
            int i11 = this.f52566a;
            if (!(i11 == 4 || i11 == 8)) {
                com.xiaomi.channel.commonutils.logger.b.a(com.xiaomi.channel.commonutils.logger.a.f51257a, a());
            }
            a();
        }
    }

    public class k extends BroadcastReceiver {
        public k() {
        }

        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent != null && intent.getExtras() != null) {
                XMPushService.this.onStart(intent, 1);
            }
        }
    }

    public class l extends j {
        public l() {
            super(5);
        }

        public String a() {
            return "ask the job queue to quit";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2960a() {
            XMPushService.a(XMPushService.this).a();
        }
    }

    public class m extends j {

        /* renamed from: a  reason: collision with root package name */
        private fp f52425a = null;

        public m(fp fpVar) {
            super(8);
            this.f52425a = fpVar;
        }

        public String a() {
            return "receive a message.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2961a() {
            XMPushService.a(XMPushService.this).a(this.f52425a);
        }
    }

    public interface n {
        void a();
    }

    public class o extends j {

        /* renamed from: a  reason: collision with other field name */
        public boolean f3311a;

        public o(boolean z11) {
            super(4);
            this.f3311a = z11;
        }

        public String a() {
            return "send ping..";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2962a() {
            if (XMPushService.this.c()) {
                try {
                    if (!this.f3311a) {
                        eq.a();
                    }
                    XMPushService.a(XMPushService.this).b(this.f3311a);
                } catch (fj e11) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
                    XMPushService.this.a(10, (Exception) e11);
                }
            }
        }
    }

    public class q extends j {
        public q() {
            super(3);
        }

        public String a() {
            return "reset the connection.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2964a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    public class r extends BroadcastReceiver {
        public r() {
        }

        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class t extends BroadcastReceiver {
        public t() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.b(XMPushService.this)) {
                boolean unused = XMPushService.this.f3297a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.xiaomi.push.aw] */
    private void d() {
        ? a11 = av.a();
        m.a(getApplicationContext()).a((aw) a11);
        if (a11 != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("network changed,");
            sb2.append("[" + "type: " + a11.a() + "[" + a11.b() + "], state: " + a11.a() + "/" + a11.a());
            com.xiaomi.channel.commonutils.logger.b.a("XMPushService", sb2.toString());
            NetworkInfo.State a12 = a11.a();
            if (a12 == NetworkInfo.State.SUSPENDED || a12 == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("XMPushService", "network changed, no active network");
        }
        if (ep.a() != null) {
            ep.a().a();
        }
        ga.a((Context) this);
        this.f3280a.d();
        if (av.a((Context) this)) {
            if (c() && f()) {
                b(false);
            }
            if (!c() && !d()) {
                this.f3292a.a(1);
                a((j) new e());
            }
            dc.a((Context) this).a();
        } else {
            a((j) new g(2, (Exception) null));
        }
        e();
    }

    private void e() {
        if (!a()) {
            ea.a();
        } else if (!ea.a()) {
            ea.a(true);
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m2933f() {
        if (SystemClock.elapsedRealtime() - this.f3277a < 30000) {
            return false;
        }
        return av.c(this);
    }

    /* renamed from: g  reason: collision with other method in class */
    private boolean m2934g() {
        if (!"com.xiaomi.xmsf".equals(getPackageName()) || Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) != 1) {
            return false;
        }
        return true;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m2935h() {
        boolean z11;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            com.xiaomi.channel.commonutils.logger.b.a("current sdk expect region is cn");
            z11 = com.xiaomi.push.n.China.name().equals(b.a(getApplicationContext()).a());
        } else {
            z11 = !r.a((Context) this).b(packageName);
        }
        if (!z11) {
            com.xiaomi.channel.commonutils.logger.b.a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(z11), ", package=", packageName, ", region=", b.a(getApplicationContext()).a());
        }
        return z11;
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m2936i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.b((Context) this) && !com.xiaomi.push.i.a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Object[]{new Date()})).intValue();
        int i11 = this.f52396a;
        int i12 = this.f3298b;
        if (i11 > i12) {
            if (intValue >= i11 || intValue < i12) {
                return true;
            }
        } else if (i11 < i12 && intValue >= i11 && intValue < i12) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.a((Context) this).a(gl.ForegroundServiceSwitch.a(), false);
    }

    public IBinder onBind(Intent intent) {
        return this.f3279a.getBinder();
    }

    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.s.a((Context) this);
        p a11 = q.a((Context) this);
        if (a11 != null) {
            y.a(a11.f52578a);
        }
        if (com.xiaomi.push.j.a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f3284a = new a();
            com.xiaomi.push.m.a(this, this.f3284a, new IntentFilter(an.f52501r), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            f52395b = true;
            handler.post(new Runnable() {
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th2) {
                        com.xiaomi.channel.commonutils.logger.b.a("[Alarm] disable ping receiver may be failure. " + th2);
                    }
                }
            });
        }
        this.f3279a = new Messenger(new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        int i11 = message.what;
                        if (i11 == 17) {
                            Object obj = message.obj;
                            if (obj != null) {
                                XMPushService.this.onStart((Intent) obj, 1);
                            }
                        } else if (i11 == 18) {
                            Message obtain = Message.obtain((Handler) null, 0);
                            obtain.what = 18;
                            Bundle bundle = new Bundle();
                            bundle.putString("xmsf_region", b.a(XMPushService.this.getApplicationContext()).a());
                            obtain.setData(bundle);
                            message.replyTo.send(obtain);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        ao.a(this);
        AnonymousClass9 r12 = new fc((Map) null, 5222, "xiaomi.com", (ff) null) {
            public byte[] a() {
                try {
                    dq.b bVar = new dq.b();
                    bVar.a(ax.a().a());
                    return bVar.a();
                } catch (Exception e11) {
                    com.xiaomi.channel.commonutils.logger.b.a("getOBBString err: " + e11.toString());
                    return null;
                }
            }
        };
        this.f3282a = r12;
        r12.a(true);
        this.f3280a = new ez(this, this.f3282a);
        this.f3291a = a();
        ea.a((Context) this);
        this.f3280a.a((fe) this);
        this.f3289a = new ak(this);
        this.f3290a = new as(this);
        new i().a();
        ep.a().a(this);
        this.f3292a = new n("Connection Controller Thread");
        am a12 = am.a();
        a12.b();
        a12.a((am.a) new am.a() {
            public void a() {
                XMPushService.a(XMPushService.this);
                if (am.a().a() <= 0) {
                    XMPushService xMPushService = XMPushService.this;
                    xMPushService.a((j) new g(12, (Exception) null));
                }
            }
        });
        if (k()) {
            h();
        }
        ge.a(this).a((gf) new o(this), "UPLOADER_PUSH_CHANNEL");
        a((n) new gb(this));
        a((n) new bd(this));
        if (com.xiaomi.push.j.a((Context) this)) {
            a((n) new al());
            if (com.xiaomi.push.i.a()) {
                a((n) new n() {
                    public void a() {
                        bi.a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        a((j) new h());
        this.f3296a.add(ay.a((Context) this));
        if (h()) {
            this.f3285a = new f();
            com.xiaomi.push.m.a((Context) this, (BroadcastReceiver) this.f3285a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
            this.f3294a = av.a((Context) this);
        }
        if (com.xiaomi.push.j.a(getApplicationContext())) {
            this.f3288a = new t();
            com.xiaomi.push.m.a(this, this.f3288a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", (Handler) null, 2);
            k kVar = new k();
            this.f3286a = kVar;
            com.xiaomi.push.m.a(this, kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", (Handler) null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f3278a = new ContentObserver(new Handler(Looper.getMainLooper())) {
                    public void onChange(boolean z11) {
                        super.onChange(z11);
                        boolean a11 = XMPushService.a(XMPushService.this);
                        com.xiaomi.channel.commonutils.logger.b.a("SuperPowerMode:" + a11);
                        XMPushService.a(XMPushService.this);
                        if (a11) {
                            XMPushService xMPushService = XMPushService.this;
                            xMPushService.a((j) new g(24, (Exception) null));
                            return;
                        }
                        XMPushService.this.a(true);
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f3278a);
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] a13 = a();
            if (a13 != null) {
                this.f3287a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                com.xiaomi.push.m.a((Context) this, (BroadcastReceiver) this.f3287a, intentFilter, (String) null, (Handler) null);
                this.f52396a = a13[0];
                this.f3298b = a13[1];
                com.xiaomi.channel.commonutils.logger.b.a("falldown initialized: " + this.f52396a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f3298b);
            }
        }
        co.a((Context) this, (fb) this.f3280a);
        cu.a(this, this.f3280a);
        String str = "";
        if (a11 != null) {
            try {
                if (!TextUtils.isEmpty(a11.f3412a) && (split = a11.f3412a.split(TIMMentionEditText.TIM_MENTION_TAG)) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        cy.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    public void onDestroy() {
        f fVar = this.f3285a;
        if (fVar != null) {
            a((BroadcastReceiver) fVar);
            this.f3285a = null;
        }
        Object obj = this.f3294a;
        if (obj != null) {
            av.a((Context) this, obj);
            this.f3294a = null;
        }
        t tVar = this.f3288a;
        if (tVar != null) {
            a((BroadcastReceiver) tVar);
            this.f3288a = null;
        }
        k kVar = this.f3286a;
        if (kVar != null) {
            a((BroadcastReceiver) kVar);
            this.f3286a = null;
        }
        r rVar = this.f3287a;
        if (rVar != null) {
            a((BroadcastReceiver) rVar);
            this.f3287a = null;
        }
        a aVar = this.f3284a;
        if (aVar != null) {
            a((BroadcastReceiver) aVar);
            this.f3284a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f3278a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f3278a);
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f3296a.clear();
        this.f3292a.b();
        a((j) new j(2) {
            public String a() {
                return "disconnect for service destroy.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m2951a() {
                if (XMPushService.a(XMPushService.this) != null) {
                    XMPushService.a(XMPushService.this).b(15, (Exception) null);
                    fb unused = XMPushService.this.f3281a = null;
                }
            }
        });
        a((j) new l());
        am.a().b();
        am.a().a((Context) this, 15);
        am.a().a();
        this.f3280a.b((fe) this);
        ax.a().a();
        ea.a();
        i();
        co.b(this, this.f3280a);
        cu.b(this, this.f3280a);
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
    }

    public void onStart(Intent intent, int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(an.f52506w);
                String stringExtra2 = intent.getStringExtra(an.G);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (!"miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                        com.xiaomi.channel.commonutils.logger.b.a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", new Object[]{intent.getAction(), stringExtra, stringExtra2, stringExtra3}));
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", new Object[]{intent.getAction(), stringExtra, stringExtra2, stringExtra3, com.xiaomi.push.j.a(intent)}));
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th2.getMessage());
                return;
            }
        }
        if (!(intent == null || intent.getAction() == null)) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f3292a.a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    am.a().a((Context) this, 14);
                    stopSelf();
                } else {
                    a((j) new i(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                i iVar = new i(intent);
                iVar.a(currentTimeMillis);
                a((j) iVar);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        onStart(intent, i12);
        return com.xiaomi.push.j.a((Context) this) ? 1 : 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00de A[Catch:{ Exception -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r10 = this;
            com.xiaomi.push.ch r0 = com.xiaomi.push.ch.a()
            r0.d()
            android.content.Context r0 = r10.getApplicationContext()
            com.xiaomi.push.service.m r0 = com.xiaomi.push.service.m.a((android.content.Context) r0)
            r0.a()
            android.content.Context r0 = r10.getApplicationContext()
            com.xiaomi.push.service.b r0 = com.xiaomi.push.service.b.a(r0)
            java.lang.String r1 = r0.a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "region of cache is "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "XMPushService"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3, (java.lang.String) r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x004c
            java.lang.String r1 = r10.b()
            com.xiaomi.push.n r2 = com.xiaomi.push.j.a((java.lang.String) r1)
            java.lang.String r2 = r2.name()
            r9 = r2
            r2 = r1
            r1 = r9
            goto L_0x004d
        L_0x004c:
            r2 = r4
        L_0x004d:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r6 = "CN"
            java.lang.String r7 = "com.xiaomi.xmsf"
            r8 = 1
            if (r5 != 0) goto L_0x006c
            com.xiaomi.push.n r5 = com.xiaomi.push.n.China
            java.lang.String r5 = r5.name()
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x006c
            r0.a(r1, r8)
            r0.b(r6, r8)
        L_0x006a:
            r2 = r6
            goto L_0x0092
        L_0x006c:
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x008c
            java.lang.String r1 = r10.getPackageName()
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x007e
            r6 = r4
            goto L_0x0084
        L_0x007e:
            com.xiaomi.push.n r1 = com.xiaomi.push.n.China
            java.lang.String r4 = r1.name()
        L_0x0084:
            r0.a(r4, r8)
            r0.b(r6, r8)
            r1 = r4
            goto L_0x006a
        L_0x008c:
            com.xiaomi.push.n r0 = com.xiaomi.push.n.China
            java.lang.String r1 = r0.name()
        L_0x0092:
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4 = 0
            java.lang.String r5 = "after check, appRegion is "
            r0[r4] = r5
            r0[r8] = r1
            r4 = 2
            java.lang.String r5 = ", countryCode="
            r0[r4] = r5
            r4 = 3
            r0[r4] = r2
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3, (java.lang.Object[]) r0)
            com.xiaomi.push.n r0 = com.xiaomi.push.n.China
            java.lang.String r0 = r0.name()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b8
            java.lang.String r0 = "cn.app.chat.xiaomi.net"
            com.xiaomi.push.fc.a((java.lang.String) r0)
        L_0x00b8:
            a((java.lang.String) r1)
            boolean r0 = r10.h()
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = "-->postOnCreate(): try trigger connect now"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3, (java.lang.String) r0)
            com.xiaomi.push.service.XMPushService$13 r0 = new com.xiaomi.push.service.XMPushService$13
            r1 = 11
            r0.<init>(r1)
            r10.a((com.xiaomi.push.service.XMPushService.j) r0)
            com.xiaomi.push.service.XMPushService$14 r1 = new com.xiaomi.push.service.XMPushService$14
            r1.<init>(r0)
            com.xiaomi.push.service.q.a((com.xiaomi.push.service.q.a) r1)
        L_0x00d8:
            boolean r0 = com.xiaomi.push.s.a()     // Catch:{ Exception -> 0x00e4 }
            if (r0 == 0) goto L_0x00e8
            com.xiaomi.push.service.h r0 = r10.f3291a     // Catch:{ Exception -> 0x00e4 }
            r0.a((android.content.Context) r10)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00e8
        L_0x00e4:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)
        L_0x00e8:
            java.lang.String r0 = r10.getPackageName()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00f9
            android.content.pm.ApplicationInfo r0 = r10.getApplicationInfo()
            com.xiaomi.push.g.a((android.content.Context) r10, (android.content.pm.ApplicationInfo) r0, (boolean) r8)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.c():void");
    }

    private String b() {
        String str;
        ah.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i11 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            ap a11 = ap.a(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && a11.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i11 < 30) {
                            obj.wait(1000);
                        } else {
                            obj.wait(30000);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i11++;
            }
            str = a();
        } else {
            str = "CN";
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.xiaomi.channel.commonutils.logger.b.a("wait coutrycode :" + str + " cost = " + elapsedRealtime2 + " , count = " + i11);
        return str;
    }

    /* access modifiers changed from: private */
    public void f() {
        fb fbVar = this.f3281a;
        if (fbVar == null || !fbVar.b()) {
            fb fbVar2 = this.f3281a;
            if (fbVar2 == null || !fbVar2.c()) {
                this.f3282a.b(av.a((Context) this));
                g();
                if (this.f3281a == null) {
                    am.a().a((Context) this);
                    c(false);
                    return;
                }
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
    }

    private void g() {
        try {
            this.f3280a.a(this.f3283a, (fl) new fl() {
                public boolean a(fp fpVar) {
                    return true;
                }
            });
            this.f3280a.e();
            this.f3281a = this.f3280a;
        } catch (fj e11) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", (Throwable) e11);
            this.f3280a.b(3, e11);
        }
    }

    private void i() {
        synchronized (this.f3295a) {
            this.f3295a.clear();
        }
    }

    public class p extends j {

        /* renamed from: a  reason: collision with other field name */
        public am.b f3312a = null;

        public p(am.b bVar) {
            super(4);
            this.f3312a = bVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2963a() {
            try {
                this.f3312a.a(am.c.unbind, 1, 16, (String) null, (String) null);
                fb a11 = XMPushService.a(XMPushService.this);
                am.b bVar = this.f3312a;
                a11.a(bVar.f52470g, bVar.f3346b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a((j) new b(this.f3312a), 300);
            } catch (fj e11) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
                XMPushService.this.a(10, (Exception) e11);
            }
        }

        public String a() {
            return "rebind the client. " + this.f3312a.f52470g;
        }
    }

    public class s extends j {

        /* renamed from: a  reason: collision with other field name */
        public am.b f3313a = null;

        /* renamed from: a  reason: collision with other field name */
        public String f3314a;

        /* renamed from: b  reason: collision with root package name */
        public int f52431b;

        /* renamed from: b  reason: collision with other field name */
        public String f3315b;

        public s(am.b bVar, int i11, String str, String str2) {
            super(9);
            this.f3313a = bVar;
            this.f52431b = i11;
            this.f3314a = str;
            this.f3315b = str2;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2965a() {
            if (!(this.f3313a.f3341a == am.c.unbind || XMPushService.a(XMPushService.this) == null)) {
                try {
                    fb a11 = XMPushService.a(XMPushService.this);
                    am.b bVar = this.f3313a;
                    a11.a(bVar.f52470g, bVar.f3346b);
                } catch (fj e11) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
                    XMPushService.this.a(10, (Exception) e11);
                }
            }
            this.f3313a.a(am.c.unbind, this.f52431b, 0, this.f3315b, this.f3314a);
        }

        public String a() {
            return "unbind the channel. " + this.f3313a.f52470g;
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m2932e() {
        return f52395b;
    }

    public class b extends j {

        /* renamed from: a  reason: collision with other field name */
        public am.b f3305a = null;

        public b(am.b bVar) {
            super(9);
            this.f3305a = bVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2952a() {
            try {
                if (!XMPushService.this.c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                am a11 = am.a();
                am.b bVar = this.f3305a;
                am.b a12 = a11.a(bVar.f52470g, bVar.f3346b);
                if (a12 == null) {
                    com.xiaomi.channel.commonutils.logger.b.a("ignore bind because the channel " + this.f3305a.f52470g + " is removed ");
                } else if (a12.f3341a == am.c.unbind) {
                    a12.a(am.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.a(XMPushService.this).a(a12);
                    eq.a(XMPushService.this, a12);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.a("trying duplicate bind, ingore! " + a12.f3341a);
                }
            } catch (Exception e11) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e11);
                XMPushService.this.a(10, e11);
            } catch (Throwable unused) {
            }
        }

        public String a() {
            return "bind the client. " + this.f3305a.f52470g;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m2937a() {
        if (this.f52397c < 0) {
            this.f52397c = com.xiaomi.push.g.a((Context) this, "com.xiaomi.xmsf");
        }
        return this.f52397c;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m2931a() {
        String[] split;
        String a11 = ah.a(getApplicationContext()).a(gl.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a11) && (split = a11.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] < 0 || iArr[0] > 23 || iArr[1] < 0 || iArr[1] > 23 || iArr[0] == iArr[1]) {
                    return null;
                }
                return iArr;
            } catch (NumberFormatException e11) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e11);
            }
        }
        return null;
    }

    private void b(boolean z11) {
        this.f3277a = SystemClock.elapsedRealtime();
        if (!c()) {
            a(true);
        } else if (av.a((Context) this)) {
            c((j) new o(z11));
        } else {
            c((j) new g(17, (Exception) null));
            a(true);
        }
    }

    private String a() {
        String a11 = com.xiaomi.push.j.a("ro.miui.region");
        return TextUtils.isEmpty(a11) ? com.xiaomi.push.j.a("ro.product.locale.region") : a11;
    }

    private void b(Intent intent) {
        long j11;
        String stringExtra = intent.getStringExtra(an.G);
        String stringExtra2 = intent.getStringExtra(an.K);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        am a11 = am.a();
        es esVar = null;
        if (bundleExtra != null) {
            fo foVar = (fo) a((fp) new fo(bundleExtra), stringExtra, stringExtra2);
            if (foVar != null) {
                esVar = es.a((fp) foVar, a11.a(foVar.k(), foVar.m()).f52471h);
            } else {
                return;
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j11 = Long.parseLong(intent.getStringExtra(an.f52503t));
                } catch (NumberFormatException unused) {
                    j11 = 0;
                }
                String stringExtra3 = intent.getStringExtra(an.f52504u);
                String stringExtra4 = intent.getStringExtra(an.f52505v);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                am.b a12 = a11.a(stringExtra5, String.valueOf(j11));
                if (a12 != null) {
                    es esVar2 = new es();
                    try {
                        esVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    esVar2.a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    esVar2.a(j11, stringExtra3, stringExtra4);
                    esVar2.a(intent.getStringExtra("ext_pkt_id"));
                    esVar2.a(byteArrayExtra, a12.f52471h);
                    com.xiaomi.channel.commonutils.logger.b.a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    esVar = esVar2;
                }
            }
        }
        if (esVar != null) {
            c((j) new aw(this, esVar));
        }
    }

    private static void a(String str) {
        if (com.xiaomi.push.n.China.name().equals(str)) {
            ch.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            ch.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            ch.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            ch.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            ch.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            ch.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            ch.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m2947d() {
        fb fbVar = this.f3281a;
        return fbVar != null && fbVar.b();
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(an.G);
        String stringExtra2 = intent.getStringExtra(an.K);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fo[] foVarArr = new fo[length];
        intent.getBooleanExtra("ext_encrypt", true);
        int i11 = 0;
        while (i11 < parcelableArrayExtra.length) {
            foVarArr[i11] = new fo((Bundle) parcelableArrayExtra[i11]);
            foVarArr[i11] = (fo) a((fp) foVarArr[i11], stringExtra, stringExtra2);
            if (foVarArr[i11] != null) {
                i11++;
            } else {
                return;
            }
        }
        am a11 = am.a();
        es[] esVarArr = new es[length];
        for (int i12 = 0; i12 < length; i12++) {
            fo foVar = foVarArr[i12];
            esVarArr[i12] = es.a((fp) foVar, a11.a(foVar.k(), foVar.m()).f52471h);
        }
        c((j) new c(this, esVarArr));
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("digest");
            m.a(getApplicationContext()).a(string);
            co.a((Context) this, string);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2940a() {
        if (SystemClock.elapsedRealtime() - this.f3277a >= ((long) fh.a()) && av.c(this)) {
            b(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: com.xiaomi.push.service.am$b} */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:352:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Intent r16, long r17) {
        /*
            r15 = this;
            r7 = r15
            r0 = r16
            r1 = r17
            com.xiaomi.push.service.am r3 = com.xiaomi.push.service.am.a()
            java.lang.String r4 = com.xiaomi.push.service.an.f52487d
            java.lang.String r5 = r16.getAction()
            boolean r4 = r4.equalsIgnoreCase(r5)
            r5 = 2
            r6 = 1
            r8 = 0
            if (r4 != 0) goto L_0x0872
            java.lang.String r4 = com.xiaomi.push.service.an.f52493j
            java.lang.String r9 = r16.getAction()
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x0026
            goto L_0x0872
        L_0x0026:
            java.lang.String r4 = com.xiaomi.push.service.an.f52492i
            java.lang.String r9 = r16.getAction()
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x0097
            java.lang.String r1 = com.xiaomi.push.service.an.G
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.an.f52506w
            java.lang.String r2 = r0.getStringExtra(r2)
            java.lang.String r4 = com.xiaomi.push.service.an.f52503t
            java.lang.String r0 = r0.getStringExtra(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Service called close channel chid = "
            r4.append(r6)
            r4.append(r2)
            java.lang.String r6 = " res = "
            r4.append(r6)
            java.lang.String r6 = com.xiaomi.push.service.am.b.a((java.lang.String) r0)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r4)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L_0x0082
            java.util.List r0 = r3.a((java.lang.String) r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0072:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x08fc
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r15.a((java.lang.String) r1, (int) r5)
            goto L_0x0072
        L_0x0082:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x008d
            r15.a((java.lang.String) r2, (int) r5)
            goto L_0x08fc
        L_0x008d:
            r4 = 2
            r5 = 0
            r6 = 0
            r1 = r15
            r3 = r0
            r1.a(r2, r3, r4, r5, r6)
            goto L_0x08fc
        L_0x0097:
            java.lang.String r4 = com.xiaomi.push.service.an.f52488e
            java.lang.String r5 = r16.getAction()
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x00a8
            r15.b((android.content.Intent) r16)
            goto L_0x08fc
        L_0x00a8:
            java.lang.String r4 = com.xiaomi.push.service.an.f52490g
            java.lang.String r5 = r16.getAction()
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x00b9
            r15.c((android.content.Intent) r16)
            goto L_0x08fc
        L_0x00b9:
            java.lang.String r4 = com.xiaomi.push.service.an.f52489f
            java.lang.String r5 = r16.getAction()
            boolean r4 = r4.equalsIgnoreCase(r5)
            java.lang.String r5 = "ext_packet"
            if (r4 == 0) goto L_0x00fe
            java.lang.String r1 = com.xiaomi.push.service.an.G
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.an.K
            java.lang.String r2 = r0.getStringExtra(r2)
            android.os.Bundle r0 = r0.getBundleExtra(r5)
            com.xiaomi.push.fn r4 = new com.xiaomi.push.fn
            r4.<init>(r0)
            com.xiaomi.push.fp r0 = r15.a((com.xiaomi.push.fp) r4, (java.lang.String) r1, (java.lang.String) r2)
            if (r0 == 0) goto L_0x08fc
            java.lang.String r1 = r0.k()
            java.lang.String r2 = r0.m()
            com.xiaomi.push.service.am$b r1 = r3.a((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.f52471h
            com.xiaomi.push.es r0 = com.xiaomi.push.es.a((com.xiaomi.push.fp) r0, (java.lang.String) r1)
            com.xiaomi.push.service.aw r1 = new com.xiaomi.push.service.aw
            r1.<init>(r15, r0)
            r15.c((com.xiaomi.push.service.XMPushService.j) r1)
            goto L_0x08fc
        L_0x00fe:
            java.lang.String r4 = com.xiaomi.push.service.an.f52491h
            java.lang.String r9 = r16.getAction()
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x0141
            java.lang.String r1 = com.xiaomi.push.service.an.G
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.an.K
            java.lang.String r2 = r0.getStringExtra(r2)
            android.os.Bundle r0 = r0.getBundleExtra(r5)
            com.xiaomi.push.fr r4 = new com.xiaomi.push.fr
            r4.<init>((android.os.Bundle) r0)
            com.xiaomi.push.fp r0 = r15.a((com.xiaomi.push.fp) r4, (java.lang.String) r1, (java.lang.String) r2)
            if (r0 == 0) goto L_0x08fc
            java.lang.String r1 = r0.k()
            java.lang.String r2 = r0.m()
            com.xiaomi.push.service.am$b r1 = r3.a((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.f52471h
            com.xiaomi.push.es r0 = com.xiaomi.push.es.a((com.xiaomi.push.fp) r0, (java.lang.String) r1)
            com.xiaomi.push.service.aw r1 = new com.xiaomi.push.service.aw
            r1.<init>(r15, r0)
            r15.c((com.xiaomi.push.service.XMPushService.j) r1)
            goto L_0x08fc
        L_0x0141:
            java.lang.String r4 = com.xiaomi.push.service.an.f52494k
            java.lang.String r5 = r16.getAction()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x01aa
            java.lang.String r1 = com.xiaomi.push.service.an.f52506w
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.an.f52503t
            java.lang.String r2 = r0.getStringExtra(r2)
            if (r1 == 0) goto L_0x08fc
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "request reset connection from chid = "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3)
            com.xiaomi.push.service.am r3 = com.xiaomi.push.service.am.a()
            com.xiaomi.push.service.am$b r1 = r3.a((java.lang.String) r1, (java.lang.String) r2)
            if (r1 == 0) goto L_0x08fc
            java.lang.String r2 = r1.f52471h
            java.lang.String r3 = com.xiaomi.push.service.an.C
            java.lang.String r0 = r0.getStringExtra(r3)
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x08fc
            com.xiaomi.push.service.am$c r0 = r1.f3341a
            com.xiaomi.push.service.am$c r1 = com.xiaomi.push.service.am.c.binded
            if (r0 != r1) goto L_0x08fc
            com.xiaomi.push.fb r0 = r15.a()
            if (r0 == 0) goto L_0x01a0
            long r1 = android.os.SystemClock.elapsedRealtime()
            r3 = 15000(0x3a98, double:7.411E-320)
            long r1 = r1 - r3
            boolean r0 = r0.a((long) r1)
            if (r0 != 0) goto L_0x08fc
        L_0x01a0:
            com.xiaomi.push.service.XMPushService$q r0 = new com.xiaomi.push.service.XMPushService$q
            r0.<init>()
            r15.c((com.xiaomi.push.service.XMPushService.j) r0)
            goto L_0x08fc
        L_0x01aa:
            java.lang.String r4 = com.xiaomi.push.service.an.f52495l
            java.lang.String r5 = r16.getAction()
            boolean r4 = r4.equals(r5)
            r9 = 0
            if (r4 == 0) goto L_0x023a
            java.lang.String r1 = com.xiaomi.push.service.an.G
            java.lang.String r1 = r0.getStringExtra(r1)
            java.util.List r2 = r3.a((java.lang.String) r1)
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x01dc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "open channel should be called first before update info, pkg="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            return
        L_0x01dc:
            java.lang.String r1 = com.xiaomi.push.service.an.f52506w
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r4 = com.xiaomi.push.service.an.f52503t
            java.lang.String r4 = r0.getStringExtra(r4)
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L_0x01f4
            java.lang.Object r1 = r2.get(r8)
            java.lang.String r1 = (java.lang.String) r1
        L_0x01f4:
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto L_0x0212
            java.util.Collection r1 = r3.a((java.lang.String) r1)
            if (r1 == 0) goto L_0x0216
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0216
            java.util.Iterator r1 = r1.iterator()
            java.lang.Object r1 = r1.next()
            r9 = r1
            com.xiaomi.push.service.am$b r9 = (com.xiaomi.push.service.am.b) r9
            goto L_0x0216
        L_0x0212:
            com.xiaomi.push.service.am$b r9 = r3.a((java.lang.String) r1, (java.lang.String) r4)
        L_0x0216:
            if (r9 == 0) goto L_0x08fc
            java.lang.String r1 = com.xiaomi.push.service.an.E
            boolean r1 = r0.hasExtra(r1)
            if (r1 == 0) goto L_0x0228
            java.lang.String r1 = com.xiaomi.push.service.an.E
            java.lang.String r1 = r0.getStringExtra(r1)
            r9.f52468e = r1
        L_0x0228:
            java.lang.String r1 = com.xiaomi.push.service.an.F
            boolean r1 = r0.hasExtra(r1)
            if (r1 == 0) goto L_0x08fc
            java.lang.String r1 = com.xiaomi.push.service.an.F
            java.lang.String r0 = r0.getStringExtra(r1)
            r9.f52469f = r0
            goto L_0x08fc
        L_0x023a:
            java.lang.String r3 = r16.getAction()
            java.lang.String r4 = "android.intent.action.SCREEN_ON"
            boolean r3 = r4.equals(r3)
            java.lang.String r5 = "android.intent.action.SCREEN_OFF"
            if (r3 != 0) goto L_0x0829
            java.lang.String r3 = r16.getAction()
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0254
            goto L_0x0829
        L_0x0254:
            java.lang.String r3 = r16.getAction()
            java.lang.String r4 = "com.xiaomi.mipush.REGISTER_APP"
            boolean r3 = r4.equals(r3)
            java.lang.String r4 = "com.xiaomi.xmsf"
            java.lang.String r5 = "mipush_payload"
            java.lang.String r10 = "mipush_app_package"
            if (r3 == 0) goto L_0x02d7
            android.content.Context r1 = r15.getApplicationContext()
            com.xiaomi.push.service.ap r1 = com.xiaomi.push.service.ap.a(r1)
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x029b
            android.content.Context r1 = r15.getApplicationContext()
            com.xiaomi.push.service.ap r1 = com.xiaomi.push.service.ap.a(r1)
            int r1 = r1.a()
            if (r1 != 0) goto L_0x029b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "register without being provisioned. "
            r1.append(r2)
            java.lang.String r0 = r0.getStringExtra(r10)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            return
        L_0x029b:
            byte[] r9 = r0.getByteArrayExtra(r5)
            java.lang.String r5 = r0.getStringExtra(r10)
            java.lang.String r1 = "mipush_env_chanage"
            boolean r1 = r0.getBooleanExtra(r1, r8)
            java.lang.String r2 = "mipush_env_type"
            int r0 = r0.getIntExtra(r2, r6)
            com.xiaomi.push.service.r r2 = com.xiaomi.push.service.r.a((android.content.Context) r15)
            r2.d(r5)
            if (r1 == 0) goto L_0x02d2
            java.lang.String r1 = r15.getPackageName()
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x02d2
            com.xiaomi.push.service.XMPushService$2 r8 = new com.xiaomi.push.service.XMPushService$2
            r3 = 14
            r1 = r8
            r2 = r15
            r4 = r0
            r6 = r9
            r1.<init>(r3, r4, r5, r6)
            r15.c((com.xiaomi.push.service.XMPushService.j) r8)
            goto L_0x08fc
        L_0x02d2:
            r15.a((byte[]) r9, (java.lang.String) r5)
            goto L_0x08fc
        L_0x02d7:
            java.lang.String r3 = r16.getAction()
            java.lang.String r11 = "com.xiaomi.mipush.SEND_MESSAGE"
            boolean r3 = r11.equals(r3)
            java.lang.String r12 = "com.xiaomi.mipush.UNREGISTER_APP"
            if (r3 != 0) goto L_0x07ca
            java.lang.String r3 = r16.getAction()
            boolean r3 = r12.equals(r3)
            if (r3 == 0) goto L_0x02f1
            goto L_0x07ca
        L_0x02f1:
            java.lang.String r3 = com.xiaomi.push.service.aq.f52512a
            java.lang.String r11 = r16.getAction()
            boolean r3 = r3.equals(r11)
            java.lang.String r11 = "pref_registered_pkg_names"
            if (r3 == 0) goto L_0x03da
            java.lang.String r1 = "uninstall_pkg_name"
            java.lang.String r0 = r0.getStringExtra(r1)
            if (r0 == 0) goto L_0x03d9
            java.lang.String r1 = r0.trim()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0313
            goto L_0x03d9
        L_0x0313:
            android.content.pm.PackageManager r1 = r15.getPackageManager()     // Catch:{ NameNotFoundException -> 0x033f }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r0, r8)     // Catch:{ NameNotFoundException -> 0x033f }
            if (r1 == 0) goto L_0x033e
            android.content.pm.ApplicationInfo r2 = r1.applicationInfo     // Catch:{ NameNotFoundException -> 0x033f }
            if (r2 == 0) goto L_0x033e
            java.lang.String r1 = r1.packageName     // Catch:{ NameNotFoundException -> 0x033f }
            boolean r1 = com.xiaomi.push.i.a((android.content.Context) r15, (java.lang.String) r1)     // Catch:{ NameNotFoundException -> 0x033f }
            if (r1 == 0) goto L_0x033e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x033f }
            r1.<init>()     // Catch:{ NameNotFoundException -> 0x033f }
            java.lang.String r2 = "dual space's app uninstalled "
            r1.append(r2)     // Catch:{ NameNotFoundException -> 0x033f }
            r1.append(r0)     // Catch:{ NameNotFoundException -> 0x033f }
            java.lang.String r1 = r1.toString()     // Catch:{ NameNotFoundException -> 0x033f }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)     // Catch:{ NameNotFoundException -> 0x033f }
            goto L_0x033f
        L_0x033e:
            r6 = r8
        L_0x033f:
            java.lang.String r1 = "com.xiaomi.channel"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0362
            com.xiaomi.push.service.am r1 = com.xiaomi.push.service.am.a()
            java.lang.String r2 = "1"
            java.util.Collection r1 = r1.a((java.lang.String) r2)
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0362
            if (r6 == 0) goto L_0x0362
            r15.a((java.lang.String) r2, (int) r8)
            java.lang.String r0 = "close the miliao channel as the app is uninstalled."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            return
        L_0x0362:
            android.content.SharedPreferences r1 = r15.getSharedPreferences(r11, r8)
            java.lang.String r2 = r1.getString(r0, r9)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x08fc
            if (r6 == 0) goto L_0x08fc
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.remove(r0)
            r1.commit()
            boolean r1 = com.xiaomi.push.service.x.b((android.content.Context) r15, (java.lang.String) r0)
            if (r1 == 0) goto L_0x0385
            com.xiaomi.push.service.x.c(r15, r0)
        L_0x0385:
            com.xiaomi.push.service.x.a((android.content.Context) r15, (java.lang.String) r0)
            android.content.Context r1 = r15.getApplicationContext()
            com.xiaomi.push.service.ac.a((android.content.Context) r1, (java.lang.String) r0)
            boolean r1 = r15.c()
            if (r1 == 0) goto L_0x08fc
            if (r2 == 0) goto L_0x08fc
            com.xiaomi.push.hc r1 = com.xiaomi.push.service.w.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ fj -> 0x03b9 }
            com.xiaomi.push.service.w.a((com.xiaomi.push.service.XMPushService) r15, (com.xiaomi.push.hc) r1)     // Catch:{ fj -> 0x03b9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ fj -> 0x03b9 }
            r1.<init>()     // Catch:{ fj -> 0x03b9 }
            java.lang.String r2 = "uninstall "
            r1.append(r2)     // Catch:{ fj -> 0x03b9 }
            r1.append(r0)     // Catch:{ fj -> 0x03b9 }
            java.lang.String r0 = " msg sent"
            r1.append(r0)     // Catch:{ fj -> 0x03b9 }
            java.lang.String r0 = r1.toString()     // Catch:{ fj -> 0x03b9 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ fj -> 0x03b9 }
            goto L_0x08fc
        L_0x03b9:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fail to send Message: "
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r1)
            r1 = 10
            r15.a((int) r1, (java.lang.Exception) r0)
            goto L_0x08fc
        L_0x03d9:
            return
        L_0x03da:
            java.lang.String r3 = com.xiaomi.push.service.aq.f52513b
            java.lang.String r12 = r16.getAction()
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x0450
            java.lang.String r1 = "data_cleared_pkg_name"
            java.lang.String r1 = r0.getStringExtra(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x03f3
            return
        L_0x03f3:
            android.content.SharedPreferences r2 = r15.getSharedPreferences(r11, r8)     // Catch:{ all -> 0x0401 }
            if (r2 == 0) goto L_0x0417
            java.lang.String r0 = r2.getString(r1, r9)     // Catch:{ all -> 0x03ff }
            r9 = r0
            goto L_0x0417
        L_0x03ff:
            r0 = move-exception
            goto L_0x0403
        L_0x0401:
            r0 = move-exception
            r2 = r9
        L_0x0403:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Fail to get sp or appId : "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
        L_0x0417:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x043e
            android.content.SharedPreferences$Editor r0 = r2.edit()
            r0.remove(r1)
            r0.commit()
            boolean r0 = com.xiaomi.push.service.x.b((android.content.Context) r15, (java.lang.String) r1)
            if (r0 == 0) goto L_0x0430
            com.xiaomi.push.service.x.c(r15, r1)
        L_0x0430:
            com.xiaomi.push.service.x.a((android.content.Context) r15, (java.lang.String) r1)
            com.xiaomi.push.hc r0 = com.xiaomi.push.service.w.b(r1, r9)
            byte[] r0 = com.xiaomi.push.hq.a(r0)
            r15.a((java.lang.String) r1, (byte[]) r0, (boolean) r6)
        L_0x043e:
            com.xiaomi.push.service.ac.a((android.content.Context) r15, (java.lang.String) r1)
            android.content.Context r0 = r15.getApplicationContext()
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x08fc
            com.xiaomi.push.service.v.a((java.lang.String) r1)
            goto L_0x08fc
        L_0x0450:
            java.lang.String r3 = r16.getAction()
            java.lang.String r11 = "com.xiaomi.mipush.CLEAR_NOTIFICATION"
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L_0x048e
            java.lang.String r1 = com.xiaomi.push.service.an.G
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.an.H
            r3 = -2
            int r2 = r0.getIntExtra(r2, r3)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x08fc
            r3 = -1
            if (r2 < r3) goto L_0x047d
            java.lang.String r4 = com.xiaomi.push.service.an.I
            int r0 = r0.getIntExtra(r4, r3)
            com.xiaomi.push.service.x.a((android.content.Context) r15, (java.lang.String) r1, (int) r2, (int) r0)
            goto L_0x08fc
        L_0x047d:
            java.lang.String r2 = com.xiaomi.push.service.an.M
            java.lang.String r2 = r0.getStringExtra(r2)
            java.lang.String r3 = com.xiaomi.push.service.an.N
            java.lang.String r0 = r0.getStringExtra(r3)
            com.xiaomi.push.service.x.a((android.content.Context) r15, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r0)
            goto L_0x08fc
        L_0x048e:
            java.lang.String r3 = r16.getAction()
            java.lang.String r11 = "com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION"
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L_0x04ab
            java.lang.String r1 = com.xiaomi.push.service.an.G
            java.lang.String r0 = r0.getStringExtra(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x08fc
            com.xiaomi.push.service.x.b((android.content.Context) r15, (java.lang.String) r0)
            goto L_0x08fc
        L_0x04ab:
            java.lang.String r3 = r16.getAction()
            java.lang.String r11 = "com.xiaomi.mipush.SET_NOTIFICATION_TYPE"
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L_0x051a
            java.lang.String r1 = com.xiaomi.push.service.an.G
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.an.L
            java.lang.String r2 = r0.getStringExtra(r2)
            java.lang.String r3 = com.xiaomi.push.service.an.J
            boolean r3 = r0.hasExtra(r3)
            if (r3 == 0) goto L_0x04e7
            java.lang.String r3 = com.xiaomi.push.service.an.J
            int r0 = r0.getIntExtra(r3, r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = com.xiaomi.push.bb.b(r3)
            r6 = r8
            r8 = r0
            goto L_0x04eb
        L_0x04e7:
            java.lang.String r3 = com.xiaomi.push.bb.b(r1)
        L_0x04eb:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0504
            boolean r0 = android.text.TextUtils.equals(r2, r3)
            if (r0 != 0) goto L_0x04f8
            goto L_0x0504
        L_0x04f8:
            if (r6 == 0) goto L_0x04ff
            com.xiaomi.push.service.x.c(r15, r1)
            goto L_0x08fc
        L_0x04ff:
            com.xiaomi.push.service.x.b(r15, r1, r8)
            goto L_0x08fc
        L_0x0504:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "invalid notification for "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            goto L_0x08fc
        L_0x051a:
            java.lang.String r3 = r16.getAction()
            java.lang.String r11 = "com.xiaomi.mipush.DISABLE_PUSH"
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L_0x054e
            java.lang.String r0 = r0.getStringExtra(r10)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0537
            com.xiaomi.push.service.r r1 = com.xiaomi.push.service.r.a((android.content.Context) r15)
            r1.b((java.lang.String) r0)
        L_0x0537:
            java.lang.String r0 = r15.getPackageName()
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x08fc
            r0 = 19
            r15.a((int) r0, (java.lang.Exception) r9)
            r15.e()
            r15.stopSelf()
            goto L_0x08fc
        L_0x054e:
            java.lang.String r3 = r16.getAction()
            java.lang.String r11 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE"
            boolean r3 = r11.equals(r3)
            java.lang.String r12 = "android.net.conn.CONNECTIVITY_CHANGE"
            java.lang.String r13 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE"
            if (r3 != 0) goto L_0x0749
            java.lang.String r3 = r16.getAction()
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x056a
            goto L_0x0749
        L_0x056a:
            java.lang.String r3 = r16.getAction()
            java.lang.String r9 = "com.xiaomi.mipush.SEND_TINYDATA"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x0595
            java.lang.String r1 = r0.getStringExtra(r10)
            byte[] r0 = r0.getByteArrayExtra(r5)
            com.xiaomi.push.gk r2 = new com.xiaomi.push.gk
            r2.<init>()
            com.xiaomi.push.hq.a(r2, (byte[]) r0)     // Catch:{ hv -> 0x058f }
            com.xiaomi.push.ge r0 = com.xiaomi.push.ge.a(r15)     // Catch:{ hv -> 0x058f }
            r0.a((com.xiaomi.push.gk) r2, (java.lang.String) r1)     // Catch:{ hv -> 0x058f }
            goto L_0x08fc
        L_0x058f:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)
            goto L_0x08fc
        L_0x0595:
            java.lang.String r3 = r16.getAction()
            java.lang.String r9 = "com.xiaomi.push.timer"
            boolean r3 = r9.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x05d0
            java.lang.String r0 = "[Alarm] Service called on timer"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            boolean r0 = r15.i()
            if (r0 == 0) goto L_0x05bb
            boolean r0 = com.xiaomi.push.ea.a()
            if (r0 == 0) goto L_0x05c7
            java.lang.String r0 = "enter falldown mode, stop alarm"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            com.xiaomi.push.ea.a()
            goto L_0x05c7
        L_0x05bb:
            com.xiaomi.push.ea.a((boolean) r8)
            boolean r0 = r15.f()
            if (r0 == 0) goto L_0x05c7
            r15.b((boolean) r8)
        L_0x05c7:
            com.xiaomi.push.service.XMPushService$a r0 = r7.f3284a
            if (r0 == 0) goto L_0x08fc
            r0.a()
            goto L_0x08fc
        L_0x05d0:
            java.lang.String r3 = r16.getAction()
            java.lang.String r9 = "com.xiaomi.push.check_alive"
            boolean r3 = r9.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x05ec
            java.lang.String r0 = "Service called on check alive."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            boolean r0 = r15.f()
            if (r0 == 0) goto L_0x08fc
            r15.b((boolean) r8)
            goto L_0x08fc
        L_0x05ec:
            java.lang.String r3 = r16.getAction()
            java.lang.String r9 = "com.xiaomi.mipush.thirdparty"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x061d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "on thirdpart push :"
            r1.append(r2)
            java.lang.String r2 = "com.xiaomi.mipush.thirdparty_DESC"
            java.lang.String r2 = r0.getStringExtra(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
            java.lang.String r1 = "com.xiaomi.mipush.thirdparty_LEVEL"
            int r0 = r0.getIntExtra(r1, r8)
            com.xiaomi.push.ea.a(r15, r0)
            goto L_0x08fc
        L_0x061d:
            java.lang.String r3 = r16.getAction()
            boolean r3 = r12.equals(r3)
            if (r3 == 0) goto L_0x062c
            r15.d()
            goto L_0x08fc
        L_0x062c:
            java.lang.String r3 = r16.getAction()
            java.lang.String r9 = "miui.net.wifi.DIGEST_INFORMATION_CHANGED"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x063d
            r15.a((android.content.Intent) r16)
            goto L_0x08fc
        L_0x063d:
            java.lang.String r3 = r16.getAction()
            java.lang.String r9 = "com.xiaomi.xmsf.USE_INTELLIGENT_HB"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x066d
            android.os.Bundle r1 = r16.getExtras()
            if (r1 == 0) goto L_0x08fc
            android.os.Bundle r0 = r16.getExtras()
            java.lang.String r1 = "effectivePeriod"
            int r0 = r0.getInt(r1, r8)
            if (r0 <= 0) goto L_0x08fc
            r1 = 604800(0x93a80, float:8.47505E-40)
            if (r0 > r1) goto L_0x08fc
            android.content.Context r1 = r15.getApplicationContext()
            com.xiaomi.push.service.m r1 = com.xiaomi.push.service.m.a((android.content.Context) r1)
            r1.a((int) r0)
            goto L_0x08fc
        L_0x066d:
            java.lang.String r3 = r16.getAction()
            java.lang.String r9 = "action_cr_config"
            boolean r3 = r9.equals(r3)
            r11 = 0
            if (r3 == 0) goto L_0x06f4
            java.lang.String r1 = "action_cr_event_switch"
            boolean r1 = r0.getBooleanExtra(r1, r8)
            java.lang.String r2 = "action_cr_event_frequency"
            r9 = 86400(0x15180, double:4.26873E-319)
            long r2 = r0.getLongExtra(r2, r9)
            java.lang.String r5 = "action_cr_perf_switch"
            boolean r5 = r0.getBooleanExtra(r5, r8)
            java.lang.String r8 = "action_cr_perf_frequency"
            long r8 = r0.getLongExtra(r8, r9)
            java.lang.String r10 = "action_cr_event_en"
            boolean r6 = r0.getBooleanExtra(r10, r6)
            r13 = 1048576(0x100000, double:5.180654E-318)
            java.lang.String r10 = "action_cr_max_file_size"
            long r13 = r0.getLongExtra(r10, r13)
            com.xiaomi.clientreport.data.Config$Builder r0 = com.xiaomi.clientreport.data.Config.getBuilder()
            com.xiaomi.clientreport.data.Config$Builder r0 = r0.setEventUploadSwitchOpen(r1)
            com.xiaomi.clientreport.data.Config$Builder r0 = r0.setEventUploadFrequency(r2)
            com.xiaomi.clientreport.data.Config$Builder r0 = r0.setPerfUploadSwitchOpen(r5)
            com.xiaomi.clientreport.data.Config$Builder r0 = r0.setPerfUploadFrequency(r8)
            android.content.Context r1 = r15.getApplicationContext()
            java.lang.String r1 = com.xiaomi.push.bm.a((android.content.Context) r1)
            com.xiaomi.clientreport.data.Config$Builder r0 = r0.setAESKey(r1)
            com.xiaomi.clientreport.data.Config$Builder r0 = r0.setEventEncrypted(r6)
            com.xiaomi.clientreport.data.Config$Builder r0 = r0.setMaxFileLength(r13)
            android.content.Context r1 = r15.getApplicationContext()
            com.xiaomi.clientreport.data.Config r0 = r0.build(r1)
            java.lang.String r1 = r15.getPackageName()
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x08fc
            int r1 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x08fc
            int r1 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x08fc
            int r1 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x08fc
            android.content.Context r1 = r15.getApplicationContext()
            com.xiaomi.push.dt.a((android.content.Context) r1, (com.xiaomi.clientreport.data.Config) r0)
            goto L_0x08fc
        L_0x06f4:
            java.lang.String r3 = com.xiaomi.push.service.an.f52497n
            java.lang.String r4 = r16.getAction()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0709
            android.content.Context r1 = r15.getApplicationContext()
            com.xiaomi.push.service.l.a((android.content.Context) r1, (android.content.Intent) r0)
            goto L_0x08fc
        L_0x0709:
            java.lang.String r3 = com.xiaomi.push.service.an.f52498o
            java.lang.String r4 = r16.getAction()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0730
            java.lang.String r1 = "ext_downward_pkt_id"
            java.lang.String r1 = r0.getStringExtra(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x08fc
            com.xiaomi.push.service.at r2 = com.xiaomi.push.service.at.a()
            java.lang.String r3 = "ext_app_receive_time"
            long r3 = r0.getLongExtra(r3, r11)
            r2.b(r1, r3)
            goto L_0x08fc
        L_0x0730:
            java.lang.String r3 = com.xiaomi.push.service.an.f52499p
            java.lang.String r4 = r16.getAction()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x08fc
            java.lang.String r3 = r0.getStringExtra(r10)
            byte[] r0 = r0.getByteArrayExtra(r5)
            com.xiaomi.push.service.v.a((java.lang.String) r3, (byte[]) r0, (long) r1)
            goto L_0x08fc
        L_0x0749:
            java.lang.String r3 = r0.getStringExtra(r10)
            byte[] r6 = r0.getByteArrayExtra(r5)
            java.lang.String r1 = "mipush_app_id"
            java.lang.String r4 = r0.getStringExtra(r1)
            java.lang.String r1 = "mipush_app_token"
            java.lang.String r5 = r0.getStringExtra(r1)
            java.lang.String r1 = r16.getAction()
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L_0x076e
            com.xiaomi.push.service.r r1 = com.xiaomi.push.service.r.a((android.content.Context) r15)
            r1.c((java.lang.String) r3)
        L_0x076e:
            java.lang.String r1 = r16.getAction()
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x0786
            com.xiaomi.push.service.r r1 = com.xiaomi.push.service.r.a((android.content.Context) r15)
            r1.e(r3)
            com.xiaomi.push.service.r r1 = com.xiaomi.push.service.r.a((android.content.Context) r15)
            r1.f(r3)
        L_0x0786:
            if (r6 != 0) goto L_0x0792
            r0 = 70000003(0x42c1d83, float:2.0232054E-36)
            java.lang.String r1 = "null payload"
            com.xiaomi.push.service.t.a(r15, r3, r6, r0, r1)
            goto L_0x08fc
        L_0x0792:
            com.xiaomi.push.service.t.b(r3, r6)
            com.xiaomi.push.service.s r8 = new com.xiaomi.push.service.s
            r1 = r8
            r2 = r15
            r1.<init>(r2, r3, r4, r5, r6)
            r15.a((com.xiaomi.push.service.XMPushService.j) r8)
            java.lang.String r0 = r16.getAction()
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x08fc
            com.xiaomi.push.service.XMPushService$f r0 = r7.f3285a
            if (r0 != 0) goto L_0x07be
            com.xiaomi.push.service.XMPushService$f r0 = new com.xiaomi.push.service.XMPushService$f
            r0.<init>()
            r7.f3285a = r0
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>(r12)
            com.xiaomi.push.service.XMPushService$f r1 = r7.f3285a
            com.xiaomi.push.m.a((android.content.Context) r15, (android.content.BroadcastReceiver) r1, (android.content.IntentFilter) r0, (java.lang.String) r9, (android.os.Handler) r9)
        L_0x07be:
            java.lang.Object r0 = r7.f3294a
            if (r0 != 0) goto L_0x08fc
            java.lang.Object r0 = com.xiaomi.push.av.a((android.content.Context) r15)
            r7.f3294a = r0
            goto L_0x08fc
        L_0x07ca:
            java.lang.String r3 = r0.getStringExtra(r10)
            byte[] r4 = r0.getByteArrayExtra(r5)
            java.lang.String r5 = "com.xiaomi.mipush.MESSAGE_CACHE"
            boolean r5 = r0.getBooleanExtra(r5, r6)
            boolean r6 = com.xiaomi.push.service.k.a(r4, r3)
            if (r6 == 0) goto L_0x07f8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "duplicate msg from: "
            r0.append(r1)
            java.lang.String r1 = java.lang.String.valueOf(r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            goto L_0x08fc
        L_0x07f8:
            java.lang.String r6 = r16.getAction()
            boolean r6 = r12.equals(r6)
            if (r6 == 0) goto L_0x0817
            com.xiaomi.push.service.r r0 = com.xiaomi.push.service.r.a((android.content.Context) r15)
            r0.a((java.lang.String) r3)
            android.content.Context r0 = r15.getApplicationContext()
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x0824
            com.xiaomi.push.service.v.a((java.lang.String) r3)
            goto L_0x0824
        L_0x0817:
            java.lang.String r0 = r16.getAction()
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x0824
            com.xiaomi.push.service.v.a((java.lang.String) r3, (byte[]) r4, (long) r1)
        L_0x0824:
            r15.a((java.lang.String) r3, (byte[]) r4, (boolean) r5)
            goto L_0x08fc
        L_0x0829:
            java.lang.String r1 = r16.getAction()
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0852
            boolean r0 = r15.i()
            if (r0 != 0) goto L_0x08fc
            java.lang.String r0 = "exit falldown mode, activate alarm."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            r15.e()
            boolean r0 = r15.c()
            if (r0 != 0) goto L_0x08fc
            boolean r0 = r15.d()
            if (r0 != 0) goto L_0x08fc
            r15.a((boolean) r6)
            goto L_0x08fc
        L_0x0852:
            java.lang.String r0 = r16.getAction()
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x08fc
            boolean r0 = r15.i()
            if (r0 == 0) goto L_0x08fc
            boolean r0 = com.xiaomi.push.ea.a()
            if (r0 == 0) goto L_0x08fc
            java.lang.String r0 = "enter falldown mode, stop alarm."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            com.xiaomi.push.ea.a()
            goto L_0x08fc
        L_0x0872:
            java.lang.String r1 = com.xiaomi.push.service.an.f52506w
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.an.C
            java.lang.String r2 = r0.getStringExtra(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x088b
            java.lang.String r0 = "security is empty. ignore."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            goto L_0x08fc
        L_0x088b:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x08f7
            boolean r2 = r15.a((java.lang.String) r1, (android.content.Intent) r0)
            com.xiaomi.push.service.am$b r3 = r15.a((java.lang.String) r1, (android.content.Intent) r0)
            boolean r0 = com.xiaomi.push.av.b(r15)
            if (r0 != 0) goto L_0x08a9
            com.xiaomi.push.service.h r1 = r7.f3291a
            r4 = 0
            r5 = 2
            r6 = 0
            r2 = r15
            r1.a(r2, r3, r4, r5, r6)
            goto L_0x08fc
        L_0x08a9:
            boolean r0 = r15.c()
            if (r0 == 0) goto L_0x08f3
            com.xiaomi.push.service.am$c r0 = r3.f3341a
            com.xiaomi.push.service.am$c r1 = com.xiaomi.push.service.am.c.unbind
            if (r0 != r1) goto L_0x08be
            com.xiaomi.push.service.XMPushService$b r0 = new com.xiaomi.push.service.XMPushService$b
            r0.<init>(r3)
            r15.c((com.xiaomi.push.service.XMPushService.j) r0)
            goto L_0x08fc
        L_0x08be:
            if (r2 == 0) goto L_0x08c9
            com.xiaomi.push.service.XMPushService$p r0 = new com.xiaomi.push.service.XMPushService$p
            r0.<init>(r3)
            r15.c((com.xiaomi.push.service.XMPushService.j) r0)
            goto L_0x08fc
        L_0x08c9:
            com.xiaomi.push.service.am$c r1 = com.xiaomi.push.service.am.c.binding
            if (r0 != r1) goto L_0x08e5
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = r3.f52470g
            r0[r8] = r1
            java.lang.String r1 = r3.f3346b
            java.lang.String r1 = com.xiaomi.push.service.am.b.a((java.lang.String) r1)
            r0[r6] = r1
            java.lang.String r1 = "the client is binding. %1$s %2$s."
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            goto L_0x08fc
        L_0x08e5:
            com.xiaomi.push.service.am$c r1 = com.xiaomi.push.service.am.c.binded
            if (r0 != r1) goto L_0x08fc
            com.xiaomi.push.service.h r1 = r7.f3291a
            r4 = 1
            r5 = 0
            r6 = 0
            r2 = r15
            r1.a(r2, r3, r4, r5, r6)
            goto L_0x08fc
        L_0x08f3:
            r15.a((boolean) r6)
            goto L_0x08fc
        L_0x08f7:
            java.lang.String r0 = "channel id is empty, do nothing!"
            com.xiaomi.channel.commonutils.logger.b.d(r0)
        L_0x08fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.a(android.content.Intent, long):void");
    }

    private void c(j jVar) {
        this.f3292a.a((n.b) jVar);
    }

    private void c(boolean z11) {
        try {
            if (!com.xiaomi.push.s.a()) {
                return;
            }
            if (z11) {
                if (com.xiaomi.push.j.a((Context) this)) {
                    Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                    intent.addFlags(1073741824);
                    sendBroadcast(intent);
                }
                for (aa a11 : (aa[]) this.f3296a.toArray(new aa[0])) {
                    a11.a();
                }
            } else if (com.xiaomi.push.j.a((Context) this)) {
                Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                intent2.addFlags(1073741824);
                sendBroadcast(intent2);
            }
        } catch (Exception e11) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2945b() {
        try {
            Class<?> a11 = com.xiaomi.push.s.a(this, "miui.os.Build");
            Field field = a11.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a11.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a11.getField("IS_CT_CUSTOMIZATION_TEST");
            if (field.getBoolean((Object) null) || field2.getBoolean((Object) null) || field3.getBoolean((Object) null)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public h m2943b() {
        return this.f3291a;
    }

    public void b(j jVar) {
        this.f3292a.a(jVar.f52566a, (n.b) jVar);
    }

    public void b(fb fbVar) {
        ep.a().b(fbVar);
        c(true);
        this.f3290a.a();
        if (!ea.a() && !i()) {
            com.xiaomi.channel.commonutils.logger.b.a("reconnection successful, reactivate alarm.");
            ea.a(true);
        }
        Iterator it2 = am.a().a().iterator();
        while (it2.hasNext()) {
            a((j) new b((am.b) it2.next()));
        }
        if (!this.f3297a && com.xiaomi.push.j.a(getApplicationContext())) {
            af.a(getApplicationContext()).a((Runnable) new Runnable() {
                public void run() {
                    boolean unused = XMPushService.this.f3297a = true;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a("try to trigger the wifi digest broadcast.");
                        Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                        if (systemService != null) {
                            ax.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2946c() {
        fb fbVar = this.f3281a;
        return fbVar != null && fbVar.c();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2944b() {
        m.a(getApplicationContext()).d();
        Iterator it2 = new ArrayList(this.f3295a).iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).a();
        }
    }

    public void a(final String str, final byte[] bArr, boolean z11) {
        Collection a11 = am.a().a(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
        if (a11.isEmpty()) {
            if (z11) {
                t.b(str, bArr);
            }
        } else if (((am.b) a11.iterator().next()).f3341a == am.c.binded) {
            a((j) new j(4) {
                public String a() {
                    return "send mi push message";
                }

                /* renamed from: a  reason: collision with other method in class */
                public void m2950a() {
                    try {
                        w.a(XMPushService.this, str, bArr);
                    } catch (fj e11) {
                        com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
                        XMPushService.this.a(10, (Exception) e11);
                    }
                }
            });
        } else if (z11) {
            t.b(str, bArr);
        }
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
            return;
        }
        hc hcVar = new hc();
        try {
            hq.a(hcVar, bArr);
            if (hcVar.f3062a == gg.Registration) {
                hg hgVar = new hg();
                try {
                    hq.a(hgVar, hcVar.a());
                    a((j) new s(this, hcVar.b(), hgVar.b(), hgVar.c(), bArr));
                    du.a(getApplicationContext()).a(hcVar.b(), "E100003", hgVar.a(), 6002, (String) null);
                } catch (hv e11) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e11);
                    t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
            }
        } catch (hv e12) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e12);
            t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    private fp a(fp fpVar, String str, String str2) {
        am a11 = am.a();
        List a12 = a11.a(str);
        if (a12.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        fpVar.o(str);
        String k11 = fpVar.k();
        if (TextUtils.isEmpty(k11)) {
            k11 = (String) a12.get(0);
            fpVar.l(k11);
        }
        am.b a13 = a11.a(k11, fpVar.m());
        if (!c()) {
            com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not connected, chid=" + k11);
            return null;
        } else if (a13 == null || a13.f3341a != am.c.binded) {
            com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not opened, chid=" + k11);
            return null;
        } else if (TextUtils.equals(str2, a13.f52472i)) {
            return fpVar;
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("invalid session. " + str2);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2930a(String str, Intent intent) {
        am.b a11 = am.a().a(str, intent.getStringExtra(an.f52503t));
        boolean z11 = false;
        if (!(a11 == null || str == null)) {
            String stringExtra = intent.getStringExtra(an.K);
            String stringExtra2 = intent.getStringExtra(an.C);
            if (!TextUtils.isEmpty(a11.f52472i) && !TextUtils.equals(stringExtra, a11.f52472i)) {
                com.xiaomi.channel.commonutils.logger.b.a("session changed. old session=" + a11.f52472i + ", new session=" + stringExtra + " chid = " + str);
                z11 = true;
            }
            if (!stringExtra2.equals(a11.f52471h)) {
                com.xiaomi.channel.commonutils.logger.b.a("security changed. chid = " + str + " sechash = " + bb.a(stringExtra2));
                return true;
            }
        }
        return z11;
    }

    private am.b a(String str, Intent intent) {
        am.b a11 = am.a().a(str, intent.getStringExtra(an.f52503t));
        if (a11 == null) {
            a11 = new am.b(this);
        }
        a11.f52470g = intent.getStringExtra(an.f52506w);
        a11.f3346b = intent.getStringExtra(an.f52503t);
        a11.f52466c = intent.getStringExtra(an.A);
        a11.f3343a = intent.getStringExtra(an.G);
        a11.f52468e = intent.getStringExtra(an.E);
        a11.f52469f = intent.getStringExtra(an.F);
        a11.f3345a = intent.getBooleanExtra(an.D, false);
        a11.f52471h = intent.getStringExtra(an.C);
        a11.f52472i = intent.getStringExtra(an.K);
        a11.f52467d = intent.getStringExtra(an.B);
        a11.f3342a = this.f3291a;
        a11.a((Messenger) intent.getParcelableExtra(an.O));
        a11.f3335a = getApplicationContext();
        am.a().a(a11);
        return a11;
    }

    public void a(String str, String str2, int i11, String str3, String str4) {
        am.b a11 = am.a().a(str, str2);
        if (a11 != null) {
            a((j) new s(a11, i11, str4, str3));
        }
        am.a().a(str, str2);
    }

    private void a(String str, int i11) {
        Collection<am.b> a11 = am.a().a(str);
        if (a11 != null) {
            for (am.b bVar : a11) {
                if (bVar != null) {
                    a((j) new s(bVar, i11, (String) null, (String) null));
                }
            }
        }
        am.a().a(str);
    }

    public void a(j jVar) {
        a(jVar, 0);
    }

    public void a(j jVar, long j11) {
        try {
            this.f3292a.a((n.b) jVar, j11);
        } catch (IllegalStateException e11) {
            com.xiaomi.channel.commonutils.logger.b.a("can't execute job err = " + e11.getMessage());
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e11) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
            }
        }
    }

    public void a(es esVar) {
        fb fbVar = this.f3281a;
        if (fbVar != null) {
            fbVar.b(esVar);
            return;
        }
        throw new fj("try send msg while connection is null.");
    }

    public void a(es[] esVarArr) {
        fb fbVar = this.f3281a;
        if (fbVar != null) {
            fbVar.a(esVarArr);
            return;
        }
        throw new fj("try send msg while connection is null.");
    }

    public void a(boolean z11) {
        this.f3290a.a(z11);
    }

    public void a(am.b bVar) {
        if (bVar != null) {
            long a11 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.a("schedule rebind job in " + (a11 / 1000));
            a((j) new b(bVar), a11);
        }
    }

    public void a(int i11, Exception exc) {
        Integer num;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("disconnect ");
        sb2.append(hashCode());
        sb2.append(", ");
        fb fbVar = this.f3281a;
        if (fbVar == null) {
            num = null;
        } else {
            num = Integer.valueOf(fbVar.hashCode());
        }
        sb2.append(num);
        com.xiaomi.channel.commonutils.logger.b.a(sb2.toString());
        fb fbVar2 = this.f3281a;
        if (fbVar2 != null) {
            fbVar2.b(i11, exc);
            this.f3281a = null;
        }
        a(7);
        a(4);
        am.a().a((Context) this, i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2941a() {
        boolean a11 = av.a((Context) this);
        boolean z11 = am.a().a() > 0;
        boolean z12 = !b();
        boolean h11 = h();
        boolean z13 = !g();
        boolean z14 = a11 && z11 && z12 && h11 && z13;
        if (!z14) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", new Object[]{Boolean.valueOf(a11), Boolean.valueOf(z11), Boolean.valueOf(z12), Boolean.valueOf(h11), Boolean.valueOf(z13)}));
        }
        return z14;
    }

    /* renamed from: a  reason: collision with other method in class */
    public h m2939a() {
        return new h();
    }

    /* access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            ah.a();
            for (int i11 = 100; i11 > 0; i11--) {
                if (av.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fb m2938a() {
        return this.f3281a;
    }

    public void a(int i11) {
        this.f3292a.a(i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2942a(int i11) {
        return this.f3292a.a(i11);
    }

    public void a(fb fbVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        ep.a().a(fbVar);
    }

    public void a(fb fbVar, int i11, Exception exc) {
        ep.a().a(fbVar, i11, exc);
        if (!i()) {
            a(false);
        }
    }

    public void a(fb fbVar, Exception exc) {
        ep.a().a(fbVar, exc);
        c(false);
        if (!i()) {
            a(false);
        }
    }

    public void a(n nVar) {
        synchronized (this.f3295a) {
            this.f3295a.add(nVar);
        }
    }
}
