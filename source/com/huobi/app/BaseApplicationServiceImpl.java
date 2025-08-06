package com.huobi.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import bh.j;
import com.bbc876219.lib.spi.annotation.ServiceImpl;
import java.lang.ref.WeakReference;

@ServiceImpl
public class BaseApplicationServiceImpl implements f3.a {

    /* renamed from: c  reason: collision with root package name */
    public static String f42124c = "";

    /* renamed from: d  reason: collision with root package name */
    public static WeakReference<Activity> f42125d = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f42126e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f42127f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static String f42128g = "";

    /* renamed from: h  reason: collision with root package name */
    public static boolean f42129h = true;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42130a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42131b = true;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            BaseApplicationServiceImpl.this.g(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            BaseApplicationServiceImpl.f42126e++;
        }

        public void onActivityStopped(Activity activity) {
            BaseApplicationServiceImpl.f42126e--;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[Catch:{ Exception -> 0x008e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d() {
        /*
            java.lang.String r0 = f42124c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0091
            int r0 = android.os.Process.myPid()     // Catch:{ Exception -> 0x008e }
            android.app.Application r1 = bh.j.c()     // Catch:{ Exception -> 0x008e }
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x008e }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ Exception -> 0x008e }
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ Exception -> 0x008e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x008e }
        L_0x0020:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x008e }
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch:{ Exception -> 0x008e }
            int r3 = r2.pid     // Catch:{ Exception -> 0x008e }
            if (r3 != r0) goto L_0x0020
            java.lang.String r0 = r2.processName     // Catch:{ Exception -> 0x008e }
            f42124c = r0     // Catch:{ Exception -> 0x008e }
        L_0x0034:
            java.lang.String r0 = f42124c     // Catch:{ Exception -> 0x008e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x008e }
            if (r0 == 0) goto L_0x0091
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0084 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0084 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r4.<init>()     // Catch:{ all -> 0x0084 }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ all -> 0x0084 }
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0084 }
            r4.append(r5)     // Catch:{ all -> 0x0084 }
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0084 }
            r3.<init>(r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0084 }
            r1.<init>(r2)     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r0.<init>()     // Catch:{ all -> 0x0082 }
        L_0x006d:
            int r2 = r1.read()     // Catch:{ all -> 0x0082 }
            if (r2 <= 0) goto L_0x0078
            char r2 = (char) r2     // Catch:{ all -> 0x0082 }
            r0.append(r2)     // Catch:{ all -> 0x0082 }
            goto L_0x006d
        L_0x0078:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0082 }
            f42124c = r0     // Catch:{ all -> 0x0082 }
            r1.close()     // Catch:{ Exception -> 0x008e }
            goto L_0x0091
        L_0x0082:
            r0 = move-exception
            goto L_0x0088
        L_0x0084:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0088:
            if (r1 == 0) goto L_0x008d
            r1.close()     // Catch:{ Exception -> 0x008e }
        L_0x008d:
            throw r0     // Catch:{ Exception -> 0x008e }
        L_0x008e:
            java.lang.String r0 = ""
            return r0
        L_0x0091:
            java.lang.String r0 = f42124c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.BaseApplicationServiceImpl.d():java.lang.String");
    }

    public Application a() {
        if (!this.f42130a) {
            f();
            this.f42130a = true;
        }
        return j.c();
    }

    public boolean b() {
        return !f42129h;
    }

    public boolean c() {
        return this.f42131b;
    }

    public void e() {
        j.c().registerActivityLifecycleCallbacks(new a());
    }

    public final void f() {
        f42127f = 105400;
        f42128g = "10.54.0";
        f42129h = true;
        f42124c = d();
        this.f42131b = j.c().getPackageName().equals(f42124c);
        e();
    }

    public void g(Activity activity) {
        f42125d = new WeakReference<>(activity);
    }
}
