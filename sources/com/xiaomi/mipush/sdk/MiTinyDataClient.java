package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gt;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static volatile a f51284a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public Context f2431a;

        /* renamed from: a  reason: collision with other field name */
        private C0640a f2432a = new C0640a();

        /* renamed from: a  reason: collision with other field name */
        private Boolean f2433a;

        /* renamed from: a  reason: collision with other field name */
        private String f2434a;

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<gk> f2435a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        public class C0640a {

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f2436a = new Runnable() {
                public void run() {
                    if (C0640a.this.f2437a.size() != 0) {
                        C0640a.this.b();
                    } else if (C0640a.a(C0640a.this) != null) {
                        C0640a.a(C0640a.this).cancel(false);
                        ScheduledFuture unused = C0640a.this.f2438a = null;
                    }
                }
            };

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<gk> f2437a = new ArrayList<>();
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with other field name */
            public ScheduledFuture<?> f2438a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f2439a = new ScheduledThreadPoolExecutor(1);

            public C0640a() {
            }

            /* access modifiers changed from: private */
            public void b() {
                gk remove = this.f2437a.remove(0);
                for (hf a11 : az.a(Arrays.asList(new gk[]{remove}), a.this.f2431a.getPackageName(), b.a(a.this.f2431a).a(), 30720)) {
                    b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    u.a(a.this.f2431a).a(a11, gg.Notification, true, (gt) null);
                }
            }

            public void a(final gk gkVar) {
                this.f2439a.execute(new Runnable() {
                    public void run() {
                        C0640a.this.f2437a.add(gkVar);
                        C0640a.a(C0640a.this);
                    }
                });
            }

            private void a() {
                if (this.f2438a == null) {
                    this.f2438a = this.f2439a.scheduleAtFixedRate(this.f2436a, 1000, 1000, TimeUnit.MILLISECONDS);
                }
            }
        }

        public void b(String str) {
            b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f2435a) {
                arrayList.addAll(this.f2435a);
                this.f2435a.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                a((gk) it2.next());
            }
        }

        public static a a() {
            if (f51284a == null) {
                synchronized (a.class) {
                    if (f51284a == null) {
                        f51284a = new a();
                    }
                }
            }
            return f51284a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2329a(Context context) {
            if (context == null) {
                b.a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f2431a = context;
            this.f2433a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        private boolean b(Context context) {
            return b.a(context).a() == null && !a(this.f2431a);
        }

        private boolean b(gk gkVar) {
            if (az.a(gkVar, false)) {
                return false;
            }
            if (this.f2433a.booleanValue()) {
                b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + gkVar.d());
                u.a(this.f2431a).a(gkVar);
                return true;
            }
            this.f2432a.a(gkVar);
            return true;
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                b.a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f2434a = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        private boolean a(Context context) {
            if (!u.a(context).a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo != null && packageInfo.versionCode >= 108) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m2330a() {
            return this.f2431a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m2331a(gk gkVar) {
            boolean z11 = false;
            if (gkVar == null) {
                return false;
            }
            if (az.a(gkVar, true)) {
                return false;
            }
            boolean z12 = TextUtils.isEmpty(gkVar.a()) && TextUtils.isEmpty(this.f2434a);
            boolean z13 = !a();
            Context context = this.f2431a;
            if (context == null || b(context)) {
                z11 = true;
            }
            if (!z13 && !z12) {
                if (!z11) {
                    b.c("MiTinyDataClient Send item immediately." + gkVar.d());
                    if (TextUtils.isEmpty(gkVar.d())) {
                        gkVar.f(aj.a());
                    }
                    if (TextUtils.isEmpty(gkVar.a())) {
                        gkVar.a(this.f2434a);
                    }
                    if (TextUtils.isEmpty(gkVar.c())) {
                        gkVar.e(this.f2431a.getPackageName());
                    }
                    if (gkVar.a() <= 0) {
                        gkVar.b(System.currentTimeMillis());
                    }
                    return b(gkVar);
                }
            }
            if (z12) {
                b.c("MiTinyDataClient Pending " + gkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL);
            } else if (z13) {
                b.c("MiTinyDataClient Pending " + gkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT);
            } else if (z11) {
                b.c("MiTinyDataClient Pending " + gkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID);
            }
            a(gkVar);
            return true;
        }

        private void a(gk gkVar) {
            synchronized (this.f2435a) {
                if (!this.f2435a.contains(gkVar)) {
                    this.f2435a.add(gkVar);
                    if (this.f2435a.size() > 100) {
                        this.f2435a.remove(0);
                    }
                }
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            b.a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().a(context);
        if (TextUtils.isEmpty(str)) {
            b.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(String str, String str2, long j11, String str3) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c(str2);
        gkVar.a(j11);
        gkVar.b(str3);
        return a.a().a(gkVar);
    }

    public static boolean upload(Context context, String str, String str2, long j11, String str3) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c(str2);
        gkVar.a(j11);
        gkVar.b(str3);
        gkVar.a(true);
        gkVar.a("push_sdk_channel");
        return upload(context, gkVar);
    }

    public static boolean upload(Context context, gk gkVar) {
        b.c("MiTinyDataClient.upload " + gkVar.d());
        if (!a.a().a()) {
            a.a().a(context);
        }
        return a.a().a(gkVar);
    }
}
