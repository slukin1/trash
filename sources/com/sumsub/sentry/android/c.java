package com.sumsub.sentry.android;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sentry.Device;
import com.sumsub.sentry.android.ConnectivityChecker;
import com.sumsub.sentry.e;
import com.sumsub.sentry.h;
import com.sumsub.sentry.k0;
import com.sumsub.sentry.m0;
import com.sumsub.sentry.q;
import com.sumsub.sentry.q0;
import com.sumsub.sentry.u;
import com.sumsub.sentry.z;
import com.sumsub.sns.internal.core.analytics.d;
import com.sumsub.sns.internal.core.common.n0;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;

public final class c implements h {

    /* renamed from: h  reason: collision with root package name */
    public static final a f30261h = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public static final String f30262i = "rooted";

    /* renamed from: j  reason: collision with root package name */
    public static final String f30263j = "kernelVersion";

    /* renamed from: k  reason: collision with root package name */
    public static final String f30264k = "emulator";

    /* renamed from: l  reason: collision with root package name */
    public static final String f30265l = "sideLoaded";

    /* renamed from: a  reason: collision with root package name */
    public final Context f30266a;

    /* renamed from: b  reason: collision with root package name */
    public final a f30267b;

    /* renamed from: c  reason: collision with root package name */
    public final h f30268c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30269d;

    /* renamed from: e  reason: collision with root package name */
    public final Future<Map<String, Object>> f30270e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30271f;

    /* renamed from: g  reason: collision with root package name */
    public final String f30272g;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30273a;

        static {
            int[] iArr = new int[ConnectivityChecker.Status.values().length];
            iArr[ConnectivityChecker.Status.NOT_CONNECTED.ordinal()] = 1;
            iArr[ConnectivityChecker.Status.CONNECTED.ordinal()] = 2;
            f30273a = iArr;
        }
    }

    public c(Context context) {
        this(context, (a) null, (h) null, (String) null, 14, (r) null);
    }

    public static final Map a(c cVar) {
        return cVar.u();
    }

    public final void b(u uVar) {
        q0 z11 = uVar.z();
        if (z11 == null) {
            uVar.a(f());
        } else if (z11.c() == null) {
            String str = this.f30269d;
            if (str == null) {
                str = h();
            }
            z11.a(str);
        }
    }

    public final void c(u uVar) {
        com.sumsub.sentry.a a11 = uVar.d().a();
        if (a11 == null) {
            a11 = new com.sumsub.sentry.a((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Map) null, 127, (r) null);
        }
        a(a11);
        a(uVar, a11);
        uVar.d().a(a11);
    }

    public final Context d() {
        return this.f30266a;
    }

    public final Future<Map<String, Object>> e() {
        return this.f30270e;
    }

    public final Long f(StatFs statFs) {
        try {
            return Long.valueOf(a(statFs) * c(statFs));
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting unused external storage amount.", th2);
            return null;
        }
    }

    public final Device g() {
        Device device = r2;
        Device device2 = new Device(i(), Build.MANUFACTURER, Build.BRAND, l(), Build.MODEL, Build.ID, (String[]) null, (Float) null, (Boolean) null, (Boolean) null, q(), (Boolean) null, (Long) null, (Long) null, (Long) null, (Boolean) null, (Long) null, (Long) null, (Long) null, (Long) null, (Integer) null, (Integer) null, (Float) null, (Integer) null, (Date) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Float) null, 2147482560, (r) null);
        Device device3 = device;
        a(device3);
        b(device3);
        try {
            Object obj = this.f30270e.get().get(f30264k);
            if (obj != null) {
                device3.d((Boolean) obj);
            }
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting emulator.", th2);
        }
        DisplayMetrics j11 = j();
        if (j11 != null) {
            device3.c(Integer.valueOf(j11.widthPixels));
            device3.b(Integer.valueOf(j11.heightPixels));
            device3.c(Float.valueOf(j11.density));
            device3.a(Integer.valueOf(j11.densityDpi));
        }
        device3.a(c());
        device3.e(s().getID());
        if (device3.w() == null) {
            device3.b(h());
        }
        Locale locale = Locale.getDefault();
        if (device3.y() == null) {
            device3.c(locale.getLanguage());
        }
        if (device3.A() == null) {
            device3.d(locale.toString());
        }
        return device3;
    }

    public final String h() {
        try {
            return e.f30275a.a(this.f30266a);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String i() {
        String string = Settings.Global.getString(this.f30266a.getContentResolver(), "device_name");
        return string == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : string;
    }

    public final DisplayMetrics j() {
        try {
            return this.f30266a.getResources().getDisplayMetrics();
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting DisplayMetrics.", th2);
            return null;
        }
    }

    public final File[] k() {
        return this.f30266a.getExternalFilesDirs((String) null);
    }

    public final String l() {
        try {
            return ((String[]) new Regex(" ").split(Build.MODEL, 0).toArray(new String[0]))[0];
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting device family.", th2);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.b.a(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m() {
        /*
            r5 = this;
            java.lang.String r0 = "os.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/proc/version"
            r1.<init>(r2)
            boolean r2 = r1.canRead()
            if (r2 != 0) goto L_0x0014
            return r0
        L_0x0014:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x002e }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x002e }
            r3.<init>(r1)     // Catch:{ IOException -> 0x002e }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002e }
            r1 = 0
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0027 }
            kotlin.io.b.a(r2, r1)     // Catch:{ IOException -> 0x002e }
            return r3
        L_0x0027:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r3 = move-exception
            kotlin.io.b.a(r2, r1)     // Catch:{ IOException -> 0x002e }
            throw r3     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            r1 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r5)
            java.lang.String r4 = "Exception while attempting to read kernel information"
            r2.e(r3, r4, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.android.c.m():java.lang.String");
    }

    public final ActivityManager.MemoryInfo n() {
        try {
            Object systemService = this.f30266a.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Error getting MemoryInfo.", (Throwable) null, 4, (Object) null);
            return null;
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting MemoryInfo.", th2);
        }
    }

    public final long o() {
        return Runtime.getRuntime().totalMemory();
    }

    public final q p() {
        q qVar = new q((String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 63, (r) null);
        qVar.c(n0.f32119g);
        qVar.e(Build.VERSION.RELEASE);
        qVar.a(Build.DISPLAY);
        try {
            Object obj = this.f30270e.get().get(f30263j);
            Boolean bool = null;
            if (obj != null) {
                qVar.b(obj instanceof String ? (String) obj : null);
            }
            Object obj2 = this.f30270e.get().get(f30262i);
            if (obj2 != null) {
                if (obj2 instanceof Boolean) {
                    bool = (Boolean) obj2;
                }
                qVar.a(bool);
            }
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting OperatingSystem.", th2);
        }
        return qVar;
    }

    public final Device.DeviceOrientation q() {
        Device.DeviceOrientation deviceOrientation;
        Throwable th2;
        try {
            deviceOrientation = d.f30274a.a(this.f30266a.getResources().getConfiguration().orientation);
            if (deviceOrientation == null) {
                try {
                    com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", (Throwable) null, 4, (Object) null);
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting device orientation.", th2);
                    return deviceOrientation;
                }
            }
        } catch (Throwable th4) {
            Throwable th5 = th4;
            deviceOrientation = null;
            th2 = th5;
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting device orientation.", th2);
            return deviceOrientation;
        }
        return deviceOrientation;
    }

    public final Map<String, String> r() {
        try {
            PackageInfo a11 = b.f30260a.a(this.f30266a);
            PackageManager packageManager = this.f30266a.getPackageManager();
            if (a11 == null || packageManager == null) {
                return null;
            }
            String installerPackageName = packageManager.getInstallerPackageName(a11.packageName);
            HashMap hashMap = new HashMap();
            if (installerPackageName != null) {
                hashMap.put("isSideLoaded", d.f31895b);
                hashMap.put("installerStore", installerPackageName);
            } else {
                hashMap.put("isSideLoaded", "true");
            }
            return hashMap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final TimeZone s() {
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = this.f30266a.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    public final boolean t() {
        String externalStorageState = Environment.getExternalStorageState();
        return (x.b("mounted", externalStorageState) || x.b("mounted_ro", externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    public final Map<String, Object> u() {
        HashMap hashMap = new HashMap();
        hashMap.put(f30262i, Boolean.valueOf(this.f30268c.e()));
        String m11 = m();
        if (m11 != null) {
            hashMap.put(f30263j, m11);
        }
        hashMap.put(f30264k, Boolean.valueOf(this.f30267b.f()));
        Map<String, String> r11 = r();
        if (r11 != null) {
            hashMap.put(f30265l, r11);
        }
        return hashMap;
    }

    public c(Context context, a aVar) {
        this(context, aVar, (h) null, (String) null, 12, (r) null);
    }

    public z a(z zVar) {
        c((u) zVar);
        b(zVar);
        d((u) zVar);
        return zVar;
    }

    public final void d(u uVar) {
        b(uVar);
        e(uVar);
        a(uVar);
        f(uVar);
    }

    public final void e(u uVar) {
        if (uVar.d().c() == null) {
            uVar.d().a(g());
        }
    }

    public c(Context context, a aVar, h hVar) {
        this(context, aVar, hVar, (String) null, 8, (r) null);
    }

    public c(Context context, a aVar, h hVar, String str) {
        this.f30266a = context;
        this.f30267b = aVar;
        this.f30268c = hVar;
        this.f30269d = str;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f30270e = newSingleThreadExecutor.submit(new i(this));
        newSingleThreadExecutor.shutdown();
        this.f30271f = Build.CPU_ABI;
        this.f30272g = Build.CPU_ABI2;
    }

    public final Long e(StatFs statFs) {
        try {
            return Long.valueOf(b(statFs) * c(statFs));
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting total internal storage amount.", th2);
            return null;
        }
    }

    public final void a(u uVar) {
        String str;
        q g11 = uVar.d().g();
        uVar.d().a(p());
        if (g11 != null) {
            String e11 = g11.e();
            if (e11 != null) {
                if (!(e11.length() == 0)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("os_");
                    int length = e11.length() - 1;
                    int i11 = 0;
                    boolean z11 = false;
                    while (i11 <= length) {
                        boolean z12 = x.c(e11.charAt(!z11 ? i11 : length), 32) <= 0;
                        if (!z11) {
                            if (!z12) {
                                z11 = true;
                            } else {
                                i11++;
                            }
                        } else if (!z12) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    sb2.append(e11.subSequence(i11, length + 1).toString().toLowerCase(Locale.ROOT));
                    str = sb2.toString();
                    uVar.d().put(str, g11);
                }
            }
            str = "os_1";
            uVar.d().put(str, g11);
        }
    }

    public final void b(z zVar) {
        m0<k0> Q = zVar.Q();
        if (Q != null) {
            for (k0 next : Q.a()) {
                if (next.c() == null) {
                    next.a(Boolean.valueOf(f.f30279a.a(next)));
                }
            }
        }
    }

    public final q0 f() {
        String str = this.f30269d;
        if (str == null) {
            str = h();
        }
        return new q0(str, (String) null, (String) null, (String) null, 14, (r) null);
    }

    public final Date c() {
        try {
            return e.f30319a.a(Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        } catch (IllegalArgumentException e11) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting the device's boot time.", e11);
            return null;
        }
    }

    public final Long d(StatFs statFs) {
        try {
            return Long.valueOf(b(statFs) * c(statFs));
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting total external storage amount.", th2);
            return null;
        }
    }

    public final void f(u uVar) {
        try {
            Object obj = this.f30270e.get().get(f30265l);
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    Map<String, String> u11 = uVar.u();
                    if (u11 != null) {
                        u11.put(str, str2);
                    }
                }
            }
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting side loaded info.", th2);
        }
    }

    public final Boolean c(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z11 = true;
            if (intExtra != 1) {
                if (intExtra != 2) {
                    z11 = false;
                }
            }
            return Boolean.valueOf(z11);
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting device charging state.", th2);
            return null;
        }
    }

    public final void b(Device device) {
        Boolean bool;
        Intent b11 = b();
        if (b11 != null) {
            device.a(a(b11));
            device.a(c(b11));
            device.b(b(b11));
        }
        ConnectivityChecker connectivityChecker = ConnectivityChecker.f30259a;
        int i11 = b.f30273a[connectivityChecker.a(this.f30266a).ordinal()];
        if (i11 == 1) {
            bool = Boolean.FALSE;
        } else if (i11 != 2) {
            bool = null;
        } else {
            bool = Boolean.TRUE;
        }
        device.c(bool);
        ActivityManager.MemoryInfo n11 = n();
        if (n11 != null) {
            device.e(Long.valueOf(o()));
            device.c(Long.valueOf(n11.availMem));
            device.b(Boolean.valueOf(n11.lowMemory));
        }
        File externalFilesDir = this.f30266a.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            device.f(e(statFs));
            device.d(g(statFs));
        }
        StatFs b12 = b(externalFilesDir);
        if (b12 != null) {
            device.b(d(b12));
            device.a(f(b12));
        }
        if (device.k() == null) {
            device.a(connectivityChecker.a(this.f30266a, this.f30267b));
        }
    }

    public final long c(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c(android.content.Context r9, com.sumsub.sentry.android.a r10, com.sumsub.sentry.android.h r11, java.lang.String r12, int r13, kotlin.jvm.internal.r r14) {
        /*
            r8 = this;
            r14 = r13 & 2
            if (r14 == 0) goto L_0x0009
            com.sumsub.sentry.android.a r10 = new com.sumsub.sentry.android.a
            r10.<init>()
        L_0x0009:
            r14 = r13 & 4
            if (r14 == 0) goto L_0x001b
            com.sumsub.sentry.android.h r11 = new com.sumsub.sentry.android.h
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 28
            r7 = 0
            r0 = r11
            r1 = r9
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
        L_0x001b:
            r13 = r13 & 8
            if (r13 == 0) goto L_0x0020
            r12 = 0
        L_0x0020:
            r8.<init>(r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.android.c.<init>(android.content.Context, com.sumsub.sentry.android.a, com.sumsub.sentry.android.h, java.lang.String, int, kotlin.jvm.internal.r):void");
    }

    public final void a(u uVar, com.sumsub.sentry.a aVar) {
        b bVar = b.f30260a;
        PackageInfo a11 = bVar.a(this.f30266a, 4096);
        if (a11 != null) {
            a(uVar, bVar.a(a11));
            a(aVar, a11);
        }
    }

    public final void a(u uVar, String str) {
        if (uVar.f() == null) {
            uVar.b(str);
        }
    }

    public final void a(com.sumsub.sentry.a aVar) {
        aVar.c(a());
    }

    public final void a(Device device) {
        device.a(new String[]{this.f30271f, this.f30272g});
    }

    public final Float a(Intent intent) {
        try {
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1) {
                if (intExtra2 != -1) {
                    return Float.valueOf((((float) intExtra) / ((float) intExtra2)) * 100.0f);
                }
            }
            return null;
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting device battery level.", th2);
            return null;
        }
    }

    public final Long g(StatFs statFs) {
        try {
            return Long.valueOf(a(statFs) * c(statFs));
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting unused internal storage amount.", th2);
            return null;
        }
    }

    public final Intent b() {
        return this.f30266a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public final long a(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    public final Float b(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(((float) intExtra) / ((float) 10));
            }
            return null;
        } catch (Throwable th2) {
            com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Error getting battery temperature.", th2);
            return null;
        }
    }

    public final File a(File file) {
        File[] k11 = k();
        if (k11 != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            Iterator a11 = kotlin.jvm.internal.h.a(k11);
            while (a11.hasNext()) {
                File file2 = (File) a11.next();
                if (file2 != null) {
                    if (absolutePath != null) {
                        if (!(absolutePath.length() == 0) && StringsKt__StringsKt.R(file2.getAbsolutePath(), absolutePath, false, 2, (Object) null)) {
                        }
                    }
                    return file2;
                }
            }
        } else {
            com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Not possible to read getExternalFilesDirs", (Throwable) null, 4, (Object) null);
        }
        return null;
    }

    public final long b(StatFs statFs) {
        return statFs.getBlockCountLong();
    }

    public final StatFs b(File file) {
        if (!t()) {
            File a11 = a(file);
            if (a11 != null) {
                return new StatFs(a11.getPath());
            }
            com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Not possible to read external files directory", (Throwable) null, 4, (Object) null);
            return null;
        }
        com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "External storage is not mounted or emulated.", (Throwable) null, 4, (Object) null);
        return null;
    }

    @SuppressLint({"NewApi"})
    public final void a(com.sumsub.sentry.a aVar, PackageInfo packageInfo) {
        aVar.b(packageInfo.packageName);
        aVar.d(packageInfo.versionName);
        aVar.a(b.f30260a.a(packageInfo));
        if (this.f30267b.d() >= 16) {
            HashMap hashMap = new HashMap();
            String[] strArr = packageInfo.requestedPermissions;
            int[] iArr = packageInfo.requestedPermissionsFlags;
            if (strArr != null) {
                if ((!(strArr.length == 0)) && iArr != null && iArr.length > 0) {
                    int length = strArr.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        String str = strArr[i11];
                        hashMap.put(str.substring(StringsKt__StringsKt.l0(str, '.', 0, false, 6, (Object) null) + 1), (iArr[i11] & 2) == 2 ? "granted" : "not_granted");
                    }
                }
            }
            aVar.a((Map<String, String>) hashMap);
        }
    }

    public final String a() {
        try {
            ApplicationInfo applicationInfo = this.f30266a.getApplicationInfo();
            int i11 = applicationInfo.labelRes;
            if (i11 != 0) {
                return this.f30266a.getString(i11);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            if (charSequence != null) {
                return charSequence.toString();
            }
            return this.f30266a.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
