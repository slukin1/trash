package com.tencent.android.tpush.stat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.b.d;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.android.tpush.stat.event.MQTTEvent;
import com.tencent.android.tpush.stat.event.c;
import com.tencent.android.tpush.stat.event.e;
import com.tencent.android.tpush.stat.event.h;
import com.tencent.android.tpush.stat.lifecycle.MtaActivityLifeCycle;
import com.tencent.android.tpush.stat.lifecycle.a;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatServiceImpl {

    /* renamed from: a  reason: collision with root package name */
    public static volatile long f69870a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Long> f69871b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static volatile Handler f69872c = null;

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f69873d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile String f69874e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f69875f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static c f69876g = b.b();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f69877h = false;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f69878i = true;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static Handler f69879j = null;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static volatile Runnable f69880k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static long f69881l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static List<c> f69882m = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static long f69883n = 800;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static volatile long f69884o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static Context f69885p = null;

    /* renamed from: q  reason: collision with root package name */
    private static String f69886q = null;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static volatile SharedPreferences f69887r = null;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static volatile SharedPreferences f69888s = null;
    public static volatile boolean storedList = true;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static volatile SharedPreferences f69889t = null;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static AtomicInteger f69890u = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static final Integer f69891v = 3;

    /* renamed from: w  reason: collision with root package name */
    private static AtomicBoolean f69892w = new AtomicBoolean(false);

    public static void checkAppLunch(Context context) {
        Application application;
        try {
            if (context instanceof Application) {
                application = (Application) context;
            } else if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else {
                application = (Application) context;
            }
            boolean isMainProcess = Util.isMainProcess(application);
            if (application != null && isMainProcess && !f69892w.get()) {
                MtaActivityLifeCycle.registerActivityLifecycleCallbacks(application, new a() {
                    public void a(Activity activity) {
                    }

                    public void a(Activity activity, Bundle bundle) {
                    }

                    public void b(Activity activity, Bundle bundle) {
                        com.tencent.android.tpush.stat.a.a.b(activity, "onActivityCreated");
                    }

                    public void c(Activity activity) {
                    }

                    public void d(Activity activity) {
                        com.tencent.android.tpush.stat.a.a.a(activity, "onActivityPaused");
                    }

                    public void e(Activity activity) {
                        com.tencent.android.tpush.stat.a.a.a(activity, "onActivityDestroyed");
                    }

                    public void b(Activity activity) {
                        com.tencent.android.tpush.stat.a.a.b(activity, "onActivityStarted");
                    }
                });
                f69892w.set(true);
            }
        } catch (Throwable unused) {
            TLogger.d("stat", "unexpected for checkAppLunch");
        }
    }

    public static boolean commitEvents(Context context, int i11) {
        if (!d.c()) {
            return false;
        }
        if (d.b()) {
            c cVar = f69876g;
            cVar.b((Object) "commitEvents, maxNumber=" + i11);
        }
        Context context2 = getContext(context);
        if (context2 == null) {
            f69876g.e("The Context of StatService.commitEvents() can not be null!");
            return false;
        } else if (i11 < -1 || i11 == 0) {
            f69876g.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            return false;
        } else if (!b.a(context2).c() || getHandler(context2) == null) {
            return false;
        } else {
            f69872c.post(new Runnable() {
                public void run() {
                    try {
                        StatServiceImpl.b();
                    } catch (Throwable th2) {
                        StatServiceImpl.f69876g.b(th2);
                    }
                }
            });
            return true;
        }
    }

    public static Context getContext(Context context) {
        return context != null ? context : f69885p;
    }

    public static Handler getHandler(Context context) {
        if (f69872c == null) {
            synchronized (StatServiceImpl.class) {
                if (f69872c == null) {
                    try {
                        init(context);
                    } catch (Throwable th2) {
                        f69876g.a(th2);
                        d.b(false);
                    }
                }
            }
        }
        return f69872c;
    }

    public static void inerTrackBeginPage(final Context context, String str, final long j11) {
        if (str != null) {
            final String str2 = new String(str);
            if (getHandler(context) != null) {
                f69872c.post(new Runnable() {
                    public void run() {
                        try {
                            synchronized (StatServiceImpl.f69871b) {
                                if (StatServiceImpl.f69871b.size() >= d.f()) {
                                    c d11 = StatServiceImpl.f69876g;
                                    d11.e("The number of page events exceeds the maximum value " + Integer.toString(d.f()));
                                    return;
                                }
                                String unused = StatServiceImpl.f69874e = str2;
                                if (StatServiceImpl.f69871b.containsKey(StatServiceImpl.f69874e)) {
                                    c d12 = StatServiceImpl.f69876g;
                                    d12.f("Duplicate PageID : " + StatServiceImpl.f69874e + ", onResume() repeated?");
                                    return;
                                }
                                StatServiceImpl.f69871b.put(StatServiceImpl.f69874e, Long.valueOf(System.currentTimeMillis()));
                                StatServiceImpl.b(context, j11);
                            }
                        } catch (Throwable th2) {
                            StatServiceImpl.f69876g.b(th2);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r3) {
        /*
            java.lang.Class<com.tencent.android.tpush.stat.StatServiceImpl> r0 = com.tencent.android.tpush.stat.StatServiceImpl.class
            monitor-enter(r0)
            if (r3 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            checkAppLunch(r3)     // Catch:{ all -> 0x003d }
            android.os.Handler r1 = f69872c     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x003b
            boolean r1 = a((android.content.Context) r3)     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0016
            monitor-exit(r0)
            return
        L_0x0016:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x003d }
            f69885p = r3     // Catch:{ all -> 0x003d }
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "XgStat"
            r1.<init>(r2)     // Catch:{ all -> 0x003d }
            r1.start()     // Catch:{ all -> 0x003d }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x003d }
            android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x003d }
            r2.<init>(r1)     // Catch:{ all -> 0x003d }
            f69872c = r2     // Catch:{ all -> 0x003d }
            android.os.Handler r1 = f69872c     // Catch:{ all -> 0x003d }
            com.tencent.android.tpush.stat.StatServiceImpl$1 r2 = new com.tencent.android.tpush.stat.StatServiceImpl$1     // Catch:{ all -> 0x003d }
            r2.<init>(r3)     // Catch:{ all -> 0x003d }
            r1.post(r2)     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r0)
            return
        L_0x003d:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.StatServiceImpl.init(android.content.Context):void");
    }

    public static void initAutoStats(Context context, long j11) {
        Application application = null;
        try {
            if (context instanceof Application) {
                application = (Application) context;
            } else if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else {
                application = (Application) context;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return;
        }
        if (application != null) {
            a(application, j11);
        }
    }

    public static void reportEvent(Context context, final Event event) {
        if (d.c()) {
            if (f69885p == null) {
                init(context);
            }
            if (getHandler(getContext(context)) != null) {
                f69872c.post(new Runnable() {
                    public void run() {
                        try {
                            StatServiceImpl.a(Event.this);
                        } catch (Throwable th2) {
                            StatServiceImpl.f69876g.b(th2);
                        }
                    }
                });
            }
        }
    }

    public static void reportXGEvent(Context context, final Event event) {
        if (!d.c()) {
            TLogger.w("stat", "disable stat service");
            return;
        }
        Context context2 = getContext(context);
        if (context2 == null) {
            f69876g.e("The Context of StatService.trackCustomEvent() can not be null!");
        } else if (getHandler(context2) != null) {
            f69872c.post(new Runnable() {
                public void run() {
                    try {
                        StatServiceImpl.a(Event.this);
                    } catch (Throwable th2) {
                        StatServiceImpl.f69876g.b(th2);
                    }
                }
            });
        }
    }

    public static void send3rdCaughtException(Context context, String str, Throwable th2) {
        a(context, 30, str, th2);
    }

    public static boolean sendLocalMsg(Context context, int i11) {
        if (!d.c()) {
            return false;
        }
        if (d.b()) {
            c cVar = f69876g;
            cVar.b((Object) "commitEvents, maxNumber=" + i11);
        }
        Context context2 = getContext(context);
        if (context2 == null) {
            f69876g.e("The Context of StatService.commitEvents() can not be null!");
            return false;
        } else if (i11 < -1 || i11 == 0) {
            f69876g.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            return false;
        } else if (!b.a(context2).c()) {
            return false;
        } else {
            c cVar2 = f69876g;
            cVar2.b((Object) "sendLocalMsg, maxNumber=" + i11);
            if (getHandler(context2) == null) {
                return false;
            }
            f69872c.post(new Runnable() {
                public void run() {
                    try {
                        StatServiceImpl.b();
                    } catch (Throwable th2) {
                        StatServiceImpl.f69876g.b(th2);
                    }
                }
            });
            return true;
        }
    }

    public static void sendTryCatchException(Context context, String str, Throwable th2) {
        a(context, 1, str, th2);
    }

    public static void setContext(Context context) {
        if (context != null) {
            f69885p = context.getApplicationContext();
        }
    }

    public static void setCrashMatchString(String str) {
        f69886q = str;
    }

    public static void setupExceptionHandler(Context context) {
        try {
            a.a(context).a();
        } catch (Throwable th2) {
            f69876g.b(th2);
        }
    }

    public static void trackBeginPage(Context context, String str, long j11) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f69876g.e("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            } else {
                inerTrackBeginPage(context2, str, j11);
            }
        }
    }

    public static void trackCustomKVEvent(Context context, final String str, Properties properties) {
        if (d.c()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f69876g.e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (a(str)) {
                f69876g.e("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                final c.a aVar = new c.a(str, (String[]) null, properties);
                if (getHandler(context2) != null) {
                    f69872c.post(new Runnable() {
                        public void run() {
                            try {
                                com.tencent.android.tpush.stat.event.c cVar = new com.tencent.android.tpush.stat.event.c(context2, 0, str, XGApiConfig.getAccessId(context2), System.currentTimeMillis());
                                cVar.a().f70017c = aVar.f70017c;
                                StatServiceImpl.a((Event) cVar);
                            } catch (Throwable th2) {
                                StatServiceImpl.f69876g.b(th2);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void trackEndPage(Context context, String str, long j11) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f69876g.e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            } else {
                b(context2, str, j11, 0, 0);
            }
        }
    }

    public static void trackLaunchEvent(Context context, int i11, int i12, long j11) {
        if (d.c()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f69876g.e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (getHandler(context2) != null) {
                final int i13 = i11;
                final int i14 = i12;
                final long j12 = j11;
                f69872c.post(new Runnable() {
                    public void run() {
                        try {
                            StatServiceImpl.a((Event) new e(context2, i13, i14, j12));
                        } catch (Throwable th2) {
                            StatServiceImpl.f69876g.b(th2);
                        }
                    }
                });
            }
        }
    }

    private static int e(List<?> list) {
        if (list != null && !list.isEmpty()) {
            try {
                Object obj = list.get(0);
                if (!(obj instanceof Event)) {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    String optString = jSONObject.optString("msgId", "");
                    if (optString != null && optString.length() > 0) {
                        com.tencent.android.tpush.stat.b.c cVar = f69876g;
                        cVar.d("a stat string event msgId: " + optString);
                        return 1;
                    } else if (jSONObject.has("customEvent")) {
                        f69876g.d(" string customEvent");
                        return 2;
                    } else {
                        f69876g.d("other string ");
                        return 0;
                    }
                } else if (obj instanceof MQTTEvent) {
                    f69876g.d("a stat instance MQTTEvent event");
                    return 1;
                } else if (obj instanceof com.tencent.android.tpush.stat.event.c) {
                    f69876g.d("a stat instance custom event");
                    return 2;
                } else {
                    f69876g.d("other instance ErrorEvent or other");
                    return 0;
                }
            } catch (Throwable th2) {
                com.tencent.android.tpush.stat.b.c cVar2 = f69876g;
                cVar2.d("distinguish event error" + th2.toString());
            }
        }
        return 0;
    }

    public static synchronized void d(List<?> list) {
        synchronized (StatServiceImpl.class) {
            if (list != null) {
                try {
                    if (!(f69887r == null || f69888s == null || f69889t == null)) {
                        com.tencent.android.tpush.stat.b.c cVar = f69876g;
                        cVar.h("update event size:" + list.size());
                        int e11 = e(list);
                        if (e11 == 1) {
                            a(f69887r, list);
                        } else if (e11 != 2) {
                            a(f69888s, list);
                        } else {
                            a(f69889t, list);
                        }
                    }
                } catch (Throwable th2) {
                    f69876g.b(th2);
                }
            }
        }
        return;
    }

    public static synchronized void c(List<?> list) {
        synchronized (StatServiceImpl.class) {
            if (list != null) {
                try {
                    if (!(f69887r == null || f69888s == null || f69889t == null)) {
                        com.tencent.android.tpush.stat.b.c cVar = f69876g;
                        cVar.h("delete event size:" + list.size());
                        int e11 = e(list);
                        if (e11 == 1) {
                            b(list, f69887r);
                        } else if (e11 != 2) {
                            b(list, f69888s);
                        } else {
                            b(list, f69889t);
                        }
                    }
                } catch (Throwable th2) {
                    f69876g.b(th2);
                }
            }
        }
        return;
    }

    public static boolean a(Context context) {
        boolean z11;
        long a11 = d.a(context, d.f69980c, 0);
        long b11 = b.b("2.0.6");
        if (b11 <= a11) {
            com.tencent.android.tpush.stat.b.c cVar = f69876g;
            cVar.e("MTA is disable for current version:" + b11 + ",wakeup version:" + a11);
            z11 = false;
        } else {
            z11 = true;
        }
        d.b(z11);
        return z11;
    }

    public static int b(Context context, long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        if (f69870a == 0) {
            f69870a = d.a(f69885p, "_INTER_MTA_NEXT_DAY", 0);
        }
        boolean z11 = false;
        if (f69873d == 0 || currentTimeMillis >= f69870a) {
            z11 = true;
        }
        if (z11) {
            f69873d = b.a();
            f69870a = b.c();
            d.b(f69885p, "_INTER_MTA_NEXT_DAY", f69870a);
            a(context, j11);
        }
        return f69873d;
    }

    public static void trackEndPage(Context context, String str, long j11, long j12, long j13) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f69876g.e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            } else {
                b(context2, str, j11, j12, j13);
            }
        }
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i11 = d.f69979b.f69994d;
            if (i11 != 0) {
                jSONObject2.put(f.f34662a, i11);
            }
            jSONObject.put(Integer.toString(d.f69979b.f69991a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            int i12 = d.f69978a.f69994d;
            if (i12 != 0) {
                jSONObject3.put(f.f34662a, i12);
            }
            jSONObject.put(Integer.toString(d.f69978a.f69991a), jSONObject3);
        } catch (JSONException e11) {
            f69876g.b((Throwable) e11);
        }
        return jSONObject;
    }

    public static void b(final Event event) {
        f.b(f69885p).a(event, (e) new e() {
            public void a() {
                StatServiceImpl.f69890u.set(0);
            }

            public void b() {
                if (StatServiceImpl.f69890u.getAndIncrement() < StatServiceImpl.f69891v.intValue()) {
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            StatServiceImpl.b(Event.this);
                        }
                    }, ((long) StatServiceImpl.f69890u.get()) * 1000);
                    return;
                }
                StatServiceImpl.f69890u.set(0);
                StatServiceImpl.b((List<?>) Arrays.asList(new Event[]{Event.this}));
            }
        });
    }

    private static void b(List<?> list, SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Object obj : list) {
                edit.remove(obj.toString());
            }
            edit.commit();
        } catch (Throwable th2) {
            f69876g.b(th2);
        }
    }

    public static void a(Context context, long j11) {
        a((Event) new h(context, f69873d, a(), j11));
    }

    public static synchronized void b(List<?> list) {
        synchronized (StatServiceImpl.class) {
            if (list != null) {
                try {
                    if (!(f69887r == null || f69888s == null || f69889t == null)) {
                        storedList = true;
                        com.tencent.android.tpush.stat.b.c cVar = f69876g;
                        cVar.h("store event size:" + list.size());
                        int e11 = e(list);
                        if (e11 == 1) {
                            a(list, f69887r);
                        } else if (e11 != 2) {
                            a(list, f69888s);
                        } else {
                            a(list, f69889t);
                        }
                    }
                } catch (Throwable th2) {
                    f69876g.b(th2);
                }
            }
        }
        return;
    }

    public static void a(final List<Event> list) {
        if (b.a(f69885p).c()) {
            f.b(f69885p).b(list, new e() {
                public void a() {
                }

                public void b() {
                    com.tencent.android.tpush.stat.b.c d11 = StatServiceImpl.f69876g;
                    d11.f("onDispatchFailure sentEventList size:" + list.size());
                    StatServiceImpl.b((List<?>) list);
                }
            });
        } else {
            b((List<?>) list);
        }
    }

    public static void a(Event event) {
        if (b.a(f69885p).c()) {
            if (storedList) {
                storedList = !sendLocalMsg(f69885p, 100);
            }
            b(event);
            return;
        }
        b((List<?>) Arrays.asList(new Event[]{event}));
    }

    private static void a(List<?> list, SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Object obj : list) {
                edit.putInt(obj.toString(), 1);
            }
            edit.commit();
        } catch (Throwable th2) {
            f69876g.b(th2);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, long j11, long j12, long j13) {
        if (str != null) {
            final String str2 = new String(str);
            if (getHandler(context) != null) {
                final Context context2 = context;
                final long j14 = j11;
                final long j15 = j12;
                final long j16 = j13;
                f69872c.post(new Runnable() {
                    public void run() {
                        Long l11;
                        try {
                            synchronized (StatServiceImpl.f69871b) {
                                l11 = (Long) StatServiceImpl.f69871b.remove(str2);
                            }
                            if (l11 != null) {
                                Long valueOf = Long.valueOf((System.currentTimeMillis() - l11.longValue()) / 1000);
                                if (valueOf.longValue() <= 0) {
                                    valueOf = 1L;
                                }
                                String i11 = StatServiceImpl.f69875f;
                                if (i11 != null && i11.equals(str2)) {
                                    i11 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                                }
                                Context context = context2;
                                com.tencent.android.tpush.stat.event.f fVar = new com.tencent.android.tpush.stat.event.f(context, i11, str2, StatServiceImpl.b(context, j14), (double) valueOf.longValue(), j14);
                                long j11 = j15;
                                if (j11 > 0) {
                                    fVar.f70032a = j11;
                                }
                                long j12 = j16;
                                if (j12 > 0) {
                                    fVar.f70032a = j12;
                                }
                                if (!str2.equals(StatServiceImpl.f69874e)) {
                                    StatServiceImpl.f69876g.c("Invalid invocation since previous onResume on diff page.");
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(fVar);
                                StatServiceImpl.a((List<Event>) arrayList);
                                String unused = StatServiceImpl.f69875f = str2;
                                return;
                            }
                            com.tencent.android.tpush.stat.b.c d11 = StatServiceImpl.f69876g;
                            d11.f("Starttime for PageID:" + str2 + " not found, lost onResume()?");
                        } catch (Throwable th2) {
                            StatServiceImpl.f69876g.b(th2);
                        }
                    }
                });
            }
        }
    }

    public static synchronized void b() {
        synchronized (StatServiceImpl.class) {
            if (f69887r != null) {
                a(f69887r);
            }
            if (f69888s != null) {
                a(f69888s);
            }
            if (f69889t != null) {
                a(f69889t);
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences, List<?> list) {
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                for (Object obj : list) {
                    String obj2 = obj.toString();
                    int i11 = sharedPreferences.getInt(obj2, 1);
                    if (i11 <= 0 || i11 > d.e()) {
                        edit.remove(obj2);
                    } else {
                        edit.putInt(obj2, i11 + 1);
                    }
                }
                edit.commit();
            } catch (Throwable th2) {
                f69876g.b(th2);
            }
        }
    }

    public static void a(final List<String> list, List<String> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            f.b(f69885p).b(list2, new e() {
                public void a() {
                    StatServiceImpl.c((List<?>) list);
                }

                public void b() {
                    StatServiceImpl.d((List<?>) list);
                }
            });
        }
    }

    public static void a(Context context, long j11, boolean z11) {
        try {
            com.tencent.android.tpush.stat.b.c cVar = f69876g;
            cVar.h("trackBackground lastForegroundTs:" + f69884o);
            if (f69884o > 0) {
                double currentTimeMillis = ((double) ((System.currentTimeMillis() - f69884o) - f69883n)) / 1000.0d;
                if (currentTimeMillis <= 0.0d) {
                    currentTimeMillis = 0.1d;
                }
                a(f69885p, currentTimeMillis, j11, z11);
            }
        } catch (Throwable th2) {
            f69876g.b(th2);
        }
        f69884o = -1;
    }

    private static void a(Context context, double d11, long j11, boolean z11) {
        if (d.c()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f69876g.e("The Context of StatService.trackBackground() can not be null!");
            } else if (getHandler(context2) != null) {
                final double d12 = d11;
                final long j12 = j11;
                f69872c.post(new Runnable() {
                    public void run() {
                        try {
                            com.tencent.android.tpush.stat.b.c d11 = StatServiceImpl.f69876g;
                            d11.b((Object) "trackBackground duration:" + d12);
                            double d12 = d12;
                            if (d12 <= 0.0d) {
                                d12 = 0.1d;
                            }
                            com.tencent.android.tpush.stat.event.a aVar = new com.tencent.android.tpush.stat.event.a(StatServiceImpl.getContext(context2), StatServiceImpl.b(context2, j12), d12, j12);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(aVar);
                            StatServiceImpl.a((List<Event>) arrayList);
                        } catch (Throwable th2) {
                            StatServiceImpl.f69876g.b(th2);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.SharedPreferences r7) {
        /*
            java.util.Map r7 = r7.getAll()     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x0020
            com.tencent.android.tpush.stat.b.c r0 = f69876g     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r1.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = "sendLocalEvent "
            r1.append(r2)     // Catch:{ all -> 0x0086 }
            int r2 = r7.size()     // Catch:{ all -> 0x0086 }
            r1.append(r2)     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0086 }
            r0.a((java.lang.Object) r1)     // Catch:{ all -> 0x0086 }
        L_0x0020:
            if (r7 == 0) goto L_0x00a1
            int r0 = r7.size()     // Catch:{ all -> 0x0086 }
            if (r0 <= 0) goto L_0x00a1
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0086 }
            r1 = 10
            r0.<init>(r1)     // Catch:{ all -> 0x0086 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0086 }
            r2.<init>(r1)     // Catch:{ all -> 0x0086 }
            java.util.Set r7 = r7.entrySet()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0086 }
        L_0x003c:
            boolean r3 = r7.hasNext()     // Catch:{ all -> 0x0086 }
            if (r3 == 0) goto L_0x007f
            java.lang.Object r3 = r7.next()     // Catch:{ all -> 0x0086 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0086 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0064 }
            java.lang.Object r5 = r3.getKey()     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0064 }
            r4.<init>(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = "rtTms"
            java.lang.Object r6 = r3.getValue()     // Catch:{ all -> 0x0064 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0064 }
            r2.add(r4)     // Catch:{ all -> 0x0064 }
            goto L_0x006b
        L_0x0064:
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0086 }
            r2.add(r4)     // Catch:{ all -> 0x0086 }
        L_0x006b:
            java.lang.Object r3 = r3.getKey()     // Catch:{ all -> 0x0086 }
            r0.add(r3)     // Catch:{ all -> 0x0086 }
            int r3 = r0.size()     // Catch:{ all -> 0x0086 }
            if (r3 != r1) goto L_0x003c
            a((java.util.List<java.lang.String>) r0, (java.util.List<java.lang.String>) r2)     // Catch:{ all -> 0x0086 }
            r0.clear()     // Catch:{ all -> 0x0086 }
            goto L_0x003c
        L_0x007f:
            a((java.util.List<java.lang.String>) r0, (java.util.List<java.lang.String>) r2)     // Catch:{ all -> 0x0086 }
            r0.clear()     // Catch:{ all -> 0x0086 }
            goto L_0x00a1
        L_0x0086:
            r7 = move-exception
            com.tencent.android.tpush.stat.b.c r0 = f69876g
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "sendLocalEvent error: "
            r1.append(r2)
            java.lang.String r7 = r7.toString()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.f(r7)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.StatServiceImpl.a(android.content.SharedPreferences):void");
    }

    public static void a(Context context, Throwable th2) {
        a(context, 2, (String) null, th2);
    }

    private static void a(Context context, int i11, String str, Throwable th2) {
        a(context, i11, str, b.a(th2));
    }

    private static void a(Context context, int i11, String str, JSONArray jSONArray) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f69876g.e("The Context of StatService.sendCrashEvent() can not be null!");
                return;
            }
            try {
                com.tencent.android.tpush.stat.event.d dVar = new com.tencent.android.tpush.stat.event.d(context2, 0, i11, jSONArray, XGPushConfig.getAccessId(context));
                dVar.a(str);
                if (!dVar.a()) {
                    f69876g.c("not contains sdk info.");
                    f69876g.c(jSONArray);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                b((List<?>) arrayList);
            } catch (Throwable th2) {
                f69876g.b(th2);
            }
        }
    }

    private static void a(c cVar) {
        f69882m.add(cVar);
    }

    private static void a(Application application, final long j11) {
        if (application != null && Build.VERSION.SDK_INT >= 14) {
            Context b11 = com.tencent.android.tpush.stat.b.e.b(application);
            f69885p = b11;
            getHandler(b11);
            if (f69879j == null) {
                f69879j = new Handler();
            }
            synchronized (StatServiceImpl.class) {
                AnonymousClass6 r12 = new a() {
                    public void a(Activity activity) {
                    }

                    public void a(Activity activity, Bundle bundle) {
                    }

                    public void b(Activity activity) {
                    }

                    public void b(Activity activity, Bundle bundle) {
                    }

                    public void c(Activity activity) {
                        if (d.c()) {
                            StatServiceImpl.inerTrackBeginPage(activity, b.h(activity), j11);
                            boolean unused = StatServiceImpl.f69878i = false;
                            boolean z11 = !StatServiceImpl.f69877h;
                            boolean unused2 = StatServiceImpl.f69877h = true;
                            if (StatServiceImpl.f69880k != null) {
                                StatServiceImpl.f69879j.removeCallbacks(StatServiceImpl.f69880k);
                            }
                            if (z11) {
                                StatServiceImpl.f69876g.b((Object) "went foreground");
                                long unused3 = StatServiceImpl.f69881l = System.currentTimeMillis();
                                for (c a11 : StatServiceImpl.f69882m) {
                                    try {
                                        a11.a();
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                }
                                return;
                            }
                            StatServiceImpl.f69876g.b((Object) "still foreground");
                        }
                    }

                    public void d(Activity activity) {
                        if (d.c()) {
                            StatServiceImpl.b(activity, b.h(activity), j11, 0, 0);
                            boolean unused = StatServiceImpl.f69878i = true;
                            if (StatServiceImpl.f69880k != null) {
                                StatServiceImpl.f69879j.removeCallbacks(StatServiceImpl.f69880k);
                            }
                            StatServiceImpl.f69879j.postDelayed(StatServiceImpl.f69880k = new Runnable() {
                                public void run() {
                                    try {
                                        if (!StatServiceImpl.f69877h || !StatServiceImpl.f69878i) {
                                            StatServiceImpl.f69876g.b((Object) "still foreground");
                                            return;
                                        }
                                        StatServiceImpl.f69876g.b((Object) "went background");
                                        for (c b11 : StatServiceImpl.f69882m) {
                                            b11.b();
                                        }
                                        boolean unused = StatServiceImpl.f69877h = false;
                                    } catch (Throwable th2) {
                                        StatServiceImpl.f69876g.b(th2);
                                    }
                                }
                            }, StatServiceImpl.f69883n);
                        }
                    }

                    public void e(Activity activity) {
                    }
                };
                try {
                    a((c) new c() {
                        public void a() {
                            long unused = StatServiceImpl.f69884o = System.currentTimeMillis();
                        }

                        public void b() {
                            StatServiceImpl.a(StatServiceImpl.f69885p, j11, com.tencent.android.tpush.common.d.a());
                        }
                    });
                    MtaActivityLifeCycle.registerActivityLifecycleCallbacks(application, r12);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }
}
