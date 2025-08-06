package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.av;
import com.xiaomi.push.ax;
import com.xiaomi.push.bb;
import com.xiaomi.push.ct;
import com.xiaomi.push.du;
import com.xiaomi.push.gg;
import com.xiaomi.push.gh;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.j;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static u f51337a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f2480a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f51338b = false;

    /* renamed from: a  reason: collision with other field name */
    private long f2481a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2482a;

    /* renamed from: a  reason: collision with other field name */
    private Intent f2483a = null;

    /* renamed from: a  reason: collision with other field name */
    private Handler f2484a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Messenger f2485a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Integer f2486a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f2487a;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f2488a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2489a = false;

    /* renamed from: b  reason: collision with other field name */
    private String f2490b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f51339c = false;

    /* renamed from: com.xiaomi.mipush.sdk.u$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51344a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xiaomi.mipush.sdk.v[] r0 = com.xiaomi.mipush.sdk.v.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51344a = r0
                com.xiaomi.mipush.sdk.v r1 = com.xiaomi.mipush.sdk.v.DISABLE_PUSH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51344a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.mipush.sdk.v r1 = com.xiaomi.mipush.sdk.v.ENABLE_PUSH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51344a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.mipush.sdk.v r1 = com.xiaomi.mipush.sdk.v.UPLOAD_HUAWEI_TOKEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f51344a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.mipush.sdk.v r1 = com.xiaomi.mipush.sdk.v.UPLOAD_FCM_TOKEN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f51344a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xiaomi.mipush.sdk.v r1 = com.xiaomi.mipush.sdk.v.UPLOAD_COS_TOKEN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f51344a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.xiaomi.mipush.sdk.v r1 = com.xiaomi.mipush.sdk.v.UPLOAD_FTOS_TOKEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.u.AnonymousClass5.<clinit>():void");
        }
    }

    public static class a<T extends hr<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        public gg f51345a;

        /* renamed from: a  reason: collision with other field name */
        public T f2491a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2492a;
    }

    private u(Context context) {
        this.f2482a = context.getApplicationContext();
        this.f2487a = null;
        this.f2489a = c();
        f51338b = d();
        this.f2484a = new Handler(Looper.getMainLooper()) {
            public void dispatchMessage(Message message) {
                if (message.what == 19) {
                    String str = (String) message.obj;
                    int i11 = message.arg1;
                    synchronized (p.class) {
                        if (p.a(u.a(u.this)).a(str)) {
                            if (p.a(u.a(u.this)).a(str) < 10) {
                                String str2 = "";
                                if (message.getData() != null) {
                                    str2 = message.getData().getString("third_sync_reason");
                                }
                                v vVar = v.DISABLE_PUSH;
                                if (vVar.ordinal() != i11 || !"syncing".equals(p.a(u.a(u.this)).a(vVar))) {
                                    v vVar2 = v.ENABLE_PUSH;
                                    if (vVar2.ordinal() != i11 || !"syncing".equals(p.a(u.a(u.this)).a(vVar2))) {
                                        v vVar3 = v.UPLOAD_HUAWEI_TOKEN;
                                        if (vVar3.ordinal() != i11 || !"syncing".equals(p.a(u.a(u.this)).a(vVar3))) {
                                            v vVar4 = v.UPLOAD_FCM_TOKEN;
                                            if (vVar4.ordinal() != i11 || !"syncing".equals(p.a(u.a(u.this)).a(vVar4))) {
                                                v vVar5 = v.UPLOAD_COS_TOKEN;
                                                if (vVar5.ordinal() != i11 || !"syncing".equals(p.a(u.a(u.this)).a(vVar5))) {
                                                    v vVar6 = v.UPLOAD_FTOS_TOKEN;
                                                    if (vVar6.ordinal() == i11 && "syncing".equals(p.a(u.a(u.this)).a(vVar6))) {
                                                        HashMap a11 = f.a(u.a(u.this), d.ASSEMBLE_PUSH_FTOS);
                                                        a11.put("third_sync_reason", str2);
                                                        u.this.a(str, vVar6, false, (HashMap<String, String>) a11);
                                                    }
                                                } else {
                                                    HashMap a12 = f.a(u.a(u.this), d.ASSEMBLE_PUSH_COS);
                                                    a12.put("third_sync_reason", str2);
                                                    u.this.a(str, vVar5, false, (HashMap<String, String>) a12);
                                                }
                                            } else {
                                                u uVar = u.this;
                                                uVar.a(str, vVar4, false, (HashMap<String, String>) f.a(u.a(uVar), d.ASSEMBLE_PUSH_FCM));
                                            }
                                        } else {
                                            HashMap a13 = f.a(u.a(u.this), d.ASSEMBLE_PUSH_HUAWEI);
                                            a13.put("third_sync_reason", str2);
                                            u.this.a(str, vVar3, false, (HashMap<String, String>) a13);
                                        }
                                    } else {
                                        u.this.a(str, vVar2, true, (HashMap<String, String>) null);
                                    }
                                } else {
                                    u.this.a(str, vVar, true, (HashMap<String, String>) null);
                                }
                                p.a(u.a(u.this)).b(str);
                            } else {
                                p.a(u.a(u.this)).c(str);
                            }
                        }
                    }
                }
            }
        };
        if (j.a(context)) {
            g.a((g.b) new g.b() {
            });
        }
        Intent b11 = b();
        if (b11 != null) {
            b(b11);
        }
    }

    private synchronized void c(int i11) {
        this.f2482a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i11).commit();
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f2482a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f2482a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f2482a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private void g() {
        this.f2481a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f2482a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f2482a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f2482a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f2482a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m2378b() {
        Intent a11 = a();
        a11.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(a11);
    }

    public void f() {
        Intent a11 = a();
        a11.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a11.putExtra(an.G, this.f2482a.getPackageName());
        a11.putExtra(an.L, bb.b(this.f2482a.getPackageName()));
        c(a11);
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f2482a.getPackageName())) {
            return c();
        }
        b.c("pushChannel xmsf create own channel");
        return e();
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m2369c() {
        try {
            PackageInfo packageInfo = this.f2482a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null && packageInfo.versionCode >= 105) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m2382e() {
        Intent a11 = a();
        a11.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) ax.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f2482a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            b.a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        a11.putExtra(an.G, packageName);
        c(a11);
    }

    private Intent c() {
        if (a()) {
            b.c("pushChannel app start miui china channel");
            return d();
        }
        b.c("pushChannel app start  own channel");
        return e();
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m2381d() {
        ArrayList<a> arrayList = f2480a;
        synchronized (arrayList) {
            boolean z11 = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                a(next.f2491a, next.f51345a, next.f2492a, false, (gt) null, true);
                if (!z11) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f2480a.clear();
        }
    }

    public void b(int i11) {
        Intent a11 = a();
        a11.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a11.putExtra(an.G, this.f2482a.getPackageName());
        a11.putExtra(an.J, i11);
        String str = an.L;
        a11.putExtra(str, bb.b(this.f2482a.getPackageName() + i11));
        c(a11);
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (f51337a == null) {
                f51337a = new u(context);
            }
            uVar = f51337a;
        }
        return uVar;
    }

    private synchronized int a() {
        return this.f2482a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m2380c() {
        if (this.f2483a != null) {
            g();
            c(this.f2483a);
            this.f2483a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m2370d() {
        if (a()) {
            try {
                if (this.f2482a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2379b() {
        if (!a() || !e()) {
            return true;
        }
        if (this.f2486a == null) {
            Integer valueOf = Integer.valueOf(ap.a(this.f2482a).a());
            this.f2486a = valueOf;
            if (valueOf.intValue() == 0) {
                this.f2482a.getContentResolver().registerContentObserver(ap.a(this.f2482a).a(), false, new ContentObserver(new Handler(Looper.getMainLooper())) {
                    public void onChange(boolean z11) {
                        u uVar = u.this;
                        Integer unused = uVar.f2486a = Integer.valueOf(ap.a(u.a(uVar)).a());
                        if (u.a(u.this).intValue() != 0) {
                            u.a(u.this).getContentResolver().unregisterContentObserver(this);
                            if (av.a(u.a(u.this))) {
                                u.this.c();
                            }
                        }
                    }
                });
            }
        }
        if (this.f2486a.intValue() != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m2372a() {
        return this.f2481a;
    }

    private void c(Intent intent) {
        ah a11 = ah.a(this.f2482a);
        int a12 = gl.ServiceBootMode.a();
        gh ghVar = gh.START;
        int a13 = a11.a(a12, ghVar.a());
        int a14 = a();
        gh ghVar2 = gh.BIND;
        boolean z11 = a13 == ghVar2.a() && f51338b;
        int a15 = z11 ? ghVar2.a() : ghVar.a();
        if (a15 != a14) {
            a(a15);
        }
        if (z11) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m2371e() {
        String packageName = this.f2482a.getPackageName();
        if (packageName.contains("miui") || packageName.contains("xiaomi") || (this.f2482a.getApplicationInfo().flags & 1) != 0) {
            return true;
        }
        return false;
    }

    public final void a(hg hgVar, boolean z11) {
        du.a(this.f2482a.getApplicationContext()).a(this.f2482a.getPackageName(), "E100003", hgVar.a(), 6001, (String) null);
        this.f2483a = null;
        b.a(this.f2482a).f2455a = hgVar.a();
        Intent a11 = a();
        byte[] a12 = hq.a(r.a(this.f2482a, hgVar, gg.Registration));
        if (a12 == null) {
            b.a("register fail, because msgBytes is null.");
            return;
        }
        a11.setAction("com.xiaomi.mipush.REGISTER_APP");
        a11.putExtra("mipush_app_id", b.a(this.f2482a).a());
        a11.putExtra("mipush_payload", a12);
        a11.putExtra("mipush_session", this.f2487a);
        a11.putExtra("mipush_env_chanage", z11);
        a11.putExtra("mipush_env_type", b.a(this.f2482a).a());
        if (!av.a(this.f2482a) || !b()) {
            this.f2483a = a11;
            return;
        }
        g();
        c(a11);
    }

    private synchronized void d(Intent intent) {
        if (this.f51339c) {
            Message a11 = a(intent);
            if (this.f2488a.size() >= 50) {
                this.f2488a.remove(0);
            }
            this.f2488a.add(a11);
            return;
        } else if (this.f2485a == null) {
            this.f2482a.bindService(intent, new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (u.this) {
                        Messenger unused = u.this.f2485a = new Messenger(iBinder);
                        boolean unused2 = u.this.f51339c = false;
                        for (Message send : u.a(u.this)) {
                            try {
                                u.a(u.this).send(send);
                            } catch (RemoteException e11) {
                                b.a((Throwable) e11);
                            }
                        }
                        u.a(u.this).clear();
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    Messenger unused = u.this.f2485a = null;
                    boolean unused2 = u.this.f51339c = false;
                }
            }, 1);
            this.f51339c = true;
            this.f2488a.clear();
            this.f2488a.add(a(intent));
        } else {
            try {
                this.f2485a.send(a(intent));
            } catch (RemoteException unused) {
                this.f2485a = null;
                this.f51339c = false;
            }
        }
    }

    private void b(Intent intent) {
        try {
            if (j.a() || Build.VERSION.SDK_INT < 26) {
                this.f2482a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e11) {
            b.a((Throwable) e11);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2373a() {
        b(a());
    }

    public final void a(hm hmVar) {
        byte[] a11 = hq.a(r.a(this.f2482a, hmVar, gg.UnRegistration));
        if (a11 == null) {
            b.a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent a12 = a();
        a12.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        a12.putExtra("mipush_app_id", b.a(this.f2482a).a());
        a12.putExtra("mipush_payload", a11);
        c(a12);
    }

    public final void a(boolean z11) {
        a(z11, (String) null);
    }

    public final void a(boolean z11, String str) {
        if (z11) {
            p a11 = p.a(this.f2482a);
            v vVar = v.DISABLE_PUSH;
            a11.a(vVar, "syncing");
            p.a(this.f2482a).a(v.ENABLE_PUSH, "");
            a(str, vVar, true, (HashMap<String, String>) null);
            return;
        }
        p a12 = p.a(this.f2482a);
        v vVar2 = v.ENABLE_PUSH;
        a12.a(vVar2, "syncing");
        p.a(this.f2482a).a(v.DISABLE_PUSH, "");
        a(str, vVar2, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2374a(Context context) {
        if (!j.a()) {
            q a11 = h.a(context);
            if (q.HUAWEI.equals(a11)) {
                a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "update");
            }
            if (q.OPPO.equals(a11)) {
                a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "update");
            }
            if (q.VIVO.equals(a11)) {
                a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "update");
            }
        }
    }

    public final void a(String str, v vVar, d dVar, String str2) {
        p.a(this.f2482a).a(vVar, "syncing");
        HashMap a11 = f.a(this.f2482a, dVar);
        a11.put("third_sync_reason", str2);
        a(str, vVar, false, (HashMap<String, String>) a11);
    }

    public void a(int i11, String str) {
        Intent a11 = a();
        a11.setAction("com.xiaomi.mipush.thirdparty");
        a11.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i11);
        a11.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(a11);
    }

    /* access modifiers changed from: private */
    public void a(String str, v vVar, boolean z11, HashMap<String, String> hashMap) {
        hf hfVar;
        String str2 = str;
        HashMap<String, String> hashMap2 = hashMap;
        if (b.a(this.f2482a).b() && av.a(this.f2482a)) {
            hf hfVar2 = new hf();
            hfVar2.a(true);
            Intent a11 = a();
            if (TextUtils.isEmpty(str)) {
                str2 = aj.a();
                hfVar2.a(str2);
                hfVar = z11 ? new hf(str2, true) : null;
                synchronized (p.class) {
                    p.a(this.f2482a).a(str2);
                }
            } else {
                hfVar2.a(str2);
                hfVar = z11 ? new hf(str2, true) : null;
            }
            switch (AnonymousClass5.f51344a[vVar.ordinal()]) {
                case 1:
                    gq gqVar = gq.DisablePushMessage;
                    hfVar2.c(gqVar.f2942a);
                    hfVar.c(gqVar.f2942a);
                    if (hashMap2 != null) {
                        hfVar2.a((Map<String, String>) hashMap2);
                        hfVar.a((Map<String, String>) hashMap2);
                    }
                    a11.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    gq gqVar2 = gq.EnablePushMessage;
                    hfVar2.c(gqVar2.f2942a);
                    hfVar.c(gqVar2.f2942a);
                    if (hashMap2 != null) {
                        hfVar2.a((Map<String, String>) hashMap2);
                        hfVar.a((Map<String, String>) hashMap2);
                    }
                    a11.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    hfVar2.c(gq.ThirdPartyRegUpdate.f2942a);
                    if (hashMap2 != null) {
                        hfVar2.a((Map<String, String>) hashMap2);
                        break;
                    }
                    break;
            }
            b.e("type:" + vVar + ", " + str2);
            hfVar2.b(b.a(this.f2482a).a());
            hfVar2.d(this.f2482a.getPackageName());
            gg ggVar = gg.Notification;
            a(hfVar2, ggVar, false, (gt) null);
            if (z11) {
                hfVar.b(b.a(this.f2482a).a());
                hfVar.d(this.f2482a.getPackageName());
                Context context = this.f2482a;
                byte[] a12 = hq.a(r.a(context, hfVar, ggVar, false, context.getPackageName(), b.a(this.f2482a).a()));
                if (a12 != null) {
                    ct.a(this.f2482a.getPackageName(), this.f2482a, hfVar, ggVar, a12.length);
                    a11.putExtra("mipush_payload", a12);
                    a11.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    a11.putExtra("mipush_app_id", b.a(this.f2482a).a());
                    a11.putExtra("mipush_app_token", b.a(this.f2482a).b());
                    c(a11);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = vVar.ordinal();
            obtain.obj = str2;
            obtain.arg1 = ordinal;
            if (!(hashMap2 == null || hashMap2.get("third_sync_reason") == null)) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", hashMap2.get("third_sync_reason"));
                obtain.setData(bundle);
            }
            this.f2484a.sendMessageDelayed(obtain, 5000);
        }
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, gt gtVar) {
        a(t11, ggVar, !ggVar.equals(gg.Registration), gtVar);
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11, gt gtVar, boolean z12) {
        a(t11, ggVar, z11, true, gtVar, z12);
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11, gt gtVar) {
        a(t11, ggVar, z11, true, gtVar, true);
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11, boolean z12, gt gtVar, boolean z13) {
        a(t11, ggVar, z11, z12, gtVar, z13, this.f2482a.getPackageName(), b.a(this.f2482a).a());
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11, boolean z12, gt gtVar, boolean z13, String str, String str2) {
        a(t11, ggVar, z11, z12, gtVar, z13, str, str2, true);
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11, boolean z12, gt gtVar, boolean z13, String str, String str2, boolean z14) {
        a(t11, ggVar, z11, z12, gtVar, z13, str, str2, z14, true);
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11, boolean z12, gt gtVar, boolean z13, String str, String str2, boolean z14, boolean z15) {
        a(t11, ggVar, z11, z12, gtVar, z13, str, str2, z14, z15, "com.xiaomi.mipush.SEND_MESSAGE");
    }

    public final <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11, boolean z12, gt gtVar, boolean z13, String str, String str2, boolean z14, boolean z15, String str3) {
        hc hcVar;
        gt gtVar2 = gtVar;
        if (!z15 || b.a(this.f2482a).c()) {
            if (z14) {
                hcVar = r.a(this.f2482a, t11, ggVar, z11, str, str2);
            } else {
                hcVar = r.b(this.f2482a, t11, ggVar, z11, str, str2);
            }
            if (gtVar2 != null) {
                hcVar.a(gtVar);
            }
            byte[] a11 = hq.a(hcVar);
            if (a11 == null) {
                b.a("send message fail, because msgBytes is null.");
                return;
            }
            T t12 = t11;
            gg ggVar2 = ggVar;
            ct.a(this.f2482a.getPackageName(), this.f2482a, t11, ggVar, a11.length);
            Intent a12 = a();
            a12.setAction(str3);
            a12.putExtra("mipush_payload", a11);
            boolean z16 = z13;
            a12.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z13);
            c(a12);
        } else if (z12) {
            a(t11, ggVar, z11);
        } else {
            b.a("drop the message before initialization.");
        }
    }

    public final void a(gk gkVar) {
        Intent a11 = a();
        byte[] a12 = hq.a(gkVar);
        if (a12 == null) {
            b.a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        a11.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        a11.putExtra("mipush_payload", a12);
        b(a11);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m2367a() {
        if (!a() || "com.xiaomi.xmsf".equals(this.f2482a.getPackageName())) {
            return e();
        }
        return d();
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m2368a() {
        String str = this.f2490b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f2482a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f2490b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f2490b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2376a() {
        if (!this.f2489a || 1 != b.a(this.f2482a).a()) {
            return false;
        }
        return true;
    }

    public <T extends hr<T, ?>> void a(T t11, gg ggVar, boolean z11) {
        a aVar = new a();
        aVar.f2491a = t11;
        aVar.f51345a = ggVar;
        aVar.f2492a = z11;
        ArrayList<a> arrayList = f2480a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public void a(int i11) {
        a(i11, 0);
    }

    public void a(int i11, int i12) {
        Intent a11 = a();
        a11.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a11.putExtra(an.G, this.f2482a.getPackageName());
        a11.putExtra(an.H, i11);
        a11.putExtra(an.I, i12);
        c(a11);
    }

    public void a(String str, String str2) {
        Intent a11 = a();
        a11.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a11.putExtra(an.G, this.f2482a.getPackageName());
        a11.putExtra(an.M, str);
        a11.putExtra(an.N, str2);
        c(a11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2375a(Intent intent) {
        intent.fillIn(a(), 24);
        c(intent);
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2377a(int i11) {
        if (!b.a(this.f2482a).b()) {
            return false;
        }
        c(i11);
        hf hfVar = new hf();
        hfVar.a(aj.a());
        hfVar.b(b.a(this.f2482a).a());
        hfVar.d(this.f2482a.getPackageName());
        hfVar.c(gq.ClientABTest.f2942a);
        HashMap hashMap = new HashMap();
        hfVar.f3081a = hashMap;
        hashMap.put("boot_mode", i11 + "");
        a(this.f2482a).a(hfVar, gg.Notification, false, (gt) null);
        return true;
    }
}
